package actividad10;
import java.sql.*;
public class ejercicio10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String dep=args[0];
			String dnombre=args[1];
			String loc=args[2];
			// conexion a ORACLE
			
			/*  Class.forName ("oracle.jdbc.driver.OracleDriver"); Connection
			  conexion = DriverManager.getConnection
			  ("jdbc:oracle:thin:@localhost:1521:XE", "ejemplo", "ejemplo");
			*/

			Class.forName("com.mysql.jdbc.Driver"); // Cargar el driver
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/empleados", "root", "");
             
			String sql =String.format("insert into departamentos values (%s, '%s', '%s')",dep,dnombre,loc);
			Statement sentencia = conexion.createStatement();
			int filas=sentencia.executeUpdate(sql);
			System.out.printf("Filas afectadas: %d %n", filas);
			
			sentencia.close();
			conexion.close();

		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
