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

    		controller.$inject = ['$scope', '$element', '$attrs', 'tickitService'];
    		function controller($scope, $element, $attrs, tickitService) {
    			$scope.data = {
    				listaOs: []
    			};

    			tickitService.listaOs().then(function(tkResponse) {
    				$scope.data.listaOs = tkResponse.obj;
    			});
    		}
    	}
})();