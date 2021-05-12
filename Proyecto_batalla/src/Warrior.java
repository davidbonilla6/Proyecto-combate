import java.awt.Image;
import java.net.URL;

public class Warrior {
	private int id,life,force,velocity,agility,defense;
	private String name;
	private Image image;
	private Weapon weapon;
	private int racePoints;
	public Warrior() {
		
	}
	public Warrior(int id, String name, Image image,Weapon weapon) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.weapon = weapon;
	}
	public Warrior(int id, int life, int force, int velocity, int agility, int defense, String name, Image image,
			Weapon weapon,int racePoints) {
		super();
		this.id = id;
		this.life = life;
		this.force = force;
		this.velocity = velocity;
		this.agility = agility;
		this.defense = defense;
		this.name = name;
		this.image = image;
		this.weapon = weapon;
		this.racePoints=racePoints;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getForce() {
		return force;
	}
	public void setForce(int force) {
		this.force = force;
	}
	public int getVelocity() {
		return velocity;
	}
	public void setVelocity(int velocity) {
		this.velocity = velocity;
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
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
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
		return "Warrior [id=" + id + ", life=" + life + ", force=" + force + ", velocity=" + velocity + ", agility="
				+ agility + ", defense=" + defense + ", name=" + name + ", image=" + image + ", weapon=" + weapon + "]";
	}
	
	
}
