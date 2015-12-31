package bataille;

import java.util.ArrayList;

public class Player 
{
	
	private String pseudo;
	private ArrayList<CardBattle> cardGame ;
	private int counter;	
	
	public Player (String pseudo, ArrayList<CardBattle> cardGame, int counter)
	{
		this.pseudo=pseudo;
		this.cardGame=cardGame;
		this.counter=0;		
	}

	public String getPseudo()
	{
		return pseudo;
	}

	public ArrayList<CardBattle> getCardGame() 
	{
		return cardGame;
	}

	public int getCounter() 
	{
		return counter;
	}
	
	/**
	 * 
	 * @param cardGame
	 * @return
	 */
	
	public CardBattle drawCard(ArrayList<CardBattle> cardGame)
	{
		return cardGame.get(cardGame.lastIndexOf(getCardGame())+1);
	}
	
	public void addCard(CardBattle newCard)
	{
		cardGame.add(newCard);				
	}
}
