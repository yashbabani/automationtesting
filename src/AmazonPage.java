import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class AmazonPage extends BasePage {

	public int NavigateTo() throws Exception {
		
		NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
		Number number = 0;
		
		driver.navigate().to("https://www.amazon.in/");
		
		
		Thread.sleep(5000);
		
		//Search Product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone 11 128GB Black" + Keys.ENTER);
		
		Thread.sleep(5000);
		
		
		//Select product
		driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='search']/div/div/div/div/span[@data-component-type='s-search-results']/div/div/div/span/div[@data-component-type='s-impression-logger']/div/div/div/div/div/div/span[@data-component-type='s-product-image']/a[@target='_blank']/div[1]")).click();
		
		Thread.sleep(5000);
		
		
		//Switch to new window
		for(String amazonNewWindow:driver.getWindowHandles()){
		    driver.switchTo().window(amazonNewWindow);
		}

		Thread.sleep(5000);


		//Add to cart
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
		Thread.sleep(3000);
		
		
		//Print Price
		System.out.println("The price of product on Amazon is: "+driver.findElement(By.id("attach-accessory-cart-subtotal")).getText());
		
		
		//Close side menu
		Actions closepopup = new Actions (driver);
		Action sendEsc1 = closepopup.sendKeys(Keys.ESCAPE).build();
		sendEsc1.perform();

		Thread.sleep(3000);


		//Open cart
		driver.findElement(By.xpath("//div[@id='nav-cart-count-container']")).click();

		Thread.sleep(5000);
		
		
		//Print Price
		String amazonItemPrice = driver.findElement(By.xpath("//body/div[@id='a-page']/div/div[@id='content']/div[@id='sc-retail-cart-container']/div/div/div[@id='sc-active-cart']/div/form[@id='activeCartViewForm']/div[@data-name='Subtotals']/span[@id='sc-subtotal-amount-activecart']/span[1]")).getText().substring(1).replaceAll("\\.0*$", "");
		amazonItemPrice = amazonItemPrice.trim();
		System.out.println("The price of product on Amazon after opening the cart is: ₹"+amazonItemPrice);
		
		//Convert price to int
		try {
			number = format.parse(amazonItemPrice);
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
				
		//return original price of the item
		return number.intValue();

		
	}
	
}
		

