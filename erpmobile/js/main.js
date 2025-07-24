/**
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates.
 * The Universal Permissive License (UPL), Version 1.0
 */
'use strict';

/**
 * Example of Require.js boostrap javascript
 */

requirejs.config(
{
  baseUrl: 'js',
  urlArgs: 'v=20200305',
  // Path mappings for the logical module names
  // Update the main-release-paths.json for release mode when updating the mappings
  paths:
  //injector:mainReleasePaths
  {
    'knockout': 'libs/knockout/knockout-3.4.2',
    'jquery': 'libs/jquery/jquery-3.3.1.min',
    'jqueryui-amd': 'libs/jquery/jqueryui-amd-1.12.1.min',
    'jquery-cookie' : 'libs/jquery/jquery.cookie',
    'promise': 'libs/es6-promise/es6-promise.min',
    'hammerjs': 'libs/hammer/hammer-2.0.8.min',
    'ojdnd': 'libs/dnd-polyfill/dnd-polyfill-1.0.0.min',
    'ojs':  'libs/oj/v5.1.0/min',
    'dl': 'delicacy',
    'ojL10n': 'libs/oj/v5.1.0/ojL10n',
    'ojtranslations': 'libs/oj/v5.1.0/resources',
    'text': 'libs/require/text',
    'signals': 'libs/js-signals/signals.min',
    'customElements': 'libs/webcomponents/custom-elements.min',
    'proj4': 'libs/proj4js/dist/proj4',
    'css': 'libs/require-css/css.min',
    'diagramLayouts':'libs/diagramLayouts'
  }
  //endinjector
  ,
  // Shim configurations for modules that do not expose AMD
  shim:
  {
    'jquery':
    {
      exports: ['jQuery', '$']
    }
  }
}
);

/**
 * A top-level require call executed by the Application.
 * Although 'ojcore' and 'knockout' would be loaded in any case (they are specified as dependencies
 * by the modules themselves), we are listing them explicitly to get the references to the 'oj' and 'ko'
 * objects in the callback
 */
require(['ojs/ojcore', 'knockout', 'dl/commclient', 'ojs/ojknockout', 'ojs/ojrouter',
  'ojs/ojmodule'],
  function (oj, ko,dl) { // this callback gets executed when all required modules are loaded

    $(function() {

      function init() {
        oj.Router.sync().then(
          function () {
              
//            变换globalModule  初始是注册页面模块login
            dl.getGlobalModule = ko.observable({name: 'loginCheck', params: '', cacheKey: 'loginCheck'});
            ko.applyBindings(null, document.getElementById('globalBody'));
          },
          function (error) {
            oj.Logger.error('Error in root start: ' + error.message);
          }
        );
      }

      // If running in a hybrid (e.g. Cordova) environment, we need to wait for the deviceready 
      // event before executing any code that might interact with Cordova APIs or plugins.
      if ($(document.body).hasClass('oj-hybrid')) {
        document.addEventListener("deviceready", init);
      } else {
        init();
      }
    });

  }
);
