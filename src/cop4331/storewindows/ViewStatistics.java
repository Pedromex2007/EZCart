package cop4331.storewindows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cop4331.accountwindows.Account;
import cop4331.accountwindows.Seller;
import cop4331.database.TransactionHistory;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewStatistics extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void ShowStatsView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStatistics frame = new ViewStatistics();
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
	public ViewStatistics() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProfit = new JLabel("Profit Generated:");
		lblProfit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProfit.setBounds(10, 11, 159, 20);
		contentPane.add(lblProfit);
		
		JLabel lblTotalRevenue = new JLabel("Total Revenue:");
		lblTotalRevenue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotalRevenue.setBounds(10, 43, 159, 20);
		contentPane.add(lblTotalRevenue);
		
		JLabel lblExpenses = new JLabel("Expenses: ");
		lblExpenses.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblExpenses.setBounds(10, 74, 159, 20);
		contentPane.add(lblExpenses);
		
		JButton btnBack = new JButton("Return");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DestroyWindow();
			}
		});
		btnBack.setBounds(10, 227, 89, 23);
		contentPane.add(btnBack);
		JLabel lblProfitNum = new JLabel("$" + TransactionHistory.getProfitFor((Seller)Account.loggedAccount));
		lblProfitNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProfitNum.setBounds(179, 11, 159, 20);
		contentPane.add(lblProfitNum);
		
		JLabel lblRevNum = new JLabel("$" + TransactionHistory.getRevenueFor((Seller)Account.loggedAccount));
		lblRevNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRevNum.setBounds(179, 43, 159, 20);
		contentPane.add(lblRevNum);
		
		JLabel lblExpNum = new JLabel("$" + TransactionHistory.getCostsFor((Seller)Account.loggedAccount));
		lblExpNum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblExpNum.setBounds(179, 74, 159, 20);
		contentPane.add(lblExpNum);
	}
	
	private void DestroyWindow() {
		this.dispose();
	}
}
