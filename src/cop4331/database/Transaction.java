package cop4331.database;

public class Transaction {
	private int id;
	private int sellerID;
	private int buyerID;
	private float cost;
	
	public Transaction(int id, int sellerID, int buyerID, float cost) {
		this.id = id;
		this.sellerID = sellerID;
		this.buyerID = buyerID;
		this.cost = cost;
	}
	
	public int getTransactionID() {
		return id;
	}
	
	public int getSellerID() {
		return sellerID;
	}
	
	public int getBuyerID() {
		return buyerID;
	}
	
	public float getCost() {
		return cost;
	}
}
