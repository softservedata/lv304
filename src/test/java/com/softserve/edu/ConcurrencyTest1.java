package com.softserve.edu;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class ConcurrencyTest1 {
    private Map<String, String> data = new HashMap<String, String>();

    @Test(threadPoolSize = 3, invocationCount = 4, invocationTimeOut = 10000)
    public void testMapOperations() throws Exception {
        //
        data.put("1_" + Thread.currentThread().getId(), "1_" + Thread.currentThread().getId());
        data.put("2_" + Thread.currentThread().getId(), "2_" + Thread.currentThread().getId());
        data.put("3_" + Thread.currentThread().getId(), "3_" + Thread.currentThread().getId());
        data.put("4_" + Thread.currentThread().getId(), "4_" + Thread.currentThread().getId());
        data.put("5_" + Thread.currentThread().getId(), "5_" + Thread.currentThread().getId());
        //
        for (Map.Entry<String, String> entry : data.entrySet()) {
            System.out.println(entry);
        }
        data.clear();
        System.out.println("***done id = " + Thread.currentThread().getId());
    }
}