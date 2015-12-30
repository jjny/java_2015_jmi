package pokedeck;


public class TrainerCards extends Card {

	private static final long serialVersionUID = 1L;
	private int trainerType;
	private String name;
	private String infos;

	public TrainerCards(int type, int numberCard, String name, int trainerType, String infos) {
		super(type, numberCard);
		this.name=name;
		this.trainerType=trainerType;
		this.infos=infos;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}  
	
	
	public int getTrainerType() {
		return trainerType;
	}

	public void setTrainerType(int trainerType) {
		this.trainerType = trainerType;
	}
	
	
	public String getInfos() {
		return infos;
	}


	public void setInfos(String infos) {
		this.infos = infos;
	}

	
	
	
	  public boolean equals_name(String name) { 
		  return name.equals(this.name);
		  }
	  
	  
	public String toString(){
		String s;
		String cardType=null;
		String trainer=null;
		
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
		
		switch(trainerType){
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
		+  "          Type : "+cardType+     "\n"
		+  "  Trainer Type : "+trainer+     "\n"
		+  "          Name : "+this.getName()+     "\n"
		+  "        Number : "+this.getNumberCard()+     "\n"
		+  "------------------------------- \n")
		+"      "+getInfos()+"\n"
		;
		
				
				
		return s;
	}


	
}