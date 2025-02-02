package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setUp(String os, String br) throws IOException {
		FileReader file= new FileReader(".//src/test/resources/config.properties");
		p=new Properties ();		
		p.load(file);
		logger=LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")){
			logger.info("----------- Entered into remote env if condition -------");
			DesiredCapabilities capabilities= new DesiredCapabilities();
			//Platform
			if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux")) {
				capabilities.setPlatform(Platform.LINUX);
			}
			else {
				System.out.println("No matching os");
				return;
			}
			//Browser
			switch(br.toLowerCase()) {
			case "chrome":capabilities.setBrowserName("chrome"); break;
			case "safari": capabilities.setBrowserName("safari"); break;
			case "firefox": capabilities.setBrowserName("firefox"); break;
			default : System.out.println("No matching Browser"); return;
			}
			
			driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			logger.info("----------- Entered into local env if condition -------");
			
			switch(br.toLowerCase()) {
			case "chrome":driver = new ChromeDriver(); break;
			case "safari": driver= new SafariDriver(); break;
			case "firefox": driver= new FirefoxDriver(); break;
			default : System.out.println("Default Browser"); return;
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
		logger.info("---------- started browsing the application-------");
		driver.manage().window().maximize();
	
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown() {
		driver.quit();
	}
	
	public String randomString() {
		String txt_GeneratedString=RandomStringUtils.randomAlphabetic(5);
		return txt_GeneratedString;
	}
	
	public String randomNumeric() {
		String txt_GeneratedNumeric=RandomStringUtils.randomNumeric(5);
		return txt_GeneratedNumeric;
	}
	
	public String randomAlphaNumeric() {
		String txt_GeneratedString=RandomStringUtils.randomAlphabetic(3);
		String txt_GeneratedNumeric=RandomStringUtils.randomNumeric(3);
		String txt_GeneratedAlphaNumeric=txt_GeneratedString+txt_GeneratedNumeric+"@gmail.com";
		return txt_GeneratedAlphaNumeric;
	}
	
	public String captureScreen(String name) {
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		System.out.println(name);
		TakesScreenshot takeScreenShot= (TakesScreenshot) driver;
		File sourceFile= takeScreenShot.getScreenshotAs(OutputType.FILE);
		System.out.println("********** Took SS **********");
		String targetFilePath= System.getProperty("user.dir")+"/screenShots/"+name+"_"+timeStamp+".png";
		
		File tagetFile= new File(targetFilePath);
		System.out.println("************ created ss in target file path*********8");
		sourceFile.renameTo(tagetFile);
		System.out.println(targetFilePath);
		return targetFilePath;
	}
	
	    public  String generateRandomAddress() {
	    		String[] STREET_NAMES = {
	    		        "Main St", "High St", "Park Ave", "Maple St", "Oak St", "2nd Ave", "Elm St", "Pine St", "Cedar Ave"
	    	    };
	    	    
	    		String[] CITIES = {
	    		        "New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "San Francisco", "Seattle", "Miami", "Denver", "Boston"
	    	    };
	    	    
	    		String[] STATES = {
	    		        "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
	    		        "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
	    		        "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire",
	    		        "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
	    		        "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington",
	    		        "West Virginia", "Wisconsin", "Wyoming"
	    		    };
	    	    
	    		String[] COUNTRIES = {
	    		        "USA", "Canada", "UK", "Germany", "France", "India", "Australia", "Japan", "Brazil", "Mexico"
	    	    };

	    		Random RANDOM = new Random();

		        int streetNumber = RANDOM.nextInt(9999) + 1;  // Random street number
		        String street = STREET_NAMES[RANDOM.nextInt(STREET_NAMES.length)];
		        String city = CITIES[RANDOM.nextInt(CITIES.length)];
		        String state = STATES[RANDOM.nextInt(STATES.length)];
		        String zipCode = String.format("%05d", RANDOM.nextInt(99999)); // 5-digit ZIP
		        String country = COUNTRIES[RANDOM.nextInt(COUNTRIES.length)];
	
		        return streetNumber + " " + street + ", " + city + ", " + zipCode + "," + country + ", " + state;
	    }
}
