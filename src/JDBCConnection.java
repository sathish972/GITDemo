import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class JDBCConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		//first we need to do a connection to the database
		// there we need pass the connection url, user and passsword for the server
		//connection url - "jdbc:mysql://"+host+":"+port+"/databasename";
		
		String host="localhost";
		String port="3306";
		// here we are the storing connection to the connection obj(its like destination where we want to go)
		//now need to create a statement(its like road to travel to the destination)
		Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/bankingdetails", "root", "Asxcvios@22*");
		// here creating a statement and assigning to the statement obj.
        Statement s=con.createStatement();
        
        //this resultset will contains the all the data that we get from execute query cmd
        //it is like array it will store the value in a 0 index
        ResultSet results=s.executeQuery("select * from credentials where scenario='zerobalancecard'");
        
        
        results.next();// its like moving our resultset to the first position
        	
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\sathish\\Browser Drivers\\chromedriver_win32\\chromedriver.exe");

       WebDriver driver=new ChromeDriver();	
       
        driver.get("https://login.salesforce.com/?locale=in");
        
        driver.findElement(By.cssSelector("#username")).sendKeys(results.getString("username"));
        driver.findElement(By.cssSelector("[type='password']")).sendKeys(results.getString("password"));
        
	}
	public void git()
	{
		System.out.println("i am from git");
		System.out.println("branch develop");
	}

}
