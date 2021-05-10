package mds.trabajopractico.sistemabecasalimentarias.domain;

public class Escuela {
	private Integer id;
	private String codigoUnicoEstablecimiento;
	private String clave;
	
	
	public Escuela(String codigoUnicoEstablecimiento, String clave,Integer idEsc) {
		super();
		this.codigoUnicoEstablecimiento = codigoUnicoEstablecimiento;
		this.clave = clave;
		this.id=idEsc;
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
	@Override
	public String toString() {
		return "Escuela [id=" + id + ", codigoUnicoEstablecimiento=" + codigoUnicoEstablecimiento + ", clave=" + clave
				+ "]";
	}

	
	

}
