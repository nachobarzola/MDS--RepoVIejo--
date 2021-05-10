package mds.trabajopractico.sistemabecasalimentarias.domain;

public class Direccion {
	private Integer id;
	private String domicilio;
	private String localidad;
	private String codigoPostal;
	public Direccion(Integer id, String domicilio, String localidad, String codigoPostal) {
		super();
		this.id = id;
		this.domicilio = domicilio;
		this.localidad = localidad;
		this.codigoPostal = codigoPostal;
	}
	public Direccion() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	@Override
	public String toString() {
		return "Direccion [id=" + id + ", domicilio=" + domicilio + ", localidad=" + localidad + ", codigoPostal="
				+ codigoPostal + "]";
	}
	
	
}
