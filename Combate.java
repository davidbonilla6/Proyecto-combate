import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

public class Combate {

	public static void main(String[] args) {
		Weapon weapon1=new Weapon(1,"sword","image",1,1,"human",10);
		Weapon weapon2=new Weapon(1,"destral","image",0,3,"dwarf",10);
		Warrior atacante=new Warrior(5,50,5,5,6,3,"PEPAZO", "img",weapon1,20);
		Warrior defensor=new Warrior(6,60,6,3,5,4,"JUANZO","img",weapon2,21);
		Warrior transicion=new Warrior();
		int turnos=0;
		int velocidad1,velocidad2,ataque;
		velocidad1=atacante.getSpeed()+weapon1.getSpeed();
		velocidad2=defensor.getSpeed()+weapon2.getSpeed();
		boolean a1;
		
		
		
		
		if (velocidad1>velocidad2) {
			System.out.println("Empieza el jugador 1");
			a1=true;
			
		}else if (velocidad1==velocidad2){
			if (atacante.getAgility()>defensor.getAgility()) {
				System.out.println("Empieza el jugador 1");
				a1=true;
				
			}else if(atacante.getAgility()==defensor.getAgility()) {
				int a=(int) Math.random();
				int b=(int) Math.random();
				if (a>b) {
					System.out.println("Empieza el jugador 1");
					a1=true;
				}else {
					System.out.println("Empieza el jugador 2");
					a1=false;
				}
			}
		}else {
			System.out.println("Empieza el jugador 2");
			a1=false;
		
	}
		do {		
		if (a1=true) {
			
				System.out.println("Turno del jugador 1");
				Random r=new Random();
				int valorRandom= r.nextInt(100);
				if ((atacante.getAgility()*10)>valorRandom) {
					System.out.println("Ataque lanzado");
					valorRandom= r.nextInt(50);
					if ((defensor.getAgility())<valorRandom) {
						
							ataque=(atacante.getStrength()+weapon1.getStrength()-defensor.getDefense());
							System.out.println("El defensor ha rebut "+ataque+"punts de dany.");
							defensor.setHealth(defensor.getHealth()-ataque);
							System.out.println("Warrior1: "+ atacante.getHealth());
							System.out.println("Warrior2: "+ defensor.getHealth());
					}
				}
					
				else {
					System.out.println("El defensor evita el ataque");
					System.out.println("Has fallado el ataque");
					
					valorRandom= r.nextInt(100);
				
					if ((velocidad1-velocidad2)*10<valorRandom ) {
//						System.out.println("Turno del jugador 2");
//						System.out.println(transicion.toString());
//						System.out.println(atacante.toString());
//						System.out.println(defensor.toString());
						transicion=defensor;
						defensor=atacante;
						atacante=transicion;
//						System.out.println(transicion.toString());
//						System.out.println(atacante.toString());
//						System.out.println(defensor.toString());
						turnos++;
						System.out.println("Cambio de turno");
						System.out.println("Turno "+turnos);
						
					}
					
				}
				if (atacante.getHealth()<=0 || defensor.getHealth()<=0) {
					a1=false;
				}
				
			
			
		
		
	
		}}while ( a1==true);
	
}
}
