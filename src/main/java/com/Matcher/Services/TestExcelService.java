package com.Matcher.Services;

import com.Matcher.Interfaces.Comparer;
import com.Matcher.Interfaces.ExcelService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.EOFException;

@Service
public class TestExcelService implements ExcelService {

    @Autowired
    Comparer comparer;

    @Override
    public boolean checkCompatibility(Sheet sheet, int rowNum, int cellNum) throws EOFException {
        Row row = sheet.getRow(rowNum);
        if(row == null){
            throw new EOFException();
        }
        Cell checkedCell = row.getCell(cellNum);
        //checkedCell.setCellType(Cell.CELL_TYPE_STRING);
        if(checkedCell == null){
            throw  new EOFException();
        }
        String checkedString = checkedCell.getStringCellValue();
        Cell expectedCell = row.getCell(cellNum + 1);
        //expectedCell.setCellType(Cell.CELL_TYPE_STRING);
        String expectedString = expectedCell.getStringCellValue();
        return comparer.match(checkedString, expectedString);
    }

    @Override
    public void changeBackgroundOfCell(Sheet sheet, int rowNum, int cellNum, CellStyle cellStyle) {
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(cellNum);
        cell.setCellStyle(cellStyle);
    }
}
