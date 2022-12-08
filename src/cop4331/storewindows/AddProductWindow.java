package cop4331.storewindows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cop4331.accountwindows.Account;
import cop4331.database.Database;
import cop4331.database.DiscountedProduct;
import cop4331.database.Product;
import cop4331.database.ShoppingCartSystem;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

/**
 * 
 * @author Charles Briandi 
 *
 */
public class AddProductWindow extends JFrame {

	private JPanel contentPane;
	private JTextField fieldName;
	private JTextField fieldQuantity;
	private JTextField fieldPrice;
	private JTextField fieldDiscount;

	/**
	 * Launch the application.
	 */
	public static void ShowAddProductWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProductWindow frame = new AddProductWindow();
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
	public AddProductWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DestroyWindow();
			}
		});
		btnGoBack.setBounds(73, 227, 89, 23);
		contentPane.add(btnGoBack);
		
		JButton btnSubmit = new JButton("Submit");

		btnSubmit.setBounds(178, 227, 89, 23);
		contentPane.add(btnSubmit);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 16, 57, 14);
		contentPane.add(lblName);
		
		JLabel lblQuantit = new JLabel("Quantity:");
		lblQuantit.setBounds(10, 47, 57, 14);
		contentPane.add(lblQuantit);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(10, 78, 48, 14);
		contentPane.add(lblPrice);
		
		fieldName = new JTextField();
		fieldName.setBounds(73, 13, 96, 20);
		contentPane.add(fieldName);
		fieldName.setColumns(10);
		
		fieldQuantity = new JTextField();
		fieldQuantity.setBounds(73, 44, 96, 20);
		contentPane.add(fieldQuantity);
		fieldQuantity.setColumns(10);
		
		fieldPrice = new JTextField();
		fieldPrice.setBounds(73, 75, 96, 20);
		contentPane.add(fieldPrice);
		fieldPrice.setColumns(10);
		
		JCheckBox chckbxOnDiscount = new JCheckBox("On Discount");
		chckbxOnDiscount.setBounds(296, 12, 97, 23);
		contentPane.add(chckbxOnDiscount);
		
		fieldDiscount = new JTextField();
		fieldDiscount.setBounds(297, 44, 96, 20);
		contentPane.add(fieldDiscount);
		fieldDiscount.setColumns(10);
		
		btnSubmit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				Database db = ShoppingCartSystem.getInstance().database;
				if(chckbxOnDiscount.isSelected()) {

					DiscountedProduct product = new DiscountedProduct(
							rand.nextInt(2000), 
							fieldName.getText(), 
							Float.parseFloat(fieldPrice.getText()), 
							Float.parseFloat(fieldPrice.getText()),
							Integer.parseInt(fieldQuantity.getText()), 
							Account.loggedAccount.getUsername(), 
							Float.parseFloat(fieldDiscount.getText())
					);
					
					db.CreateProductEntryDatabase(product);
				} else {
					
					Product product = new Product(
							rand.nextInt(2000), 
							fieldName.getText(), 
							Float.parseFloat(fieldPrice.getText()), 
							Float.parseFloat(fieldPrice.getText()),
							Integer.parseInt(fieldQuantity.getText()), 
							Account.loggedAccount.getUsername()
					);
					
					db.CreateProductEntryDatabase(product);
				}
				DestroyWindow();
			}
		});
	}
	
	private void DestroyWindow() {
		this.dispose();
	}
}
