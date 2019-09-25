package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.ModelMapDic;

import model.ModelCad;

public class ControllerGestionDesMots {

	public boolean testerUnMot(String mot, ModelCad cad) {

		//ModelCad cad = new ModelCad();
		ModelMapDic dictionnaire = new ModelMapDic();

		ResultSet output = cad.m_getRows(dictionnaire.m_trouverMot(mot));

		String outputString = "";

		try {
			while (output.next()) {
				outputString = output.getString("donnee");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		//cad.close();
		
		if (outputString != "") {
			return true;
		}
		else {
			return false;
		}
	}

}
