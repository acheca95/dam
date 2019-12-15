package actividad2_11;
import java.sql.*;
import java.text.DecimalFormat;
public class ejercicio11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empleados", "root", "");
			DecimalFormat df = new DecimalFormat("#.00");
			// recuperar parametros de main
			String dep = args[0];
			// construimos la orden SELECT
			String sql = "SELECT empleados.apellido,empleados.oficio,empleados.salario, departamentos.dnombre FROM empleados,departamentos WHERE empleados.dept_no in(SELECT departamentos.dept_no from departamentos where departamentos.dept_no=?)  AND departamentos.dept_no=empleados.dept_no ORDER BY 1";
			int count = 0;
			double media = 0;
			// Preparamos la sentencia
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1, Integer.parseInt(dep));
			ResultSet rs = sentencia.executeQuery();
			while (rs.next()) {
				System.out.printf("%s %s %s %s ", rs.getString("apellido"), rs.getString("oficio"),
						rs.getDouble("salario"), rs.getString("dnombre"));
				System.out.println();
				count++;
				media += rs.getDouble("salario");
			}
			if (count == 0) {
				System.out.println(" el departamento no existe");
			}
			if (media > 0) {
				media = media / count;
				System.out.println("numero de empleados: " + count + " media del salario: " + df.format(media));
			}
			rs.close();// liberar recursos
			sentencia.close();
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}