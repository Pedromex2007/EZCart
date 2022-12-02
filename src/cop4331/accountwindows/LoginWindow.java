package cop4331.accountwindows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cop4331.storewindows.BrowseView;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class LoginWindow extends JFrame {

	private JPanel contentPane;
	private JTextField fieldUsername;
	private JTextField fieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow();
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
	public LoginWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(154, 160, 123, 23);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BrowseView.ShowBrowseView();
				DestroyLoginWindow();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnLogin);
		
		fieldUsername = new JTextField();
		fieldUsername.setBounds(144, 78, 153, 20);
		contentPane.add(fieldUsername);
		fieldUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(61, 81, 73, 14);
		contentPane.add(lblUsername);
		
		JButton btnCreateAccout = new JButton("Create Account");
		btnCreateAccout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAccountWindow.RunCreationAccountWin();
			}
		});
		btnCreateAccout.setBounds(154, 190, 123, 23);
		contentPane.add(btnCreateAccout);
		
		fieldPassword = new JTextField();
		fieldPassword.setColumns(10);
		fieldPassword.setBounds(144, 109, 153, 20);
		contentPane.add(fieldPassword);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(61, 112, 73, 14);
		contentPane.add(lblPassword);
	}
	
	private void DestroyLoginWindow() {
		this.dispose();
	}
}
