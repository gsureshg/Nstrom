package test_jscript;

import org.jsoup.Jsoup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JsTags {
	  static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\chromedriver.exe");
		driver=new ChromeDriver();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("window-size=1024,768");
//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//		driver = new ChromeDriver(capabilities);
//		driver= new PhantomJSDriver();
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.get("http://shop.nordstrom.com");
//		String contentsOfHeadTag = (String) js.executeScript("var x =document.getElementsByTagName('head')[0].innerHTML; return x;");
//		System.out.println(contentsOfHeadTag);
		String con1 = (String) js.executeScript("var y =document.getElementsByTagName('script').innerHTML; return y;");
		System.out.println(con1);
		String status= (String) js.executeScript("var s =document.readyState; return s;");
		System.out.println(status);
//		driver.findElement(By.xpath("//script[contains()]");
		/*if (js.executeScript("return document.readyState").toString().equals("complete")){ 
			   System.out.println("Page Is loaded.");
			   return; 
			  } 

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver);

		WebDriverWait wait1 = new WebDriverWait(driver, 45);
		By tag=By.xpath("//script[@src='//s.btstatic.com/tag.js']");*/
//		wait.until(ExpectedConditions.presenceOfElementLocated(tag));
//		System.out.println(tag.innerHTML);
//		System.out.println(js.executeScript("return document.readyState"));
//		Predicate<WebDriver> pageLoaded = new Predicate<WebDriver>(){
//	        public boolean apply(WebDriver input) {
//	            return ((JavascriptExecutor) input).executeScript("return document.readyState").equals("complete");
//	        }	};
//	new FluentWait<WebDriver>(driver).until(pageLoaded);
				String html=driver.getPageSource();
		org.jsoup.nodes.Document doc = Jsoup.parse(html);
		System.out.println((doc.getElementsByAttributeValueContaining("src", "/tag.js")).outerHtml());
		System.out.println((doc.getElementsByAttributeValueContaining("src", "/sp.js")).outerHtml());

//		System.out.println(doc.html());

//		System.out.println(doc.data());
//		System.out.println(doc.outerHtml());
//		Set<Cookie> cookies= driver.manage().getCookies();
	/*	System.out.println(driver.manage().getCookieNamed("aam_uuid"));
String spl[]=driver.manage().getCookieNamed("aam_uuid").toString().split(";");
for (String st : spl) {
	System.out.println(st);
}
		System.out.println(driver.manage().getCookies().size());
		for (Cookie cookie : cookies) {
			if (cookie.toString().contains("domain=.nordstrom.com")) {
				System.out.println(cookie.toString());
				System.out.println("\n");
			}
			else{
			System.out.println(cookie.toString());}
		}
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver)
				.executeScript("alert('hello world');");
		}
*/
//		sysodocument.getElementsByTagName("script")[0].innerHTML
//System.out.println();
//		Object x= doc.
//		Elements links = doc.getElementsByTag("script");
//		Element head = doc.select("head").first();
//System.out.println(links);
		
		driver.quit();
	}
//	var scripts = document.getElementsByTagName('script');



}

