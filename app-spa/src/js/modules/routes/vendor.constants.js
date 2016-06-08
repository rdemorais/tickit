/**=========================================================
 * Module: VendorAssetsConstant.js
 =========================================================*/

(function() {
    'use strict';

    angular
        .module('naut')
        .constant('VENDOR_ASSETS', {
            // jQuery based and standalone scripts
            scripts: {
              'animate':            ['vendor/animate.css/animate.min.css'],
              'icons':              ['vendor/font-awesome/css/font-awesome.min.css',
                                     'vendor/weather-icons/css/weather-icons.min.css',
                                     'vendor/feather/webfont/feather-webfont/feather.css'],
              'slimscroll':         ['vendor/slimscroll/jquery.slimscroll.min.js'],
              'moment' :            ['vendor/moment/min/moment-with-locales.min.js'],
              'froala':             ['vendor/froala/css/froala_editor.min.css',
                                     'vendor/froala/css/froala_editor.pkgd.min.css',
                                     'vendor/froala/css/froala_style.min.css']
            },
            // Angular modules scripts (name is module name to be injected)
            modules: [
              {name: 'toaster',           files: ['vendor/angularjs-toaster/toaster.js',
                                                  'vendor/angularjs-toaster/toaster.css']},
              {name: 'textAngular',       files: ['vendor/textAngular/dist/textAngular.css',
                                                  'vendor/textAngular/dist/textAngular-rangy.min.js',                                                          
                                                  'vendor/textAngular/dist/textAngular-sanitize.js',
                                                  'vendor/textAngular/src/globals.js',
                                                  'vendor/textAngular/src/factories.js',
                                                  'vendor/textAngular/src/DOM.js',
                                                  'vendor/textAngular/src/validators.js',
                                                  'vendor/textAngular/src/taBind.js',
                                                  'vendor/textAngular/src/main.js',
                                                  'vendor/textAngular/dist/textAngularSetup.js'
                                                          ], serie: true},
              {name: 'ui.select',         files: ['vendor/ui-select/dist/select.js',
                                                  'vendor/ui-select/dist/select.css']},
              {name: 'xeditable',         files: ['vendor/angular-xeditable/dist/js/xeditable.js',
                                                  'vendor/angular-xeditable/dist/css/xeditable.css']},
              {name: 'ui.select',         files: ['vendor/angular-ui-select/dist/select.js',
                                                  'vendor/angular-ui-select/dist/select.css']},
              {name: 'datePicker',files: ['vendor/angular-datepicker/dist/angular-datepicker.js',
                                                  'vendor/angular-datepicker/dist/angular-datepicker.min.css']},
              {name: 'oitozero.ngSweetAlert',     files: ['vendor/sweetalert/dist/sweetalert.css',
                                                          'vendor/sweetalert/dist/sweetalert.min.js',
                                                          'vendor/angular-sweetalert/SweetAlert.js']}
            ]

        });
})();