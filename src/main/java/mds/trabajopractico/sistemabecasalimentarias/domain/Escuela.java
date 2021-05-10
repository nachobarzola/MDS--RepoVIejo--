package mds.trabajopractico.sistemabecasalimentarias.domain;

import java.util.ArrayList;
import java.util.List;

public class Escuela {
	private Integer id;
	private String codigoUnicoEstablecimiento;
	private String clave;
	private List<Alumno> listaAlumnos;
	
	
	public Escuela(String codigoUnicoEstablecimiento, String clave,Integer idEsc) {
		super();
		this.codigoUnicoEstablecimiento = codigoUnicoEstablecimiento;
		this.clave = clave;
		this.id=idEsc;
		this.listaAlumnos = new ArrayList<>();
	}
	public Escuela() {}
	
	public String getCodigoUnicoEstablecimiento() {
		return codigoUnicoEstablecimiento;
	}
	public void setCodigoUnicoEstablecimiento(String codigoUnicoEstablecimiento) {
		this.codigoUnicoEstablecimiento = codigoUnicoEstablecimiento;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}
	public void setListaAlumnos(List<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}
	public void addAlumnos(List<Alumno> listaAlumnos) {
		this.listaAlumnos.addAll(listaAlumnos);
	}
	@Override
	public String toString() {
		return "Escuela [id=" + id + ", codigoUnicoEstablecimiento=" + codigoUnicoEstablecimiento + ", clave=" + clave
				+ ", listaAlumnos=" + listaAlumnos + "]";
	}
	
	
	

}
