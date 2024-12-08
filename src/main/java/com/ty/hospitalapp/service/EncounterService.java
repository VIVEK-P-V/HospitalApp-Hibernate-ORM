package com.ty.hospitalapp.service;

import java.util.List;
import com.ty.hospitalapp.dao.impl.EncounterDaoImpl;
import com.ty.hospitalapp.dto.Encounter;

public class EncounterService {

	// Method to save a new encounter associated with a branch
	public Encounter saveEncounter(int bid, Encounter encounter) {
		EncounterDaoImpl daoImp = new EncounterDaoImpl();
		Encounter encounter1 = daoImp.saveEncounter(bid, encounter);
		if (encounter1 != null) {
			System.out.println("Record Saved");
			return encounter1;
		} else {
			System.out.println("Record Not Saved");
			return null;
		}
	}

	// Method to get an encounter by its ID
	public Encounter getEncounterById(int eid) {
		EncounterDaoImpl daoImp = new EncounterDaoImpl();
		Encounter encounter1 = daoImp.getEncounterById(eid);
		if (encounter1 != null) {
			return encounter1;
		} else {
			return null;
		}
	}

	// Method to update an existing encounter by its ID
	public Encounter updateEncounterById(int eid, Encounter encounter) {
		EncounterDaoImpl daoImp = new EncounterDaoImpl();
		Encounter encounter1 = daoImp.updateEncounterById(eid, encounter);
		if (encounter1 != null) {
			return encounter1;
		} else {
			return null;
		}
	}

	// Method to delete an encounter by its ID
	public boolean deleteEncounterById(int eid) {
		EncounterDaoImpl daoImp = new EncounterDaoImpl();
		boolean flag = daoImp.deleteEncounterById(eid);
		if (flag) {
			System.out.println("Record Deleted Successfully");
			return true;
		} else {
			System.out.println("Record Not Deleted");
			return false;
		}
	}

	// Method to get a list of all encounters
	public List<Encounter> getAllEncounter() {
		EncounterDaoImpl daoImp = new EncounterDaoImpl();
		List<Encounter> encounters = daoImp.getAllEncounter();
		if (encounters != null) {
			return encounters;
		} else {
			return null;
		}
	}
}
