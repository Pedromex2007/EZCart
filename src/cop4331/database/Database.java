package cop4331.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import cop4331.accountwindows.Account;

/**
 * 
 * @author Rafael Luviano
 *
 */
public class Database {
	
	public static Database Instance;

	
	private ArrayList<Account> activeAccounts = new ArrayList<Account>();
	
	private BufferedReader inventoryDatabaseReader;
	private BufferedReader userDatabaseReader;
	
	private File inventoryDatabase;
	private File userDatabase;
	
	/**
	 * Instantiate the database and connect to our csv files.
	 */
	public Database() {
		Instance = this;
		
		try   {  

			inventoryDatabaseReader = new BufferedReader(new FileReader("inventoryList.csv"));  
			userDatabaseReader = new BufferedReader(new FileReader("userList.csv"));  
			
			userDatabase = new File("userList.csv");
			
			Load();

			
			
			//inventoryDatabaseReader.close();
		}   
		catch (IOException e)   {  
			e.printStackTrace();  
		}  

        
	}
	
	/**
	 * Load all accounts and products into memory.
	 */
	public void Load() {
		LoadAccounts();
		LoadInventoryItems();
	}
	
	/**
	 * Create all the accounts into memory. Takes data from our "userList.csv" file.
	 */
	private void LoadAccounts() {
		String line = "";  
		String splitBy = ",";  
		
		try {
			while ((line = userDatabaseReader.readLine()) != null) {  
				
				String[] le_line = line.split(splitBy);
				System.out.println(le_line[0] + ", " );  
				activeAccounts.add(new Account(le_line[0], le_line[1], le_line[2]));	
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
	}
	
	private void LoadInventoryItems() {
		
	}
	
	/**
	 * Check with the active account list to see if the login info matches something.
	 * @param username The username we're trying to log in to.
	 * @param password Password of the username
	 * @return Is valid account.
	 */
	public boolean VerifyAccountInformation(String username, String password) {
		
		for(Account account : activeAccounts) {

			if(account.getUsername().equals(username) && account.getPassword().equals(password)) {
				System.out.println("Login successful.");
				Account.activeAccount = account;
				return true;
			}
		}
		
		return false;
		
	}
	
	/**
	 * Create a new account based on the parameters fed to the method.
	 * @param username Username of the new account.
	 * @param password Password of the new account.
	 * @param email Email of the new account.
	 */
	public void RegisterAccount(String username, String password, String email) {
        
        String[] accountDetails = new String[3];
        accountDetails[0] = username;
        accountDetails[1] = password;
        accountDetails[2] = email;
        
        activeAccounts.add(new Account(username, password, email));	

        FileWriter fileWriter = null;
        
		try {
			
			fileWriter = new FileWriter(userDatabase, true);
			
		} catch (IOException e) {

			e.printStackTrace();
			
		}



        StringBuilder line = new StringBuilder();
        
        for (int i = 0; i < accountDetails.length; i++) {
        	
            //line.append("\"");
            line.append(accountDetails[i].replaceAll("\"","\"\""));
            //line.append("\"");
            if (i != accountDetails.length - 1) {
                line.append(',');
            }
            
        }
        
        line.append("\n");
        
        try {
			fileWriter.write(line.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        try {
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}
}
