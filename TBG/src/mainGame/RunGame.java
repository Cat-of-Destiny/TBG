package mainGame;

import java.util.Random;
import java.util.Scanner;

import character.Mage;
import character.Character;
import character.Soldier;
import character.Alchemist;
import library.*;
//import monsters.Monster;

public class RunGame {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random gen = new Random();
		
		/*
		 * Menu Phase
		 */
		//while this is 0 the user will be asked what to do
		int condition = mainMenu(0, scan);
		
		
		/*
		 * Game Phase
		 */
		if (condition == 1) { //Based on the "condition" either display "how to play and rules" or play the game
			
			int charRef = selectCharacter(scan); //Get which class the user wants to be
			
			if (charRef == 1) { //If they selected mage, play as mage
				prePlay("Mage", scan, gen);
			} else if (charRef == 2) { //If they selected Alchemist, play as alchemist
				prePlay("Alchemist", scan, gen);
			} else { //If they selected soldier or it bugged, play as soldier
				prePlay("Soldier", scan, gen);
			}
			
			
		} 
		
		
		/*
		 * Rules Phase
		 */
		else { //Print out the rules of the game
			
			printRules();
			
		}
		
	}
	
	public static void prePlay(String charType, Scanner scan, Random gen) {
		
		if (charType == "Mage") {
			Mage player = new Mage();
			
			play(scan, player, gen);
		}
		
		else if (charType == "Alchemist") {
			Alchemist player = new Alchemist();
			
			play(scan, player, gen);
		}
		
		else {
			Soldier player = new Soldier();
			
			play(scan, player, gen);
		}
		
	}
	
	private static void play(Scanner scan, Character player, Random gen) {
		chooseBiome(scan, player, gen); //Get the player to select a starting biome
		System.out.println("\n\n\n\n\n\n");
		player.printData(); //Print out the character's stats
		
		/*
		 * Playing
		 */
		
		String currentPlace = Arrays.places[gen.nextInt(Arrays.places.length)];
		
		System.out.println("\n\n\n\n\n\n" + "Over on the horizon you see a " + currentPlace + 
				"\nDo you wish to go there (1 or 2)?"
				+ "\n1) Yes"
				+ "\n2) No");
		int option = scan.nextInt();
		
		/*
		 * Go to first place
		 */
		
		String[] mob = getMonster(player, gen); //Return a string with the plural and singular forms of a monster for the current biome, index 0: singular, index 1: plural
		
		if (option == 1) { //If they chose to go to the place on the horizon
			System.out.println("You went to the " + currentPlace + " and found " + 
							    Arrays.placesDeserted[gen.nextInt(Arrays.placesDeserted.length)] + mob[1]);
			
		} else {
			System.out.println(option);
		}
	}
	
	//Choose the player's class and character
	private static int selectCharacter(Scanner scan) {
		
		System.out.println("Which class would you like to be (enter the number): " +
		"\n1) Mage" +
		"\n2) Alchemist" +
		"\n3) Soldier");
		
		int option = scan.nextInt(3);
		
		return option;
	}
	
	//The main menu, where the player selects what to do
	private static int mainMenu(int condition, Scanner scan) {
		//Check if the selected option is valid, if true then skip straight to the return statement else run through the selection process
		if (condition == 0) {
			System.out.println("What do you want to do? "
					+ "\n1) Start playing "
					+ "\n2) Read the rules");
			System.out.print(">");
			
			int option = scan.nextInt();
				
			switch (option) {
			case 1:
				return 1;
			case 2:
				return 2;
			default: 
				return 0;
			}
		}
		
		//Recursively use it to select the mode
		while (condition == 0) {
			condition = mainMenu(condition, scan);
		}
		
		//Once valid return the mode
		return condition;
	}
	
	//Print out the rules of the game (unfinished)
	public static void printRules() {
		System.out.println("These will be the rules!");
	}
	
	//Get the player to select a starting biome
	public static void chooseBiome(Scanner scan, Character player, Random generator) {
		
		System.out.println("Select your biome (enter the number): \n");
		Biome[] startBiomes = new Biome[5];
		
		for(int i = 0; i < startBiomes.length; i++) {
			int selection = generator.nextInt(Arrays.biomes.length);
			startBiomes[i] = new Biome(selection, player.getLevel());
		}
		
		int j = 0;
		for(Biome biome: startBiomes) {
			System.out.println("Option " + j + ":"
					+ "\nThe biome is a : " + biome.getName()
					+ "\nThe difficulty of the biome is: " + biome.getDifficulty()
					+ "\nThe chances of getting better loot: " + biome.getLoot() + "\n");
			j++;
		}
		
		System.out.print("Your Selection: ");
		int selection = scan.nextInt();
		if (selection < startBiomes.length) {
			player.setBiome(startBiomes[selection]);
		} else {
			player.setBiome(startBiomes[0]);
		}
		
	}
	
	public static String[] getMonster(Character player, Random gen) {
		
		Biome biome = player.getBiome();
		String biomeName = biome.getName();
		String[] monsters = new String[2];
		
		for (int i = 0; i < Arrays.biomes.length; i++) {
			
			if (biomeName == Arrays.biomes[i]) {
				
				monsters[0] = Arrays.monstersSing[i][gen.nextInt(Arrays.monstersSing[i].length)];
				monsters[1] = Arrays.monstersPlural[i][gen.nextInt(Arrays.monstersPlural[i].length)];
				
				return monsters;
			}
			
		}
		
		return monsters;
	}
}
