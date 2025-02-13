package trafficlight;


class MyThread implements Runnable {
	Thread thrd;
	boolean suspended;
	boolean stopped;
	Lights myLight;
	
	
	// Construct a new thread.
	MyThread(Lights myLight) {
		thrd = new Thread(this);
		
		//starting all threads in a suspended state
		suspended = false;
		stopped = false;
		this.myLight = myLight;
		thrd.start(); // start the thread
	}
	
	
	// Begin execution of new thread.
	public void run() {
		
		try {	
			
			System.out.println("Light is " + myLight.getString());
			Thread.sleep(myLight.getSeconds());		
			
		}catch(InterruptedException exc) {
			System.out.println(thrd.getName() + " interrupted.");
		}

	}//end run
	
	// Suspend the thread.
	synchronized void mySuspend() {
		//System.out.println("Pausing thread " + this.getMyName());
		suspended = true;
	}
	
	// Resume the thread.
	synchronized void myResume() {
		//System.out.println("Resuming thread " + this.getMyName());
		suspended = false;
		notify();
	}
	
	synchronized void myStop() {
		
		stopped = true;
		// The following ensures that a suspended thread can be stopped.
		suspended = false;
		
		notify();
	}//end myStop
	
	synchronized void myWait() {
		try {
			thrd.wait();
		} catch (InterruptedException e) {
			System.out.println("Error");
		}
	}
	
	synchronized boolean isMyAlive() {
		return thrd.isAlive();
	}
	
	
}//MyThread