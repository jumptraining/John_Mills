package matrixinput;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/*
 * 
 * Clicking the button in AddOrRemove class will return a true or false value
 * saying if the seat is taken. If vacant, JList in its class will delete that
 * value from the list and send it to the AddOrRemove class, in which it will be displayed there.
 * I will need a Client reference inside AddOrRemove. Can check for no client in the seat
 * by checking if null. If seat is take, the AddOrRemove class will return the current
 * reference to the Client in the seat. That client will then be added back to the list.
 * AddOrRemove will then change the labels and buttons to say it is vacant
 * 
 * Need to set a check if nothing is selected that the list will
 * not remove the item since Java sets uninitialized ints to 0
 * 
 */


public class MyList{
	
	JList<Client> jlst;
	DefaultListModel<Client> defaultList;
	JLabel jlab;
	JScrollPane jscrlp;
	Client[] myList;
	JButton button;

	int index;
	
	MyList(Client[] myList) {
				
		this.myList = myList;

		defaultList = new DefaultListModel<Client>();
		jlst = new JList<Client>(defaultList);
		for(Client myClient : myList) {
			defaultList.addElement(myClient);
		}
		//super(defaultList);
		

		jlst.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		// Make a label that displays the selection.
		jlab = new JLabel("Please choose a name");


		/*
		 * TODO
		 * I think i need to send the index through the contructor of the new
		 * component being made to use the buttons on them and delete the element
		 * which would also mean i need to send the list
		 * 
		 */
		jlst.addListSelectionListener((le) -> {
			
			index = jlst.getSelectedIndex(); 
			
		}); //end addlistener		
		
	}//end MyList constructor
	
	
	
	public JList<Client> getJList() {
		return jlst;
	}
	
	public DefaultListModel<Client> getDefaultList() {
		return defaultList;
	}
	
	public int getIndex() {
		return index;
	}

	
}//end MyList class