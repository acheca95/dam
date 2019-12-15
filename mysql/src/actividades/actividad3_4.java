package actividades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Departamentos;
import primero.Empleados;

public class actividad3_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Empleados emple = new Empleados();
		
		 emple = (Empleados) session.load(Empleados.class, (7369));
		System.out.printf("%s, %s, %s, %s, %n, %.2f", emple.getApellido(), emple.getOficio(), emple.getDir(),
				emple.getFechaAlta(), emple.getSalario());

		session.close();
		System.exit(0);
	}
}
