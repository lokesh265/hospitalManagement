package com.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.dao.PatientDAO;
import com.google.gson.Gson;
import com.valueObject.Patient;

@Path("/register")
public class Registration {

	@GET
	@Path("/get/{patientId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatient(@PathParam("patientId") int patientId) {
		PatientDAO patientDAO = new PatientDAO();
		Patient patient=patientDAO.getPatient(patientId);
		Gson gson = new Gson();
		if(null!=patient){
			gson.toJson(patient);
			return Response.status(Status.OK).entity(gson.toJson(patient)).build();
		}else{
			return Response.status(Status.OK).entity(gson.toJson("No Record found !")).build();
		}
		
		
	}
	
	@POST
	@Path("/submit")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response submitPatient(String req) {
		
		Gson gson = new Gson();
		Patient patient = gson.fromJson(req, Patient.class);
		System.out.println("Patient info received is: "+patient.getName());
		
		PatientDAO patientDAO = new PatientDAO();
		Integer count = patientDAO.savePatient(patient);
		if(count!=0){
			return Response.status(Status.OK).entity(gson.toJson(count)).build();
		}else{
			return Response.status(Status.OK).entity(gson.toJson("Could not save your details. Please try again later.")).build();
		}
		
	}

}
