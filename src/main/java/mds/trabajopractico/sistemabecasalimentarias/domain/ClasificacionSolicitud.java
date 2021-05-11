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
{@UniqueConstraint(columnNames={"ID_CLASIFICACION", "DESCRIPCION"})})
public class ClasificacionSolicitud {
	//TODO: Falta completar
	//Ver como levantar los tipos de la base de datos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //valor autonumerico
	@Column(name="ID_CLASIFICACION")
	private Integer id;
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	
}
