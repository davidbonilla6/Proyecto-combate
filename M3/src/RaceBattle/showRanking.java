package RaceBattle;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class showRanking extends JDialog{
	private JPanel rankingPanel;
	private JButton exit;
	private String urlPhoto="images/backgrounds/ranking.png";
	private String urlDB= "jdbc:mysql://localhost/battle_data_base?serverTimezone=UTC";
	private String userDB= "root";
	private String passDB= "rootroot";

	public showRanking(JFrame j, boolean modal) {
		super(j, modal);
		initComponentsRanking();
		rankingPanel.setLayout(new BorderLayout());
		rankingPanel.add(exit, BorderLayout.SOUTH);

		exit.addActionListener(new ActionListener() { @Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(urlDB, userDB, passDB);
			System.out.println("[!] Connection established.");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("[!] Driver has not loaded correctly.");		
		} catch (SQLException e) {
			System.out.println("[!] ERROR. Connection lost.");
		}System.out.println(" ");
		
		add(rankingPanel);
		setSize(550,550);
		setTitle("RANKING");
		setResizable(false);
		setVisible(true);
	}
	public void initComponentsRanking() {
		rankingPanel=new ImageComponent(urlPhoto);
		
		exit=new JButton(new ImageIcon("images/buttons/exit.png"));
		exit.setContentAreaFilled(false);
		exit.setPreferredSize(new Dimension(100,50));
	}
}
