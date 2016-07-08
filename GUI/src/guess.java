
public class guess {

	/*Guess contains information for a single guess. current guess is the guess for the combo.
	 * Positions and digits correct are the number of digit and positions correct for 
	 * the given combo */
	int posistionsCorrect=0; 
	int digitsCorrect=0;  
	StringBuilder currentGuess=new StringBuilder("");

	guess(int posistionsCorrect, int digitsCorrect, StringBuilder currentGuess)
	{
		this.posistionsCorrect=posistionsCorrect;
		this.digitsCorrect=digitsCorrect;
		this.currentGuess=currentGuess;
	}
	
	guess(){}

}
