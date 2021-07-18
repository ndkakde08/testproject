package iNautix_Technologies_pune;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestClass {

//	public static void main(String[] args) throws InterruptedException {
//		// TODO Auto-generated method stub
	
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
//			System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
//			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://groww.in/");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			wait= new WebDriverWait(driver,20);
			soft = new SoftAssert();
       }
		
       @BeforeMethod
       public void Login() {
    	   	loginPage= new LoginPage(driver);
    	    loginPage.clickonloginpage();
    	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login_email1']")));
			loginPage.sendEmail1("ndkakde08@gmail.com");
			loginPage.clickoncontinue1();
			loginPage.sendPassword("Pass@123");
			loginPage.clickonsubmit();
			loginPage.insertpin("0578");
       }
       
       @Test(priority=1)
       public void validateBankNifty () {
    	   	homePage= new HomePage(driver);
	   		homePage.clickNifty(); 
	   		String url="https://groww.in/indices/nifty";
			String url1 = driver.getCurrentUrl();
			soft.assertEquals(url, url1, "not Enter on Nifty");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='NIFTY 50']")));
			String title = driver.getTitle();
			System.out.println(title);
			soft.assertEquals(title, "LIVE NIFTY 50 Indices | NIFTY 50 Share/Stock Price Today - Groww","NIFTY 50 not Appear");
			soft.assertAll();
       }  
       @Test(priority=2)
       public void validateSensex () throws Throwable {
    	    homePage= new HomePage(driver);
    	    Thread.sleep(5000);
	   		homePage.clickSensex(); 
	   		String url="https://groww.in/indices/sp-bse-sensex";
			String url1 = driver.getCurrentUrl();
			soft.assertEquals(url, url1, "not Enter on SENSEX");
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='SENSEX']")));
			String title = driver.getTitle();
			System.out.println(title);
			soft.assertEquals(title, "LIVE SENSEX Indices | SENSEX Share/Stock Price Today - Groww","SENSEX not Appear");
			soft.assertAll();
       }  
       @Test(priority=3)
       public void Search() throws Throwable {
    	   homePage= new HomePage(driver);
    	   homePage.sendsearch("Sbi");
           String text= homePage.validateBuyButton();
    	   System.out.println(text);
    	   soft.assertEquals(text, "BUY","BUY button text not Appear");
    	   String url= driver.getCurrentUrl();
    	   System.out.println(url);
    	   soft.assertEquals(url, "https://groww.in/stocks/state-bank-of-india");
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


