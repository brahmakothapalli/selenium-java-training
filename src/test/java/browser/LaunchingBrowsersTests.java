package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class LaunchingBrowsersTests {

    // launching different browsers
    @Test
    public void testLaunchAmazonChrome(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

        String url = driver.getCurrentUrl();
        System.out.println("Current url is "+url);

        String title = driver.getTitle();
        System.out.println("Title of the page "+title);

        driver.close();
    }

    // launching different browsers
    @Test
    public void testLaunchAmazonEdge(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

        String url = driver.getCurrentUrl();
        System.out.println("Current url is "+url);

        String title = driver.getTitle();
        System.out.println("Title of the page "+title);

        driver.close();
    }

    @Test
    public void testLaunchAmazonFirefox(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

        String url = driver.getCurrentUrl();
        System.out.println("Current url is "+url);

        String title = driver.getTitle();
        System.out.println("Title of the page "+title);

        driver.close();
    }

    // browser navigation

    @Test
    public void testBrowserNavigation() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.navigate().to("https://www.amazon.in/");


        driver.manage().window().maximize();

        Thread.sleep(3000);

        driver.navigate().refresh(); // to refresh the page
        System.out.println("Browser is refreshed");

        Thread.sleep(3000);

        driver.navigate().back();
        System.out.println("Browser navigated back");

        Thread.sleep(3000);

        driver.navigate().forward();
        System.out.println("Browser navigated forward");

        driver.close();
    }
}
