package actividad2_5;

public class Empleado {
private int id;
private String Apellido;
private String OFICIO;
private int DIRECCION;
private String FECHA_ALTA;
private double SALARIO;
private int COMISION;
private int DEPT_NO;

	public Empleado(int id, String Apellido, String OFICIO, int DIRECCION, String FECHA_ALTA, double SALARIO, int COMISION, int DEPT_NO) {
	this.id=id;
	this.Apellido=Apellido;
	this.OFICIO=OFICIO;
	this.DIRECCION=DIRECCION;
	this.FECHA_ALTA=FECHA_ALTA;
	this.SALARIO=SALARIO;
	this.COMISION =COMISION;
	this.DEPT_NO=DEPT_NO;
	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getOFICIO() {
		return OFICIO;
	}
	public void setOFICIO(String oFICIO) {
		OFICIO = oFICIO;
	}
	public int getDIRECCION() {
		return DIRECCION;
	}
	public void setDIRECCION(int dIRECCION) {
		DIRECCION = dIRECCION;
	}
	public String getFECHA_ALTA() {
		return FECHA_ALTA;
	}
	public void setFECHA_ALTA(String fECHA_ALTA) {
		FECHA_ALTA = fECHA_ALTA;
	}
	public double getSALARIO() {
		return SALARIO;
	}
	public void setSALARIO(double sALARIO) {
		SALARIO = sALARIO;
	}
	public int getCOMISION() {
		return COMISION;
	}
	public void setCOMISION(int cOMISION) {
		COMISION = cOMISION;
	}
	public int getDEPT_NO() {
		return DEPT_NO;
	}
	public void setDEPT_NO(int dEPT_NO) {
		DEPT_NO = dEPT_NO;
	}
	
}
