package com.softserve.edu;

import org.testng.annotations.AfterClass;

public abstract class TestRunner {

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        System.out.println("*****@AfterClass for " + this.getClass().getName());
    }

}
