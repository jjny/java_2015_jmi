import java.io.IOException;

public class MainLecteur 
{
	
	public static void main(String[] args) throws IOException  
	{
		LecteurFichier lec1=new LecteurFichier("C:/Users/jminf/workspace/Lecteur/test.txt");
		LecteurReverse lec2=new LecteurReverse("C:/Users/jminf/workspace/Lecteur/test.txt");
		LecteurPalindrome lec3= new LecteurPalindrome("C:/Users/jminf/workspace/Lecteur/test.txt");
		
		lec1.affiche();		 
		lec2.affiche();	
		lec3.affiche();
	}
}
