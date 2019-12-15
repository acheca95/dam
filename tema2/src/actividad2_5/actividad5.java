package actividad2_5;


import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
public class actividad5 {

	static String BDPer= "DBEmpleados3.yap";
	
	public static void main(String[] args) {
		Departamento d1 = new Departamento(10,"Sistemas","sevilla");
		Departamento d2 = new Departamento(20,"Gestion","sevilla");
		Departamento d3 = new Departamento(30,"BIG DATA","sevilla");
		Departamento d4 = new Departamento(40,"Evolutivo","sevilla");
		
	ObjectContainer db= Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDPer);
	Empleado e1=new Empleado(1,"perez","peon",1234,"2019-12-17",700.25,321,10);
	Empleado e2=new Empleado(2,"lopez","D.B M",433,"2019-12-17",500.25,321,20);
	Empleado e3=new Empleado(3,"martinez","S.D.",4334,"2019-12-17",5500.25,321,30);
	Empleado e4=new Empleado(4,"saez","Junior",3234,"2019-12-17",4500.25,321,40);
	Empleado e5=new Empleado(5,"guilen","Senior",453234,"2019-12-17",3500.25,321,20);
	Empleado e6=new Empleado(6,"parra","Project M",5344,"2019-12-17",2500.25,321,30);
	Empleado e7=new Empleado(7,"rosa","R.R H.H.",8976,"2019-12-17",900.25,321,10);
	Empleado e8=new Empleado(8,"checa","Sistemas",23131,"2019-12-17",1100.25,321,40);
	Empleado e9=new Empleado(9,"lomas","Front end D",977,"2019-12-17",1200.25,321,20);
	Empleado e10=new Empleado(10,"mesa","Seguridad",74665,"2019-12-17",1300.25,321,30);
	db.store(e1);
	db.store(e2);
	db.store(e3);
	db.store(e4);
	db.store(e5);
	db.store(e6);
	db.store(e7);
	db.store(e8);
	db.store(e9);
	db.store(e10);
	db.store(d1);
	db.store(d2);
	db.store(d3);
	db.store(d4);
	
	db.close();
	
	}

}
