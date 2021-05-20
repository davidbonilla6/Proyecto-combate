/*package RaceBattle;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class combat {

	public static void main(String[] args) {
		weapon weapon1=new weapon(1,"sword","image",1,1,"human",10);
		weapon weapon2=new weapon(1,"destral","image",0,3,"dwarf",10);		
		warrior atackWarrior=new warrior(5,50,5,5,6,3,"PEPAZO", "img",weapon1,20);
		warrior defenseWarrior=new warrior(6,60,6,3,5,4,"JUANZO","img",weapon2,21);
		warrior transicion=new warrior();
		int turnos=1;
		int velocidad1,velocidad2,ataque;
		velocidad1=atackWarrior.getSpeed()+weapon1.getSpeed();
		velocidad2=defenseWarrior.getSpeed()+weapon2.getSpeed();
		boolean a1;
		boolean a2;
		int injuries_caused=0;
		int injuries_suffered=0;
		int battle_points;



		//Escoger quien empieza
		if (velocidad1>velocidad2) {
			System.out.println("Empieza el jugador 1");
			a1=true;

		}else if (velocidad1==velocidad2){
			if (atackWarrior.getAgility()>defenseWarrior.getAgility()) {
				System.out.println("Empieza el jugador 1");
				a1=true;

			}else if(atackWarrior.getAgility()==defenseWarrior.getAgility()) {
				int a=(int) Math.random();
				int b=(int) Math.random();
				if (a>b) {
					System.out.println("Empieza el jugador 1");
					a1=true;
				}else {
					System.out.println("Empieza el jugador 2");
					a2=true;
				}
			}
		}else {
			System.out.println("Empieza el jugador 2");
			a2=true;

	}
		//Start Battle
		do {		
		if (a1=true) {
				Random r=new Random();
				int valorRandom= r.nextInt(100);
				if ((atackWarrior.getAgility()*10)>valorRandom) {
					System.out.println("Ataque lanzado");
					valorRandom= r.nextInt(50);
					if ((defenseWarrior.getAgility())<valorRandom) {						
							ataque=(atackWarrior.getStrength()+weapon1.getStrength()-defenseWarrior.getDefense());
							if(turnos%2!=0) {
								injuries_caused = injuries_caused + ataque;
							}
							else {
								injuries_suffered = injuries_suffered + ataque;
							}

							System.out.println("El defensor ha rebut "+ataque+"punts de dany.");
							defenseWarrior.setHealth(defenseWarrior.getHealth()-ataque);
							if (atackWarrior.getHealth()<=0) {
								atackWarrior.setHealth(0);
							}
							if (defenseWarrior.getHealth()<=0) {
								defenseWarrior.setHealth(0);
							}
							System.out.println(atackWarrior.getName()+": "+ atackWarrior.getHealth());
							System.out.println(defenseWarrior.getName()+": "+ defenseWarrior.getHealth());
					}
				}					
				else {
					System.out.println("El defensor evita el ataque");
					System.out.println("Has fallado el ataque");				
					valorRandom= r.nextInt(100);	
				}
				if ((velocidad1-velocidad2)*10<valorRandom ) {
					// Cambio de turno				
					transicion=defenseWarrior;
					defenseWarrior=atackWarrior;
					atackWarrior=transicion;
					turnos++;						
					System.out.println("Cambio de turno");
					Scanner sc=new Scanner(System.in);
					sc.nextLine();
					System.out.println("Turno "+turnos);		
					}				

				if (atackWarrior.getHealth()<=0 || defenseWarrior.getHealth()<=0) {
					if (atackWarrior.getHealth()>defenseWarrior.getHealth()) {

						System.out.println("HA GANADO "+atackWarrior.getName());

					}				
					else {
						System.out.println("HA GANADO "+defenseWarrior.getName());		
					}					
					a1=false;
				}

		}
		if (a2=true) {
			Random r=new Random();
			int valorRandom= r.nextInt(100);
			if ((defenseWarrior.getAgility()*10)>valorRandom) {
				System.out.println("Ataque lanzado");
				valorRandom= r.nextInt(50);
				if ((atackWarrior.getAgility())<valorRandom) {						
						ataque=(defenseWarrior.getStrength()+weapon1.getStrength()-atackWarrior.getDefense());
						if(turnos%2==0) {
							injuries_caused = injuries_caused + ataque;
						}
						else {
							injuries_suffered = injuries_suffered + ataque;
						}
						System.out.println("El defensor ha rebut "+ataque+"punts de dany.");
						defenseWarrior.setHealth(atackWarrior.getHealth()-ataque);
						if (atackWarrior.getHealth()<=0) {
							atackWarrior.setHealth(0);
						}
						if (defenseWarrior.getHealth()<=0) {
							defenseWarrior.setHealth(0);
						}
						System.out.println(atackWarrior.getName()+": "+ defenseWarrior.getHealth());
						System.out.println(atackWarrior.getName()+": "+ atackWarrior.getHealth());
				}
			}					
			else {
				System.out.println("El defensor evita el ataque");
				System.out.println("Has fallado el ataque");				
				valorRandom= r.nextInt(100);	
			}
			if ((velocidad2-velocidad1)*10<valorRandom ) {
				// Cambio de turno				
				transicion=atackWarrior;
				atackWarrior=defenseWarrior;
				defenseWarrior=transicion;
				turnos++;						
				System.out.println("Cambio de turno");
				Scanner sc=new Scanner(System.in);
				sc.nextLine();
				System.out.println("Turno "+turnos);		
				}				

			if (atackWarrior.getHealth()<=0 || defenseWarrior.getHealth()<=0) {
				if (atackWarrior.getHealth()>defenseWarrior.getHealth()) {

					System.out.println("HA GANADO "+atackWarrior.getName());
					System.out.println(injuries_caused+" "+ injuries_suffered);

				}				
				else {
					System.out.println("HA GANADO "+defenseWarrior.getName());
					System.out.println(injuries_caused+ " " +injuries_suffered);
				}					
				a1=false;
			}

	}
		}while ( a1==true | a2==true);

}
}*/