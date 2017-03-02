/**
 * Declare Angular Service
 */
bananaApp.factory("AuthService", function ($http, $window, $rootScope, Session) {
    var authService = {};

    authService.login = function (credentials) {
        return $http
            .post($rootScope.contextPath + '/banana/login', credentials)
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
                    Session.create(user.id, user.id, user.id, menus);
                }
                return res.data;
            });
    };

    authService.verifyLogin = function () {
        var url = "/banana/verifyLogin";
        if($rootScope.contextPath == undefined) {
            url = "/console" + url;
        } else {
            url = $rootScope.contextPath + url;
        }
        $http.post(url).success(function (data) {
            var result = data.result;
            var status = result["status"];
            $rootScope.isAuthorized = (status == 1);
        }).error(function(res) {
            $rootScope.isAuthorized = false;
        });
    }

    authService.isAuthenticated = function () {
        return !!Session.userId;
    };

    authService.isAuthorized = function (authorizedRoles) {
        if (!authorizedRoles && !angular.isArray(authorizedRoles)) {
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
});
