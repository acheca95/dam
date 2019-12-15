package actividad2_12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.CallableStatement;

public class ejercicio12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM",
					"pelis22");

		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public static void executeStoredProcedure(Connection conexion) throws SQLException {  
		
	
		conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM",
				"pelis22");
	    try(CallableStatement cstmt = (CallableStatement) conexion.prepareCall("{call dbo.Getsalariomedio(?)}");) {  
	        cstmt.getInt(1);  
	        cstmt.registerOutParameter(1, java.sql.Types.INTEGER);  
	        cstmt.execute();  
	        System.out.println("Salario medio: " + cstmt.getInt(1));  
	    }  
	}
}
