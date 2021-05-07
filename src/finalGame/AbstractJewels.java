/*
* File name: AbstractJewels.java
 * Project name: CISP1020
 * -------------------------------------------------
 * Creator's name: Michael Cumbow
 * Email: mcumbow@comcast.net
 */

package finalGame;

/**
 * AbstractJewels for setting values for the jewels being created
 * implements IETools for the interface of AbstractJewels
 */
abstract class AbstractJewels implements IETools {
	
	
	private String name;			//String name hold value
	private String Color;			//String Color hold value
	
	//Default Constructor
	
	public AbstractJewels()
	{
		this.name = name;
		this.Color = Color;
	}//end AbstractJewels()
	

	//Overloaded Constructor
	
	public AbstractJewels(String name, String Color)
	{
		this.name = name;
		this.Color = Color;
	}//end AbstractJewels(String, String)
	
	//Copy Constructor
	
	public AbstractJewels(AbstractJewels aC)
	{
		name = aC.name;
		Color = aC.Color;
	}//end AbstractJewels(AbstractJewels)


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}//end getName()

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}//end setName(String)

	/**
	 * @return the health
	 */
	public String getColor() {
		return Color;
	}//end getColor()

	/**
	 * @param Color method for Color to set
	 */
	public void setColor(String Color) {
		this.Color = Color;
	}//end setColor(String)
	
	// * toString() method to write information to Screen
	
	public String toString()
	{
		String strInfo = "";
		strInfo = "AbstractJewel [Name =" + name + "]" + "[Color =" + Color + "]"; 
		return strInfo;
	}//end toString()
	
	
	// * toSave() method to write information to the file
	
	public String toSave ( )
	{
		return "AbstractJewel" + ":" + name + ":" + Color;
	}//end toSave() method
}//end AbstractJewels() class
