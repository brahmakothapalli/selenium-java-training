package clickAndText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClickAndTextElementTests {

    /**
     * Two types of xpaths - Absolute xpath & Relative Xpath
     *
     * example - /html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input
     * disadvantages -- time consuming, not efficient
     *
     *
     * Relative Xpath: //input[@id='user-name']
     *
     *
     *
     */


    @Test
    public void testValidateLoginScenario() throws InterruptedException {

        String username = "standard_user";
        String pwd = "secret_sauce";

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        // alt+ ENTER
        WebElement userName = driver.findElement(By.id("user-name"));

        WebElement password = driver.findElement(By.name("password"));

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='submit-button btn_action']"));

        System.out.println(loginButton.getAttribute("value"));

        userName.sendKeys(username);
        password.sendKeys(pwd);
        Thread.sleep(3000);
        loginButton.click();

        WebElement cartIcon = driver.findElement(By.id("shopping_cart_container"));

        boolean val = cartIcon.isDisplayed();

//        boolean val = false;

        Assert.assertTrue(val, "Cart Icon not displayed");

        WebElement swagLogo = driver.findElement(By.cssSelector("div.app_logo"));

        String logoText = swagLogo.getText();

        Assert.assertEquals(logoText, "Swag Labs");
    }
}
