package pokedeck;

import java.io.Serializable;

public class Card implements Serializable 
{
	
	private static final long serialVersionUID = 1L;
	protected TypeCard type;
	protected int typePokemon;
	protected int numberCard;
	protected String name;
	//protected int level;
	protected int hp;
	protected int energyType;
	protected int trainerType;
	protected String infos;

	
	public Card (/*int type,*/int numberCard)
	{
		//this.setType(type);
		this.setNumberCard(numberCard);
	}

	public TypeCard getType()
	{
		return type;
	}
	
	public int getTypePokemon()
	{
		return typePokemon;
	}


	public int getNumberCard()
	{
		return numberCard;
	}

	public void setNumberCard(int numberCard) 
	{
		this.numberCard = numberCard;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public void setLevel(int lvl) {
		this.level = lvl;
	}*/

	public void setHp(int hp) 
	{
		this.hp = hp;
	}

	public void setEnergyType(int energyType)
	{
		this.energyType = energyType;
	}

	public void setTrainerType(int trainerType) 
	{
		this.trainerType = trainerType;
	}

	public void setInfos(String infos) 
	{
		this.infos = infos;
	}
	
	
	public boolean equals_name(String name){
		return false;
	}
		
	
	
}
