package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmOrderPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductDetailsPage;
import pageObjects.ProductListPage;
import testBase.BaseClass;

public class TC006_LoggedInUserOrderFlowTest extends BaseClass{
	
	@Test(groups={"Regression","Master"})
	public void verifyLoggedInUserOrderFlow() {
		try {
			logger.info("--------- Entered into verifyLoggedInUserOderFlow ----------");
			
			HomePage homepage=new HomePage(driver);
			homepage.clickOnMyAccount();
			homepage.clickOnLoginLink();
			
			LoginPage loginPage= new LoginPage(driver);
			loginPage.enterEmail(p.getProperty("email"));
			loginPage.enterPassword(p.getProperty("pwd"));
			loginPage.clickLoginbtn();
			
			homepage.enterProductToBeSearch(p.getProperty("searchProduct"));
			homepage.clickSearchButton();
			
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
			logger.info("----------- Entered into cart page ---------");
			CartPage cp= new CartPage(driver);
			cp.clickCheckoutBtn();
			
			logger.info("----------- Entered into checkout page ---------");
			CheckoutPage chpage= new CheckoutPage(driver);
			chpage.selectUseExistingAddress();
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
		logger.info("----------- Finished TC006_LoggedInUserOrderFlowTest ---------");
	}

}
