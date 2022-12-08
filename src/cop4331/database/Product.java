package cop4331.database;

import cop4331.accountwindows.Seller;

/**
 * 
 * @author Rafael Luviano
 * @author Charles Briandi 
 *
 */
public class Product {

	private int id;
	private String name;
	private float sellPrice;
	private float invoicePrice;
	private int quantity;
	private String sellerProducer;
	private String type;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public float getSellPrice() { return sellPrice; }
	public void setSellPrice(float sellPrice) { this.sellPrice = sellPrice; }
	
	public float getInvoicePrice() { return invoicePrice; }
	public void setInvoicePrice(float invoicePrice) { this.invoicePrice = invoicePrice; }
	
	public int getQuantity() { return quantity; }
	public void setQuantity(int quantity) { this.quantity = quantity; }
	
	public String getType() { return type; }
	public int getProductID() { return id; }
	
	public String getSellerName() { return sellerProducer; }

	/***
	 * Get the base price without any modifiers.
	 * @return Unmodified product price.
	 */
	public float getBasePrice() {
		return sellPrice;
	}

	/***
	 * 
	 * @return
	 */
	public float getTotalPrice() { return sellPrice *  quantity; }
	
	public Product(int id, String name, float sellPrice, float invoicePrice, int quantity, String sellerProducer) {
		this.id = id;
		this.name = name;
		this.sellPrice = sellPrice;
		this.invoicePrice = invoicePrice;
		this.quantity = quantity;
		this.sellerProducer = sellerProducer;
	}
	
	public Product(Product cloneProduct) {
    	this.id = cloneProduct.id;
    	this.name = cloneProduct.name;
    	this.sellPrice = cloneProduct.sellPrice;
    	this.invoicePrice = cloneProduct.invoicePrice;
    	this.quantity = cloneProduct.quantity;
    	this.sellerProducer = cloneProduct.sellerProducer;
    	this.type = cloneProduct.type;
	}
	
}
