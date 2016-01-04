package pokedeck;

public class PokemonCard extends Card
{
	private static final long serialVersionUID = 1L;
	protected StagePokemon stage;
	protected int hp;
	protected String name;


	public PokemonCard(int numberCard, String name, StagePokemon stage, int hp)
	{
		super(numberCard);
		this.type=TypeCard.Pokemon;
		this.stage=stage;
		this.hp=hp;
		this.name=name;
		// TODO Auto-generated constructor stub
	}

	public void setName(String name) 
	{
		this.name = name;
	}  	


	public void setStage(StagePokemon stage)
	{
		this.stage= stage;
	}

	public void setHp(int hp)
	{
		this.hp = hp;
	}
	
	public boolean equals_name(String name)
	{ 
		return name.equals(this.name);
	}
	
	public String toString()
	{
		String s;
		String lvl=null;
		
		s=("-------------------------------- \n"
		+  "          Type : "+type+     "\n"
		+  "            Hp : "+hp+     "\n"
		+  "         Stage : "+stage+     "\n"
		+  "          Name : "+name+     "\n"
		+  "        Number : "+numberCard+     "\n"
		+  "------------------------------- \n");
		
		return s;
	}
}

