package library;

import java.util.Random;
import character.*;
import character.Character;
import monsters.*;

public class Methods {
	
	
	//Method to return the damage a mob deals 
	public static double calcDmg(int maxWeaponDmg, double resistance, double dmgMultiplier) {
		
		Random gen = new Random();
		
		int weaponDmg = gen.nextInt(maxWeaponDmg) + 2;
		
		double dmgTaken = weaponDmg * ((resistance + dmgMultiplier) / 2);
		
		return dmgTaken;
		
	}
	
	
	public boolean fight(Character player) {
		
		//Weapon weapon = player.getWeapon();
		Monster monster = player.getMonster();
		
		//Print out the monster's health and player's health
		System.out.println("The monser's health is on: " + monster.getHp()
				+ "\nYour health is on: " + player.getHealth() + "\n");
		
		//While your's and the monster's health are above zero do the fighting
		while (player.getHealth() > 0 && monster.getHp() > 0) {
			
			if (player instanceof Mage) {
				
				//Check who to attack first
				if (player.getSpeed() > monster.getSpeed()) {
					Spell currentSpell = selectSpell(player);
					monster.setHp(Methods.calcDmg(currentSpell.getDmg(), monster.getResistance(), player.getStrength())); //Change the Monster's hp by the damage dealt
					player.setHealth(Methods.calcDmg(monster.getMaxDmg(), player.getResistance(), monster.getStrength())); //Change the player's hp by the damage dealt
				}
				
				else {
					Spell currentSpell = selectSpell(player);
					player.setHealth(Methods.calcDmg(monster.getMaxDmg(), player.getResistance(), monster.getStrength())); //Change the player's hp by the damage dealt
					monster.setHp(Methods.calcDmg(currentSpell.getDmg(), monster.getResistance(), player.getStrength())); //Change the Monster's hp by the damage dealt
				}
			
			}
		}
		
		//Check who wins
		if (player.getHealth() < 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public Spell selectSpell(Character player) {
		return new Spell("Hey", new Random());
	}
}
