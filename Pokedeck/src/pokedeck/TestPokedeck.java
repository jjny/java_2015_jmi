package pokedeck;

import java.util.ArrayList;

public class TestPokedeck 
{
	public static void main(String[] args)
	{
		Game m=new Game();
		ArrayList<Card> collection=new ArrayList<Card>();
		PlayerPokedeck player = new PlayerPokedeck("pseudo_tmp",collection);
		m.main_menu(player,collection);
	}	
}

