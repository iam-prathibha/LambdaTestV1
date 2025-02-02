package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}	
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPwd;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement txtMyAccount;
	
	
	
	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void enterPassword(String pwd) {
		txtPwd.sendKeys(pwd);
	}
	
	public void clickLoginbtn() {
		btnLogin.click();
	}
	public String getStringToCompareLoginSuccessfull() {
		try {
			return (txtMyAccount.getText());
		}catch(Exception e) {
			return (e.getMessage());
		}
	}
}
