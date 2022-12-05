package cop4331.database;

import java.util.ArrayList;

public class Inventory {
	
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public void AddProduct(Product product) {
		products.add(product);
	}
	
	public void RemoveProduct(int productID) {
		for(Product product : products) {
			
			if(product.getProductID() == productID) {
				products.remove(product);
				return;
			}
			
		}
	}
	
	public ArrayList<Product> GetProducts() {
		return products;
	}

}
