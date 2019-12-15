package primero;
// Generated 27-nov-2019 22:57:50 by Hibernate Tools 5.3.6.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Productos generated by hbm2java
 */
public class Productos implements java.io.Serializable {

	private int id;
	private String descripcion;
	private Integer stockactual;
	private Integer stockminimo;
	private BigDecimal pvp;
	private Set ventases = new HashSet(0);

	public Productos() {
	}

	public Productos(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public Productos(int id, String descripcion, Integer stockactual, Integer stockminimo, BigDecimal pvp,
			Set ventases) {
		this.id = id;
		this.descripcion = descripcion;
		this.stockactual = stockactual;
		this.stockminimo = stockminimo;
		this.pvp = pvp;
		this.ventases = ventases;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getStockactual() {
		return this.stockactual;
	}

	public void setStockactual(Integer stockactual) {
		this.stockactual = stockactual;
	}

	public Integer getStockminimo() {
		return this.stockminimo;
	}

	public void setStockminimo(Integer stockminimo) {
		this.stockminimo = stockminimo;
	}

	public BigDecimal getPvp() {
		return this.pvp;
	}

	public void setPvp(BigDecimal pvp) {
		this.pvp = pvp;
	}

	public Set getVentases() {
		return this.ventases;
	}

	public void setVentases(Set ventases) {
		this.ventases = ventases;
	}

}
