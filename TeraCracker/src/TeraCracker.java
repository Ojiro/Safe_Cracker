import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

// primary class for the Safe Cracker Game
/*
 * 	GAME OVERVIEW:
 * 
 *	In the game, the player takes on the role of a crook, the player takes on multiple levels
 *	in the form of safes. Each safe has a varying degree of difficulty. To crack the safe and win the level,
 *  all the player has to do is determine the combination to the safe. 
 *  
 *  Each safe contains a combination contain some number of digits (0-9) and possibly directions
 *  in the form of (U=up, D=Down, L=Left and R=Right). Each safe permits only so many attempts and
 *  only a limited amount of time.
 *  
 *  If the player fails to crack the safe with either the specified number of moves or within the time limit
 *  they will be busted and lose money.
 *  
 *  The player is also assigned a wanted level that dictates their bail out cost. If the player can't afford to bail out
 *  jail after being busted, the game is over.
 *  
 *  While playing, the user is not completely alone. The player will have the assistance of their handy-dandy CrackerJacker 3000DX,
 *  which after each attempt will tell them how many positions and digits they got correct in the combination, as well as how many 
 *  attempts they have left and how much time they have. 
 *  
 *  There are also several cheats available, but they don't come cheap. One cheat will deduce the size of the combination, another
 *  will completely blow the hinges off a safe, and finally one will delay the arrival of the cops and give the 
 *  player an extra move to try and break the safe.
 * 
 *  PROGRAM OVERVIEW:
 *  The program is divided into several classes that handle specific parts of the game.
 *  The TeraCracker class is the main class and it holds the general overview of the game.
 *  The Player class holds all the information on the player including their bankroll, bailout costs, safes broken, etc..
 *  The Safe class builds a new safe and interacts with the CrackerJacker class for gameplay
 *  The CrackerJacker class acts as the game board, communicating with safes and with the player
 *  The Interface class deals with the gui and event driven code. This shouldn't be done, use a gui class only
 *  
 *  The person playing the game will interact with the interface class
 *  interface talks with the player class, which talks with the CrackerJacker class, which talks with the safe
 */


public class TeraCracker
{

	/*
	 * GigaCracker is the graphical version of MegaCracker...
	 * 
	 * Player will try to break into  safes by guessing the combination which contains digits 0-9 and directions u,d,l, and r.
	 * Player wins loot by cracking safes and loses loot by failing to crack them within the alloted number of moves or time.
	 */
	
	/* To Do List
	 * 
	 * 
	 * Clear up display of loot and wanted level
	 * add comments
	 *  Consider what happens when the hideTools and hideButtons methods are changed
	
	 */
	


	public static void main(String[] args)
	{
		CrackerJacker board=new CrackerJacker();
		GUI GUI=new GUI();
		Interface Interface=new Interface(GUI,board);
		
		GUI.welcomeScreen();
		TeraCracker game=new TeraCracker();
		GUI.welcomeScreen();
		
	} // ends main Method
	

	
	
			
			
	
			
	
	
		

	
} // ends class

