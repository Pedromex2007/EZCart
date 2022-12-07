package cop4331.database;

public class ShoppingCart extends Inventory {
	
	public float GetTotalCost() {
		
		float finalCost = 0.00f;
		
		for(Product product : this) {
			finalCost += product.getSellPrice();
		}
		
		return finalCost;
		
	}
}
