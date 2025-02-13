package matrixinput;

import java.awt.*;

import javax.swing.*;

/*
 * This class creates the "Row A-J", "Seat 1-10"
 * and the grid layout that holds the cells with
 * buttons and the name of the person
 */
@SuppressWarnings("serial")
public class RowColumnLayout extends JPanel{

	/*
	 * could try to make them all gridlayouts to 
	 * get them to line up correctly
	 */
	JPanel seatPanel;			//will be flowlayout
	JPanel rowPanel;			//will be boxlayout
	JPanel gridPanel;			//will be gridlayout
	
	public RowColumnLayout(){
		
		this.setLayout(new BorderLayout());
		prepareRowAndColumn();
		
	}
	
	private void prepareRowAndColumn() {
		
		gridPanel = new JPanel(new GridLayout(10, 10));
		for(int i=0; i < 10; i++) {
			for(int j=0; j < 10; j++) {
				gridPanel.add(new MyCell(i, j));
			}
		}//end outer for
		
		//creating each new panel
		seatPanel = new JPanel(new FlowLayout(0, 44, 0));
		seatPanel.setAlignmentY(100);
		
		//added rigid area to set offset and line up with row of buttons
		rowPanel = new JPanel();
		rowPanel.setLayout(new BoxLayout(rowPanel, BoxLayout.Y_AXIS));
		rowPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		
		//adding Seat numbers and row numbers to each panel
		for(int i=0; i < 10; i++) {
			seatPanel.add(new JLabel("Seat " + (i+1)));

			//creates a gap in between each row to line up with buttons
			rowPanel.add(new JLabel("Row " + getCharForNumber(i+1)));
			rowPanel.add(Box.createRigidArea(new Dimension(0, 53)));

		}
				
		
		//adding all sub panels to overarching panel
		this.add(seatPanel, BorderLayout.NORTH);
		this.add(rowPanel, BorderLayout.WEST);
		this.add(gridPanel, BorderLayout.EAST);
		
	}//end prepareRow
	
	private static String getCharForNumber(int i) {
	    return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
	}
	
	
}//end class RowColumnLayout