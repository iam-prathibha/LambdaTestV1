package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//a[@role='button']//span[@class='title'][normalize-space()='My account']")
	WebElement myAccount;
	
	@FindBy(xpath="//span[normalize-space()='Register']")
	WebElement registerlink;
	
	@FindBy(xpath="//span[normalize-space()='Login']")
	WebElement loginLink;
	
	@FindBy(xpath="//div[@id='entry_217822']//input[@placeholder='Search For Products']")
	WebElement txtSearchBar;
	
	@FindBy(xpath="//button[normalize-space()='Search']")
	WebElement btnSearch;
	
	
	
	Actions action= new Actions(driver);
	
	public void clickOnMyAccount() {
		action.moveToElement(myAccount).perform();
	}
	
	public void clickOnRegisterLink() {
		action.moveToElement(registerlink).click().perform();
	}
	
	public void clickOnLoginLink() {
		action.moveToElement(loginLink).click().perform();
	}
	
	public void enterProductToBeSearch(String pName) {
		txtSearchBar.sendKeys(pName);
	}
	
	public void clickSearchButton() {
		btnSearch.click();
	}
	
	
	
}
