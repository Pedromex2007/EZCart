package cop4331.database;

import java.util.ArrayList;

public class ShoppingCart {

	private ArrayList<Product> cart = new ArrayList<Product>();
	
	/**
	 * Add a product to this specific inventory.
	 * @param product
	 */
	public void addProduct(Product product) {
		cart.add(product);
		System.out.println("added to cart");
	}
	
	/**
	 * Remove a product from the inventory.
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
	 * Get the list of products in this inventory.
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
}
