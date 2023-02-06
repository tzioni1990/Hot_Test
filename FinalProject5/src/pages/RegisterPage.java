package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage{
	
	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean getRegister(String city, String street, String building, String house, String pNumber) throws InterruptedException {
		getClick(By.xpath("//span[@data-select2-id='27']/span/span/span"));
		fillText(By.xpath("//input[@type='search']"), city);
		fillText(By.xpath("//input[@type='search']"), "Keys.ENTER");
		getClick(By.xpath("//span[@data-select2-id='30']/span/span/span"));
		fillText(By.xpath("//input[@type='search']"), street);
		fillText(By.xpath("//input[@type='search']"), "Keys.ENTER");
		getClick(By.xpath("//span[@data-select2-id='33']/span/span/span"));
		fillText(By.xpath("//input[@type='search']"), building);
		fillText(By.xpath("//input[@type='search']"), "Keys.ENTER");
		getClick(By.xpath("//span[@data-select2-id='39']/span/span/span"));
		fillText(By.xpath("//input[@type='search']"), house);
		fillText(By.xpath("//input[@type='search']"), "Keys.ENTER");
		getClick(By.xpath("//input[@id='checkPhone83']"));
		fillText(By.xpath("//input[@id='checkPhone83']"), pNumber);
		getClick(By.xpath("//div[@data-select2-id='57']//label[2]/span"));
		Thread.sleep(3000);
		if(driver.findElement(By.xpath("//span[@data-select2-id='36']")).isDisplayed())
			return true;
		else
			return false;
	}

}
