package pokedeck;

public class EnergyCard extends Card 
{
	
	private static final long serialVersionUID = 1L;
	private int energyType;
	//private TypeCard type="Energy" ;
	
	
	public EnergyCard( int numberCard,  int energyType) 
	{
		super(numberCard);	
		this.type=TypeCard.Energy;
		this.energyType= energyType;
	}

	public void setEnergyType(int energyType)
	{
		this.energyType = energyType;
	}
	
	public String toString()
	{
		String s;
		EnergyTypes energy=null;
		
		switch(energyType){
		case 1:
			energy =EnergyTypes.Grass;
			break;
		case 2:
			energy =EnergyTypes.Fire;
			break;
		case 3:				
			energy =EnergyTypes.Water;
			break;	
		case 4:
			energy=EnergyTypes.Lightning;
			break;
		case 5:
			energy =EnergyTypes.Psychic;
			break;
		case 6:				
			energy =EnergyTypes.Fighting;
			break;
		case 7:
			energy =EnergyTypes.Darkness;
			break;
		case 8:				
			energy =EnergyTypes.Metal;
			break;	
		case 9:
			energy =EnergyTypes.Fairy;
			break;
		case 10:
			energy =EnergyTypes.Dragon;
			break;
		case 11:				
			energy =EnergyTypes.Colorless;
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
