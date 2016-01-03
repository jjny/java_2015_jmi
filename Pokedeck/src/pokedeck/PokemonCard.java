package pokedeck;

public class PokemonCard extends Card
{
	private static final long serialVersionUID = 1L;
	protected int level;
	protected int hp;
	protected String name;
	private String type="Pokemon" ;

	public PokemonCard(String type, int numberCard, String name, int level, int hp)
	{
		super(numberCard);
		this.type=type;
		this.level=level;
		this.hp=hp;
		this.name=name;
		// TODO Auto-generated constructor stub
	}

	public void setName(String name) 
	{
		this.name = name;
	}  	
	
	public int getLevel() 
	{
		return level;
	}


	public void setLevel(int level)
	{
		this.level = level;
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
		
		if (level==1)
			lvl="lvl 1(base)";
		else
			lvl=Integer.toString(this.getLevel());
		
		s=("-------------------------------- \n"
		+  "          Type : "+type+     "\n"
		+  "            Hp : "+hp+     "\n"
		+  "         Level : "+lvl+     "\n"
		+  "          Name : "+name+     "\n"
		+  "        Number : "+numberCard+     "\n"
		+  "------------------------------- \n");
		
		return s;
	}
}

