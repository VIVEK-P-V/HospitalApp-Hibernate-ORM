package com.ty.hospitalapp.dao;

import java.util.List;
import com.ty.hospitalapp.dto.Item;

public interface ItemDao {
	// Save a new item associated with a specific medical order
	// Parameters:
	// int mid - The medical order ID to associate the item with
	// Item item - The item to be saved
	// Returns:
	// The saved item object
	public Item saveItem(int mid, Item item);

	// Retrieve an item by its ID
	// Parameters:
	// int id - The item ID
	// Returns:
	// The item object if found, else null
	public Item getItemById(int id);

	// Update an existing item by its ID
	// Parameters:
	// int id - The item ID
	// Item item - The new item details to update
	// Returns:
	// The updated item object if successful, else null
	public Item updateItemById(int id, Item item);

	// Delete an item by its ID
	// Parameters:
	// int id - The item ID
	// Returns:
	// True if deletion is successful, else false
	public boolean deleteItemById(int id);

	// Retrieve all items
	// Returns:
	// A list of all item objects
	public List<Item> getAllItem();
}
