package inventories;

import items.Item;

public class ItemInventory extends BaseInventory {
	
	Item[] items;
	
	public ItemInventory(int size) {
		super(size);
		
		items = new Item[size];
	}
	
	@Override
	public void setItem(Item item, int index) {
		items[index] = item;
	}
	
	@Override
	public Item getItem(int index) {
		return items[index];
	}
	
}
