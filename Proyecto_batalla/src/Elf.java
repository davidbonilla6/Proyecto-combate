import java.awt.Image;
import java.net.URL;

public class Elf extends Warrior {

	public Elf(int id, String name, Image image, Weapon weapon) {
		super(id, name, image, weapon);
		this.setHealth(40);
		this.setStrength(4);
		this.setDefense(2);
		this.setAgility(7);
		this.setSpeed(7);
		this.setRacePoints(19);
	}
	
	
	
}
