import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

//start of key listener
//Key Listener implementation written by Alice Storey, all credit goes to her
//for a top notch approach to entering characters seamlessly.
public class CharListener implements KeyListener {
	JFrame frame = new JFrame();
	char result = ' ';

	CharListener() {
		super();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		synchronized (frame) {
			frame.setVisible(false);
			frame.dispose();
			frame.notify();
		}
		result = e.getKeyChar();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JFrame getFrame() {
		return this.frame;
	}

	public char getChar() {
		return result;
	}

}

	
	

