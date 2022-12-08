package cop4331.database;

import java.util.ArrayList;

import cop4331.accountwindows.Seller;

public class TransactionHistory {
	private ArrayList<Transaction> transaction = new ArrayList<Transaction>();
	
	private static TransactionHistory instance;
	
	public TransactionHistory() {
		instance = this;
	}
	
	public static ArrayList<Transaction> getTransactions() {
		return instance.transaction;
	}
	
	// I don't really know what was the difference between these three.
	public static float getCostsFor(Seller seller) {
		float finalCosts = 0;
		
		for(Transaction trsAct : instance.transaction) {
			
			if(trsAct.getSellerID().equals(seller.getUsername())) {
				finalCosts += trsAct.getCost();
			}
			
		}
		
		return finalCosts;
	}
	
	public static float getRevenueFor(Seller seller) {
		float finalRevenue = 0;
		
		for(Transaction trsAct : instance.transaction) {
			
			if(trsAct.getSellerID().equals(seller.getUsername())) {
				finalRevenue += trsAct.getCost();
			}
			
		}
		
		return finalRevenue;
	}
	
	public static float getProfitFor(Seller seller) {
		float finalProfit = 0;
		
		for(Transaction trsAct : instance.transaction) {
			
			if(trsAct.getSellerID().equals(seller.getUsername())) {
				finalProfit += trsAct.getCost();
			}
			
		}
		
		return finalProfit;
	}
	
}
