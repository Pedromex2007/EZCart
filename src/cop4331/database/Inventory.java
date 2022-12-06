package cop4331.database;

import java.util.ArrayList;

public class Inventory {
	
	private ArrayList<Product> products = new ArrayList<Product>();
	
	/**
	 * Add a product to this specific inventory.
	 * @param product
	 */
	public void AddProduct(Product product) {
		products.add(product);
	}
	
	/**
	 * Remove a product from the inventory.
	 * @param productID
	 */
	public void RemoveProduct(int productID) {
		
		for(Product product : products) {
			
			if(product.getProductID() == productID) {
				products.remove(product);
				return;
			}
			
		}
		
	}
	
	/**
	 * Get the list of products in this inventory.
	 * @return
	 */
	public ArrayList<Product> GetProducts() {
		return products;
	}

}
