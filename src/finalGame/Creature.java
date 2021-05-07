package finalGame;

import java.util.Random;

public class Creature extends AbstractCreature
{
	Random rand = new Random();
	
	//class attributes
	boolean isDead;
	String name;
	double health = 100;
	
	
	/**
	 * Constructor description: Default Constructor
	 * Date: March 11, 2018
	 */
	
	public Creature()
	{
		this.isDead = false;
		this.health = 0;
		this.name = "TBD";
	}
	
	/**
	 * Constructor description: Overloaded Constructor
	 * @param name
	 * @param health
	 * @param title
	 * @param loot
	 * @param attackValue
	 * @param isDead
	 * Date: March 11, 2018
	 */
	
	public Creature(String name, double health, boolean isDead)
	{
		super();
		this.isDead = isDead;
		this.name = name;
		this.health = health;
	}
	
	/**
	 * Constructor description: Copy Constructor
	 * @param creature
	 * Date: March 11, 2018
	 */
	
	public Creature(Creature creature)
	{
		super(creature);
		this.isDead = creature.getIsDead();
	}

	/**
	 * Method description: Return name attribute
	 * @return name
	 * Date: March 11, 2018
	 */
	
	public String getName()
	{
		return name;
	}
	
	/**
	 * Method description: Set name attribute
	 * @param name
	 * Date: March 11, 2018
	 */
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Method description: Return health attribute
	 * @return health
	 * Date: March 11, 2018
	 */
	
	public double getHealth()
	{
		return health;
	}
	
	/**
	 * Method description: Set health attribute
	 * @param health
	 * Date: March 11, 2018
	 */
	
	public void setHealth(Double health)
	{
		this.health = health;
	}
	
	/**
	 * Method description: Return isDead attribute
	 * @return isDead
	 * Date: March 11, 2018
	 */
	
	public boolean getIsDead()
	{
		return isDead;
	}
	
	/**
	 * Method description: Set isDead attribute
	 * @param isDead
	 * Date: March 11, 2018
	 */
	
	public void setIsDead(boolean isDead)
	{
		this.isDead = isDead;
	}
	
	/**
	 * Method description: Check if the creature is dead
	 * @return isDead
	 * Date: March 11, 2018
	 */

	@Override
	public boolean checkDead()
	{
		if(health <= 0)
		{
			isDead = true;
		}
		
		return isDead;
	}

	/**
	 * Method description: Apply damage to the creature
	 * @param attackValue
	 * Date: March 11, 2018
	 */
	
	@Override
	public void takeDamage(double attackValue)
	{
		health-=attackValue;
	}
	
	/**
	 * Method description: toString for printing the object in line
	 * @return
	 * Date: March 11, 2018
	 */

	@Override
	public String toString()
	{
		return "Creature [name=" + name + ", health=" + health + ", isDead=" + isDead + "]";
	}
	
	/**
	 * Method description: Saves the current game state
	 * @return
	 * Date: March 11, 2018
	 */

	public String toSave()
	{
		return name + ":" + Double.toString(health) + ":" + isDead;
	}
}
