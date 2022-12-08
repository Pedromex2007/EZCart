package cop4331.storewindows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cop4331.database.Database;
import cop4331.database.DiscountedProduct;
import cop4331.database.Product;
import cop4331.database.ShoppingCartSystem;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateProductWindow extends JFrame {

	private JPanel contentPane;
	private static Product activeProduct;
	private JTextField textFieldName;
	private JTextField textFieldPrice;
	private JTextField textFieldQuantity;
	private JTextField textFieldDiscount;
	private JLabel lblProductPrice;
	private JLabel lblQuantity;
	private JLabel lblDisc;

	/**
	 * Launch the application.
	 */
	public static void ShowUpdateProductWindow(Product currentProduct) {
		activeProduct = currentProduct;
		
		System.out.println(activeProduct.getProductID());
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateProductWindow frame = new UpdateProductWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateProductWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Product Name:");
		lblName.setBounds(23, 14, 90, 14);
		contentPane.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(123, 11, 141, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(123, 42, 141, 20);
		contentPane.add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(123, 73, 141, 20);
		contentPane.add(textFieldQuantity);
		textFieldQuantity.setColumns(10);
		
		JCheckBox chckbxDiscount = new JCheckBox("Discounted");
		chckbxDiscount.setBounds(122, 123, 97, 23);
		contentPane.add(chckbxDiscount);
		
		textFieldDiscount = new JTextField();
		textFieldDiscount.setBounds(123, 153, 96, 20);
		contentPane.add(textFieldDiscount);
		textFieldDiscount.setColumns(10);
		
		lblProductPrice = new JLabel("Product Price:");
		lblProductPrice.setBounds(23, 45, 90, 14);
		contentPane.add(lblProductPrice);
		
		lblQuantity = new JLabel("Product Quantity:");
		lblQuantity.setBounds(23, 76, 90, 14);
		contentPane.add(lblQuantity);
		
		lblDisc = new JLabel("Discount Float:");
		lblDisc.setBounds(23, 156, 90, 14);
		contentPane.add(lblDisc);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(23, 282, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(123, 282, 96, 23);
		contentPane.add(btnExit);
		
		textFieldName.setText(activeProduct.getName());
		textFieldPrice.setText(Float.toString(activeProduct.getBasePrice()));
		textFieldQuantity.setText(Integer.toString(activeProduct.getQuantity()));
		
		try {
			
			DiscountedProduct activeProdDisc = (DiscountedProduct) activeProduct;
			textFieldDiscount.setText(Float.toString(activeProdDisc.getDiscountAmount()));
			chckbxDiscount.setSelected(true);
			
		} catch(ClassCastException e) {
			
		}
		
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DestroyWindow();
				SellerWindow.ShowSellerWindow();
			}
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Database db = ShoppingCartSystem.getInstance().database;
				if(chckbxDiscount.isSelected()) {
				
					DiscountedProduct newProduct = new DiscountedProduct(activeProduct, Float.parseFloat(textFieldDiscount.getText()));
					
					newProduct.setName(textFieldName.getText());
					newProduct.setSellPrice(Float.parseFloat(textFieldPrice.getText()));
					//newProduct.setInvoicePrice(Float.parseFloat(textFieldPrice.getText()));
					newProduct.setQuantity(Integer.parseInt(textFieldQuantity.getText()));
					newProduct.setDiscount(Float.parseFloat(textFieldDiscount.getText()));
					
					
					db.EditProductInformationDatabase(activeProduct, newProduct);

					
				} else {
					
	
					Product newProduct = new Product(activeProduct);
					
					newProduct.setName(textFieldName.getText());
					newProduct.setSellPrice(Float.parseFloat(textFieldPrice.getText()));
					//newProduct.setInvoicePrice(Float.parseFloat(textFieldPrice.getText()));
					newProduct.setQuantity(Integer.parseInt(textFieldQuantity.getText()));
					
					db.EditProductInformationDatabase(activeProduct, newProduct);

					
				}

				DestroyWindow();
				SellerWindow.ShowSellerWindow();
			}
		});
		
	}

	
	private void DestroyWindow() {
		this.dispose();
	}
}

