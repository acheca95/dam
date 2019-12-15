package actividad2_5;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
public class consulta {
	static String BDPer= "DBEmpleados3.yap";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectContainer db= Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDPer);
		Departamento dep= new Departamento(0,null,null);
		Empleado emp=new Empleado(0, null, null, 0, null, 0.0, 0, 0);
		ObjectSet<Empleado> result2 = db.queryByExample(emp);
		ObjectSet<Departamento> result= db.queryByExample(dep);
		if(result.size()==0) {
			System.out.println("No existen Registros de Departamentos..");
		}
		else {
			
			//System.out.printf("Numero de registros:%d %n",result.size());
			while(result.hasNext()) {
				Departamento d=result.next();
				if(d.getId()==10)
				{
				System.out.printf("Nombre: %s",d.getNombre());
				System.out.println();
				System.out.println();
				}
			}
		}
	
		if (result2.size() == 0) {
			System.out.println("No existen Registros de Empleados..");
		} else {
		//	System.out.printf("Numero de registros:%d %n", result2.size());
			while (result2.hasNext()) {
				Empleado e = result2.next();
				if(e.getDEPT_NO()==10) {
				System.out.printf("ID: %s, Apellido: %s,Oficio: %s,Direccion: %s,Fecha_alta: %s,Salario: %s,Comision: %s,Numero Departamento: %s %n", e.getId(), e.getApellido(),
						e.getOFICIO(),e.getDIRECCION(),e.getFECHA_ALTA(),e.getSALARIO(),e.getCOMISION(),e.getDEPT_NO());
			}
			}
		db.close();
	}
	}
}
