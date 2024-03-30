package seleniumtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		
		
		
		//Set path of executable browser driver
		System.setProperty("webdriver.chrome.driver", "/home/satyendra/setup/selenium/chromedriver");
				
		WebDriver driver = new ChromeDriver();
		
		String URL = "https://demoqa.com/droppable/";
				
		driver.get(URL);
		// It is always advisable to Maximize the window before performing DragNDrop action		 
		driver.manage().window().maximize();
				 
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		
		Actions builder = new Actions(driver);
		
		WebElement from = driver.findElement(By.id("draggable"));
		
		WebElement to = driver.findElement(By.id("droppable"));
		
		builder.dragAndDrop(from, to).perform();
		
		String toget = to.getText();
		
		if (toget.equals("Dropped!")) {
			System.out.println("The element is dropped!!");
			
		}else
		{
			System.out.println("The element is not droped \"Test Failed\" ");
		}
		
		Thread.sleep(4000);
		
		driver.quit();
		
		
		
		
	}

}
