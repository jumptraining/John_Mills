import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class DriverGui {

	JFrame frm;
	JPanel panel;
	JLabel top;
	JPanel grid;
	
	
	public DriverGui() {
		
		frm = new JFrame("Grid Demo 2");
		frm.setSize(400, 250);
		frm.setLayout(new GridBagLayout());
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		
		top = new JLabel("Push a Button");
		top.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		grid = new JPanel(new GridLayout(2, 3));
		for(int i=0; i < 6; i++) {
			grid.add(new Cell(i+1));
		}
		
		
		panel.add(top);
		panel.add(grid);
		frm.add(panel);
		
		frm.setVisible(true);
		
		frm.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	             // this is the way to force a java application to gracefully exit
	             // when not going to end via the main method entry point
	             System.exit(0);
	         }        
	      });
		
		
	}//end DriverGui constructor
	
	
}//end DriverGui class