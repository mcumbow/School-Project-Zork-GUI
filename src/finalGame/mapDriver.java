/*
 * File name: mapDriver.java
 * Project name: CISP1020
 * -------------------------------------------------
 * Creator's name: Michael Cumbow
 * Email: mcumbow@comcast.net
 */
package finalGame;
import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the driver for my game project
 *
 */
 public class mapDriver  extends Application
 { 
		@Override
		public void start(Stage primaryStage) {
			
			try {		
				Parent Root = FXMLLoader.load(getClass().getResource("gameGUI.fxml"));
				
				Scene scene = new Scene(Root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

 	public static void main(String[] args) 
 	{ 
 /*		boolean done = false; 					//boolean value for kicking out of while loop
 		Scanner cin = new Scanner(System.in); 	//Initializing Scanner
 		Random rand = new Random();				//initializing Random function
 		String response = ""; 					//String var to hold input value
 		int nodeID = 0; 						//integer var to hold nodeID number
 		String textArea = "";
 		 
 		//creates four game nodes 
 		Node node1 = new Node(0, 0, 0, "Home", "Home is where the heart is."); 
 		Node node2 = new Node(1, 0, 1, "Library", "Books rock.");
 		Node node3 = new Node(0, 1, 2, "Office", "Down and dirty!");
 		Node node4 = new Node(0, -1, 3, "Bed room", "Where the magic happens."); 
 		 
 		ArrayList<Node> nodes = new ArrayList<Node>(); 
 		nodes.add(node1); 
 		nodes.add(node2);
 		nodes.add(node3);
 		nodes.add(node4);
 		 
 		//add connections between the nodes 
 		node1.addConnection(new Node(node2));
 		node2.addConnection(new Node(node1));
 		node1.addConnection(new Node(node3));
 		node3.addConnection(new Node(node1));
 		node1.addConnection(new Node(node4));
 		node4.addConnection(new Node(node1));
 		node2.addConnection(new Node(node3));
 		node3.addConnection(new Node(node2));
 		node2.addConnection(new Node(node4));
 		node4.addConnection(new Node(node2));
 		
		ArrayList<AbstractJewels> JewelBag = new ArrayList<AbstractJewels>();
		ArrayList<AbstractJewels> gameSave = new ArrayList<AbstractJewels>();
		ArrayList<Creature> creature = new ArrayList<Creature>();
 		 
 		//add player at first node and print node info
 		Player player1 = new Player(node1);
 		gameSave.add(player1);

 		//Setting up node random generator for jewels to be added to node randomly
 	
		nodeID = rand.nextInt(3 - 0) + 1;
 		Ruby Ruby1 = new Ruby("Ruby", "Red", nodeID, false);
		gameSave.add(Ruby1);
		
	
		boolean node = false;
		while(!node)
		{
			nodeID = rand.nextInt(3 + 0) + 1;
			
			if (nodeID == Ruby1.getRubyNode())
			{
				nodeID = rand.nextInt(3 + 0) + 1;
			}
			else {
				node = true;
			}
		}
 		Diamond Diamond1 = new Diamond("Diamond", "Blue", nodeID, false);
		gameSave.add(Diamond1);

		int genRand = rand.nextInt((10000 - 5000)+ 1000);
		if (genRand > 3000)
		{
			genRand = Diamond1.getDiamondNode();	
		}
		else {
			genRand = Ruby1.getRubyNode();
		}
		
		double hobLife = rand.nextInt(100 - 1) +1;
		Hobgoblin Hobgoblin1 = new Hobgoblin("Hobgoblin", hobLife, false, true, genRand);
		//creature.add(new Hobgoblin(Hobgoblin1));
		creature.add(Hobgoblin1);
		
		//Loading the game
		System.out.println(" [To Load the game type: Load ], [ Start new game press: enter ] ");
		response = cin.nextLine();
		if (response.equalsIgnoreCase("Load")) 
		{
			
			System.out.println("Importing data from file to Arraylist!");
			File file = new File(fileChooser()); 				 //Sets dir path for db file
			Scanner ScanFile = new Scanner(System.in); 			 //Initalizes scanner
			try
			{
				ScanFile = new Scanner(file);
				while (ScanFile.hasNextLine())	 //Reads file into array
				{
					String strInfo = ScanFile.nextLine();
					String[] importInfo = strInfo.split ("[:]");
					if (importInfo[1].equals ("Ruby"))
					{
						Ruby1.setName(importInfo[1]);
						Ruby1.setColor(importInfo[2]);
						Ruby1.setRubyNode(Integer.parseInt(importInfo[3]));
						Ruby1.setBlnRuby(Boolean.parseBoolean(importInfo[4]));
						if (Ruby1.getBlnRuby() == true)
						{
							JewelBag.add(Ruby1);
						}
					}
					if (importInfo[1].equals ("Diamond"))
					{
						Diamond1.setName(importInfo[1]);
						Diamond1.setColor(importInfo[2]);
						Diamond1.setDiamondNode(Integer.parseInt(importInfo[3]));
						Diamond1.setBlnDiamond(Boolean.parseBoolean(importInfo[4]));
						if (Diamond1.getBlnDiamond() == true)
						{
							JewelBag.add(Diamond1);
						}
					}
					if (importInfo[0].equals ("Player"))
					{
						if (importInfo[1].equals("0"))
						{
						player1.setCurrentNode(node1);
						}
						if (importInfo[1].equals("1"))
						{
						player1.setCurrentNode(node2);
						}
						if (importInfo[1].equals("2"))
						{
						player1.setCurrentNode(node3);
						}
						if (importInfo[1].equals("3"))
						{
						player1.setCurrentNode(node4);
						}
						player1.setHealth(Double.parseDouble(importInfo[2]));
					}
					
					if (importInfo[0].equals ("Hobgoblin"))
					{
						Hobgoblin1.setName(importInfo[0]);
						Hobgoblin1.setHealth(Double.parseDouble(importInfo[1]));
						Hobgoblin1.setIsDead(Boolean.parseBoolean(importInfo[2]));
						Hobgoblin1.setPoisonous(Boolean.parseBoolean(importInfo[3]));
						Hobgoblin1.setNodeID(Integer.parseInt(importInfo[4]));
						if (Hobgoblin1.getIsDead() == false)
						{
							creature.add(Hobgoblin1);
						}
					}
				}//end while loop
			}//end try
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			} 
			catch(Exception e)
			{
				System.out.println("Debug");
				System.out.println(e.toString());
			}//end catch
			for (AbstractJewels AJ: JewelBag)
			{
				System.out.println(AJ.getName() + " is in your JewlBag!");
			}
			System.out.print(player1);
		}
		
		else {
			System.out.print(player1); 
			
		}
		
		//Starting the game with a while loop and boolean
 		 
 		while(!done) 
 		{ 
 			try 
 			{ 
 				for (AbstractJewels AJ: JewelBag)
 				{
 					System.out.println(AJ.getName() + " is in your JewlBag!");
 				}
 				System.out.print("?: "); 
 				response = cin.nextLine();

 				if (response.equalsIgnoreCase("Save")) 
 				{
	 		 		System.out.println("Saving Game!");
 		 			saveFile(gameSave, creature);
 		 			//saveFile2(creature);
 					System.out.print(player1);
 				}
 				if (response.equalsIgnoreCase("Save and Done")) 
 				{
	 		 		System.out.println("Saving Game!");
 		 			saveFile(gameSave, creature);
 		 			//saveFile2(creature);
 		 			done = true;
 					continue;
 				}
 				if (response.equalsIgnoreCase("End game")) 
 				{
	 		 		System.out.println("Game Ended!");
 		 			done = true;
 					continue;
 				}
 				if(response.equals("D") && player1.getCurrentNode().getNodeID() == 0) 
 				{ 
 					done = true; 
 					continue; 
 				} 
 				if (response.equals("D") && player1.getCurrentNode().getNodeID() != 0 && Ruby1.getBlnRuby() == true && Diamond1.getBlnDiamond() == true) 
 				{
					throw new inputErrorException("You must drop the jewels off at Home before you are Done");
 				}

 				if (response.equals("D") && player1.getCurrentNode().getNodeID() != 0) 
 				{
 					if (Diamond1.getDiamondNode() != 0 || Ruby1.getRubyNode() != 0)
 					{
 						System.out.println("You forgot a jewel!");
 					}
 				}
 				
 				if (response.equalsIgnoreCase(("drop Ruby")) &&  Ruby1.getBlnRuby() == true)
 				{
 					Ruby1.drop("Ruby");
 					Ruby1.setRubyNode(player1.getCurrentNode().getNodeID());
 					JewelBag.remove(Ruby1);
 					System.out.println("You dropped the Ruby at: " + player1.getCurrentNode().getNodeName());
 	 				for (AbstractJewels AJ: JewelBag)
 	 				{
 	 					System.out.println(AJ.getName() + " is in your JewlBag!");
 	 				}
 				}
				
 				if (response.equalsIgnoreCase(("drop Diamond")) &&  Diamond1.getBlnDiamond() == true)
 				{
 					Diamond1.drop("Diamond");
 					Diamond1.setDiamondNode(player1.getCurrentNode().getNodeID());
 					JewelBag.remove(Diamond1);
 					System.out.println("You dropped the Diamond at: " + player1.getCurrentNode().getNodeName());
 	 				for (AbstractJewels AJ: JewelBag)
 	 				{
 	 					System.out.println(AJ.getName() + " is in your JewlBag!");
 	 				}
 				}
 				if (!(response.contains("drop")) || response.contains("Drop") )
 				{
	 				nodeID = player1.getCurrentNode().isValidDirection(response.trim());
	 				
	 				if (nodeID != -1)
	 				{
 					player1.setCurrentNode(nodes.get(nodeID));
	 				}
	 			}
	 				
 				if(nodeID <= -1 && (!(response.contains("drop")) || response.contains("Drop")))
 				{ 
 					throw new BadGameMoveException(response, "\nTry another direction!"); 
 				}

				*//**
				 * and then the GUI.
				 *//*
				
 				if (Ruby1.getRubyNode() == player1.getCurrentNode().getNodeID() && Ruby1.getBlnRuby() == false)
 				{
 					System.out.println("\nThere is a ruby in room type: pickup Ruby");
 					response = cin.nextLine();
 					if (response.equalsIgnoreCase("pickup Ruby") && Ruby1.getBlnRuby() == false && Hobgoblin1.getNodeID() == player1.getCurrentNode().getNodeID() && Hobgoblin1.isDead == false)
 					{
 						System.out.println("A hobgoblin attacks you as you reach for the ruby!");
 						
 						//health loss of the player from initial hobgoblin attack
 						System.out.println("Players health " + player1.getHealth());
 						System.out.println("Hobgoblins health " + Hobgoblin1.getHealth());

 	 					System.out.println("\nType Attack");
 	 					response = cin.nextLine();

 						//boolean that shows the current state of battle
 						boolean battle = true;
 						
 						//while the battle is still underway
 						while(battle == true)
 						{
 							//if the player chooses to attack
 	 						if (response.equalsIgnoreCase("attack"))
 	 						{
 	 							//player hurts hobgoblin
 	 							Hobgoblin1.healthLoss();
 		 						System.out.println("Players health " + player1.getHealth());
 		 						System.out.println("Hobgoblins health " + Hobgoblin1.getHealth());
 	 							
 	 							//if the hobgoblin has no remaining health
 	 							if(Hobgoblin1.getHealth() <= 0.0 && player1.getHealth() > 0.0)
 	 							{
 	 								//the battle is over
 	 								battle = false;
 	 								//successfully pickup the ruby and add to player JewlBag
 	 		 						Ruby1.pickup("Ruby");
 	 		 						JewelBag.add(Ruby1);
 	 		 						Ruby1.setBlnRuby(true);
 	 		 						Hobgoblin1.isDead = true;
 	 		 						System.out.println("You picked up the ruby after defeating the hobgoblin.");
 	 		 						//print updated contents of JewlBag
 	 		 	 	 				for (AbstractJewels AJ: JewelBag)
 	 		 	 	 				{
 	 		 	 	 					System.out.println(AJ.getName() + " is in your JewlBag!");
 	 		 	 	 				}
 	 		 	 	 				//print player1 status
 	 		 	 					//System.out.print(player1);
 	 							}
 	 							//else the hobgoblin is still alive
	 	 							if (Hobgoblin1.getHealth() > 0.0 && player1.getHealth() > 0.0)
	 	 							{
	 	 								battle = true;
	 	 								//hobgoblin hurts player
	 	 	 	 	 					System.out.println("\nType Attack");
	 	 	 	 	 					response = cin.nextLine();
	 	 								player1.healthLoss();
	 	 								Hobgoblin1.healthLoss();
	 	 							}
	 	 							else if (Hobgoblin1.getHealth() <= 0.0 && player1.getHealth() > 0.0) {
	 	 								battle = false;
	 	 							}
	 	 							else if (Hobgoblin1.getHealth() > 0.0 && player1.getHealth() <= 0.0)
	 	 							{
		 		 						System.out.println("Players health " + player1.getHealth());
		 		 						System.out.println("Hobgoblins health " + Hobgoblin1.getHealth());
 	 									System.out.println("You was killed by the Hobgoblin!!!!! GAME OVER!!!!");
 	 									System.exit(-1);
	 	 							}
 	 						}
 	 						//else the player types in any other command than attack
 	 						else
 	 						{
 	 							//tell the player they must attack
 	 							battle = true;
 	 							System.out.println("You must fight the hobgoblin! type attack to attack the monster!");
 	 							response = cin.nextLine();
 	 						}
 						}

 					}
 					else if (response.equalsIgnoreCase("pickup Ruby") && Ruby1.getBlnRuby() == false && Hobgoblin1.getNodeID() == player1.getCurrentNode().getNodeID() &&
 	 						Hobgoblin1.isDead == true)
 					{
 						Ruby1.pickup("Ruby");
 						JewelBag.add(Ruby1);
 						Ruby1.setBlnRuby(true);
 						System.out.println("You picked up the Ruby.");
 						//print updated contents of JewlBag
 	 	 				for (AbstractJewels AJ: JewelBag)
 	 	 				{
 	 	 					System.out.println(AJ.getName() + " is in your JewlBag!");
 	 	 				}
 	 	 				//print player1 status
 	 					//System.out.print(player1);
 						
 					}
 					else if (response.equalsIgnoreCase("pickup Ruby") && Ruby1.getBlnRuby() == false && Hobgoblin1.getNodeID() != player1.getCurrentNode().getNodeID())
 					{
	 						Ruby1.pickup("Ruby");
	 						JewelBag.add(Ruby1);
	 						Ruby1.setBlnRuby(true);
	 						System.out.println("You picked up the ruby.");
	 						//print updated contents of JewlBag
	 	 	 				for (AbstractJewels AJ: JewelBag)
	 	 	 				{
	 	 	 					System.out.println(AJ.getName() + " is in your JewlBag!");
	 	 	 				}
	 	 	 				//print player1 status
	 	 					//System.out.print(player1);
 					}

 					//should the player try to pick up the ruby after already having done so
 					else if (response.equalsIgnoreCase("pickup Ruby") & Ruby1.getBlnRuby() == true)
 					{
 						//let player know they've already gotten the ruby
 						System.out.println("The ruby is already in your JewlBag.");
 					}
 					
 					//esle command input was not formatted correctly
 					else if (!(response.equalsIgnoreCase("pickup Ruby")))
 					{
 						System.out.println("\nInput is incorrect, Ruby was left at " + player1.getCurrentNode().getNodeName());
 						//System.out.print(player1);
 					}
 				}
 				///Diamond
 				if (Diamond1.getDiamondNode() == player1.getCurrentNode().getNodeID() && Diamond1.getBlnDiamond() == false)
 				{
 					System.out.println("\nThere is a Diamond in room type: pickup Diamond");
 					response = cin.nextLine();
 					if (response.equalsIgnoreCase("pickup Diamond") && Diamond1.getBlnDiamond() == false && Hobgoblin1.getNodeID() == player1.getCurrentNode().getNodeID() &&
 						Hobgoblin1.isDead == false)
 					{
 						//if (Hobgoblin1.getNodeID() == player1.getCurrentNode().getNodeID())
 						//{
	 						//>>>>THIS NEEDS TO BE TESTED<<<<<
	 						System.out.println("A hobgoblin attacks you as you reach for the diamond!");
	 						
	 						//health loss of the player from initial hobgoblin attack
	 						System.out.println("Players health " + player1.getHealth());
	 						System.out.println("Hobgoblins health " + Hobgoblin1.getHealth());

	 	 					System.out.println("\nType Attack");
	 	 					response = cin.nextLine();
	 						
	 						//boolean that shows the current state of battle
	 						boolean battle = true;
	 						
	 						//while the battle is still underway
	 						while(battle == true)
	 						{
	 							//if the player chooses to attack
	 	 						if (response.equalsIgnoreCase("attack"))
	 	 						{
	 	 							//player hurts hobgoblin
	 	 							Hobgoblin1.healthLoss();
	 		 						System.out.println("Players health " + player1.getHealth());
	 		 						System.out.println("Hobgoblins health " + Hobgoblin1.getHealth());
	 	 							
	 	 							//if the hobgoblin has no remaining health
	 	 							if(Hobgoblin1.getHealth() <= 0.0 && player1.getHealth() > 0.0)
	 	 							{
	 	 								//the battle is over
	 	 								battle = false;
	 	 								//successfully pickup the ruby and add to player JewlBag
	 	 		 						Diamond1.pickup("Diamond");
	 	 		 						JewelBag.add(Diamond1);
	 	 		 						Diamond1.setBlnDiamond(true);
	 	 		 						Hobgoblin1.isDead = true;
	 	 		 						System.out.println("You picked up the Diamond after defeating the hobgoblin.");
	 	 		 						//print updated contents of JewlBag
	 	 		 	 	 				for (AbstractJewels AJ: JewelBag)
	 	 		 	 	 				{
	 	 		 	 	 					System.out.println(AJ.getName() + " is in your JewlBag!");
	 	 		 	 	 				}
	 	 		 	 	 				//print player1 status
	 	 		 	 					//System.out.print(player1);
	 	 							}
	 	 							//else the hobgoblin is still alive
		 	 							if (Hobgoblin1.getHealth() > 0.0 && player1.getHealth() > 0.0)
		 	 							{
		 	 								battle = true;
		 	 								//hobgoblin hurts player
		 	 	 	 	 					System.out.println("\nType Attack");
		 	 	 	 	 					response = cin.nextLine();
		 	 								player1.healthLoss();
		 	 								Hobgoblin1.healthLoss();
		 	 							}
		 	 						
		 	 							else if (Hobgoblin1.getHealth() <= 0.0 && player1.getHealth() > 0.0) {
		 	 								battle = false;
		 	 							}
		 	 							else if (Hobgoblin1.getHealth() > 0.0 && player1.getHealth() <= 0.0)
		 	 							{
	 	 									System.out.println("You was killed by the Hobgoblin!!!!! GAME OVER!!!!");
	 	 									System.exit(-1);
		 	 							}
	
	 	 						}
	 	 						//else the player types in any other command than attack
	 	 						else
	 	 						{
	 	 							//tell the player they must attack
	 	 							battle = true;
	 	 							System.out.println("You must fight the hobgoblin! type attack to attack the monster!");
	 	 							response = cin.nextLine();
	 	 						}
	 						}

 					}
 					else if (response.equalsIgnoreCase("pickup Diamond") && Diamond1.getBlnDiamond() == false && Hobgoblin1.getNodeID() == player1.getCurrentNode().getNodeID() &&
 	 						Hobgoblin1.isDead == true)
 					{
 						Ruby1.pickup("Diamond");
 						JewelBag.add(Diamond1);
 						Diamond1.setBlnDiamond(true);
 						System.out.println("You picked up the Diamond.");
 						//print updated contents of JewlBag
 	 	 				for (AbstractJewels AJ: JewelBag)
 	 	 				{
 	 	 					System.out.println(AJ.getName() + " is in your JewlBag!");
 	 	 				}
 	 	 				//print player1 status
 	 					//System.out.print(player1);
 						
 					}
 					else if (response.equalsIgnoreCase("pickup Diamond") && Diamond1.getBlnDiamond() == false && Hobgoblin1.getNodeID() != player1.getCurrentNode().getNodeID())
 					{
	 						Ruby1.pickup("Diamond");
	 						JewelBag.add(Diamond1);
	 						Diamond1.setBlnDiamond(true);
	 						System.out.println("You picked up the Diamond.");
	 						//print updated contents of JewlBag
	 	 	 				for (AbstractJewels AJ: JewelBag)
	 	 	 				{
	 	 	 					System.out.println(AJ.getName() + " is in your JewlBag!");
	 	 	 				}
	 	 	 				//print player1 status
	 	 					//System.out.print(player1);
 					}

 					//should the player try to pick up the ruby after already having done so
 					else if (response.equalsIgnoreCase("pickup Diamond") & Diamond1.getBlnDiamond() == true)
 					{
 						//let player know they've already gotten the ruby
 						System.out.println("The ruby is already in your JewlBag.");
 					}
 					
 					//esle command input was not formatted correctly
 					else if (!(response.equalsIgnoreCase("pickup Diamond")))
 					{
 						System.out.println("\nInput is incorrect, Diamond was left at " + player1.getCurrentNode().getNodeName());
 						//System.out.print(player1);
 					}
 				}
					System.out.print(player1);
 			} //end try
 			catch(BadGameMoveException | inputErrorException err) 
 			{ 
 				System.out.println(err.getMessage()); 
 			} 
 		} //end while loop
 		
 		//This is the end so whenever kicked out of loop by boolean (ending the game)
 		
 		 if (Diamond1.getBlnDiamond() != true && Ruby1.getBlnRuby() != true && Diamond1.getDiamondNode() == 0 && Ruby1.getRubyNode() == 0)
 		 {
			System.out.println("You collected all the Jewels! Congratulations! You win!");
			for (AbstractJewels j: JewelBag)
			{
				System.out.println(j);
			}
 		 }
 		 else if (response.equalsIgnoreCase("Save and Done") || response.equalsIgnoreCase("End game"))
 		 {
			cin.close();
 		 }
 		 else 
 		 {
 			System.out.println("You didn't collect all the Jewels and drop them off at Home. You Lose!");
 		 }
 		 
 		System.out.println("Bye Adventurer, see you next game!"); 
	cin.close();  	*/
 		launch(args);
	}//end main(args)
 	
 	public static void setResponse(String response)
 	{
 		response = response;
 	}
 		
 	/**
 	 * This is my jFileChooser setup method
 	 *
 	 */
 	
 	public static String fileChooser() 
	{
		String strInput = "";
		try {
		    JFileChooser chooser = new JFileChooser();
		    chooser.setCurrentDirectory(new File(".\\src\\finalGame"));
		   // E:\School\Northeaststate\FinalProjectGame\src\finalGame
		    chooser.setDialogTitle ("Choose your db file");
		    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		    int returnVal = chooser.showOpenDialog(chooser.getParent ( ));
		    if (returnVal == JFileChooser.APPROVE_OPTION) {
			   strInput +=chooser.getSelectedFile ( ).getAbsolutePath ( );
		    }
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid input, try again.");
			System.out.println(e.toString());
		}//end catch
	    return strInput;
	}//end fileChooser()
 	
 	/**
 	 * This is the sameFile(Arraylist) method for saving the 
 	 * jewel and player location on the map
 	 */
 	
 	public static void saveFile(ArrayList<AbstractJewels> gameSave ,ArrayList<Creature> gameSave2)
 	{
		try {
			File file = new File(fileChooser()); 	  	//setting file to open
			Scanner ScanFile = new Scanner(file); 	  	//Reading file opened
			FileWriter fw = new FileWriter(file, false);// append file opened
			PrintWriter newFile = new PrintWriter(fw);  // write to new file open
			
			for(AbstractJewels Save: gameSave) 		
			{
				if (gameSave != null) 
				{
					newFile.println(Save.toSave());
				}
			}
			for(Creature Save: gameSave2) 		
			{
				if (gameSave2 != null) 
				{
					newFile.println(Save.toSave());
				}
			}
			ScanFile.close ( );
			newFile.close ( );
			fw.close ( );
		}
		catch(InputMismatchException e)
		{
			System.out.println("error!! input mismatch!");
			System.out.println(e.toString());
		}//end catch
		catch(Exception e)
		{
			System.out.println("Debug");
			System.out.println(e.toString());
		}//end catch
		
		//System.out.println("Saved data from Arraylist to file");
 	}//end saveFile(ArrayList)	
} //end mapDriver()
