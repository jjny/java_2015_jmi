import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

public class LecteurLine extends LecteurFichier{
	
	
	private BufferedReader br;


	public LecteurLine(String n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	
	
	public void affiche() {
		
		int sizeArray =contenu.size();
		br = null;
		try{
		
			String line;
		
			
			while ((line = br.readLine()) != null) {
			System.out.println(line);
		
			}
		}
		catch (IOException ioe) {

			System.out.println("Erreur --" + ioe.toString());
		}

	}
	
	


}
