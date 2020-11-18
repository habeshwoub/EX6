import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class HelloSelenium {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 15);

		driver.get("https://google.com");
	   	driver.findElement(By.name("q")).sendKeys("m3s" + Keys.ENTER);
		// selecting web element by CSS selector "div.g:nth-child(1) > div:nth-child(2) > div:nth-child(1)'- and run it
		 WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("div.g:nth-child(1) > div:nth-child(2) > div:nth-child(1)")));
		// System.out.println(firstResult.getAttribute("textContent"));

		//Check if text in the first result contains the string 'software engineering'
		if( firstResult.getAttribute("textContent").contains("software engineering")) {
			
			System.out.println("The Search result contains 'software engineering' ");
		}
		else{
				System.out.println("The search result does not contain keyword 'Software engineering'");
			}
		 //You can comment out the above if - else statement and uncomment the below statement to test using assertEquals
			//assertEquals("The return result does not contain the search word",firstResult.getAttribute("textContent").contains("software engineering"));

	
		//closing the browser 
		driver.close();
		}
		
	}

