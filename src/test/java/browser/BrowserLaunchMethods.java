package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserLaunchMethods {

    @Test
    public void launchBrowserUsingExecutable(){

        // download executable
        System.setProperty("webdriver.chrome.driver", "/home/brahma/Downloads/chrome-linux64/chrome.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("url");

        driver.close();

    }

    @Test
    public void launchBrowserUsingWebDriverManager(){

        // download executable
        WebDriverManager.chromedriver().setup();  // method

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://kodekloud.com/sign-in");

        driver.close();

    }

    @Test
    public void launchBrowserUsingSeleniumManager(){

        // download executable
        WebDriverManager.chromedriver().setup();  // method3 Selenium 4.6.0 Selenium Manager

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://kodekloud.com/sign-in");

        driver.close();

    }
}
