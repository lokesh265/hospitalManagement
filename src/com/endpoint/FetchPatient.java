package com.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.dao.PatientDAO;
import com.google.gson.Gson;
import com.valueObject.Patient;

@Path("/getPatient")
public class FetchPatient {

	@GET
	@Path("/{patientId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatient(@PathParam("patientId") int patientId){
		Gson gson = new Gson();
		PatientDAO patientDAO = new PatientDAO();
		Patient patient=patientDAO.getPatient(patientId);
		
		if(null!=patient){
			gson.toJson(patient);
			return Response.status(Status.OK).entity(gson.toJson(patient)).build();
		}else{
			return Response.status(Status.OK).entity(gson.toJson("No Record found !")).build();
		}
	}
}
