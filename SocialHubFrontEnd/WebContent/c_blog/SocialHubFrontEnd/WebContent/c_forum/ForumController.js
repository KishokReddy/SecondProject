myModule.controller("ForumController",function($scope,$http,$rootScope,$location)
		{	
			
			$scope.forum={'forumId':0,'forumName':'','forumContent':'','createDate':'','loginname':'','status':''};
			
			$scope.forumData;
			
			$rootScope.forumCommentData;
			
			$rootScope.forumInfo;
			
			$scope.forumComment={'commentId':0,'forumId':'','discussionText':'','loginname':'','discussionDate':''};
			
			$scope.addForum=function()
			{	console.log("Add fn");
				$http.post('http://localhost:8081/SocialHubMiddleware/addForum',$scope.forum)
				.then(function(response)
				{
					$location.path('/UserHome');
				});
			}
			
			function showForum()
			{
				console.log("Show fn");
				$http.get('http://localhost:8081/SocialHubMiddleware/listForums')
				.then(function(response)
				{
					$scope.forumData=response.data;
					console.log($scope.forumData);
					
				});
			}
			
			$scope.approveForums=function(forumId)
			{
				$http.get('http://localhost:8081/SocialHubMiddleware/approveForum/'+forumId)
				.then(function(response)
				{
					console.log('Approving the Forum');
				});
			}
			
			$scope.rejectForums=function(forumId)
			{
				$http.get('http://localhost:8081/SocialHubMiddleware/rejectForum/'+forumId)
				.then(function(response)
				{
					console.log('Rejecting the Forum');
				});
			}
			$rootScope.forumComment=function(forum)
			{
				console.log('I am in Forum Comment Controller');
				$http.get('http://localhost:8081/SocialHubMiddleware/getAllForumComment/'+forum.forumId)
				.then(function(response)
				{
					$rootScope.forumInfo=forum;
					console.log($rootScope.forumInfo);
					$rootScope.forumCommentData=response.data;
					$location.path('/forumComment');	
				});
				
			}
			
			$scope.insertForumComment=function()
			{
				console.log('Inserting Forum Comment');
				$scope.forumComment.loginname=$rootScope.currentUser.loginname;
				$scope.forumComment.forumId=$rootScope.forumInfo.forumId;
				$http.post('http://localhost:8081/SocialHubMiddleware/insertForumComment',$scope.forumComment)
				.then(function(response)
				{
					console.log('Successful');
					$location.path('/forumComment');	
				});
			}
			showForum();
		
		});
			
			
			
		
			
		