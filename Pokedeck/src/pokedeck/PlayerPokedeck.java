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
	
	public PlayerPokedeck (){}
	
	public PlayerPokedeck (String pseudo,ArrayList<Card> cardGame)
	{
		this.pseudo=pseudo;
		cardGame=new ArrayList<Card>(); 
	}
	
	
	public String getPseudo(){
		return pseudo;
	}
	
	public ArrayList<Card> getCardGame(){
		return cardGame;
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
		if(!collection.isEmpty()){	
			System.out.println("--------------------------------\n"
							  +"------     CARD GAME      ------"	);
			for(Card obj: collection){
				System.out.println(obj);
			}
		}else{
			System.out.println("\n--------------------------------"
			          +"\n-- Your card game is empty !! --"
			          +"\n--------------------------------\n\n");
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

	public void searchCardByType(int type,ArrayList<Card> collect)
	{
		TypeCard cardType=null;
				
		switch(type)
		{
			case 1:  
				cardType =TypeCard.Pokemon;
				break;				
			case 2:
				cardType =TypeCard.Energy;
				break;
			case 3:				
				cardType =TypeCard.Trainer;
				break;							
		}
				
		ListIterator<Card> ite=collect.listIterator();
		Card a=null;
		while(ite.hasNext())
		{
			 a = ite.next();
			 if(a.getType()==cardType)
				System.out.println(a.toString());
			 else
				a=null;
		}	
		if(a==null)
			System.out.println("No card correspond to it card type \n\n");		
		System.out.println(a);
	}		
}

