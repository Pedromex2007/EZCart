package cop4331.database;

/**
 * 
 * @author Rafael Luviano
 *
 */
public class DiscountedProduct extends Product {

	private float discount;
	
	public DiscountedProduct(int id, String name, float sellPrice, float invoicePrice, int quantity, String sellerProducer, float discount) {
		super(id, name, sellPrice, invoicePrice, quantity, sellerProducer);
		this.discount = discount;
	}
	
	public DiscountedProduct(Product cloneProduct, float discount) {
		super(cloneProduct);
		this.discount = discount;
	}
	
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	@Override
	public float getSellPrice() {
		return super.getSellPrice() * discount; 
	}
	
	
}
