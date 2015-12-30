package bataille;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
//import java.util.Comparator;
//import java.util.List;
import java.util.Scanner;


public class Battle{

	public static void main(String[] args) {
		
		System.out.println("\n\n    ------------------------- \n"
				+  "   |                         |\n"
				+  "   |          NEW PLAY       |\n"
				+  "   |                         |\n"
				+  "    ------------------------- \n");
		// TODO Auto-generated method stub
		
		/* DEMANDE COMBIEN DE CARTE POUR CHAQUE JOUEUR */
		int nbreCartes=0;
		Scanner sc = new Scanner(System.in);
		do{
			try{				
					System.out.println("Initially, how much cards do  you want  for each player ? (1 MIN -26 MAX)"
									+" \n (Régles : egality => +1, win => +2, lose=> 0)  ");
					
					nbreCartes = sc.nextInt();
					sc.nextLine();
				
			}catch (InputMismatchException e) 
			{
				System.out.println("------------------\n"
				  				  +"--Invalid value!--\n"
				  				  +"----Try again----- \n"
				  				  +"------------------\n");
				    sc.nextLine();
			} 
			catch (Exception e)
			{
			  System.out.println(e);
			}	
		}while(nbreCartes<1 || nbreCartes>26);
		
		/* CREATION JEUX DE CARTES VIDES*/
		
		ArrayList<CardBattle> cardGame_j1=new ArrayList<CardBattle>();
		ArrayList<CardBattle> cardGame_j2=new ArrayList<CardBattle>();
		ArrayList<CardBattle> cardsIntoGame=new ArrayList<CardBattle>();	
		
		
		/* CREATION JOUEURS*/
		
		int point_j1=0;
		int point_j2=0;
		Player j1= new Player("j1",cardGame_j1,point_j1);
		Player j2= new Player("j2",cardGame_j2,point_j2);
		
	
		
		/* REMPLISSAGE JEUX DE CARTES */
		
		while (cardGame_j1.size()<nbreCartes){
			
				
			//Math.random()*(MAX-MIN)+MIN	
			int color=(int) (Math.random()*(4-1)+1); //(coeur=1,trefle=2, carreau=3,pique=4)		 
			int value=(int) (Math.random()*(14-2)+2); //(14=AS 13=roi, 12=reine, 11=valet ..... 2=1)
			 
			 // method 'contains' : pour ne pas avoir 2fois la même carte
			
			CardBattle newCarte=new CardBattle(color,value);			 
			if (!cardGame_j1.contains(newCarte) && !cardGame_j2.contains(newCarte)){
				cardsIntoGame.add(newCarte);
				j1.addCard(newCarte);
			}	
		} // end while
		

		while (cardGame_j2.size()<nbreCartes){
			
			//Math.random()*(MAX-MIN)+MIN
			int color=(int) (Math.random()*(5-1)+1); //(coeur=1,trefle=2, carreau=3,pique=4)		 
			int value=(int) (Math.random()*(15-2)+2); //(14=AS 13=roi, 12=reine, 11=valet ..... 2=2)
			 
			
			 
			 // method 'contains' : pour ne pas avoir 2fois la même carte
			CardBattle newCarte=new CardBattle(color,value);
			if (!cardGame_j1.contains(newCarte) && !cardGame_j2.contains(newCarte)){
				cardsIntoGame.add(newCarte);
				j2.addCard(newCarte);
			}
		}//end while
		
		
		/*MELANGE JEUX*/
		
		
		Collections.shuffle(cardGame_j1);
		Collections.shuffle(cardGame_j2);
		
		System.out.println("\n*****CARD GAME PLAYER 1*****");
		for(int i = 0; i < cardGame_j1.size(); i++) {   
		    System.out.println( "• " +cardGame_j1.get(i));
		}
	    
		
		System.out.println("\n*****CARD GAME PLAYER 2*****");
		for(int i = 0; i < cardGame_j2.size(); i++) {   
		    System.out.println( "• "+cardGame_j2.get(i));
		}
	
	
		
		
		/*LES BATAILLES*/
		
		while (!cardGame_j1.isEmpty() && !cardGame_j2.isEmpty()){
			
			System.out.println("\n\n    ------------------------- \n"
					+  "   |                         |\n"
					+  "   |         NEW BATTLE      |\n"
					+  "   |                         |\n"
					+  "    ------------------------- \n");
			
			
			CardBattle cardCurrentJ1 = j1.drawCard(cardGame_j1);
			CardBattle cardCurrentJ2 = j2.drawCard(cardGame_j2);
				
			cardGame_j1.lastIndexOf(cardCurrentJ1);
			
				
				String result =(cardCurrentJ1).compare(cardCurrentJ2);
				switch(result){
					case "=":
						
						result= "\n"+cardCurrentJ1 +"(j1) = "+ cardCurrentJ2+" (j2)"
								+ "\n               equality     \n";
						CardBattle tmp_j1= cardCurrentJ1;
						CardBattle tmp_j2= cardCurrentJ2;
						cardGame_j1.remove(cardCurrentJ1);
						cardGame_j2.remove(cardCurrentJ2);
						cardGame_j1.add(tmp_j1);
						cardGame_j2.add(tmp_j2);						
						
						point_j1=point_j1+1;
						point_j2=point_j2+1;	
						/*Lorsqu'il y a égalité on remet les deux cartes à la fin de leur paquet respective*/
						
						
						break;
					case "+":
						result= "\n"+cardCurrentJ1 +"(j1) > "+ cardCurrentJ2+" (j2)"
								+ "\n       J1 winner  |  J2 loser \n";
						cardGame_j2.remove(cardCurrentJ2);
						cardGame_j1.add(cardCurrentJ2);
						
						/*Mettre la carte courante du gagnant à la fin de son jeu*/
						
						CardBattle tmp_j1_win= cardCurrentJ1;
						cardGame_j1.remove(cardCurrentJ1);
						cardGame_j1.add(tmp_j1_win);	
						
						point_j1=point_j1+2;
						
						/*Lorsque J1 gagne on lui donne la carte de J2 avec laquelle il y a eu bataille*/
						
						break;	
					case "-":
						result= "\n"+cardCurrentJ2 +"(j2) > "+ cardCurrentJ1+" (j1)"
								+ "\n        J2 winner |  J1 loser \n";				
						cardGame_j1.remove(cardCurrentJ1);
						cardGame_j2.add(cardCurrentJ1);
						
						/*Mettre la carte courante du gagnant à la fin de son jeu*/
						
						CardBattle tmp_j2_win= cardCurrentJ2;
						cardGame_j2.remove(cardCurrentJ2);
						cardGame_j2.add(tmp_j2_win);	
						
						point_j2=point_j2+2;
						
						/*Lorsque J2 gagne on lui donne la carte de J1 avec laquelle il y a eu bataille*/
						
						break;
		
				}
				System.out.println(result+"\n");
				
				System.out.println("*****NEW CARD GAME PLAYER 1*****");
				for(int i = 0; i < cardGame_j1.size(); i++) {   
				    System.out.println( "    • " +cardGame_j1.get(i));
				}
				
			    
				
				System.out.println("\n*****NEW CARD GAME PLAYER 2*****");
				for(int i = 0; i < cardGame_j2.size(); i++) {   
				    System.out.println( "     • "+cardGame_j2.get(i));
				}
				
				
				System.out.println("\n    ------------------------ \n"
								 + "   |  Total points J1 : "+point_j1 +"  | \n"
								 + "   |  Total points J2 : "+point_j2 + "  | \n"
								 + "    -------------------------");
				
				
			//Pour éviter une boucle infinie	
			if (result=="=" && cardGame_j1.size()==1 && cardGame_j2.size()==1){
				break;
				
			}
			if(point_j1>1500 || point_j2>1500){
				System.out.println(" ATTENTION BOUCLE INFINIE- Arrêt du jeu");
				break;	
			}
			
		}// fin while	
		
		
		if(point_j1<1500 && point_j2<1500){
				if( point_j2>point_j1){
					System.out.println("\n       ------------------ \n"
							+ "      |                  |\n"
							+ "      |     GAME OVER    |\n"
							+ "      |                  |\n"
							+ "       ------------------ \n"
							+ "   J2 winner! with : " + point_j2+ " points");
				}else {
					System.out.println("\n       ------------------ \n"
							+ "      |                  |\n"
							+ "      |     GAME OVER    |\n"
							+ "      |                  |\n"
							+ "       ------------------ \n"
							+ "   J1 winner! with : " + point_j1+ " points");		
				}
		}
		
	}

}
