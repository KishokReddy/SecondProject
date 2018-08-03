myModule.controller("UserController",function($scope,$http,$rootScope,$location,$cookieStore)
		{
			
			
			$scope.user={'loginname':'','password':'','username':'','emailid':'','mobile':'','role':'','address':''};
			
			$scope.checklogin=function()
			{	
				console.log('I am in Check Login');
				console.log($scope.user);
				$http.post('http://localhost:8081/SocialHubMiddleware/checkLogin',$scope.user)
				.then(function(response)
				{
					$scope.user=response.data;
					$rootScope.currentUser=response.data;
					$cookieStore.put('userDetails',response.data);
					console.log('User is Correct');
					$location.path("/UserHome");
				});
			
			}
			
			$scope.register=function()
			{
				console.log('I am in register Function');
				console.log($scope.user);
				$scope.user.role='ROLE_USER';
				$http.post('http://localhost:8081/SocialHubMiddleware/registerUser',$scope.user)
				.then(function(response)
				{
					console.log('User Registered');
					$rootScope.currentUser=$scope.user;
					$location.path("/UserHome");
				});
				
			}
	
	});




