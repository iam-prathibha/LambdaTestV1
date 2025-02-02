package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmOrderPage;
import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;
import pageObjects.ProductListPage;
import testBase.BaseClass;

public class TC007_GuestUserOrderFlowTest extends BaseClass{

	@Test(groups={"Regression","Master"})
	public void verfyingCheckoutTest() {
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
			cp.clickCheckoutBtn();
			CheckoutPage chpage= new CheckoutPage(driver);
			
			logger.info("------------ Entered into checkout page ------------");
			chpage.selectGuestCheckout();
			chpage.setFirstName(randomString());
			chpage.setLastName(randomString());
			chpage.setEmail(randomAlphaNumeric());
			chpage.setPhoneNumber(randomNumeric());
			
			String[] address1= generateRandomAddress().split(",");
			
			chpage.setAddress1(address1[0]);
			chpage.setCity(address1[1]);
			chpage.setPostalCode(address1[2]);
			
			chpage.setCountry("Canada");
			chpage.setState("Nova Scotia");
			chpage.clickTermsandConditions();
			chpage.clickContinueBtn();
			Thread.sleep(2000);
			ConfirmOrderPage cop=new ConfirmOrderPage(driver);
			logger.info("----------- Entered into checkout page ---------");
			cop.clickConfirmOrder();
			
			Assert.assertEquals(cop.getSuccessText(),"Your order has been placed!");
			
		}catch(Exception e) {
			logger.error("--------- TestCase Failed --------");
			logger.debug("----- Debug Logs");
			Assert.fail();
		}
		
		logger.info("---------- Finished TC005_CheckoutTest ---------");
	}
}
