package com.hybrid.framework.SuiteA;

import com.hybrid.framework.BaseTest;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class BasicTest extends BaseTest {
    @Test(dataProvider = "getData")
    public void basicTest(Hashtable data) {
        if (data.get("isSkip").equals("true")) {
            throw new SkipException("RunMode is set to Skip");
        }
        System.out.println(data);
    }
}
