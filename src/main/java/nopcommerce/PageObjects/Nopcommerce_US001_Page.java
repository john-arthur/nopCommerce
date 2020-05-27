package nopcommerce.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Nopcommerce_US001_Page {

	@FindBy(xpath="//input[@name='Email']")
	public static WebElement email_field;
	
	@FindBy(xpath="//input[@name='Password']")
	public static WebElement password_field;
	
	@FindBy(xpath="//input[@name='Password']/following::input[2]")
	public static WebElement login_button;
	
	@FindBy(xpath="//*[contains(text(),'Please enter your email')]")
	public static WebElement email_error_message;
	
	@FindBy(xpath="//*[contains(text(),'Wrong email')]")
	public static WebElement email_error_message_2;
	
	@FindBy(xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[1]")
	public static WebElement login_error;
	
	@FindBy(xpath="//h1[contains(text(),'Dashboard')]")
	public static WebElement dashboard;
	
}
