package matrixinput;

import javax.swing.SwingUtilities;

public class Main {

	
	//Client[] myStore = new ClientStore("clients_lists.csv");
	public static void main(String[] args) {
		
		Client clientList[] = getInput();
		for(int i=0; i < clientList.length; i++) {
			System.out.println(i + " Initials: " + clientList[i].getClientInitials());
		}
		
		//DriverGui grid = new DriverGui(clientList);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new DriverGui(clientList);
			}
		});
		
		
	}//end main
	

	public static Client[] getInput() {

		// quick test to see if we can load data from a CSV file
		// and at least get an accurate count of the rows loaded in
		ClientStore myStore = new ClientStore("clients_list.csv");		
		return myStore.getClientStore();
		
	}//end getInput

			
			
	
}