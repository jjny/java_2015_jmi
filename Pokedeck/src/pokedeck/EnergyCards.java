package pokedeck;
import java.util.ArrayList;


public class EnergyCards extends Card {
	
	private static final long serialVersionUID = 1L;
	private int energyType;
	
	public EnergyCards(int type, int numberCard,  int energyType) {
		super(type, numberCard);
		this.energyType= energyType;
	}

	
	public int getEnergyType() {
		return energyType;
	}


	public void setEnergyType(int energyType) {
		this.energyType = energyType;
	}
	
	
	/*
	public void deleteCard(int numberCard, ArrayList<Card> collect){
		ArrayList<Card> delete=new ArrayList<Card>();
		for(Card obj: collect){
			if(this.getNumberCard()==numberCard){
				delete.add(obj);
			}
		}
		
		for(Card ObjDelete : delete){
			delete.remove(ObjDelete);
		}
		
	}*/
	
	
	public String toString(){
		String s;
		String energy=null;
		String cardType=null;
		
		switch(type){
		case 1:
			cardType ="Pokemon";
			break;
		case 2:
			cardType ="Energy";
			break;
		case 3:				
			cardType ="Trainer";
			break;			
	}
		
		switch(energyType){
		case 1:
			energy ="Grass";
			break;
		case 2:
			energy ="Fire";
			break;
		case 3:				
			energy ="Water";
			break;	
		case 4:
			energy="Lightning";
			break;
		case 5:
			energy ="Psychic";
			break;
		case 6:				
			energy ="Fighting";
			break;
		case 7:
			energy ="Drakness";
			break;
		case 8:				
			energy ="Metal";
			break;	
		case 9:
			energy ="Fairy";
			break;
		case 10:
			energy ="Dragon";
			break;
		case 11:				
			energy ="Colorless";
			break;		
	}
		

		
		s=("-------------------------------- \n"
		+  "          Type : "+cardType+     "\n"
		+  "   Energy Type : "+energy+     "\n"
		+  "        Number : "+this.getNumberCard()+     "\n"
		+  "------------------------------- \n");
				
				
		return s;
	}



}
