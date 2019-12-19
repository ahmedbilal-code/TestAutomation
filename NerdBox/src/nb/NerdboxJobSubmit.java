package nb;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mongodb.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class NerdboxJobSubmit {


	WebDriver driver=null;



	@BeforeTest()
	@Parameters("browser")
	public void setup(String browsername) {
		if(browsername.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}


	}



	@Test(priority=1,enabled=true)
	public void SubmitQuestions() throws Exception {


		driver.manage().window().maximize();
		driver.get("https://q.nerd-box.com/questions");
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/div[1]/div/div/div[2]/divq")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/span/div/div[1]/div[3]/div[2]/div")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/span/div/div[1]/div/div/div[2]/div")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/span/div/div[1]/div/div/div/div[2]/div")).click();

		Thread.sleep(1000);

		//driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/span/div/div[1]/div[2]/div[1]/div/input")).sendKeys("Black");
		driver.findElement(By.xpath("//input[@placeholder='Type here']")).sendKeys("Black");
		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/span/div/div[1]/div[2]/div[2]/div[1]/button")).click();

		Thread.sleep(1000);

		//driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/span/div[1]/div/textarea")).sendKeys("Test From Front End!");
		driver.findElement(By.xpath("//*[@class='inputTextArea']")).sendKeys("Test From Front End!");


		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/span/div[3]/div[1]/button")).click();

		Thread.sleep(2000);

		//driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/span/div[1]/div/input")).sendKeys("dy1 4sq");
		driver.findElement(By.xpath("//input[@placeholder='Type your answer here']")).sendKeys("dy1 4sq");

		Thread.sleep(2000);

		driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/span/div[2]/div[1]/button")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@placeholder='Type your answer here...']")).sendKeys("Ahmed Automated");
		//driver.findElement(By.cssSelector("div.question-main-container div.question-container div:nth-child(1) span:nth-child(1) div.text-wrapper div:nth-child(1) > input.inputTextArea")).sendKeys("Ahmed Automated");

		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/span/div[2]/div[1]/button")).click();

		Thread.sleep(1000);


		//driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/span/div[1]/div/input")).sendKeys("ahmed.bilal+1002@seventechnology.co.uk");
		driver.findElement(By.xpath("//input[@placeholder='Type your answer here']")).sendKeys("ahmed.bilal+1002@seventechnology.co.uk");


		Thread.sleep(1000);

		driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/span/div[2]/div[1]/button")).click();

		Thread.sleep(1000);

		//driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/span/div[1]/div/input")).sendKeys("23232323");
		driver.findElement(By.xpath("//input[@placeholder='Type your answer here']")).sendKeys("23232323");



		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/span[1]/div[2]/div[1]/button")).click();
		//driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/span[1]/div[2]/div[1]/button")).click();

		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//This will scroll the web page till end.		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div/span[2]/div/div/div[1]/button")).click();

		Thread.sleep(6000);

		//		String actual=driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[1]/h2")).getText();
		//		String expected= "Thanks, your job has been posted!";
		//
		//		Assert.assertEquals(actual, expected);

		//driver.quit();
	}

	///html/body/div/div/div[3]/div/div/span[2]/div/div/div[1]/button

	private String id="1234";

	@Test(priority=2,enabled=true,dependsOnMethods= {"SubmitQuestions"})
	public void AddQuote() throws InterruptedException {
		DatabaseConnection dbConn = new DatabaseConnection();
		this.id = dbConn.getJob();
		//driver.manage().window().maximize();
		driver.get("https://q.nerd-box.com/estimatejob/5c9a0ddcec31f155f5ef0007/"+id);
		Thread.sleep(8000);

		driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div[2]/div[2]/div/div[2]/div[2]/form/div/div[1]/input[1]")).click();
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div[2]/div[2]/div/div[2]/div[2]/form/div/div[1]/input[1]")).sendKeys("50");

		//Thread.sleep(3000);
		driver.findElement(By.cssSelector(".comments-input")).click();
		driver.findElement(By.cssSelector(".comments-input")).sendKeys("Test Chat Automated Message");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div[2]/div[2]/div/div[2]/div[2]/form/div/div[2]/button")).click();

		Thread.sleep(5000);
		//assertThat(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/p")).getText(), is("We've sent your quote to the customer and you'll receive an email if they respond to you."));



	}


	@Test(priority=3,enabled=true,dependsOnMethods= {"AddQuote"})

	public void AcceptQuote() throws InterruptedException {

		driver.get("https://q.nerd-box.com/job/5d3564a80884ae08bd5b5d0b/"+id+"?ts=5c9a0ddcec31f155f5ef0007");
		//driver.get("https://q.nerd-box.com/job/5d3564a80884ae08bd5b5d0b/5dde2f192e26ff07990fdd5a?ts=5c9a0ddcec31f155f5ef0007");

		Thread.sleep(8000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div[4]/div[2]/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='location']")).sendKeys("home automated");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".jss102")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div[3]/div[2]/div/div/form/div[1]/input")).sendKeys("AUTOMATED!");
		Thread.sleep(5000);
		driver.switchTo().frame("__privateStripeFrame5");
		driver.findElement(By.name("cardnumber")).sendKeys("4111111111111111");
		Thread.sleep(2000);
		driver.switchTo().parentFrame();

		driver.switchTo().frame("__privateStripeFrame6");
		driver.findElement(By.name("exp-date")).sendKeys("222");
		Thread.sleep(2000);
		driver.switchTo().parentFrame();

		driver.switchTo().frame("__privateStripeFrame7");
		driver.findElement(By.name("cvc")).sendKeys("222");
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/div[3]/div[2]/div/div/form/div[4]/button")).click();
		Thread.sleep(5000);
		driver.quit();

	}


	@AfterTest
	public void tearDown() throws Exception 
	{
		driver.quit();
	}

//	@AfterSuite
//	public void sendmemail() throws Exception {
//		SendMail.execute(null);	
//	}

}
