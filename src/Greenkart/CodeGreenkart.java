package Greenkart;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CodeGreenkart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.mytime.de/Schorlen_210002703.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.switchTo().activeElement();
		driver.findElement(By.xpath("//*[@id='accept-consent-all']")).click();
		//driver.findElement(By.xpath("//*[@class='btn btn--secondary']")).click();
		//System.out.println("Done");
		driver.switchTo().activeElement();
		//String Title = driver.findElement(By.xpath("//div[@class='dialog-title']")).getText();
		//System.out.println(Title);
		driver.findElement(By.xpath("//form[@id='savePostalCodeForm-1'] /input[@type='text']")).sendKeys("20001");
		driver.findElement(By.xpath("//button[@form='savePostalCodeForm-1']")).click();
		driver.switchTo().activeElement();
		//driver.findElement(By.xpath("//button[@class='dialog-button dialog-button-primary']")).click();
		driver.findElement(By.xpath("(//button[@class='dialog-close'])[1]")).click();
		String[] products = {"Vilsa H2Obst Apfel Kirsche (Einweg)","Bionade Naturtrübe Zitrone MEHRWEG"};
		
		List<WebElement> Productname = driver.findElements(By.xpath("//h3[@class='product-card__name']"));
		//System.out.println(Productname.size());    // this is 16 as total no of products matching the above element is 16
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		for (int i =0 ; i< Productname.size(); i++)
		{
			String name = Productname.get(i).getText();
			System.out.println(name);
			List alproducts = Arrays.asList(products);
			
			if (alproducts.contains(name))   // In first iteration it will check that the name is fetching the Jeden Tag Apfelschorle (Einweg) so is it matching with arraylist , and that arraylist has been converted from array which ultimately has two string or products
			{
				
				driver.findElements(By.xpath("//button[@class='btn quantity__btn quantity__btn--inc']")).get(i).click();
				
				driver.findElements(By.xpath("//div[@class='product-card__order__buttons'] /button[@type='button']")).get(i).click();
			}
		
	
		
	}
		driver.findElement(By.xpath("//a[@class='btn btn--primary cta btn--to-checkout ']")).click();
		driver.findElement(By.xpath("(//*[@class='icon icon--close']) [2]")).click();
	}
}
