package introduction;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class linkTesting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\webcy\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		WebElement columnDriver = footerDriver.findElement(By.xpath("(//ul)[1]"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		int size = columnDriver.findElements(By.tagName("a")).size();
		for (int i = 1; i < size; i++) {

			String linkToClick = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(linkToClick);
			Thread.sleep(5000);
		}
		/*
		 * Set<String> abc = driver.getWindowHandles();// 4 Iterator<String> it =
		 * abc.iterator();
		 * 
		 * while (it.hasNext()) {
		 * 
		 * driver.switchTo().window(it.next()); System.out.println(driver.getTitle());
		 */

		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}
}
