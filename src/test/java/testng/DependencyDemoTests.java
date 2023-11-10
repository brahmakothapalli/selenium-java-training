package testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DependencyDemoTests extends BaseTest{


    @BeforeMethod
    public void setUp(){
        System.out.println("Browser launch");
        System.out.println("App Login");
    }

    @Test()
    public void testProductSearch(){
        System.out.println("Product searched successfully");
        Assert.fail();
    }

    @Test(priority = 1, dependsOnMethods = {"testProductSearch"})
    public void testAddToCart(){
        System.out.println("Product added successfully");
    }

    @Test(priority = 2)
    public void testCheckout(){
        System.out.println("Product checked-out successfully");
    }


    @AfterMethod
    public void closeBrowser(){
        System.out.println("App logout");
        System.out.println("close browser");
    }



}
