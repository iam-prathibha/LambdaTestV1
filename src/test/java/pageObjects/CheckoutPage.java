package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//label[normalize-space()='Guest Checkout']")
	WebElement rdbtnGuestCheckout;
	
	@FindBy(xpath="//input[@id='input-payment-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-payment-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-payment-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-payment-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-payment-address-1']")
	WebElement txtAddress1;
	
	@FindBy(xpath="//input[@id='input-payment-city']")
	WebElement txtCity;
	
	@FindBy(xpath="//input[@id='input-payment-postcode']")
	WebElement txtPostCode;
	
	@FindBy(xpath="//select[@id='input-payment-country']")
	WebElement optCountry;
	
	@FindBy(xpath="//select[@id='input-payment-zone']")
	WebElement optState;
	
	@FindBy(xpath="//label[@for='input-agree']")
	WebElement chkBxTermsandConditions;
	
	@FindBy(xpath="//button[@id='button-save']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Confirm Order']")
	WebElement txtForCompare;
	
	@FindBy(xpath="//label[@for='input-payment-address-existing']")
	WebElement rdoBtnUseExistingAddress;
	
	public void selectGuestCheckout() {
		rdbtnGuestCheckout.click();
	}
	
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPhoneNumber(String phoneNum) {
		txtTelephone.sendKeys(phoneNum);
	}
	
	public void setAddress1(String address1) {
		txtAddress1.sendKeys(address1);
	}
	
	public void setCity(String city) {
		txtCity.sendKeys(city);
	}
	
	public void setPostalCode(String code) {
		txtPostCode.sendKeys(code);
	}
	
	public void setCountry(String country) {
		Select countryoptions= new Select(optCountry);
		countryoptions.selectByVisibleText(country);
	}
	
	public void setState(String state) {
		Select stateoptions= new Select(optState);
		stateoptions.selectByVisibleText(state);
	}
	
	public void clickTermsandConditions() {
		chkBxTermsandConditions.click();
	}
	
	public void clickContinueBtn() {
		btnContinue.click();
	}
	
	public String getCompareText() {
		try {
			return txtForCompare.getText();
		}catch(Exception e) {
			return e.getMessage();
		}
	}
	
	public void selectUseExistingAddress() {
		rdoBtnUseExistingAddress.click();
	}
}
