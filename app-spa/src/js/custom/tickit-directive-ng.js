(function() {
    'use strict';

    angular
        .module('naut')
        .directive('tickitOsLista', tickItOsLista)
        .directive('tickitFiltros', tickitFiltros);

        function tickitFiltros() {
           return {
                restrict: 'E',
                templateUrl: 'app/views/direc/tickit-filtros.html',
                controller: controller
            };

            controller.$inject = ['$scope', '$element', '$attrs', 'tickitFilterService', '$rootScope', 'tickitService']
            function controller($scope, $element, $attrs, tickitFilterService, $rootScope, tickitService) {
                $scope.filtros = [];

                $scope.data = {
                    numChamado: '',
                    cliente: null,
                    tipoOs: null,
                    listas: {
                        listaClientes: [],
                        listaTipoOs: []
                    }
                };

                //definicao das funcoes
                var removerFlt = function(filter) {
                    var indexOf = $scope.filtros.indexOf(filter);
                    if(filter == 'numChamado') {
                        tickitFilterService[filter] = '';
                    }else {
                        tickitFilterService[filter] = null;
                    }

                    $scope.data[filter] = null;

                    if(indexOf != -1) {
                        $scope.filtros.splice(indexOf, 1);
                    }
                };


                $scope.addFiltro = function(filter) {
                    $scope.filtros.push(filter);
                };

                $scope.removerFiltro = function(filter) {
                    removerFlt(filter);

                    $rootScope.$emit('tickit:filter');
                };

                $scope.limparFiltros = function() {
                    var filtros = angular.copy($scope.filtros);
                    angular.forEach(filtros, function(value, key) {
                        removerFlt(value);
                    });

                    $rootScope.$emit('tickit:filter');
                };

                //observers
                $scope.$watch('data.numChamado', function(newValue, oldValue) {
                    if(newValue != null && newValue.length >= 3) {
                        tickitFilterService.numChamado = newValue;

                        $rootScope.$emit('tickit:filter');
                    }
                });

                $scope.$watch('data.cliente', function(newValue, oldValue) {
                    tickitFilterService.cliente = newValue;

                    $rootScope.$emit('tickit:filter');
                });

                $scope.$watch('data.tipoOs', function(newValue, oldValue) {
                    tickitFilterService.tipoOs = newValue;

                    $rootScope.$emit('tickit:filter');
                });

                //carregamentos e inicializacoes

                tickitFilterService.reset();

                tickitService.listaClientes().then(function(tkResponse) {
                    if(tkResponse.status = 'success') {
                        $scope.data.listas.listaClientes = tkResponse.obj;
                    }
                });

                tickitService.listaTipoOs().then(function(tkResponse) {
                    if(tkResponse.status = 'success') {
                        $scope.data.listas.listaTipoOs = tkResponse.obj;   
                    }
                });
            };
        }

        function tickItOsLista() {
            return {
                restrict: 'E',
                templateUrl: 'app/views/direc/os-lista.html',
                scope: {
                    totalItems: '@'
                },
                controller: controller
            }

            controller.$inject = ['$scope', '$element', '$attrs', 'tickitService', '$state', 'tickitFilterService', '$rootScope'];
            function controller($scope, $element, $attrs, tickitService, $state, tickitFilterService, $rootScope) {
                
                $scope.maxSize = 3;
                $scope.totalItems = 0;
                $scope.currentPage = 1;
                $scope.data = {
                    listaOs: []
                };

                $rootScope.$on('tickit:filter', function(event) {
                    $scope.currentPage = 1;
                    tickitFilterService.pagina = $scope.currentPage;

                    tickitService.listaOs(tickitFilterService.filtros).then(function(tkResponse) {
                        $scope.data.listaOs = tkResponse.obj;
                    });
                });


                tickitService.countOs().then(function(tkResponse) {
                    if(tkResponse.status = 'success') {
                        $scope.totalItems = tkResponse.obj;

                        tickitService.listaOs(tickitFilterService.filtros).then(function(tkResponse) {
                            $scope.data.listaOs = tkResponse.obj;
                        });
                    }
                });

                $scope.pageChanged = function() {
                    tickitFilterService.pagina = $scope.currentPage;
                    tickitService.listaOs(tickitFilterService.filtros).then(function(tkResponse) {
                        $scope.data.listaOs = tkResponse.obj;
                    });
                };

                $scope.visualizarOS = function(_osId) {
                    $state.go('app.os-intervencao', {osId: _osId});
                }
            }
        }
})();