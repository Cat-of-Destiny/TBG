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
	
	
	public static boolean fight(Character player) {
		
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
					Spell currentSpell = selectSpell((Mage) player);
					monster.setHp(Methods.calcDmg(currentSpell.getDmg(), monster.getResistance(), player.getStrength())); //Change the Monster's hp by the damage dealt
					player.setHealth(Methods.calcDmg(monster.getMaxDmg(), player.getResistance(), monster.getStrength())); //Change the player's hp by the damage dealt
				}
				
				else {
					Spell currentSpell = selectSpell((Mage) player);
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
	
	public static Spell selectSpell(Mage player) {
		
		/*
		 * Initialisation stage
		 */
		Spell[] spells = player.getSpells(); //The array of spells
		String[] names = new String[spells.length]; //The array with the names of the spells
		int[] tabs = new int[names.length]; //An array of the amount of tabs needed for each name of the spells
		int maxLength = 0; //Largest length of characters in the names
		
		for (int i = 0; i < spells.length; i++) { //Assign the names of the spells to the array of names
			if (spells[i] != null) {
				names[i] = spells[i].getName();
			}
		}
		
		for (int i = 0; i < names.length; i++) { //Get the amount of tabs in each name
			if (names[i] != null) {
				tabs[i] = (names[i].length() / 8) + 1;
			}
		}
		
		for (int i = 0; i < tabs.length; i++) { //Get the largest amount of tabs in the names
			if (tabs[i] > maxLength) {
				maxLength = tabs[i];
			}
		}
		
		for (int i = 0; i < tabs.length; i++) { //Get the actual amount of tabs to print
			tabs[i] = (maxLength - tabs[i]) + 1;
		}
		
		/*
		 * Printing stage
		 */
		
		System.out.print("Name");
		printTabs(maxLength);
		System.out.println("ID\tDamage\tMana Cost");
		
		
		for (int i = 0; i < spells.length; i++) {
			if (spells[i] != null) {
				System.out.print(names[i]);
				printTabs(tabs[i]);
				System.out.println(i + "\t" + spells[i].getDmg() + "\t" + spells[i].getCost());
			}
		}
		
		return new Spell("Hey");
	}
	
	public static void printTabs(int count) {
		
		for(int i = 0; i < count; i++) {
			System.out.print("\t");
		}
		
	}
}
