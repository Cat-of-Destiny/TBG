package items;

import java.util.Random;

import library.Arrays;

public class Weapon {

	Random gen;
	String name;
	int dmg;
	boolean isBroken;
	
	/**
	 * Constructor for a weapon, used by Soldier class and Monster class
	 * 
	 * @param typeOfWeapon, what the weapon is, i.e. Dagger, Axe
	 * @param maxDmg, The most damage this weapon can do
	 * @param goodWeapon, should this weapon have a good adjective (e.g. Awesome, amazing) if true then it gets a good prefix
	 * @param broken, if the weapon is broken
	 */
	public Weapon(String typeOfWeapon, int maxDmg, boolean goodWeapon, boolean broken) {
		
		gen = new Random();
		
		if (goodWeapon) {
			name = Arrays.goodAdjectives[gen.nextInt(Arrays.goodAdjectives.length)] + " " + typeOfWeapon;
		} else {
			name = Arrays.badAdjectives[gen.nextInt(Arrays.goodAdjectives.length)] + " " + typeOfWeapon;
		}
		
		dmg = gen.nextInt(maxDmg);
		
		isBroken = broken;
	}
	
	public int getDmg() {
		return dmg;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isBroken() {
		return isBroken;
	}
	
	public void setDmg(int newDmg) {
		dmg = newDmg;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public void setBroken(boolean broken) {
		isBroken = broken;
	}
}