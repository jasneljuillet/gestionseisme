

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Arrays;

//1d1e22
import backend.Mineur;
public class Menu extends JFrame implements ActionListener{
	
	Mineur mn = new Mineur();
	
	JPanel panel1, panel2, panel3,pbtn1,pbtn,btn2q, pbtn5, pbtn6, pbtn7, pbtn8, pbtn9, pbtn10;
	JButton btn, btn1,btn2, btn3, btn4, btn5, btn6, btn7, btn8;
	JInternalFrame frame;
	
	public Menu() throws ClassNotFoundException, SQLException { 
		super("Gestion Tremblement De Terre");
		
		panel1 = new JPanel();
		panel1.setLayout(null);
		
		
		panel2 = new JPanel();
		panel2.setBackground(Color.decode("#1d1e22"));
		panel2.setLayout(new GridLayout(16,1,5,5));
		panel2.setBounds(0,0,200,600);
		
		panel3 = new JPanel();
//		panel3.setBackground(Color.decode("#5a3205"));
		panel3.setBounds(210, 0, 550,600);
		panel3.add(new Home().ptab);
		
		pbtn1 = new JPanel();
//		pbtn1.setBackground(Color.YELLOW);
		pbtn1.setBounds(210, 0, 550,600);
		//InfoTremblement form = new InfoTremblement();
		pbtn1.add(new InfoTremblement().pform);
		
		pbtn = new JPanel();
//		pbtn.setBackground(Color.RED);
		pbtn.setBounds(210, 0, 550,600);
		pbtn.add(new InfoMajeur().pform);	
		
		btn2q = new JPanel();
//		btn2q.setBackground(Color.RED);
		btn2q.setBounds(210, 0, 550,600);
		btn2q.add(new InfoMineur().pform);
		
		pbtn5 = new JPanel();
//		pbtn5.setBackground(Color.CYAN);
		pbtn5.setBounds(210, 0, 550,600);
		pbtn5.add(new InfoHabitat().pform);

		pbtn6 = new JPanel();
//		pbtn6.setBackground(Color.darkGray);
		pbtn6.setBounds(210, 0, 550,600);
		pbtn6.add(new MajeurDepartCommune().ptab);
		

		pbtn7 = new JPanel();
//		pbtn7.setBackground(Color.RED);
		pbtn7.setBounds(210, 0, 550,600);
		pbtn7.add(new Majeurdepartement().ptab);
		pbtn8 = new JPanel();
//		pbtn8.setBackground(Color.MAGENTA);
		pbtn8.setBounds(210, 0, 550,600);
		pbtn8.add(new Habitattype().ptab);
		
		pbtn9 = new JPanel();
//		pbtn9.setBackground(Color.pink);
		pbtn9.setBounds(210, 0, 550,600);
		pbtn9.add(new MineurParentMort().ptab);
		
		pbtn10 = new JPanel();
//		pbtn10.setBackground(Color.ORANGE);
		pbtn10.setBounds(210, 0, 550,600);
		pbtn10.add(new DepartAucunVictime().ptab);		
		frame = new JInternalFrame();
		frame.setTitle("Internl frame");
		panel3.add(frame);
		
		panel1.add(panel2);
		panel1.add(panel3);

		btn = new JButton("Tremblement");
		btn1 = new JButton("Majeures");
		btn2 = new JButton("Mineurs");
		btn3 = new JButton("Habitats");
		btn4 = new JButton("Majeurs / Dep/ Com");
		btn5 =  new JButton("Majeurs / Dep/ Com/ Adr");
		btn6 =  new JButton("Habitats/ Ty/ Sta/ Dep/ Com");
		btn7 =  new JButton("Mineurs/ Dep/ Com");
		btn8 = new JButton("Dep/ Aucun/ Victime");
		
		btn.setBackground(Color.WHITE);
		btn.setFocusPainted(false);
		btn.setFont(new Font("Arial", Font.ITALIC,15));
		
		btn1.setBackground(Color.WHITE);
		btn1.setFocusPainted(false);
		btn1.setFont(new Font("Arial", Font.ITALIC,15));
		
		btn2.setBackground(Color.WHITE);
		btn2.setFocusPainted(false);
		btn2.setFont(new Font("Arial", Font.ITALIC,15));
		
		btn3.setBackground(Color.WHITE);
		btn3.setFocusPainted(false);
		btn3.setFont(new Font("Arial", Font.ITALIC,15));
		
		btn4.setBackground(Color.WHITE);
		btn4.setFocusPainted(false);
		btn4.setFont(new Font("Arial", Font.ITALIC,15));
		
		btn5.setBackground(Color.WHITE);
		btn5.setFocusPainted(false);
		btn5.setFont(new Font("Arial", Font.ITALIC,15));
		
		btn6.setBackground(Color.WHITE);
		btn6.setFocusPainted(false);
		btn6.setFont(new Font("Arial", Font.ITALIC,15));
		
		btn7.setBackground(Color.WHITE);
		btn7.setFocusPainted(false);
		btn7.setFont(new Font("Arial", Font.ITALIC,15));
		
		btn8.setBackground(Color.WHITE);
		btn8.setFocusPainted(false);
		btn8.setFont(new Font("Arial", Font.ITALIC,15));
		
		panel2.add(btn);
		panel2.add(btn1);
		panel2.add(btn2);
		panel2.add(btn3);
		panel2.add(btn4);
		panel2.add(btn5);
		panel2.add(btn6);
		panel2.add(btn7);
		panel2.add(btn8);
		
		btn.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		
		getContentPane().add(panel1);
		
		setSize(800, 600);
//		setLocationRelativeTo(null);
		setResizable(false);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String arg[]) throws ClassNotFoundException, SQLException {
		Menu menu = new Menu();
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btn) {
			
			if(panel1.add(pbtn) != null) {
				pbtn.hide();
				panel1.add(pbtn1);
				pbtn1.show();
			}
			if(panel1.add(pbtn8) != null) {
				pbtn8.hide();
				panel1.add(pbtn1);
				pbtn1.show();
			}
			if(panel1.add(pbtn6) != null ) {
				pbtn6.hide();
				panel1.add(pbtn1);
				pbtn1.show();
			}
			if(panel1.add(pbtn5) != null ) {
				pbtn5.hide();
				panel1.add(pbtn1);
				pbtn1.show();
			}
			if(panel1.add(btn2q) != null ) {
				btn2q.hide();
				panel1.add(pbtn1);
				pbtn1.show();
			}
			if(panel1.add(pbtn9) != null) {
				pbtn9.hide();
				panel1.add(pbtn1);
				pbtn1.show();
			}
			if(panel1.add(pbtn10) != null ) {
				pbtn10.hide();
				panel1.add(pbtn1);
				pbtn1.show();
			}
			if(panel1.add(pbtn5) != null ) {
				pbtn5.hide();
				panel1.add(pbtn1);
				pbtn1.show();
			}
			if(panel1.add(pbtn7) != null ) {
				pbtn7.hide();
				panel1.add(pbtn1);
				pbtn1.show();
			}
			if(panel1.add(panel3) != null ) {
				panel3.hide();
			}

		} else if(e.getSource()== btn1) {
			
			if(panel1.add(pbtn1) != null ) {
				pbtn1.hide();
				panel1.add(pbtn);
				pbtn.show();
			}
			if(panel1.add(pbtn5) != null ) {
				pbtn5.hide();
				panel1.add(pbtn);
				pbtn.show();
			}
			if(panel1.add(pbtn8) != null) {
				pbtn8.hide();
				panel1.add(pbtn);
				pbtn.show();
			}
			if(panel1.add(pbtn6) != null ) {
				pbtn6.hide();
				panel1.add(pbtn);
				pbtn.show();
			}
			if(panel1.add(pbtn9) != null) {
				pbtn9.hide();
				panel1.add(pbtn);
				pbtn.show();
			}
			if(panel1.add(btn2q) != null ) {
				btn2q.hide();
				panel1.add(pbtn);
				pbtn.show();
			}
			if(panel1.add(pbtn5) != null ) {
				pbtn5.hide();
				panel1.add(pbtn);
				pbtn.show();
			}
			if(panel1.add(pbtn7) != null ) {
				pbtn7.hide();
				panel1.add(pbtn);
				pbtn.show();
			}
			if(panel1.add(pbtn10) != null ) {
				pbtn10.hide();
				panel1.add(pbtn);
				pbtn.show();
			}
			if(panel1.add(panel3) != null ) {
				panel3.hide();
			}

		} else if(e.getSource()==btn2) {

			if(panel1.add(pbtn1) != null ) {
				pbtn1.hide();
				panel1.add(btn2q);
				btn2q.show();
			}
			if(panel1.add(pbtn5) != null ) {
				pbtn5.hide();
				panel1.add(btn2q);
				btn2q.show();
			}
			if(panel1.add(pbtn8) != null) {
				pbtn8.hide();
				panel1.add(btn2q);
				btn2q.show();
			}
			if(panel1.add(pbtn5) != null ) {
				pbtn5.hide();
				panel1.add(btn2q);
				btn2q.show();
			}
			if(panel1.add(pbtn6) != null ) {
				pbtn6.hide();
				panel1.add(btn2q);
				btn2q.show();
			}
			if(panel1.add(pbtn7) != null ) {
				pbtn7.hide();
				panel1.add(btn2q);
				btn2q.show();
			}
			if(panel1.add(pbtn9) != null) {
				pbtn9.hide();
				panel1.add(btn2q);
				btn2q.show();
			}
			if(panel1.add(pbtn) != null ) {
				pbtn.hide();
				panel1.add(btn2q);
				btn2q.show();
			}
			if(panel1.add(pbtn5) != null ) {
				pbtn5.hide();
				panel1.add(btn2q);
				btn2q.show();
			}
			if(panel1.add(pbtn10) != null ) {
				pbtn10.hide();
				panel1.add(btn2q);
				btn2q.show();
			}
			if(panel1.add(panel3) != null ) {
				panel3.hide();
			}
		}
			
			else if(e.getSource()==btn3) {
				if(panel1.add(btn2q) != null ) {
					btn2q.hide();
					panel1.add(pbtn5);
					pbtn5.show();
				}
				if(panel1.add(pbtn5) != null ) {
					pbtn5.hide();
					panel1.add(pbtn5);
					pbtn5.show();
				}
				if(panel1.add(pbtn8) != null) {
					pbtn8.hide();
					panel1.add(pbtn5);
					pbtn5.show();
				}
				if(panel1.add(pbtn6) != null ) {
					pbtn6.hide();
					panel1.add(pbtn5);
					pbtn5.show();
				}
				if(panel1.add(pbtn9) != null) {
					pbtn9.hide();
					panel1.add(pbtn5);
					pbtn5.show();
				}
				if(panel1.add(pbtn1) != null ) {
					pbtn1.hide();
					panel1.add(pbtn5);
					pbtn5.show();
				}
				if(panel1.add(pbtn) != null ) {
					pbtn.hide();
					panel1.add(pbtn5);
					pbtn5.show();
				}
				if(panel1.add(pbtn7) != null ) {
					pbtn7.hide();
					panel1.add(pbtn5);
					pbtn5.show();
				}
				if(panel1.add(pbtn10) != null ) {
					pbtn10.hide();
					panel1.add(pbtn5);
					pbtn5.show();
				}
				
				if(panel1.add(panel3) != null ) {
					panel3.hide();
				}				
			
		}else if(e.getSource()==btn4) {
		
			if(panel1.add(btn2q) != null ) {
				btn2q.hide();
				panel1.add(pbtn6);
				pbtn6.show();
			}
			if(panel1.add(pbtn5) != null ) {
				pbtn5.hide();
				panel1.add(pbtn6);
				pbtn6.show();
			}
			if(panel1.add(pbtn8) != null) {
				pbtn8.hide();
				panel1.add(pbtn6);
				pbtn6.show();
			}
			if(panel1.add(pbtn5) != null ) {
				pbtn5.hide();
				panel1.add(pbtn6);
				pbtn6.show();
			}
			if(panel1.add(pbtn9) != null) {
				pbtn9.hide();
				panel1.add(pbtn6);
				pbtn6.show();
			}
			if(panel1.add(pbtn1) != null ) {
				pbtn1.hide();
				panel1.add(pbtn6);
				pbtn6.show();
			}
			if(panel1.add(pbtn7) != null ) {
				pbtn7.hide();
				panel1.add(pbtn6);
				pbtn6.show();
			}
			if(panel1.add(pbtn) != null ) {
				pbtn.hide();
				panel1.add(pbtn6);
				pbtn6.show();
			}
			if(panel1.add(pbtn10) != null ) {
				pbtn10.hide();
				panel1.add(pbtn6);
				pbtn6.show();
			}
			
			if(panel1.add(panel3) != null ) {
				panel3.hide();
			}				
		
			
		}else if(e.getSource()==btn5) {
//			

			if(panel1.add(pbtn) != null) {
				pbtn.hide();
				panel1.add(pbtn7);
				pbtn7.show();
			}
			if(panel1.add(pbtn8) != null) {
				pbtn8.hide();
				panel1.add(pbtn7);
				pbtn7.show();
			}
			if(panel1.add(pbtn6) != null ) {
				pbtn6.hide();
				panel1.add(pbtn7);
				pbtn7.show();
			}
			if(panel1.add(pbtn5) != null ) {
				pbtn5.hide();
				panel1.add(pbtn7);
				pbtn7.show();
			}
			if(panel1.add(btn2q) != null ) {
				btn2q.hide();
				panel1.add(pbtn7);
				pbtn7.show();
			}
			if(panel1.add(pbtn9) != null) {
				pbtn9.hide();
				panel1.add(pbtn7);
				pbtn7.show();
			}
			if(panel1.add(pbtn10) != null ) {
				pbtn10.hide();
				panel1.add(pbtn7);
				pbtn7.show();
			}
			if(panel1.add(pbtn5) != null ) {
				pbtn5.hide();
				panel1.add(pbtn7);
				pbtn7.show();
			}
			if(panel1.add(pbtn7) != null ) {
				pbtn7.hide();
				panel1.add(pbtn7);
				pbtn7.show();
			}
			if(panel1.add(pbtn1) != null ) {
				pbtn1.hide();
				panel1.add(pbtn7);
				pbtn7.show();
			}
			if(panel1.add(panel3) != null ) {
				panel3.hide();
			}

			
		}else if(e.getSource()==btn6) {
			
			if(panel1.add(btn2q) != null ) {
				btn2q.hide();
				panel1.add(pbtn8);
				pbtn8.show();
			}
			if(panel1.add(pbtn5) != null ) {
				pbtn5.hide();
				panel1.add(pbtn8);
				pbtn8.show();
			}
			if(panel1.add(pbtn5) != null ) {
				pbtn5.hide();
				panel1.add(pbtn8);
				pbtn8.show();
			}
			if(panel1.add(pbtn9) != null) {
				pbtn9.hide();
				panel1.add(pbtn8);
				pbtn8.show();
			}
			if(panel1.add(pbtn1) != null ) {
				pbtn1.hide();
				panel1.add(pbtn8);
				pbtn8.show();
			}
			if(panel1.add(pbtn) != null ) {
				pbtn.hide();
				panel1.add(pbtn8);
				pbtn8.show();
			}
			if(panel1.add(pbtn6) != null ) {
				pbtn6.hide();
				panel1.add(pbtn8);
				pbtn8.show();
			}
			if(panel1.add(pbtn7) != null ) {
				pbtn7.hide();
				panel1.add(pbtn8);
				pbtn8.show();
			}
			if(panel1.add(pbtn10) != null ) {
				pbtn10.hide();
				panel1.add(pbtn8);
				pbtn8.show();
			}
			
			if(panel1.add(panel3) != null ) {
				panel3.hide();
			}				
		
			
		}else if(e.getSource()==btn7) {
			try {
				mn.minuerparentmort();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(panel1.add(pbtn) != null) {
				pbtn.hide();
				panel1.add(pbtn9);
				pbtn9.show();
			}
			if(panel1.add(pbtn5) != null ) {
				pbtn5.hide();
				panel1.add(pbtn9);
				pbtn9.show();
			}
			if(panel1.add(pbtn8) != null) {
				pbtn8.hide();
				panel1.add(pbtn9);
				pbtn9.show();
			}
			if(panel1.add(pbtn6) != null ) {
				pbtn6.hide();
				panel1.add(pbtn9);
				pbtn9.show();
			}
			if(panel1.add(pbtn1) != null) {
				pbtn1.hide();
				panel1.add(pbtn9);
				pbtn9.show();
			}
			if(panel1.add(pbtn5) != null ) {
				pbtn5.hide();
				panel1.add(pbtn9);
				pbtn9.show();
			}
			if(panel1.add(pbtn7) != null ) {
				pbtn7.hide();
				panel1.add(pbtn9);
				pbtn9.show();
			}
			if(panel1.add(btn2q) != null ) {
				btn2q.hide();
				panel1.add(pbtn9);
				pbtn9.show();
			}
			if(panel1.add(pbtn10) != null ) {
				pbtn10.hide();
				panel1.add(pbtn9);
				pbtn9.show();
			}
			if(panel1.add(panel3) != null ) {
				panel3.hide();
			}

		}else if(e.getSource()==btn8) {
			if(panel1.add(pbtn) != null) {
				pbtn.hide();
				panel1.add(pbtn10);
				pbtn10.show();
			}
			if(panel1.add(pbtn5) != null ) {
				pbtn5.hide();
				panel1.add(pbtn10);
				pbtn10.show();
			}
			if(panel1.add(pbtn8) != null) {
				pbtn8.hide();
				panel1.add(pbtn10);
				pbtn10.show();
			}
			if(panel1.add(pbtn6) != null ) {
				pbtn6.hide();
				panel1.add(pbtn10);
				pbtn10.show();
			}
			if(panel1.add(pbtn5) != null ) {
				pbtn5.hide();
				panel1.add(pbtn10);
				pbtn10.show();
			}
			if(panel1.add(btn2q) != null ) {
				btn2q.hide();
				panel1.add(pbtn10);
				pbtn10.show();
			}
			if(panel1.add(pbtn9) != null) {
				pbtn9.hide();
				panel1.add(pbtn10);
				pbtn10.show();
			}
			if(panel1.add(pbtn1) != null ) {
				pbtn1.hide();
				panel1.add(pbtn10);
				pbtn10.show();
			}
			if(panel1.add(pbtn7) != null ) {
				pbtn7.hide();
				panel1.add(pbtn10);
				pbtn10.show();
			}
			if(panel1.add(panel3) != null ) {
				panel3.hide();
			}

			pbtn10.show();
		} else {
		
		
		}
			
	}

}
