package cop4331.accountwindows;

import cop4331.database.Inventory;

public class Seller extends Account {
	
	private Inventory inventory;

	public Seller(String username, String password, String email) {
		super(username, password, email);
	}
	
	public Inventory getInventory() { return inventory; }

}
