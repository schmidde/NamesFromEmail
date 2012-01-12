package de.fhb.schmidde;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import au.com.bytecode.opencsv.CSVReader;

public class CsvReader {
	
	private char delimitter;
	private String dateiName;
	
	public CsvReader(String dateiName, char delimitter){
		this.delimitter = delimitter;
		this.dateiName = dateiName;
	}

	public List<String[]> readToList() throws IOException{
		 CSVReader reader = new CSVReader(new FileReader(dateiName), delimitter);
		    List<String[]> myEntries = reader.readAll();
		    
		    return myEntries;
	}
}
