package cop4331.storewindows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cop4331.accountwindows.Account;
import cop4331.accountwindows.Buyer;
import cop4331.accountwindows.Seller;
import cop4331.database.Database;
import cop4331.database.Product;
import cop4331.database.ShoppingCart;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductView extends JFrame{
    private JPanel masterPanel;
    

	/**
	 * Launch the application.
	 */
	public static void ShowProductView(Product product) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductView frame = new ProductView(product);
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
	public ProductView(Product product) {
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 500);
		masterPanel = new JPanel();
		masterPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(masterPanel);
		masterPanel.setLayout(null);

        JButton btnGoBack = new JButton("Go Back");
        btnGoBack.setBounds(584, 11, 90, 25);
		masterPanel.add(btnGoBack);
        btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BrowseView.ShowBrowseView();
                DestroyWindow();
				
			}
		});

        JPanel panel = new JPanel();
		panel.setBounds(10, 55, 725, 395);
		masterPanel.add(panel);

		JPanel subPanel = new JPanel();
		panel.add(subPanel);
		subPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel lblItemName = new JLabel("Name: " + product.getName());
		subPanel.add(lblItemName);
	
		JLabel lblItemPrice = new JLabel("Price: " + Float.toString(product.getSellPrice()));
		subPanel.add(lblItemPrice);

        JLabel lblItemQuantity = new JLabel("Quantity: " + Float.toString(product.getQuantity()));
		subPanel.add(lblItemQuantity);

        JLabel lblSellerName = new JLabel("Seller: " + product.getSellerName());
		subPanel.add(lblSellerName);

		

		if(Account.loggedAccount instanceof Buyer) {
			JButton btnAddToCart = new JButton("Add to Cart");
			this.add(btnAddToCart);
			btnAddToCart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Buyer buyerCast = (Buyer)Account.loggedAccount;
					System.out.println(buyerCast);
					
					
					ShoppingCart.addToShoppingCart(buyerCast.getShoppingCart().getProducts(), product);
					masterPanel.repaint();
					masterPanel.revalidate();
					
					
				}
			});
			}
        
		
		
		
    }
	
   

	private void DestroyWindow() {
		this.dispose();
	}

}

