/*
 * simple client object that holds the names,
 * id of sign up, and a reference to Seat they
 * are currently sitting in/null if no seat
 */

public class Client {
	private String lastname;
	private String firstname;
	private Seat mySeat;
	private int id;
	
	Client(String l, String f, int i) {
		lastname = l;
		firstname = f;
		id = i;
	}
	
	int getClientId() {
		return id;
	}
	
	public void setSeat(Seat mySeat) {
		this.mySeat = mySeat;
	}
	
	public Seat getSeat() {
		return mySeat;
	}
	
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
	
	String getClientSeatId() {
		return mySeat.getSeatId();
	}
	
	
	@Override
	public String toString() {
		return firstname + " " + lastname;
	}
	
}//end class Client
