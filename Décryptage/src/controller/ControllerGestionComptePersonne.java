package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.ModelCad;
import model.ModelMapPersonne;

public class ControllerGestionComptePersonne {
	
	
	
	public ResultSet m_listerLesCompte () {
		
		
		ModelCad cad = new ModelCad();
		ModelMapPersonne personne = new ModelMapPersonne();
		
		ResultSet output = cad.m_getRows(personne.m_select());
		
		cad.close();
		
		return output;
	}

	
	
	public Boolean testerCompte (String name, String password) {
		
		ModelCad cad = new ModelCad();
		
		ModelMapPersonne personne = new ModelMapPersonne();
		
		ResultSet output = cad.m_getRows(personne.m_selectSpecifique(name, password));
		
		String outputString = "";
		
		try {
			while (output.next()) {
				outputString = output.getString("Utilisateurs");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		cad.close();
		
		if (outputString != "") {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public void m_CreeUnCompte (String name, String firstName) {
		
		ModelCad cad = new ModelCad();
		ModelMapPersonne personne = new ModelMapPersonne();
		
		personne.setName(name);
		personne.setFirstName(firstName);
		
	
		cad.m_actionRows(personne.m_insert());
		
		cad.close();
		
	}
	
	
	
}
