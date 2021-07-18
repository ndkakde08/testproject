package iNautix_Technologies_pune;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy (xpath= "//span[text()='Login/Register']")
	private WebElement login;
//	@FindBy (xpath= "//div[text()='Continue with Google']")
//	private WebElement continuewithGoogle;
//	@FindBy (xpath= "//input[@id='identifierId']")
//	private WebElement email;
//	@FindBy (xpath = "(//span[@class='VfPpkd-vQzf8d'])[1]")
//	private WebElement next;
//	@FindBy (xpath = "//input[@name='password']")
//	private WebElement password;
//	@FindBy (xpath = "//span[text()='Next']")
//	private WebElement next1;
	
	@FindBy (xpath= "//input[@id='login_email1']")
	private WebElement login_email;
	@FindBy (xpath= "//span[text()='Continue']")
	private WebElement continue1;
	@FindBy (xpath= "//input[@id='login_password1']")
	private WebElement login_password;
	@FindBy (xpath= "//span[text()='Submit']")
	private WebElement submit;
	
	@FindBy (xpath="(//input[@class='otpinput88'])[1]")
	private List<WebElement> list;
	
	public LoginPage(WebDriver driver1) 
	{	PageFactory.initElements(driver1, this);}
	public void clickonloginpage() 
	{	login.click();}
//	public void clickoncontinuewithGoogle()
//	{	continuewithGoogle.click();}
//	public void sendEmail(String userEmail)
//	{	email.sendKeys(userEmail);}
//	public void clickonNextButton()
//	{	next.click();}
//	public void sendPassword(String userPassword)
//	{	password.sendKeys(userPassword);}
//	public void clickonnext1()
//	{	next1.click();}
	public void sendEmail1(String useremail)
	{	login_email.sendKeys(useremail);}
	public void clickoncontinue1 ()
	{	continue1.click();}
	public void sendPassword(String password1)
	{	login_password.sendKeys(password1);	}
	public void clickonsubmit()
	{	submit.click();}
	public void insertpin(String pin)
	{
	
		list.get(0).sendKeys(pin);
//		list.get(1).sendKeys(pin);
//		list.get(2).sendKeys(pin);
//		list.get(3).sendKeys(pin);
	}

		
	

	
}

