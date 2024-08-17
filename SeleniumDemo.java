import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDemo {

	
	public static void main(String[] args) throws InterruptedException {
		
		//Create object for ChromeDriver and invoke new empty chrome page 
		WebDriver driver = new FirefoxDriver();
		driver.get("https://merakirana.com/");
		//Wait for 30ms 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Browser window maximize 
		driver.manage().window().maximize();
		//Using get method of WebDriver interface,get the title of the page
		String title = driver.getTitle();
		
		//Using if condition verify the page title is correct 
		if (title.equals("Merakirana")) {
			System.out.println("We Are On The Merekirana PAGE...");
		}else {
			System.out.println("Oopss logged into wrong page... try again...");
		}
		
		//Verify Merakirana logo is displayed?
		boolean resl = driver.findElement(By.xpath("//img[@title='Merakirana-logo']")).isDisplayed();
		Thread.sleep(3000);
		System.out.println(resl);
		

system.out.println("RepoTest");
		
		//Now click on Home menu link & verify the page
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		String value= driver.findElement(By.id("latest_active")).getText();
		System.out.println("LATEST".equals(value));
		
		//Click on Brands menu link & verify the page
		driver.findElement(By.xpath("//a[contains(text(),'Brands')]")).click();
		String brVal = driver.findElement(By.xpath("//a[normalize-space()='Brand']")).getText();
		System.out.println(brVal);
		System.out.println("BRAND".equals(brVal));
		Thread.sleep(3000);
		
		//Click on Orders menu link & verify the page
		driver.findElement(By.xpath("//a[contains(text(),'Orders')]")).click();
		String ordVal = driver.findElement(By.xpath("//p[@class='ls-signin-title']")).getText();
		System.out.println(ordVal);
		System.out.println("Log in".equals(ordVal));
		//Close Pop-up window by clicking close button
		driver.findElement(By.xpath("//button[@class='close'][@aria-label='Close']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Contact Us')]")).click();
		String conVal = driver.findElement(By.xpath("//div[@id='content']//li[2]")).getText();
		System.out.println(conVal);
		System.out.println("CONTACT US".equals(conVal));
		
		//Navigate back to Home page
		driver.navigate().to("https://merakirana.com/");
		
		//Getting multiple tabs elements (latest, best sellers & specials 
		List<WebElement> menuList = driver.findElements(By.xpath("//div[@id='tabs']/ul/li"));
		
		//Here getting the value of with given attribute & perform click operation 
		for(int i=0; i<menuList.size(); i++) {
			String res = menuList.get(i).getAttribute("id");
			System.out.println(res);
			driver.findElement(By.id(res)).click();
			Thread.sleep(3000);			
		}
		
		
	driver.quit();	
	}
 
}
