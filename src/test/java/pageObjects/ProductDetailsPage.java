package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage{
	
	public  ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@data-id='216842']//button[@title='Add to Cart'][normalize-space()='Add to Cart']")
	WebElement btnAddToCart;
	
	@FindBy(xpath="//div[@id='notification-box-top']//a[normalize-space()='View Cart']")
	WebElement btnViewCart;
	
	public void clickAddtoCartbtn() {
		btnAddToCart.click();
	}
	
	Actions action= new Actions(driver);
	public void clickOnViewCartbtn() {
		action.moveToElement(btnViewCart).click().perform();
		
	}
	
}
