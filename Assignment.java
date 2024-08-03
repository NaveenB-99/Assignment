import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.Assert;

//import dev.failsafe.internal.util.Assert;

public class NewTest {
	
  
public static void main(String args[]) throws InterruptedException {
	
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.fitpeo.com/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//div[text()='Revenue Calculator']")).click();
	// Adjust the Slider
	   Actions actions = new Actions(driver);
	   WebElement slider = driver.findElement(By.xpath("//input[@aria-valuenow]")); // Adjust the locator as needed
	   // Drag the slider to the desired value
   actions.clickAndHold(slider)
          .moveByOffset(96, 0)
          .release()
          .perform();
   driver.findElement(By.xpath("//*[contains(@class,'MuiInputBase-input MuiOutlinedInput')]")).click();
   driver.findElement(By.xpath("//*[contains(@class,'MuiInputBase-input MuiOutlinedInput')]")).clear();
   driver.findElement(By.xpath("//*[contains(@class,'MuiInputBase-input MuiOutlinedInput')]")).sendKeys("560");
   String attributevalue=driver.findElement(By.xpath("//input[@aria-valuenow]")).getAttribute("aria-valuenow");
   
   System.out.println(attributevalue);

   for(int i=1;i<=3;i++) {
	    Thread.sleep(2000);
	   driver.findElement(By.xpath("(//div[contains(@class,'MuiBox-root css-1p19z09')] //input[contains(@class,'PrivateSwitchBase-input')])[" + i + "]")).click();
	   
   }
   String actualvalue=driver.findElement(By.xpath("(//*[contains(text(),'Total Recurring Reimbursement for all Patients')])[1]")).getText();
   System.out.println(actualvalue);
   if(actualvalue.contains("$100320")) {
	   Assert.assertEquals(true,true,"24000 value is  populated"); 
   }
   else {
	   Assert.assertEquals(false,true,"24000 value is not populated"); 

   }

       
  
	   
	
	
}
	
	
	
  }
