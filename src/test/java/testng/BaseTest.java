package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void configReadMethod(){
        System.out.println("reading config");
    }

    @BeforeClass
    public void beforeClassMethod(){
        System.out.println("Connecting to DB");
    }


    @AfterClass
    public void afterClassMethod(){
        System.out.println("Disconnect to DB");
    }
}
