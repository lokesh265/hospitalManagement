package com.valueObject;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Patient{

	private String name;
	private String bloodGroup;
	private Float height;
	private Float weight;
	private Integer bloodPressure;
	private String pastDiseases;
	private String allergies;
	private String currentMedications;
	private Integer id;
	private Long appointmentDate;
	
	public Patient(){
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public Float getHeight() {
		return height;
	}
	public void setHeight(Float height) {
		this.height = height;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public Integer getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(Integer bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	public String getPastDiseases() {
		return pastDiseases;
	}
	public void setPastDiseases(String pastDiseases) {
		this.pastDiseases = pastDiseases;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	public String getCurrentMedications() {
		return currentMedications;
	}
	public void setCurrentMedications(String currentMedications) {
		this.currentMedications = currentMedications;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Long getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Long appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
}
