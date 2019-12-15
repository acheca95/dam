package actividades;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import primero.Departamentos;
import primero.Empleados;
import actividades.HibernateUtil;

public class actividad3_6 {

	public static void main(String[] args) {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
	
		Departamentos dep = (Departamentos) session.get(Departamentos.class, (byte) 10);
		if (dep == null) {
			System.out.println("El departamento NO existe");
		} else {
			@SuppressWarnings("unchecked")
			Set<Empleados> lista = dep.getEmpleadoses();
			Iterator<Empleados> it = lista.iterator();
			while (it.hasNext()) {
				Empleados emp = it.next();
				System.out.printf("Apellido: %s,salario antiguo: %.2f ", emp.getApellido(),emp.getSalario(),"\n");
				float NuevoSalario = emp.getSalario() + 3.0f;
				emp.setSalario(NuevoSalario);
				session.update(emp);
				System.out.println("");
				System.out.printf("Salario nuevo: %.2f ",emp.getSalario(),"\n");
				System.out.println("");
				
			}
		}
		tx.commit();
		
		session.close();
		System.exit(0);
	}
}