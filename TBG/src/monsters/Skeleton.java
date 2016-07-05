package monsters;

import java.util.Random;

import library.Attack;

public class Skeleton {

	Attack[] attacks; //An array of the zombies attacks
	double hp; //The zombies health
	int strength; //The resistance to fatigue the zombie has
	int speed; //The speed of the zombie
	int maxStrength; //The maximum resistance to fatigue the zombie has
	double resistance; //The zombies resistance to damage
	String name; //The name of the zombie
	
	/**
	 * SKELETON Constructor for necromancer
	 * @param name, the name of the zombie
	 * @param speed, the combat speed of the zombie
	 * @param hp, the health of the zombie
	 * @param playerLevel, the player's level
	 */
	public Skeleton(String name, int speed, int hp, int playerLevel) {
		
		Random gen = new Random();
		attacks = new Attack[playerLevel];
		initialiseAttacks(playerLevel);
		this.hp = hp;
		this.speed = speed;
		this.maxStrength = gen.nextInt(playerLevel / 2) + 1;
		this.name = name;
		
	}
	
	/**
	 * Initialises the skeleton's attacks
	 * @param playerLevel, the amount of attacks the skeleton can have, equal to the player's level 
	 */
	private void initialiseAttacks(int playerLevel) {
		
		for (int i = 0; i < attacks.length; i++) {
			attacks[i] = new Attack(playerLevel);
		}
		
	}
	
}
