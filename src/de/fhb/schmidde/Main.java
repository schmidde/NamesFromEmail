package de.fhb.schmidde;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		if(args.length > 2){
			String in = args[0];
			String out = args[1];
			char deli = args[2].toCharArray()[0];
			
			CsvReader cr = new CsvReader(in, deli);
			CsvWriter cw = new CsvWriter(out, deli);
			NameParser np;
			
			if(args.length == 4){
				np = new NameParser("", args[3]);
			}
			else if(args.length == 5){
				np = new NameParser(args[3], args[4]);
			}
			else{
				np = new NameParser("Portal", "Nutzer");
			}
			
			List<String[]> allNames = new ArrayList();
			String[] head = {"Vorname", "Name", "Email"};
			allNames.add(head);
			
			try {
				int i = 0;
				for(String[] s: cr.readToList()){
					allNames.add(np.parse(s[0]));
					i++;
				}
				cw.writeToFile(allNames);
				System.out.println("Gesamt: " + i);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			System.out.println("Bitte Parameter angeben.");
			System.out.println("InputFile.csv OutputFile.csv Delimitter");
			System.out.println("oder");
			System.out.println("InputFile.csv OutputFile.csv Delimitter StandardName");
			System.out.println("oder");
			System.out.println("InputFile.csv OutputFile.csv Delimitter StandardVorname StandardName");
		}
	}

}
