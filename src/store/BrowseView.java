package store;

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

public class BrowseView extends JFrame {

	private JPanel contentPane;

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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new CardLayout(50, 50));
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton, "name_22670970460400");
	}
	
	private void GenerateStoreButtons() {
		//TODO: Buttons with their JLabels will be generated here. Each button will contain information about a specific item retrieved from the database.
		// Clicking on any of the buttons will instantiate the DetailView. Information from the item will be transferred to this view.
	}

}
