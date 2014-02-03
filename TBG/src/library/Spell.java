package library;

import java.util.Random;

public class Spell {
	
	String name; //Name of Spell
	int dmg; //The spell's damage
	int manaCost; //The cost to cast the spell
	
	public Spell(String spellName, Random gen) {
		name = spellName; //Set the spell name
		
		int damage = gen.nextInt(3) + 2; //Set the spell damage
		dmg = damage;
		manaCost = damage - 1; //The spell cost is one less than the damage
	}
	
	//Return the name of the spell
	public String getName() {
		return name;
	}
	
	//Return the damage of the spell
	public int getDmg() {
		return dmg;
	}
	
	//Return the mana cost of the spell
	public int getCost() {
		return manaCost;
	}
}
