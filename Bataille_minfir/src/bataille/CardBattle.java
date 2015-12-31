package bataille;

public class CardBattle {
	
	private int color;
	private int value;	
	
	public CardBattle(int color, int value) {
		this.color=color;
		this.value=value;		
	}

	public int getColor() 
	{
		return color;
	}

	public int getValue() {
		return value;
	}

	public String compare(CardBattle c){
	
		String comparison;
		
		if(this.value==c.getValue())
			comparison = "=";			
		else if (this.value < c.getValue())
			comparison = "-";
		else  
			comparison = "+";
		
		return comparison;	
	}
	
	
	public String toString()
	{
		String col = null;
		String val=null;		
		
		switch(color)
		{
			case 1:
				col ="coeur";
				break;
			case 2:
				col ="trefle";
				break;
			case 3:				
				col ="carreau";
				break;
			case 4:				
				col ="pique";
				break;			
		}
	
		switch(value)
		{
		case 14:
			val="as";
			break;
		case 13:
			val="roi";
			break;
		case 12:
			val="reine";
			break;
		case 11:
			val="valet";
			break;
		case 10:
			val="dix";
			break;
		case 9:
			val="neuf";
			break;	
		case 8:
			val="huit";
			break;
		case 7:
			val="sept";
			break;
		case 6:
			val="six";
			break;	
		case 5:
			val="cinq";
			break;
		case 4:
			val="quatre";
			break;
		case 3:
			val="trois";
			break;	
		case 2:
			val="deux";
			break;	
		}
		return val+" de "+col;		
	}


	public boolean equals(Object obj)
	{ 
		return ((CardBattle)obj).color==this.color && ((CardBattle)obj).value==this.value;
	}
	

}
