package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//a[@role='button']//span[@class='title'][normalize-space()='My account']")
	WebElement myAccount;
	
	
	@FindBy(xpath="//span[normalize-space()='Logout']")
	WebElement logoutLink;
	
	
	Actions action= new Actions(driver);
	
	public void clickOnMyAccount() {
		action.moveToElement(myAccount).perform();
	}
	
	public void clickLogoutLink() {
		action.moveToElement(logoutLink).click().perform();
	}
}
