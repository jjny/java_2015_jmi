package pokedeck;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;

public class PlayerPokedeck implements Serializable
{

	private static final long serialVersionUID = 1L;
	private String pseudo;
	private ArrayList<Card> cardGame ;
	private Game g=new Game();
	
	public PlayerPokedeck (String pseudo)
	{
		this.pseudo=pseudo;
	//	this.cardGame=cardGame;
		ArrayList<Card> cardGame=new ArrayList<Card>(); 
	}
	
	/**
	 * 
	 *   ADD A CARD
	 *   
	 *  @param card game
	 *  
	 */
	
	public ArrayList<Card> addCardPokemon(ArrayList<Card> collect, int numberCard,String name,StagePokemon level,int hp){
		PokemonCard newPokemon=new PokemonCard(numberCard,name,level,hp);
		collect.add(newPokemon);
		consultCardGame(collect);
		return collect;	
	}
	
	public ArrayList<Card> addCardEngery(ArrayList<Card> collect, int numberCard,int energyType){		
		EnergyCard newPokemon=new EnergyCard(numberCard,energyType);
		collect.add(newPokemon);
		consultCardGame(collect);
		return collect;
		
	}
	
	public ArrayList<Card> addCardTrainer(ArrayList<Card> collect, int numberCard,String name,int trainerType, String infos){		
		TrainerCard newPokemon=new TrainerCard(numberCard,name,trainerType, infos);
		collect.add(newPokemon);
		consultCardGame(collect);
		return collect;
		
	}

	
	/**
	 * 
	 *  DELETE A CARD
	 *  
	 *  @param1 card number
	 *  @param2 card game 
	 *  
	 */
	
	
	
	public boolean deleteCard(int num, ArrayList<Card> collect)
	{
		ListIterator<Card> ite=collect.listIterator();
		boolean test=false;
		while(ite.hasNext()){
			Card a = ite.next();	
			if(a.getNumberCard()==num){
				ite.remove();
				test=true;
			}
		}		
		return test;
	}
	
	
	/**
	 * 
	 *  CONSULT A CARD GAME
	 *  
	 *  @param card game
	 *  
	 */
	
	public void consultCardGame(ArrayList<Card> collection)
	{		
		if(g.isEmpty(collection)==false){	
			System.out.println("--------------------------------\n"
							  +"------     CARD GAME      ------"	);
			for(Card obj: collection){
				System.out.println(obj);
			}
		}
	}
	
	
	
	/**
	 * 
	 *   SEARCH BY NUMBER
	 *   
	 *  @param1 card number
	 *  @param2 card game 
	 *  
	 */
	

	public void searchCardByNumber(int num,ArrayList<Card> collect)
	{
		ListIterator<Card> ite=collect.listIterator();
		Card a=null;
		while(ite.hasNext()){
			 a = ite.next();
			if(a.getNumberCard()==num)
				System.out.println(a.toString());
			else
				a=null;	
		}	
		if(a==null)
			System.out.println("No card correspond to it card number \n\n");		
	}

	/**
	 * 
	 *   SEARCH BY NAME
	 *   
	 *  @param1 card name
	 *  @param2 card game 
	 *  
	 */
	
	public void searchCardByName(String name,ArrayList<Card> collect)
	{	
		ListIterator<Card> ite2= collect.listIterator();
		Card a=null;
		while(ite2.hasNext()){
			a = ite2.next();
			if (a.equals_name(name))
				System.out.println(a.toString());				
			else
				a=null;	
			}	
			if(a==null)
				System.out.println("No card correspond to it card name \n\n");			
	}
	
	
	/**
	 * 
	 *   SEARCH BY TYPE
	 *   
	 *  @param1 card type : pokemon, energy or trainer
	 *  @param2 card game 
	 *  
	 */

	public void searchCardByType(String type,ArrayList<Card> collect)
	{
		int cardType = 0;
		
		switch(type){
			case "Pokemon":  
				cardType =1;
				break;				
			case "Energy":
				cardType =2;
				break;
			case "Trainer":				
				cardType =3;
				break;	
				
			case "pokemon":  
				cardType =1;
				break;				
			case "energy":
				cardType =2;
				break;
			case "trainer":				
				cardType =3;
				break;		
		}
		
		ListIterator<Card> ite=collect.listIterator();
		Card a=null;
		while(ite.hasNext()){
			 a = ite.next();
			if(a.getTypePokemon()==cardType)
				System.out.println(a.toString());
			else
				a=null;
		}	
		if(a==null)
			System.out.println("No card correspond to it card type \n\n");
	}
}

