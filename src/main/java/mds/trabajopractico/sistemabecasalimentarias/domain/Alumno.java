package mds.trabajopractico.sistemabecasalimentarias.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Alumno {
	private Integer id;
	private String nombre;
	private String apellido;
	private String nacionalidad;
	private String dni;
	private String email;
	private String telefono;
	private String cuit;
	private Date fechaDeNacimiento;
	private String grado;
	private String turno;
	private GrupoFamiliar grupoFamiliar;
	private List<Solicitud> solicitudes;
	private Direccion direccion;
	
	
	
	public Alumno(Integer id, String nombre, String apellido, String nacionalidad, String dni, String email,
			String telefono, String cuit, Date fechaDeNacimiento, String grado, String turno,
			GrupoFamiliar grupoFamiliar, Direccion direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.dni = dni;
		this.email = email;
		this.telefono = telefono;
		this.cuit = cuit;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.grado = grado;
		this.turno = turno;
		this.grupoFamiliar = grupoFamiliar;
		this.solicitudes = new ArrayList<>();
		this.direccion = direccion;
	}
	public Alumno() {super();}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public String getGrado() {
		return grado;
	}
	public void setGrado(String grado) {
		this.grado = grado;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public GrupoFamiliar getGrupoFamiliar() {
		return grupoFamiliar;
	}
	public void setGrupoFamiliar(GrupoFamiliar grupoFamiliar) {
		this.grupoFamiliar = grupoFamiliar;
	}
	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}
	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", nacionalidad=" + nacionalidad
				+ ", dni=" + dni + ", email=" + email + ", telefono=" + telefono + ", cuit=" + cuit
				+ ", fechaDeNacimiento=" + fechaDeNacimiento + ", grado=" + grado + ", turno=" + turno
				+ ", grupoFamiliar=" + grupoFamiliar + ", solicitudes=" + solicitudes + ", direccion=" + direccion
				+ "]";
	}
	
		
	
	
}
