package BaseClass;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utilities.UtilClass;


public class Base {
	  public static WebDriver driver;
		public static Properties prop;
		
		public Base() {  
			try {
				prop =new Properties();
				FileInputStream fis=new FileInputStream("C:\\Users\\abhay.gupta\\eclipse-workspace\\VinEretail\\src\\main\\java\\Configuration\\Config.Properties");
				prop.load(fis);
			} catch (Exception e) {
	            e.printStackTrace();
			}
		}
		
		public static void initialization() {
			
			String browserName=prop.getProperty("browser");
			
			if(browserName.equals("chrome")) { 
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhay.gupta\\eclipse-workspace\\VinEretail\\Drivers\\chromedriver.exe");
				driver=new ChromeDriver();
			}else if 
				(browserName.equals("Firefox")) { 
					System.setProperty("webdriver.gecko.driver", "C:\\Users\\abhay.gupta\\eclipse-workspace\\VinEretail\\Drivers\\geckodriver.exe");
					driver=new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(UtilClass.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(UtilClass.IMPLICIT_WAIT, TimeUnit.SECONDS );
			
			driver.get(prop.getProperty("Url"));
			
		}
}
