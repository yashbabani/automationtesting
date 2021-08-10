import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

WebDriver driver;
	
	public void initialize() {
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\browserdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public void closeDriver() {
		driver.quit();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
