package nordstrom_auto;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Nordstrom_Coremetrics {
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
		// driver.get("http://shop.dev.nordstrom.com/");
		driver.get("http://about.nordstrom.com/careers/");	

		String status = (String) js
				.executeScript("var s =document.readyState; return s;");
		if (!status.equalsIgnoreCase("complete")) {
			driver.navigate().refresh();}
			/*else
		{
				System.out.println("Entered in else case");
String cmjs="if (resource.url.match('1901.nordstrom.com/cm') && (resource.url.match('tid=1') || resource.url.match('tid=6'))) {"
		+ "                    tagvals = tagUtils.getTagVals(resource.url);"
		+ "                    casper.echo(utils.dump(tagvals));"
		+ "                    return true;"
		+ "                }"
		+ "            }, 'found pageview tag');"
		+ "        });";
	

String cmstatus = (String) js
.executeScript(cmjs);
System.out.println(cmstatus);
		}*/
		
		System.out
				.println("Scripts loding status:	" + status);
		String html = driver.getPageSource();
		org.jsoup.nodes.Document doc = Jsoup.parse(html);
		String tag = doc
				.getElementsByAttributeValueContaining("src", "/tag.js")
				.outerHtml();
		String sp = doc.getElementsByAttributeValueContaining("src", "/sp.js")
				.outerHtml();
		String coremetrics = doc.getElementsByAttributeValueContaining("src",
				"/eluminate.js").outerHtml();
		System.out.println("\n Loaded tags are:");
		if (tag == null) {
			System.out.println("/tag.js is not loaded");
		} else {
			System.out.println(tag);
		}

		if (sp == null) {
			System.out.println("/sp.js is not loaded");
		} else {
			System.out.println(sp);
		}
		if (coremetrics == null) {
			System.out.println("/coremetrics.js is not loaded");
		} else {
			System.out.println(coremetrics);
		}
		System.out.println("\n Cookies count in page: "
				+ driver.manage().getCookies().size());
		System.out.println(driver.manage().getCookieNamed("aam_uuid") + "\n");
		/*String spl[] = driver.manage().getCookieNamed("aam_uuid").toString()
				.split(";");
		for (String st : spl) {
			System.out.println(st);
		}*/
		driver.quit();

	}
}