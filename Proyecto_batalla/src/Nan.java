import java.awt.Image;
import java.net.URL;

public class Nan extends Warrior {

	public Nan(int id, String name, Image image, Weapon weapon) {
		super(id,  name, image, weapon);
		this.setLife(60);
		this.setForce(6);
		this.setDefense(4);
		this.setAgility(5);
		this.setVelocity(3);
		this.setRacePoints(21);
	}
	
	
	

}
