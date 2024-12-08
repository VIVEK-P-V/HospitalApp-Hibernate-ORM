package com.ty.hospitalapp.service;

import java.util.List;
import com.ty.hospitalapp.dao.impl.BranchDaoImpl;
import com.ty.hospitalapp.dto.Branch;

public class BranchService {

	// Method to save a new branch associated with a hospital
	public Branch saveBranch(int hid, Branch branch) {
		BranchDaoImpl daoImp = new BranchDaoImpl();
		Branch branch1 = daoImp.saveBranch(hid, branch);
		if (branch1 != null) {
			System.out.println("Record Saved");
			return branch1;
		} else {
			System.out.println("Record Not Saved");
			return null;
		}
	}

	// Method to get a branch by its ID
	public Branch getBranchById(int bid) {
		BranchDaoImpl daoImp = new BranchDaoImpl();
		Branch branch1 = daoImp.getBranchById(bid);
		if (branch1 != null) {
			return branch1;
		} else {
			return null;
		}
	}

	// Method to update an existing branch by its ID
	public Branch updateBranchById(int bid, Branch branch) {
		BranchDaoImpl daoImp = new BranchDaoImpl();
		Branch branch1 = daoImp.updateBranchById(bid, branch);
		if (branch1 != null) {
			return branch1;
		} else {
			System.out.println("Record Not Updated");
			return null;
		}
	}

	// Method to delete a branch by its ID
	public boolean deleteBranch(int bid) {
		BranchDaoImpl daoImp = new BranchDaoImpl();
		boolean flag = daoImp.deleteBranch(bid);
		if (flag) {
			System.out.println("Record Deleted Successfully");
			return true;
		} else {
			System.out.println("Record Not Deleted");
			return false;
		}
	}

	// Method to get a list of all branches
	public List<Branch> getAllBranch() {
		BranchDaoImpl daoImp = new BranchDaoImpl();
		List<Branch> branches = daoImp.getAllBranch();
		if (branches != null) {
			return branches;
		} else {
			return null;
		}
	}
}
