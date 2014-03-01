package library;

import java.util.Random;
import java.util.Scanner;

import monsters.*;
import character.Character;
import character.Mage;
import character.Necromancer;

public class Methods {
	
	
	private static Scanner scan;

	//Method to return the damage a mob deals 
	/*
	 * Calculation:
	 * 
	 * Get number up to the maxWeaponDmg and add 2
	 * Multiply that number by the resistance added to the multiplier divided by 2
	 */
	public static double calcDmg(int maxWeaponDmg, double resistance, double dmgMultiplier) {
		
		Random gen = new Random();
		
		int weaponDmg = gen.nextInt(maxWeaponDmg) + 2;
		
		double dmgTaken = weaponDmg * ((resistance + dmgMultiplier) / 2);
		
		return dmgTaken;
	}
	
	
	public static boolean fight(Character player) {
		
		scan = new Scanner(System.in);
		
		//Weapon weapon = player.getWeapon();
		Monster monster = player.getMonster();
		
		//Print out the monster's health and player's health
		System.out.println("The monser's health is on: " + monster.getHp()
				+ "\nYour health is on: " + player.getHealth() + "\n");
		
		//While your's and the monster's health are above zero do the fighting
		
			if (player instanceof Mage) {
				
				while (player.getHealth() > 0 && monster.getHp() > 0) {
				
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
			
			if (player instanceof Necromancer) {
				
				Attack currentAttack;
				
				System.out.println("Which zombie do you want to use (enter the number)");
				printZombies((Necromancer) player);
				int zombieIndex = scan.nextInt();
				Zombie currentZombie = chooseZombie((Necromancer) player, zombieIndex); 
				
				while (currentZombie.getHp() > 0 && monster.getHp() > 0) {
					
					if (currentZombie.getSpeed() > monster.getSpeed()) {
						currentAttack = selectAttack(currentZombie);
						monster.setHp(Methods.calcDmg(currentAttack.getDmg(), monster.getResistance(), player.getStrength()));
						currentZombie.setHealth(Methods.calcDmg(monster.getMaxDmg(), currentZombie.getStrength(), monster.getStrength()));
					}
					
					else {
						currentAttack = selectAttack(currentZombie);
						currentZombie.setHealth(Methods.calcDmg(monster.getMaxDmg(), currentZombie.getStrength(), monster.getStrength()));
						monster.setHp(Methods.calcDmg(currentAttack.getDmg(), monster.getResistance(), player.getStrength()));
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
	
	private static Attack selectAttack(Zombie zombie) {
		
		Attack[] attacks = zombie.getAttacks();
		scan = new Scanner(System.in);
		
		System.out.println("Choose the attack (enter the number):");
		
		for (int i = 0; i < attacks.length; i++) {
			System.out.println(i + ") " + attacks[i].getName());
		}
		
		int attackIndex = scan.nextInt();
		
		Attack chosenAttack = attacks[attackIndex];
		
		return chosenAttack;
	}
	
	private static void printZombies(Necromancer player) {
		
		Zombie[] zombies = player.getZombies();
		
		for (int i = 0; i < zombies.length; i++) {
			System.out.println(i + zombies[i].getName());
		}
		
	}
	
	private static Zombie chooseZombie(Necromancer player, int zombieIndex) {
		
		Zombie[] zombies = player.getZombies();
		
		Zombie zombie;
		
		if (zombieIndex > -1 && zombieIndex < zombies.length && zombies[zombieIndex] != null) {
			zombie = zombies[zombieIndex];
		} else {
			zombie = zombies[0];
		}
		
		return zombie;
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
