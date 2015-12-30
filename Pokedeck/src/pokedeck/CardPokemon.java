package pokedeck;




public class CardPokemon extends Card{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int level;
	protected int hp;
	String name;
	

	public CardPokemon(int type, int numberCard, String name, int level, int hp) {
		super(type, numberCard);
		this.level=level;
		this.hp=hp;
		this.name=name;
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}  
	
	
	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}
	
	

	public boolean equals_name(String name) { 
		return name.equals(this.name);
	}
	
	public String toString(){
		String s;
		String lvl=null;
		String cardType=null;
		if (level==1){
			lvl="base (lvl 1)";
		}else{
			
			lvl=Integer.toString(this.getLevel());
		}
		
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
		
		s=("-------------------------------- \n"
		+  "          Type : "+cardType+     "\n"
		+  "            Hp : "+this.getHp()+     "\n"
		+  "         Level : "+lvl+     "\n"
		+  "          Name : "+this.getName()+     "\n"
		+  "        Number : "+this.getNumberCard()+     "\n"
		+  "------------------------------- \n");
				
				
		return s;
	}

}

