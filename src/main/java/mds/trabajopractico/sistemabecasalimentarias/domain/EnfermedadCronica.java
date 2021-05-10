package mds.trabajopractico.sistemabecasalimentarias.domain;

public class EnfermedadCronica {
	private Integer id;
	private String diagnostico;
	private Double gastoMensual;
	
	
	public EnfermedadCronica(Integer id, String diagnostico, Double gastoMensual) {
		super();
		this.id = id;
		this.diagnostico = diagnostico;
		this.gastoMensual = gastoMensual;
	}


	public EnfermedadCronica() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDiagnostico() {
		return diagnostico;
	}


	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}


	public Double getGastoMensual() {
		return gastoMensual;
	}


	public void setGastoMensual(Double gastoMensual) {
		this.gastoMensual = gastoMensual;
	}


	@Override
	public String toString() {
		return "EnfermedadCronica [id=" + id + ", diagnostico=" + diagnostico + ", gastoMensual=" + gastoMensual + "]";
	}
	
	
	

}
