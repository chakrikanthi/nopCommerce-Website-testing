package nopCommerce;

import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Giftcardpurchases {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/notebooks");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement Giftcardtab=driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Gift Cards ']"));
		Giftcardtab.click();
		driver.findElement(By.xpath("//a[text()='$100 Physical Gift Card']")).click();
		
		String str=RandomStringUtils.randomAlphabetic(6);
		WebElement RecipientName=driver.findElement(By.xpath("//input[@id='giftcard_45_RecipientName']"));
		RecipientName.sendKeys(str);
		
		WebElement YourName=driver.findElement(By.xpath("//input[@id='giftcard_45_SenderName']"));
		YourName.sendKeys(str);
		
		String str1=RandomStringUtils.randomAlphabetic(20);
		WebElement Message=driver.findElement(By.xpath("//textarea[@id='giftcard_45_Message']"));
		Message.sendKeys(str1);
		Thread.sleep(1000);
		WebElement Addtocart=driver.findElement(By.xpath("//button[@class='button-1 add-to-cart-button']"));
		Addtocart.click();
		
		
//		WebElement successmsg=driver.findElement(By.xpath("//p[@class='content']"));
//		System.out.println(successmsg.getText());
		
		String successmsg1=driver.findElement(By.xpath("//p[@class='content']")).getText();
		System.out.println(successmsg1);
		driver.findElement(By.xpath("//span[@class='close']")).click();
		Thread.sleep(1500);
		
		WebElement  Shoppingcarttab=driver.findElement(By.xpath("//span[@class='cart-label']"));
		Shoppingcarttab.click();
//		WebElement  Gocartbtn=driver.findElement(By.xpath("//button[@class='button-1 cart-button']"));
//		Actions act= new Actions(driver);
//		act.moveToElement(Shoppingcarttab).click(Shoppingcarttab).perform();
		WebElement termsofservice=driver.findElement(By.xpath("//input[@id='termsofservice']"));
		termsofservice.click();
		WebElement Checkoutbtn=driver.findElement(By.xpath("//button[@id='checkout']"));
		Checkoutbtn.click();
		WebElement CheckoutasGuest=driver.findElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));
		CheckoutasGuest.click();
		
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
//output:
/*The product has been added to your shopping cart
Select country
United States
Afghanistan
Albania
Algeria
American Samoa
Andorra
Angola
Anguilla
Antarctica
Antigua and Barbuda
Argentina
Armenia
Aruba
Australia
Austria
Azerbaijan
Bahamas
Bahrain
Bangladesh
Barbados
Belarus
Belgium
Belize
Benin
Bermuda
Bhutan
Bolivia
Bosnia and Herzegowina
Botswana
Bouvet Island
Brazil
British Indian Ocean Territory
Brunei Darussalam
Bulgaria
Burkina Faso
Burundi
Cambodia
Cameroon
Canada
Cape Verde
Cayman Islands
Central African Republic
Chad
Chile
China
Christmas Island
Cocos (Keeling) Islands
Colombia
Comoros
Congo
Congo (Democratic Republic of the)
Cook Islands
Costa Rica
Cote D'Ivoire
Croatia
Cuba
Cyprus
Czech Republic
Denmark
Djibouti
Dominica
Dominican Republic
East Timor
Ecuador
Egypt
El Salvador
Equatorial Guinea
Eritrea
Estonia
Ethiopia
Falkland Islands (Malvinas)
Faroe Islands
Fiji
Finland
France
French Guiana
French Polynesia
French Southern Territories
Gabon
Gambia
Georgia
Germany
Ghana
Gibraltar
Greece
Greenland
Grenada
Guadeloupe
Guam
Guatemala
Guinea
Guinea-bissau
Guyana
Haiti
Heard and Mc Donald Islands
Honduras
Hong Kong
Hungary
Iceland
India
Indonesia
Iran (Islamic Republic of)
Iraq
Ireland
Israel
Italy
Jamaica
Japan
Jordan
Kazakhstan
Kenya
Kiribati
Korea
Korea, Democratic People's Republic of
Kuwait
Kyrgyzstan
Lao People's Democratic Republic
Latvia
Lebanon
Lesotho
Liberia
Libyan Arab Jamahiriya
Liechtenstein
Lithuania
Luxembourg
Macau
Macedonia
Madagascar
Malawi
Malaysia
Maldives
Mali
Malta
Marshall Islands
Martinique
Mauritania
Mauritius
Mayotte
Mexico
Micronesia
Moldova
Monaco
Mongolia
Montenegro
Montserrat
Morocco
Mozambique
Myanmar
Namibia
Nauru
Nepal
Netherlands
Netherlands Antilles
New Caledonia
New Zealand
Nicaragua
Niger
Nigeria
Niue
Norfolk Island
Northern Mariana Islands
Norway
Oman
Pakistan
Palau
Palestine
Panama
Papua New Guinea
Paraguay
Peru
Philippines
Pitcairn
Poland
Portugal
Puerto Rico
Qatar
Reunion
Romania
Russian Federation
Rwanda
Saint Kitts and Nevis
Saint Lucia
Saint Vincent and the Grenadines
Samoa
San Marino
Sao Tome and Principe
Saudi Arabia
Senegal
Serbia
Seychelles
Sierra Leone
Singapore
Slovakia (Slovak Republic)
Slovenia
Solomon Islands
Somalia
South Africa
South Georgia & South Sandwich Islands
South Sudan
Spain
Sri Lanka
St. Helena
St. Pierre and Miquelon
Sudan
Suriname
Svalbard and Jan Mayen Islands
Swaziland
Sweden
Switzerland
Syrian Arab Republic
Taiwan
Tajikistan
Tanzania
Thailand
Togo
Tokelau
Tonga
Trinidad and Tobago
Tunisia
Turkey
Turkmenistan
Turks and Caicos Islands
Tuvalu
Uganda
Ukraine
United Arab Emirates
United Kingdom
United States minor outlying islands
Uruguay
Uzbekistan
Vanuatu
Vatican City State (Holy See)
Venezuela
Viet Nam
Virgin Islands (British)
Virgin Islands (U.S.)
Wallis and Futuna Islands
Western Sahara
Yemen
Zambia
Zimbabwe
Select state
AA (Armed Forces Americas)
AE (Armed Forces Europe)
Alabama
Alaska
American Samoa
AP (Armed Forces Pacific)
Arizona
Arkansas
California
Colorado
Connecticut
Delaware
District of Columbia
Federated States of Micronesia
Florida
Georgia
Guam
Hawaii
Idaho
Illinois
Indiana
Iowa
Kansas
Kentucky
Louisiana
Maine
Marshall Islands
Maryland
Massachusetts
Michigan
Minnesota
Mississippi
Missouri
Montana
Nebraska
Nevada
New Hampshire
New Jersey
New Mexico
New York
North Carolina
North Dakota
Northern Mariana Islands
Ohio
Oklahoma
Oregon
Palau
Pennsylvania
Puerto Rico
Rhode Island
South Carolina
South Dakota
Tennessee
Texas
Utah
Vermont
Virgin Islands
Virginia
Washington
West Virginia
Wisconsin
Wyoming
Thank you
Your order has been successfully processed!
true
order-number
div
ORDER NUMBER: 1031*/