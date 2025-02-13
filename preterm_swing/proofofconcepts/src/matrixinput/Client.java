package matrixinput;


//test class to input into matrix
public class Client {
	private String lastname;
	private String firstname;
	//private Seat mySeat;
	private int id;
	
	Client(String l, String f, int i) {
		lastname = l;
		firstname = f;
		id = i;
	}
	
	int getClientId() {
		return id;
	}
	
//	public void setSeat(Seat mySeat) {
//		this.mySeat = mySeat;
//	}
//	
//	public Seat getSeat() {
//		return mySeat;
//	}
	
	String getClientIdandInit() {
		return "id: " + id + "/" + this.getClientInitials();
	}
	
	String getClientLastName() {
		return lastname;
	}
	
	String getClientFirstName() {
		return firstname;
	}
	
	String getClientInitials() {
		char[] initialsArr = {' ', ' '};
		initialsArr[0] = firstname.charAt(0);
		initialsArr[1] = lastname.charAt(0); 
		return new String(initialsArr);
	}

	String getClientName() {
		return firstname + " " + lastname;
	}
	
	String getFullClientString() {
		String full = ("id: " + id + " lastname: " + lastname + " firstname: " + firstname);
		return full;
	}
	
	String getInitialsAndId() {
		
		String output = "id: " + id + "/" + getClientInitials();
		return output;
		
	}//end getIniti
	
	@Override
	public String toString() {
		return firstname + " " + lastname;
	}
	
	
//	String getClientSeatId() {
//		return mySeat.getSeatId();
//	}
//	
}//end class Client
