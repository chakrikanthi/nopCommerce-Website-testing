package nopCommerce;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
//testing---Only registered customers can use email a friend feature
public class NotebooksSortingtable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/notebooks");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement computertab=driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']"));
		WebElement Notebooks=driver.findElement(By.xpath("//ul[1]//li[1]//ul[1]//li[2]//a[1]"));  
		Actions act= new Actions(driver);
		act.moveToElement(computertab).click(Notebooks).perform();
		WebElement positions=driver.findElement(By.xpath("//select[@id='products-orderby']"));
		
		Select positionlist= new Select(positions);
		positionlist.selectByValue("5");
		WebElement display=driver.findElement(By.xpath("//select[@id='products-pagesize']"));
		Select displaysize= new Select(display);
		displaysize.selectByValue("3");
		Thread.sleep(1500);
		WebElement wishlistbtn=driver.findElement(By.xpath("//button[@class='button-2 add-to-wishlist-button']"));
		wishlistbtn.click();
		Thread.sleep(1500);
		WebElement Emailafrnd=driver.findElement(By.xpath("//button[@class='button-2 email-a-friend-button']"));
		Emailafrnd.click();
		
		String str=RandomStringUtils.randomAlphabetic(10);
		WebElement friendsemail=driver.findElement(By.xpath("//input[@class='friend-email']"));
		friendsemail.sendKeys("kanthisri@gmail.com");
		WebElement yourmail=driver.findElement(By.xpath("//input[@class='your-email']"));
		yourmail.sendKeys("kanthi@gmail.com");
		WebElement personalmsg=driver.findElement(By.xpath("//textarea[@id='PersonalMessage']"));
		personalmsg.sendKeys(str);
		
		WebElement sendEmail=driver.findElement(By.xpath("//button[@name='send-email']"));
		sendEmail.click();
		WebElement Errormsg=driver.findElement(By.xpath("//li[text()='Only registered customers can use email a friend feature']"));
		String msg=Errormsg.getText();
		System.out.println(msg);
		
	}

}
//output:Only registered customers can use email a friend feature
	