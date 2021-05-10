package mds.trabajopractico.sistemabecasalimentarias.domain;

import java.util.ArrayList;
import java.util.List;

public class GrupoFamiliar {
	private Integer id;
	private List<Hermano> listaHermano;
	private List<ProgenitorTutor> listaProgenitorTutor;
	private List<EnfermedadCronica> listaEnfermedadCronica;
	
	

	public GrupoFamiliar(Integer id) {
		super();
		this.id = id;
		this.listaHermano = new ArrayList<>();
		this.listaProgenitorTutor = new ArrayList<>();
		this.listaEnfermedadCronica = new ArrayList<>();
	}

	public GrupoFamiliar() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Hermano> getListaHermano() {
		return listaHermano;
	}

	public void setListaHermano(List<Hermano> listaHermano) {
		this.listaHermano = listaHermano;
	}
	public void addHermano(List<Hermano> listaHermano) {
		this.listaHermano.addAll(listaHermano);
	}

	public List<ProgenitorTutor> getListaProgenitorTutor() {
		return listaProgenitorTutor;
	}

	public void setListaProgenitorTutor(List<ProgenitorTutor> listaProgenitorTutor) {
		this.listaProgenitorTutor = listaProgenitorTutor;
	}
	public void addProgenitorTutor(List<ProgenitorTutor> listaProgenitorTutor) {
		this.listaProgenitorTutor.addAll(listaProgenitorTutor);
	}
	public List<EnfermedadCronica> getListaEnfermedadCronica() {
		return listaEnfermedadCronica;
	}

	public void setListaEnfermedadCronica(List<EnfermedadCronica> listaEnfermedadCronica) {
		this.listaEnfermedadCronica = listaEnfermedadCronica;
	}
	public void addEnfermedadCronica(List<EnfermedadCronica> listaEnfermedadCronica) {
		this.listaEnfermedadCronica.addAll(listaEnfermedadCronica);
	}

	@Override
	public String toString() {
		return "GrupoFamiliar [id=" + id + ", listaHermano=" + listaHermano + ", listaProgenitorTutor="
				+ listaProgenitorTutor + ", listaEnfermedadCronica=" + listaEnfermedadCronica + "]";
	}
	
	
	
}
