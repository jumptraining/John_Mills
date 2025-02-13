package gameofdice;

import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class Button  implements ActionListener {
	JLabel jlab;
	JLabel jlab2;
	String first;
	String second;
	JButton jbtnUp;
	
	public void setButtons(JPanel frm, String f, String s) {
		first = f;
		second = s;

		//JButton jbtnUp = new JButton(first);
		jbtnUp = new JButton(first);
		JButton jbtnDown = new JButton(second);
		// Add action listeners.
		jbtnUp.addActionListener(this);
		jbtnDown.addActionListener(this);
		// Add the buttons to the content pane.
		frm.add(jbtnUp);
		frm.add(jbtnDown);
		// Create a label.
		jlab = new JLabel("Welcome to the dice throw challenge!");
		jlab2 = new JLabel("");
		// Add the label to the frame.
		frm.add(jlab);
		frm.add(jlab2);
	}
	
	// Handle button events.

	public void actionPerformed(ActionEvent ae) {
		
		String input[] = playGame();
		
		if(ae.getActionCommand().equals(first)) {
			jlab.setText(input[0]);
			jlab2.setText(input[1]);
			jbtnUp.setText("Play Again!");
		} else if(ae.getActionCommand().equals(second)){
			//just closes pane if clicks quit
			System.exit(0);
		}
	}//end actionPerformed
	
	
	public static String[] playGame() {
		
		String output[] = new String[2];
		
		String myArr[][] = {

				{"Snake eyes", "Australian yo", "Little Joe From Kokomo", "No field five", "Easy six", "Six one you're done"},
				{"Ace caught a deuce", "Ballerina", "The fever", "Jimmie Hicks", "Benny Blue", "Easy eight"},
				{"Easy four", "OJ", "Brooklyn Forrest", "Big Red", "Eighter from Decatur", "Nina from Pasadena"},
				{"Little Phoebe", "Easy Six", "Skinny McKinney", "Square pair", "Railroad nine", "Big one on the end"},
				{"Sixie from Dixie", "Skinny Dugan", "Easy eight", "Jesse James", "Puppy paws", "Yo"},
				{"The devil", "Easy eight", "Lou Brown", "Tennessee", "Six five no jive", "Midnight"}

			};//end array instantiation
		
		Random rand = new Random();
		
		int myFirstRoll, mySecondRoll;
		int computerFirstRoll, computerSecondRoll;
		Roll myRoll;
		Tie myTie;
		
		myRoll = () -> rand.nextInt(6) + 1;
		
		myTie = (myFirst, mySecond, comFirst, comSecond) -> {
			
			boolean myFlag = false;

			if((myFirst == mySecond) && (comFirst == comSecond)){
				myFlag = true;
			}else if((myFirst != mySecond) && (comFirst != comSecond)){
				myFlag = true;
			}

			return myFlag;
			
		};
		
		myFirstRoll = myRoll.getInt();
		mySecondRoll = myRoll.getInt();
		computerFirstRoll = myRoll.getInt();
		computerSecondRoll = myRoll.getInt();
	
		output[0] = "You have rolled a " + myFirstRoll + " and " + mySecondRoll + " > the \"" + myArr[myFirstRoll-1][mySecondRoll-1] + "\"";
		output[0] = output[0] + " I have rolled a " + computerFirstRoll + " and " + computerSecondRoll + " > the \"" + myArr[computerFirstRoll-1][computerSecondRoll-1] + "\"";
		
		if((myFirstRoll + mySecondRoll) > (computerFirstRoll + computerSecondRoll)){

			output[1] = "You win!! Did you cheat?? Gimme another try, c'mon press play again to throw dice or quit to exit.";

		}else if((myFirstRoll + mySecondRoll) < (computerFirstRoll + computerSecondRoll)){

			output[1] = "I win!! Wanna try again? Press play again to throw your dice or quit to exit.";

		}else {

			if(myTie.isTie(myFirstRoll, mySecondRoll, computerFirstRoll, computerSecondRoll)){
				//same numbers no matter what
				output[1] = "Stalemate! You're tough, let's try for a tie-breaker. Press play again to throw your dice or quit to exit";
			}else if(myFirstRoll == mySecondRoll){
				output[1] = "Damn! You win on a Double! What Luck! Did you cheat?? Gimme another try. Press play again to throw your dice or quit to exit.";
			}else{
				output[1] = "Damn! I win on a Double! Ah! I pity you fool. Wanna try again? Press play again to throw your dice or quit to exit.";
			}

		}//end if/else chain
		
		return output;
		
	}//end playGame
	
}//end Button class
