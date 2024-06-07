package nopCommerce;


import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
public class NopcommerceAddingproductncheckout {

	public static void main(String[] args) throws InterruptedException {
		
		//Adding product to cart and checking out 
		
				
//		        ChromeOptions options= new ChromeOptions();
//		        options.addArguments("--disable-notifications");
//				WebDriver driver= new ChromeDriver(options);---this is not working
				
				ChromeOptions options = new ChromeOptions();
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("autofill.profile_enabled", false);
				options.setExperimentalOption("prefs", prefs);

				WebDriver driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get("https://demo.nopcommerce.com/");
				//WebElement title=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
				System.out.println(driver.getTitle());
				driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//li[6]//a[normalize-space()='Jewelry'][1][1]")).click();
				driver.findElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[3]/div[2]/button[1]")).click();
				WebElement statusmsg=driver.findElement(By.xpath("//p[@class='content']"));
				System.out.println(statusmsg);
				Boolean status= statusmsg.isDisplayed();
				System.out.println(status);
				driver.findElement(By.xpath(" //span[@title='Close']")).click();
				Thread.sleep(2500);
				//driver.wait(3000);
				driver.findElement(By.xpath("//span[@class='cart-label']")).click();
				WebElement quantitybox=driver.findElement(By.xpath("//input[@class='qty-input']"));
				quantitybox.clear();
				quantitybox.sendKeys("2");
				WebElement Updatecartbtn=driver.findElement(By.xpath("//button[@class='button-2 update-cart-button']"));
				Updatecartbtn.click();
				Thread.sleep(2000);
				WebElement termsofservice=driver.findElement(By.xpath("//input[@id='termsofservice']"));
				termsofservice.click();
				WebElement Checkoutbtn=driver.findElement(By.xpath("//button[@id='checkout']"));
				Checkoutbtn.click();
				WebElement CheckoutasGuest=driver.findElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));
				CheckoutasGuest.click();
				String str=RandomStringUtils.randomAlphabetic(5);
				String num=RandomStringUtils.randomNumeric(5);
				String phnum=RandomStringUtils.randomNumeric(10);
				WebElement Firstname= driver.findElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"));
				Firstname.sendKeys(str);

				WebElement Lastname= driver.findElement(By.xpath("//input[@id='BillingNewAddress_LastName']"));
				Lastname.sendKeys(str);
				WebElement Email= driver.findElement(By.xpath("//input[@id='BillingNewAddress_Email']"));
				Email.sendKeys(str+"@gmail.com");
				WebElement Company= driver.findElement(By.xpath("//input[@id='BillingNewAddress_Company']"));
				Company.sendKeys(str);
				WebElement country=driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
				
				Select countryname= new Select(country);
				
				List<WebElement> countrylist=countryname.getOptions();
				
				for (WebElement countrylists : countrylist) {
					System.out.println(countrylists.getText());
					
				}
				countryname.selectByValue("1");
				WebElement State= driver.findElement(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"));
				
				Select statelist= new Select(State);
				List<WebElement> states=statelist.getOptions() ;
				
				for (WebElement webElement : states) {
				System.out.println(webElement.getText());
					
				}
				statelist.selectByValue("40");
				WebElement city= driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']"));
				city.sendKeys("Dekalb");
				WebElement Address1= driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']"));
				Address1.sendKeys(num+str+ "street");
				WebElement Address2= driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address2']"));
				Address2.sendKeys(num);
				
				WebElement Zipcode= driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"));
				Zipcode.sendKeys(num);
				WebElement Phonenumber= driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"));
				Phonenumber.sendKeys(phnum);
				WebElement Faxnumber= driver.findElement(By.xpath("//input[@id='BillingNewAddress_FaxNumber']"));
				Faxnumber.sendKeys(phnum);
				driver.findElement(By.xpath("//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; Billing.save()']")).click();
//				WebUI.delay(3);
//				WebUI.executeJavaScript('window.open();', []);
//				mainWindow = WebUI.getWindowIndex()
//				WebUI.closeWindowIndex(mainWindow + 1)
//				WebUI.switchToWindowIndex(mainWindow)
			    
			    driver.findElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']")).click();
			    Thread.sleep(2000);
			    driver.findElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']")).click();
			    Thread.sleep(2000);
			    driver.findElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']")).click();
			    Thread.sleep(1200);
			    driver.findElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']")).click();
			    WebElement thankmsg=driver.findElement(By.xpath("//h1[text()='Thank you']"));
			    System.out.println(thankmsg.getText()); //output:Thank you
			    WebElement sucessmsg= driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
			    System.out.println(sucessmsg.getText()); //output:Your order has been successfully processed!
			    boolean msgdisp=sucessmsg.isDisplayed();
			    Assert.assertTrue(msgdisp);
			    System.out.println(msgdisp);
			    WebElement ordernum=driver.findElement(By.xpath("//div[@class='order-number']"));
			    System.out.println(ordernum.getAttribute("class")); //output:order-number
			   System.out.println( ordernum.getTagName()); //output: div
			   System.out.println( ordernum.getText()); //output:ORDER NUMBER: 1031
			    Thread.sleep(3000);
			    driver.findElement(By.xpath("//a[text()='Click here for order details.']")).click();
			    
			    driver.findElement(By.xpath("//a[@class='button-2 print-order-button']")).click();
				driver.quit();
			}

		


	}


