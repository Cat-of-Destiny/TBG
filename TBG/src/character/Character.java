package character;

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
	Inventory inventory;
	Biome currentBiome; //The biome the player is currently in
	int speed;
	Monster monster;
	Scanner scanner;
	
	
	public Character() {
		
		scanner = new Scanner(System.in);
		
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
		inventory = new Inventory(64);
		
		//Default biome
		currentBiome = new Biome("Start", 1);
		
		//Set the level to 1
		level = 1;
		
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
	
	//Set the monster the player is fighting
	public void setMonster(Monster fightingMonster) {
		monster = fightingMonster;
	}
	
	//Print out the essential character data
	public void printData() {
		System.out.println("Your character's name is: " + name +
				"\nYour character's health is: " + health +
				"\nYour character's strength is: " + strength +
				"\nYou are in the " + currentBiome.getName() + " biome" +
				"\nYou are level: " + level);
	}
}
