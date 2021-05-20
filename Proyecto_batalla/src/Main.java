import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost/battle_data_base?serverTimezone=UTC";
		String user="root";
		String password="superlocal";
		String query="select * from weapon";
		ArrayList<Weapon> ArrayWeapons=new ArrayList<Weapon>();
		ArrayList<Warrior> ArrayWarriors=new ArrayList<Warrior>();
		
		try {
			//Data Base connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, user, password);
			String update="";
			Statement st;
			st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery(query);	
			WeaponContainer.makeArray(rs, ArrayWeapons);
			for (Weapon p: ArrayWeapons) {
				System.out.println(p);
			}
			query="select * from race";
			ResultSet rs=st.executeQuery(query);
			WarriorContainer.makeArray(rs, ArrayWarriors);
			for (Warrior p: ArrayWarriors) {
				System.out.println(p);
			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("No se ha podido cargar el driver");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se ha podido establecer la conexion");
		}
		
		
	}

		
}

	

