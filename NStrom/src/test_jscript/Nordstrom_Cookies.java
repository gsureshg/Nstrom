package test_jscript;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class Nordstrom_Cookies {
	static WebDriver driver;

	public static void main(String[] args) {

//		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\chromedriver.exe");
//		 driver=new ChromeDriver();
//		ChromeOptions options = new ChromeOptions();
//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//		driver = new ChromeDriver(capabilities);
		 driver= new PhantomJSDriver();
		driver.get("http://shop.nordstrom.com");
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(driver.manage().getCookieNamed("aam_uuid"));
		String spl[] = driver.manage().getCookieNamed("aam_uuid").toString()
				.split(";");
//		System.out.println(spl[0].toString().length());
		for (String st : spl) {
			System.out.println(st);
		}
		System.out.println(driver.manage().getCookies().size());
		for (Cookie cookie : cookies) {
			if (cookie.toString().contains("domain=.nordstrom.com")) {
				System.out.println(cookie.toString());
				System.out.println("\n");
			} else {
//				System.out.println(cookie.toString());
			}
		}
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver)
					.executeScript("alert('hello world');");
		}

		driver.quit();

	}
}
