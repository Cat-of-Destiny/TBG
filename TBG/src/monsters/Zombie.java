package monsters;

import library.Attack;
import java.util.Random;

public class Zombie {
	
	Attack[] attacks; //An array of the zombies attacks
	int hp; //The zombies health
	int strength; //The resistance to fatigue the zombie has
	int speed; //The speed of the zombie
	int maxStrength; //The maximum resistance to fatigue the zombie has
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
	 * Initialises the zombies attacks
	 * @param playerLevel, the amount of attacks the zombie can have, equal to the player's level 
	 */
	private void initialiseAttacks(int playerLevel) {
		
		for (int i = 0; i < attacks.length; i++) {
			attacks[i] = new Attack(playerLevel);
		}
		
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
	public int getHp() {
		return hp;
	}
	
	/**
	 * Method to return the zombie's resistance to fatigue
	 * @return The zombie's resistance to fatigue
	 */
	public int getStrength() {
		return strength;
	}
}
