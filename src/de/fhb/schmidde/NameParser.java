package de.fhb.schmidde;

public class NameParser {

	private CsvReader cr;
	
	private String standardPreName = "";
	private String standardName = "";
	
	private String regex1 = "[a-zA-Z]{1,}\\.[a-zA-Z]{3,}@[0-9a-z\\-\\.]*\\.[a-z]{2,3}";
	private String regex2 = "[a-zA-Z]{1,}\\-[a-zA-Z]{3,}@[0-9a-z\\-\\.]*\\.[a-z]{2,3}";
	private String regex3 = "[a-zA-Z]{1,}\\_[a-zA-Z]{3,}@[0-9a-z\\-\\.]*\\.[a-z]{2,3}";
	
	public NameParser(){}
	public NameParser(String standardPreName, String standardName){
		this.standardPreName = standardPreName;
		this.standardName = standardName;
	}
	
	public String[] parse(String email){
		String[] names = {standardPreName, standardName};
		String[] zeile = new String[3];
		
		if(email.matches(regex1)){
			names = split(email, ".");
			zeile[0] = names[0];
			zeile[1] = names[1];
			zeile[2] = email;
		}
		else if(email.matches(regex2)){
			names = split(email, "-");
			zeile[0] = names[0];
			zeile[1] = names[1];
			zeile[2] = email;
		}
		else if(email.matches(regex3)){
			names = split(email, "_");
			zeile[0] = names[0];
			zeile[1] = names[1];
			zeile[2] = email;
		}
		else {
			zeile[0] = names[0];
			zeile[1] = names[1];
			zeile[2] = email;
		}
		
		System.out.println(zeile[0] + " " + zeile[1] + "\t\t" + zeile[2]);
		return zeile;
	}
	private String[] split(String email, String delimitter){
		
		Character first;
		String splits[], names[], fullName;
		
		splits = email.split("\\@");
		fullName = splits[0];
		names = fullName.split("\\"+delimitter);
		
		//Anfangsbuchstaben werden Grossbuchstaben
		for(int i = 0; i < names.length; i++){
			
			first = names[i].charAt(0);
			if(first.isLowerCase(first)){
				first = first.toUpperCase(first);
				names[i] = names[i].replaceFirst("[a-z]", first.toString(first));
			}
		}
		
		return names;
	}
}
