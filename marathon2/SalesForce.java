package marathon2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class SalesForce {

	public static void main(String[] args) throws InterruptedException 
	{
		ChromeOptions ch = new ChromeOptions();
	ch.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(ch);
driver.get("https://login.salesforce.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.findElement(By.name("username")).sendKeys("hari.radhakrishnan@qeagle.com");
driver.findElement(By.id("password")).sendKeys("Leaf@123");
driver.findElement(By.name("Login")).click();
 driver.findElement(By.xpath("//span[text()='Learn More']")).click();
Set<String> win = driver.getWindowHandles();
List<String>win1=new ArrayList<String>(win);
driver.switchTo().window(win1.get(1));
String url = driver.getCurrentUrl();
System.out.println(url);
driver.findElement(By.xpath("//button[text()='Confirm']")).click();
Shadow dom = new Shadow(driver);
dom.findElementByXPath("//span[text()='Learning']").click();
Thread.sleep(2000);
WebElement learningOn = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
Actions aa=new Actions(driver);
aa.moveToElement(learningOn).perform();
aa.scrollToElement(learningOn).click();
 dom.findElementByXPath("//a[text()='Salesforce Certification']").click();
 WebElement first = driver.findElement(By.xpath("//div[@class='roleMenu-item_text']"));
	String first1 = first.getText();
	System.out.println(first1);
	 List<WebElement> certifi = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
	List<String>lis=new ArrayList<String>();
	for(WebElement certi:certifi)
	{
		String cert = certi.getText();
		System.out.println("certificate Name");
	System.out.println(cert);
	}
	}

}
