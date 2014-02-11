package character;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import library.*;
import monsters.Monster;

public class Character {
	
	Random generator; //A random number generator
	int level;
	double health; //The character's health
	double strength; //dmg multiplier
	double resistance; //Dmg resistance
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
		strength = generator.nextDouble() + 0.5;
		
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
	public double getHealth() {
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
	
	public Monster getMonster() {
		return monster;
	}

	public int getSpeed() {
		return speed;
	}
	
	public double getResistance() {
		return resistance;
	}
	
	//Method to set the player's health
	public void setHealth(double newHealth) {
		health = newHealth;
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
}
