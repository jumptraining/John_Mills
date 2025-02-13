import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * this class creates the cells with the persons name
 * and the button to book/unbook
 */
@SuppressWarnings("serial")
//public class MyCell extends JPanel implements ActionListener{
public class Cell extends JPanel{

	
	JLabel label;
	JButton button;
	
	public Cell(int i) {

		prepareGui(i);
	}
	
	private void prepareGui(int i) {
				
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		button = new JButton("Button " + i);
		label = new JLabel("Label " + i);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(button);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(label);
		
	}//end prepareGui
	

	
	private static String getCharForNumber(int i) {
	    return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
	}
	
}//end MyGrid class