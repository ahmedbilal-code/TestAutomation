package BitBabyGUIAutomation.BitBabyGUIAutomation;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;




public class bbuitests {

	AppiumDriver driver;


	@BeforeTest
	public void beforeTest() throws MalformedURLException {{
		DesiredCapabilities cap=  new DesiredCapabilities();
		cap.setCapability("devicename", "A13");
		cap.setCapability("udid", "R58T80RPT9F");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformversion", "13" );
		cap.setCapability("appPackage", "com.nova.bitbaby");
		cap.setCapability("appActivity", "com.nova.bitbaby.MainActivity");
		URL url = new URL("http://127.0.0.1:4723/wd/hub"); 

		driver = new AppiumDriver(url,cap);	

	}
	}


	@Test
	public void LoginScreen() throws InterruptedException {

		System.out.println("BB App Started!");
		Thread.sleep(7000);

		String Signin_label=driver.findElement(By.xpath("//android.widget.TextView[@index='1' and @text='Sign In']")).getText();
		System.out.println("Sign in label has returned this text->"+Signin_label);

		String forgotpassword_text=driver.findElement(By.xpath("//android.widget.TextView[@index='0' and @text='Forgot password']")).getText();
		System.out.println("Forgot Password CTA has returned this text->"+forgotpassword_text);

		String Signup_text=driver.findElement(By.xpath("//android.widget.TextView[@index='0' and @text='Sign up']")).getText();
		System.out.println("Sign up CTA has returned this text->"+Signup_text);

		String Partner_register_text=driver.findElement(By.xpath("//android.widget.TextView[@index='0' and @text='Register ']")).getText();
		System.out.println("Register as partner CTA has returned this text->"+Partner_register_text);


		//clicking forgot password CTA
		driver.findElement(By.xpath("//android.widget.TextView[@index='0' and @text='Forgot password']")).click();
		Thread.sleep(3000);
		System.out.println("Forgot password tapped successfully!");

		String Temporary_password_label=driver.findElement(By.xpath("//android.widget.TextView[@index='1' and @text='Temporary password']")).getText();
		System.out.println("Temporary password label has returned this text->"+Temporary_password_label);

		Thread.sleep(2000);

		System.out.println("Now going back to login screen again!");

		driver.navigate().back();
		
		//tapping on sign up as mother
		driver.findElement(By.xpath("//android.widget.TextView[@index='0' and @text='Sign up']")).click();
		Thread.sleep(3000);
		System.out.println("Sign up tapped successfully!");

		String Signupscreen_label=driver.findElement(By.xpath("//android.widget.TextView[@index='1' and @text='Tell us your email address']")).getText();
		System.out.println("Signup screen label has returned this text->"+Signupscreen_label);
		
		Thread.sleep(2000);

		System.out.println("Now going back to login screen again!");

		driver.navigate().back();
		
		//tapping on sign up as partner
		driver.findElement(By.xpath("//android.widget.TextView[@index='0' and @text='Register ']")).click();
		Thread.sleep(3000);
		System.out.println("Register as partner CTA tapped successfully!");

		String Registerscreen_label=driver.findElement(By.xpath("//android.widget.TextView[@index='1' and @text='Tell us your email address']")).getText();
		System.out.println("Signup screen label has returned this text->"+Registerscreen_label);
		
		Thread.sleep(2000);

		System.out.println("Now going back to login screen again!");

		driver.navigate().back();
		
		System.out.println("Entering Username.");
		driver.findElement(By.xpath("//android.widget.EditText[@index='0' and @resource-id='signin_email']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@index='0' and @resource-id='signin_email']")).sendKeys("abc@abc.com");
		
		System.out.println("Entering Password.");
		driver.findElement(By.xpath("//android.widget.EditText[@index='0' and @resource-id='signin_password']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@index='0' and @resource-id='signin_password']")).sendKeys("abc");
		
		System.out.println("Clicking Signin button.");
		//driver.findElement(By.xpath("//android.widget.TextView[@index='1' and @text='Sign In']")).click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView")).click();
		System.out.println("Clicked Signin button.");
		Thread.sleep(7000);
	}

	@AfterTest
	public void afterTest() {
		
		driver.quit();
	}

}
