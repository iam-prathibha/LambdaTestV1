package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;
import pageObjects.ProductListPage;
import testBase.BaseClass;

public class  TC004_AddtoCartTest extends BaseClass{
	
	
	@Test(groups={"Sanity","Master"})
	public void verifyAddtoCartTest() {
		try {
				logger.info("---------- Started verifying AddtoCart product Test--------");
				
				HomePage hp= new HomePage(driver);
				hp.enterProductToBeSearch(p.getProperty("searchProduct"));
				hp.clickSearchButton();
				
				ProductListPage plpPage= new ProductListPage(driver);		
				Thread.sleep(2000);
				plpPage.selectTheSearchedProduct();
				Thread.sleep(2000);
				logger.info("------- Entered into product details page --------");
				
				ProductDetailsPage pdpPage= new ProductDetailsPage(driver);
				pdpPage.clickAddtoCartbtn();
				Thread.sleep(3000);
				pdpPage.clickOnViewCartbtn();
				Thread.sleep(3000);
				CartPage cp= new CartPage(driver);
				String heading=(cp.getCartPageHeading()).split("\\(")[0].trim();
				if(heading.equals("Shopping Cart")) {
					Assert.assertEquals(cp.getProductName(), p.getProperty("searchProduct"));
				}
				else {
					Assert.fail();
				}
				
			
			}catch(Exception e) {
				logger.error("--------- TestCase Failed --------");
				logger.debug("----- Debug Logs");
				Assert.fail();
			}
		
			logger.info("------- Finished TC004_AddtoCartTest ---------");
	}

}
