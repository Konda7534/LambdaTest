package LamdaTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;


public class Test_Scenario_3 {

	String username = "yedukondalureddy234";
    String accesskey = "6NLQ7V8Z1mLbI382CfjAIvH1SPhjTRYVgZIp2SJpimlhJuWiKa";
    static RemoteWebDriver driver = null;
    String gridURL = "@hub.lambdatest.com/wd/hub";
    boolean status = false;

	public void test3() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
		
		driver.get("https://www.lambdatest.com/selenium-playground/");
		
		driver.manage().window().maximize();
		
		//click “Input Form Submit” under “Input Forms”
        driver.findElement(By.xpath("//a[contains(text(),'Input Form Submit')]")).click();
        Thread.sleep(2000);
        //Click “Submit” without filling in any information in the form
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        Thread.sleep(2000);
        //Assert “Please fill in the fields” error message
        String msg=driver.findElement(By.id("name")).getAttribute("validationMessage");
        if(msg.equals("Please fill out this field."))
        {
        	System.out.println("success message equal");
        }
        else
        {
        	System.out.println("message not equal");
        }
        
       
        Thread.sleep(2000);
        //Fill in Name, Email, and other fields.
        driver.findElement(By.id("name")).sendKeys("Konda");
        Thread.sleep(2000);
        driver.findElement(By.id("inputEmail4")).sendKeys("KondaReddy@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("inputPassword4")).sendKeys("KondaReddy");
        Thread.sleep(2000);
        driver.findElement(By.id("company")).sendKeys("persistent");
        Thread.sleep(2000);
        driver.findElement(By.id("websitename")).sendKeys("Lambdatest");
        Thread.sleep(2000);
        //From the Country drop-down, select “United States” using the text property
        Select dropdown=new Select(driver.findElement(By.xpath("//select[@name='country']")));
        dropdown.selectByVisibleText("United States");
        Thread.sleep(2000);
        driver.findElement(By.id("inputCity")).sendKeys("Hyderabad");
        Thread.sleep(2000);
        driver.findElement(By.id("inputAddress1")).sendKeys("Hi-tech city");
        Thread.sleep(2000);
        driver.findElement(By.id("inputAddress2")).sendKeys("madhapur");
        Thread.sleep(2000);
        driver.findElement(By.id("inputState")).sendKeys("Telangana");
        Thread.sleep(2000);
        driver.findElement(By.id("inputZip")).sendKeys("50018");
        Thread.sleep(2000);
        //Fill all fields and click “Submit”.
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        //Once submitted, validate the success message “Thanks for contacting us, we will get back to you shortly.” on the screen.
        String SuccessfullMsg="Thanks for contacting us, we will get back to you shortly.";
        if(SuccessfullMsg.equals("Thanks for contacting us, we will get back to you shortly."))
        {
        	System.out.println("message successfully");
        }
        else
        {
        	System.out.println("message not successfully");
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
        





