/*Write an API to upload a CSV file to a schema table. For example: A CSV file with columns 
  such as ID, Name, Contact_No and Address should be parsed via an API and then the data should be 
  inserted into a table.
 
 Author : Swati Mahanag
 Date : 18-04-2018
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class CsvAPI {

	static BufferedReader fileReader = null;		
	static String fileName = "./csvfile.csv";
	public static void main(String[] args) {
		
		DataSet ds = null;
		DataSetSB dbs = null;
		try {
			
			dbs = new DataSetSB();
			dbs.CreateDatabase();
				fileReader = new BufferedReader(new FileReader(fileName));
				fileReader.readLine();
				System.out.println("Reading CSV File : \n");
				String line;
				while ((line = fileReader.readLine()) != null)
				{
					String[] file = line.split("\n");
					System.out.println(Arrays.toString(file));
					String[] tokens = line.split(",+");
	                ds = new DataSet(Integer.parseInt(tokens[0]),tokens[1],tokens[2],tokens[3]);
	                //  System.out.println(ds);
	                dbs.insertIntoDatabase(ds);
	            }
	                          
			dbs.ShowData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}

}
