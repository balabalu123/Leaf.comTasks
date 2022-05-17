package org.leafgroundPractice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGroundPractice {
	
	public void Addition() {
		System.out.println("addition");

	}
	public void percentage() {
		System.out.println("percentage");

	}
	public void modification() {
		System.out.println("modified");

	}

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\balua\\eclipse-workspace\\LeafGroundSitePractice\\Driver\\chromedriver.exe");	
		WebDriver driver=new ChromeDriver();	
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		String oldwindow=driver.getWindowHandle();
		WebElement clickButton= driver.findElement(By.id("home"));
		clickButton.click();
		Set<String>handles=driver.getWindowHandles();
		for (String newwindow : handles) {

			driver.switchTo().window(newwindow);

		}

		WebElement editBox=driver.findElement(By.xpath("//*[@id=\'post-153\']/div[2]/div/ul/li[1]/a/img"));
		editBox.click();
		driver.close();

		driver.switchTo().window(oldwindow);

		WebElement openmultiple=driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/button"));
		openmultiple.click();

		int size=driver.getWindowHandles().size();
		System.out.println(size);




		WebElement dontclose =driver.findElement(By.id("color"));
		dontclose.click();
		Set<String>newwindowHandles=driver.getWindowHandles();

		for (String allwindows : newwindowHandles) {

			if (!allwindows.equals(oldwindow)) {

				driver.switchTo().window(allwindows);
				driver.close();

			}



		}






	}

}
