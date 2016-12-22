package nordstrom_auto;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Nordstrom_Cookies {
	static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "E:\\MyGitProjects\\Nstrom-repo\\NStrom\\chromedriver.exe");
		driver=new ChromeDriver();
		//System.setProperty("phantomjs.binary.path",System.getProperty("user.dir") + "\\phantomjs.exe");
	    //driver = new PhantomJSDriver();
		driver.get("http://shop.nordstrom.com");
		//driver.get("http://shop.dev.nordstrom.com/");
		
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(driver.manage().getCookieNamed("aam_uuid"));
		String spl[] = driver.manage().getCookieNamed("aam_uuid").toString().split(";");
		for (String st : spl) {
			System.out.println(st);
		}
		
		System.out.println("Total cookies in page: " + driver.manage().getCookies().size());
		for (Cookie cookie : cookies) {
			if (cookie.toString().contains("domain=.nordstrom.com")) {
				System.out.println(cookie.toString());
				System.out.println("\n");
			} else {
				System.out.println(cookie.toString());
			}
		}
		driver.quit();
		
		
		 
 
	}
}