package actividades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Clientes;
import primero.HibernateUtil;
import primero.Productos;
import primero.Ventas;

public class actividad3_5 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		ArrayList<Integer> datos = new ArrayList<>();
		int opcion = Integer.parseInt(args[0]);
		
		System.out.println("=========== datos de Cliente =======");
		Clientes c = new Clientes();
		
		c = (Clientes) session.load(Clientes.class, (byte) opcion);
		System.out.printf("nombre: %s ", c.getNombre());
		System.out.printf("DIRECCION: %s ",  c.getDireccion());
		System.out.printf("POBLACION: %s ",	  c.getPoblacion());
		System.out.printf("TELEFONO:%s ",   c.getTelef());
		System.out.printf("NIF: %s ",   c.getNif());
		System.out.println("");
		System.out.println("=========== datos de Ventas =======");
		Set<Ventas> listaventa = c.getVentases();
		double total = 0;
		int ventaa = 0;
		Iterator<Ventas> it = listaventa.iterator();
		while (it.hasNext()) {
			Ventas v = it.next();
			if (v.getClientes().getId() == opcion) {
				
				double suma=v.getProductos().getPvp().doubleValue()* v.getCantidad();
				total+=suma;
				System.out.printf(" precio:  %f ", v.getProductos().getPvp().doubleValue());
				System.out.printf(" cantidad: %d ",v.getCantidad());
				System.out.printf(" importe: %f ", suma);
				System.out.println("");
				System.out.println("=========== datos de producto =======");
				System.out.printf(" DESCRIPCION: %s  ", v.getProductos().getDescripcion());
				System.out.printf(" PVP: %d  ", v.getProductos().getPvp().intValueExact());
				System.out.printf(" STOCK:%d  ",  v.getProductos().getStockactual());
				ventaa++;
			}
		}
		System.out.println("");
		System.out.println("numero total de ventas: "+ventaa);
		System.out.println("Importe total:"+total);
		session.close();
		System.exit(0);
	}
}
