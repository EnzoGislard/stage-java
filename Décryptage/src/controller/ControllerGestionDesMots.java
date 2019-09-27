package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

//import model.ModelMapDic;

import model.ModelCad;

public class ControllerGestionDesMots {

	public boolean testerUnMot(String mot, ModelCad cad) {

		ResultSet output = cad.m_getRows(mot);

		String outputString = "";

		try {
			while (output.next()) {
				outputString = output.getString("donnee");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (outputString != "") {
			return true;
		}
		else {
			return false;
		}
	}

}
