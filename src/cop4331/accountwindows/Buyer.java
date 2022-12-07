package cop4331.accountwindows;

import cop4331.database.ShoppingCart;

public class Buyer extends Account {
    private ShoppingCart shoppingCart;

    public Buyer(String username, String password, String email) {
		super(username, password, email);
		shoppingCart = new ShoppingCart();
	}
	
	public ShoppingCart getShoppingCart() { return shoppingCart; }

}
