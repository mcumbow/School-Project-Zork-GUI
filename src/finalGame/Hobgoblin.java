package finalGame;

import java.util.Random;

public class Hobgoblin extends Creature
{
	//class attributes
	boolean poisonous;
	int nodeID;
	
	/**
	 * Constructor description: Default Constructor
	 * Date: March 12, 2018
	 */
	
	public Hobgoblin()
	{
		this.poisonous = false;
		this.nodeID = 0;
	}
	
	/**
	 * Constructor description: Overloaded Constructor
	 * @param name
	 * @param health
	 * @param isDead
	 * @param poisonous
	 * @param nodeID
	 * Date: March 12, 2018
	 */
	
	public Hobgoblin(String name, double health, boolean isDead, boolean poisonous, int nodeID)
	{
		super(name, health, isDead);
		this.poisonous = poisonous;
		this.nodeID = nodeID;
	}

	
	/**
	 * Constructor description: Copy Constructor
	 * @param hobgoblin
	 * Date: March 12, 2018
	 */
	
	public Hobgoblin(Hobgoblin hobgoblin)
	{
		super(hobgoblin);
		this.poisonous = hobgoblin.getPoisonous();
	}

	/**
	 * Method description: Return nodeID attribute
	 * @return nodeID
	 * Date: March 12, 2018
	 */
	
	public int getNodeID()
	{
		return nodeID;
	}
	
	/**
	 * Method description: Set nodeID attribute
	 * @param nodeID
	 * Date March 12, 2018
	 */
	
	public void setNodeID(int nodeID)
	{
		this.nodeID = nodeID;
	}
	
	/**
	 * Method description: Return poisonous attribute
	 * @return poisonous
	 * Date: March 12, 2018
	 */
	
	public boolean getPoisonous()
	{
		return poisonous;
	}
	
	/**
	 * Method description: Set poisonous attribute
	 * @param poisonous
	 * Date March 12, 2018
	 */
	
	public void setPoisonous(boolean poisonous)
	{
		this.poisonous = poisonous;
	}
	
	/**
	 * Method description: Return health attribute
	 * @return health
	 * Date: March 12, 2018
	 */
	
	public double getHealth()
	{
		return health;
	}
	
	/**
	 * Method description: Set health attribute
	 * @param health
	 * Date March 12, 2018
	 */
	
	public void setHealth(double health)
	{
		this.health = health;
	}
	
	/**
	 * Method description: Check if hobgoblin is poisonous
	 * @return
	 * Date: March 12, 2018
	 */

	public boolean isPoisonous()
	{
		return poisonous;
	}

	/**
	 * Method description: Take away health from hobgoblin
	 * @return
	 * Date: March 12, 2018
	 */
	
	public double healthLoss()
	{
		//attributes that define the range for a random number
		int damageDone = 10;
		
		health -= damageDone;
		
		//return the new amount of health
		return health;
	}


	/**
	 * Method description: toString for printing the object in line
	 * @return
	 * Date: March 12, 2018
	 */

	@Override
	public String toString()
	{
		return super.toString() + " Hobgoblin [poisonous=" + poisonous + "]";
	}
	
	/**
	 * Method description: Saves the current game state
	 * @return
	 * Date: March 12, 2018
	 */
	
	public String toSave()
	{
		return super.toSave() + ":" + poisonous + ":" + nodeID;
	}
}
