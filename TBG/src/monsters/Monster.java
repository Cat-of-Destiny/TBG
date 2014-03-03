package monsters;

import java.util.Random;

public class Monster {
	
	Random generator; //A pseudo-random number generator
	double hp; //Monster's health
	double strength; //The damage mulitplier of the Monster
	double resistance; //The Monsters resistance multiplier
	int dmgMax; //The maximum damage the Monster can deal
	int speed; //The Monster's speed
	String name; //The name of the monster

	
	//Monster constructor, creates a monster with the name monsterName and with speed monsterSpeed
	public Monster(String monsterName, int monsterSpeed) {
		generator = new Random(); //Create the number generator
		
		//TODO Fix hp should be 10
		hp = generator.nextInt(100); //Assign how much health the Monster has
		
		dmgMax = generator.nextInt(4) + 1; //Assign the maximum damage
		
		//Calculate strength and resistance
		strength = generator.nextDouble() + 0.5;
		resistance = generator.nextDouble() + 0.5;
		
		name = monsterName; //Set the Monster's name
		
		speed = monsterSpeed; //Set the Monster's speed
		
	}
	
	//Method to return the Monster's current health
	public double getHp() {
		return hp;
	}
	
	//Method to return the Monster's speed
	public int getSpeed() {
		return speed;
	}
	
	//Method to return the Monster's resistance
	public double getResistance() {
		return resistance;
	}
	
	//Return the maximum damage of the Monster
	public int getMaxDmg() {
		return dmgMax;
	}
	
	//Method to return the Monster's strength
	public double getStrength() {
		return strength;
	}
	
	//Method to set the Monster's health
	public void setHp(double newHp) {
		hp = newHp;
	}
}
