package cop4331.database;

public class Transaction {
	
	// NOTE: Accounts don't have numeric IDs, so the account username will be used as the ID instead.
	
	private int id;
	private String sellerID;
	private String buyerID;
	private float cost;
	
	public Transaction(int id, String sellerID, String buyerID, float cost) {
		this.id = id;
		this.sellerID = sellerID;
		this.buyerID = buyerID;
		this.cost = cost;
	}
	
	/***
	 * Get the ID of this specific transaction.
	 * @return
	 */
	public int getTransactionID() {
		return id;
	}
	
	/***
	 * Get the ID of the seller.
	 * @return Seller username.
	 */
	public String getSellerID() {
		return sellerID;
	}
	
	/***
	 * Get the ID of the buyer.
	 * @return Buyer username.
	 */
	public String getBuyerID() {
		return buyerID;
	}
	
	/***
	 * Get the total cost of this transaction.
	 * @return Transaction cost.
	 */
	public float getCost() {
		return cost;
	}
}
