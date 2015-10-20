
public class Player
{
	private String name="John Doe Default";
	private boolean male=true;
	private int safesBroken=0;
	private int wantedLevel=0;
	private int bank=1500;
	private int bail=500;
	private boolean gameOver=false;
	private int points=0; // points are the cumulative difficulties of the safes played
	private CrackerJacker jacker;
	private int snips=0; // amount of snips owned by the player
	private int picks=0; // amount of picks owned by the player
	private int TNT=0; 	// amount of TNT owned by the player

	
	Player()
	{}
	
	public void setJacker(CrackerJacker newJacker)
	{
		jacker=newJacker;
	}
	public boolean getGameOver()
	{ return gameOver; }
	// ends getGameOver
	public String getName()
	{ return name;}
	public void setName(String n)
	{ name=n; }

	public int getSafesBroken()
	{ return safesBroken; }
	public int getWantedLevel()
	{ return wantedLevel; }
	public int getBank()
	{ return bank; }
	
	public int getMovesLeft()
	{ return jacker.getMovesLeft(); }
	
	public int getDigits()
	{ return jacker.getDigits(); }
	public int getDirections()
	{ return jacker.getDirections(); }
	public boolean makeAttempt(String guess)
	{ return jacker.makeAttempt(guess); }
	public int getDigitsCorrect()
	{ return jacker.getDigitsCorrect(); }
	public int getPosistionsCorrect()
	{ return jacker.getPosistionsCorrect(); }
	
	public void applySnips()
	{}
	public void applyPicks()
	{}
	public void applyTNT()
	{}
	
	public void safeFailed(int failedDifficulty)
	{
		points+=failedDifficulty;
		setBail(failedDifficulty);
		
		// method is called by a CrackerJacker when the player fails a safe
		if(!gameOver && bank>=bail)
		{
			bank=-bail;
		}
		else if(!gameOver && bank<bail)
		{
			gameOver=false;
		}
		
		setWantedLevel();
		//setWantedLevel(difficulty);
	} // ends safeFailed
	
	public void safeBroken(int denomination, int difficulty)
	{
		points+=difficulty;
		if(!gameOver)
		{
			safesBroken++;
			bank+=denomination;
		}
		
		setWantedLevel();
	} // ends safeBroken
	private void setWantedLevel()
	{
		if(points<5)
		{
			wantedLevel=1;
		}
		else if(points<10)
		{
			wantedLevel=2;
		}
		else if(points<15)
		{
			wantedLevel=3;
		}
		else if(points<20)
		{
			wantedLevel=4;
		}
		else if(points<25)
		{
			wantedLevel=5;
		}
		
		
	
	}// ends setWantedLevel
	private void setBail(int difficulty)
	{ bail=wantedLevel*250*(int)Math.sqrt(difficulty); }
	// ends setBail
}// ends player class
