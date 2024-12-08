package com.ty.hospitalapp.service;

import java.util.List;
import com.ty.hospitalapp.dao.impl.HospitalDaoImpl;
import com.ty.hospitalapp.dto.Hospital;

public class HospitalService {

	// Method to save a new hospital
	public void saveHospital(Hospital hospital) {
		HospitalDaoImpl daoImp = new HospitalDaoImpl();
		Hospital hospital1 = daoImp.saveHospital(hospital);
		if (hospital1 != null) {
			System.out.println("Record Saved");
		} else {
			System.out.println("Record Not Saved");
		}
	}

	// Method to get a hospital by its ID
	public Hospital getHospitalById(int hid) {
		HospitalDaoImpl daoImp = new HospitalDaoImpl();
		Hospital hospital1 = daoImp.getHospitalById(hid);
		if (hospital1 != null) {
			return hospital1;
		} else {
			return null;
		}
	}

	// Method to update an existing hospital by its ID
	public Hospital updateHospitalById(int hid, Hospital hospital) {
		HospitalDaoImpl daoImp = new HospitalDaoImpl();
		Hospital hospital1 = daoImp.updateHospitalById(hid, hospital);
		if (hospital1 != null) {
			return hospital1;
		} else {
			return null;
		}
	}

	// Method to delete a hospital by its ID
	public void deleteHospital(int hid) {
		HospitalDaoImpl daoImp = new HospitalDaoImpl();
		boolean flag = daoImp.deleteHospital(hid);
		if (flag) {
			System.out.println("Record Deleted Successfully");
		} else {
			System.out.println("Record Not Deleted");
		}
	}

	// Method to get a list of all hospitals
	public List<Hospital> getAllHospital() {
		HospitalDaoImpl daoImp = new HospitalDaoImpl();
		List<Hospital> hospital1 = daoImp.getAllHospital();
		if (hospital1 != null) {
			return hospital1;
		} else {
			return null;
		}
	}
}
