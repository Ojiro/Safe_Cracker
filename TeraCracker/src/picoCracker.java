// variation on safe cracker based on enhanced classes and played in an arcade format

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class picoCracker
{
	//declare global variable
//	JButton[] numbers=new JButton[10]; // contains the numbers 0-9
//	JButton[] tools=new JButton[12]; // tools include help buttons, directions, enter, and tools
//	JButton[] levelSelect= new JButton[25];
	
	public static void main(String[] args)
	{
		picoCracker play= new picoCracker();
	}// ends main method
	
	picoCracker()
	{
		Safe box=new Safe(1);
		System.out.println("The Combo is: " + box.getCombo());
		Scanner input=new Scanner(System.in);
		String guess;
		for(int i=0; i<10; i++)
		{
			System.out.println("\n Enter " + box.getCombinationSize() + " Digits ");
			guess=input.nextLine();
			
			if(box.isCorrect(guess) )
			{
				System.out.println("Correct");
			}
			else
			{
				System.out.println("Posistions Correct: "+ box.getPosistionsCorrect());
				System.out.println("Digits Correct: " + box.getDigitsCorrect() );
				System.out.println();
				
			}
			
		}// ends for loop
		
	} // ends constructor
} // ends picoCracker Class
