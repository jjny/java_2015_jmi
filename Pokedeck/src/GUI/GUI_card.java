package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GUI_card extends JFrame{
	 JFrame window = new JFrame("GUI_Card_Minfir");
	 JPanel jta=new JPanel();
	
	public void start(){
		
		window.setSize(800,500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jta.setLayout(new GridLayout(3,2));
		
		Color tabColor[]={new Color(0xC71585),new Color(0xFF8C00),new Color(0x4682B4),new Color(0xD2B48C),new Color(0xFF69B4),new Color(0x008080)};
		String label[]={"Add","Update","Search","Card game","Delete","Exit"};
	
		for(int i=0;i<tabColor.length;i++){
				JButton button=new JButton(label[i]);
				button.setBackground(tabColor[i]);
			
				jta.add(button);
				
				button.setForeground(Color.white);
				
				BoutonListener blis=new BoutonListener();
				button.addActionListener(blis);			
		}		              
                createMenu();	

          window.add(jta);                
          window.pack();
          window.setLocationRelativeTo(null);
          window.setVisible(true);
	}
	
	private void createMenu(){
		
		JMenuBar menuBar= new JMenuBar();
		menuBar.setBackground(Color.BLACK);	
		
		JMenu menu = new JMenu("File");
		menu.addSeparator();
		
		menu.setForeground(Color.white);
		
		ActionListener m= new ExportMenuListener();
		
		JMenuItem mi_export = new JMenuItem("sauvegarder");
		mi_export.addActionListener(m);
		mi_export.setForeground(Color.white);
		mi_export.setBackground(Color.BLACK);
		menu.add(mi_export);
		
		JMenuItem mi_import = new JMenuItem("charger");
		
		mi_import.addActionListener(m);
		mi_import.setForeground(Color.white);
		mi_import.setBackground(Color.BLACK);
		
		menu.add(mi_import);
		
		menuBar.add(menu);
		menuBar.setVisible(true);
		
		window.setJMenuBar(menuBar);
	}

	public JPanel addCard(){
		jta.removeAll();
		jta.setLayout(new GridLayout(4,1));
	
		JButton pokemon = new JButton("Pokemon");
		JButton energy = new JButton("Energy");
		JButton trainer = new JButton("Trainer");
		
		   jta.add(pokemon);
		   jta.add(energy);
		   jta.add(trainer);
		   
		   JPanel footer=new JPanel(new BorderLayout());
		   JButton back=new JButton("Back");
		   
		   BoutonListener blis=new BoutonListener();
		   pokemon.addActionListener(blis);
		   energy.addActionListener(blis);
		   trainer.addActionListener(blis);
			back.addActionListener(blis);
			
			footer.add(back,BorderLayout.CENTER);
			
			jta.add(footer);
	        
		   window.pack();
	        jta.updateUI();
	        return jta;	
	}
	
	
	public JPanel addEnergyCard(){
		jta.removeAll();
		jta.setLayout(new BorderLayout());

		JPanel p1 = new JPanel(new GridBagLayout());

        JLabel number = new JLabel("Number");
		JLabel energy = new JLabel("Energy");

		JTextField scanNumber = new JTextField(10);
		
		String[] energyList = {" Grass "
				 , " Fire "
				 , " Water "
		         , "Lightning "
		         , " Psychic "
		         , "  Fightning "
		         , "  Darkness "
		         , "  Metal "
		         , "  Fairy "
		         , "  Dragon "
		         , "  Colorless "};
 
		JComboBox energyBox = new JComboBox(energyList);
		
		 JButton b1 =new JButton("ADD!");
		 JButton back=new JButton("Back");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        p1.add(number, gbc);  
       
        gbc.gridy ++;
        p1.add(energy, gbc);
        
        gbc.gridy++;
        p1.add(back, gbc);
       
        gbc.gridx = 1;
        gbc.gridy = 0;     
        p1.add(scanNumber, gbc);
       
       	gbc.gridy++;
        p1.add(energyBox, gbc);
        
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
         p1.add(b1, gbc);     
        
        b1.setBackground(new Color(0x00CCFF));      
        
        BoutonListener blis=new BoutonListener();
		back.addActionListener(blis);
        
        jta.add(p1);
        window.pack();
        jta.updateUI();
        return jta;
	}
	
	public JPanel addPokemonCard(){
		jta.removeAll();
		jta.setLayout(new BorderLayout());

		JPanel p1 = new JPanel(new GridBagLayout());

       JLabel name = new JLabel("Name ");
		JLabel number = new JLabel("Number Card ");
		JLabel level = new JLabel("Level");
		JLabel pv = new JLabel("PV");
		
		JTextField scanName = new JTextField(10);
		JTextField scanNumber= new JTextField(10);
		JTextField scanLevel= new JTextField(10);
		JTextField scanPv = new JTextField(10);
		
		 JButton b1 =new JButton("ADD!");
		 JButton back=new JButton("Back");
		 
       GridBagConstraints gbc = new GridBagConstraints();
       gbc.anchor = GridBagConstraints.WEST;
       gbc.gridx = 0;
       gbc.gridy = 0;
       p1.add(name, gbc);  
      
       gbc.gridy ++;
       p1.add(number, gbc);
       
       gbc.gridy++;               
       p1.add(level, gbc);
       
       gbc.gridy++;               
       p1.add(pv, gbc);
       
       gbc.gridy++;
       p1.add(back, gbc);
      
       gbc.gridx = 1;
       gbc.gridy = 0;     

       p1.add(scanName, gbc);
      
       gbc.gridy++;
      	p1.add(scanNumber, gbc);
      
      	gbc.gridy++;
       p1.add(scanLevel, gbc);
       
       gbc.gridy++;
       p1.add(scanPv, gbc);
       
       gbc.gridy++;
       gbc.anchor = GridBagConstraints.CENTER;
        p1.add(b1, gbc);
       
       b1.setBackground(new Color(0x00CCFF));
       
       BoutonListener blis=new BoutonListener();
		back.addActionListener(blis);
       
       jta.add(p1);
       window.pack();
       jta.updateUI();
       return jta;	
	}
	
	public JPanel addTrainerCard(){
		jta.removeAll();
		jta.setLayout(new BorderLayout());

		JPanel p1 = new JPanel(new GridBagLayout());

       JLabel name = new JLabel("Name ");
		JLabel number = new JLabel("Number Card ");
		JLabel trainer = new JLabel("Trainer type");
		JLabel infos= new JLabel("Infos");
		
		JTextField scanName = new JTextField(10);
		JTextField scanNumber= new JTextField(10);		
		JTextField scanInfos = new JTextField(10);
		
		String[] trainerList = {" Item "
				 , " Supporte "
				 , " Stadium "};

		JComboBox trainerBox = new JComboBox(trainerList);

		 JButton b1 =new JButton("ADD!");
		 JButton back=new JButton("Back");

       GridBagConstraints gbc = new GridBagConstraints();
       gbc.anchor = GridBagConstraints.WEST;
       gbc.gridx = 0;
       gbc.gridy = 0;
       p1.add(name, gbc);  
      
       gbc.gridy ++;
       p1.add(number, gbc);
       
       gbc.gridy++;               
       p1.add(trainer, gbc);
       
       gbc.gridy++;               
       p1.add(infos, gbc);
       
       gbc.gridy++;
       p1.add(back, gbc);
      
       gbc.gridx = 1;
       gbc.gridy = 0;     
       p1.add(scanName, gbc);
      
       gbc.gridy++;
      	p1.add(scanNumber, gbc);
      
      	gbc.gridy++;
       p1.add(trainerBox, gbc);
       
       gbc.gridy++;
       p1.add(scanInfos, gbc);
       
       gbc.gridy++;
       gbc.anchor = GridBagConstraints.CENTER;
        p1.add(b1, gbc);
       
       b1.setBackground(new Color(0x00CCFF));
       
       BoutonListener blis=new BoutonListener();
		back.addActionListener(blis);
       
       jta.add(p1);
       window.pack();
	
       jta.updateUI();
       return jta;	
	}
	
	public JPanel searchCard(){
		jta.removeAll();
		jta.setLayout(new GridLayout(4,1));
	
		JButton byNumber = new JButton("By card number");
		JButton byType = new JButton("By card type");
		
		   jta.add(byNumber);
		   jta.add(byType);
		 
		   
		   JPanel footer=new JPanel(new BorderLayout());
		   JButton back=new JButton("Back");
		   
		   BoutonListener blis=new BoutonListener();
		   byNumber.addActionListener(blis);
		   byType.addActionListener(blis);
			back.addActionListener(blis);
			
			footer.add(back,BorderLayout.CENTER);
			
			jta.add(footer);
	        
		   window.pack();
	        jta.updateUI();
	        return jta;	
	}
	
	public JPanel searchByNumber(){
		jta.removeAll();
		jta.setLayout(new BorderLayout());

		JPanel p1 = new JPanel(new GridBagLayout());

        JLabel number = new JLabel("Card number");
		JTextField scanNumber = new JTextField(10);
		
		 JButton b1 =new JButton("Search !");
		 JButton back=new JButton("Back");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        p1.add(number, gbc);  
        
        gbc.gridy++;
        p1.add(back, gbc);
       
        gbc.gridx = 1;
        gbc.gridy = 0;     
        p1.add(scanNumber, gbc);
       
        
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
         p1.add(b1, gbc);     
        
        b1.setBackground(new Color(0x00CCFF));      
        
        BoutonListener blis=new BoutonListener();
		back.addActionListener(blis);
        
        jta.add(p1);
        window.pack();
        jta.updateUI();
        return jta;
		
	}
	
	public JPanel searchByType(){
		jta.removeAll();
		jta.setLayout(new BorderLayout());

		JPanel p1 = new JPanel(new GridBagLayout());

        JLabel type = new JLabel("Card type");
		JTextField scanType = new JTextField(10);
		
		 JButton b1 =new JButton("Search !");
		 JButton back=new JButton("Back");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        p1.add(type, gbc);  
        
        gbc.gridy++;
        p1.add(back, gbc);
       
        gbc.gridx = 1;
        gbc.gridy = 0;     
        p1.add(scanType, gbc);
       
        
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
         p1.add(b1, gbc);     
        
        b1.setBackground(new Color(0x00CCFF));      
        
        BoutonListener blis=new BoutonListener();
		back.addActionListener(blis);
        
        jta.add(p1);
        window.pack();
        jta.updateUI();
        return jta;
		
	}

	public JPanel delete(){
		jta.removeAll();
		jta.setLayout(new BorderLayout());

		JPanel p1 = new JPanel(new GridBagLayout());

        JLabel number = new JLabel("Card number");
		JTextField scanNumber = new JTextField(10);
		
		 JButton b1 =new JButton("Delete !");
		 JButton back=new JButton("Back");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        p1.add(number, gbc);  
        
        gbc.gridy++;
        p1.add(back, gbc);
       
        gbc.gridx = 1;
        gbc.gridy = 0;     
        p1.add(scanNumber, gbc);
       
        
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
         p1.add(b1, gbc);     
        
        b1.setBackground(new Color(0x00CCFF));      
        
        BoutonListener blis=new BoutonListener();
		back.addActionListener(blis);
        
        jta.add(p1);
        window.pack();
        jta.updateUI();
        return jta;
		
	}
	
	public JPanel update(){
		jta.removeAll();
		jta.setLayout(new BorderLayout());

		JPanel p1 = new JPanel(new GridBagLayout());

        JLabel number = new JLabel("Card number");
		JTextField scanNumber = new JTextField(10);
		
		 JButton b1 =new JButton("Update !");
		 JButton back=new JButton("Back");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        p1.add(number, gbc);  
        
        gbc.gridy++;
        p1.add(back, gbc);
       
        gbc.gridx = 1;
        gbc.gridy = 0;     
        p1.add(scanNumber, gbc);
       
        
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
         p1.add(b1, gbc);     
        
        b1.setBackground(new Color(0x00CCFF));      
        
        BoutonListener blis=new BoutonListener();
		back.addActionListener(blis);
        
        jta.add(p1);
        window.pack();
        jta.updateUI();
        return jta;
		
	}
	
	
	
	public class BoutonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String s=e.getActionCommand();
					
			if(s.equals("Add"))
				addCard();

			if(s.equals("Search"))
				searchCard();			
			
			if(s.equals("Update"))
				update();
			
			if(s.equals("Delete"))
				delete();
			
			if(s.equals("Exit")){
				System.exit(0);
			}
			
			if(s.equals("Back"))
			{
				jta.removeAll();
				start();
				jta.updateUI();
			}	
						
			if(s.equals("Pokemon"))
				addPokemonCard();			
		
			if(s.equals("Energy"))
				addEnergyCard();
			
			if(s.equals("Trainer"))
				addTrainerCard();
			
			if(s.equals("By number"))
				searchByNumber();
			
			if(s.equals("By type"))
				searchByType();
		}	
	}
	
	private class CloseListener implements ActionListener{
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        System.exit(0);
	    }
	}
}