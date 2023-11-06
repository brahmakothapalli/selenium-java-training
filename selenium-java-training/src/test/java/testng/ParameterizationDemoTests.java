package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizationDemoTests {

    @Parameters({"browser", "userid", "password", "test-env"})
    @Test
    public void launchBrowserUsingWebDriverManager(String browser, String user, String pwd, String env){

        System.out.println("Browser is -- "+browser);

        System.out.println("Browser is -- "+user);

        System.out.println("Browser is -- "+pwd);

        String appUrl = null;

        if(env.equalsIgnoreCase("QA")){
            appUrl = "QA URL";
        }else{
            appUrl = "Stage URL";
        }

        WebDriver driver = null;        

        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();  // method
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else{
            System.out.println("Unsupported browser is given");
        }
        // cross-browser testing
        assert driver != null:"Browser is not initilialized";
        driver.manage().window().maximize();
        //driver.get(appUrl);
        driver.get("https://kodekloud.com/sign-in");
        driver.close();

    }

    @Parameters({"browser", "userid"})
    @Test
    public void launchBrowserUsingWebDriverManager2(@Optional("firefox") String browser, @Optional("nani") String user){

        System.out.println("Browser is -- "+browser);

        System.out.println("User is -- "+user);

        // download executable
        WebDriverManager.chromedriver().setup();  // method

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://kodekloud.com/sign-in");

        driver.close();

    }


}
