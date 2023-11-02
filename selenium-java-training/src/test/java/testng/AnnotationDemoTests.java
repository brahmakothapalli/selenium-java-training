package testng;

import org.testng.annotations.*;

public class AnnotationDemoTests {

    @BeforeClass
    public void beforeClassMethod(){
        System.out.println("Connecting to DB");
    }


    @BeforeMethod
    public void setUp(){
        System.out.println("Browser launch");
        System.out.println("App Login");
    }

    @Test()
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

    @AfterMethod
    public void closeBrowser(){
        System.out.println("App logout");
        System.out.println("close browser");
    }

    @AfterClass
    public void afterClassMethod(){
        System.out.println("Disconnect to DB");
    }

}
