myApp.controller('CTRL_Home', [ '$scope', '$state',
		function($scope, $state) {
	
	var homeCtrl = this;
	homeCtrl.validId = false;
	
	homeCtrl.getPatientDetails = function(){
		if($scope.$parent.patientId){
			homeCtrl.validId = false;
			$state.go('main.fetch');
		}else{
			homeCtrl.validId = true;
		}
	}
	
}]);