package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC008_LoginDataDrivenTest extends BaseClass{
	

	@Test(dataProvider="LoginTestData", dataProviderClass= DataProviders.class,groups="Master")
	public void verifyLoginDDT(String email, String pwd, String status) throws InterruptedException {
		
		
		
		try {
			logger.info("----------Started verifying login test--------");
			//Home Page
			HomePage homepage=new HomePage(driver);
			logger.info("----------Moving to myaccount link --------");
			homepage.clickOnMyAccount();
			logger.info("----------Moving to login link --------");
			homepage.clickOnLoginLink();
			
			LoginPage loginPage= new LoginPage(driver);
			loginPage.enterEmail(email);
			loginPage.enterPassword(pwd);
			loginPage.clickLoginbtn();
			Thread.sleep(2000);
			String compareText=loginPage.getStringToCompareLoginSuccessfull();
			
			Boolean targetPage=compareText.equals("My Account");
			
			MyAccountPage accountPage=new MyAccountPage(driver);
			/* Valid
			 * login success - MyAccountTestPass -Pass
			 * 				 - MyAccountTestFail -Fail
			 * 
			 * InValid
			 * login Fail - MyAccountTestPass- Fail
			 * 			  - MyAccountTestFail- Pass	
			 */
			if(status.equalsIgnoreCase("Valid")) {
				if(targetPage) {
					logger.info("--------- Entered Valid if condition ------");
					accountPage.clickOnMyAccount();
					accountPage.clickLogoutLink();
					Assert.assertTrue(true);
				}else {
					Assert.assertTrue(false);
				}
			}
			
			if(status.equalsIgnoreCase("Invalid")) {
				if(targetPage) {
					accountPage.clickOnMyAccount();
					accountPage.clickLogoutLink();
					Assert.assertTrue(false);
				}else {
					
					Assert.assertTrue(true);
				}
			}
			
			
		
		}catch(Exception e) {
			logger.error("-------Test Failed------");
			logger.debug("Debug Logs ------ ");
			Assert.fail();
		}
		
		logger.info("-------- Finished TC008_LoginDataDrivenTest -----------");
	}
}
