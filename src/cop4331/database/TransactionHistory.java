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
	
	public static float getCostsFor(Seller seller) {
		float finalCosts = 0;
		return finalCosts;
	}
	
	public static float getRevenueFor(Seller seller) {
		float finalRevenue = 0;
		return finalRevenue;
	}
	
	public static float getProfitFor(Seller seller) {
		float finalProfit = 0;
		return finalProfit;
	}
	
}
