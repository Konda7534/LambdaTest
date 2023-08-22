package LamdaTest;

import org.openqa.selenium.WebDriver;

public class Lamda {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		Test_Scenario_1 TC1= new Test_Scenario_1();
		TC1.setUp();
		TC1.test1();
		TC1.tearDown();
		Thread.sleep(2000);
		Test_Scenario_3 TC3=new Test_Scenario_3();
		TC3.setUp();
		TC3.test3();
		TC3.tearDown();
		Thread.sleep(2000);
		Test_Scenario_2 TC2=new Test_Scenario_2();
		TC2.setUp();
		TC2.test2();
		TC2.tearDown2();
		
		
		

	}

}
