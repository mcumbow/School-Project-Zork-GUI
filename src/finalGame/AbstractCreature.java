package finalGame;
/**
 * -------------------------------------------------
 * File name: AbstractCreature.java
 * Project name: Project 4
 * -------------------------------------------------
 * Creator's name: Michael Cumbow
 * Email: mcumbow@comcast.net
 */

/**
 * Class description: AbstractCreature is the abstract class for Creature
 * - Constructors: Default, Copy and Overloaded
 * - Getter methods:
 * - Setter methods:
 * - Public methods: checkDead, takeDamage
 *
 *
 */

public abstract class AbstractCreature
{
	//class attributes
	protected String name;
	protected double health;
	
	/**
	 * Constructor description: Default Constructor
	 */
	public AbstractCreature()
	{
		this.name = "TBD";
		this.health = 0.0;
		
	}
	
	/**
	 * Constructor description: Overloaded Constructor
	 * @param name
	 * @param health
	 */
	
	public AbstractCreature(String name, double health)
	{
		super();
		this.name = name;
		this.health = health;
	}
	
	/**
	 * Constructor description: Copy Constructor
	 * @param creature
	 */
	
	public AbstractCreature(AbstractCreature creature)
	{
		this.name = creature.name;
		this.health = creature.health;
		
	}
	
	abstract boolean checkDead();
	abstract void takeDamage(double attackValue);
	
}
