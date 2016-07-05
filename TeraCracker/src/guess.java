
public class guess {

	int posistionsCorrect=0; // during play, this variable tells how many positions are correct (note that positions and digits are 2 distinct concepts)
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
