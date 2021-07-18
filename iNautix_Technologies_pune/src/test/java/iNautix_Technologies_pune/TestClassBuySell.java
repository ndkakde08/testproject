package iNautix_Technologies_pune;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

    public class TestClassBuySell {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage ;
	LogOut logOut;
	WebDriverWait wait;
	SoftAssert soft;
	Buy_Sell buySell;

	@BeforeClass
    public void LauchBroweser() {
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://groww.in/");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			wait= new WebDriverWait(driver,20);
			soft = new SoftAssert();
    }
			
    @BeforeMethod
    public void Login()  {
 	   		loginPage= new LoginPage(driver);
 	   		loginPage.clickonloginpage();
			loginPage.sendEmail1("ndkakde08@gmail.com");
			loginPage.clickoncontinue1();
			loginPage.sendPassword("Pass@123");
			loginPage.clickonsubmit();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='otpinput88'])")));
			loginPage.insertpin("0578");
			
			
    }
    @Test(priority=1)
   	public void BuyTrade() throws Throwable {
       	    homePage = new HomePage(driver);
       	    homePage.sendsearch("Suzlon");
       	    buySell = new Buy_Sell(driver);
//   		buySell.clickonDelivery();
   			buySell.enterStockQuantity("110");
   			String qua = driver.findElement(By.xpath("//input[@id='inputShare']")).getText();
   			System.out.println("Quantity of Stock ="+qua);
   			soft.assertEquals(qua, "110");
   			buySell.enterLimitPrice("9.10");
//   			String lim = driver.findElement(By.xpath("//*[@id=\\\"buySellOrder\\\"]/div[2]/div[3]/input")).getText();
//   			String lim = 
//   			System.out.println("Limit price of Stock ="+lim);
   			soft.assertEquals(qua, "9.10");
   			String text = homePage.validateBuyButton();
   			soft.assertEquals(text, "ADD MONEY");
   			buySell.clickonbuySellButton();
   			soft.assertAll();
    }
   	@Test(priority=2)
   	public void SellTrade() throws Throwable {
   		homePage = new HomePage(driver);
   		homePage.sendsearch("Sbi");
   		buySell.clickonSellTrade();
   		buySell.enterStockQuantity("1000");
   		String qua = driver.findElement(By.xpath("//input[@id='inputShare']")).getText();
		System.out.println("Quantity of Stock ="+qua);
		soft.assertEquals(qua, "1000");
		buySell.enterLimitPrice("400");
		String lim = driver.findElement(By.xpath("//*[@id=\\\"buySellOrder\\\"]/div[2]/div[3]/input")).getText();
		System.out.println("Limit price of Stock ="+lim);
		soft.assertEquals(qua, "400");
		String text = homePage.validateBuyButton();
		soft.assertEquals(text, "ADD MONEY");
		buySell.clickonbuySellButton();
		soft.assertAll();
   		   		
   	}
			
	
	@AfterMethod()
	public void Logout() throws Throwable {  	   	    
		    Thread.sleep(5000);
			logOut= new LogOut(driver);
		    logOut.clickOnLogOut();
    }	       
	@AfterClass
	public void CloseBrower() {
				   
		    driver.close();
	}
  }

