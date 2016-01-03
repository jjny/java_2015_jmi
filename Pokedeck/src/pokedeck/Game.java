package pokedeck;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.Scanner;

public class Game{

	private String nameFile;
	private Scanner choice=new Scanner(System.in);
	private Menu m=new Menu();
	/**
	 * 
	 *   Main menu
	 *   
	 *  
	 *  @param1 player
	 *  @param2 card game
	 *  
	 */
	
	public void playGame(PlayerPokedeck player, ArrayList<Card> collection){
		main_menu_processing(player,collection);
	}

	
	public void main_menu_processing(PlayerPokedeck player, ArrayList<Card> collection){
		int choice_mainMenu=m.main_menu();		
		if(choice_mainMenu==1)
			submenu_processing(player,collection);
		if(choice_mainMenu==2)
		{	
			System.out.println("file name ?");
			this.nameFile=choice.nextLine();
			 load(nameFile);			
		}else
			m.main_menu();		
	}
	
	
	public void submenu_processing(PlayerPokedeck player, ArrayList<Card> collection){
		int choice_submenu=m.submenu();		
			if(choice_submenu==1)		
				add_processing(player,collection);						
			else if (choice_submenu==2 )
				delete_processing(player,collection);										
			else if(choice_submenu==3)
				consult_processing(player,collection);							
			else if(choice_submenu==4)
				update_processing(player,collection);																		
			else if (choice_submenu==5) 
				submenu_search_processing(player, collection);						
			else if(choice_submenu==6 ) 
				save_processing(player,collection);				
			else if(choice_submenu==7)
			{
				System.out.println("Good bye!");
				System.exit(0);			
			}
			else
				submenu_processing(player,collection);
			
			submenu_processing(player,collection);
	}
	
	
	public void submenu_search_processing(PlayerPokedeck player, ArrayList<Card> collection)
	{
		if(check_cardGame(collection)==true)
		{
			int choice_subMenu_search=m.submenu_search();
		
			if(choice_subMenu_search==1)					
				search_number_processing(player,collection);
			else if(choice_subMenu_search==2)
				search_type_processing(player,collection);		
			else if(choice_subMenu_search==3)
				search_name_processing(player,collection);		
			else			
				submenu_processing(player, collection);		
		}
	}
	
	public static void consult_processing(PlayerPokedeck player, ArrayList<Card> collection)
	{		
		if(check_cardGame(collection)==true)
		{
			System.out.println("CARD GAME");
			player.consultCardGame(collection);	
		}
	}
	
	
	public static boolean check_cardGame(ArrayList<Card> collection)
	{	
		if(collection.size()==0)
		{
			System.out.println("your card game is empty !!\n");
			return false;
		}
		else
			return true;		
	}
	
	
	public int addNumberCard(ArrayList<Card> collection)
	{	
		int numberCard;
		boolean test_oneness_cardNumber; 
		do{
			
			System.out.println("Card number ?");
			test_oneness_cardNumber=false;
			numberCard=choice.nextInt();
			choice.nextLine();
			ListIterator<Card> ite= collection.listIterator();
	
			while(ite.hasNext())
			{
				Card card_iterator =ite.next();
				if(card_iterator.getNumberCard()==numberCard)
				{
					test_oneness_cardNumber=true;
					System.out.println("This card number is already used, card number should be unique. "
									 + "\n               Choice another card number");
				}
			}
			
		}while(test_oneness_cardNumber!=false);	
		return numberCard;	
	}
	
	
	public void add_processing(PlayerPokedeck player, ArrayList<Card> collection){	
		int choice_card_type=m.choiceCardType();
		if(choice_card_type==1)
			add_pokemon_processing(player,collection);
		else if	(choice_card_type==2)
			add_energy_processing(player,collection);
		else if	(choice_card_type==3)	
			add_trainer_processing(player,collection);
		else
			submenu_processing(player, collection);	
	}
	
	public void add_pokemon_processing(PlayerPokedeck player,ArrayList<Card> collection){
		int level=0;
		int numberCard=0;
		int hp=0;
		
		System.out.println("Pokemon name ??");
		String name=choice.nextLine();	
		try {
			numberCard=addNumberCard(collection);
			System.out.print("Level ??");
			level=choice.nextInt();	 
			choice.nextLine();
					
			System.out.print("Life point ??");
			hp=choice.nextInt();
			choice.nextLine();		 
					
			player.addCardPokemon(collection, numberCard,name, level, hp);		
		}
		catch (InputMismatchException e) {
		    System.out.println("------------------\n"
		    				  +"--Invalid value!--\n"
		    				  +"----Try again----- \n"
		    				  +"------------------\n");
		    choice.nextLine();
		    add_pokemon_processing(player,collection);
		} 
		catch (Exception e){
			  System.out.println(e);
			}
		m.submenu();
	}
	
	

	public void add_energy_processing(PlayerPokedeck player,ArrayList<Card> collection){
		int numberCard=0;
		int energyType=0;
		
		try 
		{
			 numberCard=addNumberCard(collection);
		     energyType =m.choiceEnergyType();
		     player.addCardEngery(collection,numberCard,energyType);	
		}
		catch (InputMismatchException e) {
		    System.out.println("------------------\n"
		    				  +"--Invalid value!--\n"
		    				  +"----Try again----- \n"
		    				  +"------------------\n");
		    choice.nextLine();
		    add_energy_processing(player,collection);
		} 
		catch (Exception e){
			  System.out.println(e);
			}				
	}
	
	public void add_trainer_processing(PlayerPokedeck player,ArrayList<Card> collection){
		int numberCard=addNumberCard(collection);
		int trainerType=0;
		try{
			do{
				System.out.println("choice trainer type : \n"
							 + " [1] Item \n"
							 + " [2] Supporte \n"
							 + " [3] Stadium \n");
				trainerType=choice.nextInt();
				choice.nextLine();
			}while(trainerType<1||trainerType>3);
		} 
		catch (InputMismatchException e) {
			System.out.println("------------------\n"
			  				  +"--Invalid value!--\n"
			  				  +"----Try again----- \n"
			  				  +"------------------\n");
			    choice.nextLine();
			    add_trainer_processing(player,collection);
			    
		} 
		catch (Exception e){
			  System.out.println(e);
			}	
			
		System.out.println("Card name ??");
		String name=choice.nextLine();
		
		System.out.println("Describe trainer rule");
		String infos=choice.nextLine();
		
		player.addCardTrainer(collection,numberCard,name,trainerType,infos);	
	}

	
	
	public void delete_processing(PlayerPokedeck player, ArrayList<Card> collection){
		if(check_cardGame(collection)==true)
		{
			try
				{
			    System.out.println("CARD GAME");
				player.consultCardGame(collection);
				System.out.println("Card number ??");
				int numberCard=choice.nextInt();
				choice.nextLine();
			
			if(player.deleteCard(numberCard, collection)==false)
				System.out.println("No card correspond to it card number \n\n");
			
			if(check_cardGame(collection)==true)
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
	
	
	public boolean test_exist(ArrayList<Card> collection,int numberCard){
		ListIterator<Card> ite=collection.listIterator();
		boolean test=false;
		while(ite.hasNext()){
			Card a = ite.next();	
			if(a.getNumberCard()==numberCard)
				test=true;
		}	
		return test;	
	}


	public int oneness_cardnumber(Card card_iterator){
		int newNumberCard=0;
		boolean test_oneness_cardnumber; 
		try{	
			do{
				System.out.println("new card number");
				newNumberCard = choice.nextInt();
				choice.nextLine();
				test_oneness_cardnumber=false;
													 
					if(card_iterator.getNumberCard()==newNumberCard){
						test_oneness_cardnumber=true;
						System.out.println("This card number is already used, card number should be unique. "
										 + "\n               Choice another card number");
					}
				
			}while(test_oneness_cardnumber!=false);
			
		} 
		catch (InputMismatchException e) {
			System.out.println("------------------\n"
			  				  +"--Invalid value!--\n"
			  				  +"----Try again----- \n"
			  				  +"------------------\n");
			    choice.nextLine();
			    oneness_cardnumber(card_iterator);
		} 
		catch (Exception e){
			  System.out.println(e);
			}
		return newNumberCard;
		
	}
	
	public void update_processing(PlayerPokedeck player, ArrayList<Card> collection){
		if(check_cardGame(collection)==true){
			try{
				System.out.println("CARD GAME");
				player.consultCardGame(collection);
				System.out.println("write card number you want to update");
				int numberCard=choice.nextInt();
				choice.nextLine();
				//player.UpdateCard(numberCard, collection);
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
				    update_processing(player,collection);
			} 
			catch (Exception e){
				  System.out.println(e);
				}	
			}	
	}
	

	
	/**
	 * Pokemon cards menu to update 
	 * 
	 * @return chance
	 */
	public int update_menu_field_pokemon(){
		int change=0;
		try{
			do{
				System.out.println("what field do you want change ?\n"
								  +"[1] card number \n"
								  +"[2] name\n"
								  +"[3] level\n"
								  +"[4] hp \n");

			change =choice.nextInt();
			choice.nextLine();
			}while(change<1||change>4);
		} 
		catch (InputMismatchException e) {
			System.out.println("------------------\n"
			  				  +"--Invalid value!--\n"
			  				  +"----Try again----- \n"
			  				  +"------------------\n");
			    choice.nextLine();
			    update_menu_field_pokemon();
		} 
		catch (Exception e){
			  System.out.println(e);
			}	
		return change;
		
	}
	
	/**
	 * Energy cards menu to update 
	 * 
	 * @return chance
	 */
	
	public int update_menu_field_energy(){
		int change=0;
		try{
			do{
				System.out.println("What field do you want change ?\n"
								  +"[1] Card number \n"
								  +"[2] Energy type\n");
	
				change =choice.nextInt();
				choice.nextLine();
			}while(change<1||change>2);
		} 
		catch (InputMismatchException e) {
			System.out.println("------------------\n"
			  				  +"--Invalid value!--\n"
			  				  +"----Try again----- \n"
			  				  +"------------------\n");
			    choice.nextLine();
			    update_menu_field_energy();
		} 
		catch (Exception e){
			  System.out.println(e);
			}	
		return change;
	}
	
	
	
	public void update_name(Card card_iterator, int numberCard){
		//Scanner strName= new Scanner(System.in);	
		if(card_iterator.getNumberCard()==numberCard){
			try{
			
				System.out.println("New card name ??");
				String newName = choice.nextLine();
				card_iterator.setName(newName);	
			}catch (InputMismatchException e) {
				System.out.println("------------------\n"
				  				  +"--Invalid value!--\n"
				  				  +"----Try again----- \n"
				  				  +"------------------\n");
			    choice.nextLine();
			    update_name(card_iterator,numberCard);
			} 
			catch (Exception e){
				  System.out.println(e);
				}	
		}
		m.submenu();
	}
	
	public void update_hp(Card card_iterator, int numberCard){
		if(card_iterator.getNumberCard()==numberCard){
			try{
				System.out.println("New hp ??");
				int hp= choice.nextInt();
				choice.nextLine();
				card_iterator.setHp(hp);
			}catch (InputMismatchException e) {
				System.out.println("------------------\n"
				  				  +"--Invalid value!--\n"
				  				  +"----Try again----- \n"
				  				  +"------------------\n");
			    choice.nextLine();
			    update_hp(card_iterator,numberCard);
			} 
			catch (Exception e){
				  System.out.println(e);
				}	
		}
		m.submenu();
	}
	
	public void update_level(Card card_iterator, int numberCard){
		int level=0;
		if(card_iterator.getNumberCard()==numberCard){
			try{
				System.out.println("New level ??");
				level = choice.nextInt();
				choice.nextLine();
				card_iterator.setLevel(level);
			}
			catch (InputMismatchException e) {
				System.out.println("------------------\n"
				  				  +"--Invalid value!--\n"
				  				  +"----Try again----- \n"
				  				  +"------------------\n");
			    choice.nextLine();
			    update_level(card_iterator,numberCard);
			} 
			catch (Exception e){
				  System.out.println(e);
				}	
		}
		m.submenu();
	}
	
	public void update_infos(Card card_iterator, int numberCard){
		if(card_iterator.getNumberCard()==numberCard){
			try{
				System.out.println("New card information ??");
				String infos = choice.nextLine();
				card_iterator.setInfos(infos);	
			}catch (InputMismatchException e) {
				System.out.println("------------------\n"
				  				  +"--Invalid value!--\n"
				  				  +"----Try again----- \n"
				  				  +"------------------\n");
				    choice.nextLine();
				    update_infos(card_iterator,numberCard);
			} 
			catch (Exception e){
					  System.out.println(e);
					}	
			}
			m.submenu();
	}
	
	public void update_menu_energyType(Card card_iterator, int numberCard){
		if(card_iterator.getNumberCard()==numberCard){			
			try{	
				int energyType =m.choiceEnergyType();			
				card_iterator.setEnergyType(energyType);
			}catch (InputMismatchException e) {
				System.out.println("------------------\n"
				  				  +"--Invalid value!--\n"
				  				  +"----Try again----- \n"
				  				  +"------------------\n");
			    choice.nextLine();
			    update_menu_energyType(card_iterator,numberCard);
			} 
			catch (Exception e){
				  System.out.println(e);
				}	
		}
		m.submenu();	
	}

	public void update_menu_trainerType(Card card_iterator, int numberCard){
		if(card_iterator.getNumberCard()==numberCard){
			int typeTrainer=0;
			try{
				do{
					System.out.println("Choice new trainer type : \n"
									 + " [1] Item \n"
									 + " [2] Supporte \n"
									 + " [3] Stadium \n");
					typeTrainer = choice.nextInt();
					choice.nextLine();
				}while(typeTrainer<1||typeTrainer>3);
				card_iterator.setTrainerType(typeTrainer);	
			}catch (InputMismatchException e) {
				System.out.println("------------------\n"
				  				  +"--Invalid value!--\n"
				  				  +"----Try again----- \n"
				  				  +"------------------\n");
			    choice.nextLine();
			    update_menu_trainerType(card_iterator,numberCard);
			} 
			catch (Exception e){
				  System.out.println(e);
				}	
		}
		m.submenu();
	}
	
	
	public void update_pokemon(Card card_iterator, int numberCard){
		int change=update_menu_field_pokemon();
		switch(change){
		case 1:						
			int newNumberCard=oneness_cardnumber(card_iterator);
			card_iterator.setNumberCard(newNumberCard);
			break;
			
		case 2:						
			update_name(card_iterator,numberCard);
			break;					
									
		case 3:						
			update_level(card_iterator,numberCard);
			break;				
			
		case 4:		
			update_hp(card_iterator,numberCard);
			break;		
		}	
	}
	
	public void update_energy(Card card_iterator, int numberCard){
		int change=update_menu_field_energy();
		
		switch(change){
			case 1:				
				
				int newNumberCard=oneness_cardnumber(card_iterator);
				card_iterator.setNumberCard(newNumberCard);
				break;
				
			case 2:																			
				update_menu_energyType(card_iterator,numberCard);	
				break;						
			} 	
	}
	
	public void update_trainer(Card card_iterator, int numberCard){
		int change=m.update_menu_field_trainer();
		
		switch(change){
		case 1:									
			int newNumberCard=oneness_cardnumber(card_iterator);					
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
	
	
	public void update_card(PlayerPokedeck player, ArrayList<Card> collection, int numberCard){
		ListIterator<Card> ite= collection.listIterator();
		while(ite.hasNext()){
			Card card_iterator =ite.next();
			if(card_iterator.getNumberCard()==numberCard){				
				if(card_iterator.getType()==1)			
					update_pokemon(card_iterator ,numberCard);						
				else if(card_iterator.getType()==2) 
					update_energy(card_iterator ,numberCard);
				else 
					update_trainer(card_iterator ,numberCard);		 			
			}	
		}
		player.consultCardGame(collection);
	}
	
	
	public void search_type_processing(PlayerPokedeck player, ArrayList<Card> collection){
		System.out.println("Card type : pokemon, energy or trainer ??");
		String typeCard=choice.nextLine();					
		player.searchCardByType(typeCard, collection);	
	}
	
	public void search_number_processing(PlayerPokedeck player, ArrayList<Card> collection){
		int numberCard=-1;
		try
		{
			System.out.println("Card number ??");
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
			    search_number_processing(player,collection);
		} 
		catch (Exception e){
			  System.out.println(e);
			}	
		player.searchCardByNumber(numberCard, collection);	
	}
	
	public void search_name_processing(PlayerPokedeck player, ArrayList<Card> collection){
		System.out.println("Card name ??");
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
	


	public void save(String nameFile,PlayerPokedeck player, ArrayList<Card> collection){
		try 
		{		
			FileOutputStream file = new FileOutputStream("src/save/"+nameFile+".dat");
			ObjectOutputStream oos = new ObjectOutputStream(file);
			oos.writeObject(collection);
			oos.writeObject(player);
			oos.flush();
			oos.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();		
		}	
		System.out.println("Sauvegarde réussie!");
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
			ObjectInputStream ois2 = new ObjectInputStream(file);
			
			ArrayList<Card> collection= (ArrayList<Card>) ois.readObject();
			PlayerPokedeck playerPokedeck=(PlayerPokedeck) ois2.readObject();
			
			ois.close();
			 
			consult_processing(playerPokedeck,collection);
		}
		catch (java.io.IOException e) 
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		finally {
			//ois.close();
		}
	}
	
	
	public void save_processing(PlayerPokedeck player, ArrayList<Card> collection)
	{
		try
		{
			System.out.println("Name save ?");
			String name=choice.nextLine();
			
			save(name,player,collection);
		}
		catch (InputMismatchException e)
		{
			System.out.println("------------------\n"
			  				  +"--Invalid value!--\n"
			  				  +"----Try again----- \n"
			  				  +"------------------\n");
		    choice.nextLine();
		    save_processing(player, collection);
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}			
	}
	
}