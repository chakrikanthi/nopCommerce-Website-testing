package nopCommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Searchingprdctandcheckout {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js=  (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('small-searchterms').style.border= '5px red solid';");
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Desktops");
		Thread.sleep(1000);
		js.executeScript("document.getElementsByClassName('button-1 search-box-button')[0].style.border='5px blue solid';");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@id='main']//div//div//div//div//div//div//div//div//div//div//div//div//a[contains(text(),'Lenovo IdeaCentre 600 All-in-One PC')]")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-button-3']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='shopping cart']")).click();
		driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
		driver.findElement(By.xpath("//button[@id='checkout']")).click();

	}

}
