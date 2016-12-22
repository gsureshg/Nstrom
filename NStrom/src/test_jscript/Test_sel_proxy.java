package test_jscript;
 
import java.util.ArrayList;
import java.util.List;
 
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
 
public class Test_sel_proxy {
 
private List<String> urlList = new ArrayList<String>();
 
@Before
public void setup() {
urlList.add("http://news.bbc.co.uk");
urlList.add("https://news.google.com");
}
 
@Test
public void passTraffixThroughProxyTest() {
String httpProxy = "10.10.1.3:8080";
String sslProxy = "10.10.1.3:8080";
String ftpProxy = "10.10.1.3:8080";
 
DesiredCapabilities capability = new DesiredCapabilities();
addProxyCapabilities(capability, httpProxy, sslProxy, ftpProxy);
 
for (String url : urlList){
WebDriver driver = new FirefoxDriver(capability);
driver.get(url);
driver.close();
}
}
 
public static DesiredCapabilities addProxyCapabilities(DesiredCapabilities capability, String httpProxy, String sslProxy,
String ftpProxy) {
Proxy proxy = new Proxy();
proxy.setProxyType(ProxyType.MANUAL);
proxy.setHttpProxy(httpProxy);
proxy.setSslProxy(sslProxy);
proxy.setFtpProxy(ftpProxy);
 
capability.setCapability(CapabilityType.PROXY, proxy);
capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
return capability;
}
}