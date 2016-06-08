(function() {
    'use strict';
    angular
    .module('naut')
    .constant('tickitConfig', {
    	env: 'dev',
    	usuarioLogado: '/os/usuario-logado',
    	listaTipoOs: '/os/lista-tipo-os',
    	listaClientes: '/os/lista-clientes',
    	listaTecnicos: '/os/lista-tecnicos',
    	listaCategoriaDemanda: '/os/lista-categorias-demandas',
    	manterOs: '/os/manter',
    	servers: {
    		dev: {
    			baseUrl: 'http://localhost:8080/tickit',
    			tokenApi: '/tk/api'
    		},
    		prod: {
    			baseUrl: 'http://localhost:8080/tickit',
    			tokenApi: '/tk/api'
    		}
    	}
    })
    .provider('tickitService', tickitServiceProvider)
    .factory('osService', osService);

    tickitServiceProvider.$inject = ['tickitConfig']
    function tickitServiceProvider(config) {
    	Object.defineProperties(this, {
    		env: {
    			get: function() { return config.env; },
        	set: function(value) { config.env = value; }
    		},
    		usuarioLogado: {
    			get: function() { return config.usuarioLogado; },
        	set: function(value) { config.usuarioLogado = value; }
    		},
    		listaTipoOs: {
    			get: function() { return config.listaTipoOs; },
        	set: function(value) { config.listaTipoOs = value; }
    		},
    		listaClientes: {
    			get: function() { return config.listaClientes; },
        	set: function(value) { config.listaClientes = value; }
    		},
    		listaTecnicos: {
					get: function() { return config.listaTecnicos; },
        	set: function(value) { config.listaTecnicos = value; }
    		},
    		listaCategoriaDemanda: {
    			get: function() { return config.listaCategoriaDemanda; },
        	set: function(value) { config.listaCategoriaDemanda = value; }
    		},
    		manterOs: {
    			get: function() { return config.manterOs; },
        	set: function(value) { config.manterOs = value; }
    		}
    	});

    	angular.forEach(Object.keys(config.servers), function(server) {
	      this[server] = function(params) {
	        return angular.extend(config.servers[server], params);
	      };
	    }, this);

	    this.$get = function(osService) {
	    	var tickitService = {};
	    	tickitService.usuarioLogado = function() {
	    		return osService.usuarioLogado();
	    	};

	    	tickitService.listaTipoOs = function() {
	    		return osService.listaTipoOs();
	    	};

	    	tickitService.listaClientes = function() {
	    		return osService.listaClientes();
	    	};

	    	tickitService.listaTecnicos = function() {
	    		return osService.listaTecnicos();
	    	};

	    	tickitService.listaCategoriaDemanda = function() {
	    		return osService.listaCategoriaDemanda();
	    	};

	    	tickitService.manterOs = function(os) {
	    		return osService.manterOs(os);
	    	};
	    	return tickitService;
	    }
	    this.$get.$inject = ['osService']
    };

    osService.$inject = ['$http', 'tickitConfig']
    function osService($http, config) {
    	var osS = {};
	  	var envOpts = config.servers[config.env];
	    var headers = {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    	};

    	osS.usuarioLogado = function() {
	  		return $http.post(envOpts.baseUrl + envOpts.tokenApi + config.usuarioLogado, null, headers)
				  			.then(function(response) {
				  				return response.data;
				  			}).catch(function(error) {
				  				return error;
				  			});
	    };

	    osS.listaTipoOs = function() {
	  		return $http.post(envOpts.baseUrl + envOpts.tokenApi + config.listaTipoOs, null, headers)
				  			.then(function(response) {
				  				return response.data;
				  			}).catch(function(error) {
				  				return error;
				  			});
	    };

	    osS.listaClientes = function() {
	  		return $http.post(envOpts.baseUrl + envOpts.tokenApi + config.listaClientes, null, headers)
				  			.then(function(response) {
				  				return response.data;
				  			}).catch(function(error) {
				  				return error;
				  			});
	    };

	    osS.listaTecnicos = function() {
	  		return $http.post(envOpts.baseUrl + envOpts.tokenApi + config.listaTecnicos, null, headers)
				  			.then(function(response) {
				  				return response.data;
				  			}).catch(function(error) {
				  				return error;
				  			});
	    };

	    osS.listaCategoriaDemanda = function() {
	  		return $http.post(envOpts.baseUrl + envOpts.tokenApi + config.listaCategoriaDemanda, null, headers)
				  			.then(function(response) {
				  				return response.data;
				  			}).catch(function(error) {
				  				return error;
				  			});
	    };

	    osS.manterOs = function(os) {
	  		return $http.post(envOpts.baseUrl + envOpts.tokenApi + config.manterOs, os, headers)
				  			.then(function(response) {
				  				return response.data;
				  			}).catch(function(error) {
				  				return error;
				  			});
	    };
	    return osS;
    }
})();