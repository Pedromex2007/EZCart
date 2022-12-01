package cop4331.accountwindows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateAccountWindow extends JFrame {

	private JPanel contentPane;
	private JTextField fieldUsername;
	private JTextField fieldPassword;
	private JTextField fieldEmail;

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
	 * @author Rafael Luviano
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
	}

}
