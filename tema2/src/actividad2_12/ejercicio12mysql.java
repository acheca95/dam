package actividad2_12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.CallableStatement;

public class ejercicio12mysql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver"); // Cargar el driver
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empleados", "root", "");
			executeStoredProcedure(conexion);
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void executeStoredProcedure(Connection conexion) throws SQLException {

		conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empleados", "root", "");
		try (CallableStatement cstmt = (CallableStatement) conexion
				.prepareCall("{call dbo.Getsalariomedio(?)}");) {
			cstmt.getInt(1);
			cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
			cstmt.execute();
			System.out.println("MANAGER ID: " + cstmt.getInt(2));
		}
	}
}
