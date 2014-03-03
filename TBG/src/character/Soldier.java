package character;

import inventories.WeaponInventory;
import items.Weapon;
import library.Arrays;

public class Soldier extends Character {
	
	Weapon currentWeapon;
	Weapon oldWeapon;
	WeaponInventory weapons;
	
	public Soldier() {
		
		super();
		
		double charHealth = generator.nextInt(100) + 150; //The health the character will have, between 150 and 249
		double charStrength = generator.nextDouble() + 1.5; //The strength multiplier of the character, between 1.5 and 2.4
		double charResistance = generator.nextDouble(); //The resistance to damage, between 0.0 and 0.9
		int charSpeed = generator.nextInt(10) + 10; //The combat speed of the character, between 10 and 19
		Weapon weapon = new Weapon(Arrays.weapons[generator.nextInt(Arrays.weapons.length)], 15, true, false);
		weapons = new WeaponInventory(9);
		
		//Assign the values to the player
		super.setHealth(charHealth);
		super.setStrength(charStrength);
		super.setResistance(charResistance);
		super.setSpeed(charSpeed);
		this.setWeapon(weapon);
		weapons.addWeapon(weapon, 0);
	}
	
	public void setWeapon(Weapon weapon) {
		this.currentWeapon = weapon;
	}
	
	public Weapon getWeapon() {
		return currentWeapon;
	}
	
	public void printWeapons() {
		
		int size = weapons.getInvSize();
		
		for (int i = 0; i < size; i++) {
			
			Weapon indexWeapon = weapons.getWeapon(i);
			
			if (indexWeapon != null) {
				System.out.println(i + ") " + indexWeapon.getName());
			}
			
		}
		
	}
	
	public WeaponInventory getWeapons() {
		return weapons;
	}

	public void addWeapon(Weapon weapon, int index) {
		weapons.addWeapon(weapon, index);
	}
	
	public void setOldWeapon(Weapon weapon) {
		oldWeapon = weapon;
	}
	
	public Weapon getOldWeapon() {
		if(oldWeapon != null) {
			return oldWeapon;
		} else {
			return currentWeapon;
		}
	}
}
