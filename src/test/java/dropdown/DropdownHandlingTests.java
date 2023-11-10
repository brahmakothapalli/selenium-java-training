package dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropdownHandlingTests {

    @Parameters("{browser}")
    @Test(groups = {"smoke"})
    public void testSelectDropdownValues() {

        String username = "standard_user";
        String pwd = "secret_sauce";
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='submit-button btn_action']"));
        userName.sendKeys(username);
        password.sendKeys(pwd);
        loginButton.click();
        System.out.println("test");

        // Dropdowns two -- Select Tag,
        //              --- Non Select Tage
        WebElement filterDropdown = driver.findElement(By.xpath("//select[@data-test='product_sort_container']"));

        Select select = new Select(filterDropdown);

        // count of the options
        List<WebElement> allOptions = select.getOptions();

        System.out.println("Options count in dropdown --- " +allOptions.size());

        // print all option names
        for (WebElement opt :allOptions) {
            System.out.println(opt.getText());
        }

        // fetch selected option
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        System.out.println("Selected option --- "+firstSelectedOption.getText());

        // select an option

        //using index
//        select.selectByIndex(3);

        //using visible text
//        select.selectByVisibleText("Price (low to high)");

        //using value
        select.selectByValue("za");
    }

    @Test
    public void testSelectDropdownValuesBootstrap() {

        WebDriver driver = new ChromeDriver();
        driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
        driver.manage().window().maximize();

        WebElement dropdown = driver.findElement(By.id("menu1"));

        dropdown.click();

        List<WebElement> allOptions = driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li"));

        System.out.println("Count of the options -- "+allOptions.size());

        for (WebElement opt: allOptions) {
            String text = opt.getText();
            if(text.contentEquals("JavaScript")){
                opt.click();
                break;
            }
        }
    }
}
