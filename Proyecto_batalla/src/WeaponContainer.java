import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class WeaponContainer {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost/battle_data_base?serverTimezone=UTC";
		String user="root";
		String password="P@ssw0rd";
		String query="select * from weapon";
		ArrayList<Weapon> ArrayWeapons=new ArrayList<Weapon>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, user, password);
			String update="";
			Statement st;
			st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery(query);
			crearArray(rs,ArrayWeapons);
			
			for(Weapon p:ArrayWeapons) {
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
	
	public static void crearArray(ResultSet rs,ArrayList ArrayWarriors) {
		try {
			while (rs.next()) {
				Weapon w=new Weapon(rs.getString(9));
				Image i=Toolkit.getDefaultToolkit().getImage(rs.getString(3));
							
				ArrayWarriors.add(new Weapon(rs.getInt(1), rs.getString(2), i,rs.getInt(4),rs.getInt(5),rs.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
