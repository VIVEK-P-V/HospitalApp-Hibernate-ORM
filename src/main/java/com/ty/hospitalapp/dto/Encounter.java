package com.ty.hospitalapp.dto;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid; // Encounter ID
	private String reason; // Reason for the encounter

	private String dateOfJoin; // Date of joining
	private String discharge; // Discharge date

	@OneToMany(mappedBy = "encounter")
	private List<Observation> observation; // List of observations

	@OneToOne
	@JoinColumn
	private Person person; // Associated person

	@ManyToOne
	@JoinColumn
	private Branch branchs; // Associated branch

	@OneToMany(mappedBy = "encounter")
	private List<MedOrder> medOrder; // List of medical orders

	// Getter for eid
	public int getEid() {
		return eid;
	}

	// Setter for eid
	public void setEid(int eid) {
		this.eid = eid;
	}

	// Getter for reason
	public String getReason() {
		return reason;
	}

	// Setter for reason
	public void setReason(String reason) {
		this.reason = reason;
	}

	// Getter for dateOfJoin
	public String getDateOfJoin() {
		return dateOfJoin;
	}

	// Setter for dateOfJoin
	public void setDateOfJoin(String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	// Getter for discharge
	public String getDischarge() {
		return discharge;
	}

	// Setter for discharge
	public void setDischarge(String discharge) {
		this.discharge = discharge;
	}

	// Getter for observation
	public List<Observation> getObservation() {
		return observation;
	}

	// Setter for observation
	public void setObservation(List<Observation> observation) {
		this.observation = observation;
	}

	// Getter for person
	public Person getPerson() {
		return person;
	}

	// Setter for person
	public void setPerson(Person person) {
		this.person = person;
	}

	// Getter for branchs
	public Branch getBranchs() {
		return branchs;
	}

	// Setter for branchs
	public void setBranchs(Branch branchs) {
		this.branchs = branchs;
	}

	// Getter for medOrder
	public List<MedOrder> getMedOrder() {
		return medOrder;
	}

	// Setter for medOrder
	public void setMedOrder(List<MedOrder> medOrder) {
		this.medOrder = medOrder;
	}
}
