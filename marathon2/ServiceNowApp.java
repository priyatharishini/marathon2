package marathon2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class ServiceNowApp {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
			ChromeDriver driver=new ChromeDriver(ch);
			driver.get("https://dev57553.service-now.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("5$dJ*EFdhhW0");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Shadow dom=new Shadow(driver);
			dom.setImplicitWait(10);
			WebElement all = dom.findElementByXPath("//div[text()='All']");
	all.click();
	dom.setImplicitWait(10);
	 	dom.findElementByXPath("//span[text()='Service Catalog']").click();
	 	dom.setImplicitWait(10);
	 	WebElement frame = dom.findElementByXPath("//iframe[@name='gsft_main']");
	 	 driver.switchTo().frame(frame);
	 	 dom.findElementByXPath("//h2[contains(text(), 'Mobiles')]").click();
			dom.findElementByXPath("//strong[text()='Apple iPhone 6s']").click();
			WebElement color = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2]"));
			 Select op=new Select(color);
			 op.selectByVisibleText("Gold");
			 WebElement storage = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[3]"));
			 Select op1=new Select(storage);
op1.selectByValue("onetwentyeight");
driver.findElement(By.id("oi_order_now_button")).click();
String order = driver.findElement(By.xpath("//div[@id='page_title']")).getText();
System.out.println(order);
String orderplace = driver.findElement(By.xpath("//dl[@class='dl-horizontal sc-dl-horizontal']//dd[1]")).getText();
System.out.println(orderplace);
	if(driver.getTitle().contains(order))
	{
		System.out.println("Order is Placed");
	}
	else
	{
		System.out.println("Order is Not Placed");
	}
	String request = driver.findElement(By.xpath("//a[@class='linked requestItemUrl']//b[1]")).getText();
	System.out.println(request);
	System.out.println(driver.getTitle());
	}

}
