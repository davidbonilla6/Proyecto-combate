import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {
		new Menu();

	}

}
class Menu extends JFrame {
	JPanel panel;
	JButton play,chooseWar,chooseWep,exit;
	
	public Menu() {
		this.setSize(300, 200);
		this.setTitle("MENU PRINCIPAL");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponent();
		panel.add(play);
		panel.add(chooseWar);
		panel.add(chooseWep);
		panel.add(exit);
		this.add(panel,BorderLayout.CENTER);
		this.setVisible(true);	
	}
	public void initComponent() {
		panel=new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		play=new JButton("PLAY");
		chooseWar=new JButton("CHOOSE WARRIOR");
		chooseWep=new JButton("CHOOSE WEAPON");
		exit=new JButton("EXIT");		
	}
}
