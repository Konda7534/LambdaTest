package LamdaTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Scenario_1 {
	
	//WebDriver driver;
	
	String username = "yedukondalureddy234";
    String accesskey = "6NLQ7V8Z1mLbI382CfjAIvH1SPhjTRYVgZIp2SJpimlhJuWiKa";
    static RemoteWebDriver driver = null;
    String gridURL = "@hub.lambdatest.com/wd/hub";
    boolean status = false;
    

	public void test1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		
		String value="Welcome to LambdaTest";
		
		driver.manage().window().maximize();
		
		driver.get("https://www.lambdatest.com/selenium-playground/");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[text()='Simple Form Demo']")).click();
		
	String	currentUrl=driver.getCurrentUrl();
	    if(currentUrl.equals("https://www.lambdatest.com/selenium-playground/simple-form-demo"))
	    {
	    	System.out.println("PageUrl is equal to the simple-form-demo");
	    	
	    }
	    else
	    {
	    	System.out.println("PageUrl is not equal to the simple-form-demo");
	    }
	    
	    driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys(value);
	    
	    driver.findElement(By.id("showInput")).click();
	    
	    WebElement element = driver.findElement(By.xpath("//p[@id='message']"));
	    
	    String value1=element.getText();
	    if(value.equals(value1))
	    {
	    	System.out.println("Our text is right side of the panel");
	    }
	    else
	    {
	    	System.out.println("Our text is not right side of the panel");
	    }
	    
	}
	public void setUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "104.0");
        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get any available one.
        capabilities.setCapability("build", "LambdaTestSampleApp");
        capabilities.setCapability("name", "LambdaTestJavaSample");
        capabilities.setCapability("visual",true);
        capabilities.setCapability("video",true);
        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		
	}
	public void tearDown() {
	    driver.quit();
	   
	}

}
