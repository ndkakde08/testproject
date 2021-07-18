package iNautix_Technologies_pune;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
		WebDriver driver;
	// div[text()='NIFTY']
	@FindBy (xpath ="(//div[@class='left-align ic23RightDiv'])[1]" )
	private WebElement nifty;
	@FindBy(xpath="(//div[@class='valign-wrapper'])[7]")
	private WebElement sensex;
	@FindBy(xpath=" //input[@id='mainSearch1010']")
	private WebElement search;
	@FindBy (xpath="(//div[@class='truncate clrSubText'])[1]")    //div[@id='suggestionssuzlon-energy-ltd']
	private WebElement selectstock;
	@FindBy (xpath="//span[text()='Limit']")
	private WebElement limitButton;
	@FindBy (xpath="//span[@class='absolute-center']")
	private WebElement buyButton;
//	@FindBy (xpath="//span[@class='absolute-center']")
//	private WebElement buyButton;
//	@FindBy (xpath="//span[@class='absolute-center']")
//	private WebElement buyButton;
//	@FindBy (xpath="//span[@class='absolute-center']")
//	private WebElement buyButton;
//	@FindBy (xpath="//span[@class='absolute-center']")
//	private WebElement buyButton;
//	@FindBy (xpath="//span[@class='absolute-center']")
//	private WebElement buyButton;
	public HomePage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	public void clickNifty () 
	{
		nifty.click();
		
	}
	public void clickSensex () 
	{
		sensex.click();
		
	}
	public void  sendsearch(String searchtext) throws Throwable {
		Thread.sleep(5000);
		search.click();
		search.sendKeys(searchtext);
		selectstock.click();
//		limitButton.click();
	}
	public String validateBuyButton() {
		String text = buyButton.getText();
		return text;
	}
}
	

