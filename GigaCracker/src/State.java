import java.awt.Color;

import javax.swing.JButton;

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

	public static void welcomeState(JButton[] JBDigits, JButton[] JBDirections,
			JButton[] JBTools, JButton[] JBHelpers) {
		JBDigits[0] = new JButton("");
		JBDigits[1] = new JButton("");
		JBDigits[2] = new JButton("");
		JBDigits[3] = new JButton("");
		JBDigits[4] = new JButton("");
		JBDigits[5] = new JButton("");
		JBDigits[6] = new JButton("");
		JBDigits[7] = new JButton("");
		JBDigits[8] = new JButton("");
		JBDigits[9] = new JButton("");

		JBDirections[0] = new JButton("");
		JBDirections[1] = new JButton("");
		JBDirections[2] = new JButton("");
		JBDirections[3] = new JButton("");
		JBDirections[4] = new JButton("Enter");
		JBDirections[5] = new JButton("");
		JBDirections[6] = new JButton("");

		JBTools[0] = new JButton("Pro Shop");
		JBTools[1] = new JButton("-");
		JBTools[2] = new JButton("-");
		JBTools[3] = new JButton("-");
		
		JBHelpers[0] = new JButton("Info");
		JBHelpers[0] = new JButton("-");
		JBHelpers[0] = new JButton("-");
		JBHelpers[0] = new JButton("Help");
		
		
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

		JBHelpers[0].setLocation(650, 400);
		JBHelpers[0].setLocation(550, 250);
		JBHelpers[0].setLocation(650, 250);
		JBHelpers[0].setLocation(550, 200);

		JBTools[0].setLocation(650, 200);
		JBTools[1].setLocation(550, 300);
		JBTools[2].setLocation(550, 350);
		JBTools[3].setLocation(550, 400);

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

}
