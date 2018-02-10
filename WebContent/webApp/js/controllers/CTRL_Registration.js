myApp.controller('CTRL_Registration', [ '$scope', '$http','$state',
		function($scope, $http, $state) {
	
	var registrationCtrl = this;
	
	//registrationCtrl.patient = {bloodGroup:"--Select--"};
	
	registrationCtrl.bGList = ['A+','A-','B+','B-','O+','O-','AB+','AB-'];
	registrationCtrl.message = "";
	registrationCtrl.msgColor = false;
	
	registrationCtrl.today = new Date(Date.today()).toString('yyyy-MM-d');
	//console.log(registrationCtrl.today);
	
	registrationCtrl.submit = function(){
		console.log(registrationCtrl.patient);
		registrationCtrl.patient.appointmentDate = new Date(Date.parse(registrationCtrl.patient.appointmentDate.toDateString())).getTime();
		$http({
			  method: 'POST',
			  url: '/Hospital_Appointment/hospmanage/register/submit',
			  headers: {'Content-Type': 'text/plain'},
			  data: JSON.stringify(registrationCtrl.patient)
			}).then(function(resp){
			console.log(resp);
			if(typeof resp.data == "number"){
				registrationCtrl.message = "Details saved successfully ! Your Patient ID is "+resp.data+
				". Please quote this Patient ID for any future reference.";
				registrationCtrl.msgColor = true;
				registrationCtrl.patient = {bloodGroup:"--Select--"};
			}else{
				registrationCtrl.message = "Error processing your request. Please try again later.";
				registrationCtrl.msgColor = false;
			}
		});
	};
	
	registrationCtrl.goHome = function(){
		$state.transitionTo('main.home',null, {
		    reload: true,
		    inherit: false,
		    notify: true
		});
	};
	
}]);