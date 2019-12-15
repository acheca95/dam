package comprueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class actividad4 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empleados", "root", "");
			Statement sentencia = conexion.createStatement();
			Statement sentencia2 = conexion.createStatement();

			String sql = "SELECT * FROM EMPLEADOS";

			ResultSet resul = sentencia2.executeQuery(sql);

			while (resul.next()) {
				System.out.printf("%d, %s, %n ", resul.getInt("EMP_NO"), resul.getString("APELLIDO"));

			}
			resul.close();
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
