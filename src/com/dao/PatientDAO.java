package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;

import com.mysql.jdbc.PreparedStatement;
import com.properties.PropertyReader;
import com.utils.Utility;
import com.valueObject.Patient;

public class PatientDAO {

	private static Connection connection;
	
	static {
		try {
			getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void getConnection() throws ClassNotFoundException, SQLException {
		@SuppressWarnings("unused")
		PropertyReader propertyReader = null;
		
		//try {
			//Class.forName(JDBC_DRIVER);
		DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			if(null == connection){
				propertyReader = new PropertyReader();
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalManagement", 
						"root", "lokesh265");
			}
		/* catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}*/
		// Class.forName("com.mysql.jdbc.Driver");
		// connection = (Connection) DriverManager.getConnection(DB_URL,
		// USER_NAME, PASSWD);
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
	}
	
	public Patient getPatient(int id){
		
		System.out.println("PatientDAO.getPatient():: Patient Id received: "+id);
		
		String sql = "Select * from PATIENT where id=?";
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Patient patient = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if(resultSet.next()){
				patient = new Patient();
				
				patient.setName(resultSet.getString("name"));
				patient.setBloodGroup(resultSet.getString("bloodGroup"));
				patient.setHeight(resultSet.getFloat("height"));
				patient.setWeight(resultSet.getFloat("weight"));
				patient.setBloodPressure(resultSet.getInt("bloodPressure"));
				patient.setPastDiseases(resultSet.getString("pastDiseases"));
				patient.setAllergies(resultSet.getString("allergies"));
				patient.setCurrentMedications(resultSet.getString("currentMedications"));
				patient.setId(resultSet.getInt("id"));
				patient.setAppointmentDate(resultSet.getDate("appointmentDate").getTime());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return patient;
	}
	
	public Integer savePatient(Patient patient){
		System.out.println("PatientDAO.getPatient():: Patient details received for: "+patient.getName());
		
		String insertSql = "Insert into PATIENT(name, bloodGroup, height, weight, bloodPressure, pastDiseases, allergies, currentMedications, appointmentDate)"
				+ " values (?,?,?,?,?,?,?,?,?)";
		
		String selectSql = "SELECT MAX(id) AS id from PATIENT";
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int rowInserted = 0;
		try {
			statement = (PreparedStatement) connection.prepareStatement(insertSql);
			statement.setString(1,patient.getName());
			statement.setString(2, patient.getBloodGroup());
			statement.setFloat(3, patient.getHeight());
			statement.setFloat(4, patient.getWeight());
			statement.setInt(5, patient.getBloodPressure());
			statement.setString(6, patient.getPastDiseases());
			statement.setString(7, patient.getAllergies());
			statement.setString(8, patient.getCurrentMedications());
			statement.setDate(9, Utility.stringToSqlDate(patient.getAppointmentDate()));
			//statement.setInt(8, arg1);
			rowInserted = statement.executeUpdate();
			
			if(rowInserted>0){
				statement = (PreparedStatement) connection.prepareStatement(selectSql);
				resultSet = statement.executeQuery(selectSql);
				if(null != resultSet){
					resultSet.next();
					rowInserted = Integer.parseInt(resultSet.getString("id"));
				}
			}
			
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		} 
		
		return rowInserted;
	}
}
