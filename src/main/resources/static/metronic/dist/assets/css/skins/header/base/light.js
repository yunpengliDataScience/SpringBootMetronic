/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, { enumerable: true, get: getter });
/******/ 		}
/******/ 	};
/******/
/******/ 	// define __esModule on exports
/******/ 	__webpack_require__.r = function(exports) {
/******/ 		if(typeof Symbol !== 'undefined' && Symbol.toStringTag) {
/******/ 			Object.defineProperty(exports, Symbol.toStringTag, { value: 'Module' });
/******/ 		}
/******/ 		Object.defineProperty(exports, '__esModule', { value: true });
/******/ 	};
/******/
/******/ 	// create a fake namespace object
/******/ 	// mode & 1: value is a module id, require it
/******/ 	// mode & 2: merge all properties of value into the ns
/******/ 	// mode & 4: return value when already ns object
/******/ 	// mode & 8|1: behave like require
/******/ 	__webpack_require__.t = function(value, mode) {
/******/ 		if(mode & 1) value = __webpack_require__(value);
/******/ 		if(mode & 8) return value;
/******/ 		if((mode & 4) && typeof value === 'object' && value && value.__esModule) return value;
/******/ 		var ns = Object.create(null);
/******/ 		__webpack_require__.r(ns);
/******/ 		Object.defineProperty(ns, 'default', { enumerable: true, value: value });
/******/ 		if(mode & 2 && typeof value != 'string') for(var key in value) __webpack_require__.d(ns, key, function(key) { return value[key]; }.bind(null, key));
/******/ 		return ns;
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = "../src/assets/sass/global/layout/header/skins/base/light.scss");
/******/ })
/************************************************************************/
/******/ ({

/***/ "../src/assets/sass/global/layout/header/skins/base/light.scss":
/*!*********************************************************************!*\
  !*** ../src/assets/sass/global/layout/header/skins/base/light.scss ***!
  \*********************************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

eval("throw new Error(\"Module build failed (from ./node_modules/mini-css-extract-plugin/dist/loader.js):\\nModuleBuildError: Module build failed (from ./node_modules/sass-loader/dist/cjs.js):\\nError: Node Sass does not yet support your current environment: Windows 64-bit with Unsupported runtime (83)\\nFor more information on which environments are supported please see:\\nhttps://github.com/sass/node-sass/releases/tag/v4.13.1\\n    at module.exports (C:\\\\dev\\\\metronic_v6.1.8\\\\theme\\\\default\\\\demo1\\\\tools\\\\node_modules\\\\node-sass\\\\lib\\\\binding.js:13:13)\\n    at Object.<anonymous> (C:\\\\dev\\\\metronic_v6.1.8\\\\theme\\\\default\\\\demo1\\\\tools\\\\node_modules\\\\node-sass\\\\lib\\\\index.js:14:35)\\n    at Module._compile (C:\\\\dev\\\\metronic_v6.1.8\\\\theme\\\\default\\\\demo1\\\\tools\\\\node_modules\\\\v8-compile-cache\\\\v8-compile-cache.js:192:30)\\n    at Object.Module._extensions..js (internal/modules/cjs/loader.js:1092:10)\\n    at Module.load (internal/modules/cjs/loader.js:928:32)\\n    at Function.Module._load (internal/modules/cjs/loader.js:769:14)\\n    at Module.require (internal/modules/cjs/loader.js:952:19)\\n    at require (C:\\\\dev\\\\metronic_v6.1.8\\\\theme\\\\default\\\\demo1\\\\tools\\\\node_modules\\\\v8-compile-cache\\\\v8-compile-cache.js:161:20)\\n    at getDefaultSassImpl (C:\\\\dev\\\\metronic_v6.1.8\\\\theme\\\\default\\\\demo1\\\\tools\\\\node_modules\\\\sass-loader\\\\dist\\\\index.js:198:10)\\n    at Object.loader (C:\\\\dev\\\\metronic_v6.1.8\\\\theme\\\\default\\\\demo1\\\\tools\\\\node_modules\\\\sass-loader\\\\dist\\\\index.js:80:29)\\n    at C:\\\\dev\\\\metronic_v6.1.8\\\\theme\\\\default\\\\demo1\\\\tools\\\\node_modules\\\\webpack\\\\lib\\\\NormalModule.js:316:20\\n    at C:\\\\dev\\\\metronic_v6.1.8\\\\theme\\\\default\\\\demo1\\\\tools\\\\node_modules\\\\loader-runner\\\\lib\\\\LoaderRunner.js:367:11\\n    at C:\\\\dev\\\\metronic_v6.1.8\\\\theme\\\\default\\\\demo1\\\\tools\\\\node_modules\\\\loader-runner\\\\lib\\\\LoaderRunner.js:233:18\\n    at runSyncOrAsync (C:\\\\dev\\\\metronic_v6.1.8\\\\theme\\\\default\\\\demo1\\\\tools\\\\node_modules\\\\loader-runner\\\\lib\\\\LoaderRunner.js:143:3)\\n    at iterateNormalLoaders (C:\\\\dev\\\\metronic_v6.1.8\\\\theme\\\\default\\\\demo1\\\\tools\\\\node_modules\\\\loader-runner\\\\lib\\\\LoaderRunner.js:232:2)\\n    at Array.<anonymous> (C:\\\\dev\\\\metronic_v6.1.8\\\\theme\\\\default\\\\demo1\\\\tools\\\\node_modules\\\\loader-runner\\\\lib\\\\LoaderRunner.js:205:4)\\n    at Storage.finished (C:\\\\dev\\\\metronic_v6.1.8\\\\theme\\\\default\\\\demo1\\\\tools\\\\node_modules\\\\enhanced-resolve\\\\lib\\\\CachedInputFileSystem.js:55:16)\\n    at C:\\\\dev\\\\metronic_v6.1.8\\\\theme\\\\default\\\\demo1\\\\tools\\\\node_modules\\\\enhanced-resolve\\\\lib\\\\CachedInputFileSystem.js:91:9\\n    at C:\\\\dev\\\\metronic_v6.1.8\\\\theme\\\\default\\\\demo1\\\\tools\\\\node_modules\\\\graceful-fs\\\\graceful-fs.js:115:16\\n    at FSReqCallback.readFileAfterClose [as oncomplete] (internal/fs/read_file_context.js:63:3)\");\n\n//# sourceURL=webpack:///../src/assets/sass/global/layout/header/skins/base/light.scss?");

/***/ })

/******/ });