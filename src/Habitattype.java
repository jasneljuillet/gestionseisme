import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import backend.Habitat;
import backend.Mineur;

public class Habitattype {

	JPanel ptab;
	JTable tab;
	DefaultTableModel modelmineur;
	Habitat hab = new Habitat();
	
	Object[] row = new Object[5];
	
	public Habitattype() throws ClassNotFoundException {
		ptab = new JPanel();
		tab = new JTable();
		
		Object[] colonne = {"Type", "Status", "Depart", "Com"};
		
		modelmineur = new DefaultTableModel();
		modelmineur.setColumnIdentifiers(colonne);
		tab.setModel(modelmineur);

		JScrollPane sc = new JScrollPane(tab);
		Class.forName("com.mysql.jdbc.Driver");
		
		
		ResultSet re = null;
		re = hab.habitattype();
		
		try {
			while(re.next()) {
				row[0] = re.getString("type");
				row[1] = re.getString("status");
				row[2] = re.getString("departement");
				row[3] = re.getString("commune");
				modelmineur.addRow(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ptab.add(sc);

	}
}
