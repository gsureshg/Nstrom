package test_jscript;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

public class Sample {
	static WebDriver driver;
	static String script=" <script type=\"text/javascript\">"
			+ "alert(\"Hello! I am an alert box!!\");"
			+ "</script>"+
			"\n as"
			;
    static String scr2="var addscript=window.document.createElement('script');"
    		+ "addscript.type='text/javascript';"
    		+ "addscript.src='file:///E:/PROJECTS/Selenium/CSSI_Demo/cart1.js';"
    		+ "document.getElementsByTagName('head')[0].appendChild(addscript);";

	public static void main(String[] args) throws IOException {
		System.out.println(System.currentTimeMillis());
		System.out.println(script);
	/*	System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\chromedriver.exe");
		driver=new ChromeDriver();
		  JavascriptExecutor js = (JavascriptExecutor)driver;
			driver.get("file:///C:/Users/Suresh/Desktop/Sa2.html");
//			  js.executeScript(script);
			String IncludeYUI = "script = document.createElement('script');script.type = 'text/javascript';script.async = true;script.onload = function(){};script.src = '"
                    + "E:\\PROJECTS\\Selenium\\CSSI_Demo\\cart1.js"
                    + "';document.getElementsByTagName('head')[0].appendChild(script);";
            js.executeScript(IncludeYUI);*/

//			  driver.findElement(By.name("q")).sendKeys("selenium");
		// Assume Guava, but whatever you use to load files...
//		String externalJS = Files.toString( new File("E:\\PROJECTS\\Selenium\\CSSI_Demo\\raw_cart.js"), Charset.forName("utf-8"));

		// Execute, assume no arguments, and no value to return
//		Object ignore = js.executeScript(externalJS);
//        js.executeScript("document.getElementsByTagName('head')[0].innerHTML += '<script src=\"file:///E:/PROJECTS/Selenium/CSSI_Demo/cart1.js\" type=\"text/javascript\"> </script>';");
//	js.executeScript("var s=window.document.createElement('script');\\	  s.src='file:///E:/PROJECTS/Selenium/CSSI_Demo/cart1.js';\\	  window.document.head.appendChild(s);");
	
	
	}
	
	void sampletest(){
		String s = "aam_uuid=36609448584182032773193169382851865324";

		String[] c = s.split("=");
//		System.out.println(c);
		System.out.println(c[1].toString().length());
	}
}
