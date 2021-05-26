package WindowHandling;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowHandling {

	WebDriver driver = null;

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\DemoProject_Capgemini\\SeleniumAdvanced\\src\\test\\resources\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
	}

	//	@Test
	//	public void testMethod() {
	//
	//		//	System.out.println(driver.getWindowHandle()); // Will provide the unique value for the window on which user is currently working on. 
	//		System.out.println(driver.getWindowHandles()); // Will provide the unique values for all the windows opened by the webdriver.
	//	}

	@Test
	public void swtchToAnotherWindow() {

		String firstWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		Iterator<String> itr = allWindows.iterator();

		while(itr.hasNext()) {
			
			String window = itr.next();
			driver.switchTo().window(window);
			System.out.println(driver.getTitle());

			if(driver.getTitle().contentEquals("Ice Mortgage")){
				driver.close();
			}

		}

		driver.switchTo().window(firstWindow);
		driver.findElement(By.xpath("//*[@id=\"qsb-keyword-sugg\"]")).sendKeys("Selenium Tester");
	}

	@AfterMethod
	public void afterMethod() {

		//	driver.quit();

	}

}
