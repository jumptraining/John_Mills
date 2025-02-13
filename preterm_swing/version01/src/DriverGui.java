import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * the gui that holds all the other components together
 */
public class DriverGui{

	JFrame frm;
	Room room;
	
	//need to figure out how to put this on the left
	//side of the GUI. Figure out functionality later
	MyList jlstHolder;
	JScrollPane scroller;
	Client[] myList;
	JPanel gridPanel;
	
	
	//Only need to add a text label to this
	//at the top
	JLabel top;
	ResetPrintPanel bottom;
	RowColumnLayout gridHolder;
	
	
	public DriverGui(Client[] myList) {
		//frm = new JFrame("Big matrices go uWu");
		this.myList = myList;
		prepareGUI();
	}
	
	
	private void prepareGUI() {
		
		frm = new JFrame("Big matrices go uWu");
		
		//TODO
		//this is a placeholder until i know
		//what size this needs to be
		frm.setSize(975, 800);
		frm.setLocationRelativeTo(null);
		frm.setLayout(new BorderLayout());
				
		//sets the label to top center in conjunction
		//with frm.add(top, BorderLayout.NORTH);
		top = new JLabel("2nd Matrix Demo");
		top.setHorizontalAlignment(JLabel.CENTER);
		top.setVerticalAlignment(JLabel.CENTER);
		
		
	
		//setting list in jframe
		jlstHolder = new MyList(myList);
		scroller = new JScrollPane(jlstHolder.getJList());
		scroller.setPreferredSize(new Dimension(120, 90));
		
		//creating gridholder with another borderLayout
		//taken care of in another class
		gridHolder = new RowColumnLayout(jlstHolder);
		
		//adding bottom panel with the 2 buttons in it
		bottom = new ResetPrintPanel(jlstHolder, gridHolder);

		
		//adding components to frame
		frm.add(bottom, BorderLayout.SOUTH);					//sets my button panel to bottom of screen
		frm.add(scroller, BorderLayout.WEST);					//sets scroller to left side of screen
		frm.add(top, BorderLayout.NORTH);						//sets "top" to the top center of screen along with alignments
		frm.add(gridHolder, BorderLayout.CENTER);
		frm.setVisible(true);
		

		//kills program after gui is exited
		frm.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	        	 System.exit(0);
	         }        
	      }); 
		
	}//end prepareGUI
	
}//end class MyGrid