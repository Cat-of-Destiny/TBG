package monsters;
import java.util.Random;

public class Monster {
	
	Random generator;
	int hp;
	int dmgMin;
	int dmgMax;
	int speed;
	String name;
	
	public Monster(String monsterName, int monsterSpeed) {
		generator = new Random();
		
		hp = generator.nextInt(10);
		
		dmgMin = generator.nextInt(2);
		dmgMax = (3 - dmgMin) + 1;
		
		name = monsterName;
		
		speed = monsterSpeed;
		
	}
	
	public int getHp() {
		return hp;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getDealtDmg() {
		int dmg = (generator.nextInt(dmgMax) + 1);
		
		if (dmg < dmgMin) {
			dmg = dmgMin;
		}

		return dmg;
	}
	
	public void setHp(int newHp) {
		hp = newHp;
	}
}
