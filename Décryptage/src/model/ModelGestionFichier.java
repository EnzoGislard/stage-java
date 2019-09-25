package model;

import java.io.*;
// 	
public class ModelGestionFichier {

	private String text;
	
	public ModelGestionFichier() {

	}

	public String getData(String file) {

		// The name of the file to open.
		String fileName = file;

		// This will reference one line at a time
		String line = null;

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				
				if(text != null)
					text = text + line;
				else
					text = line;
			}

			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
		return text;
	}

	
	public void setData(String file, String filename)
		  throws IOException {

			    BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
			    writer.write(file);
			     
			    writer.close();
	}
}
