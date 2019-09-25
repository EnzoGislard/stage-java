package model;

import java.sql.*;

public class ModelCAD {


    private static String URL = "jdbc:mysql://localhost/bddcryptage? autoReconnect=true&useSSL=false&useUnicode=true&useJDBC"
            + "CompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String LOGIN = "root";
    private static String PASSWORD = "";

    public Connection connection;
    public Statement statement;



    public static String getIdentifiantQuery(String Utilisateur, String Password) {
        return "call Identification('" + Utilisateur + "', '" + Password + "');";
    }
    
    
    public static String getWordQuery(String word) {
        return "call donnée ('" + word + "');";
    }

    public ModelCAD() {

        this.connection = null;
        this.statement = null;

    }

    public boolean open() {

        System.out.println("opening a connection");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(ModelCAD.URL, ModelCAD.LOGIN, ModelCAD.PASSWORD);

            this.statement = this.connection.createStatement();

        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (final SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void close() {

        System.out.println("closing a connection\n");

        if (connection != null)
            try {
                connection.close();
            } catch (SQLException ignore) {
            }
    }



    public String getIdentifiant(String Utilisateur, String Password) throws SQLException {

    	String output;
    	
        ResultSet resultSet = this.executeQuery(getIdentifiantQuery(Utilisateur, Password));

        if (resultSet.next()) {

            output = resultSet.getString("Utilisateurs");

            return output;

        } else {

            return "false";
        }
        
    }
    
    
    public String getWord(String word) throws SQLException {

    	String output;
    	
        ResultSet resultSet = this.executeQuery(getWordQuery(word));

        if (resultSet.next()) {

            output = resultSet.getString("donnee");

            return output;

        } else {
            
            return "false";
        }
        
    }

    private ResultSet executeQuery(String query_p) throws SQLException {

        ResultSet retur = this.statement.executeQuery(query_p);

        return retur;

    }
}