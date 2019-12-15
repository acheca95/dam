package actividades;

import primero.Estadisticas;
import primero.EstadisticasId;
import primero.Jugadores;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class actividad3_7c {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int id;
		String Temporada;
		Float puntosp;
		Float asistenciasp;
		Float taponesp;
		Float rebotesp;

		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("introduce el id del jugador :");
		id = Integer.parseInt(reader.readLine());
		Jugadores j = (Jugadores) session.get(Jugadores.class, (Integer) id);

		if (id < 0 || id > 999 || j == null) {
			System.out.println("el id es invalido");
		} else {
			System.out.println("introduce  los puntos por partido :");
			puntosp = Float.parseFloat(reader.readLine());
			if (puntosp < 0.0 || puntosp > 999.99) {
				System.out.println("puntos no validos");
			} else {
				System.out.println("introduce  las asistencias por partido :");
				asistenciasp = Float.parseFloat(reader.readLine());
				if (asistenciasp < 0.0 || asistenciasp > 999.99) {
					System.out.println("aistencias no validas");
				} else {
					System.out.println("introduce  los tapones por partido :");
					taponesp = Float.parseFloat(reader.readLine());
					if (taponesp < 0.0 || taponesp > 999.99) {
						System.out.println("tapones no validos");
					} else {
						System.out.println("introduce  los rebotes por partido :");
						rebotesp = Float.parseFloat(reader.readLine());
						if (rebotesp < 0.0 || rebotesp > 999.99) {
							System.out.println("rebotes no validos");
						} else {
							System.out.println("introduce la temporada :");
							Temporada = reader.readLine();

							if (id < 0 || id > 999) {

								System.out.println("el id es invalido");
							} else {
								if (Integer.parseInt(Temporada.substring(0, 2)) < 00
										|| Integer.parseInt(Temporada.substring(0, 2)) > 99
												&& Integer.parseInt(Temporada.substring(3, 5)) < 00
										|| Integer.parseInt(Temporada.substring(3, 5)) > 99) {
									System.out.println("temporada invalida");
								} else {
									Estadisticas Comprobacion = (Estadisticas) session.get(Estadisticas.class,
											new EstadisticasId(Temporada, id));
									if (Comprobacion.getId().getTemporada() == null) {
										// introducimos las estadisticas
										Estadisticas estadisticas = new Estadisticas();
										estadisticas.setId(new EstadisticasId(Temporada, id));
										estadisticas.setJugadores(j);
										estadisticas.setPuntosPorPartido(puntosp);
										estadisticas.setRebotesPorPartido(rebotesp);
										estadisticas.setTaponesPorPartido(taponesp);
										session.save(estadisticas);
										// fin introduccion
										tx.commit();
										session.close();
										System.out.println("insertado correctamente");
									} else {
										System.out.println("La estadistica ya existe");
									}

								}

							}
						}
					}

				}

			}

		}
	}

}