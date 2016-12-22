package test_jscript;

import java.io.File;
import java.io.IOException;
import java.util.List;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.core.har.HarLog;
import net.lightbody.bmp.core.har.HarRequest;
import net.lightbody.bmp.core.har.HarResponse;
import net.lightbody.bmp.proxy.CaptureType;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GetAllReqs {
	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + 
				"\\chromedriver.exe");
		// start the proxy
	    BrowserMobProxy proxy = new BrowserMobProxyServer();
	    
	    
	    proxy.start(0);

	    // get the Selenium proxy object
	    Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

	    // configure it as a desired capability
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

	    // start the browser up
	     driver = new ChromeDriver(capabilities);

	    // enable more detailed HAR capture, if desired (see CaptureType for the complete list)
	    proxy.enableHarCaptureTypes(CaptureType.REQUEST_HEADERS,CaptureType.REQUEST_CONTENT,CaptureType.REQUEST_COOKIES,
	    		CaptureType.RESPONSE_CONTENT,CaptureType.RESPONSE_COOKIES);

	    // create a new HAR with the label "yahoo.com"
	    proxy.newHar("p.nordstromdata.com");
	    // open yahoo.com
	    driver.get("http://shop.nordstrom.com/");

	    // get the HAR data
	    Har har = proxy.getHar();
	    har.writeTo(new File("E:\\PROJECTS\\Selenium\\NStrom\\Req.json"));
	    HarLog log = har.getLog();

	    List<HarEntry> entries = log.getEntries();
	    HarEntry entry = entries.get(0);
	    HarRequest req = entry.getRequest();
//	    System.out.println(req.getUrl());
	   
	    for (int i = 0; i < log.getEntries().size(); i++) {
	    	HarEntry ent = entries.get(i);
		    HarRequest re = ent.getRequest();
		    HarResponse res= ent.getResponse();
		    		
		    if(re.getUrl().contains("/tag.js")||re.getUrl().contains("/sp.js")||re.getUrl().contains("/eluminate.js")||re.getUrl().contains("1901.nordstrom.com/cm")||re.getUrl().contains("/i?stm"))
		    {
//		    	System.out.println(re.);
		    	System.out.println(i);
		    	System.out.println(re.getUrl());
		    	System.out.println(re.getCookies().toString());
		    	System.out.println("\n"+res.getStatus());
		    	System.out.println("----------------------");
		}
	    }
	    
	    
	    proxy.stop();
	   driver.quit(); 
	}
}
