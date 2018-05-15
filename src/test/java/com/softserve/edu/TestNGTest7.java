package com.softserve.edu;

import java.util.Vector;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGTest7 {

    @DataProvider(name = "Data-Provider-Function")
    public Object[][] parameterIntTestProvider() {
        return new Object[][] {
                { Vector.class, new String[] { "java.util.AbstractList", "java.util.AbstractCollection" } },
                { String.class, new String[] { "1", "2" } },
                { Integer.class, new String[] { "3", "4" } },
                { Double.class, new String[] { "5", "6", "7" } },
                { Long.class, new String[] { "8", "9" } } };
    }

    @Test(dataProvider = "Data-Provider-Function")
    public void parameterIntTest(Class<?> clzz, String[] numbers) {
        System.out.println("Class clzz = " + clzz.getName());
        for (String current : numbers) {
            System.out.println("Parameterized, current = " + current);
        }
    }
}
