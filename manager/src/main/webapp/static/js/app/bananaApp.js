var bananaApp = angular.module('bananaApp', ['ngRoute', 'angular-md5']);

/**
 * Declare Angular Config
 */
bananaApp.config(function ($httpProvider) {
    $httpProvider.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
    $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
    // Override $http service's default transformRequest
    $httpProvider.defaults.transformRequest = [function (data) {
        /* *
         * The workhorse; converts an object to x-www-form-urlencoded serialization.
         * @param { Object } obj
         * @return {String}
         */
        var param = function (obj) {
            var query = '';
            var name, value, fullSubName, subName, subValue, innerObj, i;
            for (name in obj) {
                value = obj[name];
                if (value instanceof Array) {
                    for (i = 0; i < value.length; ++i) {
                        subValue = value[i];
                        fullSubName = name + '[]';
                        innerObj = {};
                        innerObj[fullSubName] = subValue;
                        query += param(innerObj) + '&';
                    }
                } else if (value instanceof Object) {
                    for (subName in value) {
                        subValue = value[subName];
                        fullSubName = subName;
                        innerObj = {};
                        innerObj[fullSubName] = subValue;
                        query += param(innerObj) + '&';
                    }
                } else if (value !== undefined && value !== null) {
                    query += encodeURIComponent(name) + '='
                        + encodeURIComponent(value) + '&';
                }
            }
            return query.length ? query.substr(0, query.length - 1) : query;
        };
        return angular.isObject(data) && String(data) !== '[object File]'
            ? param(data)
            : data;
    }];
}).config(['$routeProvider', function ($routeProvider, AuthService) {
    $routeProvider.when('/', {
        controller: 'appCtrl'
    }).when('/login', {
        controller: 'loginCtrl',
        templateUrl: 'pages/login.html'
    }).when('/main', {
        controller: 'mainCtrl',
        templateUrl: 'pages/main.html'
    });
}]).config(function ($httpProvider) {
    $httpProvider.interceptors.push([
        '$injector',
        function ($injector) {
            return $injector.get('AuthInterceptor');
        }
    ]);
}).run(function ($rootScope, $log, AUTH_EVENTS, AuthService) {
    $rootScope.$on('$routeChangeStart', function (event, next) {
        var authorizedRoles = next.data.authorizedRoles;
        if (!AuthService.isAuthorized(authorizedRoles)) {
            event.preventDefault();
            if (AuthService.isAuthenticated()) {
                // user is not allowed
                $rootScope.$broadcast(AUTH_EVENTS.notAuthorized);
            } else {
                // user is not logged in
                $rootScope.$broadcast(AUTH_EVENTS.notAuthenticated);
            }
        }
    });

}).constant('AUTH_EVENTS', {
    loginSuccess: 'auth-login-success',
    loginFailed: 'auth-login-failed',
    logoutSuccess: 'auth-logout-success',
    sessionTimeout: 'auth-session-timeout',
    notAuthenticated: 'auth-not-authenticated',
    notAuthorized: 'auth-not-authorized'
}).constant('USER_ROLES', {
    all: '*',
    admin: 'admin',
    editor: 'editor',
    guest: 'guest'
}).factory('AuthInterceptor', function ($rootScope, $q,
                                        AUTH_EVENTS) {
    return {
        responseError: function (response) {
            $rootScope.$broadcast({
                401: AUTH_EVENTS.notAuthenticated,
                403: AUTH_EVENTS.notAuthorized,
                419: AUTH_EVENTS.sessionTimeout,
                440: AUTH_EVENTS.sessionTimeout
            }[response.status], response);
            return $q.reject(response);
        }
    };
});

/**
 * Declare Angular Service
 */
bananaApp.factory("AuthService", function ($http, $window, $rootScope, Session) {
    var authService = {};

    authService.login = function (credentials) {
        return $http
            .post($rootScope.contextPath + '/banana/banana/login', credentials)
            .then(function (res) {
                var result = res.data.result;
                var status = result["status"];
                if (status == 0) {
                    toastr.options = {
                        closeButton: true,
                        progressBar: false,
                        positionClass: "toast-bottom-full-width",
                        showMethod: 'slideDown',
                        timeOut: 3000
                    };
                    toastr.error(result["errorMessage"], '管理后台');
                } else {
                    var user = res.data.user;
                    var menus = res.data.menus;
                    /*Session.create(res.data.id, res.data.user.id,
                     res.data.user.role);*/
                }
                return res.data;
            });
    };

    authService.isAuthenticated = function () {
        return !!Session.userId;
    };

    authService.isAuthorized = function (authorizedRoles) {
        if (!angular.isArray(authorizedRoles)) {
            authorizedRoles = [authorizedRoles];
        }
        return (authService.isAuthenticated() &&
        authorizedRoles.indexOf(Session.userRole) !== -1);
    };
    return authService;
}).service('Session', function () {
    this.create = function (sessionId, userId, userRole, menus) {
        this.id = sessionId;
        this.userId = userId;
        this.userRole = userRole;
        this.menus = menus;
    };
    this.destroy = function () {
        this.id = null;
        this.userId = null;
        this.userRole = null;
        this.menus = null;
    };
    return this;
})

/**
 * Declare Angular Controller
 */
bananaApp.controller('appCtrl', function ($scope, $rootScope, $location, USER_ROLES, AuthService) {
    $scope.currentUser = null;
    $scope.menus = null;
    $scope.userRoles = USER_ROLES;
    $scope.isAuthorized = AuthService.isAuthorized;

    $scope.setCurrentUser = function (user) {
        $scope.currentUser = user;
    };
    $scope.setMeus = function (menus) {
        $scope.menus = menus;
    }
    $scope.setContextPath = function (path) {
        $rootScope.contextPath = path;
    }
    if ($scope.isAuthorized()) {
        $location.path("/main");
    } else {
        $location.path("/login");
    }
}).controller('loginCtrl', function ($scope, $rootScope, $location, md5, AUTH_EVENTS, AuthService) {
    $scope.credentials = {
        username: '',
        password: ''
    };
    $scope.login = function (credentials) {
        AuthService.login({
            username: credentials.username,
            password: md5.createHash(credentials.password)
        }).then(function (data) {
            $rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
            $scope.setMeus(data.menus);
            $scope.setCurrentUser(data);
            $location.path("/main");
        }, function (error) {
            $rootScope.$broadcast(AUTH_EVENTS.loginFailed);
        });
    };
    javascript:void(0);
}).controller("mainCtrl", function ($scope) {
    angular.forEach($scope.$parent.menus, function (data, index, array) {
        var li = $("<li></li>");
        var arrow = "<span class=\"fa arrow\"></span>";
        var childrenElement = $("<ul class='nav nav-second-level collapse'></ul>");
        if (!angular.isArray(data.children)) {
            arrow = "";
        } else {
            angular.forEach(data.children, function (data, index, array) {
                childrenElement.append("<li><a href='" + data.url + "'>" + data.name + "</a></li>");
            })
        }
        li.append("<a href='" + data.url + "'><i class=\"fa " + data.icon + "\"></i> <span class=\"nav-label\">" + data.name + "</span>" + arrow + "</a>")
        if (angular.isArray(data.children)) {
            li.append(childrenElement);
        }
        $('#side-menu').append(li);
    });
    $('#side-menu').metisMenu();

    $('.navbar-minimalize').on('click', function () {
        $("body").toggleClass("mini-navbar");
        SmoothlyMenu();

    });
});

/**
 * Declare Angular Directive
 */
bananaApp.directive('loginDialog', function (AUTH_EVENTS) {
    return {
        restrict: 'A',
        template: '<div ng-if="visible" ng-include="\'login-form.html\'">',
        link: function (scope) {
            var showDialog = function () {
                scope.visible = true;
            };

            scope.visible = false;
            scope.$on(AUTH_EVENTS.notAuthenticated, showDialog);
            scope.$on(AUTH_EVENTS.sessionTimeout, showDialog)
        }
    };
});
