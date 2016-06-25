import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

// primary class for the Safe Cracker Game
/*
 * 	GAME OVERVIEW:
 * 
 *	In the game, the player takes on the role of a crook, the player takes on multiple levels
 *	in the form of safes. Each safe has a varying degree of difficulty. To crack the safe and win the level,
 *  all the player has to do is determine the combination to the safe. 
 *  
 *  Each safe contains a combination contain some number of digits (0-9) and possibly directions
 *  in the form of (U=up, D=Down, L=Left and R=Right). Each safe permits only so many attempts and
 *  only a limited amount of time.
 *  
 *  If the player fails to crack the safe with either the specified number of moves or within the time limit
 *  they will be busted and lose money.
 *  
 *  The player is also assigned a wanted level that dictates their bail out cost. If the player can't afford to bail out
 *  jail after being busted, the game is over.
 *  
 *  While playing, the user is not completely alone. The player will have the assistance of their handy-dandy CrackerJacker 3000DX,
 *  which after each attempt will tell them how many positions and digits they got correct in the combination, as well as how many 
 *  attempts they have left and how much time they have. 
 *  
 *  There are also several cheats available, but they don't come cheap. One cheat will deduce the size of the combination, another
 *  will completely blow the hinges off a safe, and finally one will delay the arrival of the cops and give the 
 *  player an extra move to try and break the safe.
 * 
 *  PROGRAM OVERVIEW:
 *  The program is divided into several classes that handle specific parts of the game.
 *  The TeraCracker class is the main class and it holds the general overview of the game.
 *  The Player class holds all the information on the player including their bankroll, bailout costs, safes broken, etc..
 *  The Safe class builds a new safe and interacts with the CrackerJacker class for gameplay
 *  The CrackerJacker class acts as the game board, communicating with safes and with the player
 *  The Interface class deals with the gui and event driven code. This shouldn't be done, use a gui class only
 *  
 *  The person playing the game will interact with the interface class
 *  interface talks with the player class, which talks with the CrackerJacker class, which talks with the safe
 */


public class TeraCracker
{

	/*
	 * GigaCracker is the graphical version of MegaCracker...
	 * 
	 * Player will try to break into  safes by guessing the combination which contains digits 0-9 and directions u,d,l, and r.
	 * Player wins loot by cracking safes and loses loot by failing to crack them within the alloted number of moves or time.
	 */
	
	/* To Do List
	 * 
	 * 
	 * Clear up display of loot and wanted level
	 * add comments
	 *  Consider what happens when the hideTools and hideButtons methods are changed
	
	 */
	
	//data field
	
	static int loot=3000; // Loot is the currency of the game. Player gains and looses loot based on winning/losing safes. default is 3000 
	static int turnCount=0;  // this is the number of guesses made in the game, it counts upward from zero
	static int totalBreakIns=0; // Counts the number of safes cracked in a players career default is 0
	static int wantedLevel=1; // Wanted level dictates the cost of bail and increments based on how many safes the player has cracked
	static int comboSize=3; // determines how many digits in a combo, default is 3
	static int directions=0; // details how many directions can be found in a combination
	static int bail=0; // how much a player pays for failing to crack a safe, value will be based on wantedLevel and the difficulty of a safe
	static int payout=0; // how much a player gets for cracking a safe, the range of values is determined by the difficulty of a safe
	static int difficulty=1; // Correlates to how tough a safe is to crack, and settings will be changed based on this value
	static int guessLimit=10;  // in most difficulties, the number of guesses will be 10. However this may change for a few safes
	static int posistionsCorrect=0; // during play, this variable tells how many positions are correct (note that positions and digits are 2 distinct concepts)
	static int digitsCorrect=0;  // during play, tells how many digits are correct (but doesn't tell how many are in the correct spots)
	static int timeInSeconds=0; // holds the seconds portion of the time, i.e. if time left is 5:32, timeInSeconds=32
	static int timeInMinutes=6; // hold the minutes portion of the time, i.e if the time left is 5:32 timeInMinutes=5. Default time is 6 minutes
	static int explosives=0; // holds the number of TNT charges owned by the player
	static int snips=0;  // hold the number of snips owned by the player
	static int picks=0; // hold the number of lock picks owned by the player
	static boolean isWinner=false; // hold if the current safe has been solved
	static boolean carreer=true;  // boolean keeps a dead carer from playing by turning it false and saving it in load file
	static StringBuilder[] guessArray= new StringBuilder[10];  // holds all the guesses in a single game
	static StringBuilder currentGuess= new StringBuilder(); // hold the parts of a current guess, before it is added to the guessArray
	static StringBuilder combo= new StringBuilder();
	
	GUI GUI = new GUI();
	Interface Interface= new Interface();

	/*
	public  TeraCracker() 
	{
			
				
		
		// opening methods
		welcomeText();
		JStore.setVisible(true);
		mainWindow.setVisible(true); // turn the mainWindow visible
		//hideButtons();  // Consider removing this method 
		JEnter.setVisible(true);
		JInfo.setVisible(true);
	
		
	} // ends constructor
	*/
	public static void main(String[] args)
	{
		
		
	} // ends main Method
	

//=========================================================================================================================================
//=========================================================================================================================================
// METHODS						METHODS					METHODS			METHODS
//=========================================================================================================================================
//=========================================================================================================================================
	
	
/*



	// #5
	// makeCombo
	// returns a combination based on the difficulty
		public void makeCombo()
		{	
		
			/* each time a safe is played the appropriate number of digits will be appended into a StringBuilder called combo
			 * for each spot, use the randomNumber method to return a digit, the no-arg method will return 0-9, the integer arg(use any number)
			 * will return 1-9 but no zeros, this is required for the first digit in the combination. and use a character to return a direction
			 

           combo= new StringBuilder();  // clears the old combination, for a new StringBuilder
			
		
           for (int i=0; i<comboSize; i++) // the first digit of any safe will not be a zero
			{
				if(i==0)
				{
					if (difficulty==7) // this if statement runs if the Chinese Lock is selected, the safe uses all directions
					{
						combo.append(randomNumber('z'));
					}
					else
					{
					combo.append(randomNumber(1));
					}
				}
				else if (comboSize-i <= directions)
				{
					combo.append(randomNumber('z'));
				}
				else
				{
					combo.append(randomNumber());
				}
			}
		
	
				 
		
		
		} // ends makeCombo
	// #6
    // randomNumber, no-arg
	//  creates a random digit from 0-9
		public static String randomNumber()
		{
			while(true)
			{
				int a=(int)(Math.random()*10);
			
				if (a>=0 && a<=9)
				{
					Integer b=new Integer(a);
					return b.toString();		
				}
				else if (a<0 || a>9)
					continue;
				
			
			} // ends loop
			
			
			
		} // ends randomNumber(no arg)

		
		
	// #7
	// randomNumber(integer argument)
	// creates a random digit from 1-9, zero will not be an option
	// integer argument is completely irrelevant to the method and only invokes a method that will not return a zero
			public static String randomNumber(int z)
			{
				while(true)
				{
				int a=(int)(Math.random()*10);
				
				if (a>0 && a<10)
				{
					Integer b= new Integer(a);
					return b.toString();
					
				}
				else if (a<0 || a>9)
				{
					continue;
				}
				
				} // ends loop
			
			} // ends randomNumber(int)
			
	
			
	// #8
	// randomNumber(char argument)
	// creates a number 0-9 or a character U,D,L,R,I
			public static String randomNumber(char z)
			{
				while (true)
				{
					int a=(int)(Math.random()*1011);
					
					if (a>=0 && a<250) // return U
					{
						return new String("U");
					}
					else if (a<500) //return D
					{
						return new String("D");
					}
					else if (a<750) // return L
					{
						return new String("L");
					}
					else if (a<=1000) // return R
					{
						return new String("R");
					}
					else
						continue;
				} // ends while loop
			} // end randomNumber(char)
			
	// #12
	// wantedLevel
	// Determines the wanted level of the player
			public void wantedLevel()
			{  
				// determine the wanted level
				// if the totalBreakIns exceed a certain number, increase wanted level, increment this requirement by 2 for each wantedLevel
				// else if the product of current wantedLevel and the difficulty exceeds a certain value, increase wanted level
				// increment this requirement by n, where n increasing every 3 levels. So n is 2 for the first 3 if statements, then 3 for the next 3.
				
				int holdwantedLevel=wantedLevel; // acts as a holder for the current wantedLevel,
				
				if (holdwantedLevel<=2 && (holdwantedLevel*difficulty>3 || totalBreakIns>2) )
				{
				
					wantedLevel=2;
				}
				if (holdwantedLevel<=3 && (holdwantedLevel*difficulty>5 || totalBreakIns>4) )
				{
					
					wantedLevel=3;
				}
			    if (holdwantedLevel<=4 && ( holdwantedLevel*difficulty>7 || totalBreakIns>6) )
			    {
			    	
					wantedLevel=4;
			    }
			    if (holdwantedLevel<=5 && ( holdwantedLevel*difficulty>10 || totalBreakIns>8) )
			    {
					wantedLevel=5;
			    }
			    
			    if (holdwantedLevel<=6 && ( holdwantedLevel*difficulty>13 || totalBreakIns>10) )
			    {
					wantedLevel=6;
			    }
			    
			    if (holdwantedLevel<=7 && ( holdwantedLevel*difficulty>16 || totalBreakIns>12) )
			    {
					wantedLevel=7;
			    }
			    
			    if (holdwantedLevel<=8 && ( holdwantedLevel*difficulty>20 || totalBreakIns>14) )
			    {
					wantedLevel=8;
			    }
			    
			    if (holdwantedLevel<=9 && ( holdwantedLevel*difficulty>24 || totalBreakIns>16) )
			    {
					wantedLevel=9;
			    }
			    
			    if (holdwantedLevel<=10 && ( holdwantedLevel*difficulty>28 || totalBreakIns>18) )
			    {
					wantedLevel=10;
			    }
			    
			    if (holdwantedLevel<=11 && ( holdwantedLevel*difficulty>33 || totalBreakIns>20) )
			    {
					wantedLevel=11;
			    } 
			    if (holdwantedLevel<=12 && ( holdwantedLevel*difficulty>38 || totalBreakIns>22) )
			    {
					wantedLevel=12;
			    }
			    if (holdwantedLevel<=13 && ( holdwantedLevel*difficulty>43 || totalBreakIns>24) )
			    {
					wantedLevel=13;
			    }
			    if (holdwantedLevel<=14 && ( holdwantedLevel*difficulty>49 || totalBreakIns>26) )
			    {
					wantedLevel=14;
			    }
			    
			    if (holdwantedLevel<=15 && ( holdwantedLevel*difficulty>55 || totalBreakIns>28) )
			    {
					wantedLevel=15;
			    }
			    
			    if (holdwantedLevel<=16 && ( holdwantedLevel*difficulty>61 || totalBreakIns>30) )
			    {
					wantedLevel=16;
			    }
			    
			    if (holdwantedLevel<=17 && ( holdwantedLevel*difficulty>67 || totalBreakIns>32) )
			    {
					wantedLevel=17;
			    }
			    
			    if (holdwantedLevel<=18 && ( holdwantedLevel*difficulty>84 || totalBreakIns>34) )
			    {
					wantedLevel=18;
			    }
			    
			    if (holdwantedLevel<=19 && ( holdwantedLevel*difficulty>91 || totalBreakIns>36) )
			    {
					wantedLevel=19;
			    }
			    
			    if (holdwantedLevel<=20 && ( holdwantedLevel*difficulty>98 || totalBreakIns>38) )
			    {
					wantedLevel=20;
			    }
			   
			}

	//#14
	// posistionsCorrect
	//
			public void getPosistions()
			{
				/* method finds the number of positions correct in the guess.
				 *  for example if the combo is 789 and the guess is 987, there is only 1 position (the 8) 
				 *  that is correct.
				 *  
				 *  the method also finds the number of digits correct, in the previous example
				 *  there would be 3 digits correct, although the guess would not be a winner since there is only
				 *  1 Position correct
				 *  
				 *  finally it checks if the combination is correct, if it is, isWinner will be set to true
				 *
				
				// reset the number of digits and positions to zero
				posistionsCorrect=0;
				digitsCorrect=0;
				char guessChar=(' ');
				char comboChar=(' ');
				int[] includeArray= new int[120]; // index for the array will be a digit in the guess, so if the guess is 222, index 2 will equal 3
													// the large index range account for having string inputs
				
				
				// check the number of posistion correct
				for (int i=0; i<comboSize; i++) 
				{
					 guessChar=guessArray[turnCount].charAt(i);
					 comboChar=combo.charAt(i);
					 
					// check each character in the guess against the character in the combo at the same position
					if( guessChar==comboChar)
					{
						
						posistionsCorrect++; // if the condition matches, increment the number of posistions correct
						
					}
					else;
					
				} // ends for loop
				
				
				// check the number of digits correct
			
				for(int i=0; i<comboSize; i++)  // loop fills arrays with proper values
				{
				
					includeArray[(int)guessArray[turnCount].charAt(i)]++;
					
				} 
				
				for(int i=0; i<comboSize;i++) // i loop will call up values in the combo
				{ 
					
					for(int j=0; j<comboSize;j++) // j loop will call up values in the guess
					{
						// excludeArray holds how many times a number appears in the guess
						// if a number hits a match with the combo, the array is decremented so
						// that it can only hit as many times as it exists in the guess
						
						if (guessArray[turnCount].charAt(j)==combo.charAt(i) && includeArray[guessArray[turnCount].charAt(j)] >0 )
						{						
							digitsCorrect++;
							
							includeArray[guessArray[turnCount].charAt(j)]--;
							break;
						}
							
					}  // ends j loop
				} // ends i loop
				
				if (posistionsCorrect==comboSize)
				{
					isWinner=true;
				}
				
			} // ends posistionsCorrect method
	
	// #16
	// proShop
	//
			public void proShop()
			{
				
				// remove listeners that will be called in this phase to avoid repeated registering
				J0.removeActionListener(cheatListener);
				J1.removeActionListener(cheatListener);
				J2.removeActionListener(cheatListener);
				
				// remove listeners for the previous stage of the game
				J0.removeActionListener(numbers1);
				J1.removeActionListener(numbers1);
				J2.removeActionListener(numbers1);
				J3.removeActionListener(numbers1);
				J4.removeActionListener(numbers1);
				J5.removeActionListener(numbers1);
				J6.removeActionListener(numbers1);
				J7.removeActionListener(numbers1);
				J8.removeActionListener(numbers1);
				J9.removeActionListener(numbers1);
				JUp.removeActionListener(numbers1);
				JDown.removeActionListener(numbers1);
				JLeft.removeActionListener(numbers1);
				JRight.removeActionListener(numbers1);
				JEnter.removeActionListener(numbers1);
				JEnter.removeActionListener(exitWelcome1);
				
				// removes the ability of the tool buttons
				JTNT.removeActionListener(applyCheat);
				JSnips.removeActionListener(applyCheat);
				JPicks.removeActionListener(applyCheat);
				
				
				// register listeners with buttons
				J0.addActionListener(cheatListener);
				J1.addActionListener(cheatListener);
				J2.addActionListener(cheatListener);
				JEnter.addActionListener(exitGame1);
				
				// set text for ProShop
				J0.setText("TNT");
				J1.setText("Picks");
				J2.setText("Snips");
				J3.setText("");
				J4.setText("");
				J5.setText("");
				J6.setText("");
				J7.setText("");
				J8.setText("");
				J9.setText("");
				JUp.setText("");
				JDown.setText("");
				JLeft.setText("");
				JRight.setText("");
				JEnter.setText("Exit");
				
				
				if (loot<3000)  // text shown if the player doesn't have enough money
				{
					
					topText.setText("		Loot:  $" + loot + "     Wanted Level: " + wantedLevel+ "      Break-Ins: " + totalBreakIns
							+ "\n"
							+ "\n"
							+ "        We Aint Got Anything For You Right Now!"
							+ "\n");
				}
				else 	// text shown if the player has enough money
				{
					topText.setText("		Loot:  $" + loot + "     Wanted Level: " + wantedLevel+ "      Break-Ins: " + totalBreakIns
							+ "\n"
							+ "\n"
							+ "            		Psst, Welcome To The Pro-Shop"   
							+ "\n"
							+ "              		     Here's What We Got"
							+ "\n"
							+ "\n"
							+ "$4,500 "
							+ "TNT- Breaks A Safe For You, But May Alert The Cops (Tread Lightly)"
							+ "\n"
							+ "$3,500 "
							+ "Lock Pick- Removes A Digit From A Combo"
							+ "\n"
							+ "$3,000 "
							+ "Snips- Delays The Cops And Gives You An Extra Move ");
				}
				
				
				// check if there are any quantities of tools and displays the number is they do
				if (explosives>0)  
				{
					JTNT.setText("TNT (" + explosives + "x)");
					JTNT.setForeground(Color.GRAY);
				}
				if (picks>0)
				{
					JPicks.setText("Picks (" + picks + "x)");
					JPicks.setForeground(Color.GRAY);
				}
				if (snips>0)
				{
					JSnips.setText("Snips (" + snips + "x)");
					JSnips.setForeground(Color.GRAY);
				}
				
				
			}
			
	// #17
	// printUpdate
	//
			private void printUpdate()
			{
			
				// method is responsible for updating the board during the guessing phase
				// it is called by the numberListener and hits under certain conditions
				
					
				// checks if the safe has been cracked or not
				if (isWinner)
				{
					winningProtocol();
					turnCount=0;
					//currentGuess may need to be cleared here
				}
				else if(turnCount==guessLimit)
				{
					losingProtocol();
					turnCount=0;
				}
				else
				{
					// if the game is neither a winner nor a loser, then it continues to print the necessary information for gamePlay
						StringBuilder tempBuilder= new StringBuilder();
					
						for (int i=0; i<turnCount; i++)  // for loop strings together all the previous guesses for display
						{
					
							if (i==turnCount-1)
							{
								tempBuilder.append("  | " + guessArray[i].toString() + " | ");
							}
							else
							{
								tempBuilder.append("   " + guessArray[i].toString());
							}
						
						} // ends for loop
					
	
					// display top and bottom text area
				  // uncomment the combo portion of the next line to make the combo visible during play.
						topText.setText("		Loot:  $" + loot + "     Wanted Level: " + wantedLevel+ "      Break-Ins: " + totalBreakIns  + "   combo: " + combo 
								+ "\n"
								+ " Difficulty: " + difficulty 
								+ "\n"
								+ " Digits: " + comboSize + " Directions: " +directions
								+ "\n"
								+ " Guesses:  " + (guessLimit-turnCount) + "    Time: " + timeInMinutes + ":"+timeInSeconds
								+ "\n"
								+ tempBuilder + "\n"
								+ "\n"
								+ "             " + currentGuess 
								+ "\n"
								+ "      Digits Correct: " + digitsCorrect +  "    Posistions Correct: " + posistionsCorrect);
						
						// update the tool buttons
						if(explosives>0)
						{
							JTNT.setText("TNT ("+ explosives + "x)");
							JTNT.setForeground(Color.BLACK);
							JTNT.addActionListener(applyCheat);
						}
						else
						{
							JTNT.setText("");
							JTNT.removeActionListener(applyCheat);
						}
						
						if (snips>0)
						{
							JSnips.setText("Snips (" + snips + "x)");
							JSnips.setForeground(Color.BLACK);
							JSnips.addActionListener(applyCheat);
						}
						else
						{
							JSnips.setText("");
							JSnips.removeActionListener(applyCheat);
						}
						
						if (picks>0)
						{
							JPicks.setText("Lock Pick (" + picks + "x)");
							JPicks.setForeground(Color.BLACK);
							JPicks.addActionListener(applyCheat);
						}
						else
						{
							JPicks.setText("");
							JPicks.removeActionListener(applyCheat);
						}
				
				
			
				
				}// ends else
				
				mainWindow.requestFocus();
				
				
			
			} // ends printUpdate
	
			
			
	// #19
	// setGameListeners
	// sets the listeners for the guessing phase of the game
			private void setGameListener()
			{
				
				// remove the difficulty phase listeners
				J0.removeActionListener(numbers1);
				J1.removeActionListener(numbers1);
				J2.removeActionListener(numbers1);
				J3.removeActionListener(numbers1);
				J4.removeActionListener(numbers1);
				J5.removeActionListener(numbers1);
				J6.removeActionListener(numbers1);
				J7.removeActionListener(numbers1);
				J8.removeActionListener(numbers1);
				J9.removeActionListener(numbers1);
				JUp.removeActionListener(numbers1);
				JDown.removeActionListener(numbers1);
				JLeft.removeActionListener(numbers1);
				JRight.removeActionListener(numbers1);
				JEnter.removeActionListener(numbers1);
				JEnter.removeActionListener(exitWelcome1);
			
				J0.removeActionListener(cheatListener);
				J1.removeActionListener(cheatListener);
				J2.removeActionListener(cheatListener);
				
				
				// register listeners with buttons
				J0.addActionListener(numbers2);
				J1.addActionListener(numbers2);
				J2.addActionListener(numbers2);
				J3.addActionListener(numbers2);
				J4.addActionListener(numbers2);
				J5.addActionListener(numbers2);
				J6.addActionListener(numbers2);
				J7.addActionListener(numbers2);
				J8.addActionListener(numbers2);
				J9.addActionListener(numbers2);
				JUp.addActionListener(numbers2);
				JDown.addActionListener(numbers2);
				JLeft.addActionListener(numbers2);
				JRight.addActionListener(numbers2);
				JEnter.addActionListener(numbers2);
				JBackSpace.addActionListener(backSpaceListener);
				JClear.addActionListener(clearListener);
				
				mainWindow.requestFocus();
					
				//set text to guess mode
				J0.setText("0");
				J1.setText("1");
				J2.setText("2");
				J3.setText("3");
				J4.setText("4");
				J5.setText("5");
				J6.setText("6");
				J7.setText("7");
				J8.setText("8");
				J9.setText("9");
				JUp.setText("Up");
				JDown.setText("Down");
				JLeft.setText("Left");
				JRight.setText("Right");
				JClear.setText("Clear");
				JBackSpace.setText("Back Space");
				JEnter.setText("Enter");
				
				
				JBackSpace.setForeground(Color.BLACK);
				JClear.setForeground(Color.BLACK);
				
				// if the player has more than 3 break-ins show the proshop
				// proshop will not be accessible during the guess phase
				if(totalBreakIns>=3)
				{
					JStore.setText("Pro Shop");
					JStore.setForeground(Color.LIGHT_GRAY);
					//JStore.setVisible(true);
				}
				else
				{
					//JStore.setVisible(false);
				}
				
				// show tools if they are available, 
				if(explosives>0)
				{
					JTNT.setText("TNT (" +explosives+"x)");
					JTNT.addActionListener(applyCheat);
				}
				else 
				{
					JTNT.setText("-");
					JTNT.setForeground(Color.LIGHT_GRAY);
					JTNT.removeActionListener(applyCheat);
				}
				
				if (snips>0)
				{
					JSnips.setText("Snips ("+ snips +"x)" );
					JSnips.addActionListener(applyCheat);
				}
				else
				{
					JSnips.setText("-");
					JSnips.setForeground(Color.LIGHT_GRAY);
					JSnips.removeActionListener(applyCheat);
				}
				
				if (picks>0)
				{
					JPicks.setText("Picks (" + picks + "x)");
					JPicks.addActionListener(applyCheat);
				}
				else
				{
					JPicks.setText("-");
					JPicks.setForeground(Color.LIGHT_GRAY);
					JPicks.removeActionListener(applyCheat);
				}
					
				//topText.setText("		Loot:  " + loot + "     Wanted Level: " + wantedLevel+ "      Break-Ins: " + totalBreakIns);
				//bottomText.setText("");
				timer.start();
				printUpdate();
				
			}// ends setGameListener
			
	//
	// losingProtocol
	//
			public void losingProtocol()
			{
				timer.stop();
				
				// getBail();
				bail=500; // holder value, 500 is the default/ minimum bail out value
				
				bail*=wantedLevel*difficulty; // sets the amount to bail out
				loot-=bail; // subtracts the bail out from the 
				
				topText.setBackground(Color.RED);
				topText.setText("		Loot:  $" + loot + "     Wanted Level: " + wantedLevel+ "      Break-Ins: " + totalBreakIns
						+ "\n"
						+ "\n"
						+ "    	    Busted!"
						+ "\n"
						+ "         You Failed To Crack The Safe"
						+ "\n"
						+ "         You Bailed Out $" + bail
						+ "\n"
						+ "         Hit Enter To Case Out Your Next Target");
				
				
				
				// sets listeners for the transition from the end of the game to the difficulty selection
				J0.removeActionListener(numbers2);
				J1.removeActionListener(numbers2);
				J2.removeActionListener(numbers2);
				J3.removeActionListener(numbers2);
				J4.removeActionListener(numbers2);
				J5.removeActionListener(numbers2);
				J6.removeActionListener(numbers2);
				J7.removeActionListener(numbers2);
				J8.removeActionListener(numbers2);
				J9.removeActionListener(numbers2);
				JUp.removeActionListener(numbers2);
				JDown.removeActionListener(numbers2);
				JLeft.removeActionListener(numbers2);
				JRight.removeActionListener(numbers2);
				JEnter.removeActionListener(numbers2);
				JBackSpace.removeActionListener(numbers2);
				JClear.removeActionListener(numbers2);
				J0.removeActionListener(cheatListener);
				J1.removeActionListener(cheatListener);
				J2.removeActionListener(cheatListener);
				JEnter.addActionListener(exitGame1);
				
				
				JBackSpace.setForeground(Color.LIGHT_GRAY);
				JClear.setForeground(Color.LIGHT_GRAY);
				
				// proshop may be turned on during this phase
				if(totalBreakIns>=3)
				{
					JStore.setText("Pro Shop");
					JStore.setForeground(Color.BLACK);
					JStore.setVisible(true);
					JStore.addActionListener(proShopListener);
				}
				else
				{
					JStore.setVisible(false);
				}
				
				// show tools if they are available, 
				if(explosives>0)
				{
					JTNT.setText("TNT (" +explosives+"x)");
					
				}
				else 
				{
					JTNT.setText("");
					
				}
				
				if (snips>0)
				{
					JSnips.setText("Snips ("+ snips +"x)" );
				}
				else
				{
					JSnips.setText("");
					
				}
				
				if (picks>0)
				{
					JPicks.setText("Picks (" + picks + "x)");
				}
				else
				{
					JPicks.setText("");
				}
				
				
				posistionsCorrect=0;
				digitsCorrect=0;
				
			}
			
	//
	// winningProtocol
	//
			public void winningProtocol()
			{
				timer.stop();
				
				payout=(int)(Math.random()*1000)*difficulty;
				loot+=payout;
				totalBreakIns++;
				wantedLevel();
				
				topText.setBackground(Color.GREEN);
				topText.setText("		Loot:  $" + loot + "     Wanted Level: " + wantedLevel+ "      Break-Ins: " + totalBreakIns
						+ "\n"
						+ "\n"
						+ "         Nice!  You Cracked The Safe"
						+ "\n"
						+ "         You \"Found\"  $"+ payout
						+ "\n"
						+ "         Hit Enter To Case Out Your Next Target");
				
				
				turnCount=0;
				
				// sets listeners for the transition from the end of the game to the difficulty selection
				J0.removeActionListener(numbers2);
				J1.removeActionListener(numbers2);
				J2.removeActionListener(numbers2);
				J3.removeActionListener(numbers2);
				J4.removeActionListener(numbers2);
				J5.removeActionListener(numbers2);
				J6.removeActionListener(numbers2);
				J7.removeActionListener(numbers2);
				J8.removeActionListener(numbers2);
				J9.removeActionListener(numbers2);
				JUp.removeActionListener(numbers2);
				JDown.removeActionListener(numbers2);
				JLeft.removeActionListener(numbers2);
				JRight.removeActionListener(numbers2);
				JEnter.removeActionListener(numbers2);
				JBackSpace.removeActionListener(numbers2);
				JClear.removeActionListener(numbers2);
				JEnter.addActionListener(exitGame1);
				
				// turn off tools
				JTNT.removeActionListener(applyCheat);
				JSnips.removeActionListener(applyCheat);
				JPicks.removeActionListener(applyCheat);
				J0.removeActionListener(cheatListener);
				J1.removeActionListener(cheatListener);
				J2.removeActionListener(cheatListener);
				
				JBackSpace.setForeground(Color.LIGHT_GRAY);
				JClear.setForeground(Color.LIGHT_GRAY);
				
				// turn off tools
				if(totalBreakIns>=3)
				{
					JStore.setText("Pro Shop");
					JStore.setForeground(Color.BLACK);
					JStore.setVisible(true);
					JStore.addActionListener(proShopListener);
				}
				else
				{
					JStore.setVisible(false);
				}
				
				// show tools if they are available, 
				if(explosives>0)
				{
					JTNT.setText("TNT (" +explosives+"x)");
				}
				else 
				{
					JTNT.setText("");
				}
				
				if (snips>0)
				{
					JSnips.setText("Snips ("+ snips +"x)" );
				}
				else
				{
					JSnips.setText("");
				}
				
				if (picks>0)
				{
					JPicks.setText("Picks (" + picks + "x)");
				}
				else
				{
					JPicks.setText("");
				}
				
				posistionsCorrect=0;
				digitsCorrect=0;
				
				
				
			} // ends winning protocol
			
	//
	// buyStatus
	// method prints an update for a the user when they try to buy something in the proshop
			public void buyStatus(boolean sucessful, String item)
			{
				if (!sucessful)
				{
					// informers the user they couldn't but their item
					topText.setText("		Loot:  $" + loot + "     Wanted Level: " + wantedLevel+ "      Break-Ins: " + totalBreakIns
							+ "\n"
							+ "		You Don't Have Enough Loot To Buy That!"
							+ "\n"
							+ "\n"
							+ "  		Here's What We Got"
							+ "\n"
							+ "\n"
							+ "$4,500 "
							+ "TNT- Breaks A Safe For You, But May Alert The Cops (Tread Lightly)"
							+ "\n"
							+ "$3,500 "
							+ "Lock Pick- Removes A Digit From A Combo"
							+ "\n"
							+ "$3,000 "
							+ "Snips- Delays The Cops And Gives You An Extra Move ");
				}
				else if (sucessful)
				{
					// informs the user of a sucessful purchase in the proshop
					
					topText.setText("		Loot:  $" + loot + "     Wanted Level: " + wantedLevel+ "      Break-Ins: " + totalBreakIns
							+ "\n"
							+ "\n"
							+ "		Nice! You Sucessfully Bought " + item
							+ "\n"
							+ "   		Here's What We Got"
							+ "\n"
							+ "\n"
							+ "$4,500 "
							+ "TNT- Breaks A Safe For You, But May Alert The Cops (Tread Lightly)"
							+ "\n"
							+ "$3,500 "
							+ "Lock Pick- Removes A Digit From A Combo"
							+ "\n"
							+ "$3,000 "
							+ "Snips- Delays The Cops And Gives You An Extra Move ");
					
				} // ends else if
				
				// show tools as they are added
				if (explosives>0)
				{
					JTNT.setText("TNT (" + explosives + "x)");
					JTNT.setForeground(Color.GRAY);
				}
				if (picks>0)
				{
					JPicks.setText("Picks (" + picks + "x)");
					JPicks.setForeground(Color.GRAY);
				}
				if (snips>0)
				{
					JSnips.setText("Snips (" + snips + "x)");
					JSnips.setForeground(Color.GRAY);
				}
			} // ends buy status
		
*/
	
} // ends class

