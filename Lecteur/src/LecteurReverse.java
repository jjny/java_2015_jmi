import java.io.IOException;

public class LecteurReverse extends LecteurFichier
{
	public LecteurReverse(String n) 
	{
		super(n);
		// TODO Auto-generated constructor stub
	}	
	
	public void affiche() throws IOException{
		lireFichier();
		System.out.print("Lecture à l'envers :\n");
		
		for(int i = this.contenu.size()-1; i >=0 ; i--)
			System.out.print(this.contenu.get(i));	
	}
}
