package cop4331.database;

import java.util.ArrayList;
/**
 * @author Charles Briandi
 */
public class ShoppingCart {

	private ArrayList<Product> cart = new ArrayList<Product>();
	
	/**
	 * Add a product to this cart
	 * @param product
	 */
	public void addProduct(Product product) {
		cart.add(product);
		System.out.println("added to cart");
	}
	
	/**
	 * Remove a product from the cart
	 * @param productID
	 */
	public void removeProduct(int productID) {
		
		for(Product product : cart) {
			
			if(product.getProductID() == productID) {
				cart.remove(product);
				return;
			}
			
		}
		
	}
	
	/**
	 * Get the list of products in cart
	 * @return
	 */
	public ArrayList<Product> getProducts() {
		return cart;
	}

	
	public float getTotalCost() {
		
		float finalCost = 0.00f;
		

		for(Product product : getProducts()) {
			finalCost += product.getTotalPrice();
		}
		
		return finalCost;
		
	}

	/**
	 * add a product of quantity 1 to the cart
	 * @param cart
	 * @param product
	 */
	public static void addToShoppingCart(ArrayList<Product> cart, Product product){
		int count = 0;
		for(Product p : cart) {
			if(p.getProductID() == product.getProductID()) {
				if(p.getQuantity() < product.getQuantity())
				p.setQuantity(p.getQuantity() + 1);
				count++;
			}
		}
		if(count == 0) {
			Product temp = new Product(product);
			temp.setQuantity(1);
			
			System.out.println(temp);
			System.out.println("Quantity: " + Integer.toString(temp.getQuantity()));
			cart.add(temp);
		}
	}
}
