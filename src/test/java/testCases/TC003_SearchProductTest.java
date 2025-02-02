package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductListPage;
import testBase.BaseClass;

public class TC003_SearchProductTest extends BaseClass{

	
	//Tn this class fetching the products with name and clicking on first product
	
	
	@Test(groups={"Regression","Master"})
	public void verifySearchProductTest() {
		try {
		logger.info("---------- Started verifying search product Test--------");
		
		HomePage hp= new HomePage(driver);
		hp.enterProductToBeSearch(p.getProperty("searchProduct"));
		hp.clickSearchButton();
		
		ProductListPage plpPage= new ProductListPage(driver);		
		Thread.sleep(2000);
		plpPage.selectTheSearchedProduct();
		Thread.sleep(2000);
		logger.info("------- Entered into product details page --------");
		Assert.assertEquals(p.getProperty("searchProduct"),plpPage.getProductDetails());
		
		}catch(Exception e) {
			logger.error("--------- TestCase Failed --------");
			logger.debug("----- Debug Logs");
			Assert.fail();
		}
		
		logger.info("------- Finished TC003_SearchProductTest -----------");
	}
	
}
