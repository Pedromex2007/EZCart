package cop4331.accountwindows;

import cop4331.database.Inventory;
import cop4331.database.Transaction;
import cop4331.database.TransactionHistory;

/**
 * 
 * @author Rafael Luviano
 * @author Charles Briandi 
 *
 */
public class Seller extends Account {
	
	private Inventory inventory;

	private TransactionHistory transactionHistory;

	public Seller(String username, String password, String email) {
		super(username, password, email);
		inventory = new Inventory();
	}
	
	/***
	 * Get the inventory of this seller.
	 * @return List of seller's products.
	 */
	public Inventory getInventory() { return inventory; }

	/***
	 * Get the transaction history of this seller.
	 * @return Seller transactions.
	 */
	public TransactionHistory geTransactionHistory() {return transactionHistory; }

}
