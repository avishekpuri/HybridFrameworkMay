package com.hybrid.framework.SuiteB;

import com.hybrid.framework.BaseTest;
import org.testng.annotations.Test;

public class BasicTest extends BaseTest {
    @Test
    public void basicTest() {
        System.out.println("This is " + testName + " from " + suiteName);
    }
}