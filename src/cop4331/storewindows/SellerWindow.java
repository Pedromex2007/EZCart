package cop4331.storewindows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cop4331.accountwindows.Account;
import cop4331.accountwindows.Seller;
import cop4331.database.Product;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Rafael Luviano
 *
 */
public class SellerWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void ShowSellerWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellerWindow frame = new SellerWindow();
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
	public SellerWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBounds(196, 21, 516, 415);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(contentPane_1);
		
		JPanel panel = new JPanel();
		contentPane_1.add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		/*JLabel lblName = new JLabel("PRODUCT_NAME:");
		panel.add(lblName);
		
		JButton btnEditProduct = new JButton("Edit this Product");
		panel.add(btnEditProduct);*/
		
		GenerateListedProducts(panel);
		
		JPanel contentPane_1_1 = new JPanel();
		contentPane_1_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1_1.setBounds(0, 21, 191, 415);
		contentPane.add(contentPane_1_1);
		contentPane_1_1.setLayout(null);
		
		JButton btnAddProduct = new JButton("Add New Product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddProductWindow.ShowAddProductWindow();
				
			}
		});
		btnAddProduct.setBounds(10, 11, 171, 53);
		contentPane_1_1.add(btnAddProduct);
		
		JButton btnViewStats = new JButton("View Statistics");
		btnViewStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewStatistics.ShowStatsView();
			}
		});
		btnViewStats.setBounds(10, 75, 171, 53);
		contentPane_1_1.add(btnViewStats);
		
		JLabel lblNewLabel = new JLabel("Listed Products");
		lblNewLabel.setBounds(330, 0, 130, 22);
		contentPane.add(lblNewLabel);
	}
	
	/**
	 * Get a list of of all the products posted by the user viewing this page.
	 */
	private void GenerateListedProducts(JPanel subPanel) {
		class ProductButton extends JButton {

			Product product;
			
			public ProductButton(Product product) {
				this.product = product;

				//JLabel lblName = new JLabel(product.getName());
				//subPanel.add(lblName);
				this.setText("Edit this Product");
				subPanel.add(this);
			}
		}
		
		Seller sellerCast = (Seller)Account.loggedAccount;
		
		for(Product product : sellerCast.getInventory()) {
			
			
			JLabel lblName = new JLabel(product.getName());
			subPanel.add(lblName);
			
			ProductButton prodBtn = new ProductButton(product);
			prodBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					System.out.println("It worked!");
					
				}
			});
			
			//JButton btnEditProduct = new JButton("Edit this Product");
			//subPanel.add(btnEditProduct);
			
			
		}
		
	}
}
