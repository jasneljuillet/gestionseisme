import javax.swing.*;
import javax.swing.border.LineBorder;

import backend.InfoTremblementTerre;
import backend.Tremblement;

import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.*;

public class InfoTremblement  extends JFrame implements ActionListener, ItemListener {
	public static final String DateFormat = "dd/MM/yyyy";

	public String deps1 = "", departs="";
	
	public static String now(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat(DateFormat);
		return format.format(cal.getTime());
	}
       
	private Tremblement tr = new Tremblement();
	
    JPanel pform, panel, ptitre;
    JTextField tdate, tmagnitude, tdeparts, tcom; 
    JButton enreg, sup;
    JCheckBox dep1, dep2, dep3, dep4, dep5, dep6, dep7, dep8, dep9, dep10;
    
    public InfoTremblement(){

    	JLabel titre = new JLabel("Information Tremblement de terre");
    	titre.setFont(new Font("Verdana",1,15));
    	
    	pform = new JPanel();
//    	pform.setLayout(null);
//    	pform.setLayout(new GridLayout(2,0,0,0));
   
    	ptitre = new JPanel();
    
    	
//    	ptitre.setLayout(null);
//    	ptitre.setLayout(new GridLayout(3,3,0,0));
//    	ptitre.add((titre));
    	
    
    	dep1 = new JCheckBox("Art");
    	dep2 = new JCheckBox("Cen");
    	dep3= new JCheckBox("G.Anse");
    	dep4 = new JCheckBox("Nip");
    	dep5 = new JCheckBox("Ouest");
    	dep6 = new JCheckBox("Nord");
    	dep7 = new JCheckBox("N.est");
    	dep8 = new JCheckBox("N.ouest");
    	dep9 = new JCheckBox("Sud");
    	dep10 = new JCheckBox("S.est");
    	
    	JLabel date = new JLabel("Date JJ/MM/AA");
		tdate = new JTextField();
		tdate.setText(now());
		
		JLabel magnitude = new JLabel("Magnitude");
		tmagnitude = new JTextField();
		
		JLabel  tdepart = new JLabel("Departements");
		
		JLabel comm = new JLabel("Communes");
		tcom = new JTextField();
		
		enreg = new JButton("Enregistrer");
		sup = new JButton("Supprimer");
		
		panel = new JPanel();
		GridLayout gl = new GridLayout(10, 2);
		
		panel.setLayout(gl);
		
		panel.add(date);
		panel.add(tdate);
		panel.add(magnitude);
		panel.add(tmagnitude);
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
		
		panel.add(new Checkbox(""));
//		panel.add(tdeparts);
		panel.add(comm);
		
		panel.add(tcom);
		panel.add(enreg);
		panel.add(sup);

		enreg.addActionListener(this);
		sup.addActionListener(this);
		
		dep1.addItemListener(this);
		pform.add(ptitre);
    	pform.add(panel);
    	
    	
    	    	
    }
    
    
  
    public void itemStateChanged(ItemEvent e) {
    	
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource()==enreg) {
    		
    		if(dep1.isSelected()) {
    			departs = departs+" Art";
    		} else {
    			departs = departs;
    		}
    		if(dep2.isSelected()) {
    			departs = departs+" Centre";
    		} else {
    			departs = departs;
    		}
    		if(dep3.isSelected()) {
    			departs = departs+" G-Anse";
    		} else {
    			departs = departs;
    		}
    		if(dep4.isSelected()) {
    			departs = departs+" Nippes";
    		} else {
    			departs = departs;
    		}
    		if(dep5.isSelected()) {
    			departs = departs+" Ouest";
    		} else {
    			departs = departs;
    		}
    		if(dep6.isSelected()) {
    			departs = departs+" Nord";
    		} else {
    			departs = departs;
    		}
    		if(dep7.isSelected()) {
    			departs = departs+" N-est";
    		} else {
    			departs = departs;
    		}
    		if(dep8.isSelected()) {
    			departs = departs+" N-ouest";
    		} else {
    			departs = departs;
    		}
    		if(dep9.isSelected()) {
    			departs = departs+" Sud";
    		} else {
    			departs = departs;
    		}
    		if(dep10.isSelected()) {
    			departs = departs+" Sud-est";
    		} else {
    			departs = departs;
    		}
    		
    		String date = tdate.getText().trim();
    		String communes = tcom.getText().trim();
//    		String depart =  tdeparts.getText().trim();
    		
    		if(communes.length() > 0 && date.length() > 0  && tmagnitude.getText().length() >0 ) {
    			float magni = Float.parseFloat(tmagnitude.getText().trim());
    			InfoTremblementTerre trem = new InfoTremblementTerre();
    			System.out.println(departs);

        		trem.setDate(date);
        		trem.setMagnitude(magni);
        		trem.setDepartements(departs);
        		trem.setCommunes(communes);
      		
        		tdate.setText(now());
        		tcom.setText("");
//        		tdeparts.setText("");
        		tmagnitude.setText("");
        		departs = "";
        		
        		
        		try {
        		tr.enregistrer(trem);
        		JOptionPane.showMessageDialog(new JFrame(), "Enregistrer");
        			
        		}catch(Exception exc) {
        			System.out.println(exc);
        		}
        		
    		} else {
    			System.out.println(departs);
    			departs = "";
    			JOptionPane.showMessageDialog(new JFrame(), "Remplissez tous les champs");
    		}
    		
   
    	} else if (e.getSource()==sup) {
    		tdate.setText(now());
    		tcom.setText("");
    		tmagnitude.setText("");
    	}
    }
}