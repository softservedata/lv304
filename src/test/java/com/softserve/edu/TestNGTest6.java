package com.softserve.edu;

import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGTest6 {
    
    @BeforeClass
    public void beforeClass(ITestContext context) {
        HashMap<String, String> allParameters = new HashMap<String, String>(
                context.getCurrentXmlTest().getAllParameters());
        for (String key : allParameters.keySet()) {
            System.out.println("*** parameter: key=" + key + " value=" + allParameters.get(key));
        }
        System.out.println("@BeforeClass");
    }
    
    @AfterClass(alwaysRun = true)
    public void afterClass() {
        System.out.println("*****@AfterClass for " + this.getClass().getName());
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("***@AfterMethod");
        //throw new RuntimeException("HaHaHA");
    }

    //@AfterMethod(alwaysRun = true)
    //public void afterMethod(ITestResult testResult) {
    //}
        
    @Test
    @Parameters(value = "number")
    public void parameterIntTest(int number) {
        System.out.println("Parameterized Number is: " + number);
    }

    @Test
    public void parameterFromPom() {
        System.out.println("Parameter from pom: " + System.getProperty("parameter.to.test"));
        //throw new RuntimeException("HaHaHA");
    }

    
}
