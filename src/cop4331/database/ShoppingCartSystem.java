package cop4331.database;


public class ShoppingCartSystem {
	public Database database;
	public TransactionHistory transactionHistory;

	private ShoppingCartSystem() {
		// Initialize Database.Instancce
		database = new Database();
		transactionHistory = new TransactionHistory();
	}

	public static ShoppingCartSystem getInstance() {
		if (instance == null) instance = new ShoppingCartSystem();
		return instance;
	}

	private static ShoppingCartSystem instance;
}
