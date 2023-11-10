package frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class FramesDemoTests {

    @Test
    public void testSwitchingIframes() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[text()='iFrame']")).click();

        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        // empty list - if no elements found

        if(iframes.isEmpty()){
            System.out.println("There are no frames on the page");
        }else{
            System.out.println("There are frames on the page");
        }

        //switching to the frame using ID
        driver.switchTo().frame("mce_0_ifr");

        String expectedText = driver.findElement(By.id("tinymce")).getText();
        System.out.println(expectedText);

        // switching back to main page
        driver.switchTo().defaultContent();

        WebElement elementalSelenium = driver.findElement(By.xpath("(//a)[3]"));
        String elementalSeleniumText = elementalSelenium.getText();
        System.out.println(elementalSeleniumText);

        driver.close();
    }

    @Test
    public void testSwitchingNestedFrames() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.manage().window().maximize();

        // clicking nested frames link
        driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();

        List<WebElement> frames = driver.findElements(By.tagName("frame"));
        // empty list - if no elements found
        if(frames.isEmpty()){
            System.out.println("There are no frames on the page");
        }else{
            System.out.println("There are frames on the page and number of frames = "+frames.size());
        }

        //switching to top frame
        driver.switchTo().frame("frame-top");
        List<WebElement> childFramesOnTopFrame = driver.findElements(By.tagName("frame"));
        System.out.println(childFramesOnTopFrame.size());

        // switching to middle frame
        driver.switchTo().frame(1);
        String middleFrameText = driver.findElement(By.id("content")).getText();
        System.out.println(middleFrameText);
        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-top");
        //switching to right frame
        driver.switchTo().frame(2);
        String rightFrameText = driver.findElement(By.tagName("body")).getText();
        System.out.println(rightFrameText);

        driver.switchTo().defaultContent();
        // switching to bottom frame
        driver.switchTo().frame("frame-bottom");
        String bottomFrameText = driver.findElement(By.tagName("body")).getText();
        System.out.println(bottomFrameText);
        driver.quit();

    }
}
