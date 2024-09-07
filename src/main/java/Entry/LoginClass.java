package Entry;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.Base;

public class LoginClass extends Base {

	//Page Factory - object repository(or)    // These are the page libraries
	
	@FindBy(name="userOrgId")//vspl,bldrt
	WebElement userOrgId;
	
	@FindBy(name="userName")//sa
	WebElement userName;
	
	@FindBy(id="password")//vin@123
	WebElement password;
	
	@FindBy(name="Login")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[contains(@src,'images/img/logo.png')]")
	WebElement eRetaillogo;
	
	//Initialize Page Object
	public LoginClass() {
		PageFactory.initElements(driver, this);// With the initElements() method we will initialize page factory and "this" is for pointing the  Current class object
	}
	
	//Actions it means features
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateEretailImage() {
		return eRetaillogo.isDisplayed();// true or false 
	}
	
	public HomePage login(String OrgId, String uName, String pwd) {
		userOrgId.sendKeys(OrgId);
		userName.sendKeys(uName);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
}
