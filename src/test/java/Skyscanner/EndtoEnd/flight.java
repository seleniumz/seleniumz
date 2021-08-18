package Skyscanner.EndtoEnd;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class flight extends base{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver=init();
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath(obj("flights.source"))).sendKeys("New York");

		driver.findElement(By.xpath(obj("flights.source"))).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath(obj("flights.source"))).sendKeys(Keys.ENTER);
		
		
		
		
		
		
		
		


	}
	


}
