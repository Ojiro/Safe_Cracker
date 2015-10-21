
import javax.swing.*;

import java.awt.event.*;
import java.util.Scanner;
import java.awt.Color;

public class GigaCracker extends JFrame //implements KeyListener
{

	/*
	 * GigaCracker is the graphical version of MegaCracker
	 * 
	 * Player will try to break into  safes by guessing the combination which contains digits 0-9 and directions u,d,l, and r.
	 * Player wins loot by cracking safes and loses loot by failing to crack them within the alloted number of moves or time.
	 */
	
	/* To Do List
	 * 
	 * 
	 * Clear up display of loot and wanted level
	 * add comments
	 *  make sure proshop listener is off during guessing
	 *  If too few keys are entered after a game has already been won, problems occur. Consider the isWinner variable
	 *  Consider what happens when the hideTools and hideButtons methods are changed
	
	 */
	
	//data field
	
	JFrame mainWindow= new JFrame("GigaCracker"); 
	JFrame helpWindow= new JFrame("How To");
	JPanel p0 = new JPanel();
	// create JButtons that act as input
	
	// These buttons act as basic inputs, numbers and directions for the game
	JButton[] JBDigits=new JButton[10];
	JButton[] JBDirections=new JButton[7];
	JButton[] JBTools=new JButton[4];
	JButton[] JBHelpers=new JButton[5];
	
	
	
	JButton J0 = new JButton("");
	JButton J1 = new JButton("");
	JButton J2 = new JButton("");
	JButton J3 = new JButton("");
	JButton J4 = new JButton("");
	JButton J5 = new JButton("");
	JButton J6 = new JButton("");
	JButton J7 = new JButton("");
	JButton J8 = new JButton("");
	JButton J9 = new JButton("");
	JButton JUp = new JButton("");
	JButton JDown = new JButton("");
	JButton JLeft = new JButton("");
	JButton JRight = new JButton("");
	JButton JEnter = new JButton("Enter"); // allow the player to advance through the game and enter guesses
	JButton JClear= new JButton("");
	JButton JBackSpace= new JButton("");
	JButton JInfo= new JButton("Info");
	
	// Extra buttons for cheats
	JButton JStore= new JButton("Pro Shop"); 
	JButton JTNT= new JButton("-");
	JButton JSnips= new JButton("-");
	JButton JPicks= new JButton("-");
	
	// create JButtons for help, referred to as helper buttons throughout the program
	JButton Help= new JButton("How To"); // opens a box on how to play
	JButton Load= new JButton("Load");
	JButton Save= new JButton("Save");
	JTextArea topText= new JTextArea();
	//JTextArea bottomText= new JTextArea();
	JLabel name= new JLabel("Cracker-Jacker 5000 DLX");
	
	int loot=3000; // Loot is the currency of the game. Player gains and looses loot based on winning/losing safes. default is 3000 
	int turnCount=0;  // this is the number of guesses made in the game, it counts upward from zero
	int totalBreakIns=0; // Counts the number of safes cracked in a players career default is 0
	int wantedLevel=1; // Wanted level dictates the cost of bail and increments based on how many safes the player has cracked
	int comboSize=3; // determines how many digits in a combo, default is 3
	int directions=0; // details how many directions can be found in a combination
	int bail=0; // how much a player pays for failing to crack a safe, value will be based on wantedLevel and the difficulty of a safe
	int payout=0; // how much a player gets for cracking a safe, the range of values is determined by the difficulty of a safe
	int difficulty=1; // Correlates to how tough a safe is to crack, and settings will be changed based on this value
	int guessLimit=10;  // in most difficulties, the number of guesses will be 10. However this may change for a few safes
	int posistionsCorrect=0; // during play, this variable tells how many positions are correct (note that positions and digits are 2 distinct concepts)
	int digitsCorrect=0;  // during play, tells how many digits are correct (but doesn't tell how many are in the correct spots)
	int timeInSeconds=0; // holds the seconds portion of the time, i.e. if time left is 5:32, timeInSeconds=32
	int timeInMinutes=6; // hold the minutes portion of the time, i.e if the time left is 5:32 timeInMinutes=5. Default time is 6 minutes
	int explosives=0; // holds the number of TNT charges owned by the player
	int snips=0;  // hold the number of snips owned by the player
	int picks=0; // hold the number of lock picks owned by the player
	boolean isWinner=false; // hold if the current safe has been solved
	boolean carreer=true;  // boolean keeps a dead carer from playing by turning it false and saving it in load file
	StringBuilder[] guessArray= new StringBuilder[10];  // holds all the guesses in a single game
	StringBuilder currentGuess= new StringBuilder(); // hold the parts of a current guess, before it is added to the guessArray
	StringBuilder combo= new StringBuilder();
	
	// listeners are instantiated here because they will be repeatedly turned on an off
	numberListener1 numbers1= new numberListener1();
	numberListener2 numbers2 = new numberListener2();
	exitWelcome exitWelcome1= new exitWelcome();
	exitGame exitGame1= new exitGame();
	helpListener help= new helpListener();
	clearGuess clearListener= new clearGuess();
	backSpace backSpaceListener= new backSpace();
	proShopListener proShopListener= new proShopListener();
	cheatListener cheatListener= new cheatListener();
	keyListener key1= new keyListener();
	applyCheat applyCheat= new applyCheat();
	infoPress infoPress= new infoPress();
	
	private Timer timer= new Timer(1000, new timerListener());  // time event listener
	
	public GigaCracker() 
	{
		State.welcomeState(JBDigits,JBDirections,JBTools,JBHelpers);
		
		mainWindow.setSize(775,500);
		p0.setSize(750,500);
		p0.setLocation(0,0);
		mainWindow.setLayout(null);
		p0.setLayout(null);
		
		topText.setSize(650,150);
		topText.setLocation(25,25);
		topText.setEditable(false);
		
		name.setSize(250,25);
		name.setLocation(250,0);
		
		// set size and Location of buttons and object
		J0.setSize(100,50); 
		J1.setSize(100,50);
		J2.setSize(100,50);
		J3.setSize(100,50);
		J4.setSize(100,50);
		J5.setSize(100,50);
		J6.setSize(100,50);
		J7.setSize(100,50);
		J8.setSize(100,50);
		J9.setSize(100,50);
		JUp.setSize(100,50);
		JDown.setSize(100,50);
		JLeft.setSize(100,50);
		JRight.setSize(100,50);
		JEnter.setSize(100,100);
		JClear.setSize(200,50);
		JBackSpace.setSize(200,50);
		Help.setSize(100,50);
		Load.setSize(100,50);
		Save.setSize(100,50);
		JStore.setSize(100,50);
		JTNT.setSize(100,50);
		JSnips.setSize(100,50);
		JPicks.setSize(100,50);
		JInfo.setSize(100,50);
		
		J0.setLocation(25,200);
		J1.setLocation(125,200);
		J2.setLocation(225,200);
		J3.setLocation(325,200);
		J4.setLocation(425,200);
		J5.setLocation(25,250);
		J6.setLocation(125,250);
		J7.setLocation(225,250);
		J8.setLocation(325,250);
		J9.setLocation(425,250);
		JUp.setLocation(25,300);
		JDown.setLocation(125,300);
		JLeft.setLocation(225,300);
		JRight.setLocation(325,300);
		JEnter.setLocation(425,300);
		JClear.setLocation(225,350);
		JBackSpace.setLocation(25,350);
		Help.setLocation(550,200);
		JStore.setLocation(650,200);
		Load.setLocation(550,250);
		Save.setLocation(650,250);
		JTNT.setLocation(550,300);
		JPicks.setLocation(550,350);
		JSnips.setLocation(550,400);
		JInfo.setLocation(650,400);
		JStore.setForeground(Color.LIGHT_GRAY);
		JTNT.setForeground(Color.LIGHT_GRAY);
		JPicks.setForeground(Color.LIGHT_GRAY);
		JSnips.setForeground(Color.LIGHT_GRAY);
		
		
		//register listeners
		JEnter.addActionListener(exitWelcome1);
		Help.addActionListener(help); // note the button "Help" is capitalized, while the listener is lowercase
		JInfo.addActionListener(infoPress);
		mainWindow.setFocusable(true); // sets the main window to focusable
		mainWindow.requestFocus(); // requests focus for the main window
		mainWindow.setFocusTraversalKeysEnabled(false); // keeps focus from shifting away
		mainWindow.addKeyListener(key1); // registers the keyListener for the game
		
		// add buttons to the panel
		p0.add(J0);
		p0.add(J1);
		p0.add(J2);
		p0.add(J3);
		p0.add(J4);
		p0.add(J5);
		p0.add(J6);
		p0.add(J7);
		p0.add(J8);
		p0.add(J9);
		p0.add(JUp);
		p0.add(JDown);
		p0.add(JLeft);
		p0.add(JRight);
		p0.add(JEnter);
		p0.add(Help);
		p0.add(Load);
		p0.add(Save);
		p0.add(JStore);
		p0.add(topText);
		p0.add(JClear);
		p0.add(JBackSpace);
		p0.add(JTNT);
		p0.add(JSnips);
		p0.add(JPicks);
		mainWindow.add(p0);
		p0.add(name);
		p0.add(JInfo);
		
		JUp.setVisible(true);
		JDown.setVisible(true);
		JLeft.setVisible(true);
		JRight.setVisible(true);
		JTNT.setVisible(true);
		JPicks.setVisible(true);
		JSnips.setVisible(true);
			
		
		// opening methods
		welcomeText();
		JStore.setVisible(true);
		mainWindow.setVisible(true); // turn the mainWindow visible
		//hideButtons();  // Consider removing this method 
		JEnter.setVisible(true);
		JInfo.setVisible(true);
	
		
	} // ends constructor
	
	public static void main(String[] args)
	{
		GigaCracker frame= new GigaCracker();
		
	} // ends main Method
	
//========================================================================================================================================
//========================================================================================================================================
// LISTENERS			LISTENERS					LISTENERS				LISTENERS
//========================================================================================================================================
//========================================================================================================================================
	
	public class numberListener2 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			/*
			 * This is the main listener in the game and should ideally hold most of the logic
			 * it covers all the numbered buttons and the directions. It does not cover the enter button or the 
			 * helper buttons.
			 * 
			 * When the player enters a number or direction, this listener adds the information to the guess and applies the guess when the proper conditions are met
			 */
			JButton temp=(JButton)e.getSource(); // acquires the input of the entered digit or direction
		
		     if(currentGuess.length()<comboSize && turnCount < guessLimit)
			{
				// condition does not allow the string to be bigger then the combination
		    	 
		    	 	// switch updates the current guess string
				   switch(temp.getText())
				   {
				    case "0": currentGuess.append(temp.getText()); break; 
				    case "1": currentGuess.append(temp.getText()); break; 
				    case "2": currentGuess.append(temp.getText()); break; 
				    case "3": currentGuess.append(temp.getText()); break; 
				    case "4": currentGuess.append(temp.getText()); break; 
				    case "5": currentGuess.append(temp.getText()); break; 
				    case "6": currentGuess.append(temp.getText()); break; 
				    case "7": currentGuess.append(temp.getText()); break; 
				    case "8": currentGuess.append(temp.getText()); break; 
				    case "9": currentGuess.append(temp.getText()); break; 
				    case "Up": currentGuess.append("U"); break; 
				    case "Down": currentGuess.append("D"); break; 
				    case "Left": currentGuess.append("L"); break; 
				    case "Right": currentGuess.append("R"); break; 
				    default: printUpdate(); return;
				 	}   //ends switch
				
				
				 printUpdate();
				
			} // ends if
			else if(currentGuess.length()==comboSize && temp.getText().equals("Enter") && turnCount<guessLimit)
			{
				// process a completed guess
				//guessArray[turnCount].delete(0,comboSize);
				guessArray[turnCount]=currentGuess;
				
				//check the number of positions and digits correct
				getPosistions();
				
				currentGuess=new StringBuilder(); // clears out the current guess
				turnCount++;
				printUpdate();
				
				
			}
			else if(currentGuess.length()==comboSize && !temp.getText().equals("Enter"))
			{
				// suggest user hit enter
			}
			else;
			
			
			
		} // ends actionPerformed
		
	} // ends numberListener2
	
	class timerListener implements ActionListener
	{
		// class acts as a listener for a timer that tells the user how long they've been playing
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			timeInSeconds--; // everytime the listener hits, count down 1 seconds
			
			if (timeInSeconds==0 && timeInMinutes==0)
			{
				// if the timer reaches 0, ends the game
				losingProtocol();
			
			}
			else if (timeInSeconds<=0)
			{
				// if the seconds reach zero, decrements the minutes and reset seconds to 59
				timeInSeconds=59;
				timeInMinutes--;
				printUpdate();
			}
			else
			{
				printUpdate();
			}
			
			
			
		} // ends actionPerformed
	} // ends timerListener
	
	public class numberListener1 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			/*
			 * This listener is used for the difficulty selection phase of the game
			 * listener acts for each number and direction
			 * 
			 * when the player clicks on the desired difficulty, this method runs and
			 * sets the difficulty, comboSize and guessLimit variable
			 * 
			 * after those variables are set, the setGameListener method will be called
			 */
			JButton temp=(JButton)e.getSource();
			
			//conditions check the button pushed and sets the appropriate setting
			if(temp.getText().equals("Easy"))
			{   // sets game to easy
				// 3 digits with no direction
				difficulty=1;
				comboSize=3;
				guessLimit=10;
				directions=0;
				timeInSeconds=0;
				timeInMinutes=6;
				
			}
			else if (temp.getText().equals("PiggyBank"))
			{	// sets game to PiggyBank level
				// 4 digits with 1 directions
				difficulty=2;
				comboSize=4;
				guessLimit=10;
				directions=1;
				timeInSeconds=0;
				timeInMinutes=6;
				
			}
			else if (temp.getText().equals("KittyBank"))
			{   // sets game to KittyBank Level
			    // 4 digits with 0 directions
				difficulty=3;
				comboSize=4;
				guessLimit=10;
				directions=0;
				timeInSeconds=0;
				timeInMinutes=6;
			}
			else if (temp.getText().equals("MotelSafe"))
			{
				// 5 Digits with 1 directions
				difficulty=4;
				comboSize=5;
				guessLimit=10;
				directions=1;
				timeInSeconds=0;
				timeInMinutes=6;
				
			}
			else if (temp.getText().equals("HotelSafe"))
			{
				// 5 Digits with 0 direction
				difficulty=5;
				comboSize=5;
				guessLimit=10;
				directions=0;
				timeInSeconds=0;
				timeInMinutes=6;
			}
			else if(temp.getText().equals("Hard"))
			{
				//6 Digits with 2 directions
				difficulty=6;
				comboSize=6;
				guessLimit=9;
				directions=2;
				timeInSeconds=0;
				timeInMinutes=5;
			}
			else if(temp.getText().equals("Chinese"))
			{
				//6 directions
				difficulty=7;
				comboSize=6;
				guessLimit=8; // 8 is significant to eastern culture
				directions=6;
				timeInSeconds=0;
				timeInMinutes=5;
			}
			else if(temp.getText().equals("BankHeist"))
			{
				//6 Digits with 0 directions
				difficulty=8;
				comboSize=6;
				guessLimit=9;
				directions=0;
				timeInSeconds=0;
				timeInMinutes=5;
			}
			else if(temp.getText().equals("JewelHeist"))
			{
				//7 Digits with 3 directions
				difficulty=9;
				comboSize=7;
				guessLimit=9;
				directions=3;
				timeInSeconds=0;
				timeInMinutes=5;
			}
			else if(temp.getText().equals("Museum"))
			{
				//7 Digits with 2 directions
				difficulty=10;
				comboSize=7;
				guessLimit=9;
				directions=2;
				timeInSeconds=0;
				timeInMinutes=5;
			}
			else if(temp.getText().equals("Extreme"))
			{
				//8 Digits with 3 directions
				difficulty=11;
				comboSize=8;
				guessLimit=9;
				directions=3;
				timeInSeconds=0;
				timeInMinutes=5;
			}
			else if(temp.getText().equals("FedHeist"))
			{
				//8 Digits with 2 directions
				difficulty=12;
				comboSize=8;
				guessLimit=8;
				directions=2;
				timeInSeconds=0;
				timeInMinutes=5;
			}
			else if(temp.getText().equals("Oceans666"))
			{
				//8 Digits with 1 directions
				difficulty=13;
				comboSize=8;
				guessLimit=8;
				directions=1;
				timeInSeconds=0;
				timeInMinutes=5;
			}
			else if(temp.getText().equals("KingPin"))
			{
				//10 Digits with 0 directions
				difficulty=100;
				comboSize=10;
				guessLimit=7;
				directions=0;
				timeInSeconds=0;
				timeInMinutes=5;
			}
			else
				return;
			
			makeCombo();
			
			setGameListener(); // sets the buttons to game mode
			
			
				
			
		} //ends actionPerformed
		
	} // ends numberListener1
	
	
	
	public class exitWelcome implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			/*
			 *  This listener is responsible for handling the difficulty 
			 *  selection phase of the game
			 */
			
			// exits the welcome screen and implements setDifficultyListener
			requestDifficulty(); // sets the text to request difficulty
			setDifficultyListener(); // method sets the needed button text and listeners
			 
		}
	}
	
	
	public class exitGame implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// Transitions from the end of a game to the select difficulty screen
			isWinner=false;
		
			requestDifficulty();
			setDifficultyListener();
		
		}
	} 
	
	public class helpListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// brings up a box to help explain the game to the player
			
			helpWindow.setSize(815,700);
			JTextArea helpText= new JTextArea("		How To Play SafeCracker"
					+ "\n"
					+ "\n"
					+ "Choosing a Safe"
					+ "\n"
					+ "--Cracking safes can be a very lucrative but dangerous carrer. "
					+ "\n"
					+ "There are many different types of safes just waiting to have their loot liberated from them."
					+ "\n"
					+ "However, it is important to choose wisely. There are two number associated with each safe, the number of digits and the number of directions."
					+ "\n"
					+ "The number of digits tells you have many slots are in a combo, obviously a safe with 7 digits will be harder to crack than a safe with 4"
					+ "\n"
					+ "The number of directions are counted in the number of digits, but there are only 4 directions; U,D,L and R."
					+ "\n"
					+ "Any Digit that is not a directions, is a number from 0-9"
					+ "\n"
					+ "To pick a safe as your next target, you can press the button with its name, or the number or letter labeled to the very left of the name"
					+ "\n"
					+ "\n"
					+ "Cracking a Safe"
					+ "\n"
					+ "--When you try to crack a safe, you must guess the numbers and directions involved in the safe."
					+ "\n"
					+ " All safes have numbers, but some will not have any directions."
					+ "\n"
					+ "The directions will always be the last set of digits in the combo, so for example a JewelHeist safe will have 7 digits, 3 of which are directions"
					+ "\n"
					+ "so a JewelHeist combo may look like 1234LRU but never L123R4U."
					+ "\n"
					+ "\n"
					+ "Using Your Cracker-Jacker 5000 DLX"
					+ "\n"
					+ "--When you attempt to crack a safe, the Cracker-Jacker 5000 DLX will tell you how many posistions and how many digits you've gotten correct."
					+ "\n"
					+ "The digits correct tell you how many of the numbers and directions you guesses are used within the combo, but not if they are in the right location"
					+ "\n"
					+ "The posistions correct tell you how many locations within the combo are matched correctly, but not which digits are right."
					+ "\n"
					+ "Say a combonation is 123UD, and you guess 321RU. There will be 4 digits correct, but only 1 posistion correct."
					+ "\n"
					+ "Your Cracker-Jacker 5000 DLX will give you a history of all your previous guesses, but is unable to keep track of the posistions and digits correct"
					+ "\n"
					+ "\n"
					+ "Wanted Level and Bail"
					+ "\n"
					+ "--Your wanted level tells you how bad the cops want to catch you, it is based not only on the number of safes you have cracked, but how difficult they were"
					+ "\n"
					+ "While your wanted level won't lead cops to you, it will affect how much your bail is if you get caught."
					+ "\n"
					+ "Bail is how much loot you loose if you get caught by the cops. You can be caught if you take to much time to crack a safe"
					+ "\n"
					+ "or you use to many guesses. You can also get caught when you try unothadoxed methods to crack a safe quickly"
					+ "\n"
					+ " How much you have to bail out is dependant on how difficult the safe was to crack as well as your wanted level"
					+ "\n"
					+ "Be careful choosing a safe, the cost of bail can quickly skyrocket. Of course, safes that are harder to crack probably have more loot"
					+ "\n"
					+ "\n"
					+ "Loading and Saving You Carrer"
					+ "\n"
					+ "--The Save button will save your current carrer. You can click the save button or use Shift+S"
					+ "\n"
					+ "The Load button will load a previous carrer, you can click the Load button or use Shift+L"
					+ "\n"
					+ "While you can load and save a carrer that has ended (has run out of loot), you won't be able to play anymore safes with that carrer");
			helpText.setEditable(false);
			
			helpWindow.add(helpText);
			helpWindow.setVisible(true);
			
		}
		
	}
	
	public class clearGuess implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			 // listener clears the digits on the current guess by clearing currentGuess
			try
			{
				if (!isWinner)  // only allows the guess to be cleared if the game hasn't already been won
				{
					currentGuess=new StringBuilder();
					printUpdate();
				} 
				else;
			}// ends try
			catch(StringIndexOutOfBoundsException ex)
			{
				// does nothing if there is a StringIndexOutOfBoundsException
				// this type of error occurs if somebody hits backspace or clear at the wrong time
		
			} // ends catch
		}
	}
	
	public class backSpace implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// clears the most recent digit on the current guess
			try
			{
			int deleteCharLocation= currentGuess.length()-1;
			currentGuess.deleteCharAt(deleteCharLocation);
			printUpdate();
			}
			catch(StringIndexOutOfBoundsException ex)
			{
				// does nothing if there is a StringIndexOutOfBoundsException
				// this type of error occurs if somebody hits backspace or clear 
			}
			
		}
	}
	public class proShopListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			proShop();
			
		}
	}
	
	public class cheatListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton hold= (JButton)e.getSource();
			
			System.out.println("cheatListener");
			if(hold.getText().contains("TNT"))
			{
				if(loot>4500)
				{
					loot-=4500;
					explosives++;
					buyStatus(true, "TNT");
				}
				else
				{
					// display message telling user that they don't have enough money
					buyStatus(false, "Nothing");
					
				}
				
			}
			else if(hold.getText().contains("Snips"))
			{
				if(loot>3000)
				{
					loot-=3000;
					snips++;
					buyStatus(true,"Snips");
				}
				else
				{
					// display a message telling the user that they don't have enough money
					buyStatus(false, "Nothing");
				
				}
			}
			else if (hold.getText().contains("Picks"))
			{
				if(loot>3500)
				{
					loot-=3500;
					picks++;
					buyStatus(true, "Picks");
				}
				else
				{
					//display a message telling the user that they don't have enough money
					buyStatus(false, "Nothing");
					
				}
			} // ends else if
			
			
		}
	}
	
	public class keyListener implements KeyListener
	{ 
	
	public void keyTyped(KeyEvent e) 
	{
		// press appropriate button based on the key typed
		
		StringBuilder holdString= new StringBuilder(e.getKeyChar());
		
		if(e.getKeyChar()=='0')
		{
			J0.doClick();
		}
		else if(e.getKeyChar()=='1')
		{
			J1.doClick();
		}
		else if(e.getKeyChar()=='2')
		{
			J2.doClick();
		}
		else if(e.getKeyChar()=='3')
		{
			J3.doClick();
		}
		else if(e.getKeyChar()=='4')
		{
			J4.doClick();
		}
		else if(e.getKeyChar()=='5')
		{
			J5.doClick();
		}
		else if(e.getKeyChar()=='6')
		{
			J6.doClick();
		}
		else if(e.getKeyChar()=='7')
		{
			J7.doClick();
		}
		else if(e.getKeyChar()=='8')
		{
			J8.doClick();
		}
		else if(e.getKeyChar()=='9')
		{
			J9.doClick();
		}
		else if(e.getKeyChar()=='u' || e.getKeyChar()=='U')
		{
			JUp.doClick();
		}
		else if(e.getKeyChar()=='d' || e.getKeyChar()=='D')
		{
			JDown.doClick();
		}
		else if(e.getKeyChar()=='l' || e.getKeyChar()=='L')
		{
			JLeft.doClick();
		}
		else if(e.getKeyChar()=='r' || e.getKeyChar()=='R')
		{
			JRight.doClick();
		}
		else if(e.getKeyChar()=='h' || e.getKeyChar()=='H')
		{
			// triggers the how-to button
			Help.doClick();
		}
		else if(e.getKeyChar()=='S')
		{
			// triggers the save button, but only with a capital S to avoid an accidental save
			Save.doClick();
		}
		else if(e.getKeyChar()=='L')
		{
			// triggers the load button, but only with a capital L to avoid an accidental load
			Load.doClick();
		}
		else if (e.getKeyChar()=='P')
		{
			//triggers the button to the proshop, but only with a capital P to avoid accidental entry into the proshop
			JStore.doClick();
		
		}
		else if (e.getKeyChar()=='x')
		{
			JTNT.doClick();
		}
		else if (e.getKeyChar()=='p')
		{
			JPicks.doClick();
		}
		else if (e.getKeyChar()=='s')
		{
			JSnips.doClick();
		}
		else if( (int)e.getKeyChar()==10)
		{
			//trigger enter button
			JEnter.doClick();
		}
		else if( (int)e.getKeyChar()==8)
		{
			// triggers the backspace button
			JBackSpace.doClick();
		}
		else if( (int)e.getKeyChar()==127)
		{
			// triggers the clear button
			JClear.doClick();
		}
		else
		{
			//System.out.println((int)e.getKeyChar()); // print typed character for debugging
		}
		
		
	}	
	public void keyPressed(KeyEvent e)
	{
		// do nothing
	
	}
	public void keyReleased(KeyEvent e)
	{
		// do nothing
		
	} 
	} // ends key Listener
	
	public class keyListener2 implements KeyListener
	{
		// listener is used for the proshop
		public void keyTyped(KeyEvent e)
		{
			
			if( (int)e.getKeyChar()==10)
			{
				// triggers the enter button when the enter button is clicked
				JEnter.doClick();
			}
		}
		public void keyPressed(KeyEvent e)
		{
			
		}
		public void keyReleased(KeyEvent e)
		{
			
		}
	}
	public class applyCheat implements ActionListener
	{ // listener is responsible for applying cheats from the proshop to the game
		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton hold= (JButton)e.getSource();
			
			if (hold.getText().contains("TNT"))
			{
				// apply an explosive charge to the safe that may crack the safe or may call the cops
				// Success rate should be about 75% on easy and medium levels, and 45% for harder level
				
				explosives--;
				
				if (difficulty<10)
				{
					// select success for easy and medium difficulties 0-9
					int rand= (int)(Math.random()*4);
					
					if (rand>0)
						winningProtocol(); // wins if the random number is 1 or more
					else
						losingProtocol(); // otherwise it is a loser
				} // ends if (difficulty<10)
				else
				{
					// selects success for harder level
					int rand= (int)(Math.random()*101);
					
					if(rand<=45)
						winningProtocol();
					else
						losingProtocol();
				} // ends else
					
			} // ends else (hold.getText().equals("TNT))
			
			else if (hold.getText().contains("Snips"))
			{
				// delay the cops by adding time and guesses
				timeInMinutes++;
				guessLimit+=2;
				snips--;
				printUpdate();
				
			}
			else if (hold.getText().contains("Lock Pick"))
			{
				// Remove a digit from the combo, make it random
				picks--;
				int rand= (int)(Math.random()*(combo.length()+1)); // picks a random spot in the char to delete
				combo.deleteCharAt(rand); // applies the delete
				directions=0;
				
				for(int i=0; i<combo.length(); i++) // loop recounts the number of directions in the combo
				{
					
					if (combo.charAt(i)=='U' || combo.charAt(i)=='D' || combo.charAt(i)=='L' || combo.charAt(i)=='R')
					{
						directions++;
					}
				} // ends for loop
				
				comboSize=combo.length();
				printUpdate();
				
			}// ends else if
		} // ends actionPerformed method
	} // ends applyCheat class

	public class infoPress implements ActionListener
	{ // opens a window to identify special information about the creation of this program
		@Override
		public void actionPerformed(ActionEvent e)
		{
			JFrame infoWindow= new JFrame();
			infoWindow.setSize(250,250);
			JTextArea infoText= new JTextArea("Thank You For Playing Safe Cracker \n"
					+ "\n"
					+ "Created By: Steven Paytosh \n"
					+ "\n"
					+ "Computer Science and Engineering @ Univeristy of Toledo \n"
					+ "\n"
					+ "Spring 2014");
			infoWindow.setSize(500,250);
			infoWindow.add(infoText);
			
			infoWindow.setVisible(true);
		}
	} // end infoPress
	// public class
	
	
	
	
//=========================================================================================================================================
//=========================================================================================================================================
// METHODS						METHODS					METHODS			METHODS
//=========================================================================================================================================
//=========================================================================================================================================
	
	
	//#1
	// welcomeText
	//
		private void welcomeText()
		{
			topText.setBackground(Color.WHITE);
			topText.setText("		 Welcome to SafeCracker V3"
					+ "\n"
					+ "\n"
					+ "The Object of the game is to acquire loot by cracking safes"
					+ "\n"
					+ "Your Cracker-Jacker 5000 DLX will tell you how many posistions and digits you get right"
					+ "\n"
					+ "However, don't take to long, othewise you'll get busted by the cops"
					+ "\n"
					+ "If you run out of loot, or can't make bail, your carrer is over."
					+ "\n"
					+ "For more information, click how to"
					+ "\n"
					+ "To play, click enter");
			
			p0.add(topText);
	
			
		}

	// #2
	// requestDifficulty
	// Receives the desired difficulty of the next safe from the user
	// also prints an update for the user between games
		public void requestDifficulty()
		{
			// be very careful in changing the spacing of the text here, it takes a lot of work to line these up properly
			topText.setBackground(Color.WHITE);
			topText.setText("		Loot:  $" + loot + "     Wanted Level: " + wantedLevel+ "      Break-Ins: " + totalBreakIns
					+ "\n"
					+ "\n"
					+ "	                                              Select Difficulty"
					+ "\n"
					+ "\n"
			   		+ "(0) Easy - 3 Digits, 0 Directions             (5) Hard- 6 Digits, 2 Directions                (U) Extreme-8 Digits, 3 Directions"			
			   		+ "\n"
			   		+ "(1) PiggyBank- 4 Digits, 1 Directions    (6) ChineseLock- 6 Directions                 (D) FedHeist-8 Digits, 2 Directions"			
			   		+ "\n"
			   		+ "(2) KittyBank- 4 Digits, 0 Directions       (7) BankHeist-6 Digits, 0 Directions       (L) Oceans666-8 Digits, 1 Direction  "
					+ "\n"
					+ "(3) Motel Safe- 5 Digits, 1 directions     (8) JewelHeist-7 Digits, 3 Directions      (R) Heistenberg- 10 Digits, 0 Directions"		   
					+ "\n"
					+ "(4) Hotel Safe- 5 Digits, 0 Direction       (9) MuseumHeist-7 Digits, 2 Directions"
					+ "\n"
					+ "");		
			
				
		}


	// #5
	// makeCombo
	// returns a combination based on the difficulty
		public void makeCombo()
		{	
		
			/* each time a safe is played the appropriate number of digits will be appended into a StringBuilder called combo
			 * for each spot, use the randomNumber method to return a digit, the no-arg method will return 0-9, the integer arg(use any number)
			 * will return 1-9 but no zeros, this is required for the first digit in the combination. and use a character to return a direction
			 *  */

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
				 */
				
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
						topText.setText("		Loot:  $" + loot + "     Wanted Level: " + wantedLevel+ "      Break-Ins: " + totalBreakIns // + "   combo: " + combo 
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
	// #18
	// setDifficultyListener
	// sets the listeners for the select difficulty selection phase of the game
			private void setDifficultyListener()
			{
			
				// Sets the numbers1 listener to the digits and directions, that will allow the user to select the difficulty
				J0.addActionListener(numbers1);
				J1.addActionListener(numbers1);
				J2.addActionListener(numbers1);
				J3.addActionListener(numbers1);
				J4.addActionListener(numbers1);
				J5.addActionListener(numbers1);
				J6.addActionListener(numbers1);
				J7.addActionListener(numbers1);
				J8.addActionListener(numbers1);
				J9.addActionListener(numbers1);
				JUp.addActionListener(numbers1);
				JDown.addActionListener(numbers1);
				JLeft.addActionListener(numbers1);
				JRight.addActionListener(numbers1);
				JEnter.addActionListener(numbers1);
				JClear.removeActionListener(clearListener); // turns off the clearListener so there are no issues with selecting a level
				JBackSpace.removeActionListener(backSpaceListener); // turn off the backSpaceListener so there are no issue with selecting a level
				JEnter.removeActionListener(exitGame1); // removes the exitGame listener which prevents a bug from occuring when a player doesn't enter enough digits
				
				//Reset the text on the buttons
				J0.setText("Easy");
				J1.setText("PiggyBank");
				J2.setText("KittyBank");
				J3.setText("MotelSafe");
				J4.setText("HotelSafe");
				J5.setText("Hard");
				J6.setText("Chinese");
				J7.setText("BankHeist");
				J8.setText("JewelHeist");
				J9.setText("Museum");
				JUp.setText("Extreme");
				JDown.setText("FedHeist");
				JLeft.setText("Oceans666");
				JRight.setText("KingPin");
				JEnter.setText("Enter");
				JBackSpace.setText("Back Space");
				JClear.setText("Clear");
				
				// Removes the listers that allow cheats to be bought
				JTNT.removeActionListener(applyCheat);
				JSnips.removeActionListener(applyCheat);
				JPicks.removeActionListener(applyCheat);
				J0.removeActionListener(cheatListener);
				J1.removeActionListener(cheatListener);
				J2.removeActionListener(cheatListener);
				
				
				//hideButtons();
				//hideTools();
				JClear.setForeground(Color.LIGHT_GRAY);
				JBackSpace.setForeground(Color.LIGHT_GRAY);
				
				// tools are off during this phase
				if (explosives>0)
				{
					JTNT.setText("TNT (" + explosives + "x)");
					JTNT.setForeground(Color.LIGHT_GRAY);
				}
				else 
				{
					JTNT.setText("-");
					JTNT.setForeground(Color.LIGHT_GRAY);
				}
				if (picks>0)
				{
					JPicks.setText("Picks (" + picks + "x)");
					JPicks.setForeground(Color.LIGHT_GRAY);
				}
				else
				{
					JPicks.setText("-");
					JPicks.setForeground(Color.LIGHT_GRAY);
				}
				if (snips>0)
				{
					JSnips.setText("Snips (" + snips + "x)");
					JSnips.setForeground(Color.LIGHT_GRAY);
				}
				else
				{
					JSnips.setText("-");
					JSnips.setForeground(Color.LIGHT_GRAY);
				}
			
				
				// show the proshop to the player if they have more than 3 break-ins
				if(totalBreakIns>=3)  // makes the pro shop available if the player has broken enough safes
				{
					JStore.addActionListener(proShopListener);
					JStore.setText("Pro Shop");
				}
				else
				{

					JStore.removeActionListener(proShopListener);
				}
				
				
				mainWindow.requestFocus();
				
				J0.setVisible(true);
				J1.setVisible(true);
				J2.setVisible(true);
				J3.setVisible(true);
				J4.setVisible(true);
				J5.setVisible(true);
				J6.setVisible(true);
				J7.setVisible(true);
				J8.setVisible(true);
				J9.setVisible(true);
				JUp.setVisible(true);
				JDown.setVisible(true);
				JLeft.setVisible(true);
				JRight.setVisible(true);
				JEnter.setVisible(true);
				JBackSpace.setVisible(true);
				JClear.setVisible(true);
				
				
					
			}
			
			
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
		
//
// 
	
} // ends class


