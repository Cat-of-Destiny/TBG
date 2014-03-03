package inventories;

import items.*;

public class BaseInventory {

	int invSize; //The size of the Inventory
	
	public BaseInventory(int size) { //Constructor for the inventory
		invSize = size;
	}
	
	public void setItem(Item item, int index) { //Set an item at a certain index location
		return;
	}
	
	public Item getItem(int index) {
		return null;
	}
}
