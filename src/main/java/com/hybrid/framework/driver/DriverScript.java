package com.hybrid.framework.driver;

import com.hybrid.framework.keywords.GenericKeywords;
import com.hybrid.framework.util.XLS_Reader;

import java.util.Hashtable;

public class DriverScript {
    public GenericKeywords actions = null;
    String sheetName = "Keywords";

    public void executeKeywords(
            String testName,
            Hashtable testData,
            XLS_Reader xlsReader
    ) {
        actions = new GenericKeywords();
        for (int rowNum = 2; rowNum < xlsReader.getRowCount(sheetName); rowNum++) {
            String tcid = xlsReader.getCellData(sheetName, "TCID", rowNum);
            if (tcid.equals(testName)) {
                String keyword = xlsReader.getCellData(sheetName, "Keyword", rowNum);
                String object = xlsReader.getCellData(sheetName, "Object", rowNum);
                String data = xlsReader.getCellData(sheetName, "Data", rowNum);
                if (keyword.equals("openBrowser")) {
                    actions.openBrowser();
                } else if (keyword.equals("navigate")) {
                    actions.navigate();
                } else if (keyword.equals("click")) {
                    actions.click();
                } else if (keyword.equals("type")) {
                    actions.type();
                }
            }
        }
    }
}
