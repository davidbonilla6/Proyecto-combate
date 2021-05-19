import java.awt.Image;
import java.net.URL;

public class dwarf extends Warrior {

	public dwarf(int id, String name, Image image, Weapon weapon) {
		super(id,  name, image, weapon);
		this.setHealth(60);
		this.setStrength(6);
		this.setDefense(4);
		this.setAgility(5);
		this.setSpeed(3);
		this.setRacePoints(21);
	}
	
	
	

}
