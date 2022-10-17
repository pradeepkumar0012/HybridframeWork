package practice;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Actitime {
	public static void main(String[] args) throws Throwable {
		System.setProperty("Webdriver.gecko.driver", "./geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		FileInputStream fis= new FileInputStream("./actitime.txt");
		Properties pro =new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String username=pro.getProperty("un");
		String password=pro.getProperty("pwd");
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.xpath("//div[.='Login ']")).click();

	}
}
