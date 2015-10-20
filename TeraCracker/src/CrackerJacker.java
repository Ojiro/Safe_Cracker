// CrackerJacker is the class responsible for playing the game
// CrackerJacker will interface with a safe to return relevant information for the game
// CrackerJacker also processes any time constraints

public class CrackerJacker
{
	private int timeInMinutes; 
	private int timeInSeconds;
	private int elapsedTimeInSeconds;
	private int maxGuesses;
	private int bailOut;
	private int points=0; // points are the total value of difficulty for each safe played (difficulty 1 = +1, difficulty 3= +3), wanted level uses this value
	private Safe gameBox; // Box will be CrackerJackers term for a safe, gameBox is the safe currently in play
	private int turnCount;
	private Player player;
	
	
	
	CrackerJacker(Player defaultPlayer)
	{
		// a player is required to instatiate a new CrackerJacker
		newSafe( new Safe(1));
	}// ends constructor
	
	CrackerJacker(Safe newBox)
	{ newSafe(newBox);	}
	// ends constructor
	
	public void newSafe(Safe newBox)
	{
		// method receives information about a new safe
		gameBox=newBox;
		timeInMinutes=gameBox.getMTime();
		timeInSeconds=gameBox.getSTime();
	} // ends newSafe
	
	public int getMovesLeft()
	{ return (gameBox.getGuessLimit()-gameBox.getTurnCount() ); }
	// returns getMovesLeft
	public int getTurnCount()
	{ return turnCount; } 
	public int getDigitsCorrect()
	{ return gameBox.getDigitsCorrect(); }
	public int getPosistionsCorrect()
	{ return gameBox.getPosistionsCorrect(); }
	public int getDigits()
	{ return gameBox.getCombinationSize()-gameBox.getDirections(); }
	public int getDirections()
	{ return gameBox.getDirections(); }
	
	public void applySnips()
	{}
	public void applyPicks()
	{}
	public void applyTNT()
	{}
	
	public boolean makeAttempt(String guess) // add the player as a parameter later on
	{ return gameBox.isCorrect(guess);	} // ends makeAttempt
	
	public void timeDecrement()
	{
		timeInSeconds--;
		timeInMinutes=timeInSeconds/60;
		
		System.out.println(timeInSeconds+ " " + timeInMinutes);
		
	} // ends timeDecrement
	
	public Safe getSafe()
	{ return gameBox; }
}// ends CrackerJacker class
