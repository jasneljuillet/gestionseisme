import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import backend.Habitat;
import backend.Majeur;
import backend.Tremblement;

public class DepartAucunVictime {

	JPanel ptab;
	JTable tab;
	DefaultTableModel modelmineur;
	
	Majeur maj = new Majeur();
	Habitat hbt = new Habitat();
	Tremblement dp = new Tremblement();
	
	String listremove = "";
	Object[] row = new Object[2];
	
	public DepartAucunVictime() throws ClassNotFoundException, SQLException {
		ptab = new JPanel();
		tab = new JTable();
		
		Object[] colonne = {"Departements", "Seisme"};
		
		modelmineur = new DefaultTableModel();
		modelmineur.setColumnIdentifiers(colonne);
		tab.setModel(modelmineur);

		JScrollPane sc = new JScrollPane(tab);
		Class.forName("com.mysql.jdbc.Driver");
		
		ResultSet re = null, hb = null, tr = null;
		
		re = maj.majeurdepartcommune();
		hb = hbt.habitatdepartements();
		tr = dp.departements();
		
		Set<String> set = new HashSet<>();
		Set<String> deplist = new HashSet<>();
		
		deplist.add("Art");
		deplist.add("Centre");
		deplist.add("G-Anse");
		deplist.add("Nippes");
		deplist.add("Ouest");
		deplist.add("Nord");
		deplist.add("N-est");
		deplist.add("N-ouest");
		deplist.add("Sud");
		deplist.add("Sud-est");
		
		while(hb.next()) {
			set.add(hb.getString("habitat.departement"));
		}
		
		while(re.next()) {
			set.add(re.getString("majeurs.departement"));
		}
	
		while(tr.next()) {
			row[1] = tr.getString("infotremblement.date");
		}
		set.forEach( (data) -> {
			listremove = listremove+" "+data;
		});
	
		String [] tetchaje = listremove.split(" ");
		for(int i = 0; i < tetchaje.length; i++) {
			if(tetchaje[i].length() > 0) {
				deplist.remove(tetchaje[i]);
			}
			
		}
		
		deplist.forEach( (list) -> {
			row[0] = list;
			modelmineur.addRow(row);
		});
		
		ptab.add(sc);
	}
}
