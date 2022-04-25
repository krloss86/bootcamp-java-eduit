package clase20;

import java.util.Date;
import java.util.Objects;

//clase inmutable
public class Venta {

	private Long idVendedor;
//	private Vendedor vendedor;
	private Date fecha;
	private Double monto;
	
	public Venta(String venta) {
		
	}
	
	public Venta(Long idVendedor, Date fecha, Double monto) {
		super();
		this.idVendedor = idVendedor;
		this.fecha = fecha;
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public Double getMonto() {
		return monto;
	}

	public void setIdVendedor(Long idVendedor) {
		this.idVendedor = idVendedor;
	}

	public Long getIdVendedor() {
		return idVendedor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha, idVendedor, monto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venta other = (Venta) obj;
		return this.idVendedor.equals(other.getIdVendedor());
	}

	
	//lase20.Venta@2d6eabae hashCode por defecto
	
	//hashCode|equals
	
}
