package actividades;

import java.util.Iterator;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Clientes;
import primero.Productos;
import primero.Ventas;

public class actividad3_7c {
	   public static void main(String[] args) {
	        int busqueda = 1;
	        int nVentas = 0;
	        double importee = 0.0;

	        SessionFactory sesion = HibernateUtil.getSessionFactory();
	        Session session = sesion.openSession();

	        //DATOS DEL CLIENTE
	        String hqlCliente = "from Clientes c where c.id = "+busqueda;
	       org.hibernate.Query qClientes =  session.createQuery(hqlCliente);
	        Clientes c = (Clientes) ((org.hibernate.Query) qClientes).uniqueResult();
	        System.out.println("Ventas del cliente: "+c.getNombre());
	        System.out.println("");

	        //DATOS VENTA
	        String hqlVentas = "from Ventas as v where v.clientes.id = "+busqueda;
	        org.hibernate.Query qVentas =  session.createQuery(hqlVentas);
	        Iterator it = ((org.hibernate.Query) qVentas).iterate();
	        while (it.hasNext())
	        {
	           Ventas v = (Ventas) it.next();
	           //DATOS PRODUCTO
	           primero.Productos p = v.getProductos();
	           //calculamos el importe total
	           Double importe =(double)v.getCantidad()*p.getPvp().doubleValue();
	           importee+=importe;

	           System.out.printf("Venta: %d, Fecha venta %s%n"
	                           + "\tProducto: %s%n"
	                           + "\tCantidad: %d PVP: %.2f%n"
	                           + "\tImporte: %.2f %n", 
	                           v.getIdventa(), v.getFechaventa().toString(),
	                           p.getDescripcion(),
	                           v.getCantidad(),p.getPvp(),
	                           importe);
	           nVentas++;
	        }
	        System.out.println("");
	        System.out.println("total de ventas: "+nVentas);
	        System.out.printf("importe Total: %.2f",importee);
	    }
}
