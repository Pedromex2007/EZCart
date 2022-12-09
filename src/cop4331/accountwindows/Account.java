package cop4331.accountwindows;

/**
 * 
 * @author Rafael Luviano
 * @author Charles Briandi 
 *
 */
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
	
	/***
	 * This user's username. Also serves as their ID.
	 * @return User username.
	 */
	public String getUsername() { return accountUsername; }
	
	/***
	 * The user's completely un-encoded/un-encrypted password. Not a good idea.
	 * @return Raw password.
	 */
	public String getPassword() { return accountPassword; }
	
	/***
	 * The user's email.
	 * @return Email address.
	 */
	public String getEmail() { return accountEmail; }
	
}
