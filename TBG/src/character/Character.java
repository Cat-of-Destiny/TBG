package character;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import library.*;
import monsters.Monster;

public class Character {
	
	Random generator; //A random number generator
	int level;
	int health; //The character's health
	double strength; //dmg multiplier
	double resistance;
	String name; // the characters name
	HashMap Inventory;
	Biome currentBiome; //The biome the player is currently in
	Weapon weapon; //The weapon the player is using
	int speed;
	Monster monster;
	
	
	public Character(Scanner scanner) {
		//Ask the users name
		System.out.println("Enter the name for your character");
		System.out.print(">");
		name = scanner.next();
		
		//Create a random number generator
		generator = new Random();
		
		//Assign health and strength
		health = generator.nextInt(100);
		strength = generator.nextInt(2) + 1;
		
		//Create the players inventory which has 64 slots
		Inventory = new HashMap(64);
		
		//Default biome
		currentBiome = new Biome("Start", 1);
		
		//Set the level to 1
		level = 1;
		
		weapon = new Weapon("Dagger", 5, false, false);
		
		speed = generator.nextInt(10) + 1;
	}
	
	//Method to return the player's level
	public int getLevel() {
		return level;
	}
	
	//Method to return health
	public int getHealth() {
		return health;
	}
	
	//Method to return strength
	public double getStrength() {
		return strength;
	}
	
	//Method to return the name of the character
	public String getName() {
		return name;
	}
	
	//Method to return the biome the character is in
	public Biome getBiome() {
		return currentBiome;
	}
	
	//Method to get the user's weapon
	public Weapon getWeapon() {
		return weapon;
	}

	public int getSpeed() {
		return speed;
	}
	
	//Method to set the biome the player is in
	public void setBiome(Biome biome) {
		currentBiome = biome;
	}
	
	//Method to set the player's level to the parameter
	public void setLevel(int newLevel) {
		level = newLevel;
	}
	
	//Method to change the weapon
	public void setWeapon(Weapon newWeapon) {
		weapon = newWeapon;
	}
	
	//Set the monster the player is fighting
	public void setMonster(Monster fightingMonster) {
		monster = fightingMonster;
	}
	
	//Print out the essential character data
	public void printData() {
		System.out.println("Your character's name is: " + name +
				"\nYour character's weapon is: " + weapon.getName() +
				"\nYour character's health is: " + health +
				"\nYour character's strength is: " + strength +
				"\nYou are in the " + currentBiome.getName() + " biome" +
				"\nYou are level: " + level);
	}
	
	//If returns false the player lost, if true the player wins
	public boolean fight() {

		//Print out the monster's health and player's health
		System.out.println("The monser's health is on: " + monster.getHp()
				+ "\nYour health is on: " + health + "\n");
		
		//While your's and the monster's health are above zero do the fighting
		while (health > 0 && monster.getHp() > 0) {
			
			//Check who to attack first
			if (speed > monster.getSpeed()) {
				monster.setHp(monster.getHp() - (weapon.getDmg() * strength));
				health -= monster.getDealtDmg();
				System.out.println("The monser's health is on: " + monster.getHp()
						+ "\nYour health is on: " + health + "\n");
			} else {
				health -= monster.getDealtDmg();
				monster.setHp(monster.getHp() - (weapon.getDmg() * strength));
				System.out.println("The monser's health is on: " + monster.getHp()
						+ "\nYour health is on: " + health + "\n");
			}
			
		}
		
		//Check who wins
		if (health < 0) {
			return false;
		} else {
			return true;
		}
	}
}
