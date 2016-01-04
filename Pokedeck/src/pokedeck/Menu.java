package pokedeck;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu{
	private int choice_mainMenu;
	private int choice_submenu;
	private int choice_subMenu_search;
	private Scanner choice=new Scanner(System.in);
	private String nameFile;
	
	public int main_menu(){
		try
		{
			//choice_mainMenu=0;
			//do{						
				System.out.println("[1] New card game\n"
								  +"[2] Load(ne fonctionne pas )");
				this.choice_mainMenu=choice.nextInt();
				choice.nextLine();
			//}while(choice_mainMenu<1 ||choice_mainMenu>2);	
		} 
		catch (InputMismatchException e) 
		{
			System.out.println("------------------\n"
			  				  +"--Invalid value!--\n"
			  				  +"----Try again----- \n"
			  				  +"------------------\n");
			    choice.nextLine();
			    
		} 
		catch (Exception e)
		{
		  System.out.println(e);
		  
		}
		return choice_mainMenu;
		
	}
	
	public int submenu(){
		try
		{
			System.out.println("  [1] Add\n"
							  +"  [2] Delete\n"
							  +"  [3] Consult card game\n"
							  +"  [4] Update\n"
							  +"  [5] Search\n"
							  +"  [6] Save card game \n"
							  +"  [7] Exit without save \n");
			choice_submenu=choice.nextInt();
			choice.nextLine();
		} 
		catch (InputMismatchException e) 
		{
			System.out.println("------------------\n"
			  				  +"--Invalid value!--\n"
			  				  +"----Try again----- \n"
			  				  +"------------------\n");
			    choice.nextLine();
			
		} 
		catch (Exception e)
		{
			  System.out.println(e);
		}
		
		return choice_submenu;
	}
	
	

	/**
	 * 
	 *   SUBMENU TO SEARCH BY:
	 *   card number
	 *   card type :pokemon, trainer, energy
	 *   card name
	 *  
	 *  @param1 player
	 *  @param2 card game
	 *  
	 */
	
	public int submenu_search(){		
		try
		{
			System.out.println(" [1] By card number \n"
							  +" [2] By card type  \n"
							  +" [3] By card name \n"
							  +" [4] Back to menu" );
			choice_subMenu_search=choice.nextInt();	
			choice.nextLine();
		} 
		catch (InputMismatchException e) {
			System.out.println("------------------\n"
			  				  +"--Invalid value!--\n"
			  				  +"----Try again----- \n"
			  				  +"------------------\n");
			    choice.nextLine();
			    submenu_search();
		} 
		catch (Exception e){
			  System.out.println(e);
			}
		
		return choice_subMenu_search;
		
		}
	

	/**
	 * Return card type selected
	 * 
	 * @return choice_card_type
	 */
	
	
	
	public int choiceCardType(){
		int choice_card_type=0;	
		try{
			do{
				System.out.println("[1] Pokemon \n"
						    	 + "[2] Energy Card \n"
						    	 + "[3] Trainer Card \n"
						    	 + "[4] Back to menu \n");
				
				choice_card_type = choice.nextInt();
				choice.nextLine();
			}while(choice_card_type<0 || choice_card_type>4);
		} 
		catch (InputMismatchException e) {
			System.out.println("------------------\n"
			  				  +"--Invalid value!--\n"
			  				  +"----Try again----- \n"
			  				  +"------------------\n");
			    choice.nextLine();
			    choiceCardType();
		} 
		catch (Exception e){
			  System.out.println(e);
			}	
		
		
		return choice_card_type;	
	}
	
	
	/**
	 * Return energy type selected
	 * 
	 * @return energyType
	 */
	
	
	public int choiceEnergyType(){
		int energyType=0;
		try{
			do{
				System.out.println("\n-- Choice energy type -- \n"
					 + " [1] Grass \n"
					 + " [2] Fire \n"
					 + " [3] Water \n"
			         + " [4] Lightning \n"
			         + " [5] Psychic \n"
			         + " [6] Fightning \n"
			         + " [7] Darkness \n"
			         + " [8] Metal \n"
			         + " [9] Fairy \n"
			         + " [10] Dragon \n"
			         + " [11] Colorless \n");
			energyType=choice.nextInt();
			choice.nextLine();
			}while(energyType<1 ||energyType>11);
		} 
		catch (InputMismatchException e) {
			System.out.println("------------------\n"
			  				  +"--Invalid value!--\n"
			  				  +"----Try again----- \n"
			  				  +"------------------\n");
			    choice.nextLine();
			    choiceEnergyType();
		} 
		catch (Exception e){
			  System.out.println(e);
			}	
		
			
		return energyType;
	}
	
	
	public int choiceTrainerType(){
		int typeTrainer=0;
		try{
			do{
				
				System.out.println("\n- Choice new trainer type --\n"
										 + "\n [1] Item \n"
										 + " [2] Supporter \n"
										 + " [3] Stadium \n");
						typeTrainer = choice.nextInt();
						choice.nextLine();
				}while(typeTrainer<1||typeTrainer>3);
					
				}catch (InputMismatchException e) {
					System.out.println("------------------\n"
					  				  +"--Invalid value!--\n"
					  				  +"----Try again----- \n"
					  				  +"------------------\n");
				    choice.nextLine();
				    choiceTrainerType();
				} 
				catch (Exception e){
					  System.out.println(e);
					}	
		
			
		return typeTrainer;
	}
	
	
	public int MenuStage(){
		int stage=0;
		try{
			do{
				System.out.println("-- Choice stage --\n"
					 + " [1] Basic \n"
					 + " [2] Stage 1\n"
					 + " [3] Stage 2 \n");
			stage=choice.nextInt();
			choice.nextLine();
			}while(stage<1 ||stage>3);
		} 
		catch (InputMismatchException e) {
			System.out.println("------------------\n"
			  				  +"--Invalid value!--\n"
			  				  +"----Try again----- \n"
			  				  +"------------------\n");
			    choice.nextLine();
			    choiceEnergyType();
		} 
		catch (Exception e){
			  System.out.println(e);
			}	
		
			
		return stage;
	}
	
	/**
	 * Trainer cards menu to update 
	 * 
	 * @return chance
	 */
	
	public int update_menu_field_trainer(){
		int change=0;
		try{
			do{
				System.out.println("-- Choice field do you want change --\n"
								 +"[1] Card number \n"
								 +"[2] Card name\n"
								 +"[3] Type trainer \n"
								 +"[4] Infos\n");		
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
			    update_menu_field_trainer();
		} 
		catch (Exception e){
			  System.out.println(e);
			}	
	
		return change;
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
				System.out.println("-- Choice field do you want change --\n"
								  +"[1] card number \n"
								  +"[2] name\n"
								  +"[3] stage\n");

			change =choice.nextInt();
			choice.nextLine();
			}while(change<1||change>3);
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
				System.out.println("-- Choice field do you want change --\n"
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

	
}

