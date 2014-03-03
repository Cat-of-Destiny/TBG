package character;

import inventories.BaseInventory;

import java.util.Random;
import java.util.Scanner;

import library.*;
import monsters.Monster;

public class Character {
	
	
	int level; //The character's level
	int speed; //The character's speed in combat
	double health; //The character's health
	double strength; //dmg multiplier, the higher the better
	double resistance; //Dmg resistance, the smaller the better
	String name; // the characters name
	BaseInventory inventory; //The character's inventory, storing items
	Biome currentBiome; //The biome the player is currently is
	Monster monster; //The monster the character is currently fighting
	Scanner scanner; //A scanner for user input
	Random generator; //A random number generator
	
	
	public Character() {
		
		//Create a random number generator and a scanner
		generator = new Random();
		scanner = new Scanner(System.in);
		
		//Ask the users name
		System.out.println("Enter the name for your character");
		System.out.print(">");
		name = scanner.next();
		
		//Assign health and strength
		health = generator.nextInt(100) + 50;
		strength = generator.nextDouble() + 0.5;
		
		//Set the resiatance and the speed
		resistance = generator.nextDouble() + 1.0;
		speed = generator.nextInt(10) + 1;
		
		inventory = new BaseInventory(64); //Create the players inventory which has 64 slots
		currentBiome = new Biome("Start", 1); //Default biome
		level = 1; //Set the level to 1
		
		
	}
	
	@Deprecated
	public Character(String name, double health, double strength, int speed, double resistance) {
		
		//Create a random number generator and a scanner
		generator = new Random();
		scanner = new Scanner(System.in);
		
		this.name = name; //Sets the users name
		
		//Assign health and strength
		this.health = health;
		this.strength = strength;
		
		//Set resistance and speed
		resistance = generator.nextDouble() + 1.0;
		speed = generator.nextInt(10) + 1;
		
		inventory = new BaseInventory(64); //Create the players inventory which has 64 slots
		currentBiome = new Biome("Start", 1); //Default biome
		level = 1; //Set the level to 1
		
		
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
	
	//Return the monster that is currently being fought
	public Monster getMonster() {
		return monster;
	}

	//Return the combat speed of the current character
	public int getSpeed() {
		return speed;
	}
	
	//Return the resistance of the character
	public double getResistance() {
		return resistance;
	}
	
	//Method to set the player's level to the parameter
	public void setLevel(int newLevel) {
		this.level = newLevel;
	}
	
	//Set the current speed of the player
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	//Set the current health of the player
	//Method to set the player's health
	public void setHealth(double newHealth) {
		this.health = newHealth;
	}
	
	//Set the strength of the character
	public void setStrength(double strength) {
		this.strength = strength;
	}
	
	//Set the resistance of the character
	public void setResistance(double resistance) {
		this.resistance = resistance;
	}
	
	//Set the name of the character
	public void setName(String name) {
		this.name = name;
	}
	
	//Set the biome the player is currently in
	//Method to set the biome the player is in
	public void setBiome(Biome biome) {
		this.currentBiome = biome;
	}
	
	//Set the monster that the character is currently fighting
	//Set the monster the player is fighting
	public void setMonster(Monster fightingMonster) {
		this.monster = fightingMonster;
	}
	
	//Print out the essential character data 
	//Print out the essential character data
	public void printData() {
		System.out.println("Your character's name is: " + name +
				"\nYour character's health is: " + health +
				"\nYour character's strength is: " + strength +
				"\nYou are in the " + currentBiome.getName() + " biome" +
				"\nYou are level: " + level);
	}

}
