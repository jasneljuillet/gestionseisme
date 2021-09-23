import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import backend.Habitat;
import backend.Majeur;
import backend.Tremblement;


public class Home extends JFrame {

	JPanel ptab;
	JTable tab;
	DefaultTableModel modelmineur;

	Object[] row = new Object[1];
	
	public Home() throws ClassNotFoundException {
		ptab = new JPanel();
		tab = new JTable();
		
		Object[] colonne = {"Information du Programme"};
		
		modelmineur = new DefaultTableModel();
		modelmineur.setColumnIdentifiers(colonne);
		tab.setModel(modelmineur);

		JScrollPane sc = new JScrollPane(tab);
		Class.forName("com.mysql.jdbc.Driver");
		
		ptab.add(sc);
		
		
	}
	
}
