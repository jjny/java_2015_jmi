package pokedeck;

import java.io.Serializable;

public class Card implements Serializable 
{
	
	private static final long serialVersionUID = 1L;
	protected int type;
	protected int numberCard;
	protected String name;
	protected int level;
	protected int hp;
	protected int energyType;
	protected int trainerType;
	protected String infos;

	
	public Card (int type,int numberCard)
	{
		this.setType(type);
		this.setNumberCard(numberCard);
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public int getNumberCard()
	{
		return numberCard;
	}

	public void setNumberCard(int numberCard) 
	{
		this.numberCard = numberCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getLevel() 
	{
		return type;
	}

	public void setLevel(int lvl) {
		this.level = lvl;
	}
	
	public int getHp() 
	{
		return hp;
	}


	public void setHp(int hp) 
	{
		this.hp = hp;
	}
	
	public int getEnergyType()
	{
		return energyType;
	}


	public void setEnergyType(int energyType)
	{
		this.energyType = energyType;
	}
	
	public int getTrainerType() 
	{
		return trainerType;
	}

	public void setTrainerType(int trainerType) 
	{
		this.trainerType = trainerType;
	}
	
	
	public String getInfos() 
	{
		return infos;
	}


	public void setInfos(String infos) 
	{
		this.infos = infos;
	}
	
	
	public boolean equals_name(String name){
		return false;
	}
		
	
	
}
