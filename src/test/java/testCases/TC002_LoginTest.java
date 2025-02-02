package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups= {"Regression","Master"})
	public void verifyLoginTest() {
		try {
		    logger.info("----------Started verifying login test--------");
			HomePage homepage=new HomePage(driver);
			homepage.clickOnMyAccount();
			homepage.clickOnLoginLink();
			
			LoginPage loginPage= new LoginPage(driver);
			loginPage.enterEmail(p.getProperty("email"));
			loginPage.enterPassword(p.getProperty("pwd"));
			loginPage.clickLoginbtn();
			logger.info("-------Started comparing the text upon successfull login-------");
			String compareText=loginPage.getStringToCompareLoginSuccessfull();
			
			Assert.assertEquals(compareText, "My Account");
		}catch(Exception e) {
			logger.error("-------Test Failed------");
			logger.debug("Debug Logs ------ ");
			Assert.fail();
		}
		
		logger.info("-------- Finished TC002_LoginTest -----------");
	}
}
