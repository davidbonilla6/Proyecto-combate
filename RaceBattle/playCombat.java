package RaceBattle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class playCombat extends JDialog{
	private JFrame combatWindow = new JFrame();
	private Random r=new Random();
	private int injuries_caused=0;
	private int injuries_suffered=0;
	private JPanel panelCombat, panelConsole;
	private JLabel localPhoto, rivalPhoto, localWeaponLabel, rivalWeaponLabel;
	private JLabel lpowerlabel, labilitylabel, lspeedlabel, ldefenselabel, rpowerlabel, rabilitylabel, rspeedlabel, rdefenselabel, usernameLabel, rivalnameLabel;
	protected JProgressBar localHP, rivalHP;
	private String urlPhoto="images/backgrounds/combat.png";
	private String localelectedWarrior, localelectedWeapon, rivalelectedWarrior="none", rivalelectedWeapon="none";
	private String rivalname="ENEMY",localname;
	private String dlocalWeaponName, dlocalWeaponImage, drivalWeaponName, drivalWeaponImage;
	private int injuries_causedTB, injuries_sufferedTB;
	private int dlocalHP, dlocalPower, dlocalAbility, dlocalSpeed, dlocalDefense, drivalHP, drivalPower, drivalAbility, drivalSpeed, drivalDefense;
	private int dlocalWeaponID, dlocalWeaponPower, dlocalWeaponSpeed, dlocalWeaponPoints, drivalWeaponID, drivalWeaponPower, drivalWeaponSpeed, drivalWeaponPoints;
	private int dlocalWarriorID, dlocalWarriorPoints, drivalWarriorID, drivalWarriorPoints;
	private int randnum, battlecoinsThisBattle;
	int turnos=1, warrior_id;
	private JButton fight;
	private JTextArea console;
	private JScrollPane scrollConsole;
	private boolean correctweapon=false, localStarts;
	private warrior attackWarrior, defenseWarrior, localWarrior, rivalWarrior;
	private weapon localWeapon, rivalWeapon;
	private String urlDB= "jdbc:mysql://localhost/battle_data_base?serverTimezone=UTC";
	private String userDB= "root";
	private String passDB= "rootroot";

	
	
	
	public playCombat(String username, String electedWarrior, String electedWeapon, JFrame j, boolean modal, int battlecoinsTotal, int injuries_caused, int injuries_suffered) {
		super(j, modal);
		localname=username;
		injuries_causedTB=injuries_caused;
		injuries_sufferedTB=injuries_suffered;
		battlecoinsThisBattle=battlecoinsTotal;
		localelectedWarrior= electedWarrior;
		localelectedWeapon=electedWeapon;
		randomizeRival();
		setSize(550,550);
		setTitle("COMBAT");
		username=selectName(electedWarrior);
		rivalname=selectName(rivalelectedWarrior);
		initDataBaseData(username);
		initComponentsCombat(username, electedWarrior, rivalelectedWarrior, electedWeapon, rivalelectedWeapon);
		localStarts=firstStart();
		panelCombat.setLayout(null);
		panelCombat.add(lpowerlabel);
		panelCombat.add(localPhoto);
		panelCombat.add(rivalPhoto);
		panelCombat.add(localWeaponLabel);
		panelCombat.add(rivalWeaponLabel);
		panelCombat.add(lpowerlabel);
		panelCombat.add(labilitylabel);
		panelCombat.add(lspeedlabel);
		panelCombat.add(ldefenselabel);
		panelCombat.add(rpowerlabel);
		panelCombat.add(rabilitylabel);
		panelCombat.add(rspeedlabel);
		panelCombat.add(rdefenselabel);
		panelCombat.add(usernameLabel);
		panelCombat.add(rivalnameLabel);
		panelCombat.add(localHP);
		panelCombat.add(rivalHP);
		panelCombat.add(fight);
		panelConsole.add(scrollConsole);
		panelCombat.add(panelConsole);
		
		console.setBackground(Color.ORANGE);
		panelConsole.setBackground(Color.RED);
		panelConsole.setBounds(0, 433, 550, 80);
		
		localHP.setBounds(358, 351, 100, 15);
		localHP.setValue(dlocalHP);
		rivalHP.setBounds(191, 66, 100, 15);
		rivalHP.setValue(drivalHP);
		
		localHP.setBackground(Color.DARK_GRAY);
		localHP.setForeground(Color.GREEN);
		localHP.setStringPainted(true);
		
		rivalHP.setBackground(Color.DARK_GRAY);
		rivalHP.setForeground(Color.GREEN);
		rivalHP.setStringPainted(true);
		
		fight.setBounds(225, 225, 100, 50);
		fight.addActionListener(new ActionListener() { @Override
			public void actionPerformed(ActionEvent e) {
			if (turnos==1) {
				console.setText("*** Round: 1 ***");
			} else {
				console.setText(console.getText()+"\n***Round: "+turnos+" ****");
			}
			if (turnos%2==0 && localStarts==true) {
				attackWarrior=rivalWarrior;
				defenseWarrior=localWarrior;
			} else if (turnos%2!=0 && localStarts==true) {
				defenseWarrior=rivalWarrior;
				attackWarrior=localWarrior;
			}
			if (turnos%2==0 && localStarts==false) {
				defenseWarrior=rivalWarrior;
				attackWarrior=localWarrior;
			} else if (turnos%2!=0 && localStarts==false){
				attackWarrior=rivalWarrior;
				defenseWarrior=localWarrior;
			}
				turnos=combat(attackWarrior, defenseWarrior, turnos, localStarts);
				if (localWarrior.getHealth()<=0 || rivalWarrior.getHealth()<=0) {
					if (rivalWarrior.getHealth()<=0) {
						battlecoinsThisBattle+=rivalWarrior.getRacePoints();
						battlecoinsThisBattle+=rivalWeapon.getWeaponPoints();
						
					}
					new playAgain(localname, electedWarrior, electedWeapon, combatWindow, true, battlecoinsThisBattle, injuries_causedTB, injuries_sufferedTB);
					insertFight();
					dispose();
					combatWindow.dispose();
				}
			}
			
		});
		
		localPhoto.setBounds(60, 130, 150, 250);
		localPhoto.setOpaque(false);
		rivalPhoto.setBounds(335, 18, 150, 250);
		rivalPhoto.setOpaque(false);
		localWeaponLabel.setBounds(467, 300, 80, 80);
		localWeaponLabel.setOpaque(false);
		rivalWeaponLabel.setBounds(299, 16, 80, 80);
		rivalWeaponLabel.setOpaque(false);
		
		lpowerlabel.setBounds(327, 368, 40, 20);
		lpowerlabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lpowerlabel.setForeground(Color.YELLOW);
		lpowerlabel.setOpaque(false);
		
		labilitylabel.setBounds(386,368,40,20);
		labilitylabel.setFont(new Font("Impact", Font.PLAIN, 20));
		labilitylabel.setForeground(Color.YELLOW);
		labilitylabel.setOpaque(false);
		
		lspeedlabel.setBounds(440,368,40,20);
		lspeedlabel.setFont(new Font("Impact", Font.PLAIN, 20));
		lspeedlabel.setForeground(Color.YELLOW);
		lspeedlabel.setOpaque(false);
		
		ldefenselabel.setBounds(493,368,40,20);
		ldefenselabel.setFont(new Font("Impact", Font.PLAIN, 20));
		ldefenselabel.setForeground(Color.YELLOW);
		ldefenselabel.setOpaque(false);
		
		rpowerlabel.setBounds(160, 83, 40, 20);
		rpowerlabel.setFont(new Font("Impact", Font.PLAIN, 20));
		rpowerlabel.setForeground(Color.YELLOW);
		rpowerlabel.setOpaque(false);
		
		rabilitylabel.setBounds(218,83,40,20);
		rabilitylabel.setFont(new Font("Impact", Font.PLAIN, 20));
		rabilitylabel.setForeground(Color.YELLOW);
		rabilitylabel.setOpaque(false);
		
		rspeedlabel.setBounds(271,83,40,20);
		rspeedlabel.setFont(new Font("Impact", Font.PLAIN, 20));
		rspeedlabel.setForeground(Color.YELLOW);
		rspeedlabel.setOpaque(false);
		
		rdefenselabel.setBounds(324,83,40,20);
		rdefenselabel.setFont(new Font("Impact", Font.PLAIN, 20));
		rdefenselabel.setForeground(Color.YELLOW);
		rdefenselabel.setOpaque(false);
		
		usernameLabel.setBounds(297, 319, 200, 30);
		usernameLabel.setFont(new Font("Impact", Font.BOLD, 20));
		usernameLabel.setForeground(Color.YELLOW);
		usernameLabel.setOpaque(false);
		
		rivalnameLabel.setBounds(125, 33, 200, 30);
		rivalnameLabel.setFont(new Font("Impact", Font.BOLD, 20));
		rivalnameLabel.setForeground(Color.YELLOW);
		rivalnameLabel.setOpaque(false);
		
		//System.out.println(dlocalHP+" "+ dlocalPower+ " "+ dlocalAbility+ " "+ dlocalSpeed+ " "+ dlocalDefense);
		//System.out.println(drivalHP+" "+ drivalPower+ " "+ drivalAbility+ " "+ drivalSpeed+ " "+ drivalDefense);		
		add(panelCombat);
		setResizable(false);
		setVisible(true);
}
	public void insertFight() {
		// TODO Auto-generated method stub
		String urlDB= "jdbc:mysql://localhost/battle_data_base?serverTimezone=UTC";
		String userDB= "root";
		String passDB= "rootroot";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlDB, userDB, passDB);
			
			String query="Select * from players";
			Statement st = conn.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.last();
			int id_player=rs.getInt(1);
			String name_player=rs.getString(2);

			Player player=new Player(id_player, name_player);
			Conection Conection=new Conection();
			Conection.battle_final_resume_save(conn, injuries_caused, injuries_suffered, battlecoinsThisBattle, localWeapon, localWarrior, player, rivalWarrior, rivalWeapon);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void randomizeRival() {
		randnum=(int)(Math.random()*3+1);
		switch (randnum){
		case 1:
			rivalelectedWarrior="human";
			while (!correctweapon) {
				randnum=(int)(Math.random()*9+1);
				if (randnum==6 || randnum==9) {
					correctweapon=false;
				} else {
					correctweapon=true;
				}
			}
			break;
		case 2:
			rivalelectedWarrior="elf";
			while (!correctweapon) {
				randnum=(int)(Math.random()*9+1);
				if (randnum==3 || randnum==7 || randnum==9) {
					correctweapon=false;
				} else {
					correctweapon=true;
				}
			}
			break;
		case 3:	
			rivalelectedWarrior="dwarf";
			while (!correctweapon) {
				randnum=(int)(Math.random()*9+1);
				if (randnum==1 || randnum==4 || randnum==5 || randnum==6 || randnum==7) {
					correctweapon=false;
				} else {
					correctweapon=true;
				}
			}
			break;
		}
		switch (randnum) {
		case 1:
			rivalelectedWeapon="dagger";
			break;
		case 2:
			rivalelectedWeapon="sword";
			break;
		case 3:
			rivalelectedWeapon="axe";
			break;
		case 4:
			rivalelectedWeapon="doubleSword";
			break;
		case 5:
			rivalelectedWeapon="scimitar";
			break;
		case 6:
			rivalelectedWeapon="bow";
			break;
		case 7:
			rivalelectedWeapon="katana";
			break;
		case 8:
			rivalelectedWeapon="dirk";
			break;
		case 9:
			rivalelectedWeapon="doubleAxe";
			break;
		}
	}
	
	public String selectName(String race) {
		String name="";
		try {
			if (race.equals("elf")) {
				warrior_id=r.nextInt(4)+1;
			} else if (race.equals("human")) {
				warrior_id=r.nextInt(4)+1+4;
			} else if (race.equals("dwarf")) {
				warrior_id=r.nextInt(4)+1+8;
			}
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(urlDB, userDB, passDB);
			System.out.println("[!] Connection established.");
			
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("Select * from warriors where warrior_id="+warrior_id+";");
			rs.next();
			name=rs.getString(2);
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("[!] Driver has not loaded correctly.");		
		} catch (SQLException e) {
			System.out.println("[!] ERROR. Connection lost.");
		}System.out.println(" ");
		return name;
	}

	public void initDataBaseData(String username) {

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(urlDB, userDB, passDB);
			System.out.println("[!] Connection established.");
			
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("Select * from race");
			while (rs.next()) {
				if (localelectedWarrior.equals(rs.getString(2))) {
					dlocalWarriorID=rs.getInt(1);
					dlocalHP=rs.getInt(3);
					dlocalPower=rs.getInt(4);
					dlocalAbility=rs.getInt(5);
					dlocalSpeed=rs.getInt(6);
					dlocalDefense=rs.getInt(7);
					dlocalWarriorPoints=rs.getInt(8);
				}
				if (rivalelectedWarrior.equals(rs.getString(2))) {
					drivalWarriorID=rs.getInt(1);
					drivalHP=rs.getInt(3);
					drivalPower=rs.getInt(4);
					drivalAbility=rs.getInt(5);
					drivalSpeed=rs.getInt(6);
					drivalDefense=rs.getInt(7);
					drivalWarriorPoints=rs.getInt(8);
				}
			}
			rs=st.executeQuery("Select * from weapon");
			while (rs.next()) {
				if (localelectedWeapon.equals(rs.getString(2))) {
					dlocalWeaponID=rs.getInt(1);
					dlocalWeaponName=rs.getString(2);
					dlocalWeaponImage=rs.getString(3);
					dlocalPower+=rs.getInt(4);
					dlocalWeaponPower=rs.getInt(4);
					dlocalSpeed+=rs.getInt(5);
					dlocalWeaponSpeed+=rs.getInt(5);
					dlocalWeaponPoints=rs.getInt(7);
				}
				if (rivalelectedWeapon.equals(rs.getString(2))) {
					drivalWeaponID=rs.getInt(1);
					drivalWeaponName=rs.getString(2);
					drivalWeaponImage=rs.getString(3);
					drivalPower+=rs.getInt(4);
					drivalWeaponPower=rs.getInt(4);
					drivalSpeed+=rs.getInt(5);
					drivalWeaponSpeed=rs.getInt(5);
					drivalWeaponPoints=rs.getInt(7);
				}
			}
			localWeapon=new weapon(dlocalWeaponID, dlocalWeaponName, dlocalWeaponImage, dlocalWeaponPower, dlocalWeaponSpeed, dlocalWeaponPoints);
			rivalWeapon=new weapon(drivalWeaponID, drivalWeaponName, drivalWeaponImage, drivalWeaponPower, drivalWeaponSpeed, drivalWeaponPoints);		
			localWarrior=new warrior(dlocalWarriorID, username, dlocalHP, dlocalPower, dlocalAbility, dlocalSpeed, dlocalDefense, localWeapon, dlocalWarriorPoints);
			rivalWarrior=new warrior(drivalWarriorID, rivalname, drivalHP, drivalPower, drivalAbility, drivalSpeed, drivalDefense, rivalWeapon, drivalWarriorPoints);
			localHP = new JProgressBar(0,dlocalHP);
			rivalHP = new JProgressBar(0,drivalHP);
			
		} catch (ClassNotFoundException e) {
			System.out.println("[!] Driver has not loaded correctly.");		
		} catch (SQLException e) {
			System.out.println("[!] ERROR. Connection lost.");
		}System.out.println(" ");
	}
	
	public void initComponentsCombat(String username, String electedWarrior, String rivalelectedWarrior, String electedWeapon, String rivalelectedWeapon) {
		panelCombat=new ImageComponent(urlPhoto);
		panelConsole=new JPanel();
		
		localPhoto=new JLabel(new ImageIcon("images/characters/"+electedWarrior+"combat.png"));
		rivalPhoto=new JLabel(new ImageIcon("images/characters/"+rivalelectedWarrior+"combat.png"));
		localWeaponLabel = new JLabel(new ImageIcon("images/weapons/"+electedWeapon+"combat.png"));
		rivalWeaponLabel = new JLabel(new ImageIcon("images/weapons/"+rivalelectedWeapon+"combat.png"));
	
		fight = new JButton(new ImageIcon("images/buttons/fight.png"));
		console = new JTextArea(5,45);
		//scrollConsole = new JScrollBar(JScrollBar.VERTICAL, 10, 40, 0, 100);
		scrollConsole = new JScrollPane(console);
		lpowerlabel = new JLabel(String.valueOf(dlocalPower));
		labilitylabel = new JLabel(String.valueOf(dlocalAbility));
		lspeedlabel = new JLabel(String.valueOf(dlocalSpeed));
		ldefenselabel = new JLabel(String.valueOf(dlocalDefense));
		
		rpowerlabel = new JLabel(String.valueOf(drivalPower));
		rabilitylabel = new JLabel(String.valueOf(drivalAbility));
		rspeedlabel = new JLabel(String.valueOf(drivalSpeed));
		rdefenselabel = new JLabel(String.valueOf(drivalDefense));
		
		usernameLabel=new JLabel(username);
		rivalnameLabel=new JLabel(rivalname);
	}
	
	public boolean firstStart() { //true= empieza el loca, false= empieza el rival
		if (localWarrior.getSpeed()>rivalWarrior.getSpeed()) {
			return true;

		}else if (localWarrior.getSpeed()==rivalWarrior.getSpeed()){
			if (localWarrior.getAgility()>rivalWarrior.getAgility()) {
				return true;

			}else if(localWarrior.getAgility()==rivalWarrior.getAgility()) {
				int a=(int) Math.random();
				int b=(int) Math.random();
				if (a>b) {
					return true;
				}else {
					return false;
				}
			}
		}else {
			return false;

		}
		return true;
}

	public int combat(warrior attackWarrior, warrior defenseWarrior, int turnos, boolean localStarts) {
		localPhoto.setIcon(new ImageIcon("images/characters/"+localelectedWarrior+"combat.png"));
		rivalPhoto.setIcon(new ImageIcon("images/characters/"+rivalelectedWarrior+"combat.png"));
		int valorRandom=0;
		int velocidad1=attackWarrior.getSpeed();
		int velocidad2=defenseWarrior.getSpeed(),ataque;

		//Escoger quien empieza

		//Start Battle
		do {
		if (localStarts==true) {
				valorRandom= r.nextInt(100);
				if ((attackWarrior.getAgility()*10)>valorRandom) {
					valorRandom= r.nextInt(50);
					if ((defenseWarrior.getAgility())<valorRandom) {						
							ataque=(attackWarrior.getStrength()-defenseWarrior.getDefense());
							if(turnos%2!=0) {
								injuries_caused = injuries_caused + ataque;
								rivalHP.setValue(defenseWarrior.getHealth()-ataque);
								rivalPhoto.setIcon(new ImageIcon("images/characters/"+rivalelectedWarrior+"hurted.png"));
							}
							else {
								injuries_suffered = injuries_suffered + ataque;
								localHP.setValue(defenseWarrior.getHealth()-ataque);
								localPhoto.setIcon(new ImageIcon("images/characters/"+localelectedWarrior+"hurted.png"));
							}
							console.setText(console.getText()+"\n"+attackWarrior.getName()+" hits "+defenseWarrior.getName()+". It causes "+ataque+" damage points.");
							defenseWarrior.setHealth(defenseWarrior.getHealth()-ataque);
							if (attackWarrior.getHealth()<=0) {
								attackWarrior.setHealth(0);
								if(turnos%2!=0) {
									localHP.setValue(0);
								} else {
									rivalHP.setValue(0);
								}
							}
							if (defenseWarrior.getHealth()<=0) {
								defenseWarrior.setHealth(0);
								if(turnos%2!=0) {
									rivalHP.setValue(0);
								} else {
									localHP.setValue(0);
								}
							}
							console.setText(console.getText()+"\n"+attackWarrior.getName()+": "+ attackWarrior.getHealth()+" HP remaining.");
							console.setText(console.getText()+"\n"+defenseWarrior.getName()+": "+ defenseWarrior.getHealth()+" HP remaining.");
					}
					else{console.setText(console.getText()+"\n"+defenseWarrior.getName()+" has evoid the attack.");}
				}					
				else {
					console.setText(console.getText()+"\n"+attackWarrior.getName()+" failed the attack.");				
				}
		valorRandom= r.nextInt(100);
		}
		else if (localStarts==false) {
			if ((attackWarrior.getAgility()*10)>valorRandom) {
				valorRandom= r.nextInt(50);
				if ((defenseWarrior.getAgility())<valorRandom) {						
						ataque=(attackWarrior.getStrength()-defenseWarrior.getDefense());
						if(turnos%2==0) {
							injuries_caused = injuries_caused + ataque;
							rivalHP.setValue(defenseWarrior.getHealth()-ataque);
							rivalPhoto.setIcon(new ImageIcon("images/characters/"+rivalelectedWarrior+"hurted.png"));
						}
						else {
							injuries_suffered = injuries_suffered + ataque;
							localHP.setValue(defenseWarrior.getHealth()-ataque);
							localPhoto.setIcon(new ImageIcon("images/characters/"+localelectedWarrior+"hurted.png"));
						}
						console.setText(console.getText()+"\n"+attackWarrior.getName()+" hit "+defenseWarrior.getName()+". It causes "+ataque+" damage points.");
						defenseWarrior.setHealth(defenseWarrior.getHealth()-ataque);
						
						if (attackWarrior.getHealth()<=0) {
							attackWarrior.setHealth(0);
							if(turnos%2!=0) {
								rivalHP.setValue(0);
							} else {
								localHP.setValue(0);
							}
							
						}
						if (defenseWarrior.getHealth()<=0) {
							defenseWarrior.setHealth(0);
							if(turnos%2!=0) {
								localHP.setValue(0);
							} else {
								rivalHP.setValue(0);
							}
						}
						console.setText(console.getText()+"\n"+attackWarrior.getName()+": "+ attackWarrior.getHealth()+" HP remaining.");
						console.setText(console.getText()+"\n"+defenseWarrior.getName()+": "+ defenseWarrior.getHealth()+" HP remaining.");
				}
				else {console.setText(console.getText()+"\n[!] "+defenseWarrior.getName()+" has evoid the attack.");}
			}					
			else {
				console.setText(console.getText()+"\n[!] "+attackWarrior.getName()+" failed the attack.");				
			}
		}valorRandom= r.nextInt(100);
		if ((velocidad1-velocidad2)*10>valorRandom) {
			console.setText(console.getText()+"\n"+attackWarrior.getName()+" attacks again because he is so lucky.");
		}
		} while ((velocidad1-velocidad2)*10>valorRandom);
		turnos++;
		return turnos;
}

}



@SuppressWarnings("serial")
class errorPlaying extends JDialog {
	private JPanel main;
	private JLabel errorimage;
	private JButton ok;
	
	public errorPlaying(JFrame j, boolean modal) {
		super(j,modal);
		initComponentsErrorCW();
		main.setLayout(null);
		
		main.add(ok);
		main.add(errorimage);
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		ok.setBounds(70, 80, 100, 50);
		errorimage.setBounds(15, 5, 200, 70);
		errorimage.setOpaque(false);
		
		add(main);
		setLocation(225, 225);
		setSize(250,175);
		setTitle("ERROR");
		setResizable(false);
		setVisible(true);
	}
	
	public void initComponentsErrorCW() {
		main=new ImageComponent("images/backgrounds/error.png");
		
		ok=new JButton(new ImageIcon("images/buttons/ok.png"));
		errorimage=new JLabel(new ImageIcon("images/backgrounds/errorPlaying.png"));
	}
}

@SuppressWarnings("serial")
class chooseName extends JDialog {
	private JFrame chooseNamewindow = new JFrame();
	private JPanel main;
	private JTextField choosename;
	private JButton ok;
	private String username="test";
	
	public chooseName(String electedWarrior, String electedWeapon,JFrame j, boolean modal, int battlecoins, int injuries_caused, int injuries_suffered) {
		super(j,modal);
		initComponentsErrorCW();
		main.setLayout(null);
		
		main.add(ok);
		main.add(choosename);
		ok.addActionListener(new ActionListener() { @Override
			public void actionPerformed(ActionEvent e) {
				String urlDB= "jdbc:mysql://localhost/battle_data_base?serverTimezone=UTC";
				String userDB= "root";
				String passDB= "rootroot";
				username=(choosename.getText().toUpperCase());
				try {
					username=(choosename.getText().toUpperCase());
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection(urlDB, userDB, passDB);
					Conection Conection=new Conection();
					Conection.insertar_player(username, conn);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new playCombat(username, electedWarrior, electedWeapon, chooseNamewindow, true, battlecoins, injuries_caused, injuries_suffered);
				dispose();
			}
		});
		
		ok.setBounds(70, 80, 100, 50);
		choosename.setBounds(15, 40, 200, 30);
		choosename.setFont(new Font("Impact", Font.PLAIN, 25));
		choosename.setForeground(new Color(228,215,163));
		choosename.setOpaque(false);
		
		add(main);
		setLocation(225, 225);
		setSize(250,175);
		setTitle("CHOOSE USERNAME");
		setResizable(false);
		setVisible(true);
	}
	
	public void initComponentsErrorCW() {
		main=new ImageComponent("images/backgrounds/chooseName.png");

		ok=new JButton(new ImageIcon("images/buttons/ok.png"));
		choosename=new JTextField(15);
	}
}

@SuppressWarnings("serial")
class playAgain extends JDialog {
	private JFrame mainframe=new JFrame();
	private JPanel main, buttons;
	private JButton yes, no;
	
	public playAgain(String username, String electedWarrior, String electedWeapon, JFrame j, boolean modal, int battlecoins, int injuries_caused, int injuries_suffered) {
		super(j,modal);
		initComponentsErrorCW();
		main.setLayout(new BorderLayout());
		
		buttons.add(yes, BorderLayout.CENTER);
		buttons.add(no, BorderLayout.CENTER);
		yes.addActionListener(new ActionListener() { @Override
			public void actionPerformed(ActionEvent e) {
				new playCombat(username, electedWarrior, electedWeapon, mainframe,true, battlecoins, injuries_caused, injuries_suffered);
				dispose();
			}
		});
		no.addActionListener(new ActionListener() { @Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		main.add(buttons, BorderLayout.SOUTH);
		main.setOpaque(false);
		buttons.setOpaque(false);
		add(main);
		setLocation(225, 225);
		setSize(250,175);
		setTitle("PLAY AGAIN?");
		setResizable(false);
		setVisible(true);
	
	}

	public void initComponentsErrorCW() {
		main=new ImageComponent("images/backgrounds/playAgain.png");
		buttons=new JPanel();
		
		yes=new JButton(new ImageIcon("images/buttons/yes.png"));
		yes.setContentAreaFilled(false);
		yes.setPreferredSize(new Dimension(75,38));
		no=new JButton(new ImageIcon("images/buttons/no.png"));
		no.setContentAreaFilled(false);
		no.setPreferredSize(new Dimension(75,38));
	}
}
