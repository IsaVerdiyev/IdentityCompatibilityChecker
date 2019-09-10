package com.Matcher.Services;

import com.Matcher.Interfaces.ExcelNamesChecker;
import com.Matcher.Interfaces.ExcelService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class TestExcelNamesChecker implements ExcelNamesChecker {
    @Value("${startRow}")
    int startRow;
    @Value("${startCell}")
    int startCell;

    @Autowired
    ExcelService excelService;

    public TestExcelNamesChecker(ExcelService excelService) {
        this.excelService = excelService;
    }

    @Override
    public void checkExcel(String pathToResource) {
        InputStream inputStream = null;
        try {
            File myFile = new File(pathToResource);

             inputStream = new FileInputStream(myFile);
            Workbook workbook = WorkbookFactory.create(inputStream);
            int row = startRow;
            int cell = startCell;
            CellStyle greenCellStyle = workbook.createCellStyle();
            greenCellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
            greenCellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

            CellStyle redCellStyle = workbook.createCellStyle();
            redCellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
            redCellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

            Sheet sheet = workbook.getSheetAt(0);

            try{
                while (true) {

                    if(excelService.checkCompatibility(sheet, row, cell)){
                        excelService.changeBackgroundOfCell(sheet, row, cell, greenCellStyle);
                    }
                    else{
                        excelService.changeBackgroundOfCell(sheet, row, cell, redCellStyle);
                    }
                    row++;
                }
            }catch (EOFException ex){
                FileOutputStream outputStream = new FileOutputStream(myFile);
                workbook.write(outputStream);
            }

        }catch (InvalidFormatException e) {
           throw new RuntimeException("InvalidFormatException occured in checkExcel of TestExcelNamesChecker", e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("FileNotFoundException occured in checkExcel of TestExcelNamesChecker", e);
        } catch (IOException e) {
            throw new RuntimeException("IOException occured in checkExcel of TestExcelNamesChecker", e);
        }
    }
}
