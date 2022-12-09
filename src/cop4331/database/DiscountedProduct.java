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
	
	/***
	 * Clone a regular product into a discounted one.
	 * @param cloneProduct Product to clone.
	 * @param discount Discount float to apply.
	 */
	public DiscountedProduct(Product cloneProduct, float discount) {
		super(cloneProduct);
		this.discount = discount;
	}
	
	/***
	 * Clone a discounted product.
	 * @param cloneProduct Product to clone.
	 */
	public DiscountedProduct(DiscountedProduct cloneProduct) {
		super(cloneProduct);
		this.discount = cloneProduct.discount;
	}
	
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getDiscountAmount() {
		return this.discount;
	}
	
	/***
	 * Get the selling price.
	 */
	@Override
	public float getSellPrice() {
		return super.getSellPrice() * discount; 
	}
	
	
	
}
