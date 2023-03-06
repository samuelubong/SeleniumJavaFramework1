import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class saucelabsgood {

	
	public static void main(String[] args) {
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 11");
		browserOptions.setBrowserVersion("latest");
		Map<String, Object> sauceOptions = new HashMap<String, Object>();
		sauceOptions.put("build", "<1.0.1>");
		sauceOptions.put("name", "<First Google Automated Test>");
		browserOptions.setCapability("sauce:options", sauceOptions);

		URL url = null;
		try {
			url = new URL("https://oauth-samuelaubong-2c48a:6399705f-afa2-4d87-8cf6-a4640d055822@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);
		//WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		//driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Samuel Ubong");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.RETURN);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@class='oQRTK'][normalize-space()='Samuel Ubong']")).click();
		
		driver.quit();
		System.out.println("Test Completed");
		
	}
}
