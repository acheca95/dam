package actividad2_6;

import java.sql.*;

public class ejercicio6 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empleados", "root", "");
			Statement sentencia = conexion.createStatement();
			Statement sentencia2 = conexion.createStatement();
			String sql = "SELECT empleados.apellido ,empleados.salario ,departamentos.dnombre   FROM EMPLEADOS ,departamentos where empleados.salario =(SELECT MAX(empleados.salario) FROM empleados) and departamentos.dept_no=empleados.dept_no;";
			String sql2 = "SELECT * FROM EMPLEADOS";
			ResultSet resul = sentencia.executeQuery(sql);
			ResultSet resul2 = sentencia2.executeQuery(sql2);

			  while(resul.next()) {System.out.printf("%s, %.2f, %s ", resul.getString(1), resul.getFloat(2),
			  resul.getString(3));
			  System.out.println();
			  System.out.println();
			  }
			resul.close();
			sentencia.close();
			while (resul2.next()) {
				if (resul2.getInt(7) == 10) {
					System.out.printf("%d, %s, %.6f", resul2.getInt(1), resul2.getString(2), resul2.getFloat(6));
					System.out.println();
				}
			}
			resul2.close();
			sentencia2.close();
			conexion.close();
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
