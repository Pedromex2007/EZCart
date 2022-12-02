package cop4331.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Rafael Luviano
 *
 */
public class Database {
	
	public static Database Instance;
	
	
	
	private BufferedReader inventoryDatabaseReader;
	private BufferedReader userDatabaseReader;
	
	private FileWriter inventoryDatabaseWriter;
	private FileWriter userDatabaseWriter;
	
	/**
	 * Instantiate the database and connect to our csv files.
	 */
	public Database() {
		Instance = this;
		
		String line = "";  
		String splitBy = ",";  
		
		
		try   {  

			inventoryDatabaseReader = new BufferedReader(new FileReader("inventoryList.csv"));  
			while ((line = inventoryDatabaseReader.readLine()) != null) {  
				
				String[] le_line = line.split(splitBy);
				System.out.println(le_line[0] + ", " + le_line[1]);  
				
			}  
			
			inventoryDatabaseReader.close();
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
}
