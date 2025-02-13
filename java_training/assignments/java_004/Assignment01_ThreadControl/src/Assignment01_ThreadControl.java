import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JRootPane;

public class Assignment01_ThreadControl {
	
	private static CharListener listener = new CharListener();
	
	public static void main(String[] args) throws Exception{

		System.out.println("Main thread is starting");
		MyThread currentThread = null;
		MyThread threadArr[] = new MyThread[5];
		
		for(int i=0; i < 5; i++) {
			threadArr[i] = new MyThread(Integer.toString(i+1));
		}

		int counter = 5;
		int takeControl = 0;
		char input = ' ';
		

		boolean firstTimeThrough = true;
				
		do {
			
			try {
				if(counter != 0) {
					//input = br.readLine().toUpperCase();
					input = getCh();
					input = Character.toUpperCase(input);
				}else {
					break;
				}
	
				switch(input) {
							
					case '1':{
						
						if(firstTimeThrough == true) {
							currentThread = threadArr[0];
							firstTimeThrough = false;
						}
						
						currentThread = threadControl(takeControl, currentThread, threadArr, Character.getNumericValue(input));
						takeControl = 1;
						
						break;
					}//end case 1
					
					case '2':{
						
						
						if(firstTimeThrough == true) {
							currentThread = threadArr[1];
							firstTimeThrough = false;
						}
						
						currentThread = threadControl(takeControl, currentThread, threadArr, Character.getNumericValue(input));
						takeControl = 2;	
						break;
					}
					
					case '3':{
						
						if(firstTimeThrough == true) {
							currentThread = threadArr[2];
							firstTimeThrough = false;
						}
						System.out.println("TakeControl in case 3 is " + takeControl);

						
						currentThread = threadControl(takeControl, currentThread, threadArr, Character.getNumericValue(input));
						System.out.println("Current thread after method call: " + currentThread.getMyName());
						takeControl = 3;
						
						
						break;
					}
					case '4':{
						
						if(firstTimeThrough == true) {
							currentThread = threadArr[3];
							firstTimeThrough = false;
						}
						
						
						currentThread = threadControl(takeControl, currentThread, threadArr, Character.getNumericValue(input));
						takeControl = 4;
						
						break;
					}
					case '5':{
						
						if(firstTimeThrough == true) {
							currentThread = threadArr[4];
							firstTimeThrough = false;
						}
						
						currentThread = threadControl(takeControl, currentThread, threadArr, Character.getNumericValue(input));
						takeControl = 5;				
							
						break;
					}
					
					case 'S':{
						
						if(currentThread != null) {
							
							System.out.println("Permanently stopping the execution of Thread " + currentThread.getMyName());
							System.out.println();
							counter--;
							currentThread.myStop();
							printStatus(threadArr, currentThread);
											
						}//end big if
							
						break;
						
					}//end case S
					
					case 'T':{
						
						if(currentThread != null) {
							currentThread.setMyThreadPriority("T");
						}
						break;
						
					}
					
					case 'N':{
						
						if(currentThread != null) {
							currentThread.setMyThreadPriority("N");
						}
						break;
						
					}
					
					case 'L':{
						
						if(currentThread != null) {
							currentThread.setMyThreadPriority("L");
						}
						break;
						
					}
								
					default:{
						throw new WrongInputException();
					}
												
				}//end switch statement
			
			}catch(WrongInputException e) {
				System.out.println("Press 1-5 to access a thread. Press again to pause and resume the thread.");
				System.out.println("Press T to set priority to high, L for low, and N for normal.");
				System.out.println("Press S to terminate a thread.");
				continue;
			}
			
		}while(allAlive(threadArr));

			
		System.out.println("Main thread terminating");
		
	}//end main

	
	public static boolean allAlive(MyThread[] threadArr) {
		
		boolean flag = false;
		
		if(threadArr[0].isMyThreadAlive() || threadArr[1].isMyThreadAlive() || threadArr[2].isMyThreadAlive() || threadArr[3].isMyThreadAlive() || threadArr[4].isMyThreadAlive()) {
			flag = true;
		}
		
		return flag;
		
	}//end allAlive
	
	public static MyThread threadControl(int takeControl, MyThread currentThread, MyThread[] threadArr, int caseNum) {
						
		if(takeControl == caseNum) {
			//System.out.println("currentThread: " + currentThread.getMyName());
			if(currentThread.equals(threadArr[caseNum-1])) {
				
				if(currentThread.isSuspended()) {
					currentThread.myResume();
				}else {
					currentThread.mySuspend();
					
				}//end innermost if
				
			}
			
		}else {
			currentThread = threadArr[caseNum-1];
			System.out.println("Controlling thread " + currentThread.getMyName());	
		}//end outer if/else	
		
		return currentThread;
		
	}//end threadControl
	
	public static void printStatus(MyThread[] threadArr, MyThread currentThread) {
		
		String temp;
		
		for(int i=0; i < 5; i++) {
			
			temp = Integer.toString(i+1);
			if(threadArr[i].isMyThreadAlive() && !currentThread.getMyName().equals(temp)) {
				
				if(threadArr[i].isSuspended()) {
					System.out.println("thread " + (i+1) + ": paused");
				}else {
					System.out.println("thread " + (i+1) + ": running");
				}
				
			}
			
		}//end for loop
		
	}//end printStatus
	
	
	public static char getCh() {  
        
		JFrame frame = new JFrame();
        synchronized (frame) {  
            frame.setUndecorated(true);  
            frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);  
            
            listener.setFrame(frame);
            frame.addKeyListener((KeyListener)listener);  
            frame.setVisible(true);  
            try {  
                frame.wait();  
            } catch (InterruptedException e1) {  
            }  
        } 
        KeyListener klistener = frame.getKeyListeners()[0];
        return ((CharListener)klistener).getChar();
        
}
	
	
	

}//end class