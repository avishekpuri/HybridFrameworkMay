package com.hybrid.framework.SuiteA;

import com.hybrid.framework.BaseTest;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class AnotherBasicTest extends BaseTest {
    @Test(dataProvider = "getData")
    public void anotherBasicTest(Hashtable data) {
        if (data.get("isSkip").equals("true")) {
            throw new SkipException("RunMode is set to Skip");
        }
        System.out.println(data);
        driverScript.executeKeywords(testName,data,xlsReader);
    }
}
