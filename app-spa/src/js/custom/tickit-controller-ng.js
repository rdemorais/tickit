(function() {
    'use strict';
    angular
        .module('naut')
        .controller('TickitLoginController', tickitLoginController)
        .controller('TickitDashboardController', tickitDashboardController)
        .controller('TickitOSController', tickitOSController)
        .filter('propsFilter', propsFilter);

    tickitLoginController.$inject = ['$scope', '$state', 'OAuth']
    function tickitLoginController($scope, $state, OAuth) {
    	$scope.loginTickit = function() {
    		OAuth.getAccessToken({
            //username: $scope.login,
            //password: $scope.senha
            username: 'adm@tickit.com',
            password: 'serenaya'
        }).then(function() {
            if(OAuth.isAuthenticated()) {
                $state.go('app.os-main');
            }
        });
    	};
    };

    tickitDashboardController.$inject = ['$scope', '$state'];
    function tickitDashboardController($scope, $state) {
    	$scope.test = 'Ok, funcionou';
    };

    tickitOSController.$inject = ['$scope', '$state', 'tickitService', 'SweetAlert'];
    function tickitOSController($scope, $state, tickitService, SweetAlert) {
    	$scope.opened = false;
    	$scope.data = {
    		listaTipoOs: [],
    		listaClientes: [],
    		listaTecnicos: [],
    		listaCategoriaDemanda: [],
    		os: {
    			cliente: null,
    			tecAgendamento: null,
    			tecResponsavel: null,
    			categoriaDemanda: null,
    			dataHoraChamado: new Date(),
    			dataAgendamento: new Date(),
    			dataLimiteAtendimento: new Date(),
    			descricaoDemanda: '',
    			sugestaoSolucao: ''
    		}
    	};

    	$scope.cadastrarOs = function() {
    		//console.log($scope.data.os);
    		tickitService.manterOs($scope.data.os).then(function(tkResponse) {
    			if(tkResponse.status = 'success') {
    				SweetAlert.swal({   
		          title: "Sucesso",   
		          text: "Ordem de serviço cadastrada!",   
		          type: "success",   
		          showCancelButton: false,   
		          confirmButtonText: "Ok!",
		          closeOnConfirm: true 
		        }, function(isConfirm){  
		          if (isConfirm) {     
		            $state.go('app.os-main');
		          }
		        });		
    			}	
    		});
    	};

    	//Init
    	tickitService.usuarioLogado().then(function(tkResponse) {
  			if(tkResponse.status = 'success') {
  				$scope.data.os.tecAgendamento = tkResponse.obj;	
  			}
  		});

  		tickitService.listaTipoOs().then(function(tkResponse) {
  			if(tkResponse.status = 'success') {
  				$scope.data.listaTipoOs = tkResponse.obj;	
  			}
  		});

  		tickitService.listaClientes().then(function(tkResponse) {
  			if(tkResponse.status = 'success') {
  				$scope.data.listaClientes = tkResponse.obj;	
  			}
  		});

  		tickitService.listaTecnicos().then(function(tkResponse) {
  			if(tkResponse.status = 'success') {
  				$scope.data.listaTecnicos = tkResponse.obj;	
  			}
  		});

  		tickitService.listaCategoriaDemanda().then(function(tkResponse) {
  			if(tkResponse.status = 'success') {
  				$scope.data.listaCategoriaDemanda = tkResponse.obj;	
  			}
  		});
    };

    function propsFilter() {
      return function(items, props) {
        var out = [];

        if (angular.isArray(items)) {
          items.forEach(function(item) {
            var itemMatches = false;

            var keys = Object.keys(props);
            for (var i = 0; i < keys.length; i++) {
              var prop = keys[i];
              var text = props[prop].toLowerCase();
              if (item[prop].toString().toLowerCase().indexOf(text) !== -1) {
                itemMatches = true;
                break;
              }
            }

            if (itemMatches) {
              out.push(item);
            }
          });
        } else {
          // Let the output be the input untouched
          out = items;
        }

        return out;
      };
    };
})();