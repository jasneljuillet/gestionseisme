
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

import backend.InfoMajeurs;
import backend.Majeur;
import backend.Tremblement;
import backend.InfoMineurs;
public class InfoMajeur  extends JFrame implements ActionListener, ItemListener {
	public String deps1 = "", departs="";
	  JPanel pform, panel;
	    JTextField tdate, tnom, tprenom, tdeparts, tcom; 
	    JRadioButton dep1, dep2, dep3, dep4, dep5, dep6, dep7, dep8, dep9, dep10;
	    JButton save, del;
	    JRadioButton m, f;
	  public String sexe="";
	  Choice sta, seis;
	public InfoMajeur() {
		pform = new JPanel();
	    
		JPanel pdeps = new JPanel();
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
    	
    	JLabel date = new JLabel("Date Naiss JJ/MM/AA");
		tdate = new JTextField();
//		tdate.setText(now());
		
		JLabel nom = new JLabel("Nom");
		tnom = new JTextField();
		
		JLabel prenom = new JLabel("Prenom");
		tprenom = new JTextField();
		
		JLabel seisme = new JLabel("Seisme");
		
		JPanel psex = new JPanel();
		GridLayout gls = new GridLayout(1, 2);
		psex.setLayout(gls);
		
		JLabel sexe = new JLabel("Sexe");
		m=new JRadioButton("M");    
		f=new JRadioButton("F"); 
		ButtonGroup bg=new ButtonGroup();    
		bg.add(m);
		bg.add(f);    
		psex.add(m);
		psex.add(f);
		
		JLabel  tdepart = new JLabel("Departements");
		
		JLabel comm = new JLabel("Communes");
		tcom = new JTextField();
		
		JLabel status = new JLabel("Status");
		
		sta = new Choice();
		seis =  new Choice();
		seis.add("");
		
		Tremblement tr = new Tremblement();
		
		 try {

			 tr.select().forEach((data) -> seis.add(data));
			
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}
		 
		sta.addItem("");
		sta.addItem("Mort(e)");
		sta.addItem("Amputes d'un pied");
		sta.addItem("Amputes deux pieds");
		sta.addItem("Amputes d'un bras");
		sta.addItem("Amputes deux bras");
		sta.addItem("Autre");
		
		save = new JButton("Enregistrer");
		del = new JButton("Supprimer");
		
		panel = new JPanel();
		GridLayout gl = new GridLayout(14, 2);
		
		panel.setLayout(gl);

		panel.add(nom);
		panel.add(tnom);
		panel.add(prenom);
		panel.add(tprenom);
		panel.add(sexe);
		panel.add(psex);
		panel.add(date);
		panel.add(tdate);
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
		panel.add(seisme);
		panel.add(seis);
		
		panel.add(comm);
		panel.add(tcom);
		panel.add(status);
		panel.add(sta);
		panel.add(save);
		panel.add(del);

		save.addActionListener(this);
		del.addActionListener(this);

		dep1.addItemListener(this);
		sta.addItemListener(this);
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
		// 
		if( m.isSelected()) {
			sexe = "M";
		} 
		if(f.isSelected()) {
			sexe = "F";
		}
		
		InfoMajeurs maj = new InfoMajeurs();
		Majeur mj = new Majeur();
		
		if(e.getSource() == save) {
			if(tprenom.getText().length() > 0 && tnom.getText().length() > 0 && tcom.getText().length() > 0 && tdate.getText().length() > 0 && sexe.length() > 0 && departs.length() > 0 && sta.getSelectedItem().length() > 0 && seis.getSelectedItem().length() > 0) {
				String nom = tnom.getText().trim();
				String prenom = tprenom.getText().trim();
				String communes = tcom.getText().trim();
				String date = tdate.getText().trim();
				String status = sta.getSelectedItem();
				
				String[] tremblement = seis.getSelectedItem().split("id: ");
				int tremblementId =  Integer.parseInt(tremblement[1]);
						
				maj.setNom(nom);
				maj.setPrenom(prenom);
				maj.setSexe(sexe);
				maj.setDepartement(departs);
				maj.setStatus(status);
				maj.setDatenaissance(date);
				maj.setCommune(communes);	
				maj.setSeisme(tremblementId);
			
				try {
					mj.enregistrer(maj);
					tnom.setText("");
					tprenom.setText("");
					tcom.setText("");
					sexe = "";
					departs = "";
					sta.equals(false);
					
					JOptionPane.showMessageDialog(new JFrame(), "Enregistrer");
				}catch(Exception excp) {
					excp.printStackTrace();
				}
			
				
			
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "Remplissez tous les champs");
			}
		} 
		else if (e.getSource() == del ) {
			
		}
		
	}
}
