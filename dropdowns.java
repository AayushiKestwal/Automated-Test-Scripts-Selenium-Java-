package introduction;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class dropdowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\webcy\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).click();
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select dropdown = new Select(staticDropdown);

		dropdown.selectByIndex(3);
		dropdown.selectByVisibleText("USD");
		dropdown.selectByValue("INR");
		driver.findElement(By.id("divpaxinfo")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Thread.sleep(2000);
		int i = 1,j=1;

		while(i<5&&j<4)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			driver.findElement(By.id("hrefIncChd")).click();
			i++;
			j++;
		}
          System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
          driver.findElement(By.id("btnclosepaxoption")).click();
          driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
          Thread.sleep(2000);
          driver.findElement(By.xpath("//a[@value='BLR']")).click();
          Thread.sleep(2000);
          driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='CCU']")).click();
          
          
          //calender UI
          driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
          driver.findElement(By.cssSelector(".ui-state-active")).click();
          if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
          {
        	  System.out.println("its enabled");
        	  Assert.assertTrue(false);
          }
          else
          {
        	  Assert.assertTrue(true);
          }
         //driver.findElement(By.className(".ui-datepicker-div")).click();
          //Thread.sleep(2000);
          
          //autosuggestive dropdowns
          
          driver.findElement(By.id("autosuggest")).sendKeys("ind");
          Thread.sleep(2000);
          List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
          
          for(WebElement option :options)
          {
        	  if(option.getText().equalsIgnoreCase("India"))
        	  {
        		  option.click();
        		  
        		  break;
        	  }
        	  
          }
          //handling checkboxes 
          driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
          Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
          //driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected();
          System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
          System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
          
          
          
          //handling calender UI
          
          
          
	}
	

}
