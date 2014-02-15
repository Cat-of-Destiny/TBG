package character;

import monsters.Zombie;

public class Necromancer extends Character{
	
	Zombie[] zombies;
	
	
	/**
	 * Necromancer constructor
	 */
	public Necromancer() {
		super();
		
		zombies = new Zombie[5]; //The zombie's the necromancer can use
		zombies[0] = new Zombie("Rat", 3, 20, 1);
		
	}
	
	public Zombie[] getZombies() {
		return zombies;
	}
	
}
