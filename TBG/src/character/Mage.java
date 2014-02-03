package character;

import java.util.Scanner;
import java.util.Random;
import library.Spell;

public class Mage extends Character {
	
	Spell[] spells; //The array of the character's spells
	int mana; //The current amount of mana a player has
	int maxMana; //The maximum mana a player can have
	String testCommit;
	
	public Mage() {
		super(new Scanner(System.in)); //Create the default Character
		
		spells = initialSpell(spells, new Random()); //Create the inital spell
	}
	
	//Create the initial spell
	private Spell[] initialSpell(Spell[] spells, Random gen) {
		
		Spell initial = new Spell("Firebolt", gen);
		
		spells[0] = initial;
		
		return spells;
	}
	
	//Return the spells
	public Spell[] getSpells() {
		return spells;
	}
	
	//Add a spell to the player, the overwrite is which spell to overwrite
	public void addSpell(Spell spell, int overwrite) {
		spells[overwrite] = spell;
	}
	
	//Add a spell at index 0
	public void addSpell(Spell spell) {
		spells[0] = spell;
	}
	
	//Set the player's current maximum mana
	public void setMaxMana(int mana) {
		maxMana = mana;
	}
}
