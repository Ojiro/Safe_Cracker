// safe contains the information for a safe. 
// safe also interfaces with a CrackerJacker
public class Safe
{
	private  int difficulty; 
	 private StringBuilder combination; // this is the combination to open the safe
	 private int digitsCorrect; // holds the number of digits correct in the last guess
	 							// "digits" are the digits (0-9) or directions (L,R,U,D) correct regardless of position
	 private int posistionsCorrect; // holds the number of positions in the last guess that are correct
	 private int guessLimit; // the max number of guesses on the safe
	 private int combinationSize; // the total size of the combo (digits + directions)
	 private int directions; // the number of directions in the safe
	 private int timeInMinutes; 
	private int timeInSeconds=360;
	private boolean opened=false;
	private boolean failed=false;
	private boolean armed; //status determines whether or not TNT will alert the police
	private int turnCount;
	private StringBuilder[] guessArray; // guessArray holds the history of guesses
	
	Safe(int difficulty)
	{
	
		this.difficulty=difficulty;
				
				switch(difficulty)
				{
				case 1: combinationSize=3; guessLimit=10; directions=0; timeInSeconds=360; armed=false; break;
				case 2: combinationSize=4; guessLimit=10; directions=1; timeInSeconds=360; armed=false; break;
				case 3: combinationSize=4; guessLimit=10; directions=0; timeInSeconds=360; armed=false; break;
				case 4: combinationSize=5; guessLimit=10; directions=1; timeInSeconds=360; armed=setArm(); break;
				case 5:	combinationSize=5; guessLimit=10; directions=0; timeInSeconds=360; armed=setArm(); break;
				case 6: combinationSize=6; guessLimit=15; directions=2; timeInSeconds=360; armed=setArm();break;
				case 7: combinationSize=6; guessLimit=15; directions=6; timeInSeconds=480;  armed=setArm(); break;
				case 8: combinationSize=6; guessLimit=15; directions=0; timeInSeconds=360; armed=setArm(); break;
				case 9: combinationSize=7; guessLimit=15; directions=3; timeInSeconds=360; armed=setArm(); break;
				case 10: combinationSize=7; guessLimit=15; directions=3; timeInSeconds=360; armed=setArm(); break;
				case 11: combinationSize=8; guessLimit=15; directions=3; timeInSeconds=300; armed=setArm(); break;
				case 12: combinationSize=8; guessLimit=20; directions=2; timeInSeconds=300; armed=true; break;
				case 13: combinationSize=8; guessLimit=20; directions=0; timeInSeconds=300;  armed=true; break;
				case 14: combinationSize=13; guessLimit=20; directions=3; timeInSeconds=360; armed=true; break;
				default: combinationSize=4; guessLimit=10; directions=0; timeInSeconds=60; armed=setArm(); break;

		} // ends switch
				
		guessArray=new StringBuilder[guessLimit];
		combination=setCombination();
		timeInMinutes=timeInSeconds%60;
				
	} // ends constructor
	
	public String getCombo()
	{ return combination.toString();
	// debug method
	}
	public int getDifficulty()
	{ return difficulty; }
	// ends getDifficulty
	
	public int getDirections()
	{ return directions; }
	// ends getDirections
	
	public int getPosistionsCorrect()
	{ return posistionsCorrect; }
	// ends getPosistionsCorrect
	
	public int getDigitsCorrect()
	{ return digitsCorrect; }
	// end getDigitsCorrect
	
	public int getCombinationSize()
	{ return combinationSize; }
	// ends getCombinationSize
	
	public int getGuessLimit()
	{ return guessLimit; }
	// ends getGuessLimit
	
	public int getTurnCount()
	{ return turnCount; }
	// ends getTurnCount
	
	public int getComboSize()
	{ return combinationSize; }
	// ends getComboSize
	public boolean isCorrect(String input)
	{
		// input is the combination guess
		if(!failed && !opened)
		{
			turnCount++;
			guessArray[turnCount-1]=new StringBuilder(input);
		
			setInfo(input);
			
			if(turnCount >= guessLimit)
			{	lockSafe();}
			else if(input.equals(combination.toString()))
			{  openSafe(); }
		} // ends if block
			
		return opened;
	} // ends isCorrect
	
	public boolean isFailed()
	{ return failed; }
	
	public void snips()
	{
		// modify combination if snips are used
		
	}
	
	public void TNT()
	{
		//modify combination if TNT is used
	}
	public void picks()
	{
		// modify combination if picks are used
	}
	
	private StringBuilder setCombination()
	{
		/* each time a safe is played the appropriate number of digits will be appended into a StringBuilder called combo
		 * for each spot, use the randomNumber method to return a digit, the no-arg method will return 0-9, the integer arg(use any number)
		 * will return 1-9 but no zeros, this is required for the first digit in the combination. and use a character to return a direction
		 *  */

       combination= new StringBuilder();  // clears the old combination, for a new StringBuilder
		
	
       for (int i=0; i<combinationSize; i++) // the first digit of any safe will not be a zero
		{
			if(i==0)
			{
				if (difficulty==7) // this if statement runs if the Chinese Lock is selected, the safe uses all directions
				{
					combination.append(randomNumber('z'));
				}
				else
				{
				combination.append(randomNumber(1));
				}
			}
			else if (combinationSize-i <= directions)
			{
				combination.append(randomNumber('z'));
			}
			else
			{
				combination.append(randomNumber());
			}	
		} // ends for loop
       
       return combination;
	} // ends setCombination class
	
    // randomNumber, no-arg
	//  creates a random digit from 0-9
	private String randomNumber()
		{
			while(true)
			{
				int a=(int)(Math.random()*10);
			
				if (a>=0 && a<=9)
				{
					Integer b=new Integer(a);
					return b.toString();		
				}
				else if (a<0 || a>9)
					continue;
				
			
			} // ends loop
			
			
			
		} // ends randomNumber(no arg)

		
	// randomNumber(integer argument)
	// creates a random digit from 1-9, zero will not be an option
	// integer argument is completely irrelevant to the method and only invokes a method that will not return a zero
	private String randomNumber(int z)
			{
				while(true)
				{
				int a=(int)(Math.random()*10);
				
				if (a>0 && a<10)
				{
					Integer b= new Integer(a);
					return b.toString();
					
				}
				else if (a<0 || a>9)
				{
					continue;
				}
				
				} // ends loop
			
			} // ends randomNumber(int)
			
	
	// randomNumber(char argument)
	// creates a number 0-9 or a character U,D,L,R
	private String randomNumber(char z)
			{
				while (true)
				{
					int a=(int)(Math.random()*1011);
					
					if (a>=0 && a<250) // return U
					{
						return new String("U");
					}
					else if (a<500) //return D
					{
						return new String("D");
					}
					else if (a<750) // return L
					{
						return new String("L");
					}
					else if (a<=1000) // return R
					{
						return new String("R");
					}
					else
						continue;
				} // ends while loop
			} // end randomNumber(char)
			
	
	private void setInfo(String guess)
	{
		// method determines how many digits and positions are correct
	
		
		// reset the number of digits and positions to zero
		posistionsCorrect=0;
		digitsCorrect=0;
		
		StringBuilder guessCombo=new StringBuilder(guess); 
		char guessChar=(' ');
		char comboChar=(' ');
		int[] includeArray= new int[120]; // index for the array will be a digit in the guess, so if the guess is 222, index 2 will equal 3
											// the large index range account for having string inputs
		
		// check the number of posistion correct
		for(int i=0; i<combinationSize; i++)
		{
			if(guessCombo.charAt(i)==combination.charAt(i) )
			{ posistionsCorrect++; }
			
		
		}// ends for loop
		
		
		// check the number of digits correct
	
		for(int i=0; i<combinationSize; i++)  // loop fills arrays with proper values
		{
		
			includeArray[(int)guessCombo.charAt(i)]++;
			
		} 
		
		for(int i=0; i<combinationSize;i++) // i loop will call up values in the combo
		{ 
			
			for(int j=0; j<combinationSize;j++) // j loop will call up values in the guess
			{
				// excludeArray holds how many times a number appears in the guess
				// if a number hits a match with the combo, the array is decremented so
				// that it can only hit as many times as it exists in the guess
				
				if (guessCombo.charAt(j)==combination.charAt(i) && includeArray[guessCombo.charAt(j)] >0 )
				{						
					digitsCorrect++;
					
					includeArray[guessCombo.charAt(j)]--;
					break;
				}
					
			}  // ends j loop
		} // ends i loop
		
		
		
	} // ends setInfo
			
	//
	//setArm
	//Randomly sets the armed status to be true or false	
	private boolean setArm()
			{
				return(Math.random()*10>5);
			} // ends setArm
			
	//
	//timeDecrement
	
	
	public int getSTime()
	{
		return timeInSeconds;
	} // ends getSTime
	
	public int getMTime()
	{
		return timeInMinutes;
	} // ends getMTime
	
	private void openSafe()
	{
		// method changes the status of the opened variable to true;
		// opened prevents any trues on the safe
		if(!failed)
			opened=true;
	} // ends openSafe
	
	private void lockSafe()
	{
		// method changes the status of the failed variable to true
		// failed prevents any tries on the safe
		if(!opened)
			failed=true;
	} // ends lockSafe

	
	
} // ends safe class
