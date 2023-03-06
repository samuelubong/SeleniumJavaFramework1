import java.util.HashMap;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.HashMap;

public class BrowserStack {

	public static final String URL = "https://samuelubong_9bIZYC:dDgmbj5p3SfEzhXEY9Gc@hub-cloud.browserstack.com/wd/";

	public static void main(String[] args) throws Exception {

		MutableCapabilities caps = new MutableCapabilities();
		caps.setCapability("browserName", "chrome");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", "Windows");
		browserstackOptions.put("osVersion", "10");

		//  Set the resolution using the 'resolution' capability.
		browserstackOptions.put("resolution", "1024x768");
		browserstackOptions.put("buildName", "Java Screen Resolution test Sample Build");
		browserstackOptions.put("sessionName", "Screen Resolution test");


		//  Set the selenium version.
		browserstackOptions.put("seleniumVersion", "4.0.0");
		caps.setCapability("bstack:options", browserstackOptions);
		
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		//WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.browserstack.com");
		driver.quit();
		
	}
}



