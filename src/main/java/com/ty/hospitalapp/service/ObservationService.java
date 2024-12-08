package com.ty.hospitalapp.service;

import java.util.List;
import com.ty.hospitalapp.dao.impl.ObservationDaoImpl;
import com.ty.hospitalapp.dto.Observation;

public class ObservationService {

	// Method to save a new observation associated with an encounter
	public Observation saveObservation(int eid, Observation observation) {
		ObservationDaoImpl daoImp = new ObservationDaoImpl();
		Observation observation2 = daoImp.saveObservation(eid, observation);
		if (observation2 != null) {
			System.out.println("Record Saved");
			return observation2;
		} else {
			System.out.println("Record Not Saved");
			return null;
		}
	}

	// Method to get an observation by its ID
	public Observation getObservationById(int oid) {
		ObservationDaoImpl daoImp = new ObservationDaoImpl();
		Observation observation2 = daoImp.getObservationById(oid);
		if (observation2 != null) {
			return observation2;
		} else {
			return null;
		}
	}

	// Method to update an existing observation by its ID
	public Observation updateObservationById(int oid, Observation observation) {
		ObservationDaoImpl daoImp = new ObservationDaoImpl();
		Observation observation2 = daoImp.updateObservationById(oid, observation);
		if (observation2 != null) {
			return observation2;
		} else {
			return null;
		}
	}

	// Method to delete an observation by its ID
	public boolean deleteObservationById(int oid) {
		ObservationDaoImpl daoImp = new ObservationDaoImpl();
		boolean flag = daoImp.deleteObservationById(oid);
		if (flag) {
			System.out.println("Record Deleted Successfully");
			return true;
		} else {
			System.out.println("Record Not Deleted");
			return false;
		}
	}

	// Method to get a list of observations by doctor name
	public List<Observation> getAllObservationByDoctorName(String dname) {
		ObservationDaoImpl daoImp = new ObservationDaoImpl();
		List<Observation> observations = daoImp.getAllObservationByDoctorName(dname);
		if (observations != null && !observations.isEmpty()) {
			return observations;
		} else {
			return null;
		}
	}
}
