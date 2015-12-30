package bataille;

import java.util.ArrayList;


public class Player {
	
	private String pseudo;
	private ArrayList<CardBattle> cardGame ;
	private int counter;
	
	
	public Player (String pseudo, ArrayList<CardBattle> cardGame, int counter){
		this.pseudo=pseudo;
		this.cardGame=cardGame;
		this.counter=0;		
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public ArrayList<CardBattle> getCardGame() {
		return cardGame;
	}


	public void setCardGame(ArrayList<CardBattle> cardGame) {
		this.cardGame = cardGame;
	}


	public int getCounter() {
		return counter;
	}


	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	/**
	 * 
	 * @param cardGame
	 * @return
	 */
	
	public CardBattle drawCard(ArrayList<CardBattle> cardGame){
		return cardGame.get(cardGame.lastIndexOf(getCardGame())+1);
	}
	
	public void addCard(CardBattle newCard){
		cardGame.add(newCard);				
	}
	
	
	
}
