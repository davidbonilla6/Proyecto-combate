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
			rs.updateInt(1, player.getPlayer_id());
			rs.updateInt(2, points);
			rs.updateInt(3, warrior.getId());
			rs.insertRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void battle_final_resume_save(Connection con, int injuries_caused, int injuries_suffered, int battle_points, Weapon weapon_id, Warrior warrior_id, Player player_id, Warrior warrior_enemig, Weapon weapon_enemig) {
		String query="select * from battles";
		Statement st;
		try {
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery(query);
			int random_id = (int) (Math.random()*10000+1);
			rs.moveToInsertRow();
			rs.updateInt(1, random_id);
			rs.updateInt(2, player_id.getPlayer_id());
			rs.updateInt(3, warrior_id.getId());
			rs.updateInt(4, weapon_id.getId());
			rs.updateInt(5, warrior_enemig.getId());
			rs.updateInt(6, weapon_enemig.getId());
			rs.updateInt(7, injuries_caused);
			rs.updateInt(8, injuries_suffered);
			rs.updateInt(9, battle_points);
			rs.insertRow();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ranking_array_resume(Connection con) {
		String query="select * from ranking";
		Statement st;
		ArrayList ArrayRanking=new ArrayList();
		try {
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery(query);
			while (rs.next()) {//It takes the data of each warrior and stores it in the Array
				//Weapon w=new Weapon(rs.getString(9));
				//Image i=Toolkit.getDefaultToolkit().getImage(rs.getString(8));
							
				ArrayRanking.add(String.valueOf(rs.getInt(1)));
				ArrayRanking.add(String.valueOf(rs.getInt(2)));
				ArrayRanking.add(String.valueOf(rs.getInt(3)));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
