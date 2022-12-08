package cop4331.accountwindows;

import cop4331.database.ShoppingCart;

/***
 * 
 * @author Charles Briandi
 *
 */
public class Buyer extends Account {
    private ShoppingCart cart;

    public Buyer(String username, String password, String email) {
		super(username, password, email);
		cart = new ShoppingCart();
	}
	
	public ShoppingCart getShoppingCart() { return cart; }

}
