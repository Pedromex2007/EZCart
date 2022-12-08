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
	
	public int getTransactionID() {
		return id;
	}
	
	public String getSellerID() {
		return sellerID;
	}
	
	public String getBuyerID() {
		return buyerID;
	}
	
	public float getCost() {
		return cost;
	}
}
