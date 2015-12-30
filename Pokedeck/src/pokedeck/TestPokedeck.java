package pokedeck;

import java.util.ArrayList;

import javax.swing.JFrame;


public class TestPokedeck {

	public static void main(String[] args) {

		//JFrame game=new JFrame("Pokemon card - Minfir");
		//game.setContentPane(new Menu());
		//game.setLocation(400, 300);
		//game.setSize(500, 400);
		//game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//game.setVisible(true);
		Game m=new Game();
	//	GameGUI game=new GameGUI();
		//game.start();
		
			
			ArrayList<Card> collection=new ArrayList<Card>();
			
			
			PlayerPokedeck player = new PlayerPokedeck("pseudo_tmp",collection);
			
			//String pseudo =player.choosePseudo(); /* crée une erreur : java.util.NoSuchElementException */
			//player.setPseudo(pseudo);
			
			
			
			
			/*Card poke=new CardPokemon(1,12,"pikachu",2,200);
			collection.add(poke);
		*/
		
			m.main_menu(player,collection);
			
			
			
			
	
	}	
}

