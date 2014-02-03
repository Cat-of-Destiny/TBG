package character;

import java.util.Scanner;
import java.util.Random;
import library.Spell;

public class Mage extends Character {
	
	Spell[] spells; //The array of the character's spells
	int mana; //The current amount of mana a player has
	int maxMana; //The maximum mana a player can have
	
	public Mage() {
		super(new Scanner(System.in)); //Create the default Character
		
		spells = new Spell[9]; //Create the array of nine spells
		
		initialSpell(new Random()); //Create the inital spell
	}
	
	//Create the initial spell
	private void initialSpell(Random gen) {
		
		Spell initial = new Spell("Firebolt", gen);
		
		spells[0] = initial;
		
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
	
	//Print out the spells
	public void printSpells() {
		
		for (int i = 0; i < spells.length; i++) {
			if (spells[i] != null) {
				System.out.println(i + ") " + spells[i].getName());
			}
		}
		
	}
	
	//Print out the character's essential data
	public void printData() {
		super.printData();
		System.out.println("You are a mage" +
		"\nYour spells are:");
		printSpells();
	}
	
}
