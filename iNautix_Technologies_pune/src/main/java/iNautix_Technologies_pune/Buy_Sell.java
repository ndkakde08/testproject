package iNautix_Technologies_pune;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Buy_Sell {
	
	WebDriver driver;
	
	@FindBy (xpath="//span[text()='Delivery']")
	private WebElement delivery;
	@FindBy (xpath="//input[@id='inputShare']")   //input[@class='qtyinputbox
	private WebElement quantity;
	@FindBy (xpath="//span[text()='Limit']")
	private WebElement limitButton;
	@FindBy (xpath="//*[@id=\"buySellOrder\"]/div[2]/div[3]/input")  //(//input[@class='qtyinputbox '])[2]
	private WebElement limittextbox;
	@FindBy (xpath="//span[@class='absolute-center']")
	private WebElement buySellButton;
	@FindBy (xpath="//div[text()='SELL']")
	private WebElement sell;
	@FindBy (xpath="//div[text()='BUY']")
	private WebElement buy;
	public Buy_Sell(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public void clickonDelivery() {
		delivery.click();
	}
	public void enterStockQuantity(String qua) {
		quantity.sendKeys(qua);
	}
	public void enterLimitPrice(String lim) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='qtyinputbox '])[2]")));
//		Thread.sleep(5000);
		limittextbox.click();
		limittextbox.clear();
		limittextbox.sendKeys(lim);
	}
	public void clickonbuySellButton() {
		buySellButton.click();
	}
	public void clickonSellTrade() {
		sell.click();
	}
	public void clickonbuyTrade() {
		buy.click();
	}
	
	
}
