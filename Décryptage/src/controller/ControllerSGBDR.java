package controller;

import java.sql.SQLException;

import model.ModelCAD;

public class ControllerSGBDR {

	ModelCAD CAD;
	
	public ControllerSGBDR (){
		
		CAD = new ModelCAD();
	}
	
	
	

	public Boolean contactDictionnary(String word) {
		 
		String output;
		 
		
		CAD.open();
		
		
		try {
			output = CAD.getWord(word);
			
			if (output.equals(word)) {
				
				System.out.println("Le mot est pas dans le dictionnaire");
				CAD.close();
				return true;
			}
			else if (output.equals("false")){
				
				System.out.println("Le mot n'est pas dans le dictionnaire");
				CAD.close();
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CAD.close();
		
		return false;
	}
	
	
	
	
	
	
	public Boolean pcs_authentifier(String login, String password) {
		 
		String output;
		 
		
		CAD.open();
		
		
		try {
			output = CAD.getIdentifiant(login, password);
			
			if (output.equals(login)) {
				
				System.out.println("Utilisateur trouvé!");
				CAD.close();
				return true;
			}
			else if (output.equals("false")){
				
	            System.out.println("Mauvais utilisateur ou mauvais mot de passe");
				CAD.close();
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CAD.close();
		
		return false;
	}
	

}
