package inventories;

import items.*;

public class Inventory {

	int invSize; //The size of the Inventory
	Item[] items; //The items in the Inventory
	
	public Inventory(int size) { //Constructor for the inventory
		
		invSize = size;
		items = new Item[size];
		
	}
	
	public void setItem(Item item, int index) { //Set an item at a certain index location
		
		items[index] = item;
		
	}
}
