package actividades;

import java.util.Iterator;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.*;
import primero.HibernateUtil;

public class actividad3_5c {
	public static void main(String args[]) {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();

		Jugadores jug = new Jugadores();
		jug = (Jugadores) session.load(Jugadores.class, (int) Integer.parseInt(args[0]));
		System.out.println("Datos del jugador: " + jug.getCodigo());
		System.out.println("Nombre: " + jug.getNombre());
		System.out.println("Equipo: " + jug.getEquipos().getNombre());
		System.out.println("Temporada   Ptos   Asis   Tap   Reb");
		System.out.println("");

		Set<Estadisticas> listajug = jug.getEstadisticases();
		Iterator<Estadisticas> it = listajug.iterator();

		while (it.hasNext()) {
			Estadisticas es = it.next();
			System.out.printf("%s %.1f  %.1f  %.1f  %.1f %n", es.getId().getTemporada(),
					es.getPuntosPorPartido(), es.getAsistenciasPorPartido(), es.getTaponesPorPartido(),
					es.getRebotesPorPartido());
		}

		System.out.println("");
		System.out.printf("Num de Registros: %d %n", listajug.size());
		System.out.println("");
		session.close();
		System.exit(0);
	}
}
