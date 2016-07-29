(function() {
	'use strict';
	angular
    .module('naut')
    .provider('tickitFilterService', tickitFilterServiceProvider);
	
	function tickitFilterServiceProvider() {
		this.$get = function() {
			var tickitFilterService = {};
			var tkFiltros = {};

			var initFiltros = function() {
				tkFiltros = {
					numChamado: '',
					cliente: null,
					tipoOs: null,
					pagina: 1
				};

				return tkFiltros;
			};

			Object.defineProperties(tickitFilterService, {
				numChamado: {
					get: function() { return tkFiltros.numChamado; },
	      	set: function(value) { tkFiltros.numChamado = value; }
				},
				cliente: {
					get: function() { return tkFiltros.cliente; },
	      	set: function(value) { tkFiltros.cliente = value; }
				},
				tipoOs: {
					get: function() { return tkFiltros.tipoOs; },
	      	set: function(value) { tkFiltros.tipoOs = value; }
				},
				pagina: {
					get: function() { return tkFiltros.pagina; },
	      	set: function(value) { tkFiltros.pagina = value; }
				},
				filtros: {
					get: function() { return tkFiltros; }
				}
			});
			
			initFiltros();

			tickitFilterService.reset = function() {
				initFiltros();				
			};

			return tickitFilterService;
		};
	}
})();