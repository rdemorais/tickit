(function() {
    'use strict';

    angular
        .module('naut')
        .directive('tickitOsLista', tickItOsLista);

        function tickItOsLista() {
            return {
                restrict: 'E',
                templateUrl: 'app/views/direc/os-lista.html',
                scope: {
                    totalItems: '@'
                },
                controller: controller
            }

            controller.$inject = ['$scope', '$element', '$attrs', 'tickitService', '$state'];
            function controller($scope, $element, $attrs, tickitService, $state) {
                
                $scope.maxSize = 3;
                $scope.totalItems = 0;
                $scope.currentPage = 1;
                $scope.data = {
                    listaOs: []
                };

                tickitService.countOs().then(function(tkResponse) {
                    if(tkResponse.status = 'success') {
                        $scope.totalItems = tkResponse.obj;

                        tickitService.listaOs($scope.currentPage).then(function(tkResponse) {
                            $scope.data.listaOs = tkResponse.obj;
                        });
                    }
                });

                $scope.pageChanged = function() {
                    console.log($scope.currentPage);
                    tickitService.listaOs($scope.currentPage).then(function(tkResponse) {
                        $scope.data.listaOs = tkResponse.obj;
                    });
                };

                $scope.visualizarOS = function(_osId) {
                    $state.go('app.os-intervencao', {osId: _osId});
                }
            }
        }
})();