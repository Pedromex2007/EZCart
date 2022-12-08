package cop4331.accountwindows;

import cop4331.database.Inventory;
import cop4331.database.Transaction;
import cop4331.database.TransactionHistory;

public class Seller extends Account {
	
	private Inventory inventory;

	private TransactionHistory transactionHistory;

	public Seller(String username, String password, String email) {
		super(username, password, email);
		inventory = new Inventory();
	}
	
	public Inventory getInventory() { return inventory; }

	public TransactionHistory geTransactionHistory() {return transactionHistory; }

}
