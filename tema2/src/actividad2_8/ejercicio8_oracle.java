package actividad2_8;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;  

public class ejercicio8_oracle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName ("oracle.jdbc.driver.OracleDriver"); 
			Connection conexion = DriverManager.getConnection
			  ("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM","pelis22");
			DatabaseMetaData dbmd = conexion.getMetaData();
			ResultSet resul = null;
			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();

			System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS: ");
			System.out.println("=================================== ");
			System.out.printf("Nombre : %s %n", nombre);
			System.out.printf("Driver : %s %n", driver);
			System.out.printf("URL 	  : %s %n", url);
			System.out.printf("Usuario: %s %n", usuario);
			resul = dbmd.getTables(null, "empleados", null, null);
			while (resul.next()) {
				String catalogo = resul.getString(1);
				String esquema = resul.getString(2);
				String tabla = resul.getString(3);
				String tipo = resul.getString(4);
				System.out.printf("%s - Catalogo: %s,Esquema: %s, Nombre: %s %n", tipo, catalogo, esquema, tabla);
			}
			conexion.close();
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
