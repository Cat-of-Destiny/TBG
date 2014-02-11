package character;

import java.util.Scanner;
import java.util.Random;
import library.Spell;
import library.Methods;

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
		
		Spell initial = new Spell("Firebolt");
		
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
	
	
	//Print out the character's essential data
	public void printData() {
		super.printData();
		System.out.println("You are a mage" +
		"\nYour spells are:");
		printSpells();
	}
	
	//Method to print out mages spells
	public void printSpells() {
		
		/*
		 * Initialisation stage
		 */
		String[] names = new String[spells.length]; //The array with the names of the spells
		int[] tabs = new int[names.length]; //An array of the amount of tabs needed for each name of the spells
		int maxLength = 0; //Largest length of characters in the names
		
		for (int i = 0; i < spells.length; i++) { //Assign the names of the spells to the array of names
			if (spells[i] != null) {
				names[i] = spells[i].getName();
			}
		}
		
		for (int i = 0; i < names.length; i++) { //Get the amount of tabs in each name
			if (names[i] != null) {
				tabs[i] = (names[i].length() / 8) + 1;
			}
		}
		
		for (int i = 0; i < tabs.length; i++) { //Get the largest amount of tabs in the names
			if (tabs[i] > maxLength) {
				maxLength = tabs[i];
			}
		}
		
		for (int i = 0; i < tabs.length; i++) { //Get the actual amount of tabs to print
			tabs[i] = (maxLength - tabs[i]) + 1;
		}
		
		/*
		 * Printing stage
		 */
		
		System.out.print("Name");
		Methods.printTabs(maxLength);
		System.out.println("ID\tDamage\tMana Cost");
		
		
		for (int i = 0; i < spells.length; i++) {
			if (spells[i] != null) {
				System.out.print(names[i]);
				Methods.printTabs(tabs[i]);
				System.out.println(i + "\t" + spells[i].getDmg() + "\t" + spells[i].getCost());
			}
		}
	}
}
