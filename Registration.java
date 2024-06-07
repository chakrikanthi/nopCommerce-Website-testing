package nopCommerce;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Registration {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		WebElement Femaleradiobtn=driver.findElement(By.xpath("//input[@id='gender-female']"));
		Femaleradiobtn.click();
		
		//WebElement Maleradiobtn=driver.findElement(By.xpath("//input[@id='gender-male']"));
		String str=RandomStringUtils.randomAlphabetic(6);
		String num=RandomStringUtils.randomNumeric(1);
		String num1=RandomStringUtils.randomNumeric(1);
		//String num2=RandomStringUtils.randomNumeric(4);
		WebElement Firstname=driver.findElement(By.xpath("//input[@id='FirstName']"));
		Firstname.sendKeys(str);
		
		WebElement Lastname=driver.findElement(By.xpath("//input[@id='LastName']"));
		Lastname.sendKeys(str);
		
		WebElement day=driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
		Select dayfield= new Select(day);
		dayfield.selectByValue(num);
		
		WebElement month= driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
		Select monthfield= new Select(month);
		monthfield.selectByValue(num1);
		
		WebElement year= driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
		Select yearfield= new Select(year);
		yearfield.selectByValue("1982");
		
		WebElement Email=driver.findElement(By.xpath("//input[@id='Email']"));
		Email.sendKeys(str+"@gmail.com");
		
		//WebElement company=driver.findElement(By.xpath("//input[@id='Company']"));
		Email.sendKeys(str);
		
		String passwordstrg= RandomStringUtils.randomAlphanumeric(8);
		Thread.sleep(2000);
		
		WebElement password= driver.findElement(By.xpath("//input[@id='Password']"));
		password.sendKeys(passwordstrg);
		
		WebElement confirmpassword= driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
		confirmpassword.sendKeys(passwordstrg);
		
		WebElement Registerbtn= driver.findElement(By.xpath("//button[@id='register-button']"));
		Registerbtn.click();
		
		WebElement successmsg=driver.findElement(By.xpath("//div[@class='result']"));
		String finalsucmsg=successmsg.getText();
		System.out.println(finalsucmsg);
		Assert.assertEquals("Your registration completed",finalsucmsg);
	}

}
