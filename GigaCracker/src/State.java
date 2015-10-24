import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.tools.JavaFileObject;

/*
 * JBDigit buttons 0-9 correspond to J0-J9
 * JBDirection: 0=up, 1=down, 2=left,3=right, 4=Enter,5=clear, 6=backspace
 * JBTools: Store, TNT, Picks, Snips
 * JBHelpers: Info, load, save, help 
 * 
 * */
final public class State {

	
	private static void State() {
	}

	public static void setWelcomeState(JButton[] JBDigits, JButton[] JBDirections, JButton[] JBTools, JButton[] JBHelpers) {
		
		
		setButtonsAsReal(JBDigits);
		setButtonsAsReal(JBDirections);
		setButtonsAsReal(JBTools);
		setButtonsAsReal(JBHelpers);
		JBDirections[4] = new JButton("Enter");
		JBTools[0] = new JButton("Pro Shop");
		JBHelpers[0] = new JButton("Info");
		JBHelpers[3] = new JButton("Help");
		
		
	}

	public static void setWelcomeState(JTextArea topText)
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
	}
	
	public static void setProShopWelcomeState(JButton[] JBDigits,JButton[] JBDirections, JButton[] JBTools,JTextArea topText, int loot, int wantedLevel,int totalBreakIns,int explosives, int snips,int picks)
	{

		JBDigits[0].setText("TNT");
		JBDigits[1].setText("Picks");
		JBDigits[2].setText("Snips");
		JBDigits[3].setText("");
		JBDigits[4].setText("");
		JBDigits[5].setText("");
		JBDigits[6].setText("");
		JBDigits[7].setText("");
		JBDigits[8].setText("");
		JBDigits[9].setText("");
		JBDirections[0].setText("");
		JBDirections[1].setText("");
		JBDirections[2].setText("");
		JBDirections[3].setText("");
		JBDirections[4].setText("Exit");
		
		if (loot < 3000) // text shown if the player doesn't have enough money
		{

			topText.setText("		Loot:  $" + loot + "     Wanted Level: "
					+ wantedLevel + "      Break-Ins: " + totalBreakIns + "\n"
					+ "\n" + "        We Aint Got Anything For You Right Now!"
					+ "\n");
		} else // text shown if the player has enough money
		{
			topText.setText("		Loot:  $"
					+ loot
					+ "     Wanted Level: "
					+ wantedLevel
					+ "      Break-Ins: "
					+ totalBreakIns
					+ "\n"
					+ "\n"
					+ "            		Psst, Welcome To The Pro-Shop"
					+ "\n"
					+ "              		     Here's What We Got"
					+ "\n"
					+ "\n"
					+ "$4,500 "
					+ "TNT- Breaks A Safe For You, But May Alert The Cops (Tread Lightly)"
					+ "\n" + "$3,500 "
					+ "Lock Pick- Removes A Digit From A Combo" + "\n"
					+ "$3,000 "
					+ "Snips- Delays The Cops And Gives You An Extra Move ");
		}

		// check if there are any quantities of tools and displays the number is
		// they do
		if (explosives > 0) {
			JBTools[1].setText("TNT (" + explosives + "x)");
			JBTools[1].setForeground(Color.GRAY);
		}
		if (picks > 0) {
			JBTools[2].setText("Picks (" + picks + "x)");
			JBTools[2].setForeground(Color.GRAY);
		}
		if (snips > 0) {
			JBTools[3].setText("Snips (" + snips + "x)");
			JBTools[3].setForeground(Color.GRAY);
		}

	}
	public static void setDefaultLocation(JButton[] JBDigits,
			JButton[] JBDirections, JButton[] JBTools, JButton[] JBHelpers) {
		JBDigits[0].setLocation(25, 200);
		JBDigits[1].setLocation(125, 200);
		JBDigits[2].setLocation(225, 200);
		JBDigits[3].setLocation(325, 200);
		JBDigits[4].setLocation(425, 200);
		JBDigits[5].setLocation(25, 250);
		JBDigits[6].setLocation(125, 250);
		JBDigits[7].setLocation(225, 250);
		JBDigits[8].setLocation(325, 250);
		JBDigits[9].setLocation(425, 250);

		JBDirections[0].setLocation(25,300);
		JBDirections[1].setLocation(125,300);
		JBDirections[2].setLocation(225,300);
		JBDirections[3].setLocation(325,300);
		JBDirections[4].setLocation(425,300);
		JBDirections[5].setLocation(225,350);
		JBDirections[6].setLocation(25,350);
		
		JBHelpers[0].setLocation(650, 400);
		JBHelpers[0].setLocation(550, 250);
		JBHelpers[0].setLocation(650, 250);
		JBHelpers[0].setLocation(550, 200);

		JBTools[0].setLocation(650, 200);
		JBTools[1].setLocation(550, 300);
		JBTools[2].setLocation(550, 350);
		JBTools[3].setLocation(550, 400);

	}
	

	public static void setButtonsAsReal(JButton[] arr)
	{
		for (int i = 0; i < arr.length; i++) {
			arr[i]= new JButton("");
		}
	}
	public static void setButtonToDefaultSize(JButton[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i].setSize(100, 50);
		}
	}
	
	public static void setButtonsToVisible(JButton[] arr)
	{
		for (int i = 0; i < arr.length; i++) {
			arr[i].setVisible(true);
		}
	}
	
	public static void setButtonsToNotVisible(JButton[] arr)
	{
		for (int i = 0; i < arr.length; i++) {
			arr[i].setVisible(false);
		}
	}

	public static void setButtonAsDisabled(JButton[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i].setForeground(Color.LIGHT_GRAY);
		}
	}
	
	public static void addButtonToElement(JPanel element,JButton[] arr) {
		for (int i = 0; i < arr.length; i++) {
			element.add(arr[i]);
		}
	}
	public static void removeListenerFromButton(ActionListener Listener, JButton[] arr )
	{
		for (int i = 0; i < arr.length; i++) {
			arr[i].removeActionListener(Listener);
		}
	}
	public static void addListenerToButton(ActionListener Listener, JButton[] arr )
	{
		for (int i = 0; i < arr.length; i++) {
			arr[i].addActionListener(Listener);
		}
	}
}
