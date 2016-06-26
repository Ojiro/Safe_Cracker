import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GUI extends JFrame {

	final short Standard_Button_Height=50;
	final short Standard_Button_Width=100;
	final short Secondary_Button_Height=50;
	final short Secondary_Button_Width=200;
	
	final short Column_1=25;
	final short Column_2=125;
	final short Column_3=225;
	final short Column_4=325;
	final short Column_5=425;
	
	final short Row_1=200;
	final short Row_2=250;
	final short Row_3=300;
	final short Row_4=350;
	
	static JFrame mainWindow = new JFrame("GigaCracker");
	static JFrame helpWindow = new JFrame("How To");
	static JPanel p0 = new JPanel();
	// create JButtons that act as input

	// These buttons act as basic inputs, numbers and directions for the game
	static JButton J0 = new JButton("");
	static JButton J1 = new JButton("");
	static JButton J2 = new JButton("");
	static JButton J3 = new JButton("");
	static JButton J4 = new JButton("");
	static JButton J5 = new JButton("");
	static JButton J6 = new JButton("");
	static JButton J7 = new JButton("");
	static JButton J8 = new JButton("");
	static JButton J9 = new JButton("");
	static JButton JUp = new JButton("");
	static JButton JDown = new JButton("");
	static JButton JLeft = new JButton("");
	static JButton JRight = new JButton("");
	static JButton JEnter = new JButton("Enter"); // allow the player to advance
													// through the game and
													// enter guesses
	static JButton JClear = new JButton("");
	static JButton JBackSpace = new JButton("");
	static JButton JInfo = new JButton("Info");

	// Extra buttons for cheats
	static JButton JStore = new JButton("Pro Shop");
	static JButton JTNT = new JButton("-");
	static JButton JSnips = new JButton("-");
	static JButton JPicks = new JButton("-");

	// create JButtons for help, referred to as helper buttons throughout the
	// program
	static JButton Help = new JButton("How To"); // opens a box on how to play
	static JButton Load = new JButton("Load");
	static JButton Save = new JButton("Save");
	static JTextArea topText = new JTextArea();
	// JTextArea bottomText= new JTextArea();
	static JLabel name = new JLabel("Cracker-Jacker 5000 DLX");

	 GUI() {
		// instantiate a new game board
		mainWindow.setSize(775, 500);
		p0.setSize(750, 500);
		p0.setLocation(0, 0);
		mainWindow.setLayout(null);
		p0.setLayout(null);

		topText.setSize(650, 150);
		topText.setLocation(25, 25);
		topText.setEditable(false);

		name.setSize(250, 25);
		name.setLocation(250, 0);

		// set size and Location of buttons and object
		J0.setSize(Standard_Button_Width, Standard_Button_Height);
		J1.setSize(Standard_Button_Width, Standard_Button_Height);
		J2.setSize(Standard_Button_Width, Standard_Button_Height);
		J3.setSize(Standard_Button_Width, Standard_Button_Height);
		J4.setSize(Standard_Button_Width, Standard_Button_Height);
		J5.setSize(Standard_Button_Width, Standard_Button_Height);
		J6.setSize(Standard_Button_Width, Standard_Button_Height);
		J7.setSize(Standard_Button_Width, Standard_Button_Height);
		J8.setSize(Standard_Button_Width, Standard_Button_Height);
		J9.setSize(Standard_Button_Width, Standard_Button_Height);
		JUp.setSize(Standard_Button_Width, Standard_Button_Height);
		JDown.setSize(Standard_Button_Width, Standard_Button_Height);
		JLeft.setSize(Standard_Button_Width, Standard_Button_Height);
		JRight.setSize(Standard_Button_Width, Standard_Button_Height);
		JEnter.setSize(100, 100);
		JClear.setSize(Secondary_Button_Width, Secondary_Button_Height);
		JBackSpace.setSize(Secondary_Button_Width, Secondary_Button_Height);
		Help.setSize(Standard_Button_Width, Standard_Button_Height);;
		Load.setSize(Standard_Button_Width, Standard_Button_Height);
		Save.setSize(Standard_Button_Width, Standard_Button_Height);
		JStore.setSize(Standard_Button_Width, Standard_Button_Height);
		JTNT.setSize(Standard_Button_Width, Standard_Button_Height);
		JSnips.setSize(Standard_Button_Width, Standard_Button_Height);
		JPicks.setSize(Standard_Button_Width, Standard_Button_Height);
		JInfo.setSize(Standard_Button_Width, Standard_Button_Height);

		J0.setLocation(Column_1, Row_1);
		J1.setLocation(Column_2, Row_1);
		J2.setLocation(Column_3, Row_1);
		J3.setLocation(Column_4, Row_1);
		J4.setLocation(Column_5, Row_1);
		J5.setLocation(Column_1, Row_2);
		J6.setLocation(Column_2, Row_2);
		J7.setLocation(Column_3, Row_2);
		J8.setLocation(Column_4, Row_2);
		J9.setLocation(Column_5, Row_2);
		JUp.setLocation(Column_1, Row_3);
		JDown.setLocation(Column_2, Row_3);
		JLeft.setLocation(Column_3, Row_3);
		JRight.setLocation(Column_4, Row_3);
		JEnter.setLocation(Column_5, Row_3);
		JClear.setLocation(Column_3, 350);
		JBackSpace.setLocation(Column_1, 350);
		Help.setLocation(550, 200);
		JStore.setLocation(650, 200);
		Load.setLocation(550, 250);
		Save.setLocation(650, 250);
		JTNT.setLocation(550, 300);
		JPicks.setLocation(550, 350);
		JSnips.setLocation(550, 400);
		JInfo.setLocation(650, 400);
		JStore.setForeground(Color.LIGHT_GRAY);
		JTNT.setForeground(Color.LIGHT_GRAY);
		JPicks.setForeground(Color.LIGHT_GRAY);
		JSnips.setForeground(Color.LIGHT_GRAY);
		
		welcomeScreen();
		JStore.setVisible(true);
		mainWindow.setVisible(true); // turn the mainWindow visible
		//hideButtons();  // Consider removing this method 
		JEnter.setVisible(true);
		JInfo.setVisible(true);
	}

	public void welcomeScreen() {
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

		welcomeText();
	}

	// #1
	// welcomeText
	//
	private void welcomeText() {
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
				+ "\n" + "For more information, click how to" + "\n"
				+ "To play, click enter");

		p0.add(topText);

	}

	// #18
	// setDifficultyListener
	// sets the listeners for the select difficulty selection phase of the game
	public void setDifficultyListener() {

		// Interface.setDifficultyListeners();
		// Reset the text on the buttons
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

		// hideButtons();
		// hideTools();
		JClear.setForeground(Color.LIGHT_GRAY);
		JBackSpace.setForeground(Color.LIGHT_GRAY);

		// tools are off during this phase
		if ((CrackerJacker.explosives) > 0) {
			JTNT.setText("TNT (" + (CrackerJacker.explosives) + "x)");
			JTNT.setForeground(Color.LIGHT_GRAY);
		} else {
			JTNT.setText("-");
			JTNT.setForeground(Color.LIGHT_GRAY);
		}
		if ((CrackerJacker.picks) > 0) {
			JPicks.setText("Picks (" + (CrackerJacker.picks) + "x)");
			JPicks.setForeground(Color.LIGHT_GRAY);
		} else {
			JPicks.setText("-");
			JPicks.setForeground(Color.LIGHT_GRAY);
		}
		if ((CrackerJacker.snips) > 0) {
			JSnips.setText("Snips (" + (CrackerJacker.snips) + "x)");
			JSnips.setForeground(Color.LIGHT_GRAY);
		} else {
			JSnips.setText("-");
			JSnips.setForeground(Color.LIGHT_GRAY);
		}

		/*
		 * // show the proshop to the player if they have more than 3 break-ins
		 * if((TeraCracker.totalBreakIns)>=3) // makes the pro shop available if
		 * the player has broken enough safes {
		 * JStore.addActionListener(proShopListener);
		 * JStore.setText("Pro Shop"); } else {
		 * 
		 * JStore.removeActionListener(proShopListener); }
		 */

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

	// #2
	// requestDifficulty
	// Receives the desired difficulty of the next safe from the user
	// also prints an update for the user between games
	public static void requestDifficulty() {
		// be very careful in changing the spacing of the text here, it takes a
		// lot of work to line these up properly
		topText.setBackground(Color.WHITE);
		topText.setText("		Loot:  $"
				+ (CrackerJacker.loot)
				+ "     Wanted Level: "
				+ (CrackerJacker.wantedLevel)
				+ "      Break-Ins: "
				+ (CrackerJacker.totalBreakIns)
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
				+ "\n" + "");

	}

	//
	//setGameText
	public static void setGameText()
	{
		// set text to guess mode
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
				if (CrackerJacker.totalBreakIns >= 3) {
					JStore.setText("Pro Shop");
					JStore.setForeground(Color.LIGHT_GRAY);
					JStore.setVisible(true);
				} else {
					JStore.setVisible(false);
				}

				// show tools if they are available,
				if (CrackerJacker.explosives > 0) {
					JTNT.setText("TNT (" + CrackerJacker.explosives + "x)");
					//JTNT.addActionListener(applyCheat);
				} else {
					JTNT.setText("-");
					JTNT.setForeground(Color.LIGHT_GRAY);
					//JTNT.removeActionListener(applyCheat);
				}

				if (CrackerJacker.snips > 0) {
					JSnips.setText("Snips (" + CrackerJacker.snips + "x)");
					//JSnips.addActionListener(applyCheat);
				} else {
					JSnips.setText("-");
					JSnips.setForeground(Color.LIGHT_GRAY);
					//JSnips.removeActionListener(applyCheat);
				}

				if (CrackerJacker.picks > 0) {
					JPicks.setText("Picks (" + CrackerJacker.picks + "x)");
					//GUI.JPicks.addActionListener(applyCheat);
				} else {
					JPicks.setText("-");
					JPicks.setForeground(Color.LIGHT_GRAY);
					//JPicks.removeActionListener(applyCheat);
				}

				//
				GUI.topText.setText("		Loot:  " + CrackerJacker.loot
						+ "     Wanted Level: " + CrackerJacker.wantedLevel
						+ "      Break-Ins: " + CrackerJacker.totalBreakIns);
				// bottomText.setText("");
	
	}
	
	
	//
	// buyStatus
	// method prints an update for a the user when they try to buy something in the proshop
			public void buyStatus(boolean sucessful, String item)
			{
				if (!sucessful)
				{
					// informers the user they couldn't but their item
					topText.setText("		Loot:  $" + CrackerJacker.loot + "     Wanted Level: " + CrackerJacker.wantedLevel+ "      Break-Ins: " + CrackerJacker.totalBreakIns
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
					
					topText.setText("		Loot:  $" + CrackerJacker.loot + "     Wanted Level: " + CrackerJacker.wantedLevel+ "      Break-Ins: " + CrackerJacker.totalBreakIns
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
				if (CrackerJacker.explosives>0)
				{
					JTNT.setText("TNT (" + CrackerJacker.explosives + "x)");
					JTNT.setForeground(Color.GRAY);
				}
				if (CrackerJacker.picks>0)
				{
					JPicks.setText("Picks (" + CrackerJacker.picks + "x)");
					JPicks.setForeground(Color.GRAY);
				}
				if (CrackerJacker.snips>0)
				{
					JSnips.setText("Snips (" + CrackerJacker.snips + "x)");
					JSnips.setForeground(Color.GRAY);
				}
			} // ends buy status
	
}
