package comprueba;

import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class actividad6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tipo = Integer.parseInt(args[0]);
		int id = Integer.parseInt(args[1]);
		int idcli = Integer.parseInt(args[2]);
		int idpro = Integer.parseInt(args[3]);
		int cantidad = Integer.parseInt(args[4]);
		boolean id1 = false;
		boolean id2 = false;
		boolean id3 = false;
		Date date = new Date();
		DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd");
		String fecha = fechaHora.format(date);
		Connection conexion = null;
		try {
			if (tipo == 1) {
				Class.forName("com.mysql.jdbc.Driver");
				conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/unidad2", "root", "");
			}
			if (tipo == 2) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "pelis22");
			}
			if (tipo == 3) {
				Class.forName("com.mysql.jdbc.Driver");
				conexion = DriverManager.getConnection("jdbc:sqlite:C:/sqlite/unidad2.db");
			}

			String sql1 = "SELECT id FROM productos";
			String sql2 = "SELECT id FROM clientes";
			String sql3 = "SELECT IDVENTA FROM ventas";
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery(sql1);
			while (resul.next()) {
				if (resul.getInt(1) == id) {
					System.out.println("el id del producto ya existe.");
					id1 = true;
				}
			}
			ResultSet resul2 = sentencia.executeQuery(sql2);
			while (resul2.next()) {
				if (resul2.getInt(1) == id) {
					System.out.println("el id del cliente ya existe.");
					id2 = true;
				}
			}
			ResultSet resul3 = sentencia.executeQuery(sql3);
			while (resul3.next()) {
				if (resul3.getInt(1) == id) {
					System.out.println("el id de la venta ya existe.");
					id3 = true;
				}
			}
			if(cantidad<=0) {
				System.out.println("la cantidad es incorrecta");
			}
			if (id1 == false && id2 == false && id3 == false && cantidad > 0) {

				String sql = String.format("insert into ventas values (%i ,'%s', '%i', '%i', '%i',)", id, fecha, idcli,
						idpro, cantidad);
				int filas = sentencia.executeUpdate(sql);
				System.out.printf("Filas afectadas: %d %n", filas);

			}
			resul.close();
			resul2.close();
			resul3.close();
			sentencia.close();
			conexion.close();
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
