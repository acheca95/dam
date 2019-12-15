package actividades;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import primero.Equipos;
import primero.Estadisticas;

import primero.EstadisticasId;
import primero.Jugadores;

import primero.Partidos;
import java.util.Set;

import javax.management.Query;

import primero.*;

public class actividad3_6c {

	public static void main(String args[]) throws IOException {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
	
		Query q = (Query) session.createQuery("from Equipos order by nombre");
		List<Equipos> lista = ((org.hibernate.Query) q).list();
		Iterator<Equipos> iter = lista.iterator();
		System.out.printf("Numero de equipos: %d %n", lista.size());

		
		System.out.println("------------------");
		Equipos eq = (Equipos) iter.next();
		System.out.printf("Equipo: %s %n", eq.getNombre());

		Query q2 = (Query) session.createQuery("from Jugadores where equipos=:param");

		((org.hibernate.Query) q2).setParameter("param", eq);
		List<Jugadores> lista2 = ((org.hibernate.Query) q2).list();
		Iterator<Jugadores> iter2 = lista2.iterator();
		while (iter2.hasNext()) {
			Jugadores jug = (Jugadores) iter2.next();
			Query q3 = (Query) session
					.createQuery("select avg(puntosPorPartido) from Estadisticas where jugadores=:param2");
			((org.hibernate.Query) q3).setParameter("param2", jug);
			Double media = (Double) ((org.hibernate.Query) q3).uniqueResult();
			System.out.printf("%d, %s:  %.2f %n", jug.getCodigo(), jug.getNombre(), media);
			session.close();
		}
		System.out.println("------------------");
	}

}
