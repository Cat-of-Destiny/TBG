package library;

public class Arrays {
	
	//Except biome try to make these begin with a capital letter, otherwise "a Axe" might be a thing!
	
	//Places for the character to be
	public static String[] biomes = {"Plains", "Swamp", "Mountain", "Island", "Forest"};
	public static String[] places = {"House", "Hut", "Tower", "Marsh", "Mine"};
	public static String[] placesDeserted = {"it crawling with ", "a group of ", "a pub full of ", "a grand meeting of the "};
	
	//Adjectives
	public static String[] goodAdjectives = {"Legendary", "Totally Awesome", "Gold-Lined", "Glowing", "Cherished"};
	public static String[] badAdjectives = {"Vile", "Caustic", "Foul", "Distasteful", "Nauseating"};
	
	//Weapons for the character
	public static String[] weapons = {"Double-edged sword", "Battle-Axe", "Long-Bow", "Dagger", "Broadsword"};
	
	//Different monsters for each biome
	public static String[][] monstersSing = {{"Glowing Spirit", "Field-Orc", "Purified Thought", "White Wizard", "Knight of justice"}, //Plains
											{"Bloodsucking Vampire", "Disembodied Zombie", "Necromancer", "Black Wizard", "Knight of the dead"}, //Swamp
											{"Hobgoblin", "Fire Ghost", "Wrecking Troll", "Pyromatic Wizard", "Knight of the flames"}, //Mountains
											{"Sea dragon", "Aquatic Horse", "Serpent of Illusion", "Water Mage", "Knight of the sea"}, //Island
											{"Primeval Troll", "Fungal Oak", "Festering Maggot", "Growth Mage", "Knight of the living"}}; //Forest
	
	public static String[][] monstersPlural = {{"Glowing Spirits", "Field-Orcs", "Purified Thoughts", "White Wizards", "Knights of justice"}, //Plains
											  {"Bloodsucking Vampires", "Disembodied Zombies", "Necromancers", "Black Wizards", "Knights of the dead"}, //Swamp
											  {"Hobgoblins", "Fire Ghosts", "Wrecking Trolls", "Pyromatic Wizards", "Knights of the flames"}, //Mountains
											  {"Sea dragon", "Aquatic Horses", "Serpents of Illusion", "Water Mages", "Knights of the sea"}, //Island
											  {"Primeval Trolls", "Fungal Oaks", "Festering Maggots", "Growth Mages", "Knights of the living"}}; //Forest
	
	public static String[] attackNames = {"Take Down", "Crescent Kick", "Body Slam", "Tackle", "Triple Kick"};
}
