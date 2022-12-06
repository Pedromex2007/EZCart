package cop4331.storewindows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cop4331.database.Product;

public class UpdateProductWindow extends JFrame {

	private JPanel contentPane;
	private static Product activeProduct;

	/**
	 * Launch the application.
	 */
	public static void ShowUpdateProductWindow(Product currentProduct) {
		activeProduct = currentProduct;
		
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}
	
	private void DestroyWindow() {
		this.dispose();
	}

}
