package com.hybrid.framework.SuiteB;

import com.hybrid.framework.BaseTest;
import org.testng.annotations.Test;

public class AnotherBasicTest extends BaseTest {
    @Test
    public void anotherBasicTest() {
        System.out.println("This is " + testName + " from " + suiteName);
    }
}