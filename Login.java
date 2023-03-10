package introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class windowsactivity {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\webcy\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String pass = getPassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		driver.findElement(By.cssSelector("input[placeholder='Username'")).sendKeys("Aayushi");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello Aayushi,");
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		
		
		
		
		//driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		
	}
	
    public static String getPassword(WebDriver driver) throws InterruptedException
    {
    driver.get("https://rahulshettyacademy.com/locatorspractice/");
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("input[placeholder='Username'")).sendKeys("Aayushi");
	driver.findElement(By.cssSelector("input[placeholder='Password'")).sendKeys("Aayushi");
	driver.findElement(By.id("chkboxOne")).click();
	driver.findElement(By.id("chkboxTwo")).click();
	driver.findElement(By.cssSelector(".submit")).click();
	System.out.println(driver.findElement(By.cssSelector("form p")).getText());
	
	Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "* Incorrect username or password");
	
	driver.findElement(By.linkText("Forgot your password?")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("input[type=text]:nth-child(2)")).sendKeys("Aayushi");
	driver.findElement(By.cssSelector("input[type=text]:nth-child(3)")).sendKeys("aayu@gmail.com");
	driver.findElement(By.cssSelector("input[type=text]:nth-child(4)")).sendKeys("789456234");
    driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
    String passwordText = driver.findElement(By.cssSelector("form p")).getText();
    String[] passArray = passwordText.split("'");
    String password = passArray[1].split("'")[0];
    return password;
    
    
    
    }
    
}
