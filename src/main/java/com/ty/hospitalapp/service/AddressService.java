package com.ty.hospitalapp.service;

import java.util.List;
import com.ty.hospitalapp.dao.impl.AddressDaoImpl;
import com.ty.hospitalapp.dto.Address;

public class AddressService {

	// Method to save a new address associated with a branch
	public void saveAddress(int bid, Address address) {
		AddressDaoImpl daoImp = new AddressDaoImpl();
		Address address2 = daoImp.saveAddress(bid, address);
		if (address2 != null) {
			System.out.println("Record Saved");
		} else {
			System.out.println("Record Not Saved");
		}
	}

	// Method to get an address by its ID
	public Address getAddressById(int aid) {
		AddressDaoImpl daoImp = new AddressDaoImpl();
		Address address2 = daoImp.getAddressById(aid);
		if (address2 != null) {
			return address2;
		} else {
			return null;
		}
	}

	// Method to update an existing address by its ID
	public Address updateAddressById(int aid, Address address) {
		AddressDaoImpl daoImp = new AddressDaoImpl();
		Address address2 = daoImp.updateAddressById(aid, address);
		if (address2 != null) {
			return address2;
		} else {
			return null;
		}
	}

	// Method to delete an address by its ID
	public boolean deleteAddressById(int aid) {
		AddressDaoImpl daoImp = new AddressDaoImpl();
		boolean flag = daoImp.deleteAddressById(aid);
		if (flag) {
			System.out.println("Record Deleted Successfully");
			return true;
		} else {
			System.out.println("Record Not Deleted");
			return false;
		}
	}

	// Method to get a list of all addresses
	public List<Address> getAllAddress() {
		AddressDaoImpl daoImp = new AddressDaoImpl();
		List<Address> addresses = daoImp.getAllAddress();
		if (addresses != null) {
			return addresses;
		} else {
			return null;
		}
	}
}
