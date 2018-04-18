/*Write an API to upload a CSV file to a schema table. For example: A CSV file with columns 
  such as ID, Name, Contact_No and Address should be parsed via an API and then the data should be 
  inserted into a table.
 
 Author : Swati Mahanag
 Date : 18-04-2018
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSetSB {
	Connection connection = null;
	Statement statement;
	public void CreateDatabase() throws ClassNotFoundException
	{
		Class.forName("org.sqlite.JDBC");
        
		try
		{
			connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
			statement = connection.createStatement();
			statement.executeUpdate("drop table if exists Dataset");
		    statement.executeUpdate("create table Dataset (id integer, name string, contact string, address string)");
		    System.out.println("Initialize : DataBase Created...");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	    
	}
	public void  insertIntoDatabase(DataSet ds)
	{
		String sql = "insert into Dataset values("+ds.getId()+","+"'"+ds.getName()+"'"+","+"'"+ds.getContact()+"'"+","+"'"+ds.getAddress()+"'"+")";
		try {
			statement.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ShowData()
	{
		System.out.println("\nReading Database.....");
		ResultSet rs;
		try {
			rs = statement.executeQuery("select * from Dataset");
			while(rs.next())
		    {
		        System.out.print("\t ID : " + rs.getInt("id"));
		        System.out.println("\n\t Name : " + rs.getString("name"));
		        System.out.println("\t Contact_NO : " + rs.getString("contact"));
		        System.out.println("\t Address : " + rs.getString("address"));
		        System.out.println(" ");
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	}
}
