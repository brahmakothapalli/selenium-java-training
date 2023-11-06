package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigDemoTest {

    String configFilePath = "/home/brahma/qababuworks/selenium-java-training/selenium-java-training/src/test/configuration.properties";
    static Properties prop;
    static FileInputStream fis;
    String browser;
    String appUrl;
    String userid;
    String pwd;

    WebDriver driver = null;

    public static Properties readConfigFile(String filePath) throws IOException {
        prop = new Properties();
        fis = new FileInputStream(filePath);
        prop.load(fis);
        return prop;
    }

    @BeforeClass
    public void setUp() throws IOException {
        System.out.println("Reading configuration :: setUp");
        prop =ReadConfigDemoTest.readConfigFile(configFilePath);
        appUrl = prop.get("appUrl").toString();
        browser = prop.get("browser").toString();
        userid = prop.get("user").toString();
        pwd = prop.get("password").toString();
    }

    @BeforeMethod
    public void browserInitialize(){
        System.out.println("Initializing browser :: browserInitialize");
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();  // method
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            System.out.println("Unsupported browser is given");
        }
        driver.manage().window().maximize();
        driver.get(appUrl);
    }


    @Test
    public void testPrintTitle() {
        String title = driver.getTitle();
        System.out.println(title);
    }

    @Test
    public void testPrintUrl() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
    }


    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @AfterMethod
    public void closeFile() throws IOException {
        prop.clear();
        fis.close();
    }
}
