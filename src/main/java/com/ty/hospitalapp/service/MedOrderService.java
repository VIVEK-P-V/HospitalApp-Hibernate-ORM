package com.ty.hospitalapp.service;

import java.util.List;
import com.ty.hospitalapp.dao.impl.MedOrderDaoImpl;
import com.ty.hospitalapp.dto.MedOrder;

public class MedOrderService {

	// Method to save a new medical order associated with an encounter
	public MedOrder saveMedOrder(int eid, MedOrder medOrder) {
		MedOrderDaoImpl daoImp = new MedOrderDaoImpl();
		MedOrder medOrder2 = daoImp.saveMedOrder(eid, medOrder);
		if (medOrder2 != null) {
			System.out.println("Record Saved");
			return medOrder2;
		} else {
			System.out.println("Record Not Saved");
			return null;
		}
	}

	// Method to get a medical order by its ID
	public MedOrder getMedOrderById(int mid) {
		MedOrderDaoImpl daoImp = new MedOrderDaoImpl();
		MedOrder medOrder2 = daoImp.getMedOrderById(mid);
		if (medOrder2 != null) {
			return medOrder2;
		} else {
			return null;
		}
	}

	// Method to update an existing medical order by its ID
	public MedOrder updateMedOrderById(int mid, MedOrder medOrder) {
		MedOrderDaoImpl daoImp = new MedOrderDaoImpl();
		MedOrder medOrder2 = daoImp.updateMedOrderById(mid, medOrder);
		if (medOrder2 != null) {
			return medOrder2;
		} else {
			return null;
		}
	}

	// Method to delete a medical order by its ID
	public boolean deleteMedOrderById(int mid) {
		MedOrderDaoImpl daoImp = new MedOrderDaoImpl();
		boolean flag = daoImp.deleteMedOrderById(mid);
		if (flag) {
			System.out.println("Record Deleted Successfully");
			return true;
		} else {
			System.out.println("Record Not Deleted");
			return false;
		}
	}

	// Method to get a list of all medical orders
	public List<MedOrder> getAllMedOrder() {
		MedOrderDaoImpl daoImp = new MedOrderDaoImpl();
		List<MedOrder> medOrders = daoImp.getAllMedOrder();
		if (medOrders != null) {
			return medOrders;
		} else {
			return null;
		}
	}

	// Method to get a list of medical orders by doctor name
	public List<MedOrder> getMedOrderByDoctorName(String dname) {
		MedOrderDaoImpl daoImp = new MedOrderDaoImpl();
		List<MedOrder> medOrders = daoImp.getMedOrderByDoctorName(dname);
		if (medOrders != null) {
			return medOrders;
		} else {
			return null;
		}
	}
}
