package RaceBattle;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class chooseWarrior extends JDialog{
	private String urlPhoto="images/backgrounds/dungeon.jpg";
	private JPanel panelChoosingP;
	private JButton bhuman, belf, bdwarf;
	private String electedWarrior="none";
	
	
	public chooseWarrior(JFrame j, boolean modal) {
		super(j,modal);
		setSize(550,550);
		setTitle("CHOOSE WARRIOR");
		 setLayout(new GridLayout());
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponentsChoosePlayer();
		panelChoosingP.add(bhuman);
		bhuman.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				electedWarrior="human";
				dispose();
			}});
		panelChoosingP.add(belf);
		belf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				electedWarrior="elf";
				dispose();
			}});
		panelChoosingP.add(bdwarf);
		bdwarf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				electedWarrior="dwarf";
				dispose();
			}});
		add(panelChoosingP, BorderLayout.CENTER);
		setResizable(false);
        setVisible(true);
	}
	
	public void initComponentsChoosePlayer() {
		//CHOOSE PLAYER's components.
		panelChoosingP=new ImageComponent(urlPhoto);
		
		ImageIcon humanimage=new ImageIcon("images/characters/human.png");
		bhuman=new JButton(humanimage);
		bhuman.setPreferredSize(new Dimension(150, 500));
		bhuman.setContentAreaFilled(false);
		bhuman.setBorderPainted(false);
		ImageIcon elfimage=new ImageIcon("images/characters/elf.png");
		belf=new JButton(elfimage);
		belf.setPreferredSize(new Dimension(150, 500));
		belf.setContentAreaFilled(false);
		belf.setBorderPainted(false);
		ImageIcon dwarfimage=new ImageIcon("images/characters/dwarf.png");
		bdwarf=new JButton(dwarfimage);
		bdwarf.setPreferredSize(new Dimension(150, 500));
		bdwarf.setContentAreaFilled(false);
		bdwarf.setBorderPainted(false);
	}
    
    public String getElection() {
    	return electedWarrior;
    }
}


