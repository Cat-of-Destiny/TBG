package library;

import java.util.Random;

public class Weapon {

	Random gen;
	String name;
	int dmg;
	boolean isBroken;
	
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
