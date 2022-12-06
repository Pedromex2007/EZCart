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
import cop4331.accountwindows.Seller;

/**
 * 
 * @author Rafael Luviano
 *
 */
public class Database {
	
	public static Database Instance;

	
	private ArrayList<Account> activeAccounts = new ArrayList<Account>();
	public ArrayList<Product> activeProducts = new ArrayList<Product>();
	
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
			inventoryDatabase = new File("inventoryList.csv");
			
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
	
	/**
	 * Create a new entry in our csv "database" containing the information of the specific product.
	 * @param product Product to introduce into the csv sheet
	 */
	public void CreateProductEntryDatabase(Product product) {
		
        String[] productDetails = new String[7];
        productDetails[0] = Integer.toString(product.getProductID());
        productDetails[1] = product.getName();
        productDetails[2] = Float.toString(product.getSellPrice());
        productDetails[3] = Float.toString(product.getInvoicePrice());
        productDetails[4] = Integer.toString(product.getQuantity());
        productDetails[5] = product.getSellerName();
        
        try {
        	
        	DiscountedProduct discProd = (DiscountedProduct)product;
        	productDetails[6] = Float.toString(discProd.getSellPrice());
        	
        } catch (ClassCastException e) {
        	
        	System.out.println("This is not a discounted product. Disregarding.");
        	productDetails[6] = null;
        	
        }

        
        activeProducts.add(null);	

        FileWriter fileWriter = null;
        
		try {
			
			fileWriter = new FileWriter(inventoryDatabase, true);
			
		} catch (IOException e) {

			e.printStackTrace();
			
		}



        StringBuilder line = new StringBuilder();
        
        for (int i = 0; i < productDetails.length; i++) {
        	
        	if(productDetails[i] == null) continue;
        	
            line.append(productDetails[i].replaceAll("\"","\"\""));
            if (i != productDetails.length - 1) {
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
	
	private void LoadInventoryItems() {
		String line = "";  
		String splitBy = ",";  
		
		try {
			while ((line = inventoryDatabaseReader.readLine()) != null) {  
				
				String[] le_line = line.split(splitBy);
				System.out.println(le_line[0] + ", " );  
				
				try {
					activeProducts.add(new DiscountedProduct(
						Integer.parseInt(le_line[0]), le_line[1], Float.parseFloat(le_line[2]), Float.parseFloat(le_line[3]), Integer.parseInt(le_line[4]), le_line[5], Float.parseFloat(le_line[6]))
					);
					PopulateSellerInventory(activeProducts.get(activeProducts.size()-1));
				} catch (Exception e) {
					// Not a discounted product. Adding regular product.
					activeProducts.add(new Product(
						Integer.parseInt(le_line[0]), le_line[1], Float.parseFloat(le_line[2]), Float.parseFloat(le_line[3]), Integer.parseInt(le_line[4]), le_line[5])
					);
					PopulateSellerInventory(activeProducts.get(activeProducts.size()-1));
				}

				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	
	private void PopulateSellerInventory(Product product) {
		for(Account account : activeAccounts) {
			
			try {
				Seller sellAccount = (Seller)account;
				
				if(product.getSellerName().equals(sellAccount.getUsername())) {
					sellAccount.getInventory().AddProduct(product);
				}

			} catch (ClassCastException e) {
				continue;
			}
			

		}
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
				Account.loggedAccount = account;
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
