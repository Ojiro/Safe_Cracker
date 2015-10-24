import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
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

}
