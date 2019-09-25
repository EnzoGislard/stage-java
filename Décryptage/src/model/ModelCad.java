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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {
            	
				this.con = DriverManager.getConnection(connectionUrl, login, psw);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	
	public ResultSet m_getRows (String requette) {
		
        ResultSet output = null;
		
		try {
			this.stmt = this.con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
        
		try {
			output = this.stmt.executeQuery(requette);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return output;
	
	}
	
	 
	
	
	public void m_actionRows (String requette) {
		
		
		try {
			this.stmt = this.con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			this.stmt.executeUpdate(requette);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
