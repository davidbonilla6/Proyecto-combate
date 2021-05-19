import java.awt.Image;
import java.net.URL;

public class Warrior {
	private int id,health,strength,speed,agility,defense;
	private String name;
	private String image;
	private Weapon weapon;
	private int racePoints;
	public Warrior() {
		
	}
	public Warrior(int id, String name, String image,Weapon weapon) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.weapon = weapon;
	}
	public Warrior(int id, int health, int strength, int speed, int agility, int defense, String name, String image,
			Weapon weapon,int racePoints) {
		super();
		this.id = id;
		this.health = health;
		this.strength = strength;
		this.speed = speed;
		this.agility = agility;
		this.defense = defense;
		this.name = name;
		this.image = image;
		this.weapon = weapon;
		this.racePoints=racePoints;
	}
	
	public Warrior(int id, String name, int health, int strength, int speed, int agility, int defense, int racePoints) {
		super();
		this.id = id;
		this.name = name;
		this.health = health;
		this.strength = strength;
		this.speed = speed;
		this.agility = agility;
		this.defense = defense;
		this.racePoints = racePoints;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getAgility() {
		return agility;
	}
	public void setAgility(int agility) {
		this.agility = agility;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public int getRacePoints() {
		return racePoints;
	}
	public void setRacePoints(int racePoints) {
		this.racePoints = racePoints;
	}
	@Override
	public String toString() {
		return "Warrior [id=" + id +", name=" + name + ", health=" + health + ", strength=" + strength + ", speed=" + speed + ", agility="
				+ agility + ", defense=" + defense +  ", image=" + image + ", weapon=" + weapon
				+ ", racePoints=" + racePoints + "]";
	}
	
	
	
}
