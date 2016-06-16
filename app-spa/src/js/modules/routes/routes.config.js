/**=========================================================
 * Module: RoutesConfig.js
 =========================================================*/

(function() {
    'use strict';

    angular
        .module('naut')
        .config(routesConfig);

    routesConfig.$inject = ['$locationProvider', '$stateProvider', '$urlRouterProvider', 'RouteProvider', 'tickitServiceProvider', 'OAuthProvider'];
    function routesConfig($locationProvider, $stateProvider, $urlRouterProvider, Route, tickitServiceProvider, OAuthProvider) {

      OAuthProvider.configure({
        baseUrl: 'http://localhost:8080/tickit',
        clientId: 'restapp',
        clientSecret: 'secret',
        grantPath: '/oauth/token',
        revokePath: '/oauth/revoke'
      });

      tickitServiceProvider.env = 'dev';

      tickitServiceProvider.dev({
        baseUrl: 'http://localhost:8080/tickit',
        tokenApi: '/tk/api'
      });

      tickitServiceProvider.prod({
        baseUrl: 'http://localhost:8080/tickit',
        tokenApi: '/tk/api'
      });

      // use the HTML5 History API
      $locationProvider.html5Mode(false);

      // Default route
      $urlRouterProvider.otherwise('/app-login/login');

      // Application Routes States
      $stateProvider
        .state('app', {
          url: '/app',
          abstract: true,
          templateUrl: Route.base('app.html'),
          resolve: {
            _assets: Route.require('icons', 'toaster', 'animate', 'moment', 'ui.select', 'datePicker', 'froala', 'oitozero.ngSweetAlert')
          }
        })
        .state('app-login', {
          url: '/app-login',
          abstract: true,
          templateUrl: Route.base('app-login.html'),
          resolve: {
            _assets: Route.require('icons', 'toaster', 'animate')
          }
        })
        .state('app-login.login', {
          url: '/login',
          controller: 'TickitLoginController',
          templateUrl: Route.base('login.html'),
          resolve: {}
        })
        .state('app.dashboard', {
          url: '/dashboard',
          controller: 'TickitDashboardController',
          templateUrl: Route.base('dashboard.html'),
          resolve: {}
        })
        .state('app.os-main', {
          url: '/os-main',
          controller: 'TickitOSListaController',
          templateUrl: Route.base('os-main.html'),
          resolve: {}
        })
        .state('app.os-manter', {
          url: '/os-manter',
          controller: 'TickitOSController',
          templateUrl: Route.base('os-manter.html'),
          resolve: {
            assets: Route.require('slimscroll')
          }
        })
        .state('app.os-intervencao', {
          params: {
            'osId': null
          },
          url: '/os-intervencao',
          controller: 'TickItOSIntervencaoController',
          templateUrl: Route.base('os-intervencao.html'),
          resolve: {}
        });
    }
})();