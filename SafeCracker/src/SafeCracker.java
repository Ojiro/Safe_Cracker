// Guess the Combo Game
// program will produce a set of numbers and user must try to guess all the numbers
// user will have so many guesses to win before they lose 

import java.util.Scanner;

public class SafeCracker
{
	public static void main(String[] args)
	{

		// Introduces the game to the user
		
		welcomeText();


			// Declare variables to use in the game 
		
		Scanner input=new Scanner(System.in);	// new scanner for inputing difficulty	
		int gameLevel=3;   // determines how many numbers are in the combination
		int attempts=10;   // tracks the number of attempts the user has
		int loot=1500; 	  // tracks the amount of money the player has
		int breakIns=0;    // tracks the number of safes broken int
		int wantedLevel=1; // tracks the skill of the user and helps determine cost of bailout
		int bail=500;     // determines how much money (loot) the user loses for failing to crack a safe
		int payout=500;  // holds payout value for cracking safes
		int special=0;  // special holds a value that will determine special additions to the game
		int lockModifier=0; // holds a value that will subtract the number of locks on a safe
		int guesses=0;   // tracks how many guesses the user has made
		System.out.println("  ");
		System.out.println("  ");

		
		


		// determine difficulty to help create a random combination

		while(loot>0){    // loop allows user to play more safes even after beating or failing a level, so long as they have money

			int storeNumber=(int)(Math.random()*100001);  // assigns a random number as the selection for the pro shop

			requestDifficulty(loot, wantedLevel, storeNumber);   // displays text for requesting difficulty

			int difficulty= input.nextInt();
	
			if(difficulty==1)
			{
				gameLevel=3; 
				attempts=10; }
			else if (difficulty==2)
			{
				gameLevel=4;
				attempts=9;  }
			else if (difficulty==3)
			{
				gameLevel=5;
				attempts=9; }
			else if (difficulty==4)
			{
				gameLevel=5;
				attempts=8; }
			else if (difficulty==5)
			{
				gameLevel=5;
				attempts=6; }
			else if (difficulty==6)
			{
				gameLevel=6;
				attempts=7; }
			else if (difficulty==storeNumber){
				special=gameStore(difficulty);
				loot= specialDebit(special, loot);
				lockModifier=lockRedux(special,lockModifier); 
				wantedLevel=wantRedux(special, wantedLevel);
				special=0;
				continue;   }

			else{
				difficulty=1; }    // else clause give player the easiest setting if they enter an invalid number

			final int MAX_ATTEMPTS=attempts;  // holds the max number of attempts for use in listHistory method


			// Displays loot and wanted level after starting a new safe, but not between guesses

			System.out.println(" ");
			System.out.println("=====================================================");
			System.out.println("Bank Account: $" +loot+ ": Wanted Level " + wantedLevel);
			System.out.println("=====================================================");
			System.out.println("  ");

					


				//  creates a combination

			int[] comboArray= new int[gameLevel];
			makeCombo(comboArray, gameLevel, lockModifier);
	
		
			lockModifier=0;   // resets lockModifier if somebody bought a bonus
	
	

				
			// recieve guess for combination from the user


			int[] guess= new int[MAX_ATTEMPTS];
	
				


			while(attempts>0) // starts loop to recieve guesses from user
			{ 			

						
				int[] guessArray= new int[gameLevel];
				System.out.println("Enter a " + gameLevel + " digit combination");
				
				for(int i=0; i<gameLevel; i++)
				{
					System.out.print(" =>  ");
					guessArray[i]=input.nextInt();
					
						if (guessArray[i] >= 10)
						{
							simplifyGuess(guessArray);  // program will sort out a combo not seperated by spaces
							break;
						}    
  							
				} // ends for loop
		
				

				// assigns values to an array to display previous guesses in listHistory
				
				for(int i=0; i<gameLevel; i++)
				{	
					
					int a=(guessArray[gameLevel-1-i]*( (int)(Math.pow(10, i) ) ) );
					guess[guesses]+=a;
				}	

			
 
				// Determine posistions correct and number of digits correct

				int posistionCount=getPosistions(guessArray,comboArray,gameLevel);
				int correctCount=getNumberCorrect(guessArray,comboArray);		
			

				// Informs user of result of guess and determines game status

	
				if(posistionCount>=gameLevel){
					payout=getPayout(difficulty,wantedLevel);
					loot=loot+payout;
					System.out.println("--------------------------------------");
					System.out.println("          Nice!    ");
					System.out.println("You cracked the safe! you got $"+payout);
					System.out.println("--------------------------------------");
					System.out.println("  ");
					System.out.println("  ");
					System.out.println("  ");
					System.out.println("  ");
					System.out.println("  ");
					System.out.println("Ready to crack another safe?");
					System.out.println("  ");
					breakIns++;
					wantedLevel=mostWanted(breakIns); 
					guesses=0;
					break;
					 	
					} // ends if
			
				else if(attempts==1){
					attempts--;
					bail=getBail(difficulty, wantedLevel);
					loot=loot-bail;
					System.out.println("--------------------------------------");
					System.out.println("          Busted!                     ");
					System.out.println("You failed to crack the safe, you had to bail-out $" +bail+"!"); 
					System.out.println("--------------------------------------");
					System.out.println("  ");
					System.out.println("  ");
					System.out.println("  ");
					System.out.println("  ");
					System.out.println("  ");
					System.out.println("Try not to get busted this time!");
					System.out.println("  ");
					guesses=0;
					break;
					 }

				else{
					attempts--;
					System.out.println("   ");
					listHistory(guess, guesses);
					System.out.println("===>You've guessed " + correctCount   + " numbers and " +posistionCount+ " spots correctly");
					System.out.println("==>You have " +attempts+ " attempts remaining");
					System.out.println("   ");
					guesses++;
					 }  // ends else

				
				
	
			} // ends guessing loop

		} // ends game loop

	if(loot<= 0)
	{
		System.out.println("Looks like breaking safes isn't your thing; but at least you'll have plenty of time to learn a new skill in prison");
		System.out.println("Game Over!");
	}
	

} // ends main method

//
//
//
//=============================================================================================|
//=============================================================================================|
// 						**METHODS**           		  	       |
//=============================================================================================|
//	#1 makeCombo -- #2 getPosistions -- #3 getPayout -- #4 getNumberCorrect -- #5 getBail  
// #6 welcomeText -- #7 mostWanted -- #8 requestDifficulty -- #9 gameStore --  #10 specialDebit
// #11 lockRedux -- #12 wantRedux -- #13 listHistory -- #14 simplifyGuess
//=============================================================================================|
//  
//
//
//


//#1
//  makeCombo 
//
// produces the numbers for the combonation
// not currently in use
//
//
	public static void makeCombo(int[] comboArray, int gameLevel, int lockModifier)
	{

		 for(int i=0; i<gameLevel-lockModifier; i++)
				{
				   comboArray[i]=(int)(Math.random()*10);
				
				   if(comboArray[0]==0)
					continue;  // this condition prevents the first digit from ever being a 0
				 }  

		
	} // ends makeCombo

	
// #2 
// getPosistions 
//
// tells how many posistions are correct
// i.e if the combo is 1 2 3 and the user guesses 3 2 1, only 1 posistion is correct
//
//
		public static int getPosistions(int guessArray[], int comboArray[], int gameLevel){
			int posistionCount=0;
			for(int i=0; i<gameLevel; i++){
				if (guessArray[i]==comboArray[i]){
					posistionCount++; 
					} // ends if
				} // ends for loop

			return posistionCount;

		} // ends getPosistion Method

//
// #3
//
// getPayout
//
// determines how much to pay user for a cracked safe
//	determines a random payout within bounds of th difficulty
//
		public static int getPayout(int difficulty, int wantedLevel){
			
		int payout=0;
			
			while(true)
			{
				
				int random=(int)(Math.random()*1001);
				if (difficulty == 1)
				{
					payout=random; 
				}
				else 
				{
					payout=2*random*wantedLevel; 
				}

				
				if(wantedLevel<= 2)
				{
					if (payout<250)
					{	payout*=2;
						break;
					}
					else
						break;
				}
				else if(wantedLevel<=4)
				{
					if (payout<1000)
					{
						payout*=4;
						break;
					}
					else
						break;
				}
				else if( wantedLevel> 4)
				{
					if (payout<2000)
					{
						payout*=10;
						break;
					}
				else	
					break;
				} // ends else if
			} // ends while loop
		
			return payout;
				
		} // ends payout method

// #4
//
// getNumberCorrect
//
//

	public static int getNumberCorrect(int guessArray[], int comboArray[]){

			int correctValue=0;
			int testSize= guessArray.length;      
			int l=(guessArray.length);
			int[] excludeArray= new int[10];
			int[] includeArray= new int[10];  // check for repeating values in combo, if they repeat add them to list
			int in=0;
			int ex=0;  // exclude array and ex are used to exclude a guess value that has already hit


			// create 2 loops to check repeating numbers in both guess and combo

			for (int i=0; i<l; i++){
				int f=guessArray[i];
				excludeArray[f]++;
				} // ends exclude for
			for (int e=0; e<l; e++){
				int f=comboArray[e];
				includeArray[f]++;	
				} // ends include array
			
			for(int i=0; i<testSize; i++){
				for(int n=0; n<testSize; n++){

					int z=guessArray[n];

					  if(excludeArray[z] < includeArray[z]){
						includeArray[z]--; 
						 }
					  else if(excludeArray[z]==0 || includeArray[z] == 0){
						 }	
					  else if(comboArray[i]==guessArray[n]){
						correctValue++;
						break; }  // breaks the inside for loop
					else;

						
						 
									
				} // ends n for loop
			} // ends i for loop  
			return correctValue;
						
	
	} // ends getNumberCorrect


// #5
//
// getBail
//
		public static int getBail(int difficulty, int wantedLevel)
		{
			int setBail=500;
			setBail=500*difficulty*wantedLevel;
			return setBail;
		
		} // end getBail

// #6
// 
// welcomeText
// introduces the game
// 


		public static void welcomeText()
		{
		
		System.out.println("  ");
		System.out.println("  ");
		System.out.println("          Welcome to SafeCracker!");
		System.out.println("--+-------------+------------+-------------+-----------+--------+--");
		System.out.println("To play: ");
		System.out.println("-Guess the combination, if you guess correctly you win loot");
		System.out.println("-But be careful not to get busted by the cops");
		System.out.println("-As long as you have enough loot, you can bail out");
		System.out.println("-But the more safes you break, the more costly getting caught is");
		System.out.println("    ");
		
	
		} // ends welcomeText

// #7
// mostWanted
//
// determines the how wanted the user is by the cops based on the number of sucessfull break-ins
//
		public static int mostWanted(int breakIns)
		{
			int wantedLevel=1;
			
			if (breakIns<2){
				wantedLevel=1;}
			else if (breakIns< 4){
				wantedLevel=2; }
			else if (breakIns<6){
				wantedLevel=3; }
			else if (breakIns<10){
				wantedLevel=4; }
			else if (breakIns<20){
				wantedLevel=5; }
			else{
				wantedLevel=6; }

			return wantedLevel;

		} //  ends mostWanted

// #8
//
// requestDifficulty 
//
// ask user to input a difficulty setting 
//
//
		public static void requestDifficulty(int loot, int wantedLevel, int storeNumber){
			System.out.println("    ");
			System.out.println("==================================================");
			System.out.println("Select difficulty                     Bank Account: $" +loot  );
			System.out.println("				      Wanted Level: " +wantedLevel );
			System.out.println("    ");
			System.out.println("(1) = Easy; 3 digits ");
			System.out.println("(2) = Medium; 4 digits");
			System.out.println("(3) = Hard; 5 digits  ");
			System.out.println("(4) = Jewel Theft; 5 digits");
			System.out.println("(5) = D.B. MasterTheft; 5 digits");
			System.out.println("(6) = Heistenberg; god of safe crackers, 6 digits");
			System.out.println("(" +storeNumber+ ") = Enter Pro Shop");
			System.out.println("   ");
		
		} // ends requestDifficulty

// #9
//
//
// gameStore 
// determines special additions to the game
//

		public static int gameStore(int loot)
		{

			int tip=1;
			if (loot%2==0)
				tip=2;
			else if (Math.random()>.50)
				tip=3;
			else;
			
			Scanner input=new Scanner(System.in);
			System.out.println("  ");
			System.out.println("  ");
			System.out.println("  ");
			System.out.println("==================================================");
			System.out.println("   Welcome to the Pro Shop           loot $" +loot);
			System.out.println("==================================================");
			
				if(tip==1)
					System.out.println("			Pro Tip #1: No combonation will every start with 0");
				else if (tip==2)
					System.out.println("                    Pro Tip #2: Keep track of your numbers on the guess bar");
				else if (tip==3)
					System.out.println("			Pro Tip #3: Payout from a safe is determined by difficulty and your wanted level");
				else;
			
			System.out.println("  ");	
			System.out.println("(1) C-95: an small, powerful, localized explosive that removes a posistion on a safe. $2500");
			System.out.println("(2) Comlumbian Camo: lowers your wanted level by 1  $3500");
			System.out.println("(0) Exits Pro Shop");
			int a= input.nextInt();
			return a;
		} // ends gameStore

//
// #10
//
// specialDebit 
//
// determines how much to reduce from loot for making a purchase
//
//
//
		public static int specialDebit(int special,int loot)
		{
			int a=loot; 
			if(a==1){
				a=-2500; }
			else if(a==2){
				a=-3500; }
			else;

			return a;
		} // end specialDebit

//
// #11
//
// lockRedux
//
//
//
		public static int lockRedux(int special, int lockModifier)
		{
			int a=lockModifier;
			if (special==1){
				a++;}
			else;

			return a;
		} // ends lockRedux

// #12
//
//
//
// wantRedux 
// reduces wanted level
//
//
		public static int wantRedux(int special, int wantedLevel)
		{
			int a=wantedLevel;
			if(special==2 && wantedLevel != 1){
				a--; }
			else;

			return a;
		} // end wantRedux
// #13
//
// listHistory
// Creates a line displaying previous guesses
// Method has a glitch where leading zeros aren't displayed
//
//

	public static void listHistory(int[] guess, int guesses)
	{
			
		System.out.println("--------------------------------------");

		for(int i=0;i<=guesses;i++)
		{

			int s=(int)(Math.pow(10,guess.length-1));
	
			if(i==guesses)
				System.out.print("| " +guess[i]+ " |");
				
			else
				System.out.print(guess[i] +" ");
		}					

		System.out.println(" ");
		System.out.println("--------------------------------------");

	} // ends listHistory

// #14
//  simplifyGuess
// 	Takes a combo not already seperated by spaces and places it into proper format
//	Method is not complete
	
	public static void simplifyGuess(int[] guessArray)
	{
			int l=guessArray.length;
			int hold=guessArray[0];
					
			for(int i=0; i<l; i++)
			{
				
				int v=(int)(hold/ (Math.pow(10, l-1-i) ) );
				guessArray[i]=v;
				hold-=v*(int)(Math.pow(10, l-1-i) );
			}

		
	}



//=====================================================================|
//=====================================================================|
//			ends of method list
//=====================================================================|
		
					


} // ends class

