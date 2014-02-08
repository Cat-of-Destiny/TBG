package library;

import java.util.Random;

public class Methods {
	
	
	//Method to return the damage a mob deals 
	public double calcDmg(int maxWeaponDmg, double resistance, double dmgMultiplier) {
		
		Random gen = new Random();
		
		int weaponDmg = gen.nextInt(maxWeaponDmg) + 2;
		
		double dmgTaken = weaponDmg * ((resistance + dmgMultiplier) / 2);
		
		return dmgTaken;
		
	}
	
}
