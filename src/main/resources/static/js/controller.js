var app = angular.module('app', []);

app.controller("mailerController", function($scope, $http) {

	$http.get("/mailerlite/groups").then(function(response) {
		$scope.data = response.data;
	});

	$scope.save = function(group) {

		angular.forEach($scope.data, function(groups) {
			if (groups.selected) {
				group.id = groups.selected;
			}
		});
		$http.post('/mailerlite/groups/save', group).then(function(data) {
			alert("Success");
			$http.get("/mailerlite/groups").then(function(response) {
				$scope.data = response.data;
			});
		}, function(err) {
			alert("Error");
		});
	}
});