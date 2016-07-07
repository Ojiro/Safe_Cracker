import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.event.*;
import java.io.File;
import java.io.FileFilter;


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
	final short Column_6=550;
	final short Column_7=650;
	
	final short Row_1=200;
	final short Row_2=250;
	final short Row_3=300;
	final short Row_4=350;
	final short Row_5=400;
	
	JFrame mainWindow = new JFrame("GigaCracker");
	JFrame helpWindow = new JFrame("How To");
	JPanel p0 = new JPanel();

	//Buttons that will allow for regular play (0-9, directions...)
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
	JButton JEnter = new JButton("Enter"); 
	
	JButton JClear = new JButton("");
	JButton JBackSpace = new JButton("");
	JButton JInfo = new JButton("Info");
	JButton Exit=new JButton("Exit");
	JButton Career=new JButton("Career");

	// Extra buttons for cheats
	JButton JStore = new JButton("Pro Shop");
	JButton JTNT = new JButton("-");
	JButton JSnips = new JButton("-");
	JButton JPicks = new JButton("-");

	// create JButtons for help, referred to as helper buttons throughout the program
	JButton Help = new JButton("How To"); // opens a box on how to play
	JButton Load = new JButton("Load");
	JButton Save = new JButton("Save");
	
	//display area
	JTextArea topText = new JTextArea();
	JLabel name = new JLabel("Cracker-Jacker 5000 DLX");

	CrackerJacker CrackerJacker;
	 GUI() {
		// instantiate a new game board
		mainWindow.setSize(775, 500);
		p0.setSize(750, 500);
		p0.setLocation(0, 0);
		mainWindow.setLayout(null);
		p0.setLayout(null);
		
		Color a=new Color(0,153,51);
		topText.setBorder(BorderFactory.createLineBorder(Color.black));
		mainWindow.getContentPane().setBackground(a);
		p0.setBackground(a);
		
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
		Exit.setSize(Standard_Button_Width,Standard_Button_Height );
		Career.setSize(Standard_Button_Width,Standard_Button_Height);

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
		JClear.setLocation(Column_3, Row_4);
		JBackSpace.setLocation(Column_1, Row_4);
		Help.setLocation(Column_6, Row_1);
		JStore.setLocation(Column_7, Row_1);
		Load.setLocation(Column_6, Row_2);
		Save.setLocation(Column_7, Row_2);
		Exit.setLocation(Column_7,Row_4);
		Career.setLocation(Column_7,Row_3);
		JTNT.setLocation(Column_6, Row_3);
		JPicks.setLocation(Column_6, Row_4);
		JSnips.setLocation(Column_6, Row_5);
		JInfo.setLocation(Column_7, Row_5);

		
		welcomeScreen();
		JStore.setVisible(true);
		mainWindow.setVisible(true);
		JEnter.setVisible(true);
		JInfo.setVisible(true);
		Exit.setVisible(true);
		Career.setVisible(true);
		
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
		p0.add(Exit);
		p0.add(Career);

		JUp.setVisible(true);
		JDown.setVisible(true);
		JLeft.setVisible(true);
		JRight.setVisible(true);
		JTNT.setVisible(true);
		JPicks.setVisible(true);
		JSnips.setVisible(true);

		welcomeText();
	}


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
		clearAllButtons(true);
		JEnter.setText("Play");
		JInfo.setText("Info");
		Load.setText("Load");
		Help.setText("How To");
		Save.setText("Save");
		Save.setForeground(Color.BLACK);
		

	}

	public void setDifficultyListener() {

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

		JClear.setForeground(Color.LIGHT_GRAY);
		JBackSpace.setForeground(Color.LIGHT_GRAY);
	
		mainWindow.requestFocus();
		requestDifficulty();
		  }

	public void requestDifficulty() {
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

	public void setGameText()
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
				Save.setForeground(Color.GRAY);
				JBackSpace.setForeground(Color.BLACK);
				JClear.setForeground(Color.BLACK);
				
				topText.setText("		Loot:  " + CrackerJacker.loot
						+ "     Wanted Level: " + CrackerJacker.wantedLevel
						+ "      Break-Ins: " + CrackerJacker.totalBreakIns);
	
	}
	
	public void setGameOver()
	{
		//display shown if the player has lost the game
		topText.setBackground(Color.RED);
		topText.setText(" Busted!!!"
				+ "\n"
				+"You Failed To Make Bail \n It Looks Like It's Game Over For You"
				);
		
		clearAllButtons(true);
		J7.setText("Restart");
		
	}

	public void buyStatus(boolean sucessful, String item)
	{
		//show the status of an attempted purchase in the proshop
		if (!sucessful)
		{
			// informs the user they couldn't but their item
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
		
	public void clearAllButtons(boolean isVisible)	
	{
		//method clears the text from MOST JButtons, and sets the visibility to isVisible
		J0.setText("");
		J1.setText("");
		J2.setText("");
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
		JClear.setText("");
		JBackSpace.setText("");
		JEnter.setText("");
		JTNT.setText("");
		JSnips.setText("");
		JPicks.setText("");
		JStore.setText("");
		
		setButtonVisibility(isVisible);
	}
	
	public void setButtonVisibility(boolean isVisible)
	{
		J0.setVisible(isVisible);
		J1.setVisible(isVisible);
		J2.setVisible(isVisible);
		J3.setVisible(isVisible);
		J4.setVisible(isVisible);
		J5.setVisible(isVisible);
		J6.setVisible(isVisible);
		J7.setVisible(isVisible);
		J8.setVisible(isVisible);
		J9.setVisible(isVisible);
		JUp.setVisible(isVisible);
		JDown.setVisible(isVisible);
		JLeft.setVisible(isVisible);
		JRight.setVisible(isVisible);
		JEnter.setVisible(isVisible);
		JBackSpace.setVisible(isVisible);
		JClear.setVisible(isVisible);
		
		JTNT.setVisible(isVisible);
		JPicks.setVisible(isVisible);
		JSnips.setVisible(isVisible);
		JStore.setVisible(isVisible);
		
		JInfo.setVisible(isVisible);
		Help.setVisible(isVisible);
		Load.setVisible(isVisible);
		Save.setVisible(isVisible);
		
	}
	
	public void setHelpText()
	{
		//this is the help window for the player to learn about the game
		helpWindow.setSize(815, 700);
		JTextArea helpText = new JTextArea(
				"		How To Play SafeCracker"
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
						+ "Your Cracker-Jacker 5000 DLX will give you a history of all your previous guesses, you can view the position and digits correct by turning on analysis mode"
						+ "\n"
						+ "To turn on analysis mode, hit CTRL. Once analysis mode is on, you can view your previous guesses, along with the digits and posistions correct, with the left and right arrows"
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
						+ "When you save your carrer, it will save a .cjx file, you must use this file type to load a carrer"
						+ "\n"
						+ "While you can load and save a carrer that has ended (has run out of loot), you won't be able to play anymore safes with that carrer");
		helpText.setEditable(false);
	
		helpWindow.add(helpText);
		helpWindow.setVisible(true);
	}
	
	public void setProShopText()
	{
		// set text for ProShop
		topText.setBackground(Color.WHITE);
		clearAllButtons(true);
		J0.setText("TNT");
		J1.setText("Picks");
		J2.setText("Snips");
	
		JEnter.setText("Exit");
	
		if (CrackerJacker.loot < 3000) 
		{
			// text shown if the player doesn't have enough money
			topText.setText("		Loot:  $" + CrackerJacker.loot
					+ "     Wanted Level: " + CrackerJacker.wantedLevel
					+ "      Break-Ins: " + CrackerJacker.totalBreakIns + "\n"
					+ "\n" + "        We Aint Got Anything For You Right Now!"
					+ "\n");
		} else 
		{
			// text shown if the player has enough money
			topText
					.setText("		Loot:  $"
							+ CrackerJacker.loot
							+ "     Wanted Level: "
							+ CrackerJacker.wantedLevel
							+ "      Break-Ins: "
							+ CrackerJacker.totalBreakIns
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
	
		// check if there are any quantities of tools and displays the number is
		// they do
		if (CrackerJacker.explosives > 0) {
			JTNT.setText("TNT (" + CrackerJacker.explosives + "x)");
			JTNT.setForeground(Color.GRAY);
		}
		if (CrackerJacker.picks > 0) {
			JPicks.setText("Picks (" + CrackerJacker.picks + "x)");
			JPicks.setForeground(Color.GRAY);
		}
		if (CrackerJacker.snips > 0) {
			JSnips.setText("Snips (" + CrackerJacker.snips + "x)");
			JSnips.setForeground(Color.GRAY);
		}
	}
	
	public void setInfoText()
	{
		//brings up a new text box with information about the game and creation
		JFrame infoWindow = new JFrame();
		infoWindow.setSize(250, 250);
		JTextArea infoText = new JTextArea(
				"Thank You For Playing Safe Cracker \n"
						+ "\n"
						+ "Created By: Steven Paytosh \n"
						+ "\n"
						+ "Computer Science and Engineering @ Univeristy of Toledo \n"
						+ "\n" + "Spring 2014" + "\n"
						+ "https://github.com/StevePaytosh/SafeCracker");
		infoWindow.setSize(500, 250);
		infoWindow.add(infoText);
		infoWindow.setVisible(true);
	}
	
	public void setSaveConfirm()
	{
		//brings up a new text box with infomation about the game and creation
		JFrame infoWindow = new JFrame();
		infoWindow.setSize(250, 250);
		JTextArea infoText = new JTextArea("Carrer Saved");
		infoWindow.setSize(500, 250);
		infoWindow.add(infoText);
		infoWindow.setVisible(true);
	}
	
	public void setSaveFailed()
	{
		JFrame infoWindow = new JFrame();
		infoWindow.setSize(250, 250);
		JTextArea infoText = new JTextArea("Failed To Save File:"
				+ "\n"
				+ "If you have already loaded a valid .cjx file, check that it has not been moved,renamed"
				+ " or deleted");
		infoWindow.setSize(500, 250);
		infoWindow.add(infoText);
		infoWindow.setVisible(true);
	}
	public void setLoadFailed()
	{
		JFrame infoWindow = new JFrame();
		infoWindow.setSize(250, 250);
		JTextArea infoText = new JTextArea("File failed to load:\n"
				+ " Make sure you are uploading a valid .cjx file");
		infoWindow.setSize(500, 250);
		infoWindow.add(infoText);
		infoWindow.setVisible(true);
	}
	public void setButtonListener(String buttonID, ActionListener a)
	{
		switch(buttonID)
		{
		case "0": J0.addActionListener(a);
		case "1": J0.addActionListener(a);
		case "2": J0.addActionListener(a);
		case "3": J0.addActionListener(a);
		case "4": J0.addActionListener(a);
		case "5": J0.addActionListener(a);
		case "6": J0.addActionListener(a);
		case "7": J0.addActionListener(a);
		case "8": J0.addActionListener(a);
		case "9": J0.addActionListener(a);
		case "Up": J0.addActionListener(a);
		case "Down": J0.addActionListener(a);
		case "Left": J0.addActionListener(a);
		case "Right": J0.addActionListener(a);
		case "BackSpace": J0.addActionListener(a);
		case "Clear": J0.addActionListener(a);
		case "Info": J0.addActionListener(a);
		case "Store": J0.addActionListener(a);
		case "Help": J0.addActionListener(a);
		case "TNT": J0.addActionListener(a);
		case "Picks": J0.addActionListener(a);
		case "Snips": J0.addActionListener(a);
		case "Enter": J0.addActionListener(a);
		case "Save": J0.addActionListener(a);
		case "Load": J0.addActionListener(a);
		
		}
	}
	
	public void removeButtonListeners(String buttonID, ActionListener a)
	{
		switch(buttonID)
		{
		case "0": J0.addActionListener(a);
		case "1": J0.addActionListener(a);
		case "2": J0.addActionListener(a);
		case "3": J0.addActionListener(a);
		case "4": J0.addActionListener(a);
		case "5": J0.addActionListener(a);
		case "6": J0.addActionListener(a);
		case "7": J0.addActionListener(a);
		case "8": J0.addActionListener(a);
		case "9": J0.addActionListener(a);
		case "Up": J0.addActionListener(a);
		case "Down": J0.addActionListener(a);
		case "Left": J0.addActionListener(a);
		case "Right": J0.addActionListener(a);
		case "BackSpace": J0.addActionListener(a);
		case "Clear": J0.addActionListener(a);
		case "Info": J0.addActionListener(a);
		case "Store": J0.addActionListener(a);
		case "Help": J0.addActionListener(a);
		case "TNT": J0.addActionListener(a);
		case "Picks": J0.addActionListener(a);
		case "Snips": J0.addActionListener(a);
		case "Enter": J0.addActionListener(a);
		case "Save": J0.addActionListener(a);
		case "Load": J0.addActionListener(a);
		
		}
	}
	
	public void openFileSelector()
	{
		final JFileChooser fc = new JFileChooser();
		//fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc.setAcceptAllFileFilterUsed(false); //set all file types to not appear (only .cjx should appear)
	//	cjx cjx= new cjx();
	//	fc.setFileFilter(cjx);
		int returnVal = fc.showOpenDialog(mainWindow);
		//System.out.println(fc.getSelectedFile().getAbsolutePath());
		CrackerJacker.career_file=fc.getSelectedFile().getAbsolutePath();
	}
	
	private class cjx implements FileFilter{
	
		@Override
		public boolean accept(File arg0) {
			String extension=arg0.getPath();
			System.out.println(extension);
			
			return false;
		}
		
	}
	
	public void setProShopButton(boolean set)
	{
		JStore.setText("Pro Shop");
		if(set)
			JStore.setForeground(Color.BLACK);
		else
			JStore.setForeground(Color.LIGHT_GRAY);
	}
	
	public void setToolButtons(boolean gamePhase)
	{
		if ((CrackerJacker.explosives) > 0) {
			JTNT.setText("TNT (" + (CrackerJacker.explosives) + "x)");
			JTNT.setForeground(!gamePhase?Color.LIGHT_GRAY:Color.BLACK);
		} else {
			JTNT.setText("-");
			JTNT.setForeground(Color.LIGHT_GRAY);
		}
		
		if ((CrackerJacker.picks) > 0) {
			JPicks.setText("Picks (" + (CrackerJacker.picks) + "x)");
			JPicks.setForeground(!gamePhase?Color.LIGHT_GRAY:Color.BLACK);
		} else {
			JPicks.setText("-");
			JPicks.setForeground(Color.LIGHT_GRAY);
		}
		
		if ((CrackerJacker.snips) > 0) {
			JSnips.setText("Snips (" + (CrackerJacker.snips) + "x)");
			JSnips.setForeground(!gamePhase?Color.LIGHT_GRAY:Color.BLACK);
		} else {
			JSnips.setText("-");
			JSnips.setForeground(Color.LIGHT_GRAY);
		}
	}
	
	public void setCareer()
	{
		//brings up a new text box with infomation about the players career
		JFrame infoWindow = new JFrame();
		infoWindow.setSize(250, 250);
		JTextArea infoText = new JTextArea("Career Stats:"
				+ "\n"
				+ "Safes Cracked: " + CrackerJacker.totalBreakIns
				+ "\n"
				+ "...");
		infoWindow.setSize(500, 250);
		infoWindow.add(infoText);
		infoWindow.setVisible(true);
	}
	public void terminate()
	{
		mainWindow.dispose();
	}
	
	public void printUpdate()
	{
		//method prints out the current status of the game include previous guesses & digits correct
			StringBuilder tempBuilder = new StringBuilder();
	
			int selectedVal=CrackerJacker.turnCount-CrackerJacker.leftCounter-1; // index of guess to be viewed
			for (int i = 0; i < CrackerJacker.turnCount; i++) 
			{
				//for loop strings together previous guesses
				if (i == selectedVal) {
					tempBuilder.append("  | "
							+ CrackerJacker.guessArray[i].currentGuess + " | ");
				} else {
					tempBuilder.append("   "
							+ CrackerJacker.guessArray[i].currentGuess.toString());
				}
	
			}
	
			topText.setText("		Loot:  $" + CrackerJacker.loot
					+ "     Wanted Level: " + CrackerJacker.wantedLevel
					+ "      Break-Ins: " + CrackerJacker.totalBreakIns
					+ "   combo: " + CrackerJacker.combo + "\n"
					+ " Difficulty: " + CrackerJacker.difficulty + "\n"
					+ " Digits: " + CrackerJacker.comboSize + " Directions: "
					+ CrackerJacker.directions + "\n" + " Guesses:  "
					+ (CrackerJacker.guessLimit - CrackerJacker.turnCount)
					+ "    Time: " + CrackerJacker.timeInMinutes + ":"
					+ CrackerJacker.timeInSeconds + "\n" );
			
			if(CrackerJacker.debugMode) //if the debugMode variable is set, show the combo 
				topText.append(tempBuilder + "\n");  
					
			topText.append("\n" + "             " + CrackerJacker.currentGuess.currentGuess.toString() );
			
			if(CrackerJacker.isAnalysisMode)
			{
				topText.append(" ANALYSIS MODE: ON");
			}
			topText.append( "\n" + "      Digits Correct: "
					+ CrackerJacker.digitsCorrect() + "    Posistions Correct: "
					+ CrackerJacker.posistionsCorrect() + "\t\t Analysis Mode: CTRL");
	
	}
	
	public void setGameBoard(CrackerJacker a)
	{ this.CrackerJacker=a; }
}
