import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import backend.Habitat;
import backend.InfoHabitats;
import backend.Mineur;

public class InfoHabitat extends JFrame implements ActionListener, ItemListener{

	 Mineur mn = new Mineur();
	 
		public String deps1 = "", departs="";
		  JPanel pform, panel;
		    JTextField tdate, tnom, tadd, tdeparts, tcom; 
		    JRadioButton dep1, dep2, dep3, dep4, dep5, dep6, dep7, dep8, dep9, dep10;
		    JButton save, del;
		    JRadioButton m, f;
		  public String sexe="";
		  Choice sta, par, hab;
		  JTable tab;
		  
	public InfoHabitat() {
		 pform = new JPanel();
		    
	    	JLabel date = new JLabel("Commune");
			tcom = new JTextField();
			
			JLabel nom = new JLabel("Habitat");
			tnom = new JTextField();
			
			JLabel prenom = new JLabel("Adresse");
			tadd = new JTextField();
			
			JLabel  parent = new JLabel("Proprietaire");
			
			JLabel status = new JLabel("Status");
			
			JLabel  tdepart = new JLabel("Departements");
			
			par = new Choice();
			par.addItem("");
	
			 try {

				 mn.selectAllPersonne().forEach((data) -> par.add(data));
				
			} catch (ClassNotFoundException e1) {

				e1.printStackTrace();
			}

			sta = new Choice();
			hab = new Choice();
			
			sta.addItem("");
			sta.addItem("Detruite");
			sta.addItem("A Demolir");
			sta.addItem("A Reparer");
			
			hab.addItem("");
			hab.addItem("Maison");
			hab.addItem("Hotel");
			hab.addItem("Eglise");
	        
			ButtonGroup dep=new ButtonGroup();  
			
	    	dep1 = new JRadioButton("Art");
	    	dep2 = new JRadioButton("Cen");
	    	dep3= new JRadioButton("G.Anse");
	    	dep4 = new JRadioButton("Nip");
	    	dep5 = new JRadioButton("Ouest");
	    	dep6 = new JRadioButton("Nord");
	    	dep7 = new JRadioButton("N.est");
	    	dep8 = new JRadioButton("N.ouest");
	    	dep9 = new JRadioButton("Sud");
	    	dep10 = new JRadioButton("S.est");
	    	
	    	dep.add(dep1);
	    	dep.add(dep2);
	    	dep.add(dep3);
	    	dep.add(dep4);
	    	dep.add(dep5);
	    	dep.add(dep6);
	    	dep.add(dep7);
	    	dep.add(dep8);
	    	dep.add(dep9);
	    	dep.add(dep10);
	    	
			save = new JButton("Enregistrer");
			del = new JButton("Supprimer");
			
			panel = new JPanel();
			GridLayout gl = new GridLayout(17, 2);
			
			panel.setLayout(gl);

			panel.add(nom);
			panel.add(hab);
			panel.add(prenom);
			panel.add(tadd);
			panel.add(date);
			panel.add(tcom);
			panel.add(tdepart);
			panel.add(dep1);
			panel.add(dep2);
			panel.add(dep3);
			panel.add(dep4);
			panel.add(dep5);
			panel.add(dep6);
			panel.add(dep7);
			panel.add(dep8);
			panel.add(dep9);
			panel.add(dep10);
			panel.add(new JRadioButton(""));
			panel.add(parent);
			panel.add(par);
			panel.add(status);
			panel.add(sta);
			panel.add(save);
			panel.add(del);

			save.addActionListener(this);
			del.addActionListener(this);

			sta.addItemListener(this);
			par.addItemListener(this);
			
	    	pform.add(panel);
	    	
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(dep1.isSelected()) {
			departs = "Art";
		}
		if(dep2.isSelected()) {
			departs = "Centre";
		}
		if(dep3.isSelected()) {
			departs = "G-Anse";
		} 
		if(dep4.isSelected()) {
			departs = "Nippes";
		}
		if(dep5.isSelected()) {
			departs = "Ouest";
		}
		if(dep6.isSelected()) {
			departs = "Nord";
		}
		if(dep7.isSelected()) {
			departs = "N-est";
		} 
		if(dep8.isSelected()) {
			departs = "N-ouest";
		}
		if(dep9.isSelected()) {
			departs = "Sud";
		}
		if(dep10.isSelected()) {
			departs = "Sud-est";
		}
		
		if(e.getSource()==save) {
			
			if(departs.length() > 0 && hab.getSelectedItem().length() > 0 && sta.getSelectedItem().length() > 0 && tadd.getText().length() > 0 && tcom.getText().length() > 0 && par.getSelectedItem().length() > 0) {
				String habitat = hab.getSelectedItem();
				String commune = tcom.getText();
				String adresse = tadd.getText();
				String status = sta.getSelectedItem();
				String pparent = par.getSelectedItem();
				String[] parent = par.getSelectedItem().split(" ");
				int parentId =  Integer.parseInt(parent[0]);
				
				String departm = par.getSelectedItem();
				//System.out.println(habitat+" "+commune+" "+adresse+" "+status+" "+parentId+" "+departs);
				Habitat ha = new Habitat();
				InfoHabitats infohabitat = new InfoHabitats();
				
				infohabitat.setType(habitat);
				infohabitat.setCommune(commune);
				infohabitat.setAdresse(adresse);
				infohabitat.setDepartement(departm);
				infohabitat.setProprietaire(parentId);
				infohabitat.setStatus(status);
				
				try {
					ha.enregistrer(infohabitat);
					tcom.setText("");
					tadd.setText("");
					departs = "";
					JOptionPane.showMessageDialog(new JFrame(), "Enregistrer");
				}catch(Exception excp) {
					excp.printStackTrace();
				}
			
				
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "Remplissez tous les champs");
			}
		}
		
	}
}
