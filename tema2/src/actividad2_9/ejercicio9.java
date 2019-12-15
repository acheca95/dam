package actividad2_9;
import java.sql.*;

public class ejercicio9 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // Cargar el driver
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/empleados", "root", "");
			Statement sentencia = conexion.createStatement();
			ResultSet rs = sentencia
					.executeQuery("SELECT * FROM empleados");
			ResultSetMetaData md = rs.getMetaData();
			int nColumnas = md.getColumnCount();
			String nula;
			System.out.printf("Numero de columnas: %d%n", nColumnas);
			for (int i = 1; i <= nColumnas; i++) {
				System.out.printf("Columna %d: %n ", i);
				System.out.printf("Nombre: %s %n   Tipo: %s %n ",
						 md.getColumnName(i),  md.getColumnTypeName(i));
				if (md.isNullable(i) == 0)
					nula = "NO";
				else
					nula = "SI";
				System.out.printf("Puede ser nula?: %s %n ", nula);			
				System.out.printf("Maximo ancho de la columna: %d %n",
						 md.getColumnDisplaySize(i));
			}
			sentencia.close();
			rs.close();
			conexion.close();
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
