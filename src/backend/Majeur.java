package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Majeur {

	DB db = new DB();
public int enregistrer(InfoMajeurs maj) throws ClassNotFoundException {
		
		String insert = "INSERT INTO majeurs" + " ( nom, prenom, sexe, departement, status, datenaissance, "
				+ " commune, seisme ) VALUES " + 
				" (?, ?, ?, ?, ?, ?, ?, ?);" ;
		
		int result = 0;
		Class.forName("com.mysql.jdbc.Driver");
		
		try( Connection connection = DriverManager.getConnection(db.getDb(), db.getUser(), db.getPsw());
				PreparedStatement stmt = connection.prepareStatement(insert)) {
			
				stmt.setString(1, maj.getNom());
				stmt.setString(2, maj.getPrenom());
				stmt.setString(3, maj.getSexe());
				stmt.setString(4, maj.getDepartement());
				stmt.setString(5, maj.getStatus());
				stmt.setString(6, maj.getDatenaissance());
				stmt.setString(7, maj.getCommune());
				stmt.setInt(8, maj.getSeisme());
				
//				System.out.println(stmt);
				result = stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}


public ResultSet majeurdepartcommune() throws ClassNotFoundException{
	
	ResultSet re = null;
	Class.forName("com.mysql.jdbc.Driver");
	
	try {
		
		Connection connection = DriverManager.getConnection(db.getDb(), db.getUser(), db.getPsw());
		Statement stmt = (Statement) connection.createStatement();
		re = stmt.executeQuery("Select majeurs.nom, majeurs.prenom, majeurs.sexe, majeurs.datenaissance, majeurs.departement, majeurs.commune, majeurs.status, infotremblement.magnitude, infotremblement.date from majeurs inner join infotremblement where majeurs.seisme = infotremblement.id");
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	return re;
	}

public ResultSet majeurdepartements() throws ClassNotFoundException{
	
	ResultSet re = null;
	Class.forName("com.mysql.jdbc.Driver");
	
	try {
		
		Connection connection = DriverManager.getConnection(db.getDb(), db.getUser(), db.getPsw());
		Statement stmt = (Statement) connection.createStatement();
		re = stmt.executeQuery("select majeurs.departement from majeurs inner join infotremblement where majeurs.seisme = infotremblemen.id");
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	return re;
}

public ResultSet majeurdepartcommuneadresse() throws ClassNotFoundException{
	
	ResultSet re = null;
	Class.forName("com.mysql.jdbc.Driver");
	
	try {
		
		Connection connection = DriverManager.getConnection(db.getDb(), db.getUser(), db.getPsw());
		Statement stmt = (Statement) connection.createStatement();
		re = stmt.executeQuery("select majeurs.nom, majeurs.prenom, majeurs.commune, majeurs.departement, infotremblement.date, habitat.adresse from majeurs inner join infotremblement on majeurs.seisme = infotremblement.id inner join habitat on majeurs.id = habitat.proprietaire");
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	return re;
	}

}
