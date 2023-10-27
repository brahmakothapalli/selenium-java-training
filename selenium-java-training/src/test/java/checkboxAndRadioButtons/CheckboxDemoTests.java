package checkboxAndRadioButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CheckboxDemoTests {

    @Test
    public void testCheckboxSelection(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();

        WebElement chkBox1 = driver.findElement(By.xpath("(//form[@id='checkboxes']/input)[1]"));

        WebElement chkBox2 = driver.findElement(By.xpath("(//form[@id='checkboxes']/input)[2]"));

        // checking a checkbox
        chkBox1.click();

        System.out.println("Checkbox1 is selected ? --- "+chkBox1.isSelected());

        // uncheck a checkbox
        chkBox2.click();

        System.out.println("Checkbox2 is selected ? --- "+chkBox2.isSelected());


    }


    @Test
    public void testRadioButtonsSelection(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/radio.html");
        driver.manage().window().maximize();

        WebElement firstRadioButton = driver.findElement(By.id("vfb-7-1"));

        WebElement secondRadioButton = driver.findElement(By.id("vfb-7-2"));

        System.out.println("firstRadioButton is selected before clicking? --- "+firstRadioButton.isSelected());

        // selecting a radio button
        firstRadioButton.click();

        System.out.println("firstRadioButton is selected after clicking? --- "+firstRadioButton.isSelected());

        System.out.println("secondRadioButton is selected? --- "+secondRadioButton.isSelected());






    }
}
