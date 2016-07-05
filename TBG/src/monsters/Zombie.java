package monsters;

import library.Attack;
import java.util.Random;

public class Zombie {
	
	Attack[] attacks; //An array of the zombies attacks
	double hp; //The zombies health
	int strength; //The resistance to fatigue the zombie has
	int speed; //The speed of the zombie
	int maxStrength; //The maximum resistance to fatigue the zombie has
	double resistance; //The zombies resistance to damage
	String name; //The name of the zombie
	
	/**
	 * Zombie Constructor for necromancer
	 * @param name, the name of the zombie
	 * @param speed, the combat speed of the zombie
	 * @param hp, the health of the zombie
	 * @param playerLevel, the player's level
	 */
	public Zombie(String name, int speed, int hp, int playerLevel) {
		
		Random gen = new Random();
		attacks = new Attack[playerLevel];
		initialiseAttacks(playerLevel);
		this.hp = hp;
		this.speed = speed;
		this.maxStrength = gen.nextInt(playerLevel / 2) + 1;
		this.name = name;
		
	}
	
	/**
	 * Initialises the zombie's attacks
	 * @param playerLevel, the amount of attacks the zombie can have, equal to the player's level 
	 */
	private void initialiseAttacks(int playerLevel) {
		
		for (int i = 0; i < attacks.length; i++) {
			attacks[i] = new Attack(playerLevel);
		}
		
	}
	
	/**
	 * Method to return the zombie's speed
	 * @return the zombie's speed
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * Method to return the name of the zombie
	 * @return the name of the zombie
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Method to return the attacks the zombie has
	 * @return an array of the attacks the zombie has
	 */
	public Attack[] getAttacks() {
		return attacks;
	}
	
	/**
	 * Method to return the zombie's hp
	 * @return the zombie's current hp 
	 */
	public double getHp() {
		return hp;
	}
	
	/**
	 * Method to return the zombie's resistance to fatigue
	 * @return The zombie's resistance to fatigue
	 */
	public int getStrength() {
		return strength;
	}
	
	/**
	 * Method to set health of Zombie
	 * @param newHealth, the new health for the zombie
	 */
	public void setHealth(double newHealth) {
		hp = newHealth;
	}
}
