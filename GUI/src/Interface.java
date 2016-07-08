import java.awt.Color;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.Timer;


public class Interface {
	// listeners are instantiated here because they will be repeatedly turned on and off
	difficultySelectionListener difficultyListener = new difficultySelectionListener();
	gameListener gameListener = new gameListener();
	exitWelcome exitWelcome = new exitWelcome();
	exitRound exitRound1 = new exitRound();
	exitGame exitGame=new exitGame();
	helpListener helpListener = new helpListener();
	clearGuess clearListener = new clearGuess();
	backSpace backSpaceListener = new backSpace();
	proShopListener proShopListener = new proShopListener();
	cheatListener cheatListener = new cheatListener();
	keyListener keyBoardListener = new keyListener();
	applyCheat applyCheat = new applyCheat();
	infoPress infoPress = new infoPress();
	saveListener saveListener=new saveListener();
	loadListener loadListener= new loadListener();
	exitAppListener exitAppListener= new exitAppListener();
	careerListener careerListener=new careerListener();
	
	private Timer timer = new Timer(1000, new timerListener()); // time event listener
	GUI GUI;
	CrackerJacker CrackerJacker;

	Interface(GUI a, CrackerJacker b) {
		GUI = a;
		CrackerJacker = b;
		GUI.setGameBoard(CrackerJacker);
		setWelcomeListeners();
		//declare listeners for buttons that will never have their listener removed
		GUI.Exit.addActionListener(exitAppListener);
		GUI.Career.addActionListener(careerListener);
		GUI.JInfo.addActionListener(infoPress);
		GUI.Help.addActionListener(helpListener);
	}

	// ========================================================================================================================================
	// ========================================================================================================================================
	// LISTENERS LISTENERS LISTENERS LISTENERS
	// ========================================================================================================================================
	// ========================================================================================================================================

	
	
	public class gameListener implements ActionListener {
		/*
		 This is the main listener for the game. This listens for buttons presses and
		 append the appropriate value to the current guess and submits the guess once the player 
		 hits enter.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {

			JButton temp = (JButton) e.getSource();
			// acquires the input of the entered digit or direction

			if ((CrackerJacker.currentGuess.currentGuess).length() < (CrackerJacker.comboSize)
					&& (CrackerJacker.turnCount) < (CrackerJacker.guessLimit)) {
				// condition does not allow the string to be bigger then the
				// combination

				// switch updates the current guess string
			if(!CrackerJacker.isAnalysisMode){
				switch (temp.getText()) {
				case "0":
				case "1":
				case "2":
				case "3":
				case "4":
				case "5":
				case "6":
				case "7":
				case "8":
				case "9":
					(CrackerJacker.currentGuess.currentGuess).append(temp.getText());
					break;
				case "Up":
					(CrackerJacker.currentGuess.currentGuess).append("U");
					break;
				case "Down":
					(CrackerJacker.currentGuess.currentGuess).append("D");
					break;
				case "Left":
					(CrackerJacker.currentGuess.currentGuess).append("L");
					break;
				case "Right":
					(CrackerJacker.currentGuess.currentGuess).append("R");
					break;
				default:
					printUpdate();
					return;
				}
			}
			else
			{
				switch (temp.getText())
				{
				case "Left":
					CrackerJacker.incLeftCounter(true);
					break;
				case "Right":
					CrackerJacker.incLeftCounter(false);
				}
			}

				printUpdate();

			} // ends if

			else if ( (CrackerJacker.currentGuess.currentGuess).length() == CrackerJacker.comboSize
					&& temp.getText().equals("Enter")
					&& CrackerJacker.turnCount < CrackerJacker.guessLimit) {
				// process a completed guess

				// guessArray[turnCount].delete(0,comboSize);
				CrackerJacker.guessArray[CrackerJacker.turnCount] = CrackerJacker.currentGuess;

				// check the number of positions and digits correct
				CrackerJacker.getPosistions();

				CrackerJacker.currentGuess = new guess(); // clears out the current guess
				CrackerJacker.turnCount++;
				printUpdate();
				
			} else if ( (CrackerJacker.currentGuess.currentGuess).length() == CrackerJacker.comboSize
					&& !temp.getText().equals("Enter")) {
				// suggest user hit enter
			}

			else;

		} // ends actionPerformed

	} // ends numberListener2

	class timerListener implements ActionListener {
		// class acts as a listener for a timer that tells the user how long a safe has been in play
		@Override
		public void actionPerformed(ActionEvent e) {

			CrackerJacker.timeInSeconds--; // everytime the listener hits, count down 1 second

			if (CrackerJacker.timeInSeconds == 0
					&& CrackerJacker.timeInMinutes == 0) {
				// if the timer reaches 0, ends the game
				losingProtocol();

			} else if (CrackerJacker.timeInSeconds <= 0) {
				// if the seconds reach zero, decrements the minutes and reset seconds to 59
				CrackerJacker.timeInSeconds = 59;
				CrackerJacker.timeInMinutes--;
				printUpdate();
			} else {
				printUpdate();
			}

		} // ends actionPerformed
	} // ends timerListener

	public class difficultySelectionListener implements ActionListener {
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

			JButton temp = (JButton) e.getSource();
			// conditions check the button pushed and sets the appropriate
			// setting
			if (temp.getText().equals("Easy")) { // sets game to easy
													// 3 digits with no
													// direction
				CrackerJacker.difficulty = 1;
				CrackerJacker.comboSize = 3;
				CrackerJacker.guessLimit = 10;
				CrackerJacker.directions = 0;
				CrackerJacker.timeInSeconds = 0;
				CrackerJacker.timeInMinutes = 6;

			} else if (temp.getText().equals("PiggyBank")) { // sets game to
																// PiggyBank
																// level
																// 4 digits with
																// 1 directions
				CrackerJacker.difficulty = 2;
				CrackerJacker.comboSize = 4;
				CrackerJacker.guessLimit = 10;
				CrackerJacker.directions = 1;
				CrackerJacker.timeInSeconds = 0;
				CrackerJacker.timeInMinutes = 6;

			} else if (temp.getText().equals("KittyBank")) { // sets game to
																// KittyBank
																// Level
																// 4 digits with
																// 0 directions
				CrackerJacker.difficulty = 3;
				CrackerJacker.comboSize = 4;
				CrackerJacker.guessLimit = 10;
				CrackerJacker.directions = 0;
				CrackerJacker.timeInSeconds = 0;
				CrackerJacker.timeInMinutes = 6;
			} else if (temp.getText().equals("MotelSafe")) {
				// 5 Digits with 1 directions
				CrackerJacker.difficulty = 4;
				CrackerJacker.comboSize = 5;
				CrackerJacker.guessLimit = 10;
				CrackerJacker.directions = 1;
				CrackerJacker.timeInSeconds = 0;
				CrackerJacker.timeInMinutes = 6;

			} else if (temp.getText().equals("HotelSafe")) { // 5 Digits with 0
																// direction
				CrackerJacker.difficulty = 5;
				CrackerJacker.comboSize = 5;
				CrackerJacker.guessLimit = 10;
				CrackerJacker.directions = 0;
				CrackerJacker.timeInSeconds = 0;
				CrackerJacker.timeInMinutes = 6;
			} else if (temp.getText().equals("Hard")) {
				// 6 Digits with 2 directions
				CrackerJacker.difficulty = 6;
				CrackerJacker.comboSize = 6;
				CrackerJacker.guessLimit = 9;
				CrackerJacker.directions = 2;
				CrackerJacker.timeInSeconds = 0;
				CrackerJacker.timeInMinutes = 5;
			} else if (temp.getText().equals("Chinese")) {
				// 6 directions
				CrackerJacker.difficulty = 7;
				CrackerJacker.comboSize = 6;
				CrackerJacker.guessLimit = 8; // 8 is significant to astern
												// culture
				CrackerJacker.directions = 6;
				CrackerJacker.timeInSeconds = 0;
				CrackerJacker.timeInMinutes = 5;
			} else if (temp.getText().equals("BankHeist")) {
				// 6 Digits with 0 directions
				CrackerJacker.difficulty = 8;
				CrackerJacker.comboSize = 6;
				CrackerJacker.guessLimit = 9;
				CrackerJacker.directions = 0;
				CrackerJacker.timeInSeconds = 0;
				CrackerJacker.timeInMinutes = 5;
			} else if (temp.getText().equals("JewelHeist")) {
				// 7 Digits with 3 directions
				CrackerJacker.difficulty = 9;
				CrackerJacker.comboSize = 7;
				CrackerJacker.guessLimit = 9;
				CrackerJacker.directions = 3;
				CrackerJacker.timeInSeconds = 0;
				CrackerJacker.timeInMinutes = 5;
			} else if (temp.getText().equals("Museum")) {
				// 7 Digits with 2 directions
				CrackerJacker.difficulty = 10;
				CrackerJacker.comboSize = 7;
				CrackerJacker.guessLimit = 9;
				CrackerJacker.directions = 2;
				CrackerJacker.timeInSeconds = 0;
				CrackerJacker.timeInMinutes = 5;
			} else if (temp.getText().equals("Extreme")) {
				// 8 Digits with 3 directions
				CrackerJacker.difficulty = 11;
				CrackerJacker.comboSize = 8;
				CrackerJacker.guessLimit = 9;
				CrackerJacker.directions = 3;
				CrackerJacker.timeInSeconds = 0;
				CrackerJacker.timeInMinutes = 5;
			} else if (temp.getText().equals("FedHeist")) {
				// 8 Digits with 2 directions
				CrackerJacker.difficulty = 12;
				CrackerJacker.comboSize = 8;
				CrackerJacker.guessLimit = 8;
				CrackerJacker.directions = 2;
				CrackerJacker.timeInSeconds = 0;
				CrackerJacker.timeInMinutes = 5;
			} else if (temp.getText().equals("Oceans666")) { // 8 Digits with 1
																// directions
				CrackerJacker.difficulty = 13;
				CrackerJacker.comboSize = 8;
				CrackerJacker.guessLimit = 8;
				CrackerJacker.directions = 1;
				CrackerJacker.timeInSeconds = 0;
				CrackerJacker.timeInMinutes = 5;
			} else if (temp.getText().equals("KingPin")) {
				// 10 Digits with 0 directions
				CrackerJacker.difficulty = 100;
				CrackerJacker.comboSize = 10;
				CrackerJacker.guessLimit = 7;
				CrackerJacker.directions = 0;
				CrackerJacker.timeInSeconds = 0;
				CrackerJacker.timeInMinutes = 5;
			} else
				return;
			CrackerJacker.makeCombo();
			setGameListener(); // sets the buttons to game mode

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
			setDifficultyListeners();// method sets the needed button text and
										// listeners

		}
	}

	public class exitRound implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Transitions from the end of a game to the select difficulty screen
			CrackerJacker.isWinner = false;
			GUI.requestDifficulty();
			setDifficultyListeners();
		}
	}

	public class exitGame implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// When the game is over, take the player back to the welcome screen
			setWelcomeListeners();
		}
	}

	public class helpListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) { 
			// brings up a box to help explain the game to the player
			GUI.setHelpText();
		}
	}

	public class clearGuess implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// listener clears the digits on the current guess by clearing currentGuess
			try {
				if (!CrackerJacker.isWinner) // only allows the guess to be cleared if the game hasn't already been won
				{
					CrackerJacker.currentGuess.currentGuess = new StringBuilder();
					printUpdate();
				} else;
			}
			// ends try
			catch (StringIndexOutOfBoundsException ex) {
				// does nothing if there is a StringIndexOutOfBoundsException
				// this type of error occurs if somebody hits backspace or clear
				// at the wrong time

			} // ends catch
		}
	}

	public class backSpace implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) { // clears the most recent
														// digit on the current
														// guess
			try {
				int deleteCharLocation = (CrackerJacker.currentGuess.currentGuess).length() - 1;
				(CrackerJacker.currentGuess.currentGuess).deleteCharAt(deleteCharLocation);
				printUpdate();
			} catch (StringIndexOutOfBoundsException ex) { 
				// does nothing if there is a StringIndexOutOfBoundsException
				// this type of error occurs if  somebody hits backspace or clear
			}

		}
	}

	public class proShopListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			proShop();

		}
	}

	public class cheatListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton hold = (JButton) e.getSource();

			if (hold.getText().contains("TNT")) {
				if (CrackerJacker.loot > 4500) {
					CrackerJacker.loot -= 4500;
					CrackerJacker.explosives++;

					GUI.buyStatus(true, "TNT");
				} else { // display message telling user that they don't have enough money
					GUI.buyStatus(false, "Nothing");

				}

			} else if (hold.getText().contains("Snips")) {
				if (CrackerJacker.loot > 3000) {
					CrackerJacker.loot -= 3000;
					CrackerJacker.snips++;
					GUI.buyStatus(true, "Snips");
				} else {
					// display a message telling the user that they don't have
					// enough money
					GUI.buyStatus(false, "Nothing");

				}
			} else if (hold.getText().contains("Picks")) {
				if (CrackerJacker.loot > 3500) {
					CrackerJacker.loot -= 3500;
					CrackerJacker.picks++;
					GUI.buyStatus(true, "Picks");
				} else {
					// display a message telling the user that they don't have
					// enough money
					GUI.buyStatus(false, "Nothing");

				}
			} // ends else if

		}
	}

	public class keyListener implements KeyListener {

		public void keyTyped(KeyEvent e) {
			// press appropriate button based on the key typed

		//	StringBuilder holdString = new StringBuilder(e.getKeyChar());

			switch(e.getKeyChar())
			{
			case KeyEvent.VK_0: GUI.J0.doClick(); break;
			case KeyEvent.VK_1: GUI.J1.doClick(); break;
			case KeyEvent.VK_2: GUI.J2.doClick(); break;
			case KeyEvent.VK_3: GUI.J3.doClick(); break;
			case KeyEvent.VK_4: GUI.J4.doClick(); break;
			case KeyEvent.VK_5: GUI.J5.doClick(); break;
			case KeyEvent.VK_6: GUI.J6.doClick(); break;
			case KeyEvent.VK_7: GUI.J7.doClick(); break;
			case KeyEvent.VK_8: GUI.J8.doClick(); break;
			case KeyEvent.VK_9: GUI.J9.doClick(); break;
			
			case KeyEvent.VK_C: GUI.JClear.doClick(); break;
			case KeyEvent.VK_H: GUI.Help.doClick(); break;
			case KeyEvent.VK_L: GUI.Load.doClick(); break;
			case KeyEvent.VK_P: GUI.JPicks.doClick(); break;
			case KeyEvent.VK_S: GUI.Save.doClick(); break;
			case KeyEvent.VK_X: GUI.JTNT.doClick(); break;
			
			case KeyEvent.VK_ENTER: GUI.JEnter.doClick(); break;
			case KeyEvent.VK_BACK_SPACE: GUI.JBackSpace.doClick(); break;
			
			
			}

		}

		public void keyPressed(KeyEvent e) { // do nothing
			
			switch(e.getKeyCode())
			{
			case KeyEvent.VK_UP: GUI.JUp.doClick(); break;
			case KeyEvent.VK_DOWN: GUI.JDown.doClick(); break;
			case KeyEvent.VK_LEFT: GUI.JLeft.doClick(); break;
			case KeyEvent.VK_RIGHT: GUI.JRight.doClick(); break;
			
			case KeyEvent.VK_H: GUI.Help.doClick(); break;
			case KeyEvent.VK_P: GUI.JPicks.doClick(); break;
			case KeyEvent.VK_S: GUI.JSnips.doClick(); break;
			case KeyEvent.VK_X: GUI.JTNT.doClick(); break;
		
			case KeyEvent.VK_CONTROL: CrackerJacker.toggleAnalysis(); break;
			case KeyEvent.VK_ESCAPE: GUI.Exit.doClick();
			
			}

		}

		public void keyReleased(KeyEvent e) { // do nothing

		}
	} // ends key Listener

	public class keyListener2 implements KeyListener {
		// listener is used for the proshop

		public void keyTyped(KeyEvent e) {

			if ((int) e.getKeyChar() == 10) {

				// triggers the enter button when the enter button is clicked
				GUI.JEnter.doClick();
			}
		}

		public void keyPressed(KeyEvent e) {

		}

		public void keyReleased(KeyEvent e) {

		}
	}

	public class applyCheat implements ActionListener {
		// listener is responsible for applying cheats from the proshop to the game

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton hold = (JButton) e.getSource();

			if (hold.getText().contains("TNT")) {
		    // apply an explosive charge to the safe that may crack the safe or may call the cops
				// Success rate should be about 75% on easy and medium levels, and 45% for harder level

				CrackerJacker.explosives--;

				if (CrackerJacker.difficulty < 10) {
					// select success for easy and medium difficulties 0-9
					int rand = (int) (Math.random() * 4);

					if (rand > 0)
						winningProtocol(); // wins if the random number is 1 or more
					else
						losingProtocol();
					// otherwise it is a loser
				} 
				else {
					// selects success for harder level
					int rand = (int) (Math.random() * 101);

					if (rand <= 45)
						winningProtocol();
					else
						losingProtocol();
				} 
			} 

			else if (hold.getText().contains("Snips")) { // delay the cops by
															// adding time and
															// guesses
				CrackerJacker.timeInMinutes++;
				CrackerJacker.guessLimit += 2;
				CrackerJacker.snips--;
				printUpdate();

			} else if (hold.getText().contains("Lock Pick")) { // Remove a digit
																// from the
																// combo, make
																// it random
				CrackerJacker.picks--;
				int rand = (int) (Math.random() * (CrackerJacker.combo.length() + 1));
				// picks a random spot in the char to delete
				CrackerJacker.combo.deleteCharAt(rand); // applies the delete
				CrackerJacker.directions = 0;

				for (int i = 0; i < CrackerJacker.combo.length(); i++) // loop recounts the number of directions in the combo
				{

					if (CrackerJacker.combo.charAt(i) == 'U'
							|| CrackerJacker.combo.charAt(i) == 'D'
							|| CrackerJacker.combo.charAt(i) == 'L'
							|| CrackerJacker.combo.charAt(i) == 'R') {
						CrackerJacker.directions++;
					}
				} 

				CrackerJacker.comboSize = CrackerJacker.combo.length();
				printUpdate();

			}
		}
	}

	public class infoPress implements ActionListener { 
		// opens a window to identify special information about the creation of this program
		@Override
		public void actionPerformed(ActionEvent e) {
			GUI.setInfoText();
		}
	} 

	public class saveListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			//Save a carrer file, or update a carrer file if it already exists
			try {
				saveFile();
			} 
			catch (FileNotFoundException e1) {
			
			} 
			catch (IOException e1) {
		
			}
		}
	}
	
	public class loadListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			try {
				loadFile();
			} catch (FileNotFoundException e1) {
				GUI.setLoadFailed();
			} catch (IOException e1) {
				GUI.setLoadFailed();
			} catch (ClassNotFoundException e1) {
				GUI.setLoadFailed();
			}
			catch(NullPointerException e1)
			{
	
			}
			
		}
	}
	
	public class exitAppListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			GUI.terminate();
		}
	}
	
	public class careerListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			GUI.setCareer();
		}
	}

	// ===================================================
	// METHODS
	// ===========================================

	public void setDifficultyListeners() {
		// Sets the numbers1 listener to the digits and directions, that will
		// allow the user to select the difficulty
		
		clearListeners();
	//	GUI.setButtonListener("0",difficultyListener);
		(GUI.J0).addActionListener(difficultyListener);
		(GUI.J1).addActionListener(difficultyListener);
		(GUI.J2).addActionListener(difficultyListener);
		(GUI.J3).addActionListener(difficultyListener);
		(GUI.J4).addActionListener(difficultyListener);
		(GUI.J5).addActionListener(difficultyListener);
		(GUI.J6).addActionListener(difficultyListener);
		(GUI.J7).addActionListener(difficultyListener);
		(GUI.J8).addActionListener(difficultyListener);
		(GUI.J9).addActionListener(difficultyListener);
		(GUI.JUp).addActionListener(difficultyListener);
		(GUI.JDown).addActionListener(difficultyListener);
		(GUI.JLeft).addActionListener(difficultyListener);
		(GUI.JRight).addActionListener(difficultyListener);
		(GUI.JEnter).addActionListener(difficultyListener);
		(GUI.Save).addActionListener(saveListener);
		(GUI.Load).addActionListener(loadListener);
		// the backSpaceListener so there are no issue with selecting a level
		(GUI.JEnter).removeActionListener(exitRound1); // removes the exitGame
		// listener which prevents a bug from occuring when a player doesn't
		// enter enough digits
		
		GUI.setDifficultyListener();
		
		setProShopButton();
		setToolButtons(false);

		
	}

	private void setGameListener() {

		// remove the difficulty phase listeners
		clearListeners();

		// register listeners with buttons
		GUI.J0.addActionListener(gameListener);
		GUI.J1.addActionListener(gameListener);
		GUI.J2.addActionListener(gameListener);
		GUI.J3.addActionListener(gameListener);
		GUI.J4.addActionListener(gameListener);
		GUI.J5.addActionListener(gameListener);
		GUI.J6.addActionListener(gameListener);
		GUI.J7.addActionListener(gameListener);
		GUI.J8.addActionListener(gameListener);
		GUI.J9.addActionListener(gameListener);
		GUI.JUp.addActionListener(gameListener);
		GUI.JDown.addActionListener(gameListener);
		GUI.JLeft.addActionListener(gameListener);
		GUI.JRight.addActionListener(gameListener);
		GUI.JEnter.addActionListener(gameListener);
		GUI.JBackSpace.addActionListener(backSpaceListener);
		GUI.JClear.addActionListener(clearListener);

		//GUI.Save.removeActionListener(saveListener);
		//GUI.Load.removeActionListener(loadListener);
		GUI.mainWindow.requestFocus();
		GUI.setGameText();

		// show tools if they are available,
		setToolButtons(true);

		timer.start();
		printUpdate();

	}

	public void printUpdate() {

		// method is responsible for updating the board during the guessing phase
		// it is called by the numberListener and hits under certain conditions

		if (CrackerJacker.isWinner) {
			winningProtocol();
			CrackerJacker.turnCount = 0;
			// currentGuess may need to be cleared here
		} else if (CrackerJacker.turnCount == CrackerJacker.guessLimit) {
			losingProtocol();
			CrackerJacker.turnCount = 0;
		} else {
			GUI.printUpdate();
					
			// update the tool buttons
			setToolButtons(true);
		}

		GUI.mainWindow.requestFocus();
	}

	public void losingProtocol() {
		timer.stop();

		CrackerJacker.bail = 500; // holder value, 500 is the default/ minimum bail out value
		CrackerJacker.bail *= CrackerJacker.wantedLevel
				* CrackerJacker.difficulty; // sets the amount to bail out
		// check if the player has enough to bail out
		if (CrackerJacker.bail > CrackerJacker.loot) 
		{
			// initiate the end of game protocol
			GUI.setGameOver();
			gameOverProtocol();
			
		} 
		else
		{

			CrackerJacker.loot -= CrackerJacker.bail; // subtracts the bail out from loot

			GUI.topText.setBackground(Color.RED);
			GUI.topText.setText("		Loot:  $" + CrackerJacker.loot
				+ "     Wanted Level: " + CrackerJacker.wantedLevel
				+ "      Break-Ins: " + CrackerJacker.totalBreakIns + "\n"
				+ "\n" + "    	    Busted!" + "\n"
				+ "         You Failed To Crack The Safe" + "\n"
				+ "         You Bailed Out $" + CrackerJacker.bail + "\n"
				+ "         Hit Enter To Case Out Your Next Target");
		
		GUI.JBackSpace.setForeground(Color.LIGHT_GRAY);
		GUI.JClear.setForeground(Color.LIGHT_GRAY);
		GUI.Load.setForeground(Color.BLACK);
		GUI.Save.setForeground(Color.BLACK);
			
		// sets listeners for the transition from the end of the game to the difficulty selection	
		clearListeners();
		
		
		GUI.JEnter.addActionListener(exitRound1);
		GUI.Save.addActionListener(saveListener);
		GUI.Load.addActionListener(loadListener);
		setProShopButton();
		setToolButtons(false);

		CrackerJacker.currentGuess.posistionsCorrect = 0;
		CrackerJacker.currentGuess.digitsCorrect = 0;
		}
	}

	public void winningProtocol() {
		timer.stop();

		CrackerJacker.payout = (int) (Math.random() * 1000)
				* CrackerJacker.difficulty;
		CrackerJacker.loot += CrackerJacker.payout;
		CrackerJacker.totalBreakIns++;
		CrackerJacker.wantedLevel();

		GUI.topText.setBackground(Color.GREEN);
		GUI.topText.setText("		Loot:  $" + CrackerJacker.loot
				+ "     Wanted Level: " + CrackerJacker.wantedLevel
				+ "      Break-Ins: " + CrackerJacker.totalBreakIns + "\n"
				+ "\n" + "         Nice!  You Cracked The Safe" + "\n"
				+ "         You \"Found\"  $" + CrackerJacker.payout + "\n"
				+ "         Hit Enter To Case Out Your Next Target");

		CrackerJacker.turnCount = 0;
		
		GUI.JBackSpace.setForeground(Color.LIGHT_GRAY);
		GUI.JClear.setForeground(Color.LIGHT_GRAY);
		GUI.Save.setForeground(Color.BLACK);
		GUI.Load.setForeground(Color.BLACK);
		
		// sets listeners for the transition from the end of the game to the difficulty selection
		clearListeners();

		GUI.JEnter.addActionListener(exitRound1);
		GUI.Save.addActionListener(saveListener);
		GUI.Load.addActionListener(loadListener);
		//set pro shop button
		setProShopButton();
		setToolButtons(false);

		CrackerJacker.currentGuess.posistionsCorrect = 0;
		CrackerJacker.currentGuess.digitsCorrect = 0;

	}

	public void setWelcomeListeners() {
		clearListeners();
		(GUI.JEnter).addActionListener(exitWelcome);
		(GUI.Help).addActionListener(helpListener); // note the button "Help" is capitalized, while the listener is lowercase
		(GUI.JInfo).addActionListener(infoPress);
		(GUI.mainWindow).setFocusable(true); // sets the main window to  focusable
		(GUI.mainWindow).requestFocus(); // requests focus for the main window
		(GUI.mainWindow).setFocusTraversalKeysEnabled(false); // keeps focus from shifting away
		(GUI.mainWindow).addKeyListener(keyBoardListener); // registers the keyListener for the game
		GUI.Save.addActionListener(saveListener);
		GUI.Load.addActionListener(loadListener);
		GUI.welcomeScreen();
		setProShopButton();
		setToolButtons(false);
	}
	public void gameOverProtocol() {
		// When the game is over, the only button the user will have a is  restart button
		CrackerJacker.career=false; //career is over
		clearListeners();
		GUI.J7.addActionListener(exitGame);

	}

	public void proShop() {

		clearListeners();
	
		// register listeners with buttons
		GUI.J0.addActionListener(cheatListener);
		GUI.J1.addActionListener(cheatListener);
		GUI.J2.addActionListener(cheatListener);
		GUI.JEnter.addActionListener(exitRound1);

		GUI.setProShopText();

	}

	public void clearListeners()
	{
		JButton[] buttonArr={GUI.J0,GUI.J1,GUI.J2,GUI.J3,GUI.J4,GUI.J5,GUI.J6,GUI.J7,GUI.J8,GUI.J9,
				GUI.JTNT,GUI.JSnips,GUI.JStore,GUI.JPicks,GUI.JBackSpace,
				GUI.JClear,GUI.JEnter,GUI.JUp,GUI.JDown,GUI.JLeft,GUI.JRight,GUI.Save,GUI.Load
				
		};
		
		
		for(int i=0; i<buttonArr.length; i++)
		{
			ActionListener[] arr=buttonArr[i].getActionListeners();
			for (int j=0; j<arr.length; j++)
			{
				buttonArr[i].removeActionListener(arr[j]);
			}
		}
	}

	public void saveFile() throws FileNotFoundException, IOException
	{
		//if a career is still active, it can be saved. Otherwise it can only be saved if the 
		// if the .cjx file already exists. If the file doesn't exist allow the player to select a save location
		
		player player=new player(CrackerJacker.loot, CrackerJacker.totalBreakIns,CrackerJacker.wantedLevel,
				CrackerJacker.explosives,CrackerJacker.snips,CrackerJacker.picks, CrackerJacker.career);
		
		ObjectOutputStream output;//= new ObjectOutputStream(new FileOutputStream("save.dat"));
		if(CrackerJacker.career)
		{
			// if the career is still alive, it can be saved regardless
			if(CrackerJacker.career_file!="")
			{
				//save to the location indicated by career_file
				output=new ObjectOutputStream(new FileOutputStream(CrackerJacker.career_file));
				output.writeObject(player);
				output.close();
				GUI.setSaveConfirm();
			}
			else
			{
				//allow the user to select a save location
				LocalDateTime t=LocalDateTime.now();
				Integer n=t.getYear();
				CrackerJacker.career_file+=n.toString();
			    n=(t.getDayOfYear());
				CrackerJacker.career_file+=n.toString();
				n=t.getHour();
				CrackerJacker.career_file+=n.toString();
				n=t.getMinute();
				CrackerJacker.career_file+=n.toString();
				n=t.getSecond();
				CrackerJacker.career_file+=".cjx";
				
				//CrackerJacker.career_file=LocalDateTime.now().toString()+".cjx";
			//	System.out.println(CrackerJacker.career_file);
				//output=new ObjectOutputStream(new FileOutputStream(CrackerJacker.career_file));
				//output.writeObject(player);
				//output.close();
				//GUI.setSaveConfirm();
				
				Path path=Paths.get(CrackerJacker.career_file);
				//Files.write(path, 0, Charset.forName("UTF-8"));
				Files.createFile(path);
				saveFile();
			}
			}
		else
		{
			//if the career is over, it can only be saved to an existing save file
			if(CrackerJacker.career_file!="")
			{
				//save the file
				output=new ObjectOutputStream(new FileOutputStream(CrackerJacker.career_file));
				output.writeObject(player);
				output.close();
			}
			else
			{
				//do nothing
			}
			
		}
		
		
		}

	public void loadFile() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		
			GUI.openFileSelector();
			
			ObjectInputStream input= new ObjectInputStream(new FileInputStream(CrackerJacker.career_file));
			Object a;
			a=input.readObject();
			input.close();
			player p=(player)a;
			CrackerJacker.setPlayer(p);
			//GUI=new GUI();
			setDifficultyListeners();
			GUI.setDifficultyListener();
		
		
	}
	
	public void setProShopButton()
	{
		//the proshop will be available when the player has 3 or more broeken safes and is not is guess mode
		if (CrackerJacker.totalBreakIns >= 3) {
			GUI.JStore.addActionListener(proShopListener);
			GUI.setProShopButton(true);
		} else {
			GUI.JStore.removeActionListener(proShopListener);
			GUI.setProShopButton(false);
		}
		
		
	}

	public void setToolButtons(boolean gamePhase)
	{
		//tool buttons will show the number of available tool during the guessing phase
		//otherwise they will be grayed out
		if(gamePhase && CrackerJacker.explosives>0)
		{
			GUI.JTNT.addActionListener(applyCheat);
		}
		else 
		{
			GUI.JTNT.removeActionListener(applyCheat);
		}
		
		if(gamePhase && CrackerJacker.snips>0)
		{
			GUI.JSnips.addActionListener(applyCheat);
		}
		else 
		{
			GUI.JSnips.removeActionListener(applyCheat);
		}
		
		if(gamePhase && CrackerJacker.picks>0)
		{
			GUI.JPicks.addActionListener(applyCheat);
		}
		else 
		{
			GUI.JPicks.removeActionListener(applyCheat);
		}
		
		GUI.setToolButtons(gamePhase);
	}
}
