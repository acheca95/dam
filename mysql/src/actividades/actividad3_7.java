package actividades;

import java.util.Iterator;
import java.util.Set;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import antlr.collections.List;
import primero.Departamentos;
import primero.Empleados;
import primero.HibernateUtil;

public class actividad3_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		String hql="select departamentos from Departamentos as departamentos where departamentos.deptNo=20";
			org.hibernate.Query q = session.createQuery(hql);
		Departamentos dep = (Departamentos) q.uniqueResult();
		System.out.printf("nombre: %s ", dep.getDnombre());
		System.out.println();
		Set<Empleados> lista = dep.getEmpleadoses();
		Iterator<Empleados> it = lista.iterator();
		while (it.hasNext()) {
			Empleados emp = it.next();
			System.out.printf("Apellido: %s,salario : %.2f ", emp.getApellido(),emp.getSalario(),"\n");
			System.out.println();
		}
		session.close();
		System.exit(0);
	}
		
	}

