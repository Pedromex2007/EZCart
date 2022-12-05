package cop4331.accountwindows;

public class Account {
	// This is the account we're logged into.
	public static Account loggedAccount;
	
	private String accountUsername;
	private String accountPassword;
	private String accountEmail;
	
	public Account(String username, String password, String email) {
		accountUsername = username;
		accountPassword = password;
		accountEmail = email;
	}
	
	public String getUsername() { return accountUsername; }
	public String getPassword() { return accountPassword; }
	public String getEmail() { return accountEmail; }
	
}
