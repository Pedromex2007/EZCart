package cop4331.database;

import cop4331.accountwindows.Seller;

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

	public float getTotalPrice() { return sellPrice *  quantity; }
	
	public Product(int id, String name, float sellPrice, float invoicePrice, int quantity, String sellerProducer) {
		this.id = id;
		this.name = name;
		this.sellPrice = sellPrice;
		this.invoicePrice = invoicePrice;
		this.quantity = quantity;
		this.sellerProducer = sellerProducer;
	}
	
    /*public Object clone() throws CloneNotSupportedException {
        // Assign the shallow copy to
        // new reference variable t
    	Product t = (Product)super.clone();
 
        // Creating a deep copy for c
        t.c = new Product();

 
        // Create a new object for the field c
        // and assign it to shallow copy obtained,
        // to make it a deep copy
        return t;
    }*/
	
}
