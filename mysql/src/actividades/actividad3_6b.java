package actividades;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import primero.Clientes;
import primero.Productos;
import primero.Ventas;

public class actividad3_6b {

	public static void main(String[] args) {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		// productos
		String[] descripciones = new String[2];
		int[] stockmin = new int[2];
		int[] stockmax = new int[2];
		double[] pvp = new double[2];
		descripciones[0] = "producto de prueba a";
		descripciones[1] = "producto de prueba b";
		descripciones[2] = "producto de prueba c";
		stockmin[0] = 22;
		stockmin[1] = 33;
		stockmin[2] = 44;
		stockmax[0] = 55;
		stockmax[1] = 66;
		stockmax[2] = 77;
		pvp[0] = 10.05;
		pvp[1] = 20.05;
		pvp[2] = 30.05;
		Productos p = new Productos();
		// productos
		// ventas
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date[] fecha = new Date[2];
		fecha[0] = date;
		fecha[1] = date;
		fecha[2] = date;
		int[] idcli = new int[2];
		idcli[0] = 1;
		idcli[1] = 2;
		idcli[2] = 3;
		int[] idprod = new int[2];
		idprod[0] = 4;
		idprod[1] = 5;
		idprod[2] = 6;
		int[] cant = new int[2];
		cant[0] = 8;
		cant[1] = 8;
		cant[2] = 8;
		int[] vent = new int[2];
		vent[0] = 1;
		vent[0] = 2;
		vent[0] = 3;
		// ventas
		// Clientes
		String[] nom = new String[2];
		nom[0] = "JOSE GUTIERREZ";
		nom[1] = "MARIA PEREZ";
		nom[2] = "ANTONIO CHECA";
		String[] dir = new String[2];
		dir[0] = "C/falsa 123";
		dir[1] = "C/falsa 456";
		dir[2] = "C/falsa 789";
		String[] pob = new String[2];
		pob[0] = "Jaen";
		pob[1] = "Jaen";
		pob[2] = "Jaen";
		String[] tel = new String[2];
		tel[0] = "949876655";
		tel[1] = "949876655";
		tel[2] = "949876655";
		String[] nif = new String[2];
		nif[0] = "X6968240E";
		nif[1] = "X8254984P";
		nif[2] = "Z2776992T";

		// clientes
		
		Productos pro = new Productos();
		Productos pro1 = new Productos();
		Productos pro2 = new Productos();
		Clientes cli = new Clientes();
		Clientes cli1 = new Clientes();
		Clientes cli2 = new Clientes();
		Ventas v = new Ventas();
		Ventas v1 = new Ventas();
		Ventas v2 = new Ventas();
		Ventas com = session.load(Ventas.class, (short) vent[0]);
		Ventas com1 = session.load(Ventas.class, (short) vent[1]);
		Ventas com2 = session.load(Ventas.class, (short) vent[2]);
		if (com.getIdventa() == vent[0]) {
			System.out.println("la venta ya existe");
		} else if (com1.getIdventa() == vent[1]) {
			System.out.println("la venta ya existe");
		} else if (com2.getIdventa() == vent[2]) {
			System.out.println("la venta ya existe");
		} else {
			if (stockmax[0] - cant[0] >= stockmin[0]) {
				pro.setId((byte) 9);
				pro.setDescripcion(descripciones[0]);
				pro.setStockminimo(stockmin[0]);
				pro.setStockactual(stockmax[0]);
				pro.setPvp(BigDecimal.valueOf(pvp[0]));

				session.save(pro);

				cli.setDireccion(dir[0]);
				cli.setId((byte) 5);
				cli.setNif(nif[0]);
				cli.setNombre(nom[0]);
				cli.setPoblacion(pob[0]);
				cli.setTelef(tel[0]);

				session.save(cli);
				
				v.setIdventa((short) 6);
				v.setFechaventa(fecha[0]);
				v.setClientes(cli);
				v.setProductos(pro2);
				v.setCantidad((byte) cant[0]);
				session.save(v);

			} else {
				System.out.println("no hay suficiente stock");
			}
			if (stockmax[1] - cant[1] >= stockmin[1]) {
				pro1.setId((byte) 10);
				pro1.setDescripcion(descripciones[1]);
				pro1.setStockminimo(stockmin[1]);
				pro1.setStockactual(stockmax[1]);
				pro1.setPvp(BigDecimal.valueOf(pvp[1]));
				session.save(pro1);

				cli1.setDireccion(dir[1]);
				cli1.setId((byte) 6);
				cli1.setNif(nif[1]);
				cli1.setNombre(nom[1]);
				cli1.setPoblacion(pob[1]);
				cli1.setTelef(tel[1]);

				session.save(cli1);
				
				v1.setIdventa((short) 7);
				v1.setFechaventa(fecha[1]);
				v1.setClientes(cli1);
				v1.setProductos(pro1);
				v1.setCantidad((byte) cant[1]);
				session.save(v1);

			} else {
				System.out.println("no hay suficiente stock");
			}
			if (stockmax[2] - cant[2] >= stockmin[2]) {
				pro2.setId((byte) 11);
				pro2.setDescripcion(descripciones[2]);
				pro2.setStockminimo(stockmin[2]);
				pro2.setStockactual(stockmax[2]);
				pro2.setPvp(BigDecimal.valueOf(pvp[2]));
				session.save(pro2);

				cli2.setDireccion(dir[2]);
				cli2.setId((byte) 6);
				cli2.setNif(nif[2]);
				cli2.setNombre(nom[2]);
				cli2.setPoblacion(pob[2]);
				cli2.setTelef(tel[2]);
				session.save(cli);

				v2.setIdventa((short) 8);
				v2.setFechaventa(fecha[2]);
				v2.setClientes(cli1);
				v2.setProductos(pro1);
				v2.setCantidad((byte) cant[2]);
				session.save(v2);

				
			} else {

				System.out.println("no hay suficiente stock");
			}
		}
		tx.commit();
		session.close();
		System.exit(0);
	}
}