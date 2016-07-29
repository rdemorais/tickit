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
    	listaDemanda: '/os/lista-demandas',
    	listaOs: '/os/lista-os',
    	listaIntervencoes: '/os/lista-intervencoes',
    	countOs: '/os/count-os',
    	manterOs: '/os/manter',
    	manterIntervencao: '/os/manter-intervencao',
    	loadOs: '/os/load-os',
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
    		listaDemanda: {
    			get: function() { return config.listaDemanda; },
        	set: function(value) { config.listaDemanda = value; }
    		},
    		listaOs: {
					get: function() { return config.listaOs; },
        	set: function(value) { config.listaOs = value; }
    		},
    		listaIntervencoes: {
    			get: function() { return config.listaIntervencoes; },
        	set: function(value) { config.listaIntervencoes = value; }
    		},
    		manterIntervencao: {
    			get: function() { return config.manterIntervencao; },
        	set: function(value) { config.manterIntervencao = value; }
    		},
    		manterOs: {
    			get: function() { return config.manterOs; },
        	set: function(value) { config.manterOs = value; }
    		},
    		loadOs: {
    			get: function() { return config.loadOs; },
        	set: function(value) { config.loadOs = value; }
    		},
    		countOs: {
    			get: function() { return config.countOs; },
        	set: function(value) { config.countOs = value; }
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

	    	tickitService.listaDemanda = function(categoriaDemanda) {
	    		return osService.listaDemanda(categoriaDemanda);
	    	};

	    	tickitService.listaOs = function(filtro) {
	    		return osService.listaOs(filtro);
	    	};

	    	tickitService.listaIntervencoes = function(idOs) {
	    		return osService.listaIntervencoes(idOs);
	    	};

	    	tickitService.manterIntervencao = function(intervencao) {
	    		return osService.manterIntervencao(intervencao);
	    	};

	    	tickitService.manterOs = function(os) {
	    		return osService.manterOs(os);
	    	};

	    	tickitService.loadOs = function(os) {
	    		return osService.loadOs(os);
	    	};

	    	tickitService.countOs = function() {
	    		return osService.countOs();
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

    	var simpleCall = function(url) {
					return $http.post(envOpts.baseUrl + envOpts.tokenApi + url, null, headers)
				  			.then(function(response) {
				  				return response.data;
				  			}).catch(function(error) {
				  				return error;
				  			});
	    };

	    var parameterCall = function(url, param) {
	    	return $http.post(envOpts.baseUrl + envOpts.tokenApi + url, param, headers)
				  			.then(function(response) {
				  				return response.data;
				  			}).catch(function(error) {
				  				return error;
				  			});
	    };

    	osS.usuarioLogado = function() {
	  		return simpleCall(config.usuarioLogado);
	    };

	    osS.listaTipoOs = function() {
	  		return simpleCall(config.listaTipoOs);
	    };

	    osS.listaClientes = function() {
	  		return simpleCall(config.listaClientes);
	    };

	    osS.listaTecnicos = function() {
	  		return simpleCall(config.listaTecnicos);
	    };

	    osS.listaCategoriaDemanda = function() {
	  		return simpleCall(config.listaCategoriaDemanda);
	    };

	    osS.listaDemanda = function(categoriaDemanda) {
	  		return parameterCall(config.listaDemanda, categoriaDemanda);
	    };

	    osS.listaOs = function(filtro) {
	  		return parameterCall(config.listaOs, filtro);
	    };

	    osS.listaIntervencoes = function(idOs) {
	    	return parameterCall(config.listaIntervencoes, idOs);
	    };

	    osS.manterIntervencao = function(intervencao) {
	    	return parameterCall(config.manterIntervencao, intervencao);
	    };

	    osS.manterOs = function(os) {
	  		return parameterCall(config.manterOs, os);
	    };

	    osS.loadOs = function(osId) {
	  		return parameterCall(config.loadOs, osId);
	    };

	    osS.countOs = function() {
	  		return simpleCall(config.countOs);
	    };

	    return osS;
    }
})();