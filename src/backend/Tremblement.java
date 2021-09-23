package backend;

import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class Tremblement {

	DB db = new DB();
	
	public int enregistrer(InfoTremblementTerre trem) throws ClassNotFoundException {
		
		String insert = "INSERT INTO infotremblement" + " ( date, magnitude, departements, "
				+ " communes  ) VALUES " + 
				" (?, ?, ?, ?);" ;
		
		int result = 0;
		Class.forName("com.mysql.jdbc.Driver");
		
		try( Connection connection = DriverManager.getConnection(db.getDb(), db.getUser(), db.getPsw());
				PreparedStatement stmt = connection.prepareStatement(insert)) {
				stmt.setString(1, trem.getDate());
				stmt.setFloat(2, trem.getMagnitude());
				stmt.setString(3, trem.getDepartements());
				stmt.setString(4, trem.getCommunes());
				
//				System.out.println(stmt);
				result = stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public ArrayList<String> select() throws ClassNotFoundException {
		//
			
			ArrayList<String> list = new ArrayList<String>();
			
			
				Class.forName("com.mysql.jdbc.Driver");
				
				try {
					
					
					Connection connection = DriverManager.getConnection(db.getDb(), db.getUser(), db.getPsw());
					Statement stmt = (Statement) connection.createStatement();
					ResultSet re = stmt.executeQuery("SELECT * FROM infotremblement ");
					 
					while(re.next()) {
					 list.add(re.getString("date")+" id: "+re.getInt("id"));
					}
					
				}catch(SQLException e) {
					e.printStackTrace();
				}

				return list;
		}
	
	public ResultSet departements() throws ClassNotFoundException{
		
		ResultSet tr = null;
		Class.forName("com.mysql.jdbc.Driver");
		
		try {
			
			Connection connection = DriverManager.getConnection(db.getDb(), db.getUser(), db.getPsw());
			Statement stmt = (Statement) connection.createStatement();
			tr = stmt.executeQuery("SELECT infotremblement.date from majeurs INNER JOIN infotremblement on majeurs.seisme = infotremblement.id INNER JOIN habitat on majeurs.id = habitat.proprietaire");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return tr;
	}
}
