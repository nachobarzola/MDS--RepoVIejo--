package mds.trabajopractico.sistemabecasalimentarias.domain;

import java.util.Date;

public class BecaAprobada {
	private Integer id;
	private Date fechaInicio;
	private Date fechaFin;
	private Solicitud solicitud;
	
	public BecaAprobada(Integer id, Date fechaInicio, Date fechaFin, Solicitud solicitud) {
		super();
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.solicitud = solicitud;
	}

	public BecaAprobada() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	@Override
	public String toString() {
		return "BecaAprobada [id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", solicitud="
				+ solicitud + "]";
	}
	
	

}
