package backend;

import java.awt.List;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.Arrays;

import com.mysql.jdbc.Statement;

public class Mineur {

	DB db = new DB();
	
public ArrayList<String> select() throws ClassNotFoundException {
//
	
	ArrayList<String> list = new ArrayList<String>();
	
	
		Class.forName("com.mysql.jdbc.Driver");
		
		try {
			
			
			Connection connection = DriverManager.getConnection(db.getDb(), db.getUser(), db.getPsw());
			Statement stmt = (Statement) connection.createStatement();
			ResultSet re = stmt.executeQuery("SELECT * FROM majeurs where status = 'Mort(e)' ");
			 
			while(re.next()) {
			 list.add(re.getString("id")+" "+re.getString("nom")+" "+re.getString("prenom"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return list;
}

public int enregistrer(InfoMineurs min) throws ClassNotFoundException {
	
	String insert = "INSERT INTO mineurs" + " ( nom, prenom, sexe, datenaissance, status, "
			+ " parent ) VALUES " + 
			" (?, ?, ?, ?, ?, ?);" ;
	
	int result = 0;
	Class.forName("com.mysql.jdbc.Driver");
	
	try( Connection connection = DriverManager.getConnection(db.getDb(), db.getUser(), db.getPsw());
			PreparedStatement stmt = connection.prepareStatement(insert)) {
		
			stmt.setString(1, min.getNom());
			stmt.setString(2, min.getPrenom());
			stmt.setString(3, min.getSexe());
			stmt.setString(4, min.getDatenaissance());
			stmt.setString(5, min.getStatus());
			stmt.setInt(6, min.getParent());
		
			System.out.println(stmt);
			result = stmt.executeUpdate();
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return result;
	
}

	public ResultSet minuerparentmort() throws ClassNotFoundException{
		
		ResultSet re = null;
		Class.forName("com.mysql.jdbc.Driver");
		
		try {
			
			Connection connection = DriverManager.getConnection(db.getDb(), db.getUser(), db.getPsw());
			Statement stmt = (Statement) connection.createStatement();
			re = stmt.executeQuery("SELECT mineurs.nom, mineurs.prenom, mineurs.sexe,mineurs.datenaissance, majeurs.nom, majeurs.prenom, majeurs.departement, majeurs.commune, majeurs.status from mineurs INNER JOIN majeurs WHERE mineurs.parent = majeurs.id;");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return re;
	}
	
	
	public ArrayList<String> selectAllPersonne() throws ClassNotFoundException {
		//
			
			ArrayList<String> list = new ArrayList<String>();
			
			
				Class.forName("com.mysql.jdbc.Driver");
				
				try {
					
					
					Connection connection = DriverManager.getConnection(db.getDb(), db.getUser(), db.getPsw());
					Statement stmt = (Statement) connection.createStatement();
					ResultSet re = stmt.executeQuery("SELECT * FROM majeurs");
					 
					while(re.next()) {
					 list.add(re.getString("id")+" "+re.getString("nom")+" "+re.getString("prenom"));
					}
					
				}catch(SQLException e) {
					e.printStackTrace();
				}

				return list;
		}
}
