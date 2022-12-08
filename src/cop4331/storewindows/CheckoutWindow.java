package cop4331.storewindows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cop4331.accountwindows.Account;
import cop4331.accountwindows.Buyer;
import cop4331.database.Product;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
 * @author Charles Briandi
 */
public class CheckoutWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fieldAddress;
	private JTextField fieldCard;


	/**
	 * Launch the application.
	 */
	public static void ShowCheckoutWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckoutWindow frame = new CheckoutWindow();
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
	public CheckoutWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		fieldAddress = new JTextField();
		fieldAddress.setBounds(144, 78, 153, 20);
		contentPane.add(fieldAddress);
		fieldAddress.setColumns(10);
		
		JLabel lblUsername = new JLabel("Address:");
		lblUsername.setBounds(61, 81, 73, 14);
		contentPane.add(lblUsername);
	
		
		fieldCard = new JTextField();
		fieldCard.setColumns(10);
		fieldCard.setBounds(144, 109, 153, 20);
		contentPane.add(fieldCard);
		
		JLabel lblPassword = new JLabel("Card:");
		lblPassword.setBounds(61, 112, 73, 14);
		contentPane.add(lblPassword);

		JLabel messageLabel = new JLabel();
		messageLabel.setBounds(185, 220, 250, 23);
		contentPane.add(messageLabel);
		
		

		JButton btnBackToStore = new JButton("Back to Cart");
		btnBackToStore.setBounds(10, 10, 150, 25);
		contentPane.add(btnBackToStore);
		btnBackToStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ShoppingCartView.ShowShoppingCartView();
				
			}
		});

		GenerateTotal(contentPane);
		

		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.setBounds(154, 160, 123, 23);
		contentPane.add(btnCheckout);

		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = fieldCard.getText();
				int test;
				try{
					test = Integer.parseInt(temp);
				}
				catch(NumberFormatException ex) {
					messageLabel.setForeground(Color.red);
					messageLabel.setBounds(175, 220, 250, 23);
					messageLabel.setText("Numbers only!");
				}

				if(fieldCard.getText().length() != 16) {
					messageLabel.setForeground(Color.red);
					messageLabel.setBounds(100, 220, 300, 23);
					messageLabel.setText("Make sure you enter a card number with 16 digits.");
				}
				else {
					//processOrder
				}

			}
		});
		
	}

	/**
	 * Get the total price of the cart
	 */
	private void GenerateTotal(JPanel subPanel) {
		Buyer buyerCast = (Buyer)Account.loggedAccount;

		JLabel lblTotal = new JLabel("Total Price: " + Float.toString(buyerCast.getShoppingCart().getTotalCost()));
		lblTotal.setBounds(172, 175, 150, 75);
		subPanel.add(lblTotal);
		
	}

}
