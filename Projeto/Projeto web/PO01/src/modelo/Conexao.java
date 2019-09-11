package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static Connection con;

	public static Connection getConexao(){


		if(con == null){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost/locadora?useSSL=false";
				con =  DriverManager.getConnection(url, "root","Root");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}


			
		}
		return con;

	}
}
