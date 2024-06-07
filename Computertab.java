package nopCommerce;

import java.time.Duration;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
//from computers tab->desktop-> order placed successfully
public class Computertab {

	public static void main(String[] args) throws InterruptedException {
		
//		ChromeOptions options = new ChromeOptions();
//		Map<String, Object> prefs = new HashMap<String, Object>();
//		prefs.put("profile.default_content_setting_values.notifications", 2);
//		prefs.put("autofill.profile_enabled", false);
//		options.setExperimentalOption("prefs", prefs);---try this code if you get any error like "save address automatically" pop up blocks you
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/notebooks");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement computertab=driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']"));
		WebElement desktops=driver.findElement(By.xpath("//ul[1]//li[1]//ul[1]//li[1]//a[1]"));  
		Actions act= new Actions(driver);
		act.moveToElement(computertab).click(desktops).perform();
		WebElement Lenovo=driver.findElement(By.xpath("//a[text()='Lenovo IdeaCentre 600 All-in-One PC']"));
		Lenovo.click();
		WebElement wishlist=driver.findElement(By.xpath("//button[@id='add-to-wishlist-button-3']"));
		wishlist.click();
		
		String successmsg=driver.findElement(By.xpath("//p[@class='content']")).getText();
		System.out.println(successmsg);
		Thread.sleep(3000);
		WebElement closetxt=driver.findElement(By.xpath("//span[@class='close']"));
		closetxt.click();
		WebElement Addtocart=driver.findElement(By.xpath("//button[@id='add-to-cart-button-3']"));
		Addtocart.click();WebElement Addtocartsucmsg=driver.findElement(By.xpath("//p[text()='The product has been added to your ']//a[text()='shopping cart']"));
		Thread.sleep(1500);
		System.out.println("Your product has been added successfully to:"+Addtocartsucmsg.getText());
		Thread.sleep(1500);
		driver.findElement(By.xpath("//span[@class='close']")).click();
		Thread.sleep(2000);
		WebElement Shoppingcart=driver.findElement(By.xpath("//span[@class='cart-qty']"));
		System.out.println(Shoppingcart.getText());
		Shoppingcart.click();
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
		Thread.sleep(1500);
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
//		WebUI.delay(3);
//		WebUI.executeJavaScript('window.open();', []);
//		mainWindow = WebUI.getWindowIndex()
//		WebUI.closeWindowIndex(mainWindow + 1)
//		WebUI.switchToWindowIndex(mainWindow)
	    
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

//output:The product has been added to your wishlist
//Your product has been added successfully to:shopping cart
//(1)
//Select country
//United States
//Afghanistan
//Albania
//Algeria
//American Samoa
//Andorra
//Angola
//Anguilla
//Antarctica
//Antigua and Barbuda
//Argentina
//Armenia
//Aruba
//Australia
//Austria
//Azerbaijan
//Bahamas
//Bahrain
//Bangladesh
//Barbados
//Belarus
//Belgium
//Belize
//Benin
//Bermuda
//Bhutan
//Bolivia
//Bosnia and Herzegowina
//Botswana
//Bouvet Island
//Brazil
//British Indian Ocean Territory
//Brunei Darussalam
//Bulgaria
//Burkina Faso
//Burundi
//Cambodia
//Cameroon
//Canada
//Cape Verde
//Cayman Islands
//Central African Republic
//Chad
//Chile
//China
//Christmas Island
//Cocos (Keeling) Islands
//Colombia
//Comoros
//Congo
//Congo (Democratic Republic of the)
//Cook Islands
//Costa Rica
//Cote D'Ivoire
//Croatia
//Cuba
//Cyprus
//Czech Republic
//Denmark
//Djibouti
//Dominica
//Dominican Republic
//East Timor
//Ecuador
//Egypt
//El Salvador
//Equatorial Guinea
//Eritrea
//Estonia
//Ethiopia
//Falkland Islands (Malvinas)
//Faroe Islands
//Fiji
//Finland
//France
//French Guiana
//French Polynesia
//French Southern Territories
//Gabon
//Gambia
//Georgia
//Germany
//Ghana
//Gibraltar
//Greece
//Greenland
//Grenada
//Guadeloupe
//Guam
//Guatemala
//Guinea
//Guinea-bissau
//Guyana
//Haiti
//Heard and Mc Donald Islands
//Honduras
//Hong Kong
//Hungary
//Iceland
//India
//Indonesia
//Iran (Islamic Republic of)
//Iraq
//Ireland
//Israel
//Italy
//Jamaica
//Japan
//Jordan
//Kazakhstan
//Kenya
//Kiribati
//Korea
//Korea, Democratic People's Republic of
//Kuwait
//Kyrgyzstan
//Lao People's Democratic Republic
//Latvia
//Lebanon
//Lesotho
//Liberia
//Libyan Arab Jamahiriya
//Liechtenstein
//Lithuania
//Luxembourg
//Macau
//Macedonia
//Madagascar
//Malawi
//Malaysia
//Maldives
//Mali
//Malta
//Marshall Islands
//Martinique
//Mauritania
//Mauritius
//Mayotte
//Mexico
//Micronesia
//Moldova
//Monaco
//Mongolia
//Montenegro
//Montserrat
//Morocco
//Mozambique
//Myanmar
//Namibia
//Nauru
//Nepal
//Netherlands
//Netherlands Antilles
//New Caledonia
//New Zealand
//Nicaragua
//Niger
//Nigeria
//Niue
//Norfolk Island
//Northern Mariana Islands
//Norway
//Oman
//Pakistan
//Palau
//Palestine
//Panama
//Papua New Guinea
//Paraguay
//Peru
//Philippines
//Pitcairn
//Poland
//Portugal
//Puerto Rico
//Qatar
//Reunion
//Romania
//Russian Federation
//Rwanda
//Saint Kitts and Nevis
//Saint Lucia
//Saint Vincent and the Grenadines
//Samoa
//San Marino
//Sao Tome and Principe
//Saudi Arabia
//Senegal
//Serbia
//Seychelles
//Sierra Leone
//Singapore
//Slovakia (Slovak Republic)
//Slovenia
//Solomon Islands
//Somalia
//South Africa
//South Georgia & South Sandwich Islands
//South Sudan
//Spain
//Sri Lanka
//St. Helena
//St. Pierre and Miquelon
//Sudan
//Suriname
//Svalbard and Jan Mayen Islands
//Swaziland
//Sweden
//Switzerland
//Syrian Arab Republic
//Taiwan
//Tajikistan
//Tanzania
//Thailand
//Togo
//Tokelau
//Tonga
//Trinidad and Tobago
//Tunisia
//Turkey
//Turkmenistan
//Turks and Caicos Islands
//Tuvalu
//Uganda
//Ukraine
//United Arab Emirates
//United Kingdom
//United States minor outlying islands
//Uruguay
//Uzbekistan
//Vanuatu
//Vatican City State (Holy See)
//Venezuela
//Viet Nam
//Virgin Islands (British)
//Virgin Islands (U.S.)
//Wallis and Futuna Islands
//Western Sahara
//Yemen
//Zambia
//Zimbabwe
//Select state
//AA (Armed Forces Americas)
//AE (Armed Forces Europe)
//Alabama
//Alaska
//American Samoa
//AP (Armed Forces Pacific)
//Arizona
//Arkansas
//California
//Colorado
//Connecticut
//Delaware
//District of Columbia
//Federated States of Micronesia
//Florida
//Georgia
//Guam
//Hawaii
//Idaho
//Illinois
//Indiana
//Iowa
//Kansas
//Kentucky
//Louisiana
//Maine
//Marshall Islands
//Maryland
//Massachusetts
//Michigan
//Minnesota
//Mississippi
//Missouri
//Montana
//Nebraska
//Nevada
//New Hampshire
//New Jersey
//New Mexico
//New York
//North Carolina
//North Dakota
//Northern Mariana Islands
//Ohio
//Oklahoma
//Oregon
//Palau
//Pennsylvania
//Puerto Rico
//Rhode Island
//South Carolina
//South Dakota
//Tennessee
//Texas
//Utah
//Vermont
//Virgin Islands
//Virginia
//Washington
//West Virginia
//Wisconsin
//Wyoming
//Thank you
//Your order has been successfully processed!
//true
//order-number
//div
//ORDER NUMBER: 1031
