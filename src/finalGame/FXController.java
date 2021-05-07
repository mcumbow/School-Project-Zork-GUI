/**
 * 
 */
package finalGame;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.EventHandler;

/**
 * @author Michael
 *
 */
public class FXController implements Initializable {
	
	String response = ""; 					//String var to hold input value
	boolean done = false; 					//boolean value for kicking out of while loop
	Scanner cin = new Scanner(System.in); 	//Initializing Scanner
	Random rand = new Random();				//initializing Random function
	int nodeID = 0; 						//integer var to hold nodeID number
	String textArea = "";
	ArrayList<AbstractJewels> JewelBag = new ArrayList<AbstractJewels>();
	ArrayList<AbstractJewels> gameSave = new ArrayList<AbstractJewels>();
	ArrayList<Creature> creature = new ArrayList<Creature>();
	ArrayList<Node> nodes = new ArrayList<Node>();
	
	//creates four game nodes 
	Node node1 = new Node(0, 0, 0, "Home", "Home is where the heart is."); 
	Node node2 = new Node(1, 0, 1, "Library", "Books rock.");
	Node node3 = new Node(0, 1, 2, "Office", "Down and dirty!");
	Node node4 = new Node(0, -1, 3, "Bed room", "Where the magic happens.");
	
	//nodeID = rand.nextInt(3 - 0) + 1;
	//Ruby Ruby1 = new Ruby("Ruby", "Red", nodeID, false);
	
    @FXML
    //private Label result;
    private TextArea ta;
    
    @FXML
    private TextField tf;
    
    @FXML
    private Button submit;
    
    @FXML
    private Button N;
    
    @FXML
    private Button S;
    
    @FXML
    private Button E;
    
    @FXML
    private Button W;
    
    @FXML
    private Button SE;
    
    @FXML
    private Button SW;
    
    @FXML
    private Button NE;
    
    @FXML
    private Button NW;
    mapDriver MD = new mapDriver();
	
	public FXController() {
		
	}

	@FXML
	public void onCloseEvent(ActionEvent event)
	{
		System.exit(0);
	}//end onCloseEvent(ActionEvent)
	
	@FXML
	public void onClickNorth(ActionEvent event)
	{
		response = "North";
	}//end onCloseEvent(ActionEvent)
	
	@FXML
	public void onClickSubmit(ActionEvent event)
	{
	    response = tf.getText();
	}//end onClickSubmit(ActionEvent)
	
	@FXML
	public void onClickSouth(ActionEvent event)
	{
		response = "South";
	}//end onCloseEvent(ActionEvent)
	
	@FXML
	public void onClickEast(ActionEvent event)
	{
		response = "East";
	}//end onCloseEvent(ActionEvent)
	@FXML
	public void onClickWest(ActionEvent event)
	{
		response = "West";
	}//end onCloseEvent(ActionEvent)
	@FXML
	public void onClickNW(ActionEvent event)
	{
		response = "North West";
	}//end onCloseEvent(ActionEvent)
	@FXML
	public void onClickNE(ActionEvent event)
	{
		response = "North East";
	}//end onCloseEvent(ActionEvent)
	@FXML
	public void onClickSW(ActionEvent event)
	{
		response = "South West";
	}//end onCloseEvent(ActionEvent)
	@FXML
	public void onClickSE(ActionEvent event)
	{
		response = "South East";
	}//end onCloseEvent(ActionEvent)
	
	
	public void gameRun() 
 	{ 
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
		creature.add(Hobgoblin1);
		
		ta.appendText(" [ To Load the game type: Load ] \n");
		ta.appendText(player1.toString() + "\n");
		
		N.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) 
	        {
	        	response = "North";
	        	movePlayer(player1, Ruby1, Diamond1, Hobgoblin1);
	        }
		});
		S.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) 
	        {
	        	response = "South";
	        	movePlayer(player1, Ruby1, Diamond1, Hobgoblin1);
	        }
		});
		E.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) 
	        {
	        	response = "East";
	        	movePlayer(player1, Ruby1, Diamond1, Hobgoblin1);
	        }
		});
		W.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) 
	        {
	        	response = "West";
	        	movePlayer(player1, Ruby1, Diamond1, Hobgoblin1);
	        }
		});
		NW.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) 
	        {
	        	response = "North West";
	        	movePlayer(player1, Ruby1, Diamond1, Hobgoblin1);
	        }
		});
		NE.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) 
	        {
	        	response = "North East";
	        	movePlayer(player1, Ruby1, Diamond1, Hobgoblin1);
	        }
		});
		SW.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) 
	        {
	        	response = "South West";
	        	movePlayer(player1, Ruby1, Diamond1, Hobgoblin1);
	        }
		});
		SE.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) 
	        {
	        	response = "South East";
	        	movePlayer(player1, Ruby1, Diamond1, Hobgoblin1);
	        }
		});
		
		submit.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) 
	        {
				response = tf.getText();
				if (response.equalsIgnoreCase("Load")) 
				{
					ta.clear();
					ta.appendText(player1.toString());
					gameLoad();

				} 
				if (response.equalsIgnoreCase(""))
				{
					ta.clear();
					ta.appendText(player1.toString());
				}
				
	        //running the game
	        
				ta.appendText("?: ");
				//while(!done) 
		 		//{ 
					switch(response.toUpperCase())
					{
					
					case "SAVE" :

		  				saveInfo();
						ta.appendText(player1.toString());
					
					case "SAVE AND DONE" :
			  				saveInfo();
							 ta.appendText("\nBye Adventurer, see you next game!");
								ta.setText("\nPress Enter to continue\n");
								tf.clear();
								submit.setOnAction(new EventHandler<ActionEvent>() {
							        @Override
							        public void handle(ActionEvent event) 
							        {
							        	System.exit(-1);
							        }
								});

					case "END GAME" :
							ta.appendText("\nBye Adventurer, see you next game!");
							ta.setText("\nPress Enter to continue\n");
							tf.clear();
							submit.setOnAction(new EventHandler<ActionEvent>() {
						        @Override
						        public void handle(ActionEvent event) 
						        {
						        	System.exit(-1);
						        }
							});


					}//end switch()

					//////////////////////////////////////////// RUBY SECTION /////////////////////////////////////
					setupRuby(Ruby1, Hobgoblin1,player1);
					
					////////////////////////////////////////////// DIAMOND ////////////////////////////////////////
					setupDiamond(Diamond1, Hobgoblin1, player1);
					
					gameEnding(Ruby1, Diamond1, player1);
			     }
			 });
	}//end gameRun()
	
	public void gameLoad()
	{
		Ruby Ruby1 = new Ruby();
		Diamond Diamond1 = new Diamond();
		Player player1 = new Player();
		Hobgoblin Hobgoblin1 = new Hobgoblin();
		//Loading the game

		if (response.equalsIgnoreCase("Load")) 
		{
			ta.appendText("\nImporting data from file to Arraylist!");
			File file = new File(MD.fileChooser()); 				 //Sets dir path for db file
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
				ta.appendText("Debug");
				ta.appendText(e.toString());
			}//end catch
			
			
			for (AbstractJewels AJ: JewelBag)
			{
				ta.appendText("\n" + AJ.getName() + " is in your JewlBag!");
			}
			ta.appendText(player1.toString());
		}
	}//end gameLoad()

	public void saveInfo()
	{
		Player player1 = new Player();
		MD.saveFile(gameSave, creature);
	}//end saveInfo()
	
	public void movePlayer(Player player1, Ruby Ruby1, Diamond Diamond1, Hobgoblin Hobgoblin1)
	{
		if (!(response.contains("drop")) || response.contains("Drop") )
		{
				nodeID = player1.getCurrentNode().isValidDirection(response.trim());
				
				if (nodeID != -1)
				{
					tf.clear();
					ta.clear();
					player1.setCurrentNode(nodes.get(nodeID));
					ta.setText(player1.toString());
				}
				if(nodeID <= -1)
 				{ 
 					ta.appendText("Wrong direction, Enter a different direction");
 				}
				
				//////////////////////////////////////////// RUBY SECTION /////////////////////////////////////
				setupRuby(Ruby1, Hobgoblin1, player1);
				
				////////////////////////////////////////////// DIAMOND ////////////////////////////////////////
				setupDiamond(Diamond1, Hobgoblin1, player1);
				}
		
				gameEnding(Ruby1, Diamond1, player1);

			}//end the player move
	
	public void setupRuby(Ruby Ruby1, Hobgoblin Hobgoblin1, Player player1)
	{

		if (Ruby1.getRubyNode() == player1.getCurrentNode().getNodeID() && Ruby1.getBlnRuby() == false)
		{
			ta.setText("\nThere is a ruby in room, You can go to different room or type: pickup Ruby");
			response = tf.getText();

			if (response.equalsIgnoreCase("pickup Ruby") && Ruby1.getBlnRuby() == false && Hobgoblin1.getNodeID() != player1.getCurrentNode().getNodeID())
			{
				Ruby1.pickup("Ruby");
				JewelBag.add(Ruby1);
				Ruby1.setBlnRuby(true);
				ta.appendText("\nYou picked up the Ruby.\n");
				//print updated contents of JewlBag
 				for (AbstractJewels AJ: JewelBag)
 				{
 					ta.appendText("\n" + AJ.getName() + " is in your JewlBag!");
 				}
 				ta.appendText("\n Press ENTER to continue. \n");
 				tf.clear();
			}//end if no monster

			if (response.equalsIgnoreCase("pickup Ruby") && Ruby1.getBlnRuby() == false && Hobgoblin1.getNodeID() == player1.getCurrentNode().getNodeID() && Hobgoblin1.isDead == false)
			{
				ta.clear();
				tf.clear();
				ta.appendText("\nA hobgoblin attacks you as you reach for the ruby!");
				
				//health loss of the player from initial hobgoblin attack
				ta.appendText("\nPlayers health " + player1.getHealth() + "\n");
				ta.appendText("\nHobgoblins health " + Hobgoblin1.getHealth() + "\n");
				ta.appendText("\nType Attack");						
				response = tf.getText();
			}//end if monster

			//if the player chooses to attack
			else if (response.equalsIgnoreCase("attack"))
				{
					tf.clear();
					//player hurts hobgoblin
					
					Hobgoblin1.healthLoss();
					ta.appendText("\nPlayers health " + player1.getHealth() + "\n");
					ta.appendText("\nHobgoblins health " + Hobgoblin1.getHealth() + "\n");
					
					//if the hobgoblin has no remaining health
					
					if(Hobgoblin1.getHealth() <= 0.0 && player1.getHealth() > 0.0)
					{
						//successfully pickup the ruby and add to player JewlBag
 						Ruby1.pickup("Ruby");
 						JewelBag.add(Ruby1);
 						Ruby1.setBlnRuby(true);
 						Hobgoblin1.isDead = true;
 						ta.appendText("\nYou picked up the ruby after defeating the hobgoblin.\n");
 						//print updated contents of JewlBag
 	 	 				for (AbstractJewels AJ: JewelBag)
 	 	 				{
 	 	 				ta.appendText("\n" + AJ.getName() + " is in your JewlBag!\n");
 	 	 				}
		 				ta.appendText("\n Press ENTER to continue. \n");
		 				tf.clear();
 	 	 				//print player1 status
 	 					//System.out.print(player1);
					}
					//else the hobgoblin is still alive
					else if (Hobgoblin1.getHealth() > 0.0 && player1.getHealth() > 0.0)
						{
							//battle = true;
							//hobgoblin hurts player
							ta.appendText("\nType Attack");
	 	 					response = tf.getText();
							player1.healthLoss();
							Hobgoblin1.healthLoss();
						}
					
					else if (Hobgoblin1.getHealth() > 0.0 && player1.getHealth() <= 0.0) 
						{
							ta.appendText("\nPlayers health " + player1.getHealth() + "\n");
							ta.appendText("Hobgoblins health " + Hobgoblin1.getHealth() + "\n");
							ta.appendText("You was killed by the Hobgoblin!!!!! GAME OVER!!!!\n");
							ta.appendText("\nPress Enter to continue\n");
							tf.clear();
							submit.setOnAction(new EventHandler<ActionEvent>() {
						        @Override
						        public void handle(ActionEvent event) 
						        {
						        	System.exit(-1);
						        }

							});
						}
					else if (Hobgoblin1.getHealth() <= 0.0 && player1.getHealth() <= 0.0) 
						{
							ta.appendText("\nPlayers health " + player1.getHealth() + "\n");
							ta.appendText("Hobgoblins health " + Hobgoblin1.getHealth() + "\n");
							ta.appendText("You was killed by the Hobgoblin!!!!! and You killed the Hobgoblin!!! GAME OVER!!!!\n");
							ta.appendText("\nPress Enter to continue\n");
							tf.clear();
							submit.setOnAction(new EventHandler<ActionEvent>() {
						        @Override
						        public void handle(ActionEvent event) 
						        {
						        	System.exit(-1);
						        }

							});
						}
				  }
			}
			else if (response.equalsIgnoreCase("drop ruby") && Ruby1.getBlnRuby() == true)
			{
				try {
					Ruby1.drop("Ruby");
				} catch (inputErrorException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

					Ruby1.setRubyNode(player1.getCurrentNode().getNodeID());
					Ruby1.setBlnRuby(false);
					JewelBag.remove(Ruby1);
					ta.appendText("You dropped the Ruby at: " + player1.getCurrentNode().getNodeName());
	 				ta.appendText("\n Press ENTER to continue. \n");
	 				tf.clear();
			}
	}//end setupRuby()
	
	public void setupDiamond(Diamond Diamond1, Hobgoblin Hobgoblin1, Player player1)
	{
		if (Diamond1.getDiamondNode() == player1.getCurrentNode().getNodeID() && Diamond1.getBlnDiamond() == false)
		{
			ta.setText("\nThere is a Diamond in room, You can go to a different room or type: pickup Diamond");
			response = tf.getText();
			if (response.equalsIgnoreCase("pickup Diamond") && Diamond1.getBlnDiamond() == false && Hobgoblin1.getNodeID() != player1.getCurrentNode().getNodeID())
			{
				Diamond1.pickup("Diamond");
				JewelBag.add(Diamond1);
				Diamond1.setBlnDiamond(true);
				ta.appendText("\nYou picked up the Diamond.\n");
				//print updated contents of JewlBag
 				for (AbstractJewels AJ: JewelBag)
 				{
 					ta.appendText("\n" +AJ.getName() + " is in your JewlBag!\n");
 				}
 				ta.appendText("\n Press ENTER to continue. \n");
 				tf.clear();
			}//end if no monster
			
			if (response.equalsIgnoreCase("pickup Diamond") && Diamond1.getBlnDiamond() == false && Hobgoblin1.getNodeID() == player1.getCurrentNode().getNodeID() && Hobgoblin1.isDead == false)
			{
				tf.clear();
				ta.clear();
				ta.appendText("\nA hobgoblin attacks you as you reach for the Diamond!\n");
				
				//health loss of the player from initial hobgoblin attack
				ta.appendText("\nPlayers health " + player1.getHealth() + "\n");
				ta.appendText("\nHobgoblins health " + Hobgoblin1.getHealth() + "\n");
				ta.appendText("\nType Attack\n");						
				response = tf.getText();
			}//end if monster

			//if the player chooses to attack
			else if (response.equalsIgnoreCase("attack"))
				{
					tf.clear();
					//player hurts hobgoblin
					Hobgoblin1.healthLoss();
					ta.appendText("\nPlayers health " + player1.getHealth() + "\n");
					ta.appendText("\nHobgoblins health " + Hobgoblin1.getHealth() + "\n");
				//}	
					//if the hobgoblin has no remaining health
					if(Hobgoblin1.getHealth() <= 0.0 && player1.getHealth() > 0.0)
					{
						//the battle is over
						//battle = false;
						//successfully pickup the ruby and add to player JewlBag
 						Diamond1.pickup("Diamond");
 						JewelBag.add(Diamond1);
 						Diamond1.setBlnDiamond(true);
 						Hobgoblin1.isDead = true;
 						ta.appendText("\nYou picked up the Diamond after defeating the hobgoblin.\n");
 						//print updated contents of JewlBag
 	 	 				for (AbstractJewels AJ: JewelBag)
 	 	 				{
 	 	 				ta.appendText("\n" + AJ.getName() + " is in your JewlBag!\n");
 	 	 				}
		 				ta.appendText("\n Press ENTER to continue. \n");
		 				tf.clear();
 	 	 				//print player1 status
 	 					//System.out.print(player1);
					}
					//else the hobgoblin is still alive
					else if (Hobgoblin1.getHealth() > 0.0 && player1.getHealth() > 0.0)
						{
							//battle = true;
							//hobgoblin hurts player
							ta.appendText("\nType Attack");
 	 	 					response = tf.getText();
							player1.healthLoss();
							Hobgoblin1.healthLoss();
						}
					
					else if (Hobgoblin1.getHealth() > 0.0 && player1.getHealth() <= 0.0) 
						{
							ta.appendText("\nPlayers health " + player1.getHealth() + "\n");
							ta.appendText("Hobgoblins health " + Hobgoblin1.getHealth() + "\n");
							ta.appendText("You was killed by the Hobgoblin!!!!! GAME OVER!!!!\n");
							ta.appendText("\nPress Enter to continue\n");
							tf.clear();
							submit.setOnAction(new EventHandler<ActionEvent>() {
						        @Override
						        public void handle(ActionEvent event) 
						        {
						        	System.exit(-1);
						        }

							});
						}
					else if (Hobgoblin1.getHealth() <= 0.0 && player1.getHealth() <= 0.0) 
						{
							ta.appendText("\nPlayers health " + player1.getHealth() + "\n");
							ta.appendText("Hobgoblins health " + Hobgoblin1.getHealth() + "\n");
							ta.appendText("You was killed by the Hobgoblin!!!!! and You killed the Hobgoblin!!! GAME OVER!!!!\n");
							ta.appendText("\nPress Enter to continue\n");
							tf.clear();
							submit.setOnAction(new EventHandler<ActionEvent>() {
						        @Override
						        public void handle(ActionEvent event) 
						        {
						        	System.exit(-1);
						        }

							});
						}
				  }
				 }//end Diamond if

/*				else if ((response.equalsIgnoreCase("drop diamond")) && Diamond1.getBlnDiamond() == true)
				{
					try {
						Diamond1.drop("Diamond");
					} catch (inputErrorException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

 					Diamond1.setDiamondNode(player1.getCurrentNode().getNodeID());
 					Diamond1.setBlnDiamond(false);
 					JewelBag.remove(Ruby1);
 					ta.appendText("You dropped the Diamond at: " + player1.getCurrentNode().getNodeName());
				}
				else if (response.equalsIgnoreCase("Done") && player1.getCurrentNode().getNodeID() != 0)
				{
						if (Ruby1.getBlnRuby() == true && Diamond1.getBlnDiamond() == true)
					{
							ta.appendText("You must go Home before you are Done");
					}
				}
				else if (response.equalsIgnoreCase("Done") && player1.getCurrentNode().getNodeID() == 0 && Diamond1.getBlnDiamond() == true && Ruby1.getBlnRuby() == true)
				{
					 ta.setText("\nYou collected all the Jewels! Congratulations! You win!\n");
				}
		       }*/
	}//end setupDiamond
	
	public void gameEnding(Ruby Ruby1, Diamond Diamond1, Player player1)
	{
		 if ((response.equalsIgnoreCase("drop diamond")) && Diamond1.getBlnDiamond() == true)
		{
			try {
				Diamond1.drop("Diamond");
			} catch (inputErrorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Diamond1.setDiamondNode(player1.getCurrentNode().getNodeID());
			Diamond1.setBlnDiamond(false);
			JewelBag.remove(Ruby1);
			ta.appendText("You dropped the Diamond at: " + player1.getCurrentNode().getNodeName() + "\n");
			ta.appendText("\n Press ENTER to continue. \n");
			tf.clear();
		}
		else if (response.equalsIgnoreCase("Done") && player1.getCurrentNode().getNodeID() != 0)
		{
				if (Ruby1.getBlnRuby() == true && Diamond1.getBlnDiamond() == true)
			{
					ta.appendText("You must go Home before you are Done");
			}
		}
		else if (response.equalsIgnoreCase("Done") && player1.getCurrentNode().getNodeID() == 0 && Diamond1.getBlnDiamond() == true && Ruby1.getBlnRuby() == true)
		{
			ta.setText("\nYou collected all the Jewels! Congratulations! You win!\n");
			ta.setText("\nPress Enter to continue\n");
			tf.clear();
			submit.setOnAction(new EventHandler<ActionEvent>() {
		        @Override
		        public void handle(ActionEvent event) 
		        {
		        	System.exit(-1);
		        }

			});
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gameRun();
	}
}
