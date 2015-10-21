import javax.swing.JButton;

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

}
