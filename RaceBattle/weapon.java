package RaceBattle;


public class weapon {
	private String name,utility;
	private String image;
	private int speed,power,id,weaponPoints;
	public weapon() {
		
	}
	public weapon(String name) {
		this.name=name;
	}
	
	public weapon(int id, String name, String image, int power, int speed, int weaponPoints) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.speed = speed;
		this.power = power;
		this.weaponPoints = weaponPoints;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUtility() {
		return utility;
	}

	public void setUtility(String utility) {
		this.utility = utility;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int velocity) {
		this.speed = velocity;
	}

	public int getStrength() {
		return power;
	}

	public void setStrength(int power) {
		this.power = power;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public int getWeaponPoints() {
		return weaponPoints;
	}

	public void setWeaponPoints(int weaponPoints) {
		this.weaponPoints = weaponPoints;
	}

	@Override
	public String toString() {
		return "Weapon [id=" + id + ", name=" + name +", speed="+ speed + ", power=" + power +", weaponPoints=" + weaponPoints+  "]";
	}

	
	
}