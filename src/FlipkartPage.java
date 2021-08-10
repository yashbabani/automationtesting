import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class FlipkartPage extends BasePage {

	public int NavigateTo() throws Exception {
		
		NumberFormat format = NumberFormat.getInstance(Locale.US);
		Number number = 0;
		
		driver.navigate().to("https://www.flipkart.com/");
		
		Thread.sleep(5000);


		//Close login pop-up
		Actions closepopup = new Actions (driver);
		Action sendEsc = closepopup.sendKeys(Keys.ESCAPE).build();
		sendEsc.perform();
		
		Thread.sleep(5000);
		
		
		//Search product 
		driver.findElement(By.name("q")).sendKeys("iPhone 11 128GB Black" + Keys.ENTER);

		Thread.sleep(5000);

		
		//Fetch first product
		driver.findElement(By.xpath("//body/div[@id='container']/div/div/div/div/div[2]/div[1]/div[1]/div[1]/a[1]/div[2]/div[1]/div[1]")).click();
		
		Thread.sleep(5000);
		
		
		//Switch to new window
		for(String newWindowFlipkart:driver.getWindowHandles()){
		    driver.switchTo().window(newWindowFlipkart);
		}
		
		Thread.sleep(5000);
		
		
		//Print price of fetched product
		String flipkartItemPrice = driver.findElement(By.xpath("//div[@class='_30jeq3 _16Jk6d']")).getText().substring(1);
		System.out.println("The price of product on Flipkart is: ₹"+flipkartItemPrice);
		
		
		//Add to cart 
		driver.findElement(By.className("_1KOMV2")).click();
		
		Thread.sleep(5000);
		
		
		//Increase quantity
		driver.findElement(By.xpath("//button[2]")).click();
		
		Thread.sleep(10000);
		
		
		//Print new price
		System.out.println("The price of product after increasing quantity by 1 on Flipkart is: "+driver.findElement(By.xpath("//div[@class='Ob17DV _3X7Jj1']//span")).getText());
		
		//Convert price to int
		try {
			number = format.parse(flipkartItemPrice);
		}
		catch(ParseException e) {
			e.printStackTrace();
		}

		//return original price of the item
		return number.intValue();
		
	}
	
}
