/*
 * Class is responsible for the GUI and any event driven code
 * 
 * 
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class Interface
{
	JFrame mainWindow;
	JButton[] buttonArray;
	JPanel p0;
	JTextArea textWindow;
	CrackerJacker gameBoard;
	
	Interface(CrackerJacker newBoard)
	{
		gameBoard=newBoard;
		buttonArray= new JButton[25]; // buttons 0-9 correspond numbers, 10-18 are for directions and other buttons
										// 19-22 are for cheats
		welcomeScreen();
		
	}// ends constructor
	
	private void welcomeScreen()
	{
		// Welcome the player to game
		mainWindow= new JFrame();
		p0=new JPanel();
		textWindow=new JTextArea();
		
		mainWindow.setSize(775,500);
		p0.setSize(750,500);
		p0.setLocation(0,0);
		mainWindow.setLayout(null);
		p0.setLayout(null);
		
		mainWindow.add(p0);
		mainWindow.add(textWindow);
		
		textWindow.setSize(650,150);
		textWindow.setLocation(25,25);
		textWindow.setText("Welcome To Safe Cracker! ");
		textWindow.setEditable(false);
		
		for(int i=0; i<25; i++)
		{
			buttonArray[i]=new JButton();
			p0.add(buttonArray[i]);
		}
		buttonArray[0].setText("Let's Play");
		buttonArray[0].setLocation(300,200);
		buttonArray[0].setSize(100, 100);
		
		p0.add(buttonArray[0]);
		p0.add(textWindow);
		mainWindow.setVisible(true);
		p0.setVisible(true);
		textWindow.setVisible(true);
		
		buttonArray[0].setVisible(true);
		
	} // ends welcomeScreen
	
	public void LevelSelect()
	{
		// prompts player to select a level, or enter the cheat store (when available)
		for(int i=0; i<25; i++)
		{
			buttonArray[i].setSize(100,50);
			//set level Select Text, and location
			setLevelSelectButtons(i);
		}
		
	}//ends S
	
	private void loseScreen()
	{
		// red screen shows when the users fails to crack the safe and is busted
	}// ends loserScreen
	
	private void winScreen()
	{
		// green screen shows when the users cracks the safe
	}// ends loserScreen
	
	private void storeScreen()
	{
		
	}
	
	private void setLevelSelectButtons(int index)
	{
		int row1=200;
		int row2=250;
		int row3=300;
		int col1=50;
		int col2=150;
		int col3=250;
		switch(index)
		{
		case 0: buttonArray[index].setLocation(300,500); buttonArray[index].setSize(100,100); buttonArray[index].setText("Enter"); buttonArray[index].setVisible(true); break;
		case 1: buttonArray[index].setLocation(col1,row1); buttonArray[index].setSize(100,50); buttonArray[index].setText("Easy");buttonArray[index].setVisible(true); break;
		case 2: buttonArray[index].setLocation(col1,row2); buttonArray[index].setSize(100,50); buttonArray[index].setText("Piggy Bank"); buttonArray[index].setVisible(true); break;
		case 3: buttonArray[index].setLocation(col1,row3); buttonArray[index].setSize(100,50); buttonArray[index].setText("Home Safe"); buttonArray[index].setVisible(true); break;
		case 4: buttonArray[index].setLocation(col2,row1); buttonArray[index].setSize(100,50); buttonArray[index].setText("Motel Safe"); buttonArray[index].setVisible(true); break;
		case 5: buttonArray[index].setLocation(col2,row2); buttonArray[index].setSize(100,50); buttonArray[index].setText("Medium"); buttonArray[index].setVisible(true); break;
		case 6: buttonArray[index].setLocation(col2,row3); buttonArray[index].setSize(100,50); buttonArray[index].setText("Hotel Safe"); buttonArray[index].setVisible(true);break;
		case 7: buttonArray[index].setLocation(col3,row1); buttonArray[index].setSize(100,50); buttonArray[index].setText("ATM");buttonArray[index].setVisible(true); break;
		case 8: buttonArray[index].setLocation(col3,row2); buttonArray[index].setSize(100,50); buttonArray[index].setText("Hard"); buttonArray[index].setVisible(true); break;
		case 9: buttonArray[index].setLocation(col3,row3); buttonArray[index].setSize(100,50); buttonArray[index].setText("Bank Vault"); buttonArray[index].setVisible(true); break;
		default: buttonArray[index].setVisible(false); break;
		}
	}
} // ends Interface class
