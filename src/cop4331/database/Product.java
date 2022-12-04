package cop4331.database;

public class Product {

	private int id;
	private String name;
	private float sellPrice;
	private float invoicePrice;
	private int quantity;
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
	
	public Product(int id, String name, float sellPrice, float invoicePrice, int quantity) {
		this.id = id;
		this.name = name;
		this.sellPrice = sellPrice;
		this.invoicePrice = invoicePrice;
		this.quantity = quantity;
	}
	
}
