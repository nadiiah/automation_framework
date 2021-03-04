package com.skelia.nhryhor.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.CSVReader;

import java.io.FileReader;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(CSVFileReader.class);

    public static List<String> readFromCSVFile(String pathToFile) {
        ArrayList list = new ArrayList();

        try (CSVReader reader = new CSVReader(new FileReader(pathToFile))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                list.add(line);
            }
        } catch (CsvException | IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}


