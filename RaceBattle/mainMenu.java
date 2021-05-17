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
	private JButton play, choosepj, choosewp, exit;
	private JLabel fcurrentp, fcurrentw;
	private String chosenwarriorname="none", chosenweaponname="none";
	private ImageIcon playimage, chooseWarriorimage, chooseWeaponimage, exitimage;
	
	public static void main(String[] args) {
		new mainMenu();
	}
	
	public mainMenu() {
		initComponentsMain();
		initButtons();
		pmain.setLayout(new BorderLayout());
		
		pbuttons.setLayout(new BoxLayout(pbuttons, BoxLayout.Y_AXIS));
		pbuttonsup.add(play);
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
		
		
		play.addActionListener(new ActionListener() { @Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (chosenweaponname.equals("none")) {
					new errorPlaying(window,true);
				} else {
					new chooseName(chosenwarriorname, chosenweaponname, window, true);
				}
			}
			
		});
		
		choosepj.addActionListener(new ActionListener() { @Override
			public void actionPerformed(ActionEvent e) {
				chooseWarrior chosenWarrior = new chooseWarrior(window,true);
				chosenwarriorname=chosenWarrior.getElection();
				chosenweaponname="none";
				Icon playdisabledimage =new ImageIcon("images/buttons/playDisabled.png");
				play.setIcon(playdisabledimage);
				Icon noneweapon = new ImageIcon("images/weapons/nonemain.png");
				fcurrentw.setIcon(noneweapon);
				if (!chosenwarriorname.equals("none")) {
					Icon weaponabailableimage =new ImageIcon("images/buttons/chooseWeapon.png");
					choosewp.setIcon(weaponabailableimage);
					Icon warriorchosenmain = new ImageIcon("images/characters/"+chosenwarriorname+"main.png");
					fcurrentp.setIcon(warriorchosenmain);
					
				}
			}
		});
		
		choosewp.addActionListener(new ActionListener() { @Override
				public void actionPerformed(ActionEvent e) {
					if (chosenwarriorname.equals("none")) {
						new errorChoosingWeapon(window, true);
					} else {
						chooseWeapon chosenWeapon = new chooseWeapon(chosenwarriorname, window, true);
						chosenweaponname=chosenWeapon.getElection();
						if (!chosenweaponname.equals("none")) {
							Icon playabailableimage =new ImageIcon("images/buttons/play.png");
							play.setIcon(playabailableimage);
							Icon weaponchosenmain = new ImageIcon("images/weapons/"+chosenweaponname+"main.png");
							fcurrentw.setIcon(weaponchosenmain);
						}
					}
				}
			});
		
		exit.addActionListener(new ActionListener() { @Override
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
	public void initComponentsMain() {
		pmain=new ImageComponent(urlPhoto);
		pbuttons=new JPanel();
		pbuttonsup=new JPanel();
		pbuttonsdown=new JPanel();
		pcurrents=new JPanel();
		
		ImageIcon currentpimage = new ImageIcon("images/characters/"+chosenwarriorname+"main.png");
		fcurrentp=new JLabel(currentpimage);
		ImageIcon currentwimage = new ImageIcon("images/weapons/"+chosenweaponname+"main.png");
		fcurrentw=new JLabel(currentwimage);
	}
	
	public void initButtons() {
		playimage = new ImageIcon("images/buttons/playDisabled.png");
		play=new JButton(playimage);
		play.setPreferredSize(new Dimension(100, 50));
		
		chooseWarriorimage = new ImageIcon("images/buttons/chooseWarrior.png");
		choosepj=new JButton(chooseWarriorimage);
		choosepj.setPreferredSize(new Dimension(250, 50));
		
		chooseWeaponimage = new ImageIcon("images/buttons/chooseWeaponDisabled.png");
		choosewp=new JButton(chooseWeaponimage);
		choosewp.setPreferredSize(new Dimension(250, 50));
		
		exitimage = new ImageIcon("images/buttons/exit.png");
		exit=new JButton(exitimage);
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
/*class AnimationPane extends JPanel {

    private BufferedImage picture;
    private int xPos = 0;
    private int direction = 1;

    public AnimationPane(String urlPhoto, int Xorigin, int Xdestiny) {
        try {
        	picture = ImageIO.read(new File(urlPhoto));
            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    xPos += direction;
                    if (xPos + picture.getWidth() < Xdestiny) {
                        xPos = getWidth() - picture.getWidth();
                        direction *= -1;
                    } else if (xPos < 0) {
                        xPos = 0;
                        direction *= -1;
                    }
                    repaint();
                }

            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return picture == null ? super.getPreferredSize() : new Dimension(picture.getWidth() * 4, picture.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int y = getHeight() - picture.getHeight();
        g.drawImage(picture, xPos, y, this);

    }

}*/

class ImageComponent extends JPanel{
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
