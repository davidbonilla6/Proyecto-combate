package RaceBattle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class mainMenu{
	private JFrame window = new JFrame();
	private String urlPhoto="images/backgrounds/main.png";
    private JPanel pmain, pbuttons, pbuttonsup, pbuttonsdown, pcurrents;
	private JButton play, choosepj, choosewp, exit, ranking;
	private JLabel fcurrentp, fcurrentw;
	private String chosenwarriorname="none", chosenweaponname="none";
	
	public static void main(String[] args) {
		new mainMenu();
	}
	
	public mainMenu() { //adding JComponents to the main panel and setting the JFrame.
		initComponentsMain();
		initButtons();
		pmain.setLayout(new BorderLayout());
		
		pbuttons.setLayout(new BoxLayout(pbuttons, BoxLayout.Y_AXIS));
		pbuttonsup.add(play);
		pbuttonsup.add(ranking);
		pbuttonsup.add(exit);
		pbuttonsdown.add(choosepj);
		pbuttonsdown.add(choosewp);
		pbuttonsup.setOpaque(false);
		pbuttonsdown.setOpaque(false);
		pbuttons.add(pbuttonsup);
		pbuttons.add(pbuttonsdown);
		pbuttons.setOpaque(false);
		pbuttons.setSize(550, 100);
		pmain.add(pbuttons, BorderLayout.NORTH);
		pmain.setOpaque(false);
		pcurrents.setLayout(null);
		
		pcurrents.setOpaque(false);
		
		pcurrents.add(fcurrentp);
		pcurrents.add(fcurrentw);
		fcurrentp.setOpaque(false);
		fcurrentw.setOpaque(false);
		fcurrentp.setBounds(140, 45, 115, 192);
		fcurrentw.setBounds(275, 85, 110, 110);
		pmain.add(pcurrents, BorderLayout.CENTER);
		window.add(pmain);
		
		
		play.addActionListener(new ActionListener() { @Override //If we press "PLAY" button, if we have chosen a weapon then it launches the chooseName class. Else it launches the errorPlaying window.
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (chosenweaponname.equals("none")) {
					new errorPlaying(window,true);
				} else {
					int battlecoins=0, injuries_caused=0, injuries_suffered=0;
					new chooseName(chosenwarriorname, chosenweaponname, window, true, battlecoins, injuries_caused, injuries_suffered);
					chosenwarriorname="none";
					chosenweaponname="none";
					play.setIcon(new ImageIcon("images/buttons/playDisabled.png"));
					choosewp.setIcon(new ImageIcon("images/buttons/chooseWeaponDisabled.png"));
					fcurrentp.setIcon(new ImageIcon("images/characters/nonemain.png"));
					fcurrentw.setIcon(new ImageIcon("images/weapons/nonemain.png"));
				}
			}
			
		});
		
		choosepj.addActionListener(new ActionListener() { @Override //Executing the menu to choose a Warrior.
			public void actionPerformed(ActionEvent e) {
				chooseWarrior chosenWarrior = new chooseWarrior(window,true);
				chosenwarriorname=chosenWarrior.getElection();
				chosenweaponname="none";
				play.setIcon(new ImageIcon("images/buttons/playDisabled.png"));
				fcurrentw.setIcon(new ImageIcon("images/weapons/nonemain.png"));
				if (!chosenwarriorname.equals("none")) {
					choosewp.setIcon(new ImageIcon("images/buttons/chooseWeapon.png"));
					fcurrentp.setIcon(new ImageIcon("images/characters/"+chosenwarriorname+"main.png"));
					
				}
			}
		});
		
		choosewp.addActionListener(new ActionListener() { @Override //Executing the menu for choosing a Weapon if be have chosen a warrior before.
				public void actionPerformed(ActionEvent e) {
					if (chosenwarriorname.equals("none")) {
						new errorChoosingWeapon(window, true);
					} else {
						chooseWeapon chosenWeapon = new chooseWeapon(chosenwarriorname, window, true);
						chosenweaponname=chosenWeapon.getElection();
						if (!chosenweaponname.equals("none")) {
							play.setIcon(new ImageIcon("images/buttons/play.png"));
							fcurrentw.setIcon(new ImageIcon("images/weapons/"+chosenweaponname+"main.png"));
						}
					}
				}
			});
		
		ranking.addActionListener(new ActionListener() { @Override //Executing the ranking.
			public void actionPerformed(ActionEvent e) {
				new showRanking(window,true);
			}
			
		});
		
		exit.addActionListener(new ActionListener() { @Override //Exiting the APP.
			public void actionPerformed(ActionEvent e) {
				window.dispose();
			}
		});
		window.setSize(550,550);
		window.setTitle("MAIN MENU");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
	}
	public void initComponentsMain() { // Initializing the components used on main panel.
		pmain=new ImageComponent(urlPhoto);
		pbuttons=new JPanel();
		pbuttonsup=new JPanel();
		pbuttonsdown=new JPanel();
		pcurrents=new JPanel();
		
		fcurrentp=new JLabel(new ImageIcon("images/characters/"+chosenwarriorname+"main.png"));
		fcurrentw=new JLabel(new ImageIcon("images/weapons/"+chosenweaponname+"main.png"));
	}
	
	public void initButtons() { // Initializing the buttons used on main panel.
		ranking = new JButton(new ImageIcon("images/buttons/ranking.png"));
		ranking.setPreferredSize(new Dimension(150,50));
		
		play=new JButton(new ImageIcon("images/buttons/playDisabled.png"));
		play.setPreferredSize(new Dimension(100, 50));
		
		choosepj=new JButton(new ImageIcon("images/buttons/chooseWarrior.png"));
		choosepj.setPreferredSize(new Dimension(250, 50));
		
		choosewp=new JButton(new ImageIcon("images/buttons/chooseWeaponDisabled.png"));
		choosewp.setPreferredSize(new Dimension(250, 50));

		exit=new JButton(new ImageIcon("images/buttons/exit.png"));
		exit.setPreferredSize(new Dimension(100, 50));
	}
	
	public void setChosenWarrior(String election) {
		chosenwarriorname=election;
	}
	
	public void setChosenWeapon(String election) {
		chosenweaponname=election;
	}

}



@SuppressWarnings("serial")
class ImageComponent extends JPanel{ // Setting the background of a panel with a large image auto-escalated.
    private BufferedImage image;
    
    ImageComponent(String urlFoto){
        try {
            image = ImageIO.read(new File(urlFoto));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void paintComponent(Graphics g) {
          Graphics2D g2d = (Graphics2D)g;
          int x = 0; 
          int y = 0;
          g2d.drawImage(image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH), x, y, this);
    }
}
