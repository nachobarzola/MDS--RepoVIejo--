package mds.trabajopractico.sistemabecasalimentarias.domain;

public class Hermano {
	private Integer id;
	private Integer edad;
	private String ocupacion; //Ver
	private String escuela;
	private Boolean convive;
	
	public Hermano(Integer id, Integer edad, String ocupacion, String escuela, Boolean convive) {
		super();
		this.id = id;
		this.edad = edad;
		this.ocupacion = ocupacion;
		this.escuela = escuela;
		this.convive = convive;
	}

	public Hermano() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getEscuela() {
		return escuela;
	}

	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}

	public Boolean getConvive() {
		return convive;
	}

	public void setConvive(Boolean convive) {
		this.convive = convive;
	}

	@Override
	public String toString() {
		return "Hermano [id=" + id + ", edad=" + edad + ", ocupacion=" + ocupacion + ", escuela=" + escuela
				+ ", convive=" + convive + "]";
	}
	
	
}
