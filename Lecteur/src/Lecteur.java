import java.io.IOException;
import java.util.ArrayList;

public interface Lecteur 
{
	
	public boolean openAndCheck();
	
	public ArrayList<Character> lireFichier() throws IOException;
	
	public void affiche() throws IOException;
	
}

