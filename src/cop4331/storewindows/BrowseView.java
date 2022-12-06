package cop4331.storewindows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cop4331.accountwindows.Account;
import cop4331.accountwindows.Seller;
import cop4331.database.Database;
import cop4331.database.Product;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Rafael Luviano
 *
 */
public class BrowseView extends JFrame {

	private JPanel masterPanel;

	/**
	 * Launch the application.
	 */
	public static void ShowBrowseView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrowseView frame = new BrowseView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @author Rafael Luviano
	 */
	public BrowseView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 500);
		masterPanel = new JPanel();
		masterPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(masterPanel);
		masterPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 55, 725, 395);
		masterPanel.add(panel);
		
		JPanel subPanel = new JPanel();
		panel.add(subPanel);
		subPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("ITEM_NAME:");
		subPanel.add(lblNewLabel);
		
		JButton btnView = new JButton("View");
		subPanel.add(btnView);
		
		JLabel lblItemprice = new JLabel("ITEM_PRICE:");
		subPanel.add(lblItemprice);
		
		JButton btnAddToCart = new JButton("Add to Cart");
		subPanel.add(btnAddToCart);
		
		GenerateStoreButtons(panel);
		
		if(Account.loggedAccount instanceof Seller) {
			
			JButton btnViewSellPage = new JButton("View Seller Page");

			btnViewSellPage.setBounds(584, 11, 151, 33);
			masterPanel.add(btnViewSellPage);
			
			btnViewSellPage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SellerWindow.ShowSellerWindow();
					DestroyWindow();
				}
			});
			
		}
		
		
	}
	
	/**
	 * Create panels that contain all items from our database.
	 * @author Rafael Luviano
	 */
	private void GenerateStoreButtons(JPanel firstPanel) {
		
		class ProductButton extends JPanel {

			Product product;
			
			public ProductButton(Product product) {
				this.product = product;
				
				firstPanel.add(this);
				this.setLayout(new GridLayout(0, 2, 0, 0));
				
				JLabel lblNewLabel = new JLabel(product.getName());
				this.add(lblNewLabel);
				
				JButton btnView = new JButton("View");
				this.add(btnView);
				
				JLabel lblItemprice = new JLabel(Float.toString(product.getSellPrice()));
				this.add(lblItemprice);
				
				JButton btnAddToCart = new JButton("Add to Cart");
				this.add(btnAddToCart);
			}
		}
		
		//TODO: Buttons with their JLabels will be generated here. Each button will contain information about a specific item retrieved from the database.
		// Clicking on the "view" button will instantiate the DetailView. Information from the item will be transferred to this view.
		
		// Instantiate each button.
		for(Product product : Database.Instance.activeProducts) {
			System.out.println("Something, yknow.");
			
			
			//JPanel subPanel = new JPanel();
			
			ProductButton prodBtn = new ProductButton(product);
			firstPanel.add(prodBtn);
			
			/*subPanel.setLayout(new GridLayout(0, 2, 0, 0));
			
			JLabel lblNewLabel = new JLabel(product.getName());
			subPanel.add(lblNewLabel);
			
			JButton btnView = new JButton("View");
			subPanel.add(btnView);
			
			JLabel lblItemprice = new JLabel(Float.toString(product.getSellPrice()));
			subPanel.add(lblItemprice);
			
			JButton btnAddToCart = new JButton("Add to Cart");
			subPanel.add(btnAddToCart);*/
		}

	}
	
	private void DestroyWindow() {
		this.dispose();
	}

}

