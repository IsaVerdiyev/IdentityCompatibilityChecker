package com.Matcher.Interfaces;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.EOFException;

public interface ExcelService {
    public boolean checkCompatibility(Sheet sheet, int rowNum, int cellNum) throws EOFException;
    public void changeBackgroundOfCell(Sheet sheet, int rowNum, int cellNum,  CellStyle cellStyle);
}
