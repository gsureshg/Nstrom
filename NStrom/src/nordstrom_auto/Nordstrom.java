package nordstrom_auto;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Nordstrom {
	static WebDriver driver;
//	static BufferedWriter opdata;
	static long timestamp=System.currentTimeMillis();

	public static void main(String[] args) throws IOException {
//		opdata = new BufferedWriter(new FileWriter(	System.getProperty("user.dir") + "\\Scripts-"+timestamp+".txt", true));
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\chromedriver.exe");
		driver=new ChromeDriver();
		//System.setProperty("phantomjs.binary.path",System.getProperty("user.dir") + "\\phantomjs.exe");
	    //driver = new PhantomJSDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.get("http://shop.nordstrom.com");
//		driver.get("http://shop.dev.nordstrom.com/");
		String status= (String) js.executeScript("var s =document.readyState; return s;");
		if(!status.equalsIgnoreCase("complete")){
			driver.navigate().refresh();
		}
		System.out.println("**************************");
		List<WebElement> tags = driver.findElements(By.tagName("script"));
		for (WebElement webElement : tags) {
			System.out.println(webElement.getAttribute("src").toString());
			System.out.println("**************************");

		}

		List<WebElement> alllinks = driver.findElements(By.xpath("//a[string-length(@href) > 0]"));
		System.out.println("Total number of links in this page :" + alllinks.size()+"\n");
		System.out.println("Scripts loding status:	"+status+" \nTags are :");

//		String contentsOfHeadTag = (String) js.executeScript("var x =document.getElementsByTagName('head')[0].innerHTML; return x;");
//		System.out.println(contentsOfHeadTag);		
		String html=driver.getPageSource();
		org.jsoup.nodes.Document doc = Jsoup.parse(html);
		System.out.println((doc.getElementsByAttributeValueContaining("src", "/tag.js")).outerHtml());
		System.out.println((doc.getElementsByAttributeValueContaining("src", "/sp.js")).outerHtml()+"\n");
		System.out.println((doc.getElementsByAttributeValueContaining("src", "/eluminate.js")).outerHtml()+"\n");

		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Cookies count in page: " + driver.manage().getCookies().size());
		System.out.println(driver.manage().getCookieNamed("aam_uuid")+"\n");
		String spl[] = driver.manage().getCookieNamed("aam_uuid").toString().split(";");
		for (String st : spl) {
			System.out.println(st);
		}
		
		
		/*for (Cookie cookie : cookies) {
			if (cookie.toString().contains("domain=.nordstrom.com")) {
				System.out.println(cookie.toString());
				System.out.println("\n");
			} else {
				System.out.println(cookie.toString());
			}
		}*/
		driver.quit();		 
 
	}
}