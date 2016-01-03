package pokedeck;

public class TrainerCard extends Card 
{
	private static final long serialVersionUID = 1L;
	private int trainerType;
	private String name;
	private String infos;
	private String type="Trainer" ;

	public TrainerCard(String type, int numberCard, String name, int trainerType, String infos) 
	{
		super(numberCard);
		this.type=type;
		this.name=name;
		this.trainerType=trainerType;
		this.infos=infos;
	}

	public void setName(String name) {
		this.name = name;
	}  
	
	public void setTrainerType(int trainerType) {
		this.trainerType = trainerType;
	}

	public void setInfos(String infos) {
		this.infos = infos;
	}

	  public boolean equals_name(String name)
	  { 
		  return name.equals(this.name);
	}
  
	public String toString()
	{
		String s;
		String trainer=null;

		switch(trainerType)
		{
		case 1:
			trainer ="Item";
			break;
		case 2:
			trainer ="Supporte";
			break;
		case 3:				
			trainer ="Stadium";
			break;			
	}
		
		s=("-------------------------------- \n"
		+  "          Type : "+type+     "\n"
		+  "  Trainer Type : "+trainer+     "\n"
		+  "          Name : "+name+     "\n"
		+  "        Number : "+numberCard+     "\n"
		+  "------------------------------- \n")
		+"      "+infos+"\n"
		;
				
		return s;
	}
}