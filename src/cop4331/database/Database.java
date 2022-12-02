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
	
	private FileWriter inventoryDatabaseWriter;
	private FileWriter userDatabaseWriter;
	
	/**
	 * Instantiate the database and connect to our csv files.
	 */
	public Database() {
		Instance = this;
		
		try   {  

			inventoryDatabaseReader = new BufferedReader(new FileReader("inventoryList.csv"));  
			userDatabaseReader = new BufferedReader(new FileReader("userList.csv"));  
			
			Load();

			
			
			//inventoryDatabaseReader.close();
		}   
		catch (IOException e)   {  
			e.printStackTrace();  
		}  


 
        
        /*try {
			inventoryDatabaseWriter = new FileWriter("inventoryList.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
        
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
}
