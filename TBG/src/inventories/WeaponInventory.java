package inventories;

import items.Item;
import items.Weapon;

public class WeaponInventory extends BaseInventory {
	
	Weapon[] weapons;
	
	public WeaponInventory(int size) {
		super(size);
		
		weapons = new Weapon[size];
	}
	
	public int getInvSize() {
		return invSize;
	}
	
	public void addWeapon(Weapon weapon, int index) {
		this.weapons[index] = weapon; 
	}
	
	public Weapon getWeapon(int index) {
		return weapons[index];
	}
	
	@Override
	public Item getItem(int index) {
		return weapons[index];
	}
	
}
