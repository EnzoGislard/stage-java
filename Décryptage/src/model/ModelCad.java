package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelCad {
	
	private String connectionUrl;
	private String login;
	private String psw;
	private Connection con;
	private Statement stmt;

	public ModelCad () {
	
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
	
	
	
	public ResultSet m_getRows (String requete) {
		
        ResultSet output = null;
		
		try {
			this.stmt = this.con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
		try {
			output = this.stmt.executeQuery(requete);
		} catch (SQLException e) {
			e.printStackTrace();
		}

        return output;	
	}	
	
	public void m_actionRows (String requete) {
		
		
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
