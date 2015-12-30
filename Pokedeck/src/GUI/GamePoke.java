package GUI;
	import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

	import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpringLayout;




	public class GamePoke extends JFrame{

		JPanel jta=new JPanel();
		Container c=this.getContentPane();

		public void start(){
				   
		    this.setTitle("POKEDECK - MINFIR");
			this.setSize(500,400);
			jta.setBackground(Color.white);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
			this.init();
		}

		public JPanel init(){
			
			c.add(panelNord(),BorderLayout.NORTH);
			c.add(mainPanel(),BorderLayout.CENTER);
			//c.add(panelSud(),BorderLayout.SOUTH);
			//c.add(panelOuest(),BorderLayout.WEST);
			c.add(jta,BorderLayout.CENTER);
			return jta;
		}
		
		
		public JPanel panelNord(){
			JPanel jpan=new JPanel();
			JLabel text=new JLabel("POKEDECK - MINFIR");
			jpan.add(text);	
			return jpan;
		}
		
		public JPanel mainPanel(){
				jta.setLayout(new GridLayout(2,1,1,1));
			
			
			JButton charger=new JButton("charger");
			JButton nouveauJeu=new JButton("Nouveau jeu");
			
			charger.setBackground(new Color(0x008080));
			nouveauJeu.setBackground(new Color(0xFF8C00));
			charger.setForeground(Color.white);
			nouveauJeu.setForeground(Color.white);
			
			jta.add(charger);	
			jta.add(nouveauJeu);	
			
			BoutonListener blis=new BoutonListener();
			charger.addActionListener(blis);
			nouveauJeu.addActionListener(blis);
			
			jta.setBackground(Color.white);
			
			return jta;
		}
		
		
		public JPanel submenuPanel(){
			jta.removeAll();
			jta.setLayout(new GridLayout(4,1,10,10));
			
			Color tabColor[]={new Color(0xC71585),new Color(0xFF8C00),new Color(0x4682B4),new Color(0xD2B48C),new Color(0xFF69B4),new Color(0x008080),new Color(0xDC143C)};
			String option[]={"add a card","delete a card","consult the card game","update a card","search a card","save","exit"};
			
			for(int i=0;i<tabColor.length;i++){
					JButton button=new JButton(option[i]);
					button.setBackground(tabColor[i]);
						
					jta.add(button);
					
					button.setForeground(Color.white);
					
					BoutonListener blis=new BoutonListener();
					button.addActionListener(blis);
					
			}
			jta.updateUI();
			return jta;
		}
		
		
		public JPanel searchMenuPanel(){
			jta.removeAll();
			Color tabColor[]={new Color(0xC71585),new Color(0xFF8C00),new Color(0x4682B4),new Color(0xD2B48C)};
			String option[]={"search by card number","search by card type","search by card name","back"};
			
			for(int i=0;i<tabColor.length;i++){
					JButton button=new JButton(option[i]);
					button.setBackground(tabColor[i]);
						
					jta.add(button);
					
					button.setForeground(Color.white);
					
					BoutonListener blis=new BoutonListener();
					button.addActionListener(blis);
					
			}
			jta.updateUI();
			return jta;
		}
		
		
		public String[] getStateStrings() {
	        String[] typeCard = {
	            "Pokemon",
	            "Energy",
	            "Stadium",
	        };
	        return typeCard;
		} 
		
		
		public JPanel addPanel(){
		
			jta.removeAll();
			jta.setBackground(new Color(0x9ACD32));
			jta.setLayout(new GridLayout(2,1,1,1));
			//jta.setLayout(new SpringLayout());
			// SpringLayout layout = new SpringLayout();
			// c.setLayout(layout);
			
			
				JTextField type2=new JTextField();
				type2.setColumns(10);
		        
		        
		        JLabel type=new JLabel("type",JLabel.TRAILING);
		        
		        type.setLabelFor(type2);
		        
		        
		        
		        JButton ok= new JButton("OK");
		        JButton cancel= new JButton("Cancel");
		        /*
		        JLabel box = new JLabel("Une ComboBox");
		        JComboBox listTypeCard=new JComboBox();
		        listTypeCard.setPreferredSize(new Dimension(200, 20));
		        listTypeCard.addItem("Pokemon");
		        listTypeCard.addItem("Energy");
		        listTypeCard.addItem("Stadium");
		        jta.add(box);
		        jta.add(listTypeCard);*/
		        //SpringUtilities.makeCompactGrid(jta, type, 2, 5, 5, 5, 5);
		        
		        
		       jta.add(type);
		        jta.add(type2);
		        jta.add(ok);
		        jta.add(cancel);
		        
		      

		     
		        
		        
			jta.updateUI();
			return jta;
		}
		
		public class BoutonListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				String s=e.getActionCommand();
				
				if(s.equals("charger")){
					JOptionPane.showMessageDialog(null,"fichier telechargé");
					
				}
				
				if(s.equals("Nouveau jeu")){
					submenuPanel();
				}
				
				if(s.equals("add a card")){
					addPanel();
				}	
				
				if(s.equals("search a card")){
					searchMenuPanel();
				}
				
				if(s.equals("exit")){
					jta.removeAll();//JOptionPane.showMessageDialog(null,"exit réussit");
					mainPanel();
					jta.updateUI();
				}
				
				if(s.equals("back")){
					jta.removeAll();//JOptionPane.showMessageDialog(null,"exit réussit");
					submenuPanel();
					jta.updateUI();
				}
				
				
				
			}
		}
		
	

}
