package gameofdice;
import javax.swing.*;
import java.awt.*;

public class Driver{


	public static void main(String[] args){


		SwingUtilities.invokeLater(new Runnable() {
			Swing demo;
			JFrame frm;
			
			public void run() {
				demo = new Swing("Game of Dice!");
				frm = demo.getFrame();
				frm = setFrameStuff(frm, JFrame.EXIT_ON_CLOSE);
				frm.setVisible(true);
			}
		});
			
	}//end main
	
	public static JFrame setFrameStuff(JFrame frm, int onExit) {
		
		// this will center and size the JFrame on screen
		// it will have a height and width of half the screen
		centerAndSizeJFrameOnScreen(frm);
		frm.setDefaultCloseOperation(onExit);
		
		JPanel panel1 = new JPanel();
		
		panel1.setLayout(new FlowLayout());
		
		Button bd1 = new Button();
		bd1.setButtons(panel1, "Click to Play!", "Quit");

		
		frm.add(panel1);
		return frm;
	}
	
	public static void centerAndSizeJFrameOnScreen(JFrame frm) {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		
		// set the size of the frame to half in width and height
		frm.setSize(width/2, height/2);
		// here's the part where the JFrame gets actually centered
		frm.setLocationRelativeTo(null);
	}

}//end class