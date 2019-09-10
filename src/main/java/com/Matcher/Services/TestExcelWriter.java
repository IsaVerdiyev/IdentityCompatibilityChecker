package com.Matcher.Services;

import com.Matcher.Interfaces.ExcelWriter;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class TestExcelWriter implements ExcelWriter {
    @Override
    public void writeInExcel() throws IOException, InvalidFormatException {
        File myFile = new File("test.xlsx");

        InputStream inputStream = new FileInputStream(myFile);
        Workbook myWorkBook = WorkbookFactory.create(inputStream);
        Sheet sheet = null;
        try {
            sheet = myWorkBook.getSheetAt(0);
        }catch (IllegalArgumentException ex){
            sheet = myWorkBook.createSheet("first sheet");
        }
        int rownum = sheet.getLastRowNum();
        CellStyle cellStyle = myWorkBook.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        Row row =  sheet.createRow(++rownum);
        int cellNum = 2;
        Cell cell = row.createCell(cellNum++);
        cell.setCellValue("Isa");
        cell = row.createCell(cellNum++);
        cell.setCellValue("Verdiyev");
        cell.setCellStyle(cellStyle);
        FileOutputStream outputStream = new FileOutputStream(myFile);
        myWorkBook.write(outputStream);
    }
}
