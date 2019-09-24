package model;

import java.sql.*;


public class ModelCAD {

//	 DataSet GetRows(String rq_sql, String resultSetName) {
//		 
//		 
//		 
//		 
//		 
//	 }

	private static String URL = "jdbc:mysql://localhost/test? autoReconnect=true&useSSL=false&useUnicode=true&useJDBC"
			+ "CompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String LOGIN = "root";
	private static String PASSWORD = "";

	public Connection connection;
	public Statement statement;
	
	
	
	
	

	public static String getMAPQuery(int id) {
		return "call CALL_MAP(" + id + ");";
	}

	

	
	public ModelCAD() {

		this.connection = null;
		this.statement = null;

	}

	public boolean open() {

		System.out.println("\n\nopening a connection");

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

		System.out.println("closing a connection");

		if (connection != null)
			try {
				connection.close();
			} catch (SQLException ignore) {
			}
	}

	public String getMAp(int id) throws SQLException {

		final ResultSet resultSet = this.executeQuery(getMAPQuery(id));

		String map = "";

		if (resultSet.first()) {
			map = resultSet.getString("map");
		}

		return map;

	}

	private ResultSet executeQuery(String query_p) throws SQLException {

		ResultSet retur = this.statement.executeQuery(query_p);

		return retur;

	}
}
