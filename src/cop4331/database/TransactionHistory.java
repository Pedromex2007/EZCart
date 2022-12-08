package cop4331.database;

import java.util.ArrayList;

import cop4331.accountwindows.Seller;

/**
 * 
 * @author Rafael Luviano
 *
 */
public class TransactionHistory {
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	
	private static TransactionHistory instance;
	
	/**
	 * Add a transaction to the history
	 * @param transaction
	 */
	public void addProduct(Transaction transaction) {
		transactions.add(transaction);
	}

	public TransactionHistory() {
		instance = this;
	}
	
	/***
	 * Get the list of all transactions.
	 * @return Transaction history list.
	 */
	public static ArrayList<Transaction> getTransactions() {
		return instance.transactions;
	}
	
	//TODO: I don't really know what was the difference between these three.
	
	/***
	 * Get the total cost of every transaction.
	 * @param seller Seller to examine.
	 * @return Transaction costs from this seller.
	 */
	public static float getCostsFor(Seller seller) {
		float finalCosts = 0;
		
		for(Transaction trsAct : instance.transactions) {
			
			if(trsAct.getSellerID().equals(seller.getUsername())) {
				finalCosts += trsAct.getCost();
			}
			
		}
		
		return finalCosts;
	}
	
	/***
	 * Get all revenue generated from this seller's products.
	 * @param seller Seller to examine.
	 * @return Revenue generated.
	 */
	public static float getRevenueFor(Seller seller) {
		float finalRevenue = 0;
		
		for(Transaction trsAct : instance.transactions) {
			
			if(trsAct.getSellerID().equals(seller.getUsername())) {
				finalRevenue += trsAct.getCost();
			}
			
		}
		
		return finalRevenue;
	}
	
	/***
	 * Get the profit generated from all products this seller posted.
	 * @param seller Seller to examine.
	 * @return Profits generated.
	 */
	public static float getProfitFor(Seller seller) {
		float finalProfit = 0;
		
		for(Transaction trsAct : instance.transactions) {
			
			if(trsAct.getSellerID().equals(seller.getUsername())) {
				finalProfit += trsAct.getCost();
			}
			
		}
		
		return finalProfit;
	}
	
}
