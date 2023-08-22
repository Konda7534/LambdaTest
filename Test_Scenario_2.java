package LamdaTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Scenario_2 {
	
	String username = "yedukondalureddy234";
    String accesskey = "6NLQ7V8Z1mLbI382CfjAIvH1SPhjTRYVgZIp2SJpimlhJuWiKa";
    static RemoteWebDriver driver = null;
    String gridURL = "@hub.lambdatest.com/wd/hub";
    boolean status = false;

	public void test2()throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		
		
		driver.get("https://www.lambdatest.com/selenium-playground");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Drag & Drop Sliders")).click();
		
		
		WebElement progressbar=driver.findElement(By.xpath("//input[@value='15']"));
	    //JavascriptExecutor js=(JavascriptExecutor)driver;
	    Actions act = new Actions(driver);  
	    act.dragAndDropBy(progressbar,215,15).build().perform();
	    Thread.sleep(2000);
	    
	    WebElement element = driver.findElement((By.id("rangeSuccess")));
	    String text = element.getText();
	    System.out.println(text);
	    Thread.sleep(3000);
	    if(text.equals("95"))
	    {
	    	System.out.println("value is equal");
	    }
	    else
	    {
	    	System.out.println("value not equal");
	    }
	    Thread.sleep(3000);
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
	public void tearDown2() {
	    driver.quit();
	   
	}


}
