package com.softserve.edu;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample {
    
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("\t@BeforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("\t@AfterSuite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("\t\t@BeforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("\t\t@AfterTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("\t\t\t@BeforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("\t\t\t@AfterClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("\t\t\t\t@BeforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("\t\t\t\t@AfterMethod");
    }

    @Test
    public void testMethod1() {
        System.out.println("\t\t\t\t\t@Test testMethod1()");
    }

    @Test
    public void testMethod2() {
        System.out.println("\t\t\t\t\t@Test testMethod2()");
    }

}
