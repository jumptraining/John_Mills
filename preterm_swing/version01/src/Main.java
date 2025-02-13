import javax.swing.SwingUtilities;

public class Main {

	
	public static void main(String[] args) {
		
		Client clientList[] = getInput();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new DriverGui(clientList);
			}
		});
		
	}//end main
	

	public static Client[] getInput() {

		ClientStore myStore = new ClientStore("clients_list.csv");		
		return myStore.getClientStore();
		
	}//end getInput			
	
}