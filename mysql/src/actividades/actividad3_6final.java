package actividades;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import primero.Clientes;
import primero.Productos;
import primero.Ventas;

public class actividad3_6final {

	public static void main(String[] args) {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();

		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Clientes cli = new Clientes();
		Productos pro = new Productos();
		Ventas v = new Ventas();
		Ventas ventaas = new Ventas();
		Clientes cliente1 = new Clientes();
		Productos producto2 = new Productos();
		int cantidad = 10;
		System.out.println("introduce una opcion:");
		System.out.println("1: añadir cliente ,2:añadir producto,3:añadir venta,4:salir");
		Scanner reader = new Scanner(System.in);
		String sTexto = reader.next();
		switch (sTexto) {
		case "1":

			// añadir producto
			int id = 6;
			pro.setId(id);
			pro.setDescripcion("producto prueba a");
			pro.setStockminimo(9);
			pro.setStockactual(20);
			pro.setPvp(BigDecimal.valueOf(25.0));

			if (pro.getStockactual() > pro.getStockminimo()) {
				session.save(pro);
			} else {
				System.out.println("el stock no es suficente");
			}
			break;
		case "2":
			// añadir cliente
			cli.setId((byte) 1);
			cli.setDireccion("calle falsa 123");
			cli.setNif("34343434g");
			cli.setNombre("pepe");
			cli.setPoblacion("jaen");
			cli.setTelef("633282542");

			session.save(cli);
			break;
		case "3":
			if (pro.getId() == 0) {
				pro.setId((byte) 4);
				// se comprueba que el producto exista
				producto2 = (Productos) session.get(Productos.class, (Integer) 4);
				System.out.print(producto2.getDescripcion());
				
				if (producto2 == null) {
					System.out.println("el producto no existe");
				}
			}
			if (cli.getId() == 0) {
				cli.setId((byte) 4);
				// se comprueba que el cliente exista
				cliente1 = (Clientes) session.get(Clientes.class, (byte) 4);
				System.out.print(cliente1.getNombre());
				if (cliente1 == null) {
					System.out.println("el Cliente no existe");
				}
			}

			if (cliente1 != null && producto2 != null) {
				// añadir añadir venta
				ventaas = (Ventas) session.get(Ventas.class, (short) 7);
				if (ventaas==null) {
					if (producto2.getStockactual() - cantidad >= producto2.getStockminimo()) {
						v.setIdventa((short) 7);
						v.setFechaventa(date);
						v.setClientes(cliente1);
						v.setProductos(producto2);
						v.setCantidad((byte) 10);
						
						session.save(v);
						tx.commit();
						
						session.close();
						System.exit(0);
					} else {
						System.out.println("el stock no es suficiente");
					}
				} else {
					System.out.println("la venta ya existe");
				}

			} else
				System.out.println("no se ha podido realizar la inseccion de la venta");

			break;
		case "4":
			System.out.println("Salir");
			break;
		}
	}

}
