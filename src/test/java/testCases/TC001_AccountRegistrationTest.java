package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	@Test(groups={"Sanity","Master"})
	public void verifyAccountRegistrationTest() {
		try {
		logger.info("----Started verifying account registration test -----");
		
		HomePage homePage=new HomePage(driver);
		
		homePage.clickOnMyAccount();
		homePage.clickOnRegisterLink();
		logger.info("------ Started entering the values in registration form ------");
		AccountRegisterPage accountRegisterPage= new AccountRegisterPage(driver);
		accountRegisterPage.setFirstName(randomString().toUpperCase());
		accountRegisterPage.setLastName(randomString().toUpperCase());
		accountRegisterPage.setEmail(randomString().toUpperCase()+"@gmail.com");
		accountRegisterPage.setPhoneNumber(randomNumeric());
		String pwd= randomAlphaNumeric();
		accountRegisterPage.setPassword(pwd);
		accountRegisterPage.setConfirmPassword(pwd);
		accountRegisterPage.clickPrivacyPolicy();
		accountRegisterPage.clickContinueBtn();
		logger.info("---- Started comparing the success msg after creating the account------");
		String successMsg= accountRegisterPage.getConfirmationMsg();
		Assert.assertEquals(successMsg, "Your Account Has Been Created!");
		}catch(Exception e) {
			logger.error("-------Test Failed------");
			logger.debug("Debug Logs ------ ");
			Assert.fail();
		}
		
		logger.info("------ Finised TC001_AccountRegistrationTest --------");
		
	}
	
	
}
