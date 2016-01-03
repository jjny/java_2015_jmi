package pokedeck;

public class EnergyCard extends Card 
{
	
	private static final long serialVersionUID = 1L;
	private int energyType;
	private String type="Energy" ;
	
	
	public EnergyCard(String type, int numberCard,  int energyType) 
	{
		super(numberCard);	
		this.type=type;
		this.energyType= energyType;
	}

	public void setEnergyType(int energyType)
	{
		this.energyType = energyType;
	}
	
	public String toString()
	{
		String s;
		String energy=null;
		
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
		+  "          Type : "+type+     "\n"
		+  "   Energy Type : "+energy+     "\n"
		+  "        Number : "+numberCard+     "\n"
		+  "------------------------------- \n");
								
		return s;
	}
}
