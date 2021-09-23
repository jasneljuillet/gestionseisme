import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import backend.Majeur;
import backend.Mineur;

public class MajeurDepartCommune {

	JPanel ptab;
	JTable tab;
	DefaultTableModel modelmineur;
	Majeur maj = new Majeur();
	
	Object[] row = new Object[9];
	
	public MajeurDepartCommune() throws ClassNotFoundException {
		
		ptab = new JPanel();
		tab = new JTable();
		
		Object[] colonne = {"Nom", "Pre", "Sexe", "D-Nais","Depart", "Commune", "Satus", "S.Date", "S.mag"};
		
		modelmineur = new DefaultTableModel();
		modelmineur.setColumnIdentifiers(colonne);
		tab.setModel(modelmineur);

		JScrollPane sc = new JScrollPane(tab);
//		tab.setBackground(Color.PINK);
		Class.forName("com.mysql.jdbc.Driver");
		
		
		ResultSet re = null;
		re = maj.majeurdepartcommune();
		
		try {
			while(re.next()) {
				row[0] = re.getString("majeurs.nom");
				row[1] = re.getString("majeurs.prenom");
				row[2] = re.getString("majeurs.sexe");
				row[3] = re.getString("majeurs.datenaissance");
				row[4] = re.getString("majeurs.departement");
				row[5] = re.getString("majeurs.commune");
				row[6] = re.getString("majeurs.status");
				row[7] = re.getString("infotremblement.date");
				row[8] = re.getString("infotremblement.magnitude");
				
				modelmineur.addRow(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ptab.add(sc);
		
	}
}
