package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ButtonListener {
	JLabel jta;
	GUI_card gui;
	
	public ButtonListener(){
		 this.jta= new JLabel();
		 GUI_card gui=new GUI_card();
		 
		
	}
	
	
		public void actionPerformed(ActionEvent e){
			String s=e.getActionCommand();
					
			if(s.equals("Add"))
				gui.addCard();

			if(s.equals("Search"))
				gui.searchCard();			
			
			if(s.equals("Update"))
				gui.update();
			
			if(s.equals("Delete"))
				gui.delete();
			
			if(s.equals("Exit")){
				System.exit(0);
			}
			
			if(s.equals("Back"))
			{
				jta.removeAll();
				gui.start();
				jta.updateUI();
			}	
						
			if(s.equals("Pokemon"))
				gui.addPokemonCard();			
		
			if(s.equals("Energy"))
				gui.addEnergyCard();
			
			if(s.equals("Trainer"))
				gui.addTrainerCard();
			
			if(s.equals("By number"))
				gui.searchByNumber();
			
			if(s.equals("By type"))
				gui.searchByType();
		}	
	}
	


