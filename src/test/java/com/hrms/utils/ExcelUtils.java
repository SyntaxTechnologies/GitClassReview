package com.hrms.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {
    static Workbook book;
    static Sheet sheet;

    /**
     * @param filePath
     */
    public static void openExcel(String filePath) {

        try {
            FileInputStream fis = new FileInputStream(filePath);
            book = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param sheetName
     */
    public static void getSheet(String sheetName) {
        sheet = book.getSheet(sheetName);
    }

    /**
     * @return
     */
    public static int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    /**
     * @param rowIndex
     * @return
     */
    public static int getColsCount(int rowIndex) {
        return sheet.getRow(rowIndex).getPhysicalNumberOfCells();
    }

    public static String getCellData(int rowIndex, int colIndex) {

        return sheet.getRow(rowIndex).getCell(colIndex).toString();
    }

    public static List<Map<String, String>> excelIntoListMap(String filePath, String sheetName) {

        openExcel(filePath);
        getSheet(sheetName);

        List<Map<String, String>> listData = new ArrayList();

        for (int row = 1; row < getRowCount(); row++) {
            //creating a map for every row
            Map<String, String> map = new LinkedHashMap<>();
            //looping through all cell in the row
            for (int col = 0; col < getColsCount(row); col++) {
                //storing values from each cell into a map
                map.put(getCellData(0, col), getCellData(row, col));
            }
            //adding every map to the list
            listData.add(map);
        }

        return listData;
    }
}
