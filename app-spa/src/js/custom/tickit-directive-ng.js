(function() {
    'use strict';

    angular
    	.module('naut')
    	.directive('tickitOsLista', tickItOsLista);

    	function tickItOsLista() {
    		return {
    			restrict: 'E',
    			templateUrl: 'app/views/direc/os-lista.html',
	        controller: controller
    		}

    		controller.$inject = ['$scope', '$element', '$attrs', 'tickitService', '$state'];
    		function controller($scope, $element, $attrs, tickitService, $state) {
    			$scope.data = {
    				listaOs: []
    			};

    			tickitService.listaOs().then(function(tkResponse) {
    				$scope.data.listaOs = tkResponse.obj;
    			});

                $scope.visualizarOS = function(_osId) {
                    $state.go('app.os-intervencao', {osId: _osId});
                }
    		}
    	}
})();