import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class WarriorContainer {
	ArrayList<Warrior> ArrayWarriors=new ArrayList<Warrior>();
	
	public WarriorContainer() {
		String url="jdbc:mysql://localhost/battle_data_base?serverTimezone=UTC";
		String user="root";
		String password="superlocal";
		String query="select * from race";
		try {
			//Data Base Connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, user, password);
			String update="";
			Statement st;
			st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery(query);
			makeArray(rs,ArrayWarriors);
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("No se ha podido cargar el driver");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se ha podido establecer la conexion");
		}
	}
	
	public static void makeArray(ResultSet rs,ArrayList ArrayWarriors) {
		try {
			while (rs.next()) {//It takes the data of each warrior and stores it in the Array
				//Weapon w=new Weapon(rs.getString(9));
				//Image i=Toolkit.getDefaultToolkit().getImage(rs.getString(8));
							
				ArrayWarriors.add(new Warrior(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6),rs.getInt(7),rs.getInt(8)));	
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
