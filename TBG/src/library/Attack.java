package library;

import java.util.Random;

public class Attack {
	
	Random gen;
	int dmg; //The damage of the attack
	String name; //The name of the attack
	int fatigue; //How much will the user be fatigued by using the attack
	
	
	public Attack(int level) {
		
		gen = new Random(); //New random number generator
		this.name = Arrays.attackNames[gen.nextInt(Arrays.attackNames.length)]; //The name of the attack
		dmg = gen.nextInt(level * 6); //The damage of the attakc
		fatigue = ((dmg / 2) / (gen.nextInt(3) + 1)) + 1; //How much it tires the user
		
	}

	
	//Return the damage
	public int getDmg() {
		return dmg;
	}
	
	//Return the Name
	public String getName() {
		return name;
	}
	
	//Return the fatigue factor
	public int getFatigue() {
		return fatigue;
	}
}
