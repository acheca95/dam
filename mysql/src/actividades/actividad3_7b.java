package actividades;

import java.util.Iterator;
import java.util.Set;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Clientes;
import primero.Departamentos;
import primero.Empleados;
import primero.HibernateUtil;
import primero.Ventas;

public class actividad3_7b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		/*
		 * 
		 * String hql = "from Empleados where empNo = :numemple"; Query q =
		 * session.createQuery(hql); q.setParameter("numemple", (short) 7369);
		 */
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		String hql = "select productos.descripcion,productos.stockactual,productos.stockminimo,productos.pvp,\r\n" + 
				"ventas.fechaventa,ventas.cantidad,clientes.nombre\r\n" + 
				" from Ventas as ventas where ventas.clientes.id=1";
		org.hibernate.Query q = session.createQuery(hql);
		q.setParameter("idcliente", (byte) 2);
		Ventas v = (Ventas) q.uniqueResult();
		System.out.println("=========== datos de Cliente =======");
		Clientes c = new Clientes();

		System.out.printf("nombre: %s ", v.getClientes().getNombre());
		System.out.printf("DIRECCION: %s ", v.getClientes().getDireccion());
		System.out.printf("POBLACION: %s ", v.getClientes().getPoblacion());
		System.out.printf("TELEFONO:%s ", v.getClientes().getTelef());
		System.out.printf("NIF: %s ", v.getClientes().getNif());
		System.out.println("");
		System.out.println("=========== datos de Ventas =======");

		double suma = v.getProductos().getPvp().doubleValue() * v.getCantidad();
		System.out.printf(" precio:  %f ", v.getProductos().getPvp().doubleValue());
		System.out.printf(" cantidad: %d ", v.getCantidad());
		System.out.printf(" importe: %f ", suma);
		System.out.println("");
		System.out.println("=========== datos de producto =======");
		System.out.printf(" DESCRIPCION: %s  ", v.getProductos().getDescripcion());
		System.out.printf(" PVP: %d  ", v.getProductos().getPvp().intValueExact());
		System.out.printf(" STOCK:%d  ", v.getProductos().getStockactual());
		session.close();
		System.exit(0);
	}

}
