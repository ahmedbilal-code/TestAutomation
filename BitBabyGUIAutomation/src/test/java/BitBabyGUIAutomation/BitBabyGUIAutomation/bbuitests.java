package BitBabyGUIAutomation.BitBabyGUIAutomation;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;




public class bbuitests {
  
	AppiumDriver driver;
	
	@Test
  public void LoginScreen() {
		
		System.out.println("BB App Started!");
		
		
  }
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

  @AfterTest
  public void afterTest() {
  }

}
