package library;

import java.util.Random;

public class Biome {
	
	Random generator;
	String name;
	int difficulty;
	double loot;
	
		public Biome(int selection, int playerLevel) {
		generator = new Random();
		
		//Check the biome name selection is inside the arrays boundaries, if not get the first element of the array
		if (selection < Arrays.biomes.length) {
			name = Arrays.biomes[selection]; //The name of the biome
		} else {
			name = Arrays.biomes[0];
		}
		
		//Generate the difficulty of the biome
		int random = generator.nextInt(3);
		difficulty = (random - 1) + playerLevel;
		
		//Create a playerLevel weight for the algorithm to make more loot on the higher the difficulty and the higher the player level
		double positivePlayerLevel = generator.nextInt(playerLevel);
		
		if (positivePlayerLevel < 0) {
			positivePlayerLevel *= -0.5;
		} else if (positivePlayerLevel == 0) {
			positivePlayerLevel = 0.25;
		}
		
		//Use the algorithm explained above
		loot = ((double)difficulty * 0.25) * (positivePlayerLevel);
	}
	
	public Biome(String biomeName, int playerLevel) {
		generator = new Random();
		
		//Set the name of the biome to the inputed string
		name = biomeName;
		
		//Generate the difficulty of the biome
		int random = generator.nextInt(3);
		difficulty = (random - 1) + playerLevel;
		
		//Create a playerLevel weight for the algorithm to make more loot on the higher the difficulty and the higher the player level
		double positivePlayerLevel = generator.nextInt(playerLevel);
		
		if (positivePlayerLevel < 0) {
			positivePlayerLevel *= -0.5;
		} else if (positivePlayerLevel == 0) {
			positivePlayerLevel = 0.25;
		}
		
		//Use the algorithm explained above
		loot = ((double)difficulty * 0.25) * (positivePlayerLevel);
	}
	
	public double getLoot() {
		return loot;
	}
	
	public int getDifficulty() {
		return difficulty;
	}
	
	public String getName() {
		return name;
	}
	
	public static void main(String[] args) {
		Random gen = new Random(); 
		Biome[] biomes = new Biome[10];
		
		for(int i = 0; i < biomes.length; i++) {
			biomes[i] = new Biome(gen.nextInt(Arrays.biomes.length), (gen.nextInt(10) + 1));
		}
		
		int i = 0;
		for(Biome biome: biomes) {
			System.out.println("\n" + i + " Loot: " + biome.getLoot() + 
					"\n" + i + " Difficulty: " + biome.getDifficulty() +
					"\n" + i + " Name: " + biome.getName());
			i++;
		}
	}
}
