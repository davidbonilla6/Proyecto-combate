import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class WeaponContainer {
	ArrayList<Weapon> ArrayWeapons=new ArrayList<Weapon>();
	
	public WeaponContainer() {
		String url="jdbc:mysql://localhost/battle_data_base?serverTimezone=UTC";
		String user="root";
		String password="superlocal";
		String query="select * from weapon";
		
		try {
			//Data Base connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, user, password);
			String update="";
			Statement st;
			st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery(query);
			makeArray(rs,ArrayWeapons);		
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("No se ha podido cargar el driver");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se ha podido establecer la conexion");
		}
	}
	
	public static void makeArray(ResultSet rs,ArrayList ArrayWeapons) {
		try {
			while (rs.next()) {//It takes the data of each weapon and stores it in the Array
				//Image i=Toolkit.getDefaultToolkit().getImage(rs.getString(3));
				String i = null;
				ArrayWeapons.add(new Weapon(rs.getInt(1), rs.getString(2), i,rs.getInt(4),rs.getInt(5),rs.getString(6),rs.getInt(7)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
