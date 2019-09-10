package com.Matcher;

import com.Matcher.Interfaces.Comparer;
import com.Matcher.Interfaces.ExcelNamesChecker;
import com.Matcher.Interfaces.ExcelWriter;
import com.Matcher.Services.TestExcelWriter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Value("${excelName}")
    String excelName;

    @Autowired
    private ExcelNamesChecker excelNamesChecker;

    private Logger LOG = LoggerFactory
            .getLogger(Main.class);


    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }


    @Override
    public void run(String... args) throws IOException, InvalidFormatException {


        excelNamesChecker.checkExcel(excelName);
    }
}
