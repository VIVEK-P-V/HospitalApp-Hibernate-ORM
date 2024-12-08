package com.ty.hospitalapp.service;

import java.util.List;
import com.ty.hospitalapp.dao.impl.ItemDaoImpl;
import com.ty.hospitalapp.dto.Item;

public class ItemService {

	// Method to save a new item associated with a medical order
	public Item saveItem(int mid, Item item) {
		ItemDaoImpl daoImp = new ItemDaoImpl();
		Item item1 = daoImp.saveItem(mid, item);
		if (item1 != null) {
			System.out.println("Record Saved");
			return item1;
		} else {
			System.out.println("Record Not Saved");
			return null;
		}
	}

	// Method to get an item by its ID
	public Item getItemById(int id) {
		ItemDaoImpl daoImp = new ItemDaoImpl();
		Item item1 = daoImp.getItemById(id);
		if (item1 != null) {
			return item1;
		} else {
			return null;
		}
	}

	// Method to update an existing item by its ID
	public Item updateItemById(int id, Item item) {
		ItemDaoImpl daoImp = new ItemDaoImpl();
		Item item1 = daoImp.updateItemById(id, item);
		if (item1 != null) {
			System.out.println("Record Updated");
			return item1;
		} else {
			System.out.println("Record Not Updated");
			return null;
		}
	}

	// Method to delete an item by its ID
	public boolean deleteItemById(int id) {
		ItemDaoImpl daoImp = new ItemDaoImpl();
		boolean flag = daoImp.deleteItemById(id);
		if (flag) {
			System.out.println("Record Deleted Successfully");
			return true;
		} else {
			System.out.println("Record Not Deleted");
			return false;
		}
	}

	// Method to get a list of all items
	public List<Item> getAllItem() {
		ItemDaoImpl daoImp = new ItemDaoImpl();
		List<Item> items = daoImp.getAllItem();
		if (items != null) {
			return items;
		} else {
			return null;
		}
	}
}
