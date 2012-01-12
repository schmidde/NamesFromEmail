package de.fhb.schmidde;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;

public class CsvWriter {

	private String fileName;
	private char delimitter;
	
	public CsvWriter(String fileName, char delimitter){
		this.fileName = fileName;
		this.delimitter = delimitter;
	}
	public void writeToFile(List<String[]> names) throws IOException{
		
		CSVWriter writer = new CSVWriter(new FileWriter(fileName), delimitter, CSVWriter.NO_QUOTE_CHARACTER);
	    
	    writer.writeAll(names);
		writer.close();
	}
	
}
