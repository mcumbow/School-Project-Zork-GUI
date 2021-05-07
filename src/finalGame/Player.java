/*
* File name: Player.java
 * Project name: CISP1020
 * -------------------------------------------------
 * Creator's name: Michael Cumbow
 * Email: mcumbow@comcast.net
 */
package finalGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Player.java is to setup the player for the game which  AbstractJewels 
 *
 */
public class Player extends AbstractJewels { 
	Random rand = new Random();
	
 	private Node currentNode; 
	double playerLife = rand.nextInt(100 - 1) +1;
 	private double health = playerLife; 
 	
 	/**
 	 * Player default constructor 
 	 *
 	 */
 	
 	public Player() 
 	{ 
 		
 	} //end Player()
 	
 	/**
 	 * Player copy constructor 
 	 *
 	 */
 	 
 	public Player(Node currentNode) 
 	{ 
 		this.currentNode = currentNode; 
 		this.health = health; 
 	} //end Player(Node)
 	
 	/**
 	 * getCurrentNode() method to get the current mode of player
 	 *
 	 */
 
 
 	public Node getCurrentNode() 
 	{ 
 		return currentNode; 
 	} //end getCurrentNode()
 	
 	/**
 	 * pickup(String) method for picking up and dropping the jewel specified 
 	 *
 	 */
 	

	public void pickup(String jewel) {

	}//end pickup(String)

	public void drop(String jewel) {
		
	} //end drop(String)
	
 	/**
 	 * setCurrentNode(Node)
 	 * For setting the current node of the player 
 	 *
 	 */
 	 
 	public void setCurrentNode(Node currentNode) 
 	{ 
 		this.currentNode = currentNode; 
 	} //end setCurrentNode(Node)
 	
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
	
	public double getHealth()
	{
		return health;
	}
	public void setHealth(double health)
	{
		this.health =  health;
	}

	/**
	 * toString() override method
	 *
	 */
 	  
	public String toString() { 
		return "\nPlayer is in " + currentNode + "]" + "\n [To Save the game type: Save ] " + "\n [To quit game without saving type: End Game ] \n";
	} //end toString()
	
	/*
	 * toSave() method to write information to the file
	 */
 	
 	public String toSave() 
 	{ 
 		return "Player" + ":" + currentNode.getNodeID() + ":" + getHealth(); 
 	}//end toSave()
} //end Player Class

