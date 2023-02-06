package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public boolean getHomePage() throws InterruptedException {
		fillText(By.xpath("//input[@name='q']"), "הוט");
		getClick(By.xpath("// div[@class='FPdoLc lJ9FBc']//input[@name='btnK']"));
		getClick(By.xpath("//a[@href='http://www.hot.net.il/heb/main/']/h3"));
		getClick(By.xpath("//div[text()='להצטרפות']"));
		getClick(By.xpath("//div[contains(@class,'Tered')]/div[2]//div[@class='ng-binding']"));
		Thread.sleep(3000);
		if(driver.findElement(By.xpath("//fiber-pop[@id='fiber_popChannels83']//h3[text()='בחירה מצוינת!']")).isDisplayed())
			return true;
		else
			return false;
	}

}
