package RaceBattle;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class playCombat extends JDialog{
	private JPanel panelCombat;
	private JLabel localPhoto, rivalPhoto, localWeapon, rivalWeapon;
	private JLabel lpowerlabel, labilitylabel, lspeedlabel, ldefenselabel, rpowerlabel, rabilitylabel, rspeedlabel, rdefenselabel, usernameLabel, rivalnameLabel;
	protected JProgressBar pblocalHP, pbrivalHP;
	private String urlPhoto="images/backgrounds/combat.png";
	private String rivalelectedWarrior="none", rivalelectedWeapon="none";
	private String rivalname="Enemy";
	private int randnum;
	private boolean correctweapon=false;
	
	public playCombat(String username, String electedWarrior, String electedWeapon, JFrame j, boolean modal) {
		super(j, modal);
		randomizeRival();
		setSize(550,550);
		setTitle("COMBAT");
		initComponentsCombat(username, electedWarrior, rivalelectedWarrior, electedWeapon, rivalelectedWeapon);
		panelCombat.setLayout(null);
		panelCombat.add(lpowerlabel);
		panelCombat.add(localPhoto);
		panelCombat.add(rivalPhoto);
		panelCombat.add(localWeapon);
		panelCombat.add(rivalWeapon);
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

		//panelCombat.add(localStats);
		//panelCombat.add(rivalStats);
		/*EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                add(new AnimationPane("images/characters/human.png", 0, 60));
            }

        });*/
		
		localPhoto.setBounds(60, 130, 150, 250);
		localPhoto.setOpaque(false);
		rivalPhoto.setBounds(335, 18, 150, 250);
		rivalPhoto.setOpaque(false);
		localWeapon.setBounds(453, 299, 80, 80);
		localWeapon.setOpaque(false);
		rivalWeapon.setBounds(289, 15, 80, 80);
		rivalWeapon.setOpaque(false);
		
		lpowerlabel.setBounds(320, 367, 20, 20);
		lpowerlabel.setFont(new Font("Impact", Font.PLAIN, 20));
		lpowerlabel.setForeground(Color.YELLOW);
		lpowerlabel.setOpaque(false);
		
		labilitylabel.setBounds(375,365,20,20);
		labilitylabel.setFont(new Font("Impact", Font.PLAIN, 20));
		labilitylabel.setForeground(Color.YELLOW);
		labilitylabel.setOpaque(false);
		
		lspeedlabel.setBounds(427,367,20,20);
		lspeedlabel.setFont(new Font("Impact", Font.PLAIN, 20));
		lspeedlabel.setForeground(Color.YELLOW);
		lspeedlabel.setOpaque(false);
		
		ldefenselabel.setBounds(477,367,20,20);
		ldefenselabel.setFont(new Font("Impact", Font.PLAIN, 20));
		ldefenselabel.setForeground(Color.YELLOW);
		ldefenselabel.setOpaque(false);
		
		rpowerlabel.setBounds(156, 83, 20, 20);
		rpowerlabel.setFont(new Font("Impact", Font.PLAIN, 20));
		rpowerlabel.setForeground(Color.YELLOW);
		rpowerlabel.setOpaque(false);
		
		rabilitylabel.setBounds(211,81,20,20);
		rabilitylabel.setFont(new Font("Impact", Font.PLAIN, 20));
		rabilitylabel.setForeground(Color.YELLOW);
		rabilitylabel.setOpaque(false);
		
		rspeedlabel.setBounds(263,83,20,20);
		rspeedlabel.setFont(new Font("Impact", Font.PLAIN, 20));
		rspeedlabel.setForeground(Color.YELLOW);
		rspeedlabel.setOpaque(false);
		
		rdefenselabel.setBounds(313,83,20,20);
		rdefenselabel.setFont(new Font("Impact", Font.PLAIN, 20));
		rdefenselabel.setForeground(Color.YELLOW);
		rdefenselabel.setOpaque(false);
		
		usernameLabel.setBounds(290, 317, 200, 30);
		usernameLabel.setFont(new Font("Impact", Font.PLAIN, 20));
		usernameLabel.setForeground(Color.YELLOW);
		usernameLabel.setOpaque(false);
		
		rivalnameLabel.setBounds(125, 33, 200, 30);
		rivalnameLabel.setFont(new Font("Impact", Font.PLAIN, 20));
		rivalnameLabel.setForeground(Color.YELLOW);
		rivalnameLabel.setOpaque(false);
		
		add(panelCombat);
		setResizable(false);
		setVisible(true);
	}
	
	public void initComponentsCombat(String username, String electedWarrior, String rivalelectedWarrior, String electedWeapon, String rivalelectedWeapon) {
		panelCombat=new ImageComponent(urlPhoto);
		
		ImageIcon localimage=new ImageIcon("images/characters/"+electedWarrior+"combat.png");
		localPhoto=new JLabel(localimage);
		ImageIcon rivalimage=new ImageIcon("images/characters/"+rivalelectedWarrior+"combat.png");
		rivalPhoto=new JLabel(rivalimage);
		ImageIcon localWimage=new ImageIcon("images/weapons/"+electedWeapon+"combat.png");
		localWeapon = new JLabel(localWimage);
		ImageIcon rivalWimage=new ImageIcon("images/weapons/"+rivalelectedWeapon+"combat.png");
		rivalWeapon = new JLabel(rivalWimage);
	
		lpowerlabel = new JLabel("20");
		labilitylabel = new JLabel("20");
		lspeedlabel = new JLabel("20");
		ldefenselabel = new JLabel("20");
		
		rpowerlabel = new JLabel("00");
		rabilitylabel = new JLabel("00");
		rspeedlabel = new JLabel("00");
		rdefenselabel = new JLabel("00");
		
		usernameLabel=new JLabel(username);
		rivalnameLabel=new JLabel(rivalname);
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
		setLocation(125, 175);
		setSize(250,175);
		setTitle("ERROR");
		setResizable(false);
		setVisible(true);
	}
	
	public void initComponentsErrorCW() {
		main=new ImageComponent("images/backgrounds/error.png");
		
		ImageIcon okimage = new ImageIcon("images/buttons/ok.png");
		ok=new JButton(okimage);
		ImageIcon errorimageicon=new ImageIcon("images/backgrounds/errorPlaying.png");
		errorimage=new JLabel(errorimageicon);
	}
}

@SuppressWarnings("serial")
class chooseName extends JDialog {
	private JFrame chooseNamewindow = new JFrame();
	private JPanel main;
	private JTextField choosename;
	private JButton ok;
	private String username="test";
	
	public chooseName(String electedWarrior, String electedWeapon,JFrame j, boolean modal) {
		super(j,modal);
		initComponentsErrorCW();
		main.setLayout(null);
		
		main.add(ok);
		main.add(choosename);
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				username=choosename.getText();
				new playCombat(username, electedWarrior, electedWeapon, chooseNamewindow, true);
				dispose();
			}
		});
		
		ok.setBounds(70, 80, 100, 50);
		choosename.setBounds(15, 40, 200, 30);
		choosename.setFont(new Font("Impact", Font.PLAIN, 25));
		choosename.setForeground(new Color(228,215,163));
		choosename.setOpaque(false);
		
		add(main);
		setLocation(125, 175);
		setSize(250,175);
		setTitle("CHOOSE USERNAME");
		setResizable(false);
		setVisible(true);
	}
	
	public void initComponentsErrorCW() {
		main=new ImageComponent("images/backgrounds/chooseName.png");
		
		ImageIcon okimage = new ImageIcon("images/buttons/ok.png");
		ok=new JButton(okimage);
		choosename=new JTextField(15);
	}
}