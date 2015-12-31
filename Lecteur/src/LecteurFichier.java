import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LecteurFichier implements Lecteur
{
	private File file;
	protected String name;
	protected ArrayList<Character> contenu;
	
	public LecteurFichier(String n) 
	{
		this.name=n;
		this.contenu =new ArrayList<Character>();
	}
	
	/**
	 * Vérification l'existence du fichier et s'il peut être lu.
	 * @return boolean.
	 */	
	public boolean openAndCheck()  
	{
	
		System.out.println("\n\nFichier \"" + name + "\"\n");
		file = new File(name);
		return this.file.exists() && this.file.canRead();
	}
	
	/**
	 * Lecture du fichier
	 * @return contenu
	 */
	
	public ArrayList<Character> lireFichier() throws IOException
	{	
		 InputStream is = null; 
	      InputStreamReader isr = null;
	      BufferedReader br = null;

	      try{
	    	  if (this.openAndCheck()) {
	         is = new FileInputStream(file);
	         isr = new InputStreamReader(is);
	         br = new BufferedReader(isr);
	         int value=0;
	         
	         while((value = br.read()) != -1){
	            //char c = (char)value;
	            contenu.add((char) value);	           
	         }
	    	  }  
	      }catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         
	         if(is!=null)
	            is.close();
	         if(isr!=null)
	            isr.close();
	         if(br!=null)
	            br.close();
	      }
		return contenu;
	}
	
	/**
	 * Affiche le fichier
	 */
	
	public void affiche() throws IOException
	{
		ArrayList<Character> contenu=lireFichier();
		System.out.println("Lecture simple :");
		
		for(Character elem: contenu)
	       {
	       	 System.out.print (elem);
	       }
	}
}
