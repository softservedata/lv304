package com.softserve.edu;

import org.testng.annotations.Test;

public class TestNGTest4 {
    
    @Test(timeOut = 1010)
    public void infinity() {
        long currentTime = System.currentTimeMillis();
        long beginTime = currentTime;
        long printTime = currentTime;
        while (currentTime - beginTime < 2000) {
            currentTime = System.currentTimeMillis();
            if (currentTime - printTime > 100) {
                printTime = currentTime;
                System.out.println("Working = " + (currentTime - beginTime));
            }
        }
        System.out.println("Working = " + (currentTime - beginTime));
    }
}
