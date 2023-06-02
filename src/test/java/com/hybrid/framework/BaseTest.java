package com.hybrid.framework;

import com.hybrid.framework.driver.DriverScript;
import com.hybrid.framework.util.XLS_Reader;
import org.testng.annotations.*;

import java.util.Hashtable;

public class BaseTest {
    public String testName;
    public String suiteName;
    public DriverScript driverScript;
    public XLS_Reader xlsReader = null;
    @BeforeTest
    public void beforeTest() {
        testName = this.getClass().getSimpleName();
        suiteName = getSuiteName();
        driverScript = new DriverScript();
        String projectDirectory = System.getProperty("user.dir");
        String testResourcesDirectory = projectDirectory + "/src/test/resources/";
        System.out.println(testResourcesDirectory + "Suites/" + suiteName + ".xlsx");
        xlsReader = new XLS_Reader(testResourcesDirectory + "Suites/" + suiteName + ".xlsx");
    }

    @AfterTest
    public void afterTest() {
    }

    @BeforeMethod
    public void beforeMethod() {

    }

    @AfterMethod
    public void afterMethod() {
//        System.out.println("Closing Browser");
//        System.out.println("==================================");
    }

    public String getSuiteName() {
        String[] packageName = this.getClass().getName().split("\\.");
        return packageName[packageName.length-2];
    }

    @DataProvider
    public Object[] getData() {
        String sheetName = "TestData";
        int testStartRowNum = 1;
        //TestName
        // Iterate on each cell of Col1
        while(!(xlsReader.getCellData(sheetName, 0, testStartRowNum).equalsIgnoreCase(testName))) {
            testStartRowNum++;
        }

        int colNameRowNum = testStartRowNum+1;
        int testDataStartRowNum = colNameRowNum + 1;

        int testDataColCount = 0;
        while (!xlsReader.getCellData(sheetName, testDataColCount, colNameRowNum).equals("")) {
            testDataColCount++;
        }

        int testDataRowCount = 0;
        while (!xlsReader.getCellData(sheetName, 0, testDataStartRowNum + testDataRowCount).equals("")) {
            testDataRowCount++;
        }


        Object[] testDataSets = new Object[testDataRowCount];
        for (int rowNum = 0; rowNum < testDataRowCount; rowNum++) {
            Hashtable dataTable = new Hashtable<>();
            for (int colCount = 0; colCount < testDataColCount; colCount++) {
                String key = xlsReader.getCellData(sheetName, colCount, colNameRowNum);
                String value = xlsReader.getCellData(sheetName, colCount, rowNum + testDataStartRowNum);
                dataTable.put(key, value);
            }
            testDataSets[rowNum] = dataTable;
        }
        return testDataSets;
    }
}
