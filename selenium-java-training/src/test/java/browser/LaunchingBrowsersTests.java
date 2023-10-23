package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class LaunchingBrowsersTests {

    // launching different browsers
    @Test
    public void testLaunchAmazonChrome(){
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
        WebDriver driver = new EdgeDriver();
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
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.navigate().refresh(); // to refresh the page

        Thread.sleep(3000);

        driver.navigate().back();



//        driver.close();
    }
}
