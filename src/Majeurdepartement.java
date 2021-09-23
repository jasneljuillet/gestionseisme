import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import backend.Habitat;
import backend.Majeur;

public class Majeurdepartement {

	JPanel ptab;
	JTable tab;
	DefaultTableModel modelmineur;
	Majeur maj = new Majeur();
	
	Object[] row = new Object[7];
	
	 public Majeurdepartement() throws ClassNotFoundException {
		 ptab = new JPanel();
			tab = new JTable();
			
			Object[] colonne = {"Nom","Pre", "Commune", "Depart", "Adresse", "Seisme"};
			
			modelmineur = new DefaultTableModel();
			modelmineur.setColumnIdentifiers(colonne);
			tab.setModel(modelmineur);

			JScrollPane sc = new JScrollPane(tab);
			Class.forName("com.mysql.jdbc.Driver");
			
			
			ResultSet re = null;
			re = maj.majeurdepartcommuneadresse();
			
			try {
				while(re.next()) {
					row[0] = re.getString("majeurs.nom");
					row[1] = re.getString("majeurs.prenom");
					row[2] = re.getString("majeurs.commune");
					row[3] = re.getString("majeurs.departement");
					row[4] = re.getString("habitat.adresse");
					row[5] = re.getString("infotremblement.date");
					modelmineur.addRow(row);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ptab.add(sc);
	 }
}
