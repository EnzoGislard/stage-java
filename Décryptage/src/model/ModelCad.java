package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelCad {

	private String connectionUrl;
	private String login;
	private String psw;
	private Connection con;
	private Statement stmt;

	public ModelCad() {

		this.connectionUrl = "jdbc:mysql://localhost/bddcryptage? autoReconnect=true&useSSL=false&useUnicode=true&useJDBC"
				+ "CompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		this.login = "root";
		this.psw = "";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			this.con = DriverManager.getConnection(connectionUrl, login, psw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet m_getRows (String identifiant, String password) {
		
        ResultSet output = null;
        PreparedStatement statement = null;
        
		try {
			statement = con.prepareStatement("call Identification(?,?)");
			statement.setObject(1,identifiant); 
			statement.setObject(2, password); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			output = statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return output;
        
	}
        
	public ResultSet m_getRows(String mot) {

		ResultSet output = null;
		PreparedStatement statement;

		try {
			statement = con.prepareStatement("call Donnée(?)");
			statement.setObject(1, mot);
			output = statement.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

//		try {
//			statement = this.con.createStatement();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		try {
//			output = this.stmt.executeQuery(requete);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		return output;
	}

	public void m_actionRows(String requete) {

		try {
			this.stmt = this.con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {

			this.stmt.executeUpdate(requete);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {

		if (con != null)
			try {
				con.close();
			} catch (SQLException ignore) {
			}
	}

}
