package iNautix_Technologies_pune;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut {
	WebDriver driver;
	@FindBy (xpath ="//i[@class='material-icons downArrow']")
	private WebElement account;
	@FindBy (xpath="(//div[@class='settingItem valign-wrapper'])[4]")
	private WebElement logout;
	
	public  LogOut(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);	
	}
	public void clickOnLogOut() {
		account.click();
		logout.click();
	}
	
	
}
