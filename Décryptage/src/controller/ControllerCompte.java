package controller;

import model.ModelCAD;

public class ControllerCompte {

	
	
	public Boolean pcs_authentifier(String login, String password) {
		 
		 
		
		
		
		
		
		
		ModelCAD CAD;
		 
		
		CAD = new ModelCAD();
		
		CAD.open();
		
		
		
		
		 
		CAD.close();
	
		return true;
		 
	}
	

}
