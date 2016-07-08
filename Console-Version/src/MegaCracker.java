/*
 * SafeCracker is a game where a player tries to break safes by guessing the combination. The number of digits to guess is dependant
 * on the difficulty. Harder levels also have fewer guesses. When the user makes a guess, the program tells the player how many digits they 
 * got correct as well as how many positions they got correct. When the player guesses the combination, they win money, called loot. If they
 * fail to break the safe in the alloted number of guesses, they get busted and have to bail out, which comes out of their loot.
 * if the player can't afford to bail out, the game ends. 
 * 
 * MegaCracker is a variant on safecracker. As opposed to strictly using numbers to for the combination, 
 * there will be numbers and several characters that represent directions on
 * the lock, U for up, D for Down, L for Left, and R for Right.  This version of the game will be more difficult by nature
 * so caution must be made in designing difficulties, payout and bail.
 * 
 * Current to do list:
 * -Create methods to analyze how many numbers and locations are correct
 * -Create a pro-shop for add on to the game
 * -Improve display
 * -Create a scanner that will read and write to a file that makes a high score list
 * 		- Create an option to exit the game that saves the user profile 
 * 
 */

import java.util.Scanner;
public class MegaCracker
{
	public static void main(String[] args)
	{
		// declare variables
		String combo;
		String[] guess=new String[11];  // will hold a history of guesses for the player
		int[] pro = new int[1];
		int turns=1; // counts the number of turns
		int loot=2500;  // players wallet, used to buy upgrades and bail out. If <= 0 then player loses
		int difficulty=1;  
		int gameLevel=3;  // the number of spots to guess in the combo, i.e. 3 means there will be 3 spots to guess
		int guesses;
		int totalBreakIns=0;
		int wantedLevel=1;
		
		// Welcome player to the game
		welcomeText();
			
		while(true) // loop plays the entire game for multiple safes, call this the game loop
		{
			 
			// Request Difficulty
			difficulty=getDifficulty(loot, wantedLevel, totalBreakIns, pro);
			guesses=getGuesses(difficulty);
			gameLevel=getLevel(difficulty);
			combo=makeCombo(difficulty, gameLevel);
			
			
			
			// begin playing a safe
			for(int i=0; i<=guesses; i++) // for loop plays each safe, call this the safe loop
			{
				// guessHistory(guess, i)
			//	System.out.println("							"+ combo);
				Scanner input=new Scanner(System.in);
				System.out.println("Enter "+gameLevel+ " digits and directions");
				System.out.print("====> ");
				guess[i]=input.nextLine();
				guess[i]=guess[i].toUpperCase();
				
				if (guess[i].equalsIgnoreCase(combo)==true)  // triggers a winner display if the guess = combo
				{
					totalBreakIns++;
					loot=getPayout(loot, difficulty);
					 wantedLevel=wantedLevel(guess[i].equalsIgnoreCase(combo), difficulty, wantedLevel, totalBreakIns);
					 break;
				}
				else if(i+1==guesses) // triggers a loss display if all the guesses are used
				{
					loot=getBail(loot, difficulty, wantedLevel, combo);
					 wantedLevel=wantedLevel(guess[i].equalsIgnoreCase(combo), difficulty, wantedLevel, totalBreakIns);
					 break;
				}  
				else // displays the number of positions and digits correctly guessed
				{
					statusUpdateInGame(guess, combo, guesses,i);
				}
				
			}// ends for loop for each safe (safe loop)
			
			if (loot<=0)
			{
				System.out.println("You're out of loot, looks like your carrer is over");
				break;
			}
		} // ends game loop
		
	} // ends main method
	
//========================================================================================================================================================
//			METHODS						METHODS 					METHODS				METHODS
//========================================================================================================================================================

//#1
// welcomeText
//
	public static void welcomeText()
	{
		System.out.println("		Welcome to SafeCracker Version 2!");
		System.out.println("-----------------------------------------------");
		System.out.println(" ");
		System.out.println("The object of this game is to acquire loot by cracking safes");
		System.out.println("Your Cracker-Jacker 5000 DLX will tell you how many posistions and digits you get right");
		System.out.println("However, don't take to long, otherwise you'll get busted by the cops and have to bail out");
		System.out.println("If you run out of loot, or can't make bail, your career is over.");
		System.out.println("");
		System.out.println("Combinations will have digits and sometimes directions");
		System.out.println("Directions include: D, U, L, and R");
		
		
	}

// #2
//	getDifficulty
// Receives the desired difficulty of the next safe from the user
// also prints an update for the user between games
	public static int getDifficulty(int loot, int wantedLevel, int totalBreakIns, int[] pro)
	{
		while(true)  // loop repeats if the player uses the proshop
		{
		// print a brief status update
		System.out.println("                               loot: "+loot+ "     Wanted Level: " + wantedLevel+ "    Safes Broken: " + totalBreakIns);
		System.out.println(" ");
		
		// recieve difficulty from user
		int difficulty=1;
		Scanner input= new Scanner(System.in);
		System.out.println("(1) Easy- 3 spots, no directions");
		System.out.println("(2) PiggyBank - 3 spots, 1 direction");
		System.out.println("(3) KittyBank - 4 spots, 1 direction");
		System.out.println("(4) Medium- 5 spots, 2 directions");
		
		
		int proCode=(int)(Math.random()*123456); // this variable is used to hold the access code for the proshop
		if (totalBreakIns>=4) // this will reveal a special access code to enter the proshop and buy add ons
		{
			System.out.println("("+ proCode + ") Enter Pro Shop");
			continue;
		}
		while (true) // loop repeats if the user inputs an invalid entry, this loop may be deleted
		{
		System.out.println("");
		System.out.print(" Enter difficulty level ==> ");
		difficulty=input.nextInt();
		 
		if (difficulty <1 || difficulty>4)
		{
			System.out.println("Sorry, that is an invalid entry");
			continue;
		}
		else if(difficulty==proCode)
		{
			//proShop(loot, pro)
			continue;
		}
		else
			break;
		}
		
		System.out.println("------------------------------------");
		System.out.println(" ");
		return difficulty;
		} // ends while loop
		
	}
//#3
// getGuesses
// returns the number of guesses a player will have to try and break a safe
	public static int getGuesses(int difficulty)
	{
		int guesses;
		if(difficulty <= 5)
			guesses=10;
		else
			guesses=10;
		
		return guesses;
	}
// #4
// getLevel
// Determines the number of slots to be used in a safe
	public static int getLevel(int difficulty)
	{
		int level;
		if (difficulty<=2)
			level=3;
		else if (difficulty==3)
			level=4;
		else
			level=5;
		
		return level;
	}
// #5
// makeCombo
// returns a combination based on the difficulty
	public static String makeCombo(int difficulty, int gameLevel)
	{	
	
	
		
		/* each time a safe is played the appropriate number of digits will be placed into a concatenated string called combo
		 * for each spot, use the randomNumber method to return a digit, the no-arg method will return 0-9, the integer arg(use any number)
		 * will return 1-9 but no zeros, this is required for the first digit in the combination. and use a character to return a direction
		 *  */
		
		while(true)
		if (difficulty<=1) // sets 3 spots with no directions
		{
		
			String a=randomNumber(1);
			String b=randomNumber();
			String c=randomNumber();
			
			
			return new String(a+b+c);
			//return new String("222");
			
		}
		else if (difficulty==2) // sets 3 spots with 1 direction
		{
			String a=randomNumber(1);
			String b=randomNumber();
			String c=randomNumber('c');
			 
			return new String(a+b+c);
		}
		else if (difficulty==3) // sets 4 spots with 1 direction
		{
			String a=randomNumber(1);
			String b=randomNumber();
			String c=randomNumber();
			String d=randomNumber('c');
			
		
			return new String(a+b+c+d);
		} 
		else if (difficulty==4) // sets 5 spots with 2 directions
		{
			String a=randomNumber(1);
			String b=randomNumber();
			String c=randomNumber();
			String d=randomNumber('c');
			String e=randomNumber('c');
			
			return new String(a+b+c+d+e);
		}
		else
		{
			System.out.println("Error Creating Combo");
			return new String("E");  // returns an error that will show up for debugging, combo must be showing	
			
		
		}
	}
// #6
//	randomNumber, no-arg
//  creates a random digit from 0-9
	public static String randomNumber()
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
		else
		{
			String f= new String("F");
			return f;
		}
		
		} // ends loop
		
		
		
	} // ends randomNumber(no arg)

	
	
// #7
// randomNumber(integer argument)
// creates a random digit from 1-9, zero will not be an option
// integer argument is completely irrelevant to the method and only invokes a method that will not return a zero
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
			else
			{
				String f= new String("F");
				return f;	
			}
			
			} // ends loop
		
		} // ends randomNumber(int)
		
// #8
// guessHistory
//
		public static void guessHistory(String[] guess, int i)
		{
			System.out.println("--------------------");
			for(int j=0; j<=i;j++)
			{
				if (j==i)
					System.out.print("|");
				System.out.println(" "+ guess[j]);
				if (j==i)
					System.out.print("|");
			}
			System.out.println("--------------------");
		} // ends guessHistory
	// #9
	// getPayout
	//
		public static int getPayout(int loot, int difficulty)
		{
			int a=(int)(Math.random()*1000*difficulty);
			loot+=a;
			System.out.println(" ");
			System.out.println("===================================================");
			System.out.println("Nice! You cracked the safe, you \"found\" $" + a);
			System.out.println("===================================================");
			return loot;
		}
	
	// #10
	// getBail
	//
		public static int getBail(int loot, int difficulty, int wantedLevel, String combo)
		{
			
			loot-=500*wantedLevel*difficulty;
			
			System.out.println(" ");
			System.out.println("===================================================");
			System.out.println("Busted! You failed to crack the safe. Bailed out $"+(500*wantedLevel*difficulty));
			System.out.println("The combo was: " + combo);
			System.out.println("===================================================");
			
			return loot;
		}

	// #11
	// randomNumber(char)
	// returns a direction character U,D,L,R
		
// #8
// randomNumber(char argument)
// creates a number 0-9 or a character U,D,L,R,I
		public static String randomNumber(char z)
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
		
// #12
// wantedLevel
//
		public static int wantedLevel(boolean f, int difficulty, int wantedLevel, int totalBreakIns)
		{
			if (wantedLevel<=1)
			{
				if(difficulty*wantedLevel>=3 || totalBreakIns >=2)
					wantedLevel=2;
				else;
				
				return wantedLevel;
			}
			else if (wantedLevel==2)
			{
				if(difficulty*wantedLevel>7 || totalBreakIns>=5)
					wantedLevel=3;
				else;
				
				return wantedLevel;
			}
			else
				return wantedLevel;
				
		}
// #13
// statusUpdate(guess, combo)
// creates a status bar for the user as to the state of the game
// update tells the user how many positions and number they got right, and how many guesses are left
		
		public static void statusUpdateInGame(String[] guess, String combo, int guesses, int currentGuess )
		{
			int remainingGuesses=guesses-currentGuess-1; 
			int posistionsCorrect=0; // holds the number of positions guessed correctly
			int numberCorrect=0; // hold the number of digits guessed correctly
			
			 posistionsCorrect=getPosistions(guess[currentGuess], combo);
			numberCorrect= getNumber(guess[currentGuess], combo);
			
			System.out.println("|=====================================================================|");
			System.out.println("|       Cracker-Jacker 5000 DLX 	                              |");									  
			System.out.println("|---------------------------------------------------------------------|");
			
			for (int i=0; i<currentGuess+1; i++)  // loop prints out the previous guesses, note that i is reused from the method header
			{
				if (i==currentGuess)
					System.out.print("|");
				System.out.print(" "+ guess[i]);
				if (i==currentGuess)
					System.out.print("|");
			}
			
			System.out.println(" ");
			System.out.println("|---------------------------------------------------------------------|");
			System.out.println("|Digits Correct: " + numberCorrect + "    Posistions Correct: " + posistionsCorrect + "    Remaining Guesses: " + remainingGuesses +"   |");
			System.out.println("|=====================================================================|");
		}
//#14
// posistionsCorrect
//
		public static int getPosistions(String guess, String combo)
		{
			int posistionsCorrect=0;
			
			int z=combo.length();
			
			for (int i=0; i<z; i++)
			{
				if(guess.charAt(i)==combo.charAt(i))
				{
					posistionsCorrect++;
					
				}
				else;
			}
			
		
			return posistionsCorrect;
			
		} // ends posistionsCorrect method
// #15
// getNumber
// Determines how many digits are correct. This method requires the most attention
// for determining winners. 
// i.e. if guess is 123 and combo is 321, this method should return 3
		public static int getNumber(String guess, String combo)
		{
			int numberCorrect=0;
			int z=combo.length();
			int[] includeArray= new int[100]; // index for the array will be a digit in the guess, so if the guess is 222, index 2 will equal 3
			
			for(int i=0; i<z; i++)  // loop fills arrays with proper values
			{
			
				includeArray[(int)guess.charAt(i)]++;
				
			} 
			
			for(int i=0; i<z;i++) // i loop will call up values in the combo
			{ 
				
				
				for(int j=0; j<z;j++) // j loop will call up values in the guess
				{
					// excludeArray holds how many times a number appears in the guess
					// if a number hits a match with the combo, the array is decremented so
					// that it can only hit as many times as it exists in the guess
					
					if (guess.charAt(j)==combo.charAt(i) && includeArray[guess.charAt(j)] >0 )
					{						
						numberCorrect++;
						
						includeArray[guess.charAt(j)]--;
						break;
					}
						
				}  // ends j loop
			} // ends i loop
			
			return numberCorrect;
		}
// #16
// proShop
//
		public static void proShop(int loot, int[] pro)
		{
			System.out.println("Welcome to the ProShop");
			System.out.println("----------------------");
			System.out.println("");
			System.out.println(" We ain't got jack for you right now, so come back later");
		}

// #17 
//
//
		
}





