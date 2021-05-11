package mds.trabajopractico.sistemabecasalimentarias.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = 
{@UniqueConstraint(columnNames={"ID_ENFERMEDAD_CRONICA"})})
public class EnfermedadCronica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //valor autonumerico
	@Column(name="ID_ENFERMEDAD_CRONICA")
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
