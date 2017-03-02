/**
 * Declare Angular Controller
 */
bananaApp.controller('appCtrl', function ($scope, $rootScope, $location, AuthService) {
    AuthService.verifyLogin();

    $scope.setContextPath = function (path) {
        $rootScope.contextPath = path;
    }

    $scope.currentUser = null;
    $scope.menus = null;

    $scope.setCurrentUser = function (user) {
        $rootScope.currentUser = user;
    };
    $scope.setMeus = function (menus) {
        $rootScope.menus = menus;
    }

    $scope.setIsAuthorized = function (isAuthorized) {
        $rootScope.isAuthorized = isAuthorized;
    }
}).controller('loginCtrl', function ($scope, $rootScope, $location, md5, AUTH_EVENTS, AuthService) {
    $scope.credentials = {
        username: '',
        password: ''
    };
    $scope.login = function (credentials) {
        AuthService.login({
            username: credentials.username,
            password: credentials.password
        }).then(function (data) {
            $rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
            $scope.setMeus(data.menus);
            $scope.setCurrentUser(data.user);
            $scope.setIsAuthorized(true);
        }, function (error) {
            $rootScope.$broadcast(AUTH_EVENTS.loginFailed);
        });
    };
}).controller("mainCtrl", function ($scope, $rootScope) {
    angular.forEach($scope.menus, function (data, index, array) {
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

