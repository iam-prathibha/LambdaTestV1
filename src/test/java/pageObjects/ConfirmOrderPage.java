package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmOrderPage extends BasePage{
	
	public ConfirmOrderPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//button[@id='button-confirm']")
	WebElement btnConfirmOrder;
	
	@FindBy(xpath="//h1[normalize-space()='Your order has been placed!']")
	WebElement txtCompareSuccess;
	
	public void clickConfirmOrder() {
		btnConfirmOrder.click();
	}
	
	public String getSuccessText() {
		try{
			return txtCompareSuccess.getText();
		}catch(Exception e) {
			return e.getMessage();
		}
	}

}
