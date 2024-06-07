package nopCommerce;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CurrencyTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/notebooks");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement currency=driver.findElement(By.xpath("//select[@id='customerCurrency']"));
		Select currencylist=new Select(currency);
		List<WebElement> currencylist1=currencylist.getOptions();
		System.out.println("Total number of options:"+currencylist1.size());
		for (WebElement webElement : currencylist1) {
			System.out.println(webElement.getText());
			
		}
		
		currencylist.selectByVisibleText("Euro");  
		WebElement computertab=driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']"));
		WebElement desktops=driver.findElement(By.xpath("//ul[1]//li[1]//ul[1]//li[1]//a[1]"));  
		Actions act= new Actions(driver);
		act.moveToElement(computertab).click(desktops).perform();
		
		WebElement europrice=driver.findElement(By.xpath("//span[contains(text(),'€430.00')]"));
		String LenovoEUROprice=europrice.getText();
		System.out.println("Price in Euros:"+LenovoEUROprice);
		Thread.sleep(2000);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("document.getElementsByName('customerCurrency')[0].style.border='5px red solid'");
		driver.findElement(By.xpath("//div[@class='currency-selector']")).click();
		driver.findElement(By.xpath("//div[@class='currency-selector']//select//option[1]")).click();
		WebElement  price=driver.findElement(By.xpath("//span[normalize-space()='$500.00']"));
		String LenovoUSprice=price.getText();
		System.out.println("Price in US Dollars:"+LenovoUSprice);
		
		
	
		
	}

}
