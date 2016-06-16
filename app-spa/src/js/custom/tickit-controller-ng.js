(function() {
    'use strict';
    angular
        .module('naut')
        .controller('TickitLoginController', tickitLoginController)
        .controller('TickitDashboardController', tickitDashboardController)
        .controller('TickitOSController', tickitOSController)
        .controller('TickItOSIntervencaoController', tickItOSIntervencaoController)
        .controller('TickitOSListaController', tickitOSListaController)
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

    tickitOSListaController.$inject = ['$scope', '$state'];
    function tickitOSListaController($scope, $state) {

    };

    tickitDashboardController.$inject = ['$scope', '$state'];
    function tickitDashboardController($scope, $state) {
    	$scope.test = 'Ok, funcionou';
    };

    tickItOSIntervencaoController.$inject = ['$scope', '$uibModal', '$stateParams', 'tickitService']
    function tickItOSIntervencaoController($scope, $modal, $stateParams, tickitService) {

    	$scope.data = {
    		listas: {
    			listaCategoriaDemanda: [],
    			listaClientesOrigem: [],
    			listaClientesDestino: []
    		},
    		tecAgendamento: null,
    		intervencoes: [],
    		os: {}
    	};

    	tickitService.loadOs($stateParams.osId).then(function(tkResponse) {
    		if(tkResponse.status = 'success') {
    			$scope.data.os = tkResponse.obj;
    		}
    	});

    	//Init Listas
    	tickitService.usuarioLogado().then(function(tkResponse) {
  			if(tkResponse.status = 'success') {
  				$scope.data.tecAgendamento = tkResponse.obj;	
  			}
  		});

      tickitService.listaCategoriaDemanda().then(function(tkResponse) {
  			if(tkResponse.status = 'success') {
  				$scope.data.listas.listaCategoriaDemanda = tkResponse.obj;	
  			}
  		});

  		tickitService.listaClientes().then(function(tkResponse) {
  			if(tkResponse.status = 'success') {
  				$scope.data.listas.listaClientesOrigem = tkResponse.obj;
  				$scope.data.listas.listaClientesDestino = tkResponse.obj;
  			}
  		});

      $scope.openModalIntervencao = function() {

        var modalInstance = $modal.open({
          templateUrl: 'app/views/modal/intervencao-modal.html',
          controller: ModalInstanceCtrl,
          size: 'lg',
          resolve: {
          	listas: function() {
          		return $scope.data.listas;
          	},
          	tecAgendamento: function() {
          		return $scope.data.tecAgendamento;
          	},
          	os: function() {
          		return $scope.data.os;
          	}
          }
        });

        modalInstance.result.then(function (intervencao) {
          $scope.data.intervencoes.push(intervencao);
        }, function () {
          console.log('Modal dismissed with Cancel status');
        });
      };

      // Please note that $modalInstance represents a modal window (instance) dependency.
      // It is not the same as the $modal service used above.
      
      var ModalInstanceCtrl = function ($scope, $modalInstance, listas, tecAgendamento, os) {

      	$scope.data = {
      		listaCategoriaDemanda: listas.listaCategoriaDemanda,
      		listaClientesOrigem: listas.listaClientesOrigem,
      		listaClientesDestino: listas.listaClientesDestino,
      		tecAgendamento: tecAgendamento
      	};

      	$scope.intervencao = {
      		dataHoraIntervencao: new Date(),
      		dataHoraFimIntervencao: '',
      		categoriaDemanda: os.categoriaDemanda,
      		clienteOrigem: os.cliente
      	};

        $scope.ok = function () {
          $modalInstance.close($scope.intervencao);
        };

        $scope.cancel = function () {
          $modalInstance.dismiss('cancel');
        };
      };
      ModalInstanceCtrl.$inject = ['$scope', '$uibModalInstance', 'listas', 'tecAgendamento', 'os'];
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
		            $state.go('app.os-intervencao', {osId: tkResponse.obj.id});
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