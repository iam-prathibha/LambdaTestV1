package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductListPage extends BasePage {
	 
	public ProductListPage(WebDriver driver) {
		super(driver);
	}
	
	
	
	@FindBy(xpath="//a[normalize-space()='iPod Classic']")
	List<WebElement> listOfSearchProduct;
	
	@FindBy(xpath="//h1[normalize-space()='iPod Classic']")
	WebElement productTitle;
	
	
	
	public void selectTheSearchedProduct() {
		WebElement product=listOfSearchProduct.get(0);
		product.click();
		
	}
	
	public String getProductDetails() {
		try{
			return (productTitle.getText());
		}catch(Exception e) {
			return (e.getMessage());
		}
	}
	
}
