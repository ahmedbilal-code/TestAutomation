package WebPractice.webpractice.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google {

	WebDriver driver=null;

	@BeforeTest
	public void beforeMethod() {

		String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

		System.out.println("Starting Test On Chrome Browser");

		WebDriverManager.chromedriver().setup();

		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

		driver=new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(baseUrl);
	}
	

	@AfterTest
	public void afterMethod() {
		driver.quit();
		
		System.out.println("Finished Test On Chrome Browser");
	}
	
	@Test
	public void f() throws InterruptedException {



		System.out.println("Launching google"); 
		//String testTitle = "Google";
		String originalTitle = driver.getTitle();
		System.out.println(originalTitle);
		//Assert.assertEquals(originalTitle, testTitle);
		//		driver.findElement(By.xpath("//input[@title='Search']")).click();
		//		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Allah is the greatest");
		//		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")).click();
		Thread.sleep(2000);
		String testTitle1 = "First name is required.";
		String originalTitle1 = driver.findElement(By.xpath("//*[@id=\"customer.firstName.errors\"]")).getText();
		System.out.println(originalTitle1);
		Assert.assertEquals(originalTitle1, testTitle1);
		driver.findElement(By.xpath(".//a[text()='Forgot login info?']")).click();
		Thread.sleep(5000);

	}
}
