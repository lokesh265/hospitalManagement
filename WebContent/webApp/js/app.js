var myApp = [];

myApp.controller = ('allControllers',[]);

myApp = angular.module('hospitalAppointment',['ui.router'])

myApp.config(function($stateProvider, $urlRouterProvider){
	
	$stateProvider.state('main',{
		controller: 'CTRL_Main',
		controllerAs: 'mainCtrl',
		abstract: true,
		template: '<div ui-view></div>'
		
	}).state('main.home',{
		url: '/home',
		controller: 'CTRL_Home',
		controllerAs: 'homeCtrl',
		templateUrl: 'webApp/templates/PRTL_Home.html'
		
	}).state('main.register',{
		url: '/register',
		controller: 'CTRL_Registration',
		controllerAs: 'registrationCtrl',
		templateUrl: 'webApp/templates/PRTL_Registration.html'
		
	}).state('main.fetch',{
		url: '/fetch',
		controller: 'CTRL_FetchDetails',
		controllerAs: 'fetchCtrl',
		templateUrl: 'webApp/templates/PRTL_FetchDetails.html'
		
	});
	
	$urlRouterProvider.otherwise('/home');  //default state get loaded if we enter any wrong state/url
});
