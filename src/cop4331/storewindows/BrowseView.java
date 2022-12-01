package cop4331.storewindows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JLabel;

public class BrowseView extends JFrame {

	private JPanel masterPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	 */
	public BrowseView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 500);
		masterPanel = new JPanel();
		masterPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(masterPanel);
		masterPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JPanel subPanel = new JPanel();
		masterPanel.add(subPanel);
		subPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("ITEM_NAME:");
		subPanel.add(lblNewLabel);
		
		JButton btnView = new JButton("View");
		subPanel.add(btnView);
		
		JLabel lblItemprice = new JLabel("ITEM_PRICE:");
		subPanel.add(lblItemprice);
		
		JButton btnAddToCart = new JButton("Add to Cart");
		subPanel.add(btnAddToCart);
		GenerateStoreButtons();
	}
	
	private void GenerateStoreButtons() {
		//TODO: Buttons with their JLabels will be generated here. Each button will contain information about a specific item retrieved from the database.
		// Clicking on the "view" button will instantiate the DetailView. Information from the item will be transferred to this view.
		
		//The for loop is an example on how to instantiate each container. We would iterate over each item our database has instead.
		for(int i = 0; i < 10; i++) {
			JPanel subPanel = new JPanel();
			masterPanel.add(subPanel);
			subPanel.setLayout(new GridLayout(0, 2, 0, 0));
			
			JLabel lblNewLabel = new JLabel("ITEM_NAME:");
			subPanel.add(lblNewLabel);
			
			JButton btnView = new JButton("View");
			subPanel.add(btnView);
			
			JLabel lblItemprice = new JLabel("ITEM_PRICE:");
			subPanel.add(lblItemprice);
			
			JButton btnAddToCart = new JButton("Add to Cart");
			subPanel.add(btnAddToCart);
		}
	}

}
