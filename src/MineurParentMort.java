import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import backend.Mineur;

public class MineurParentMort extends JFrame {
	
	JPanel ptab;
	JTable tab;
	DefaultTableModel modelmineur;
	Mineur mn = new Mineur();
	
	Object[] row = new Object[7];
	
	public MineurParentMort() throws ClassNotFoundException {

	ptab = new JPanel();
	tab = new JTable();
	
	Object[] colonne = {"M-nom", "M-pre", "M-sexe", "M-Nais","Depart", "Commune", "Parent"};
	
	modelmineur = new DefaultTableModel();
	modelmineur.setColumnIdentifiers(colonne);
	tab.setModel(modelmineur);

	JScrollPane sc = new JScrollPane(tab);
//	tab.setBackground(Color.PINK);
	sc.setAlignmentX(CENTER_ALIGNMENT);
	Class.forName("com.mysql.jdbc.Driver");
	
	
	ResultSet re = null;
	re = mn.minuerparentmort();
	
	try {
		while(re.next()) {
			row[0] = re.getString("mineurs.nom");
			row[1] = re.getString("mineurs.prenom");
			row[2] = re.getString("mineurs.sexe");
			row[3] = re.getString("mineurs.datenaissance");
			row[4] = re.getString("majeurs.departement");
			row[5] = re.getString("majeurs.commune");
			row[6] = re.getString("majeurs.nom")+" "+re.getString("majeurs.prenom");
			modelmineur.addRow(row);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	ptab.add(sc);

	}
}

