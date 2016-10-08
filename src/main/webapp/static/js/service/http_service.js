	'use strict';
angular.module("myApp").factory("httpService",['$http',function($http){

		var getDataByForm = function(details) {
			return $http.post(details.getUrl, details.getFormData).then(
					function(response) {
						return response.data;
					});
		}
		var getData = function(details) {
			return $http.post(details.getUrl).then(
					function(response) {
						return response.data;
					});
		}
		var getDataByFile = function(details) {
			return $http.post(details.getUrl,details.getFormData,{
			    headers: { 'Content-Type': undefined},
			    transformRequest:  function(data, headersGetterFunction) {
			        return data;
			    }
			}).then(
					function(response) {
						return response.data;
					});
		}
		var getDataByFileAlone = function(details) {
			alert(details.getUrl);
			alert(details.getFormData);
			return $http.post(details.getUrl,details.getFormData,{
				transformRequest: angular.identity,
	            headers: {'Content-Type': undefined}
			}).then(
					function(response) {
						return response.data;
					});
		}
		function setUserName(data) {
			saveUserData = data;
		}
		function getUserName() {
			return saveUserData;
		}
		return {
			getData : getData,
			getDataByForm : getDataByForm,
			getDataByFile  : getDataByFile,
			getDataByFileAlone : getDataByFileAlone,
			setUserName : setUserName,
			getUserName : getUserName
		};
	}]);

