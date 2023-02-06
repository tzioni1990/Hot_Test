package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void fillText(By by, String text) {
		WebElement we=driver.findElement(by);
		we.clear();
		if(text!="Keys.ENTER")
			we.sendKeys(text);
		else
			we.sendKeys(Keys.ENTER);
	}
	
	public void getClick(By by) {
		wait.until(ExpectedConditions.elementToBeClickable(by));
		WebElement we=driver.findElement(by);
		we.click();
	}

}
