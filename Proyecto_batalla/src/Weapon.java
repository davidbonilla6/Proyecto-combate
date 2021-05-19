import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Weapon {
	private String name,utility;
	private String image;
	private int speed,power,id,weaponPoints;
	public Weapon() {
		
	}
	public Weapon(String name) {
		this.name=name;
	}
	
	public Weapon(int id, String name, String image, int speed, int power, String utility,int weaponPoints) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.speed = speed;
		this.power = power;
		this.utility = utility;
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
		this.speed = speed;
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
		return "Weapon [id=" + id + ", name=" + name + ", image="+ image+", speed="+ speed + ", power=" + power + ", utility=" + utility +", weaponPoints=" + weaponPoints+  "]";
	}

	
	
}
