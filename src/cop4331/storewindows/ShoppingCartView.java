package cop4331.storewindows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ShoppingCartView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void ShowShoppingCartView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingCartView frame = new ShoppingCartView();
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
	public ShoppingCartView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBounds(196, 21, 516, 415);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(contentPane_1);
		
		JPanel panel = new JPanel();
		contentPane_1.add(panel);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		
		
		JPanel contentPane_1_1 = new JPanel();
		contentPane_1_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1_1.setBounds(0, 21, 191, 415);
		contentPane.add(contentPane_1_1);
		
		
		JButton btnBackToStore = new JButton("Back to Store");
		btnBackToStore.setBounds(10, 75, 171, 53);
		contentPane_1_1.add(btnBackToStore);
		btnBackToStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BrowseView.ShowBrowseView();
				
			}
		});
		
		JButton btnCheckOut = new JButton("Check Out");
		btnBackToStore.setBounds(330, 0, 130, 22);
		contentPane_1_1.add(btnCheckOut);
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//CheckoutWindow.ShowCheckoutWindow();
				
			}
		});
		
		
	}

}
