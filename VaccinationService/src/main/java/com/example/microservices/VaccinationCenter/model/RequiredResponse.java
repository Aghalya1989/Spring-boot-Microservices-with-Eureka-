package com.example.microservices.VaccinationCenter.model;

import java.util.List;

import com.example.microservices.VaccinationCenter.Entity.VaccinationCenter;

public class RequiredResponse {

	private VaccinationCenter center;
	private List<Citizen> citizens;
	public VaccinationCenter getCenter() {
		return center;
	}
	public void setCenter(VaccinationCenter center) {
		this.center = center;
	}
	public RequiredResponse(VaccinationCenter center, List<Citizen> citizens) {
		super();
		this.center = center;
		this.citizens = citizens;
	}
	public List<Citizen> getCitizens() {
		return citizens;
	}
	public RequiredResponse() {
		super();
	}
	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}
}
