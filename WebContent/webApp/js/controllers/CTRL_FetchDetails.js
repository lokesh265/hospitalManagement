myApp.controller('CTRL_FetchDetails', [ '$scope', '$http', '$state',
		function($scope, $http, $state) {
	
	var fetchCtrl = this;
	fetchCtrl.modalMsg = "";
	fetchCtrl.getPatient = function(){
		if($scope.$parent.patientId){
			$http({
				  method: 'GET',
				  url: '/Hospital_Appointment/hospmanage/getPatient/'+$scope.$parent.patientId,
				  headers: {'Content-Type': 'text/plain'},
				}).then(function(resp){
				console.log(resp);
				if(resp.data=="No Record found !"){
					fetchCtrl.modalMsg = "No Record found !";
					$('#alertModal').modal('show');
				}else{
					fetchCtrl.patient=resp.data;
					fetchCtrl.patient.appointmentDate = new Date(fetchCtrl.patient.appointmentDate).toDateString();
				}
			});
		}else{
			fetchCtrl.goHome();
		}		
	};
	
	fetchCtrl.getPatient();
	
	fetchCtrl.goHome = function(){
		$state.transitionTo('main.home',null,{
		    reload: true,
		});
	};
	
}]);