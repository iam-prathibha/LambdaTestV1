package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage{
	
	public AccountRegisterPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtPhoneNumber;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtPasswordConfirmation;
	
	@FindBy(xpath="//label[@for='input-agree']")
	WebElement chkBoxPrivacyPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement successMSG;
	
	public void setFirstName(String fName) {
		txtFirstName.sendKeys(fName);
	}
	
	public void setLastName(String lName) {
		txtLastName.sendKeys(lName);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPhoneNumber(String phnNum) {
		txtPhoneNumber.sendKeys(phnNum);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void setConfirmPassword(String password) {
		txtPasswordConfirmation.sendKeys(password);
	}
	
	public void clickPrivacyPolicy() {
		chkBoxPrivacyPolicy.click();
	}
	
	public void clickContinueBtn() {
		btnContinue.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return(successMSG.getText());
		}catch(Exception e) {
			return (e.getMessage());
		}
	}
	
}
