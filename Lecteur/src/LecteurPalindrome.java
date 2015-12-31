import java.io.IOException;

public class LecteurPalindrome extends LecteurFichier
{

	public LecteurPalindrome(String f)
	{
		super(f);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Affiche le fichier en palindrôme
	 */
	@Override
	public void affiche() throws IOException 
	{
		lireFichier();	
		System.out.println("Lecture Palindrome : ");
		
		for(int i = 0; i < this.contenu.size(); i++)
			System.out.print(this.contenu.get(i));
		for(int i = this.contenu.size()-1; i >=0 ; i--)
			System.out.print(this.contenu.get(i));	
	}
}