import javax.swing.JButton;
/*
 * JBDigit buttons 0-9 correspond to J0-J9
 * JBDirection: 0=up, 1=down, 2=left,3=right, 4=Enter,5=clear, 6=backspace
 *   
 * 
 * */
final public class State {

	private static void State() {
	}

	public static void welcomeState(JButton[] JBDigits, JButton[] JBDirections,JButton[] JBTools, JButton[] JBHelpers) {
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

		JBTools[0] = new JButton("Info");
		JBTools[1] = new JButton("Pro Shop");
		JBTools[2] = new JButton("-");
		JBTools[3] = new JButton("-");
		JBTools[4] = new JButton("-");
	}

	public static void setDefaultLocation(JButton[] JBDigits, JButton[] JBDirections,JButton[] JBTools, JButton[] JBHelpers)
	{
		JBDigits[0].setLocation(25,200);
		JBDigits[1].setLocation(125,200);
		JBDigits[2].setLocation(225,200);
		JBDigits[3].setLocation(325,200);
		JBDigits[4].setLocation(425,200);
		JBDigits[5].setLocation(25,250);
		JBDigits[6].setLocation(125,250);
		JBDigits[7].setLocation(225,250);
		JBDigits[8].setLocation(325,250);
		JBDigits[9].setLocation(425,250);
		
	}
	public static void setButtonToDefaultSize(JButton[] arr)
	{
		for(int i=0; i<arr.length; i++)
		{arr[i].setSize(100,50); }
	}
}
