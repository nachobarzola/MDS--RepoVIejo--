package mds.trabajopractico.sistemabecasalimentarias.domain;

public class ProgenitorTutor {
	private String nombre;
	private String apellido;
	private Double ingresoNeto;
	private Integer edad;
	private String ocupacion;
	private String lugarDeTrabajo;
	private Boolean convive;
	
	
	public ProgenitorTutor(String nombre, String apellido, Double ingresoNeto, Integer edad, String ocupacion,
			String lugarDeTrabajo, Boolean convive) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.ingresoNeto = ingresoNeto;
		this.edad = edad;
		this.ocupacion = ocupacion;
		this.lugarDeTrabajo = lugarDeTrabajo;
		this.convive = convive;
	}


	public ProgenitorTutor() {
		super();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Double getIngresoNeto() {
		return ingresoNeto;
	}


	public void setIngresoNeto(Double ingresoNeto) {
		this.ingresoNeto = ingresoNeto;
	}


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public String getOcupacion() {
		return ocupacion;
	}


	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}


	public String getLugarDeTrabajo() {
		return lugarDeTrabajo;
	}


	public void setLugarDeTrabajo(String lugarDeTrabajo) {
		this.lugarDeTrabajo = lugarDeTrabajo;
	}


	public Boolean getConvive() {
		return convive;
	}


	public void setConvive(Boolean convive) {
		this.convive = convive;
	}


	@Override
	public String toString() {
		return "ProgenitorTutor [nombre=" + nombre + ", apellido=" + apellido + ", ingresoNeto=" + ingresoNeto
				+ ", edad=" + edad + ", ocupacion=" + ocupacion + ", lugarDeTrabajo=" + lugarDeTrabajo + ", convive="
				+ convive + "]";
	}
	
	
	
}
