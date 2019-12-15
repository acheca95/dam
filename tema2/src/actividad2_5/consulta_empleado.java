package actividad2_5;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class consulta_empleado {

	static String BDPer = "DBEmpleados3.yap";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPer);
		Empleado emp = new Empleado(0, null, null, 0, null, 0.0, 0, 0);
		ObjectSet<Empleado> result = db.queryByExample(emp);
		ObjectSet<Empleado> result2 = db.queryByExample(new Empleado(1, null, null, 0, null, 0.0, 0, 0));
		if (result.size() == 0) {
			System.out.println("No existen Registros de Empleados..");
		} else {
			System.out.printf("Numero de registros:%d %n", result.size());
			while (result.hasNext()) {
				Empleado e = result.next();
				
				System.out.printf(
						"ID: %s, Apellido: %s,Oficio: %s,Direccion: %s,Fecha_alta: %s,Salario: %s,Comision: %s,Numero Departamento: %s %n",
						e.getId(), e.getApellido(), e.getOFICIO(), e.getDIRECCION(), e.getFECHA_ALTA(), e.getSALARIO(),
						e.getCOMISION(), e.getDEPT_NO());
			}
			/*
			 * private int id; private String Apellido; private String OFICIO; private int
			 * DIRECCION; private String FECHA_ALTA; private double SALARIO; private int
			 * COMISION; private int DEPT_NO;
			 */
		}
		db.close();
	}
}
