package test_jscript;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	static WebDriver driver;
	static long timestamp = System.currentTimeMillis();

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\chromedriver.exe");
		driver = new ChromeDriver();
//		 System.setProperty("phantomjs.binary.path",System.getProperty("user.dir")
//		 + "\\phantomjs.exe");
//		 driver = new PhantomJSDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		driver.get("http://shop.nordstrom.com");
		 driver.get("http://shop.dev.nordstrom.com/");
//		driver.get("http://about.nordstrom.com/careers/");
		String html = driver.getPageSource();
		org.jsoup.nodes.Document doc = Jsoup.parse(html);
		String tag = doc
				.getElementsByAttributeValueContaining("src", "/cm")
				.outerHtml();
	
		driver.quit();
	}
}