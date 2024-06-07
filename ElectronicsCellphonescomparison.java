package nopCommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ElectronicsCellphonescomparison {
	//from Electronics tab->Cell phones-> order placed successfully
	public static void main(String[] args) throws InterruptedException   {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/notebooks");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement Electronicstab=driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"));
		WebElement Cellphones=driver.findElement(By.xpath("//body/div/div/ul[1]/li[2]/ul[1]/li[2]/a[1]"));  
		Actions act= new Actions(driver);
		act.moveToElement(Electronicstab).click(Cellphones).perform();
		WebElement htcphone=driver.findElement(By.xpath("//h2[@class='product-title']//a[text()='HTC One M8 Android L 5.0 Lollipop']"));
		htcphone.click();
		
		WebElement comparelistbtn=driver.findElement(By.xpath("//div[@class='compare-products']//button[@class='button-2 add-to-compare-list-button']"));
		comparelistbtn.click();
		
		WebElement successmsg=driver.findElement(By.xpath("//p[@class='content']"));
		System.out.println(successmsg.getText());
		WebElement  closebtn=driver.findElement(By.xpath("//span[@class='close']"));
		closebtn.click();
		driver.navigate().back();
		
		WebElement Nokiahone=driver.findElement(By.xpath("//a[text()='Nokia Lumia 1020']"));
		Nokiahone.click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//div[@class='compare-products']//button[@class='button-2 add-to-compare-list-button']")).click();
			
		WebElement prdctcompariosnbtn= driver.findElement(By.xpath("//a[text()='product comparison']"));
		prdctcompariosnbtn.click();
		WebElement compprdcttext=driver.findElement(By.xpath("//h1[text()='Compare products']"));
		System.out.println("Two  :"+compprdcttext.getText());
	}

}
