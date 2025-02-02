package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h1[contains(text(),'Shopping Cart')]")
	WebElement txtCartPageConf;
	
	@FindBy(xpath="//td[@class='text-left']//a[contains(text(),'iPod Classic')]")
	WebElement txtProductName;
	
	@FindBy(xpath="//div[@class='buttons d-flex']//a[normalize-space()='Checkout']")
	WebElement btnCheckout;
	
	public String getCartPageHeading() {
		try {
		 return txtCartPageConf.getText();
		}catch(Exception e) {
			return e.getMessage();
		}
	}
	
	public String getProductName() {
		try {
			 return txtProductName.getText();
			}catch(Exception e) {
				return e.getMessage();
			}
	}
	
	public void clickCheckoutBtn() {
		btnCheckout.click();
	}

}
