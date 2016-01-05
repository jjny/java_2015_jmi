package pokedeck;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.Scanner;

public class Game implements Serializable{


	private static final long serialVersionUID = 1L;
	private static String nameFile;
	private static Scanner choice=new Scanner(System.in);
	private static Menu m=new Menu();
	private static PlayerPokedeck p;
	
	/**
	 *   Main menu
	 *    
	 *  @param1 player
	 *  @param2 card game
	 *  
	 */
	
	public static void playGame( ArrayList<Card> collection){
		System.out.println("Enter your pokedeck name : ");
		String playerName = choice.next();
		p = new PlayerPokedeck(playerName);
		System.out.println("-------------------------------\n");
		main_menu_processing(p,collection);
	}

	
	public static void main_menu_processing(PlayerPokedeck player, ArrayList<Card> collection){
		int choice_mainMenu=m.main_menu();		
		
		if(choice_mainMenu==1)
		{
		
			choice.nextLine();
			submenu_processing(player,collection);
			
		}
		if(choice_mainMenu==2)
		{	
			choice.nextLine();
			System.out.println("\n---- Enter file name ------");
			nameFile=choice.nextLine();
			 load(nameFile);			
		}else
			m.main_menu();		
	}
	
	
	public static void submenu_processing(PlayerPokedeck player, ArrayList<Card> collection){
		int choice_submenu=m.submenu();		
			if(choice_submenu==1)		
				add(player,collection);						
			else if (choice_submenu==2 )
				delete(player,collection);										
			else if(choice_submenu==3)
				player.consultCardGame(collection);
			else if(choice_submenu==4)
				update(player,collection);																		
			else if (choice_submenu==5) 
				submenu_search_processing(player, collection);						
			else if(choice_submenu==6 ) 
				save(player,collection);				
			else if(choice_submenu==7)
			{
				System.out.println("\n----------------------"
								  +"\n-----  GOOD BYE  -----"
				                  +"\n----------------------");
				System.exit(0);			
			}
			else
				submenu_processing(player,collection);
			
			submenu_processing(player,collection);
	}
	
	
	public static boolean isEmpty(ArrayList<Card> collection)
	{	
		if(collection.size()==0)
		{
			System.out.println("\n--------------------------------"
					          +"\n-- Your card game is empty !! --"
					          +"\n--------------------------------\n\n");
			return true;
		}
		else
			return false;		
	}
	
	public static boolean test_exist(ArrayList<Card> collection,int numberCard){
		ListIterator<Card> ite=collection.listIterator();
		boolean test=false;
		while(ite.hasNext()){
			Card a = ite.next();	
			if(a.getNumberCard()==numberCard)
				test=true;
		}	
		return test;	
	}
	
	
	public static void submenu_search_processing(PlayerPokedeck player, ArrayList<Card> collection)
	{
		if(!isEmpty(collection))
		{
			int choice_subMenu_search=m.submenu_search();
		
			if(choice_subMenu_search==1)					
				search_number(player,collection);
			else if(choice_subMenu_search==2)
				search_type(player,collection);		
			else if(choice_subMenu_search==3)
				search_name(player,collection);		
			else			
				submenu_processing(player, collection);		
		}
	}
	
	

	public static int addCardNumber(ArrayList<Card> collection)
	{	
		int numberCard = 0;
		boolean unique_cardNumber = false; 
		try {
			do{
				System.out.println("\n-- Enter card number  --");
				unique_cardNumber=false;
				numberCard=choice.nextInt();
				choice.nextLine();
				ListIterator<Card> ite= collection.listIterator();
			
				while(ite.hasNext())
				{
					Card card_iterator =ite.next();
					if(card_iterator.getNumberCard()==numberCard)
					{
						unique_cardNumber=true;
						System.out.println("This card number is already used, card number should be unique. "
										 + "\n               Choose another card number");
					}
				}
			}while(unique_cardNumber!=false);
		}
		catch (InputMismatchException e) 
		{
		    System.out.println("------------------\n"
  				  +"--Invalid value!--\n"
  				  +"----Try again----- \n"
  				  +"------------------\n");
			  choice.nextLine();
			  addCardNumber(collection);
		} 
		catch (Exception e)
		{
			 System.out.println(e);
		}
					
		return numberCard;
			
	}
	
	
	public static void add(PlayerPokedeck player, ArrayList<Card> collection){	
		int choice_card_type=m.choiceCardType();
		if(choice_card_type==1)
			add_pokemon(player,collection);
		else if	(choice_card_type==2)
			add_energy(player,collection);
		else if	(choice_card_type==3)	
			add_trainer(player,collection);
		else
			submenu_processing(player, collection);	
	}
	
	public static void add_pokemon(PlayerPokedeck player,ArrayList<Card> collection){
		//int numberCard=0;
		int hp=0;	

		try {
			System.out.println("\n-- Enter pokemon name  --");
			String name=choice.nextLine();	
			
			int numberCard=addCardNumber(collection);

			StagePokemon stage =stage_pokemon(player,collection);

			if(stage==StagePokemon.BASIC)
				hp=60;
			else if(stage==StagePokemon.STAGE_1)
				hp=80;
			else
				hp=140;			
					
			player.addCardPokemon(collection, numberCard,name, stage, hp);		
		}
		catch (InputMismatchException e) {
		    System.out.println("------------------\n"
		    				  +"--Invalid value!--\n"
		    				  +"----Try again----- \n"
		    				  +"------------------\n");
		    choice.nextLine();
		    add_pokemon(player,collection);
		} 
		catch (Exception e){
			  System.out.println(e);
			}
		m.submenu();
	}
	
	public static StagePokemon stage_pokemon(PlayerPokedeck player,ArrayList<Card> collection){
		int choice=m.MenuStage();
		StagePokemon stage = null;
		
		switch(choice){
		case 1:						
			stage=StagePokemon.BASIC;
			break;			
		case 2:						
			stage=StagePokemon.STAGE_1;
			break;														
		case 3:						
			stage=StagePokemon.STAGE_2;
			break;							
		}	
		
		return stage;
	}
		

	public static void add_energy(PlayerPokedeck player,ArrayList<Card> collection){
		int numberCard=0;
		int energyType=0;
		
		try 
		{
			 numberCard=addCardNumber(collection);
		     energyType =m.choiceEnergyType();
		     player.addCardEngery(collection,numberCard,energyType);	
		}
		catch (InputMismatchException e) {
		    System.out.println("------------------\n"
		    				  +"--Invalid value!--\n"
		    				  +"----Try again----- \n"
		    				  +"------------------\n");
		    choice.nextLine();
		    add_energy(player,collection);
		} 
		catch (Exception e){
			  System.out.println(e);
			}				
	}
	
	public static void add_trainer(PlayerPokedeck player,ArrayList<Card> collection){
		int numberCard=addCardNumber(collection);
		int trainerType=m.choiceTrainerType();
			
		System.out.println("\n-- Enter card name --");
		String name=choice.nextLine();
		
		System.out.println("\n-- Describe trainer ruler --");

		String infos=choice.nextLine();
		
		player.addCardTrainer(collection,numberCard,name,trainerType,infos);	
	}

	
	
	public static void delete(PlayerPokedeck player, ArrayList<Card> collection){
		if(!isEmpty(collection))
		{
			try
				{
			    
				player.consultCardGame(collection);
				System.out.println("\n-- Enter card number --");
				int numberCard=choice.nextInt();
				choice.nextLine();
			
			if(!player.deleteCard(numberCard, collection))
				System.out.println("No card correspond to it card number \n\n");
			
			if(!isEmpty(collection))
				player.consultCardGame(collection);	
			}
			catch (InputMismatchException e) {
				System.out.println("------------------\n"
			    				  +"--Invalid value!--\n"
			    				  +"----Try again----- \n"
			    				  +"------------------\n");
			    choice.nextLine();    
			} 
			catch (Exception e){
				System.out.println(e);
			}
		}	
	}
	


	public static int add_cardnumber(Card card_iterator){
		int newNumberCard=0;
		boolean unique_cardNumber; 
		try{	
			do{
				System.out.println("\n-- Enter new card number --");
				newNumberCard = choice.nextInt();
				choice.nextLine();
				unique_cardNumber=false;
													 
					if(card_iterator.getNumberCard()==newNumberCard){
						unique_cardNumber=true;
						System.out.println("This card number is already used, card number should be unique. "
										 + "\n               Choose another card number");
					}
				
			}while(unique_cardNumber!=false);
			
		} 
		catch (InputMismatchException e) {
			System.out.println("------------------\n"
			  				  +"--Invalid value!--\n"
			  				  +"----Try again----- \n"
			  				  +"------------------\n");
			    choice.nextLine();
			    add_cardnumber(card_iterator);
		} 
		catch (Exception e){
			  System.out.println(e);
			}
		return newNumberCard;
		
	}
	
	
	
	public static void update(PlayerPokedeck player, ArrayList<Card> collection){
		if(!isEmpty(collection)){
			try{			
				player.consultCardGame(collection);
				
				System.out.println("\n-- Enter card number you want to update --");
				
				System.out.println("");
				int numberCard=choice.nextInt();
				choice.nextLine();

				if(test_exist(collection,numberCard))
					update_card(player,collection,numberCard);
				else
					System.out.println("\n No card correspond to it card number \n");
			}
			
			catch (InputMismatchException e) {
				System.out.println("------------------\n"
				  				  +"--Invalid value!--\n"
				  				  +"----Try again----- \n"
				  				  +"------------------\n");
				    choice.nextLine();
				    update(player,collection);
			} 
			catch (Exception e){
				  System.out.println(e);
				}	
			}	
	}
	
	
	public static void update_card(PlayerPokedeck player, ArrayList<Card> collection, int numberCard){
		ListIterator<Card> ite= collection.listIterator();
		while(ite.hasNext()){
			Card card_iterator = ite.next();
			if(card_iterator.getNumberCard()==numberCard){				
				if(card_iterator.getType()==TypeCard.Pokemon){
					update_pokemon((PokemonCard) card_iterator ,numberCard,player,collection);						
				}else if(card_iterator.getType()==TypeCard.Energy) {
					update_energy(card_iterator ,numberCard);
				}else{
					update_trainer(card_iterator ,numberCard);
				}
				
			}	
		}
		player.consultCardGame(collection);
	}
	
	public static void update_pokemon(PokemonCard card_iterator, int numberCard,PlayerPokedeck player, ArrayList<Card> collection){
		int change=m.update_menu_field_pokemon();
		switch(change){
		case 1:						
			int newNumberCard=add_cardnumber(card_iterator);
			card_iterator.setNumberCard(newNumberCard);
			break;
			
		case 2:						
			update_name(card_iterator,numberCard);
			break;					
									
		case 3:						
			update_stage(card_iterator,numberCard,player,collection);
			break;					
		}	
	}
	
	public static void update_energy(Card card_iterator, int numberCard){
		int change=m.update_menu_field_energy();
		
		switch(change){
			case 1:				
				
				int newNumberCard=add_cardnumber(card_iterator);
				card_iterator.setNumberCard(newNumberCard);
				break;
				
			case 2:																			
				update_menu_energyType(card_iterator,numberCard);	
				break;						
			} 	
	}
	
	public static void update_trainer(Card card_iterator, int numberCard){
		int change=m.update_menu_field_trainer();
		
		switch(change){
		case 1:									
			int newNumberCard=add_cardnumber(card_iterator);					
			card_iterator.setNumberCard(newNumberCard);
			break;												
						
		case 2:												
			update_name(card_iterator,numberCard);
			break;	
		
		case 3:						
			update_menu_trainerType(card_iterator,numberCard);
			break;	
			
		case 4:		
			update_infos(card_iterator,numberCard);
			break;	

		} 
	}
	

	
	public static void update_name(Card card_iterator, int numberCard)
	{
		if(card_iterator.getNumberCard()==numberCard)
		{			
				System.out.println("\n-- Enter new card name --");
				String newName = choice.nextLine();
				card_iterator.setName(newName);			
		}
		m.submenu();
	}
	
	
	public static void update_stage(PokemonCard card_iterator, int numberCard,PlayerPokedeck player, ArrayList<Card> collection )
	{
		int hp=0;
		if(card_iterator.getNumberCard()==numberCard){
			StagePokemon stage =stage_pokemon(player,collection);
			
			if(stage==StagePokemon.BASIC)
				hp=60;
			else if(stage==StagePokemon.STAGE_1)
				hp=80;
			else
				hp=140;			
					
			card_iterator.setStage(stage);
			card_iterator.setHp(hp);
		}
		m.submenu();
	}
	
	public static void update_infos(Card card_iterator, int numberCard)
	{
		if(card_iterator.getNumberCard()==numberCard)
		{
				System.out.println("\n-- Enter new card information --");				
				String infos = choice.nextLine();
				card_iterator.setInfos(infos);		
			}
			m.submenu();
	}
	
	public static void update_menu_energyType(Card card_iterator, int numberCard)
	{
		if(card_iterator.getNumberCard()==numberCard)
		{			
				int energyType =m.choiceEnergyType();			
				card_iterator.setEnergyType(energyType);
		}
		m.submenu();	
	}

	public static void update_menu_trainerType(Card card_iterator, int numberCard){
		if(card_iterator.getNumberCard()==numberCard)
		{
			int typeTrainer=m.choiceTrainerType();
			card_iterator.setTrainerType(typeTrainer);	
		}
		m.submenu();
	}
	

	
	public static void search_type(PlayerPokedeck player, ArrayList<Card> collection){
		System.out.println("Card type : pokemon, energy or trainer ??");
		String typeCard=choice.nextLine();					
		player.searchCardByType(typeCard, collection);	
	}
	
	public static void search_number(PlayerPokedeck player, ArrayList<Card> collection){
		int numberCard=-1;
		try
		{
			System.out.println("\n-----   Enter Card number ------");
			
			numberCard=choice.nextInt();
			choice.nextLine();
		}
		catch (InputMismatchException e) 
		{
			System.out.println("------------------\n"
			  				  +"--Invalid value!--\n"
			  				  +"----Try again----- \n"
			  				  +"------------------\n");
			    choice.nextLine();
			    search_number(player,collection);
		} 
		catch (Exception e){
			  System.out.println(e);
			}	
		player.searchCardByNumber(numberCard, collection);	
	}
	
	
	public static void search_name(PlayerPokedeck player, ArrayList<Card> collection){
		
		System.out.println("\n------   Enter Card name -------");
		
		String typeCard=choice.nextLine();
		player.searchCardByName(typeCard, collection);	
	}
	
	
	/**
	 * 
	 *   SAVE A CARD GAME :
	 *  
	 *  @param1 name file
	 *  @param2 card game
	 *  @param3 player
	 *  
	 */
	


	public static void save(PlayerPokedeck player, ArrayList<Card> collection){
		try 
		{				
			System.out.println("\n---- Enter recording name ------");
			String fileName=choice.nextLine();
			
			FileOutputStream file = new FileOutputStream("src/save/"+fileName+".dat");
			ObjectOutputStream oos = new ObjectOutputStream(file);
			oos.writeObject(collection);
			oos.flush();
			oos.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();		
		}	
		System.out.println("Sauvegarde réussie!");
		m.submenu();
	} 
	
	
	
	/**
	 * 
	 *   LOAD A CARD GAME :
	 *  
	 *  @param name file
	 *  
	 */
	
	
	public static void load(String nomFichier)
	{
		try 
		{
			
			FileInputStream file = new FileInputStream("src/save/"+nomFichier+".dat");
			ObjectInputStream ois = new ObjectInputStream(file);			
			
			ArrayList<Card> collection= (ArrayList<Card>) ois.readObject();
			
			ois.close();

			p.consultCardGame(collection);
			submenu_processing(p,collection);
			
		}
		catch (java.io.IOException e) 
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	
}
