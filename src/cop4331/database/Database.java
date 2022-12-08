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
import cop4331.accountwindows.Buyer;
import cop4331.accountwindows.Seller;

/**
 * 
 * @author Rafael Luviano
 *
 */
public class Database {
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
		//EditProductInformationDatabase();
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
				
				if(le_line[3].equals("Seller")) {
					activeAccounts.add(new Seller(le_line[0], le_line[1], le_line[2]));
				} else {
					activeAccounts.add(new Buyer(le_line[0], le_line[1], le_line[2]));
				}
				
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
		System.out.println("Product ID: " + Integer.toString(product.getProductID()));
		System.out.println("Product name: " + product.getName());
		System.out.println("Sell price: " + Float.toString(product.getSellPrice()));
		System.out.println("Invoice price: " + Float.toString(product.getInvoicePrice()));
		System.out.println("Quantity: " +  Integer.toString(product.getQuantity()));
		System.out.println("Seller name: " + product.getSellerName());
        
        try {
        	
        	DiscountedProduct discProd = (DiscountedProduct)product;
        	productDetails[6] = Float.toString(discProd.getSellPrice());
        	
        } catch (ClassCastException e) {
        	
        	System.out.println("This is not a discounted product. Disregarding.");
        	productDetails[6] = null;
        	
        }

        
        activeProducts.add(product);	
        
        WriteToCSV(productDetails, inventoryDatabase, true);
        
        
	}
	
	/***
	 * Edit a product with the new product information. Product with the matching ID will be modified.
	 * @param originalProduct Product to alter.
	 * @param newProduct New product information.
	 */
	public void EditProductInformationDatabase(Product originalProduct, Product newProduct) {
		
		try {
			inventoryDatabaseReader = new BufferedReader(new FileReader("inventoryList.csv"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}  
		
		ArrayList<String[]> csvLines = GetCSVLines(inventoryDatabaseReader);
		
		
		
		
		
		for(String[] lineString : csvLines) {
			System.out.println("READING");
			
			System.out.println(Integer.parseInt(lineString[0]) + " | " + originalProduct.getProductID());
			
			if(Integer.parseInt(lineString[0]) == originalProduct.getProductID()) {
				lineString[1] = newProduct.getName();
				lineString[2] = Float.toString(newProduct.getBasePrice());
				lineString[3] = Float.toString(newProduct.getInvoicePrice());
				lineString[4] = Integer.toString(newProduct.getQuantity());
				
				//System.out.println("I found it! Editing...");
				
		        try {
		        	
		        	DiscountedProduct discProd = (DiscountedProduct)newProduct;
		        	lineString[6] = Float.toString(discProd.getDiscountAmount());
		        	
		        } catch (ClassCastException e) {
		        	System.out.println("Not a discounted product.");
		        	lineString[6] = "0";
		        }

				break;
			}			
			
		}
		
		//This will override everything and starting recreating the database.
		//Only way to edit/remove things from the file apparently.
		boolean append = false;
		
		for(String[] innerLine : csvLines) {
			WriteToCSV(innerLine, inventoryDatabase, append);
			append = true;
		}
		
		for(Product product : activeProducts) {
			if(product.getProductID() == originalProduct.getProductID()) {
				activeProducts.remove(product);
				break;
			}
		}
		
		
        try {
        	
        	DiscountedProduct discProd = (DiscountedProduct)newProduct;
        	activeProducts.add(new DiscountedProduct(discProd));
        	
        } catch (ClassCastException e) {
        	activeProducts.add(new Product(newProduct));
        }


		PopulateSellerInventory();
		//LoadInventoryItems();
		
	}
	
	
	/***
	 * Get every line from a specific CSV file and turn it into an ArrayList. Useful or editing or deleting rows.
	 * @param csvFile
	 * @return ArrayList of every line from a CSV file.
	 */
	private ArrayList<String[]> GetCSVLines(BufferedReader csvFile) {
		
		ArrayList<String[]> csvLines = new ArrayList<String[]>();
		String line = "";  
		String splitBy = ",";  
		
		try {
			while ((line = inventoryDatabaseReader.readLine()) != null) {  
				
				String[] le_line = line.split(splitBy);
				csvLines.add(le_line);
				System.out.println(le_line[0] + ", " );  

				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return csvLines;
	}
	
	
	/**
	 * Load all of the product items in our bootleg database, aka the csv files, and add them into memory.
	 */
	private void LoadInventoryItems() {
		String line = "";  
		String splitBy = ",";  
		
		activeProducts.clear();
		
		try {
			while ((line = inventoryDatabaseReader.readLine()) != null) {  
				
				String[] le_line = line.split(splitBy);
				
				if(Float.parseFloat(le_line[6]) > 0) {
					activeProducts.add(new DiscountedProduct(
							Integer.parseInt(le_line[0]), le_line[1], Float.parseFloat(le_line[2]), Float.parseFloat(le_line[3]), Integer.parseInt(le_line[4]), le_line[5], Float.parseFloat(le_line[6]))
						);
				} else {
					// Not a discounted product. Adding regular product.
					activeProducts.add(new Product(
						Integer.parseInt(le_line[0]), le_line[1], Float.parseFloat(le_line[2]), Float.parseFloat(le_line[3]), Integer.parseInt(le_line[4]), le_line[5])
					);
				}

				
			}
			PopulateSellerInventory();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	/**
	 * Populate each seller's inventory with products that they were responsible for posting.
	 * @param product Product to link  with seller account.
	 */
	private void PopulateSellerInventory() {
		
		for(Account account : activeAccounts) {
			try {
				Seller sellAccount = (Seller)account;
				sellAccount.getInventory().GetProducts().clear();

			} catch (ClassCastException e) {
				continue;
			}
		}
		
		for(Product product : activeProducts) {
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
	 * Check with the active account list to see if the username is taken.
	 * @param username The username we're checking.
	 * @return if the username already exists.
	 */
	public boolean usernameIsTaken(String username) {
		
		for(Account account : activeAccounts) {
			
				if(account.getUsername().equals(username)) {
					System.out.println("Username taken");
					return true;
				}
			
		}
		return false;
		
	}

	/**
	 * Check with the active account list to see if the email is taken.
	 * @param email The email we're checking.
	 * @return if the email already exists.
	 */
	public boolean emailIsTaken(String email) {
		
		for(Account account : activeAccounts) {
			
				if(account.getEmail().equals(email)) {
					System.out.println("Email taken");
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
	public void RegisterAccount(String username, String password, String email, String type) {
        
        String[] accountDetails = new String[4];
        accountDetails[0] = username;
        accountDetails[1] = password;
        accountDetails[2] = email;
        accountDetails[3] = type;
        
        activeAccounts.add(new Account(username, password, email));	

        WriteToCSV(accountDetails, userDatabase, true);
        
	}
	
	/***
	 * Take an array of strings which serve as a row. Append the row to an existing csv file, or override the whole thing.
	 * @param stringLine
	 * @param file
	 * @param append
	 */
	private void WriteToCSV(String[] stringLine, File file, boolean append) {
		
        FileWriter fileWriter = null;
        
		try {
			
			fileWriter = new FileWriter(file, append);
			
		} catch (IOException e) {

			e.printStackTrace();
			
		}



        StringBuilder line = new StringBuilder();
        
		
        for (int i = 0; i < stringLine.length; i++) {
        	System.out.println(stringLine.length);
            //line.append("\"");
            line.append(stringLine[i].replaceAll("\"","\"\""));
            //line.append("\"");
            if (i != stringLine.length - 1) {
                line.append(',');
            }
            
        }
        
        line.append("\n");
        
        try {
			fileWriter.write(line.toString());
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
