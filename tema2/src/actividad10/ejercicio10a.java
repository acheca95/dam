package actividad10;

import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ejercicio10a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Date date = new Date();
			DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd");
			String empleado = args[0];
			String apellido = args[1];
			String oficio = args[2];
			String dir = args[3];
			String fecha = fechaHora.format(date);
			String salario = args[4];
			String departamento = args[5];
			boolean direxiste = false;
			boolean id = false;
			boolean dep = false;
			

			Class.forName("com.mysql.jdbc.Driver"); // Cargar el driver
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empleados", "root", "");
			//
			Statement sentencia2 = conexion.createStatement();
			String sql2 = "SELECT emp_no, dir ,dept_no FROM empleados";
			Statement sentencia = conexion.createStatement();
			ResultSet resul2 = sentencia2.executeQuery(sql2);

			while (resul2.next()) {

				if (resul2.getInt(1) == Integer.parseInt(empleado)) {
					id = true;
				} else if (resul2.getInt(2) == Integer.parseInt(dir)) {
					direxiste = true;
				} else if (resul2.getInt(3) == Integer.parseInt(departamento)) {
					dep = true;
				}
			}
			if (dep == false) {
				System.out.println("el departamento no existe.");
			} else if (direxiste == false) {
				System.out.println("el director no existe.");
			} else if (Double.parseDouble(salario) <= 0) {
				System.out.println("salario incorrecto.");
			} else if (id == true) {
				System.out.println("el id del empleado ya existe.");
				id = true;
			} else if (id == false && direxiste == true && dep == true && Double.parseDouble(salario) >= 0 && apellido!=null && oficio!=null) {
				String sql = String.format("insert into empleados values (%s, '%s', '%s', '%s', '%s', '%s', '%s')",
						empleado, apellido, oficio, dir, fecha, salario, departamento);

				int filas = sentencia.executeUpdate(sql);
				// System.out.printf("Filas afectadas: %d %n", filas);
				sentencia.close();
			}
			else if (apellido==null || oficio==null && apellido=="" || oficio=="") {
				System.out.println("el apellido o el oficio estan vacios.");
				id = true;
			}
			//

			sentencia2.close();
			conexion.close();

		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
