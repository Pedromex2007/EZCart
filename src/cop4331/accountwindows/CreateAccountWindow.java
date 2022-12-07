package cop4331.accountwindows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cop4331.database.Database;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;

/**
 * 
 * @author Rafael Luviano
 *
 */
public class CreateAccountWindow extends JFrame {

	private JPanel contentPane;
	private JTextField fieldUsername;
	private JTextField fieldPassword;
	private JTextField fieldEmail;

	private String type;

	/**
	 * Launch this window when called.
	 */
	public static void RunCreationAccountWin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccountWindow frame = new CreateAccountWindow();
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
	public CreateAccountWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegister = new JButton("Register");

		btnRegister.setBounds(10, 227, 89, 23);
		contentPane.add(btnRegister);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 11, 67, 14);
		contentPane.add(lblUsername);
		
		fieldUsername = new JTextField();
		fieldUsername.setBounds(87, 8, 143, 20);
		contentPane.add(fieldUsername);
		fieldUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 39, 67, 14);
		contentPane.add(lblPassword);
		
		fieldPassword = new JTextField();
		fieldPassword.setColumns(10);
		fieldPassword.setBounds(87, 36, 143, 20);
		contentPane.add(fieldPassword);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 65, 67, 14);
		contentPane.add(lblEmail);
		
		fieldEmail = new JTextField();
		fieldEmail.setColumns(10);
		fieldEmail.setBounds(87, 62, 143, 20);
		contentPane.add(fieldEmail);

		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(10, 91, 67, 17);
		contentPane.add(lblType);

		JButton btnBuyer = new JButton("Buyer");
		btnBuyer.setBounds(60, 91, 70, 17);
		contentPane.add(btnBuyer);

		JButton btnSeller = new JButton("Seller");
		btnSeller.setBounds(140, 91, 70, 17);
		contentPane.add(btnSeller);

		

		JLabel messageLabel = new JLabel("Welcome");
		messageLabel.setBounds(185, 220, 123, 23);
		contentPane.add(messageLabel);
		
		btnBuyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type = "Buyer";
			}
		});

		btnSeller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type = "Seller";
			}
		});

		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fieldUsername.getText().equals("") || fieldPassword.getText().equals("") || fieldEmail.getText().equals("")) {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Please fill in all fields.");
				}
				else if(Database.Instance.usernameIsTaken(fieldUsername.getText())) {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Username taken.");
				}
				else if(Database.Instance.emailIsTaken(fieldEmail.getText())) {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Email taken.");
				}
				else if(type != "Buyer" && type != "Seller") {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Buyer or Seller?");
				}
				else {
					Database.Instance.RegisterAccount(fieldUsername.getText(), fieldPassword.getText(), fieldEmail.getText(), type);
					DestroyRegisterWindow();
				}
			}
		});
		
	}
	
	private void DestroyRegisterWindow() {
		this.dispose();
	}

}
