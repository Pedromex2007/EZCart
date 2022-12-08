package cop4331.database;


public class ShoppingCartSystem {
	public Database database;

	private ShoppingCartSystem() {
		// Initialize Database.Instancce
		database = new Database();
	}

	public static ShoppingCartSystem getInstance() {
		if (instance == null) instance = new ShoppingCartSystem();
		return instance;
	}

	private static ShoppingCartSystem instance;
}