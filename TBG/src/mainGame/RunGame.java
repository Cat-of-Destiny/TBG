package mainGame;

import java.util.Random;
import java.util.Scanner;
import character.Character;
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
			
			/*
			 * Character creation
			 */
			Character player = new Character(scan); //Create a character
			chooseBiome(scan, player, gen); //Get the player to select a starting biome
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
			
			String[] mob = getMonster(player, gen);
			if (option == 1) {
				System.out.println("You went to the " + currentPlace + " and found " + 
								    Arrays.placesDeserted[gen.nextInt(Arrays.placesDeserted.length)] + mob[1]);
				
			} else {
				System.out.println(option);
			}
			
			
		} 
		
		
		/*
		 * Rules Phase
		 */
		else { //Print out the rules of the game
			
			printRules();
			
		}
		
	}
	
	//The main menu, where the player selects what to do
	public static int mainMenu(int condition, Scanner scan) {
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
