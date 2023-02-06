package test;

import org.testng.annotations.Test;

import dp.Data;
import pages.HomePage;
import pages.RegisterPage;
import utility.Utility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestPageObject {
	WebDriver driver;
	HomePage hp;
	RegisterPage rp;
	String baseURL;
	private static final Logger log=LogManager.getLogger(TestPageObject.class.getName());

	@BeforeClass
	public void beforeClass() throws IOException {
		log.info("Before Class");
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		System.setProperty("chrome.webdriver.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		System.setProperty("file.encoding", "UTF-8");
		baseURL=Utility.getURL("url");
	}

	@BeforeMethod
	public void beforeMethod() {
		log.info("Before Method");
		hp=new HomePage(driver);
		rp=new RegisterPage(driver);
		driver.get(baseURL);
	}

	@Test(dataProvider = "dataFromExcel", dataProviderClass = Data.class)
	public void test1(String city, String street, String building, String house, String pNumber) {
		log.info("Test");
		try {
			Assert.assertTrue(hp.getHomePage());
			Assert.assertTrue(rp.getRegister(city, street, building, house, pNumber));
			Utility.addSnapShotToReport(Utility.getPrintScreen(driver));
		}
		
		catch(Exception e) {
			log.error("The test failed for exception");
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		log.info("After Method");
		Thread.sleep(10000);
	}

	@AfterClass
	public void afterClass() {
		log.info("After Class");
		driver.quit();
	}

}
