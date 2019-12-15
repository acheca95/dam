package actividad2_10;
import java.sql.*;
public class ejercicio10 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");// Cargar el driver
			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/empleados", "root", "");
			// recuperar argumentos de main
			String dep = args[0]; // num. departamento
			String dnombre = args[1]; // nombre
			String loc = args[2]; // localidad
			//construir orden INSERT	        
	        String sql = String.format("INSERT INTO departamentos VALUES (%s, '%s', '%s')",
	        		dep,dnombre,loc);
	        System.out.println(sql);
			System.out.println(sql);
			Statement sentencia = conexion.createStatement();
			int filas=0;
			try {
			  filas = sentencia.executeUpdate(sql.toString());
			  System.out.println("Filas afectadas: " + filas);
			} catch (SQLException e) {
				//e.printStackTrace();
				   System.out.printf("HA OCURRIDO UNA EXCEPCI�N:%n"); 
				   System.out.printf("Mensaje   : %s %n", e.getMessage()); 
				   System.out.printf("SQL estado: %s %n", e.getSQLState()); 
				   System.out.printf("C�d error : %s %n", e.getErrorCode());	    	
			}
			sentencia.close(); // Cerrar Statement
			conexion.close(); // Cerrar conexi�n
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}