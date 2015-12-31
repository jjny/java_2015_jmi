package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class PrintCard implements ActionListener {
	
	  private JTextField scanNom;
	  private JTextField scanPv;
	  private JTextField scanLevel;
	  private JTextField scanNumber;
	
	public PrintCard(JTextField scanNom,JTextField scanNumber,JTextField scanLevel,JTextField scanPv){
		 this.scanNom = scanNom;
		 this.scanPv = scanPv;
		 this.scanLevel = scanLevel;
		 this.scanNumber = scanNumber;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Nom pokemon : "+scanNom.getText()+"\n"+
						   "PV pokemon : "+scanPv.getText()+"\n"+
						   "Number pokemon : "+scanNumber.getText()+"\n"	
							);	
		
	}

}
