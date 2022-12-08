package cop4331.database;

import java.util.ArrayList;

public class BundleProduct extends Product {
	public BundleProduct(int id, String name, float sellPrice, float invoicePrice, int quantity, String sellerProducer, ArrayList<Product> products) {
		super(id, name, sellPrice, invoicePrice, quantity, sellerProducer);
		this.products = products;
	}

	private ArrayList<Product> products;
}
