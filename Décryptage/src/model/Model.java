package model;

import model.ModelDecrypt;

public class Model{

	public ModelGestionFichier modelGestionFichier;
	public ModelDecrypt modelDecrypt;
	
	public Model() {
		
		modelDecrypt = new ModelDecrypt();

		modelGestionFichier = new ModelGestionFichier();
		
	}
	
	

	
}
