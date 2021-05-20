import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Conection {
	public void Conection() {
		String url="jdbc:mysql://localhost/battle_data_base?serverTimezone=UTC";
		String user="root";
		String password="root";
		String query="select * from weapon";
		ArrayList<Weapon> ArrayWeapons=new ArrayList<Weapon>();
		try {
			//Data Base connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, user, password);
			String update="";
			Statement st;
			st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery(query);	
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("No se ha podido cargar el driver");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se ha podido establecer la conexion");
		}
	}
	public void insertar_player(String user_name, Connection con) {
		try {
			String query="Select * from players";
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery(query);
			int random_id = (int) (Math.random()*10000+1);
			rs.moveToInsertRow();
			rs.updateInt(1, random_id);
			rs.updateString(2, user_name);
			rs.insertRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void ranking(Warrior warrior, Player player, int points, Connection con) {
		String query="Select * from players";
		Statement st;
		try {
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery(query);
			rs.moveToInsertRow();
			rs.updateInt(1, player.player_id);
			rs.updateInt(2, points);
			rs.updateInt(3, warrior.getId());
			rs.insertRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
