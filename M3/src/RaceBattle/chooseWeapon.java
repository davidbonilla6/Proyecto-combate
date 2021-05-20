package RaceBattle;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class chooseWeapon extends JDialog{
	private JFrame weaponwindow = new JFrame();
	private JPanel panelChoosingW;
	private JButton bdagger, bsword, baxe, bdoubleSword, bscimitar, bbow, bkatana, bdirk, bdoubleAxe;
	private String urlPhoto="images/backgrounds/armory.jpg";
	private String electedWeapon="none";
	
	public chooseWeapon(String electedWarrior, JFrame j, boolean modal) {
		super(j,true);
		setSize(550,550);
		setTitle("CHOOSE WEAPON");
		initComponentsChooseWeapon(electedWarrior);
		panelChoosingW.setLayout(new GridLayout(3,3,30,20));
		panelChoosingW.add(bdagger);
		bdagger.addActionListener(new ActionListener() { @Override
			public void actionPerformed(ActionEvent e) {
				if (electedWarrior.equals("human")||electedWarrior.equals("elf")){
					electedWeapon="dagger";
					dispose();
				} else {
					new errorWeaponDisabled(weaponwindow,true);
				}
			}});
		
		panelChoosingW.add(bsword);
		bsword.addActionListener(new ActionListener() { @Override
			public void actionPerformed(ActionEvent e) {
				electedWeapon="sword";
				dispose();
			}});
		
		panelChoosingW.add(baxe);
		baxe.addActionListener(new ActionListener() { @Override
			public void actionPerformed(ActionEvent e) {
				if (electedWarrior.equals("human")||electedWarrior.equals("dwarf")){
					electedWeapon="axe";
					dispose();
				} else {
					new errorWeaponDisabled(weaponwindow,true);
				}
			}});
		
		panelChoosingW.add(bdoubleSword);
		bdoubleSword.addActionListener(new ActionListener() { @Override
			public void actionPerformed(ActionEvent e) {
				if (electedWarrior.equals("human")||electedWarrior.equals("elf")){
					electedWeapon="doubleSword";
					dispose();
				} else {
					new errorWeaponDisabled(weaponwindow,true);
				}
			}});
		
		panelChoosingW.add(bscimitar);
		bscimitar.addActionListener(new ActionListener() { @Override
			public void actionPerformed(ActionEvent e) {
				if (electedWarrior.equals("human")||electedWarrior.equals("elf")){
					electedWeapon="scimitar";
					dispose();
				} else {
					new errorWeaponDisabled(weaponwindow,true);
				}
			}});
		
		panelChoosingW.add(bbow);
		bbow.addActionListener(new ActionListener() { @Override
			public void actionPerformed(ActionEvent e) {
				if (electedWarrior.equals("elf")){
					electedWeapon="bow";
					dispose();
				} else {
					new errorWeaponDisabled(weaponwindow,true);
				}
			}});
		
		panelChoosingW.add(bkatana);
		bkatana.addActionListener(new ActionListener() { @Override
			public void actionPerformed(ActionEvent e) {
				if (electedWarrior.equals("human")){
					electedWeapon="katana";
					dispose();
				} else {
					new errorWeaponDisabled(weaponwindow,true);
				}
			}});
		
		panelChoosingW.add(bdirk);
		bdirk.addActionListener(new ActionListener() { @Override
			public void actionPerformed(ActionEvent e) {
				electedWeapon="dirk";
				dispose();
			}});
		
		panelChoosingW.add(bdoubleAxe);
		bdoubleAxe.addActionListener(new ActionListener() { @Override
			public void actionPerformed(ActionEvent e) {
				if (electedWarrior.equals("dwarf")){
					electedWeapon="doubleAxe";
					dispose();
				} else {
					new errorWeaponDisabled(weaponwindow,true);
				}
			}});
		
		add(panelChoosingW, BorderLayout.CENTER);
		setResizable(false);
		setVisible(true);
	}
	
	public void initComponentsChooseWeapon(String election) {
		//CHOOSE PLAYER's components.
		panelChoosingW=new ImageComponent(urlPhoto);
		ImageIcon daggerimage, swordimage, axeimage, doubleswordimage, scimitarimage, bowimage, katanaimage, dirkimage, doubleAxeimage;
		
		if (election.equals("human")||election.equals("elf")) {
			daggerimage=new ImageIcon("images/weapons/dagger.png");
		} else {
			daggerimage=new ImageIcon("images/weapons/daggerDisabled.png");
		}
		bdagger=new JButton(daggerimage);
		bdagger.setPreferredSize(new Dimension(160, 160));
		
		swordimage=new ImageIcon("images/weapons/sword.png");
		bsword=new JButton(swordimage);
		bsword.setPreferredSize(new Dimension(160, 160));
		
		if (election.equals("human")||election.equals("dwarf")) {
			axeimage=new ImageIcon("images/weapons/axe.png");
		} else {
			axeimage=new ImageIcon("images/weapons/axeDisabled.png");
		}
		baxe=new JButton(axeimage);
		baxe.setPreferredSize(new Dimension(160, 160));
		
		if (election.equals("human")||election.equals("elf")) {
			doubleswordimage=new ImageIcon("images/weapons/doubleSword.png");
		} else {
			doubleswordimage=new ImageIcon("images/weapons/doubleSwordDisabled.png");
		}
		bdoubleSword=new JButton(doubleswordimage);
		bdoubleSword.setPreferredSize(new Dimension(160, 160));
		
		if (election.equals("human")||election.equals("elf")) {
			scimitarimage=new ImageIcon("images/weapons/scimitar.png");
		} else {
			scimitarimage=new ImageIcon("images/weapons/scimitarDisabled.png");
		}
		bscimitar=new JButton(scimitarimage);
		bscimitar.setPreferredSize(new Dimension(160, 160));
		
		if (election.equals("elf")) {
			bowimage=new ImageIcon("images/weapons/bow.png");
		} else {
			bowimage=new ImageIcon("images/weapons/bowDisabled.png");
		}
		bbow=new JButton(bowimage);
		bbow.setPreferredSize(new Dimension(160, 160));
		
		if (election.equals("human")) {
			katanaimage=new ImageIcon("images/weapons/katana.png");
		} else {
			katanaimage=new ImageIcon("images/weapons/katanaDisabled.png");
		}
		bkatana=new JButton(katanaimage);
		bkatana.setPreferredSize(new Dimension(160, 160));
		
		dirkimage=new ImageIcon("images/weapons/dirk.png");
		bdirk=new JButton(dirkimage);
		bdirk.setPreferredSize(new Dimension(160, 160));
		
		if (election.equals("dwarf")) {
			doubleAxeimage=new ImageIcon("images/weapons/doubleAxe.png");
		} else {
			doubleAxeimage=new ImageIcon("images/weapons/doubleAxeDisabled.png");
		}
		bdoubleAxe=new JButton(doubleAxeimage);
		bdoubleAxe.setPreferredSize(new Dimension(160, 160));
	}
	
	public String getElection() {
		return electedWeapon;
	}
}


@SuppressWarnings("serial")
class errorChoosingWeapon extends JDialog {
	private JPanel main;
	private JLabel errorimage;
	private JButton ok;
	
	public errorChoosingWeapon(JFrame j, boolean modal) {
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
		
		ImageIcon okimage = new ImageIcon("images/buttons/ok.png");
		ok=new JButton(okimage);
		ImageIcon errorimageicon=new ImageIcon("images/backgrounds/errorChoosingWeapon.png");
		errorimage=new JLabel(errorimageicon);
	}
}

@SuppressWarnings("serial")
class errorWeaponDisabled extends JDialog {
	private JPanel main;
	private JLabel errorimage;
	private JButton ok;
	
	public errorWeaponDisabled(JFrame j, boolean modal) {
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
		
		ImageIcon okimage = new ImageIcon("images/buttons/ok.png");
		ok=new JButton(okimage);
		ImageIcon errorimageicon=new ImageIcon("images/backgrounds/errorWeaponDisabled.png");
		errorimage=new JLabel(errorimageicon);
	}
}