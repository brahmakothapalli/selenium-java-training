package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertsDemoTests {

    @Test
    public void testHandlingAlerts() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        // simple alert Ok
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        Alert alertHandler = driver.switchTo().alert();

        driver.switchTo().defaultContent();

        // getting alert text
        String alertText = alertHandler.getText();

        // clicking Ok
        alertHandler.accept();

        // confirm alert Ok & Cancel
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        // cancel alert
        alertHandler.dismiss();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        Alert alertHandler1 = driver.switchTo().alert();

        alertHandler1.sendKeys("this alert text");

        System.out.println(alertText);

    }

    @Test
    public void testHandleAlertPrompt() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        // prompt alert

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        Alert alertHandler1 = driver.switchTo().alert();

        String promptText = alertHandler1.getText();

        System.out.println(promptText);

        alertHandler1.sendKeys("this alert text");

        alertHandler1.accept();
    }
}
