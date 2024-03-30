package seleniumtest;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.*;
import java.io.Reader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Test {

  
  private static final String SAMPLE_CSV_FILE_PATH = "/home/satyendra/Documents/eclipseEEworkspace/seleniumtest/src/seleniumtest/data.csv";

  public static void main(String[] args) throws IOException {
    LinkedHashSet<String> set1=new LinkedHashSet();  
	  
		//Set path of executable browser driver
		//System.setProperty("webdriver.chrome.driver", "/home/satyendra/setup/selenium/chromedriver");
		
	  System.setProperty("webdriver.gecko.driver", "/home/satyendra/setup/selenium/geckodriver");
      
//	 
		WebDriver driver = new FirefoxDriver();
//		
//////		ChromeOptions options = new ChromeOptions();
//////		options.addArguments("--remote-allow-origins=*");
//////		WebDriver driver = new ChromeDriver(options);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println(driver.getTitle());
		
		  synchronized (driver) {
            try {
               driver.wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		  
		  
		  
     // driver.wait(20000);
   
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");  
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123"); 
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		
		synchronized (driver) {
          try {
             driver.wait(10000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
		driver.findElement(By.xpath("//div[@id='app']/div/div/aside/nav/div[2]/ul/li[2]/a/span")).click();
		
		synchronized (driver) {
          try {
             driver.wait(10000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
		
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		
		
		
	  
	  


		
	
	  
	  
	  
	  
	  
	  
	  
	 
	  
	  
	  try (
	      Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
	      //Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
          CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
      ) {
	    for (CSVRecord csvRecord : csvParser) {
              String name = csvRecord.get(0);
              String middle = csvRecord.get(1);
              String surname = csvRecord.get(2);
             
              set1.add(name+" " +middle+ " " + surname);
             
              System.out.println("Record No - " + csvRecord.getRecordNumber());
              System.out.println("---------------");
              System.out.println("Name : " + name);
              System.out.println("Email : " + middle);
              System.out.println("Phone : " + surname);
             
              System.out.println("---------------\n\n");
              
              System.out.println("--------------------------------------------\n\n");
              Iterator<String> it1 = set1.iterator();
              
              while(it1.hasNext()) {
                System.out.println(it1.next());
              }
             
              System.out.println("--------------------------------------------\n\n");
              System.out.println("--------------------------------------------\n\n");
              
          }
	  }
	  
	  
	  
	
	  
	  
//	  driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Raghuram")
//	  
//	  
//	  xpath=//input[@name='firstName']    raghumram
//	      xpath=//input[@name='middleName']
//	      xpath=//input[@name='lastName']
//	      xpath=//button[@type='submit']
//	  
//	  
//	  
//	  
//	  
//	  
	  
	  
	  
	  
	  
	  
	 
      JavascriptExecutor js = (JavascriptExecutor) driver;

      String name1 = "Raghuram Venkat";
      
      Iterator<String> it1 = set1.iterator();
      
      while(it1.hasNext()) {
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.HOME).perform();
      //Locating element by link text and store in variable "Element"             
        WebElement Element = driver.findElement(By.linkText(name1));
        System.out.println(it1.next());
        js.executeScript("arguments[0].scrollIntoView();", Element);
      }
      //Locating element by link text and store in variable "Element"             
     // WebElement Element = driver.findElement(By.linkText());

      // Scrolling down the page till the element is found        
      
//	  
//	  
//	  
//	  
//	  
//	
//	  
	  driver.quit();
//	  
//	  
	  
	  
	  
	  
//	
	}
}
//	}
