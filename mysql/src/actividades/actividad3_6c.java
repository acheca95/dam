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

public class actividad3_6c {

	public static void main(String[] args) {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();

		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Clientes cli = new Clientes();
		Productos pro = new Productos();
		Ventas com=new Ventas();
		Ventas v = new Ventas();
		com = (Ventas)session.get(Ventas.class, (short) 6);
		if (com == null) {
			if (20 - 9 >= 7) {
				pro.setId((byte) 9);
			
				pro.setDescripcion("producto prueba a");
				pro.setStockminimo(9);
				pro.setStockactual(20);
				pro.setPvp(BigDecimal.valueOf(25.0));

				session.save(pro);

				cli.setDireccion("calle falsa 123");
				cli.setId((byte) 5);
				cli.setNif("34343434g");
				cli.setNombre("pepe");
				cli.setPoblacion("jaen");
				cli.setTelef("633282542");

				session.save(cli);

				v.setIdventa((short) 6);
				v.setFechaventa(date);
				v.setClientes(cli);
				v.setProductos(pro);
				v.setCantidad((byte) 10);
				session.save(v);

			} else {
				System.out.println("no hay suficiente stock");
			}
		} else {
	
			System.out.println("la venta ya existe");
		}
		tx.commit();
		session.close();
		System.exit(0);
	}
}
