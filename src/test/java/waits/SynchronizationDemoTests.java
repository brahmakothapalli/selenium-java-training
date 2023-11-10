package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SynchronizationDemoTests {

    /***
     * Selenium Waits
     *
     * 1. Implicit Wait - at the time browser initialization
     *  scope is throughtout execution for all the web elements
     *
     *
     *  2. Explicit Wait or WebDiverWait - whenever required we define
     *  scope is - to the element
     *  polling period = 0.5 sec
     *
     *
     *  3. Fluent Wait - advanced version of explicit wait
     *  scope is - to the element
     *  polling period = user can customize 2 or 3 or 5 secs
     *
     *
     *
     *
     *
     */



    @Test
    public void testCheckboxSelection() {

        WebDriver driver = new ChromeDriver();

        // implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        WebElement firstLink = driver.findElement(By.xpath("//a[@href='/dynamic_loading/1']"));

        firstLink.click();

        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']/button"));

        startButton.click();

        WebElement hellWorldText = driver.findElement(By.xpath("//div[@id='finish']/h4"));

        // explicit wait
        // default selenium polling period is 500 ms or 0.5 sec
        // polling period --
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(hellWorldText));
        //Thread.sleep(5000); // not right approach


        // By locator = By.xpath("//div[@id='finish']/h4")

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='finish']/h4")));



        String actualText = hellWorldText.getText();

        Assert.assertEquals(actualText, "Hello World!", "Text not matched");

    }
}
