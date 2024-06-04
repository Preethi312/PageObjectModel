package config;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import commonFunctions.AdminLoginPage;
import commonFunctions.AdminLogoutPage;

public class AppUtil 
{
  public static WebDriver driver;
  public static Properties prop;
  @BeforeTest
  public static void Setup()throws Throwable
  {
	 prop = new Properties();
	 prop.load(new FileInputStream("./PropertyFile/Login.properities"));
	 if(prop.getProperty("Browser").equalsIgnoreCase("chrome"))
	 {
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(prop.getProperty("Url"));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 AdminLoginPage Login = PageFactory.initElements(driver, AdminLoginPage.class);
		 Login.adminLogin("admin", "master");
	 }
	 else if (prop.getProperty("Browser").equalsIgnoreCase("Firefox"))
	 {
		 driver = new FirefoxDriver();
		 driver.get(prop.getProperty("Url"));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 AdminLoginPage Login = PageFactory.initElements(driver, AdminLoginPage.class);
		 Login.adminLogin("admin", "master");
	 }
	 else
	 {
		 Reporter.log("Browser not compatible");
	 }
  }
  @AfterTest
  public static void teardown()
  {
	  AdminLogoutPage Logout = PageFactory.initElements(driver, AdminLogoutPage.class);
	  Logout.adminLogout();
	  driver.quit();
  }
}
