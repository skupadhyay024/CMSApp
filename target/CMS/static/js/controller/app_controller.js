'use strict';
angular.module('myApp').controller('appctrl',["$scope", "httpService","$location","$window",function($scope,httpService,$location,$window){
	
	/*To Validate the User*/
	 $scope.validateuser=function(){
		var uname=$scope.username;
		var pass=$scope.password;
	var formdata={
				username:uname,
				password:pass
				
		};
		var details={
				
				getUrl:"rest/isvalid",
				getFormData:formdata
				
		};
		
		httpService.getDataByForm(details).then(onSuccessRetrival, onError);
	 };
		
		var onSuccessRetrival = function(data) {
		
			$window.localStorage.setItem("uname",data.username);
			//$scope.logged=data.username;
			//console.log($scope.logged);
			
			$location.path('/dashboard');
			//$scope.getArticleDetails();
			
		};
		
		var onError = function(reason) {
			alert("Invalid Login");
			
		};
		
		/*To display Logged in User*/
		$scope.$watch('logged',function(newValue,oldValue){
			$scope.logged=$window.localStorage.getItem("uname");
			console.log($scope.logged+"**");
			
			
		});
		/*To add the article*/
		
		$scope.addarticle=function(){
			var title=$scope.title;
			var article=$scope.article;
		var formdata={
				"articleTitle":title,
				"articleText":article,
				"username":$window.localStorage.getItem("uname")
			
					
			};
			var details={
					
					getUrl:"rest/addArticle",
					getFormData:formdata
					
			};
			
			httpService.getDataByForm(details).then(onSuccessRetrivals, onErrorArticle);
		 };
		 var onErrorArticle = function(reason) {
				alert("Article is not added");
				
			};
			
			var onSuccessRetrivals = function(data) {
			alert("Article Added");
			$location.path('/dashboard');
			};
			
			 $scope.newart=function(){
				 $location.path('/newart');
			
				 };
				 
		//To Fetch Article List		 
				
				 
				 $scope.getArticleDetails = function(){
						var formdata={
								"username":$window.localStorage.getItem("uname")
							};
						var details={
								
								getUrl:"rest/getAllArticle",
								getFormData:formdata
								
						};
					
						httpService.getDataByForm(details).then(successart, artfailure);
				 };
					
				 var successart=function successCallback(data) {
			
							$scope.ArticleList=data;
							
						  };
						  
						  var artfailure=function errorCallback(reason) {
							  alert('Not Able to Fetch Article');
						  };
					
				
						  $scope.getArticleDetails();
						  /*To show article content*/
						  $scope.articleClick=function(item){
							  $scope.content=item.articleText;
							  
						  };
						  /*Go to Home*/
						  $scope.goToHome=function(){
							  $location.path('/dashboard');
							  
						  };
		 
						  
	
		
	}






	
	
]);
