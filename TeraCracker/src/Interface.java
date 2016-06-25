import java.awt.Color;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class Interface {
	// listeners are instantiated here because they will be repeatedly turned on
	// an off
	numberListener1 numbers1 = new numberListener1();
	numberListener2 numbers2 = new numberListener2();
	exitWelcome exitWelcome1 = new exitWelcome();
	// exitGame exitGame1= new exitGame();
	// helpListener help= new helpListener();
	// clearGuess clearListener= new clearGuess();
	// backSpace backSpaceListener= new backSpace();
	// proShopListener proShopListener= new proShopListener();
	// cheatListener cheatListener= new cheatListener();
	// keyListener key1= new keyListener();
	// public applyCheat applyCheat= new applyCheat();
	// infoPress infoPress= new infoPress();

	private Timer timer = new Timer(1000, new timerListener()); // time event
																// listener
	GUI GUI;

	Interface(GUI a) {
		GUI = a;
		// register listeners
		(GUI.JEnter).addActionListener(exitWelcome1);
		// (GUI.Help).addActionListener(help); // note the button "Help" is
		// capitalized, while the listener is lowercase
		// (GUI.JInfo).addActionListener(infoPress);
		(GUI.mainWindow).setFocusable(true); // sets the main window to
												// focusable
		(GUI.mainWindow).requestFocus(); // requests focus for the main window
		(GUI.mainWindow).setFocusTraversalKeysEnabled(false); // keeps focus
																// from shifting
																// away
		// (GUI.mainWindow).addKeyListener(key1); // registers the keyListener
		// for the game
	}

	// ========================================================================================================================================
	// ========================================================================================================================================
	// LISTENERS LISTENERS LISTENERS LISTENERS
	// ========================================================================================================================================
	// ========================================================================================================================================

	public class numberListener2 implements ActionListener {/*
															 * This is the main
															 * listener in the
															 * game and should
															 * ideally hold most
															 * of the logic it
															 * covers all the
															 * numbered buttons
															 * and the
															 * directions. It
															 * does not cover
															 * the enter button
															 * or the helper
															 * buttons.
															 * 
															 * When the player
															 * enters a number
															 * or direction,
															 * this listener
															 * adds the
															 * information to
															 * the guess and
															 * applies the guess
															 * when the proper
															 * conditions are
															 * met
															 */
		@Override
		public void actionPerformed(ActionEvent e) {
			/*
			 * 
			 * JButton temp=(JButton)e.getSource(); // acquires the input of the
			 * entered digit or direction
			 * 
			 * if((TeraCracker.currentGuess).length()<(TeraCracker.comboSize) &&
			 * (TeraCracker.turnCount) < (TeraCracker.guessLimit)) { //
			 * condition does not allow the string to be bigger then the
			 * combination
			 * 
			 * // switch updates the current guess string switch(temp.getText())
			 * { case "0": (TeraCracker.currentGuess).append(temp.getText());
			 * break; case "1":
			 * (TeraCracker.currentGuess).append(temp.getText()); break; case
			 * "2": (TeraCracker.currentGuess).append(temp.getText()); break;
			 * case "3": (TeraCracker.currentGuess).append(temp.getText());
			 * break; case "4":
			 * (TeraCracker.currentGuess).append(temp.getText()); break; case
			 * "5": (TeraCracker.currentGuess).append(temp.getText()); break;
			 * case "6": (TeraCracker.currentGuess).append(temp.getText());
			 * break; case "7":
			 * (TeraCracker.currentGuess).append(temp.getText()); break; case
			 * "8": (TeraCracker.currentGuess).append(temp.getText()); break;
			 * case "9": (TeraCracker.currentGuess).append(temp.getText());
			 * break; case "Up": (TeraCracker.currentGuess).append("U"); break;
			 * case "Down": (TeraCracker.currentGuess).append("D"); break; case
			 * "Left": (TeraCracker.currentGuess).append("L"); break; case
			 * "Right": (TeraCracker.currentGuess).append("R"); break; default:
			 * TeraCracker.printUpdate(); return; } //ends switch
			 * 
			 * 
			 * printUpdate();
			 * 
			 * } // ends if
			 * 
			 * else if(currentGuess.length()==comboSize &&
			 * temp.getText().equals("Enter") && turnCount<guessLimit) { //
			 * process a completed guess
			 * //guessArray[turnCount].delete(0,comboSize);
			 * guessArray[turnCount]=currentGuess;
			 * 
			 * //check the number of positions and digits correct
			 * getPosistions();
			 * 
			 * currentGuess=new StringBuilder(); // clears out the current guess
			 * turnCount++; printUpdate();
			 * 
			 * 
			 * } else if(currentGuess.length()==comboSize &&
			 * !temp.getText().equals("Enter")) { // suggest user hit enter }
			 * else;
			 */
		} // ends actionPerformed

	} // ends numberListener2

	class timerListener implements ActionListener {
		// class acts as a listener for a timer that tells the user how long
		// they've been playing
		@Override
		public void actionPerformed(ActionEvent e) {
			/*
			 * timeInSeconds--; // everytime the listener hits, count down 1
			 * seconds
			 * 
			 * if (timeInSeconds==0 && timeInMinutes==0) { // if the timer
			 * reaches 0, ends the game losingProtocol();
			 * 
			 * } else if (timeInSeconds<=0) { // if the seconds reach zero,
			 * decrements the minutes and reset seconds to 59 timeInSeconds=59;
			 * timeInMinutes--; printUpdate(); } else { printUpdate(); }
			 */

		} // ends actionPerformed
	} // ends timerListener

	public class numberListener1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			/*
			 * This listener is used for the difficulty selection phase of the
			 * game listener acts for each number and direction
			 * 
			 * when the player clicks on the desired difficulty, this method
			 * runs and sets the difficulty, comboSize and guessLimit variable
			 * 
			 * after those variables are set, the setGameListener method will be
			 * called
			 */
			/*
			 * JButton temp=(JButton)e.getSource();
			 * 
			 * //conditions check the button pushed and sets the appropriate
			 * setting if(temp.getText().equals("Easy")) { // sets game to easy
			 * // 3 digits with no direction difficulty=1; comboSize=3;
			 * guessLimit=10; directions=0; timeInSeconds=0; timeInMinutes=6;
			 * 
			 * } else if (temp.getText().equals("PiggyBank")) { // sets game to
			 * PiggyBank level // 4 digits with 1 directions difficulty=2;
			 * comboSize=4; guessLimit=10; directions=1; timeInSeconds=0;
			 * timeInMinutes=6;
			 * 
			 * } else if (temp.getText().equals("KittyBank")) { // sets game to
			 * KittyBank Level // 4 digits with 0 directions difficulty=3;
			 * comboSize=4; guessLimit=10; directions=0; timeInSeconds=0;
			 * timeInMinutes=6; } else if (temp.getText().equals("MotelSafe")) {
			 * // 5 Digits with 1 directions difficulty=4; comboSize=5;
			 * guessLimit=10; directions=1; timeInSeconds=0; timeInMinutes=6;
			 * 
			 * } else if (temp.getText().equals("HotelSafe")) { // 5 Digits with
			 * 0 direction difficulty=5; comboSize=5; guessLimit=10;
			 * directions=0; timeInSeconds=0; timeInMinutes=6; } else
			 * if(temp.getText().equals("Hard")) { //6 Digits with 2 directions
			 * difficulty=6; comboSize=6; guessLimit=9; directions=2;
			 * timeInSeconds=0; timeInMinutes=5; } else
			 * if(temp.getText().equals("Chinese")) { //6 directions
			 * difficulty=7; comboSize=6; guessLimit=8; // 8 is significant to
			 * eastern culture directions=6; timeInSeconds=0; timeInMinutes=5; }
			 * else if(temp.getText().equals("BankHeist")) { //6 Digits with 0
			 * directions difficulty=8; comboSize=6; guessLimit=9; directions=0;
			 * timeInSeconds=0; timeInMinutes=5; } else
			 * if(temp.getText().equals("JewelHeist")) { //7 Digits with 3
			 * directions difficulty=9; comboSize=7; guessLimit=9; directions=3;
			 * timeInSeconds=0; timeInMinutes=5; } else
			 * if(temp.getText().equals("Museum")) { //7 Digits with 2
			 * directions difficulty=10; comboSize=7; guessLimit=9;
			 * directions=2; timeInSeconds=0; timeInMinutes=5; } else
			 * if(temp.getText().equals("Extreme")) { //8 Digits with 3
			 * directions difficulty=11; comboSize=8; guessLimit=9;
			 * directions=3; timeInSeconds=0; timeInMinutes=5; } else
			 * if(temp.getText().equals("FedHeist")) { //8 Digits with 2
			 * directions difficulty=12; comboSize=8; guessLimit=8;
			 * directions=2; timeInSeconds=0; timeInMinutes=5; } else
			 * if(temp.getText().equals("Oceans666")) { //8 Digits with 1
			 * directions difficulty=13; comboSize=8; guessLimit=8;
			 * directions=1; timeInSeconds=0; timeInMinutes=5; } else
			 * if(temp.getText().equals("KingPin")) { //10 Digits with 0
			 * directions difficulty=100; comboSize=10; guessLimit=7;
			 * directions=0; timeInSeconds=0; timeInMinutes=5; } else return;
			 * 
			 * makeCombo();
			 * 
			 * setGameListener(); // sets the buttons to game mode
			 */

		} // ends actionPerformed

	} // ends numberListener1

	public class exitWelcome implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			/*
			 * This listener is responsible for handling the difficulty
			 * selection phase of the game
			 */

			// exits the welcome screen and implements setDifficultyListener
			GUI.requestDifficulty(); // sets the text to request difficulty
			// setDifficultyListener(); // method sets the needed button text
			// and listeners

		}
	}

	
	 public class exitGame implements ActionListener 
	 {
	   @Override 
	   public void actionPerformed(ActionEvent e) { 
		  // Transitions from the end of a game to the select difficulty screen 
		//  isWinner=false;
	  //requestDifficulty(); 
	  setDifficultyListener();
	  
	  } 
	   }
	  
	  public class helpListener implements ActionListener 
	  {
		  @Override 
		  public void actionPerformed(ActionEvent e) 
		  { // brings up a box to help explain the game to the player
	  
	  GUI.helpWindow.setSize(815,700); JTextArea helpText= new
	  JTextArea("		How To Play SafeCracker" + "\n" + "\n" + "Choosing a Safe" +
	  "\n" + "--Cracking safes can be a very lucrative but dangerous carrer. "
	  + "\n" +
	  "There are many different types of safes just waiting to have their loot liberated from them."
	  + "\n" +
	  "However, it is important to choose wisely. There are two number associated with each safe, the number of digits and the number of directions."
	  + "\n" +
	  "The number of digits tells you have many slots are in a combo, obviously a safe with 7 digits will be harder to crack than a safe with 4"
	  + "\n" +
	  "The number of directions are counted in the number of digits, but there are only 4 directions; U,D,L and R."
	  + "\n" + "Any Digit that is not a directions, is a number from 0-9" +
	  "\n" +
	  "To pick a safe as your next target, you can press the button with its name, or the number or letter labeled to the very left of the name"
	  + "\n" + "\n" + "Cracking a Safe" + "\n" +
	  "--When you try to crack a safe, you must guess the numbers and directions involved in the safe."
	  + "\n" +
	  " All safes have numbers, but some will not have any directions." + "\n"
	  +
	  "The directions will always be the last set of digits in the combo, so for example a JewelHeist safe will have 7 digits, 3 of which are directions"
	  + "\n" + "so a JewelHeist combo may look like 1234LRU but never L123R4U."
	  + "\n" + "\n" + "Using Your Cracker-Jacker 5000 DLX" + "\n" +
	  "--When you attempt to crack a safe, the Cracker-Jacker 5000 DLX will tell you how many posistions and how many digits you've gotten correct."
	  + "\n" +
	  "The digits correct tell you how many of the numbers and directions you guesses are used within the combo, but not if they are in the right location"
	  + "\n" +
	  "The posistions correct tell you how many locations within the combo are matched correctly, but not which digits are right."
	  + "\n" +
	  "Say a combonation is 123UD, and you guess 321RU. There will be 4 digits correct, but only 1 posistion correct."
	  + "\n" +
	  "Your Cracker-Jacker 5000 DLX will give you a history of all your previous guesses, but is unable to keep track of the posistions and digits correct"
	  + "\n" + "\n" + "Wanted Level and Bail" + "\n" +
	  "--Your wanted level tells you how bad the cops want to catch you, it is based not only on the number of safes you have cracked, but how difficult they were"
	  + "\n" +
	  "While your wanted level won't lead cops to you, it will affect how much your bail is if you get caught."
	  + "\n" +
	  "Bail is how much loot you loose if you get caught by the cops. You can be caught if you take to much time to crack a safe"
	  + "\n" +
	  "or you use to many guesses. You can also get caught when you try unothadoxed methods to crack a safe quickly"
	  + "\n" +
	  " How much you have to bail out is dependant on how difficult the safe was to crack as well as your wanted level"
	  + "\n" +
	  "Be careful choosing a safe, the cost of bail can quickly skyrocket. Of course, safes that are harder to crack probably have more loot"
	  + "\n" + "\n" + "Loading and Saving You Carrer" + "\n" +
	  "--The Save button will save your current carrer. You can click the save button or use Shift+S"
	  + "\n" +
	  "The Load button will load a previous carrer, you can click the Load button or use Shift+L"
	  + "\n" +
	  "While you can load and save a carrer that has ended (has run out of loot), you won't be able to play anymore safes with that carrer"
	  ); helpText.setEditable(false);
	  
	  GUI.helpWindow.add(helpText); 
	  GUI.helpWindow.setVisible(true);
	  
	  }
	  
	  }
	  
	  public class clearGuess implements ActionListener 
	  {
		  @Override 
		  public void actionPerformed(ActionEvent e) { 
			  // listener clears the digits on the current guess by clearing currentGuess 
			  try { 
				  if(!TeraCracker.isWinner) // only allows the guess to be cleared if the game hasn't already been won 
					  { TeraCracker.currentGuess=new StringBuilder();
					  printUpdate(); 
					  }
	  else; 
				  }
			  // ends try 
			  catch (StringIndexOutOfBoundsException ex) 
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
	 { // clears the most  recent digit on the current guess 
		 try { int deleteCharLocation=TeraCracker.currentGuess.length()-1; 
		 TeraCracker.currentGuess.deleteCharAt(deleteCharLocation);
	  printUpdate(); 
	  } 
		 catch(StringIndexOutOfBoundsException ex) 
		 { // does nothing if there is a StringIndexOutOfBoundsException 
			 // this type of error occurs if somebody hits backspace or clear
			 }
	  
	  } 
	 } 
	  
	  public class proShopListener implements ActionListener {
	  
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
	  if(TeraCracker.loot>4500) { TeraCracker.loot-=4500; 
	  TeraCracker.explosives++; 
	 
	  buyStatus(true, "TNT"); 
	  } 
	  else
	  { // display message telling user that they don't have enough money
	  buyStatus(false, "Nothing");
	  
	  }
	  
	  } 
	  else if(hold.getText().contains("Snips")) 
	  { 
		  if(loot>3000) 
		  { 
			  loot-=3000;
			  teraCracker.snips++; 
			  buyStatus(true,"Snips"); } 
		  else 
		  { 
			  // display a message telling the user that they don't have enough money 
			  buyStatus(false, "Nothing");
	  
	  } 
		  } 
	  else if (hold.getText().contains("Picks")) 
	  { if(TeraCracker.loot>3500) 
	  {
	  TeraCracker.loot-=3500; 
	  TeraCracker.picks++; 
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
	  
	  if(e.getKeyChar()=='0') { GUI.J0.doClick(); } else if(e.getKeyChar()=='1') {
	  GUI.J1.doClick(); } else if(e.getKeyChar()=='2') { GUI.J2.doClick(); } else
	  if(e.getKeyChar()=='3') { GUI.J3.doClick(); } else if(e.getKeyChar()=='4') {
		  GUI.J4.doClick(); } else if(e.getKeyChar()=='5') { GUI.J5.doClick(); } else
	  if(e.getKeyChar()=='6') { GUI.J6.doClick(); } else if(e.getKeyChar()=='7') {
		  GUI.J7.doClick(); } else if(e.getKeyChar()=='8') { GUI.J8.doClick(); } else
	  if(e.getKeyChar()=='9') { GUI.J9.doClick(); } else if(e.getKeyChar()=='u' ||
	  e.getKeyChar()=='U') { GUI.JUp.doClick(); } else if(e.getKeyChar()=='d' ||
	  e.getKeyChar()=='D') { GUI.JDown.doClick(); } else if(e.getKeyChar()=='l' ||
	  e.getKeyChar()=='L') { GUI.JLeft.doClick(); } else if(e.getKeyChar()=='r' ||
	  e.getKeyChar()=='R') { GUI.JRight.doClick(); } else if(e.getKeyChar()=='h' ||
	  e.getKeyChar()=='H') { 
		  // triggers the how-to button 
		  GUI.Help.doClick(); 
		  }
	  else if(e.getKeyChar()=='S') { 
		  // triggers the save button, but only with a capital S to avoid an accidental save 
		  GUI.Save.doClick(); 
		  } else
	  if(e.getKeyChar()=='L') { 
		  // triggers the load button, but only with a capital L to avoid an accidental load 
		  GUI.Load.doClick(); } else if
	  (e.getKeyChar()=='P') { 
			  //triggers the button to the proshop, but only with a capital P to avoid accidental entry into the proshop
			  GUI.JStore.doClick();
	  
	  } 
		  else if (e.getKeyChar()=='x') 
		  { 
			  GUI.JTNT.doClick(); 
			  } else if
	  (e.getKeyChar()=='p') 
			  { 
				  GUI.JPicks.doClick(); } 
			  else if (e.getKeyChar()=='s')
	  { 
				  GUI.JSnips.doClick(); 
				  } 
			  else if( (int)e.getKeyChar()==10) 
			  { //trigger enter button 
				  GUI.JEnter.doClick(); } 
			  else if( (int)e.getKeyChar()==8) { 
				  // triggers the backspace button 
				  GUI.JBackSpace.doClick(); 
				  } 
			  else if
			  (
	  (int)e.getKeyChar()==127) 
			  { 
				  // triggers the clear button
				  GUI.JClear.doClick(); 
				  } 
			  else 
			  { 
		//System.out.println((int)e.getKeyChar()); 
				  //print typed character for debugging 
				  }
	  
	  
	  } 
	  public void keyPressed(KeyEvent e) 
	  { // do nothing
	  
	  } 
	  public void keyReleased(KeyEvent e) 
	  { // do nothing
	  
	  } 
	  } // ends key Listener
	  
	  public class keyListener2 implements KeyListener 
	  { 
		  // listener is used for the proshop 
	  
		  public void keyTyped(KeyEvent e) {
	  
	  
	  if( (int)e.getKeyChar()==10) { 
		  
		  // triggers the enter button when the enter button is clicked 
		  GUI.JEnter.doClick(); 
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
	  { 
		  // listener is responsible for applying cheats from the proshop to the game
	  
	  @Override 
	  public void actionPerformed(ActionEvent e) 
	  { 
		  JButton hold= (JButton)e.getSource();
	  
	  if (hold.getText().contains("TNT"))
	  { 
		  // apply an explosive charge to the safe that may crack the safe or may call the cops 
		  // Success rate should be about 75% on easy and medium levels, and 45% for harder level
	  
	  TeraCracker.explosives--;
	  
	  if (TeraCracker.difficulty<10) 
	  { 
		  // select success for easy and medium difficulties 0-9 
		  int rand= (int)(Math.random()*4);
	  
	  if (rand>0) TeraCracker.winningProtocol(); // wins if the random number is 1 or more
	  else TeraCracker.losingProtocol(); 
	  // otherwise it is a loser 
	  }  // ends if(difficulty<10) 
	  else { 
		  // selects success for harder level 
		  int rand=(int)(Math.random()*101);
	  
	  if(rand<=45) 
		  winningProtocol();
	  else 
		  losingProtocol(); 
	  } // ends else
	  
	  } // ends else (hold.getText().equals("TNT))
	  
	  else if (hold.getText().contains("Snips")) 
	  { // delay the cops by adding time and guesses 
		  TeraCracker.timeInMinutes++; 
		  TeraCracker.guessLimit+=2; 
		  TeraCracker.snips--; 
		  printUpdate();
	  
	  
	  } 
	  else if (hold.getText().contains("Lock Pick")) 
	  { // Remove a digit from the combo, make it random 
		  TeraCracker.picks--; 
		  int rand=(int)(Math.random()*(TeraCracker.combo.length()+1));
		  // picks a random spot in the char to delete 
		  TeraCracker.combo.deleteCharAt(rand); // applies the delete
	  TeraCracker.directions=0;
	  
	  for(int i=0; i<TeraCracker.combo.length(); i++) // loop recounts the number of directions in the combo 
		  {
	  
	  if (TeraCracker.combo.charAt(i)=='U' || TeraCracker.combo.charAt(i)=='D' || TeraCracker.combo.charAt(i)=='L'
	  || TeraCracker.combo.charAt(i)=='R') { TeraCracker.directions++; } } // ends for loop
	  
	  TeraCracker.comboSize=TeraCracker.combo.length(); 
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
		  JTextArea infoText= new
	  JTextArea("Thank You For Playing Safe Cracker \n" + "\n" +
	  "Created By: Steven Paytosh \n" + "\n" +
	  "Computer Science and Engineering @ Univeristy of Toledo \n" + "\n" +
	  "Spring 2014" + "\n" + "https://github.com/StevePaytosh/SafeCracker");
	  infoWindow.setSize(500,250); 
	  infoWindow.add(infoText);
	  infoWindow.setVisible(true); 
	  } 
	  } // end infoPress 
	  // public class
	 
	
	// ===================================================
	// METHODS
	// ===========================================

	public void setDifficultyListeners() {
		// Sets the numbers1 listener to the digits and directions, that will
		// allow the user to select the difficulty
		(GUI.J0).addActionListener(numbers1);
		(GUI.J1).addActionListener(numbers1);
		(GUI.J2).addActionListener(numbers1);
		(GUI.J3).addActionListener(numbers1);
		(GUI.J4).addActionListener(numbers1);
		(GUI.J5).addActionListener(numbers1);
		(GUI.J6).addActionListener(numbers1);
		(GUI.J7).addActionListener(numbers1);
		(GUI.J8).addActionListener(numbers1);
		(GUI.J9).addActionListener(numbers1);
		(GUI.JUp).addActionListener(numbers1);
		(GUI.JDown).addActionListener(numbers1);
		(GUI.JLeft).addActionListener(numbers1);
		(GUI.JRight).addActionListener(numbers1);
		(GUI.JEnter).addActionListener(numbers1);
		// (GUI.JClear).removeActionListener(clearListener); // turns off the
		// clearListener so there are no issues with selecting a level
		// (GUI.JBackSpace).removeActionListener(backSpaceListener); // turn off
		// the backSpaceListener so there are no issue with selecting a level
		// (GUI.JEnter).removeActionListener(exitGame1); // removes the exitGame
		// listener which prevents a bug from occuring when a player doesn't
		// enter enough digits

		// Removes the listers that allow cheats to be bought
		// (GUI.JTNT).removeActionListener((applyCheat);
		// (GUI.JSnips).removeActionListener(applyCheat);
		// (GUI.JPicks).removeActionListener(applyCheat);
		// (GUI.J0).removeActionListener(cheatListener);
		// (GUI.J1).removeActionListener(cheatListener);
		// (GUI.J2).removeActionListener(cheatListener);

		// show the proshop to the player if they have more than 3 break-ins
		if ((TeraCracker.totalBreakIns) >= 3) // makes the pro shop available if
												// the player has broken enough
												// safes
		{
			// (GUI.JStore).addActionListener(proShopListener);
			(GUI.JStore).setText("Pro Shop");
		} else {

			// (GUI.JStore).removeActionListener(proShopListener);
		}
	}

	// #19
		// setGameListeners
		// sets the listeners for the guessing phase of the game
				private void setGameListener()
				{
					
					// remove the difficulty phase listeners
					GUI.J0.removeActionListener(numbers1);
					GUI.J1.removeActionListener(numbers1);
					GUI.J2.removeActionListener(numbers1);
					GUI.J3.removeActionListener(numbers1);
					GUI.J4.removeActionListener(numbers1);
					GUI.J5.removeActionListener(numbers1);
					GUI.J6.removeActionListener(numbers1);
					GUI.J7.removeActionListener(numbers1);
					GUI.J8.removeActionListener(numbers1);
					GUI.J9.removeActionListener(numbers1);
					GUI.JUp.removeActionListener(numbers1);
					GUI.JDown.removeActionListener(numbers1);
					GUI.JLeft.removeActionListener(numbers1);
					GUI.JRight.removeActionListener(numbers1);
					GUI.JEnter.removeActionListener(numbers1);
					GUI.JEnter.removeActionListener(exitWelcome1);
				
				//	GUI.J0.removeActionListener(cheatListener);
				//	GUI.J1.removeActionListener(cheatListener);
				//	GUI.J2.removeActionListener(cheatListener);
					
					
					// register listeners with buttons
					GUI.J0.addActionListener(numbers2);
					GUI.J1.addActionListener(numbers2);
					GUI.J2.addActionListener(numbers2);
					GUI.J3.addActionListener(numbers2);
					GUI.J4.addActionListener(numbers2);
					GUI.J5.addActionListener(numbers2);
					GUI.J6.addActionListener(numbers2);
					GUI.J7.addActionListener(numbers2);
					GUI.J8.addActionListener(numbers2);
					GUI.J9.addActionListener(numbers2);
					GUI.JUp.addActionListener(numbers2);
					GUI.JDown.addActionListener(numbers2);
					GUI.JLeft.addActionListener(numbers2);
					GUI.JRight.addActionListener(numbers2);
					GUI.JEnter.addActionListener(numbers2);
					GUI.JBackSpace.addActionListener(backSpaceListener);
					GUI.JClear.addActionListener(clearListener);
					
					GUI.mainWindow.requestFocus();
						
					//set text to guess mode
					GUI.J0.setText("0");
					GUI.J1.setText("1");
					GUI.J2.setText("2");
					GUI.J3.setText("3");
					GUI.J4.setText("4");
					GUI.J5.setText("5");
					GUI.J6.setText("6");
					GUI.J7.setText("7");
					GUI.J8.setText("8");
					GUI.J9.setText("9");
					GUI.JUp.setText("Up");
					GUI.JDown.setText("Down");
					GUI.JLeft.setText("Left");
					GUI.JRight.setText("Right");
					GUI.JClear.setText("Clear");
					GUI.JBackSpace.setText("Back Space");
					GUI.JEnter.setText("Enter");
					
					
					GUI.JBackSpace.setForeground(Color.BLACK);
					GUI.JClear.setForeground(Color.BLACK);
					
					// if the player has more than 3 break-ins show the proshop
					// proshop will not be accessible during the guess phase
					if(TeraCracker.totalBreakIns>=3)
					{
						GUI.JStore.setText("Pro Shop");
						GUI.JStore.setForeground(Color.LIGHT_GRAY);
						//JStore.setVisible(true);
					}
					else
					{
						//JStore.setVisible(false);
					}
					
					// show tools if they are available, 
					if(TeraCracker.explosives>0)
					{
						GUI.JTNT.setText("TNT (" +TeraCracker.explosives+"x)");
					//	GUI.JTNT.addActionListener(applyCheat);
					}
					else 
					{
						GUI.JTNT.setText("-");
						GUI.JTNT.setForeground(Color.LIGHT_GRAY);
					//	GUI.JTNT.removeActionListener(applyCheat);
					}
					
					if (TeraCracker.snips>0)
					{
						GUI.JSnips.setText("Snips ("+ TeraCracker.snips +"x)" );
					//	GUI.JSnips.addActionListener(applyCheat);
					}
					else
					{
						GUI.JSnips.setText("-");
						GUI.JSnips.setForeground(Color.LIGHT_GRAY);
						//GUI.JSnips.removeActionListener(applyCheat);
					}
					
					if (TeraCracker.picks>0)
					{
						GUI.JPicks.setText("Picks (" + TeraCracker.picks + "x)");
						//GUI.JPicks.addActionListener(applyCheat);
					}
					else
					{
						GUI.JPicks.setText("-");
						GUI.JPicks.setForeground(Color.LIGHT_GRAY);
					//	GUI.JPicks.removeActionListener(applyCheat);
					}
						
					//topText.setText("		Loot:  " + loot + "     Wanted Level: " + wantedLevel+ "      Break-Ins: " + totalBreakIns);
					//bottomText.setText("");
					timer.start();
					//printUpdate();
					
				}// ends setGameListener

				// #17
				// printUpdate
				//
						public void printUpdate()
						{
						
							// method is responsible for updating the board during the guessing phase
							// it is called by the numberListener and hits under certain conditions
							
								
							// checks if the safe has been cracked or not
							if (TeraCracker.isWinner)
							{
								winningProtocol();
								TeraCracker.turnCount=0;
								//currentGuess may need to be cleared here
							}
							else if(TeraCracker.turnCount==TeraCracker.guessLimit)
							{
								losingProtocol();
								TeraCracker.turnCount=0;
							}
							else
							{
								// if the game is neither a winner nor a loser, then it continues to print the necessary information for gamePlay
									StringBuilder tempBuilder= new StringBuilder();
								
									for (int i=0; i<TeraCracker.turnCount; i++)  // for loop strings together all the previous guesses for display
									{
								
										if (i==TeraCracker.turnCount-1)
										{
											tempBuilder.append("  | " + TeraCracker.guessArray[i].toString() + " | ");
										}
										else
										{
											tempBuilder.append("   " + TeraCracker.guessArray[i].toString());
										}
									
									} // ends for loop
								
				
								// display top and bottom text area
							  // uncomment the combo portion of the next line to make the combo visible during play.
									GUI.topText.setText("		Loot:  $" + TeraCracker.loot + "     Wanted Level: " + TeraCracker.wantedLevel+ "      Break-Ins: " + TeraCracker.totalBreakIns  + "   combo: " + TeraCracker.combo 
											+ "\n"
											+ " Difficulty: " + TeraCracker.difficulty 
											+ "\n"
											+ " Digits: " + TeraCracker.comboSize + " Directions: " +TeraCracker.directions
											+ "\n"
											+ " Guesses:  " + (TeraCracker.guessLimit-TeraCracker.turnCount) + "    Time: " + TeraCracker.timeInMinutes + ":"+TeraCracker.timeInSeconds
											+ "\n"
											+ tempBuilder + "\n"
											+ "\n"
											+ "             " + TeraCracker.currentGuess 
											+ "\n"
											+ "      Digits Correct: " + TeraCracker.digitsCorrect +  "    Posistions Correct: " + TeraCracker.posistionsCorrect);
									
									// update the tool buttons
									if(TeraCracker.explosives>0)
									{
										GUI.JTNT.setText("TNT ("+ TeraCracker.explosives + "x)");
										GUI.JTNT.setForeground(Color.BLACK);
										GUI.JTNT.addActionListener(applyCheat);
									}
									else
									{
										GUI.JTNT.setText("");
										GUI.JTNT.removeActionListener(applyCheat);
									}
									
									if (TeraCracker.snips>0)
									{
										GUI.JSnips.setText("Snips (" + snips + "x)");
										GUI.JSnips.setForeground(Color.BLACK);
										GUI.JSnips.addActionListener(applyCheat);
									}
									else
									{
										GUI.JSnips.setText("");
										GUI.JSnips.removeActionListener(applyCheat);
									}
									
									if (TeraCracker.picks>0)
									{
										GUI.JPicks.setText("Lock Pick (" + TeraCracker.picks + "x)");
										GUI.JPicks.setForeground(Color.BLACK);
										GUI.JPicks.addActionListener(applyCheat);
									}
									else
									{
										GUI.JPicks.setText("");
										GUI.JPicks.removeActionListener(applyCheat);
									}
							
							
						
							
							}// ends else
							
							GUI.mainWindow.requestFocus();
							
							
						
						} // ends printUpdate
						
						//
						// losingProtocol
						//
								public void losingProtocol()
								{
									timer.stop();
									
									// getBail();
									TeraCracker.bail=500; // holder value, 500 is the default/ minimum bail out value
									
									TeraCracker.bail*=TeraCracker.wantedLevel*TeraCracker.difficulty; // sets the amount to bail out
									TeraCracker.loot-=TeraCracker.bail; // subtracts the bail out from the 
									
									GUI.topText.setBackground(Color.RED);
									GUI.topText.setText("		Loot:  $" + TeraCracker.loot + "     Wanted Level: " + TeraCracker.wantedLevel+ "      Break-Ins: " + TeraCracker.totalBreakIns
											+ "\n"
											+ "\n"
											+ "    	    Busted!"
											+ "\n"
											+ "         You Failed To Crack The Safe"
											+ "\n"
											+ "         You Bailed Out $" + TeraCracker.bail
											+ "\n"
											+ "         Hit Enter To Case Out Your Next Target");
									
									
									
									// sets listeners for the transition from the end of the game to the difficulty selection
									GUI.J0.removeActionListener(numbers2);
									GUI.J1.removeActionListener(numbers2);
									GUI.J2.removeActionListener(numbers2);
									GUI.J3.removeActionListener(numbers2);
									GUI.J4.removeActionListener(numbers2);
									GUI.J5.removeActionListener(numbers2);
									GUI.J6.removeActionListener(numbers2);
									GUI.J7.removeActionListener(numbers2);
									GUI.J8.removeActionListener(numbers2);
									GUI.J9.removeActionListener(numbers2);
									GUI.JUp.removeActionListener(numbers2);
									GUI.JDown.removeActionListener(numbers2);
									GUI.JLeft.removeActionListener(numbers2);
									GUI.JRight.removeActionListener(numbers2);
									GUI.JEnter.removeActionListener(numbers2);
									GUI.JBackSpace.removeActionListener(numbers2);
									GUI.JClear.removeActionListener(numbers2);
									GUI.J0.removeActionListener(cheatListener);
									GUI.J1.removeActionListener(cheatListener);
									GUI.J2.removeActionListener(cheatListener);
									GUI.JEnter.addActionListener(exitGame1);
									
									
									GUI.JBackSpace.setForeground(Color.LIGHT_GRAY);
									GUI.JClear.setForeground(Color.LIGHT_GRAY);
									
									// proshop may be turned on during this phase
									if(TeraCracker.totalBreakIns>=3)
									{
										GUI.JStore.setText("Pro Shop");
										GUI.JStore.setForeground(Color.BLACK);
										GUI.JStore.setVisible(true);
										GUI.JStore.addActionListener(proShopListener);
									}
									else
									{
										GUI.JStore.setVisible(false);
									}
									
									// show tools if they are available, 
									if(TeraCracker.explosives>0)
									{
										GUI.JTNT.setText("TNT (" +TeraCracker.explosives+"x)");
										
									}
									else 
									{
										GUI.JTNT.setText("");
										
									}
									
									if (TeraCracker.snips>0)
									{
										GUI.JSnips.setText("Snips ("+ TeraCracker.snips +"x)" );
									}
									else
									{
										GUI.JSnips.setText("");
										
									}
									
									if (TeraCracker.picks>0)
									{
										GUI.JPicks.setText("Picks (" + TeraCracker.picks + "x)");
									}
									else
									{
										GUI.JPicks.setText("");
									}
									
									
									TeraCracker.posistionsCorrect=0;
									TeraCracker.digitsCorrect=0;
									
								}
								
						//
						// winningProtocol
						//
								public void winningProtocol()
								{
									timer.stop();
									
									TeraCracker.payout=(int)(Math.random()*1000)*TeraCracker.difficulty;
									TeraCracker.loot+=TeraCracker.payout;
									TeraCracker.totalBreakIns++;
									TeraCracker.wantedLevel();
									
									GUI.topText.setBackground(Color.GREEN);
									GUI.topText.setText("		Loot:  $" + TeraCracker.loot + "     Wanted Level: " + TeraCracker.wantedLevel+ "      Break-Ins: " + TeraCracker.totalBreakIns
											+ "\n"
											+ "\n"
											+ "         Nice!  You Cracked The Safe"
											+ "\n"
											+ "         You \"Found\"  $"+ TeraCracker.payout
											+ "\n"
											+ "         Hit Enter To Case Out Your Next Target");
									
									
									TeraCracker.turnCount=0;
									
									// sets listeners for the transition from the end of the game to the difficulty selection
									GUI.J0.removeActionListener(numbers2);
									GUI.J1.removeActionListener(numbers2);
									GUI.J2.removeActionListener(numbers2);
									GUI.J3.removeActionListener(numbers2);
									GUI.J4.removeActionListener(numbers2);
									GUI.J5.removeActionListener(numbers2);
									GUI.J6.removeActionListener(numbers2);
									GUI.J7.removeActionListener(numbers2);
									GUI.J8.removeActionListener(numbers2);
									GUI.J9.removeActionListener(numbers2);
									GUI.JUp.removeActionListener(numbers2);
									GUI.JDown.removeActionListener(numbers2);
									GUI.JLeft.removeActionListener(numbers2);
									GUI.JRight.removeActionListener(numbers2);
									GUI.JEnter.removeActionListener(numbers2);
									GUI.JBackSpace.removeActionListener(numbers2);
									GUI.JClear.removeActionListener(numbers2);
									GUI.JEnter.addActionListener(exitGame1);
									
									// turn off tools
									GUI.JTNT.removeActionListener(applyCheat);
									GUI.JSnips.removeActionListener(applyCheat);
									GUI.JPicks.removeActionListener(applyCheat);
									GUI.J0.removeActionListener(cheatListener);
									GUI.J1.removeActionListener(cheatListener);
									GUI.J2.removeActionListener(cheatListener);
									
									GUI.JBackSpace.setForeground(Color.LIGHT_GRAY);
									GUI.JClear.setForeground(Color.LIGHT_GRAY);
									
									// turn off tools
									if(TeraCracker.totalBreakIns>=3)
									{
										GUI.JStore.setText("Pro Shop");
										GUI.JStore.setForeground(Color.BLACK);
										GUI.JStore.setVisible(true);
										GUI.JStore.addActionListener(proShopListener);
									}
									else
									{
										GUI.JStore.setVisible(false);
									}
									
									// show tools if they are available, 
									if(TeraCracker.explosives>0)
									{
										GUI.JTNT.setText("TNT (" +TeraCracker.explosives+"x)");
									}
									else 
									{
										GUI.JTNT.setText("");
									}
									
									if (TeraCracker.snips>0)
									{
										GUI.JSnips.setText("Snips ("+ TeraCracker.snips +"x)" );
									}
									else
									{
										GUI.JSnips.setText("");
									}
									
									if (TeraCracker.picks>0)
									{
										GUI.JPicks.setText("Picks (" + TeraCracker.picks + "x)");
									}
									else
									{
										GUI.JPicks.setText("");
									}
									
									TeraCracker.posistionsCorrect=0;
									TeraCracker.digitsCorrect=0;
									
									
									
								} // ends winning protocol
								
}
