package hooks;

import loggerUtility.LoggerUtility;
import extentUtility.ExtentUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import propertyUtility.PropertyUtility;

public class Hooks {

    private String testName;
    public PropertyUtility propertyUtility;

    @BeforeSuite
    public void prepareSuite(){
        ExtentUtility.initiateReport();
    }

    @BeforeMethod
    public void prepareTest(){
        testName = this.getClass().getSimpleName();
        LoggerUtility.startTestCase(testName);
        ExtentUtility.startTest(testName);
    }

    @AfterMethod
    public void clearTest(){
        LoggerUtility.finishTestCase(testName);
        ExtentUtility.finishTest(testName);
    }

    @AfterSuite
    public void clearSuite(){
        ExtentUtility.generateReport();
    }
}
