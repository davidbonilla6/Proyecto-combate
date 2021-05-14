import java.awt.Image;

public class Combate {

	public static void main(String[] args) {
		Weapon weapon1=new Weapon(1,"sword","image",1,1,"human",10);
		Weapon weapon2=new Weapon(1,"destral","image",0,3,"dwarf",10);
		Warrior warrior1=new Warrior(5,50,5,5,6,3,"PEPAZO","imagen",weapon1,20);
		Warrior warrior2=new Warrior(6,60,6,3,5,4,"JUANZO","imagen",weapon2,21);
		int velocidad1,velocidad2;
		velocidad1=warrior1.getSpeed()+weapon1.getSpeed();
		velocidad2=warrior2.getSpeed()+weapon2.getSpeed();
		if (velocidad1>velocidad2) {
			System.out.println("Empieza el jugador 1");
			
		}else if (velocidad1==velocidad2){
			if (warrior1.getAgility()>warrior2.getAgility()) {
				System.out.println("Empieza el jugador 1");
			}else if(warrior1.getAgility()==warrior2.getAgility()) {
				int a=(int) Math.random();
				int b=(int) Math.random();
				if (a>b) {
					System.out.println("Empieza el jugador 1");
				}else {
					System.out.println("Empieza el jugador 2");
				}
			}
		}else {
			System.out.println("Empieza el jugador 2");
		
	}
	
	}	

}
