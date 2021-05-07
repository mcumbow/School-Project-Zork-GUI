/*
* File name: Diamond.java
 * Project name: CISP1020
 * -------------------------------------------------
 * Creator's name: Michael Cumbow
 * Email: mcumbow@comcast.net
 */
package finalGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Michael Cumbow
 * Diamond class inherits AbstractJewels class
 */
public class Diamond extends AbstractJewels {
	
	//private Node currentNode; 
	int currentNode; 				//currentNode integer holds value
	private String name;			//name String holds String value
	private boolean blnDiamond;		//blnRuby boolean holds boolean value
	
	/**
	 * Diamond() default constructor
	 * @return 
	 *
	 */
	
	public Diamond()
	{
		this.blnDiamond = false;
	}//end Diamond()

	/**
	 * Diamond() overload constructor
	 * @return 
	 *
	 */
 	 
 	public Diamond(String name, String Color, int currentNode, boolean blnDiamond) 
 	{ 
 		super(name, Color);
 		this.currentNode = currentNode;
 		this.blnDiamond = blnDiamond;
 	}//end Diamond(String, String, int, int) 
	

	
	/**
	 * Diamond copy constructor
	 *
	 */
	public Diamond(Diamond cDiamond)
	{
		super(cDiamond);

	}//end Diamond(cDiamond) (Copy)
	
	/**
	 * getDiamondNode() gets the current location of the Diamond
	 *
	 */
	
 	public int getDiamondNode() 
 	{ 
 		return currentNode; 
 	} //end getDiamondNode()
 	
	/**
	 * setDiamondNode(int) to set the location of the diamond
	 *
	 */

	
 	public void setDiamondNode(int currentNode) 
 	{ 
 		this.currentNode = currentNode; 
 	} //end setDiamondNode(int)
 	
	/**
	 * @return the blnDiamond
	 */
 	
	public boolean getBlnDiamond() {
			return blnDiamond;
	}//end getBlnDiamond()

	/**
	 * @param blnDiamond the blnDiamond to set
	 */
	public void setBlnDiamond(boolean blnDiamond) {
		this.blnDiamond = blnDiamond;
	}//end setBlnDiamond(boolean)
	
	
	/**
	 * @param pickup(String) to pickup the diamond and move it
	 * drop(String) to drop the diamond in a current location
	 */
	public void pickup(String jewel) {
		if (jewel.equalsIgnoreCase("Diamond"))
		{
		setBlnDiamond(true);
		}
		
	}//end pickup(String)

	public void drop(String jewel) throws inputErrorException 
	{
		Player player1 = new Player();
		if (jewel.equalsIgnoreCase("Diamond"))
		{
		//setDiamondNode(player1.getCurrentNode().getNodeID());
		setBlnDiamond(false);
		}
		else {
			throw new inputErrorException("Nothing was entered");
		}
	}//end drop(String)
	
	/**
	 * toString() override method
	 *
	 */
 	 
 	@Override 
	public String toString() { 
		return super.toString() + "Diamond [currentNode=" + getDiamondNode() + "] Diamond was picked up [ " + getBlnDiamond() + "]"; 
	} 
	
	/*
	 * toSave() method to write information to the file
	 */
	public String toSave ( )
	{
		return super.toSave() + ":" + getDiamondNode() + ":" + getBlnDiamond();
	}//end toSave() method

}//end Diamond class
