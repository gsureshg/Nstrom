package nordstrom_auto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Home_Page_All_Links {
	static WebDriver driver;
	public static void main(String[] args) 
    {
//        FirefoxDriver driver=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");

//		System.setProperty("phantomjs.binary.path",System.getProperty("user.dir")+"\\phantomjs.exe");
//		DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setJavascriptEnabled(true);
//		caps.setCapability("takesScreenshot", true);

//		driver = new PhantomJSDriver();
//		driver.get(url);
		
		
		 driver=new ChromeDriver();
	driver.get("http://shop.nordstrom.com");
		
	List<WebElement> alllinks=driver.findElements(By.xpath("//a[string-length(@href) > 0]"));
//        List<WebElement> links=driver.findElements(By.tagName("a"));
//        System.out.println("no of links:" +links.size());
        System.out.println("no of alllinks:" +alllinks.size());
        String linkText[]=new String[alllinks.size()];
        int i=0;
   	 for(WebElement link : alllinks)
     {
		 	if(link.getAttribute("href").contains("http")){
		 		 linkText[i]=link.getAttribute("href");
//			     System.out.println(linkText[i]); 
		 	}else{System.out.println("Not link");}
		 	 i++;
		    
     }
	 for(String lt:linkText)
	 {
		 driver.navigate().to(lt);
		
			// d.findElement(By.linkText(t)).click();
			 if(driver.getTitle().contains("Error 404"))
			 {
				 System.out.println(" "+lt+" Link: is not Working ");
				 driver.navigate().back();
			 }
			 else
			 {
			  System.out.println(" "+lt+" Link: is Working fine");
			 driver.navigate().back(); 
		 }
			/*String title= driver.getTitle();
			 if(title.equals("404"))
				 
			 {
				 System.out.println(" "+lt+" ---> is not Working ");
				 driver.navigate().back();
			 }
			 else
			 {
				 System.out.println(" "+lt+" ---> is Working fine");
				 driver.navigate().back();
			 }*/
				
			 
		
		
	 }
   }
}

