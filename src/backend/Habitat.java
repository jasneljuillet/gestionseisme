package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Habitat {
	DB db = new DB();
	
	public int enregistrer(InfoHabitats hab) throws ClassNotFoundException {
		
		String insert = "INSERT INTO habitat" + " ( type, commune, adresse, departement, proprietaire, "
				+ " status ) VALUES " + 
				" (?, ?, ?, ?, ?, ?);" ;
		
		int result = 0;
		Class.forName("com.mysql.jdbc.Driver");
		
		try( Connection connection = DriverManager.getConnection(db.getDb(), db.getUser(), db.getPsw());
				PreparedStatement stmt = connection.prepareStatement(insert)) {
			
				stmt.setString(1, hab.getType());
				stmt.setString(2, hab.getCommune());
				stmt.setString(3, hab.getAdresse());
				stmt.setString(4, hab.getDepartement());
				stmt.setInt(5, hab.getProprietaire());
				stmt.setString(6, hab.getStatus());
				
				System.out.println(stmt);
				result = stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
public ResultSet habitattype() throws ClassNotFoundException{
		
		ResultSet re = null;
		Class.forName("com.mysql.jdbc.Driver");
		
		try {
			
			Connection connection = DriverManager.getConnection(db.getDb(), db.getUser(), db.getPsw());
			Statement stmt = (Statement) connection.createStatement();
			re = stmt.executeQuery("select * from habitat");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return re;
	}

public ResultSet habitatdepartements() throws ClassNotFoundException{
	
	ResultSet hb = null;
	Class.forName("com.mysql.jdbc.Driver");
	
	try {
		
		Connection connection = DriverManager.getConnection(db.getDb(), db.getUser(), db.getPsw());
		Statement stmt = (Statement) connection.createStatement();
		hb = stmt.executeQuery("select habitat.departement from habitat inner join majeurs where habitat.proprietaire = majeurs.id");
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	return hb;
}
	
}
