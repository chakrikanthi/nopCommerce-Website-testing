package nopCommerce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestingApparelsusingImages {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//img[@title='Show products in category Apparel']")).click();
		driver.findElement(By.xpath("//img[@title='Show products in category Clothing']")).click();
		
		driver.findElement(By.xpath("//div[@id='main']//div//div//div//div//div//div//div//div//div//div//div//img[@title='Show details for Custom T-Shirt']")).click();
		driver.findElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[9]/div[2]/button[1]")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//img[@title='Show details for Oversized Women T-Shirt']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Add to compare list']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='product comparison']")).click();
		WebElement customtshirt=driver.findElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/a[1]/img[1]"));
         boolean customtshirtdisplaystatus=customtshirt.isDisplayed();
         System.out.println("Custom tshirt is displayed:"+customtshirtdisplaystatus);
        String customtshirtprice=driver.findElement(By.xpath("//td[normalize-space()='$15.00']")).getText();
        System.out.println("Price of the Custom  shirt starts :"+customtshirtprice);
    	WebElement OversizedWomenTShirt=driver.findElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[3]/a[1]/img[1]"));
        boolean OversizedWomenTShirtdisplaystatus=OversizedWomenTShirt.isDisplayed();
        System.out.println("Oversized women  tshirt is displayed:"+OversizedWomenTShirtdisplaystatus);
       String oversizedtshirtprice=driver.findElement(By.xpath("//td[normalize-space()='From $16.00']")).getText();
       System.out.println("Price of the over sized shirt starts :"+oversizedtshirtprice);
       driver.quit();
         
	}

}
/*output:Custom tshirt is displayed:true
Price of the Custom  shirt starts :$15.00
Oversized women  tshirt is displayed:true
Price of the over sized shirt starts :From $16.00*/