package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ExportMenuListener implements ActionListener {

	/*private JMenuItem mi_import;
	private JMenuItem mi_export;
	
	public ExportMenuListener(JMenuItem mi_import,JMenuItem mi_export){
		 this.mi_import = mi_import;
		 this.mi_export = mi_export;
		
	}*/
	
	public void actionPerformed(ActionEvent e) {
		String s=e.getActionCommand();
		
	
	if(s.equals("charger")){
		JOptionPane.showMessageDialog(null,"carte chargé");
	}else{
		JOptionPane.showMessageDialog(null,"carte sauvegardé");
	}
	}
	
}	
