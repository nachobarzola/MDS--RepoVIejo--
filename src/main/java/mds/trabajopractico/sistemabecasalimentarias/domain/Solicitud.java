package mds.trabajopractico.sistemabecasalimentarias.domain;

import java.util.Date;

public class Solicitud {
	private Integer id;
	private Date fecha;
	private BecaAprobada becaAprobada;
	private Alumno alumnoSolicitante;
	private ClasificacionSolicitud clasificacionSolicitud;
	
	
	public Solicitud(Integer id, Date fecha, BecaAprobada becaAprobada, Alumno alumnoSolicitante,
			ClasificacionSolicitud clasificacionSolicitud) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.becaAprobada = becaAprobada;
		this.alumnoSolicitante = alumnoSolicitante;
		this.clasificacionSolicitud = clasificacionSolicitud;
	}


	public Solicitud() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public BecaAprobada getBecaAprobada() {
		return becaAprobada;
	}


	public void setBecaAprobada(BecaAprobada becaAprobada) {
		this.becaAprobada = becaAprobada;
	}


	public Alumno getAlumnoSolicitante() {
		return alumnoSolicitante;
	}


	public void setAlumnoSolicitante(Alumno alumnoSolicitante) {
		this.alumnoSolicitante = alumnoSolicitante;
	}


	public ClasificacionSolicitud getClasificacionSolicitud() {
		return clasificacionSolicitud;
	}


	public void setClasificacionSolicitud(ClasificacionSolicitud clasificacionSolicitud) {
		this.clasificacionSolicitud = clasificacionSolicitud;
	}


	@Override
	public String toString() {
		return "Solicitud [id=" + id + ", fecha=" + fecha + ", becaAprobada=" + becaAprobada + ", alumnoSolicitante="
				+ alumnoSolicitante + ", clasificacionSolicitud=" + clasificacionSolicitud + "]";
	}
	
	
}
