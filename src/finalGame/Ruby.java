/*
* File name: Ruby.java
 * Project name: CISP1020
 * -------------------------------------------------
 * Creator's name: Michael Cumbow
 * Email: mcumbow@comcast.net
 */
package finalGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Michael Cumbow
 * Ruby class inherits AbstractJewels class
 */
public class Ruby extends AbstractJewels {
	
	private int currentNode; 		//currentNode integer holds value
	private String name;			//name String holds String value
	private boolean blnRuby;		//blnRuby boolean holds boolean value
	
 	
	/**
	 * Ruby() default constructor
	 * @return 
	 *
	 */
	public Ruby()
	{
		this.blnRuby = false;
	}//end Ruby()
	
	/**
	 * Ruby() overload constructor
	 * @return 
	 *
	 */
 	 
 	public Ruby(String name, String Color, int currentNode, boolean blnRuby) 
 	{ 
 		super(name, Color);
 		this.currentNode = currentNode;
 		this.blnRuby = blnRuby;
 	} //end Ruby(String, String, int, boolean)
	
	/**
	 * Ruby copy constructor
	 *
	 */
	public Ruby(Ruby cRuby)
	{
		super(cRuby);

	}//end Ruby(Ruby) (Copy)
	
	/*
	 * getRubyNode() for getting the location of the Ruby 
	 */
	
 	public int getRubyNode() 
 	{ 
 		return currentNode; 
 	} //end getRubyNode()

	/*
	 * setting the node id for ruby location
	 */
 	public void setRubyNode(int currentNode) 
 	{ 
 		this.currentNode = currentNode; 
 	} //end setRubyNode(int)
 	
 	 /* @return the blnRuby
	 */
	public boolean getBlnRuby() {
		return blnRuby;
	}//end getBlnRuby()

	/**
	 * @param setblnRuby the blnRuby to set
	 */
	public void setBlnRuby(boolean blnRuby) {
		this.blnRuby = blnRuby;
	}//end setBlnRuby
	
	/*
	 * pickup and drop method's for moving the jewels where needed to
	 */
	public void pickup(String jewel) 
	{
		if (jewel.equalsIgnoreCase("Ruby"))
		{
		setBlnRuby(true);
		}
	}//end pickup(String)

	public void drop(String jewel) throws inputErrorException 
	{
		Player player1 = new Player();
		if (jewel.equalsIgnoreCase("Ruby"))
		{
	 	setBlnRuby(false);
		}
		else if (jewel.equalsIgnoreCase(null)) {
			throw new inputErrorException("Nothing was entered");
		}
	}//end drop(String)
	
	/**
	 * toString() override method
	 *
	 */
 	  
	public String toString() { 
		return super.toString() + "Ruby [currentNode=" + getRubyNode() + "] Ruby was picked up [ " + getBlnRuby() + "]"; 
	} //end toString()
	
	/*
	 * toSave() method to write information to the file
	 */
	public String toSave ( )
	{
		return super.toSave() + ":" + getRubyNode() + ":" + getBlnRuby();
	}//end toSave() method

}//end Ruby class
