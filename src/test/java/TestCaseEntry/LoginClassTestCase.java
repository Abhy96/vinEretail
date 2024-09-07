package TestCaseEntry;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.Base;
import Entry.HomePage;
import Entry.LoginClass;

public class LoginClassTestCase extends Base {

	LoginClass loginClass;
	HomePage homePage;
	LoginClassTestCase(){
		super();// it will call parent class constructor and super keyword always first statement after the constructor.
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		 loginClass= new LoginClass();
	}
	
	@Test(priority = 1)
	public void loginPageTitletest() {
	String title= loginClass.validateLoginPageTitle();
	Assert.assertEquals(title, "Welcome to eRetail");
		
	}
	@Test(priority = 2)
	public void eRetailLogoImageTest() {
	boolean flag=loginClass.validateEretailImage();
	Assert.assertTrue(flag);
	
	 
	}
	@Test(priority = 3)
	public void loginTest() {
	homePage=loginClass.login(prop.getProperty("userOrgId"), prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
