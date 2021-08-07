package com.linkedin.utility;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class CsvReadAndWrite {
	String csvReadpath = "C:\\Users\\misol\\eclipse-workspace\\com.linkedin\\src\\main\\resources\\search.csv";
	String csvWritePath = "C:\\Users\\misol\\eclipse-workspace\\com.linkedin\\src\\main\\resources\\output.csv";
	private CSVReader csvReader;
	String[] csvCell;

	public String getDataForSearch() throws CsvValidationException, IOException {
		csvReader = new CSVReader(new FileReader(csvReadpath));
		String searchData = null;
		while ((csvCell = csvReader.readNext()) != null) {
			searchData = csvCell[0];
		}
		return searchData;
	}

	public String getTypeOfSearch() throws CsvValidationException, IOException {
		csvReader = new CSVReader(new FileReader(csvReadpath));
		String searchType = null;
		while ((csvCell = csvReader.readNext()) != null) {
			searchType = csvCell[1];
		}
		return searchType;
	}
	//Add output data in csv file
	public void writeOnCsv(ArrayList<String[]> array) throws IOException {
		try (CSVWriter writer = new CSVWriter(new FileWriter(csvWritePath))) {

			for (int i = 0; i < array.size(); i++) {

				writer.writeNext(array.get(i));
			}

		}
	}
	//delete all data in csv file
	public void clearCsv() throws Exception {
		FileWriter fw = new FileWriter(csvWritePath, false);
		PrintWriter pw = new PrintWriter(fw, false);
		pw.flush();
		pw.close();
		fw.close();
	}

}
