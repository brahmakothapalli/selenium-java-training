package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupsDemoTests extends BaseTest{


    @BeforeMethod
    public void setUp(){
        System.out.println("Browser launch");
        System.out.println("App Login");
    }

    @Test(groups = {"smoke"})
    public void testProductSearch(){
        System.out.println("Product searched successfully");
    }

    @Test(priority = 1)
    public void testAddToCart(){
        System.out.println("Product added successfully");
    }

    @Test(priority = 2)
    public void testCheckout(){
        System.out.println("Product checked-out successfully");
    }

    @Test(groups = {"smoke"})
    public void testProductSearch2(){
        System.out.println("Product searched successfully2");
    }

    @Test(priority = 1)
    public void testAddToCart2(){
        System.out.println("Product added successfully2");
    }

    @Test(priority = 2, groups = {"smoke"})
    public void testCheckout2(){
        System.out.println("Product checked-out successfully2");
    }


    @AfterMethod
    public void closeBrowser(){
        System.out.println("App logout");
        System.out.println("close browser");
    }



}
