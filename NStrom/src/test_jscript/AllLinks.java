package test_jscript;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLinks {
	static WebDriver driver;
	public static void main(String[] args) 
    {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		driver=new ChromeDriver();
//		System.setProperty("phantomjs.binary.path",System.getProperty("user.dir")+"\\phantomjs.exe");
//		driver = new PhantomJSDriver();
	driver.get("http://shop.nordstrom.com");
		
	List<WebElement> alllinks=driver.findElements(By.xpath("//a[string-length(@href) > 0]"));
        System.out.println("no of alllinks:" +alllinks.size());
        String linkText[]=new String[alllinks.size()];
        int i=0;
   	 for(WebElement link : alllinks)
     {
		 	if(link.getAttribute("href").contains("http")){
		 		 linkText[i]=link.getAttribute("href");
//			     System.out.println(linkText[i]); 
		 	}
		 	else{
		 		System.out.println(linkText[i]+"is Not a link");
		 		}
		 	 i++;
		    
     }
	 for(String lt:linkText)
	 {
		 driver.navigate().to(lt);
		
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
	 }
  driver.quit();
  }
}

