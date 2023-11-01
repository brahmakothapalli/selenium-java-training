package windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowsDemoTests {

    @Test
    public void testHandlingMultipleWindows() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();

        // get parent window handle
        String parentWindow = driver.getWindowHandle();

        System.out.println("Parent Window ------ "+parentWindow);

        //clicking on New Window
        driver.findElement(By.id("windowButton")).click();

        Thread.sleep(3000);

        // switching to child window
        driver.switchTo().window("21F6D0D269C0AF565EB2F9342274A6BE");

        // get all window handles
        Set<String> childWindows = driver.getWindowHandles();
        for (String window : childWindows) {
            System.out.println("Child Widows --------- "+window);
        }

        driver.close();

        // driver.close() -- it closes the current window

        // driver.quit() -- it closes all the associated windows


    }
}
