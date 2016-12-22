package nordstrom_auto;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Nordstrom_Testng {
WebDriver driver;
JavascriptExecutor js;
String html;
Document doc;
	@BeforeSuite
	public void openBrowser(){
		System.setProperty("webdriver.chrome.driver","E:\\MyGitProjects\\Nstrom-repo\\NStrom\\chromedriver.exe");
		driver=new ChromeDriver();
		//System.setProperty("phantomjs.binary.path",System.getProperty("user.dir") + "\\phantomjs.exe");
	    //driver = new PhantomJSDriver();
		 js = (JavascriptExecutor)driver;
		driver.get("http://shop.nordstrom.com");
//		driver.get("http://shop.dev.nordstrom.com/");
		System.out.println("openbrowser done");
	}
	@AfterSuite
	public void closeBrowser(){
		driver.quit();	}
	@Test(priority=1)
	public void app_loading_status(){
		String status= (String) js.executeScript("var s =document.readyState; return s;");
		if(!status.equalsIgnoreCase("complete")){
			driver.navigate().refresh();
		}
		 html = driver.getPageSource();
		 doc = Jsoup.parse(html);
	}
	
	@Test(priority=2)
	public void tagjs_loading_staus(){
		String tag = doc
				.getElementsByAttributeValueContaining("src", "/tag.js")
				.outerHtml();
		if (tag == null) {
			System.out.println("/tag.js is not loaded");
		} else {
			System.out.println("/tag.js is loaded successfully \n" + tag);
		}

			}
	
	@Test(priority=3)
	public void spjs_loading_staus(){
			String sp = doc.getElementsByAttributeValueContaining("src", "/sp.js")
				.outerHtml();
		if (sp == null) {
			System.out.println("/sp.js is not loaded");
		} else {
			System.out.println("/sp.js is loaded successfully \n" + sp);
		}
		
	}
	@Test(priority=4)
	public void coremetricstag_loading_staus(){
		
		String coremetrics = doc.getElementsByAttributeValueContaining("src",
				"/eluminate.js").outerHtml();
		if (coremetrics == null) {
			System.out.println("/coremetrics.js is not loaded");
		} else {
			System.out.println("/coremetrics.js is loaded successfully \n"+coremetrics);
		}
	}
	
}
