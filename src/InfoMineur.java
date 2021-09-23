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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import backend.Mineur;
import backend.InfoMineurs;

public class InfoMineur extends JFrame implements ActionListener, ItemListener {

	 Mineur mn = new Mineur();
	 
	public String deps1 = "", departs="";
	  JPanel pform, panel;
	    JTextField tdate, tnom, tprenom, tdeparts, tcom; 
	    JRadioButton dep1, dep2, dep3, dep4, dep5, dep6, dep7, dep8, dep9, dep10;
	    JButton save, del;
	    JRadioButton m, f;
	  public String sexe="";
	  Choice sta, par;
	  JTable tab;
	  public InfoMineur() {
		  
		  pform = new JPanel();
		    
	    	JLabel date = new JLabel("Date Naiss");
			tdate = new JTextField();
			tdate.setText("JJ/MM/AA");
//			tdate.setText(now());
			
			JLabel nom = new JLabel("Nom");
			tnom = new JTextField();
			
			JLabel prenom = new JLabel("Preom");
			tprenom = new JTextField();
			
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
			
			JLabel  parent = new JLabel("Parent");
			
			JLabel status = new JLabel("Status");
			
			par = new Choice();
			par.addItem("");
	
			 try {

				 mn.select().forEach((data) -> par.add(data));
				
			} catch (ClassNotFoundException e1) {

				e1.printStackTrace();
			}

			sta = new Choice();
			sta.addItem("");
			sta.addItem("Amputes d'un pied");
			sta.addItem("Amputes deux pieds");
			sta.addItem("Amputes d'un bras");
			sta.addItem("Amputes deux bras");
			
	        
			save = new JButton("Enregistrer");
			del = new JButton("Supprimer");
			
			panel = new JPanel();
			GridLayout gl = new GridLayout(10, 2);
			
			panel.setLayout(gl);

			panel.add(nom);
			panel.add(tnom);
			panel.add(prenom);
			panel.add(tprenom);
			panel.add(sexe);
			panel.add(psex);
			panel.add(date);
			panel.add(tdate);
			
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
		if( m.isSelected()) {
			sexe = "M";
		} 
		if(f.isSelected()) {
			sexe = "F";
		}
		
		InfoMineurs infomineur = new InfoMineurs();
		
		if(e.getSource()==save) {
			if(tnom.getText().length() > 0 && tprenom.getText().length() > 0 && tdate.getText().length() > 0 && sexe.length() > 0 && sta.getSelectedItem().length() > 0 && par.getSelectedItem().length() > 0 ) {
				String nom = tnom.getText().trim();
				String prenom = tprenom.getText().trim();
				String date = tdate.getText().trim();
				String status = sta.getSelectedItem();
				
				String[] parent = par.getSelectedItem().split(" ");
				int parentId =  Integer.parseInt(parent[0]);
				
				infomineur.setNom(nom);
				infomineur.setPrenom(prenom);
				infomineur.setDatenaissance(date);
				infomineur.setStatus(status);
				infomineur.setSexe(sexe);
				infomineur.setParent(parentId);
				
				try {
					
					mn.enregistrer(infomineur);
					JOptionPane.showMessageDialog(new JFrame(), "Enregistrer");
					tnom.setText("");
					tprenom.setText("");
					sexe = "";
					sta.equals(false);
					
				}catch( Exception myexcep) {
					myexcep.printStackTrace();
				}
				
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "Remplissez tous les champs");
			}
		}
		
	}
}
