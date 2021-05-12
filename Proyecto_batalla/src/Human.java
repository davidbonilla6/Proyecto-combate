import java.awt.Image;
import java.net.URL;

public class Human extends Warrior {

	public Human(int id, String name, Image image, Weapon weapon) {
		super(id, name, image, weapon);
		this.setLife(50);
		this.setForce(5);
		this.setDefense(3);
		this.setAgility(6);
		this.setVelocity(5);
		this.setRacePoints(20);
	}
	
	
	

}
