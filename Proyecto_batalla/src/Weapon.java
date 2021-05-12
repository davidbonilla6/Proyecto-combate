import java.awt.Image;

public class Weapon {
	private String name,utility;
	private Image image;
	private int velocity,force,id;
	public Weapon(String name) {
		this.name=name;
	}
	
	public Weapon(int id, String name, Image image, int velocity, int force, String utility) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.velocity = velocity;
		this.force = force;
		this.utility = utility;
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

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Weapon [name=" + name + ", utility=" + utility + ", image=" + image + ", velocity=" + velocity
				+ ", force=" + force + ", id=" + id + "]";
	}
	
}
