
public class CrackerJacker {

	int loot=3000; // Loot is the currency of the game. Player gains and looses loot based on winning/losing safes. default is 3000 
	int turnCount=0;  // this is the number of guesses made in the game, it counts upward from zero
	int totalBreakIns=0; // Counts the number of safes cracked in a players career default is 0
	int wantedLevel=1; // Wanted level dictates the cost of bail and increments based on how many safes the player has cracked
	int comboSize=3; // determines how many digits in a combo, default is 3
	int directions=0; // details how many directions can be found in a combination
	int bail=0; // how much a player pays for failing to crack a safe, value will be based on wantedLevel and the difficulty of a safe
	int payout=0; // how much a player gets for cracking a safe, the range of values is determined by the difficulty of a safe
	int difficulty=1; // Correlates to how tough a safe is to crack, and settings will be changed based on this value
	int guessLimit=10;  // in most difficulties, the number of guesses will be 10. However this may change for a few safes
	int timeInSeconds=0; // holds the seconds portion of the time, i.e. if time left is 5:32, timeInSeconds=32
	int timeInMinutes=6; // hold the minutes portion of the time, i.e if the time left is 5:32 timeInMinutes=5. Default time is 6 minutes
	int explosives=0; // holds the number of TNT charges owned by the player
	int snips=0;  // hold the number of snips owned by the player
	int picks=0; // hold the number of lock picks owned by the player
	boolean isWinner=false; // hold if the current safe has been solved
	boolean career=true;  // boolean keeps a dead carer from playing by turning it false and saving it in load file
	boolean isAnalysisMode=false; //when analysis mode is on, arrow will traverse previous guesses
	boolean debugMode=true; //debug mode shows the combo in the status update when debugMode is true
	int leftCounter=0; //used in analysis mode to determine how far back to go
	String career_file=""; //file location of .cjx file for loading and saving a carreer
    guess[] guessArray; // holds all the guesses in a single game
    guess currentGuess= new guess();//new StringBuilder(); // hold the parts of a current guess, before it is added to the guessArray
	StringBuilder combo= new StringBuilder();
	boolean analyzeWithArrow=false; //when this is false, arrows will act as a directional guess
									//when true, it will shift along the guess history to show details

			public void makeCombo()
			{	
			
				/* each time a safe is played the appropriate number of digits will be appended into a StringBuilder called combo
				 * for each spot, use the randomNumber method to return a digit, the no-arg method will return 0-9, the integer arg(use any number)
				 * will return 1-9 but no zeros, this is required for the first digit in the combination. and use a character to return a direction
				 */

				guessArray=new guess[guessLimit];
				
	           combo= new StringBuilder();  // clears the old combination, for a new StringBuilder
				
			
	           for (int i=0; i<comboSize; i++) // the first digit of any safe will not be a zero
				{
					if(i==0)
					{
						if (difficulty==7) // this if statement runs if the Chinese Lock is selected, the safe uses all directions
						{
							combo.append(randomNumber('z'));
						}
						else
						{
						combo.append(randomNumber(1));
						}
					}
					else if (comboSize-i <= directions)
					{
						combo.append(randomNumber('z'));
					}
					else
					{
						combo.append(randomNumber());
					}
				}
			
		
					 
			
			
			} // ends makeCombo
	
			public static String randomNumber()
			{
				//creates a random number from 0-9
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
						
				} 
			} 

			
				public static String randomNumber(int z)
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
					
					} 
				
				} 
				
				public static String randomNumber(char z)
				{
					//creates a random number 0-9 or U,D,L,R
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
				
				public void wantedLevel()
				{  
					// determine the wanted level
					// if the totalBreakIns exceed a certain number, increase wanted level, increment this requirement by 2 for each wantedLevel
					// else if the product of current wantedLevel and the difficulty exceeds a certain value, increase wanted level
					// increment this requirement by n, where n increasing every 3 levels. So n is 2 for the first 3 if statements, then 3 for the next 3.
					
					int holdwantedLevel=wantedLevel; // acts as a holder for the current wantedLevel,
					
					if (holdwantedLevel<=2 && (holdwantedLevel*difficulty>3 || totalBreakIns>2) )
					{
					
						wantedLevel=2;
					}
					if (holdwantedLevel<=3 && (holdwantedLevel*difficulty>5 || totalBreakIns>4) )
					{
						
						wantedLevel=3;
					}
				    if (holdwantedLevel<=4 && ( holdwantedLevel*difficulty>7 || totalBreakIns>6) )
				    {
				    	
						wantedLevel=4;
				    }
				    if (holdwantedLevel<=5 && ( holdwantedLevel*difficulty>10 || totalBreakIns>8) )
				    {
						wantedLevel=5;
				    }
				    
				    if (holdwantedLevel<=6 && ( holdwantedLevel*difficulty>13 || totalBreakIns>10) )
				    {
						wantedLevel=6;
				    }
				    
				    if (holdwantedLevel<=7 && ( holdwantedLevel*difficulty>16 || totalBreakIns>12) )
				    {
						wantedLevel=7;
				    }
				    
				    if (holdwantedLevel<=8 && ( holdwantedLevel*difficulty>20 || totalBreakIns>14) )
				    {
						wantedLevel=8;
				    }
				    
				    if (holdwantedLevel<=9 && ( holdwantedLevel*difficulty>24 || totalBreakIns>16) )
				    {
						wantedLevel=9;
				    }
				    
				    if (holdwantedLevel<=10 && ( holdwantedLevel*difficulty>28 || totalBreakIns>18) )
				    {
						wantedLevel=10;
				    }
				    
				    if (holdwantedLevel<=11 && ( holdwantedLevel*difficulty>33 || totalBreakIns>20) )
				    {
						wantedLevel=11;
				    } 
				    if (holdwantedLevel<=12 && ( holdwantedLevel*difficulty>38 || totalBreakIns>22) )
				    {
						wantedLevel=12;
				    }
				    if (holdwantedLevel<=13 && ( holdwantedLevel*difficulty>43 || totalBreakIns>24) )
				    {
						wantedLevel=13;
				    }
				    if (holdwantedLevel<=14 && ( holdwantedLevel*difficulty>49 || totalBreakIns>26) )
				    {
						wantedLevel=14;
				    }
				    
				    if (holdwantedLevel<=15 && ( holdwantedLevel*difficulty>55 || totalBreakIns>28) )
				    {
						wantedLevel=15;
				    }
				    
				    if (holdwantedLevel<=16 && ( holdwantedLevel*difficulty>61 || totalBreakIns>30) )
				    {
						wantedLevel=16;
				    }
				    
				    if (holdwantedLevel<=17 && ( holdwantedLevel*difficulty>67 || totalBreakIns>32) )
				    {
						wantedLevel=17;
				    }
				    
				    if (holdwantedLevel<=18 && ( holdwantedLevel*difficulty>84 || totalBreakIns>34) )
				    {
						wantedLevel=18;
				    }
				    
				    if (holdwantedLevel<=19 && ( holdwantedLevel*difficulty>91 || totalBreakIns>36) )
				    {
						wantedLevel=19;
				    }
				    
				    if (holdwantedLevel<=20 && ( holdwantedLevel*difficulty>98 || totalBreakIns>38) )
				    {
						wantedLevel=20;
				    }
				   
				}

		public void getPosistions()
				{
					/* method finds the number of positions correct in the guess.
					 *  for example if the combo is 789 and the guess is 987, there is only 1 position (the 8) 
					 *  that is correct.
					 *  
					 *  the method also finds the number of digits correct, in the previous example
					 *  there would be 3 digits correct, although the guess would not be a winner since there is only
					 *  1 Position correct
					 *  
					 *  finally it checks if the combination is correct, if it is, isWinner will be set to true
					 */
					
					// reset the number of digits and positions to zero
					currentGuess.posistionsCorrect=0;
					currentGuess.digitsCorrect=0;
					char guessChar=(' ');
					char comboChar=(' ');
					int[] includeArray= new int[120]; // index for the array will be a digit in the guess, so if the guess is 222, index 2 will equal 3
														// the large index range account for having string inputs
					
					
					// check the number of positions correct
					for (int i=0; i<comboSize; i++) 
					{
						 guessChar=guessArray[turnCount].currentGuess.charAt(i);
						 comboChar=combo.charAt(i);
						 
						// check each character in the guess against the character in the combo at the same position
						if( guessChar==comboChar)
						{
							
							currentGuess.posistionsCorrect++; // if the condition matches, increment the number of positions correct

						}
						else;
						
					} 
					
					
					// check the number of digits correct
				
					for(int i=0; i<comboSize; i++) 
					{
					
						includeArray[(int)guessArray[turnCount].currentGuess.charAt(i)]++;
						
					} 
					
					for(int i=0; i<comboSize;i++)
					{ 	
						for(int j=0; j<comboSize;j++)
						{
							// excludeArray holds how many times a number appears in the guess
							// if a number hits a match with the combo, the array is decremented so
							// that it can only hit as many times as it exists in the guess
							
							if (guessArray[turnCount].currentGuess.charAt(j)==combo.charAt(i) && includeArray[guessArray[turnCount].currentGuess.charAt(j)] >0 )
							{						
								currentGuess.digitsCorrect++;
								
								includeArray[guessArray[turnCount].currentGuess.charAt(j)]--;
								break;
							}
								
						}
					} 
					
					if (currentGuess.posistionsCorrect==comboSize)
					{
						isWinner=true;
					}
					 
				} 
		
		public void setPlayer(player p)
		{
			//receives a player object and sets the current game value to the values in the object
			loot=p.loot;
			totalBreakIns=p.totalBreakIns;
			wantedLevel=p.wantedLevel;
			explosives=p.explosives;
			snips=p.snips;
			picks=p.snips;
			career=p.career;
		}
			

		public int digitsCorrect()
		{
			//return the digits correct from a guess object in the guess array
			if(!isAnalysisMode){
				
				if(turnCount>0)
					return guessArray[turnCount-1].digitsCorrect;
				return 0;
			}
			else
			{
				if(leftCounter>=turnCount)
				{
					return guessArray[0].digitsCorrect;
				}
				else if(leftCounter>0)
				{
					return guessArray[turnCount-leftCounter-1].digitsCorrect;
				}
				else
				{
					return guessArray[turnCount-1].digitsCorrect;
				}
			}
			
		}
		
		public int posistionsCorrect()
		{
			//returns the positions correct from a guess object in the guess array
			/*if(turnCount>0)
			return guessArray[turnCount-1].posistionsCorrect;
			else return 0; */
			
	if(!isAnalysisMode){
				
				if(turnCount>0)
					return guessArray[turnCount-1].posistionsCorrect;
				return 0;
			}
			else
			{
				if(leftCounter>=turnCount)
				{
					return guessArray[0].posistionsCorrect;
				}
				else if(leftCounter>0)
				{
					return guessArray[turnCount-leftCounter-1].posistionsCorrect;
				}
				else
				{
					return guessArray[turnCount-1].posistionsCorrect;
				}
			}
		}
		
		
		public void toggleAnalysis()
		{
			//toggles the state of isAnalysisMode, but factors a few other rules
			if(turnCount==0)
			{
				//do not permit analysis mode to be on when there are no guesses
				isAnalysisMode=false;
				return;
			}
			isAnalysisMode=!isAnalysisMode;
			
			if(!isAnalysisMode)
			{
				//reset the left counter when analysis mode is off
				leftCounter=0;
			}
		}

		public void incLeftCounter(boolean increment)
		{
			//increments or decrements the leftCounter based on the boolean parameter
			if(increment)
			{
				//rules to increment leftCounter
				if(leftCounter+1>=turnCount-1)
				{
					leftCounter=turnCount-1;
				}
				else
				{
					leftCounter++;
				}
			}
			else
			{
				//rules to decrement leftCounter
				if(leftCounter==0 )
				{
					// if the player comes back to the current guess from previous guesses, turn off analysis
					leftCounter=0;
					isAnalysisMode=false;
				}
				if(leftCounter>0)
				{
					leftCounter--;
					
				}
			}
		}
}
