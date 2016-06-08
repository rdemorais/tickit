/**=========================================================
 * Module: DashboardController.js
 =========================================================*/

(function() {
    'use strict';

    angular
        .module('naut')
        .controller('DashboardController', DashboardController);
    
    function DashboardController() {
      var vm = this;
      vm.title = 'Naut - Bootstrap + AngularJS (Seed Project)';
      vm.text = 'This project is an application skeleton for a typical AngularJS web app. You can use it to quickly bootstrap your angular webapp projects and dev environment for these projects.' + 
                    'The seed app doesnt do much, just shows how to wire some controllers and views together.';
    }

})();
