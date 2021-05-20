import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ranking {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost/battle_data_base?serverTimezone=UTC";
		String user="root";
		String password="superlocal";
		String query="Select * from ranking";
		
		try {
			//Data Base connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, user, password);
			String update="";
			Statement st;
			st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String query1="select* from players";
			
			ResultSet rs2=st.executeQuery(query1);
			
			ResultSet rs=st.executeQuery(query);
			insertarFila(rs);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("No se ha podido cargar el driver");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No se ha podido establecer la conexion");
		}
	}
	public static void insertarFila(ResultSet rs) {
		Player p1=new Player(2,""); 
		Weapon w1=new Weapon(1,"sword","image",1,1,"human",10);
		Warrior ww1=new Warrior(5,50,5,5,6,3,"JOSE", "img",w1,20);
		int TotalPoints=40;
		try {
			rs.moveToInsertRow();
			rs.updateInt(1, 2);
			rs.updateInt(2, TotalPoints);
			rs.updateInt(3, ww1.getId());
			rs.insertRow();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	}


