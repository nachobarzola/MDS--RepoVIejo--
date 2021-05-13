package mds.trabajopractico.sistemabecasalimentarias.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mds.trabajopractico.sistemabecasalimentarias.domain.BecaAprobada;
import mds.trabajopractico.sistemabecasalimentarias.domain.ClasificacionSolicitud;
import mds.trabajopractico.sistemabecasalimentarias.domain.Solicitud;
import mds.trabajopractico.sistemabecasalimentarias.services.dao.BecaAprobadaRepository;
import mds.trabajopractico.sistemabecasalimentarias.services.dao.SolicitudRepository;
import mds.trabajopractico.sistemabecasalimentarias.services.interfaces.AlumnoService;
import mds.trabajopractico.sistemabecasalimentarias.services.interfaces.SolicitudService;

@Service
public class SolicitudSeviceImp implements SolicitudService{
	
	@Autowired
	private SolicitudRepository solicitudRepo;
	
	@Autowired
	private BecaAprobadaRepository becaAprobadaRepo;
	
	@Autowired
	private AlumnoService alumnoService;

	@Override
	public Optional<Solicitud> guardarSolicitud(Solicitud solicitud) {
		if(solicitud.getAlumnoSolicitante() == null 
				|| solicitud.getClasificacionSolicitud() == null) {
			return Optional.empty();
		}
		Solicitud solicitudGuar = solicitudRepo.save(solicitud);
		if(solicitudGuar != null) {
			return Optional.of(solicitudGuar);
		}
		return Optional.empty();
	}

	@Override
	public Optional<Solicitud> agregarBecaAprobada(Solicitud solicitud, BecaAprobada becaAprobada) {
		if(becaAprobadaRepo.save(becaAprobada) != null) {
			solicitud.setBecaAprobada(becaAprobada);
			becaAprobada.setSolicitud(solicitud);
			//Solicitud es dueña de la relacion por lo tanto la guarda
			Solicitud solicitudReturn = solicitudRepo.save(solicitud); 
			if(solicitudReturn != null) {
				return Optional.of(solicitudReturn);
			}
		}
		return Optional.empty();
	}

	@Override
	public ClasificacionSolicitud clasificarSolicitud(Solicitud solicitud) {
		Double sumaIngresoNetoFamiliar = alumnoService.getIngresoFamiliarTotal(solicitud.getAlumnoSolicitante());
		if(sumaIngresoNetoFamiliar == null) {
			//TODO: deberia notificar a la interfaz
			return null; //TODO: evitar return null
		}
		Double sumaGastoEnfermedad = alumnoService.getGastoEnfermedadCronica(solicitud.getAlumnoSolicitante());
		if(sumaGastoEnfermedad == null) {
			//TODO: deberia notificar a la interfaz
			return null; //TODO: evitar return null
		}
		Double diferenciaIngresoGasto = sumaIngresoNetoFamiliar - sumaGastoEnfermedad;
		if(diferenciaIngresoGasto < 0.0) {
			diferenciaIngresoGasto = 0.0;
		}
		Integer cantidadHermanos = alumnoService.getCantidadHermanos(solicitud.getAlumnoSolicitante());
		
		
		return analizarSolicitud(diferenciaIngresoGasto, cantidadHermanos);
	}
	
	private ClasificacionSolicitud analizarSolicitud(Double diferenciaIngresoGasto, Integer cantidadHermanos) {
		//------------SOLICITUD RECHAZADA
		//Suma(ingresosFamiliar) - Suma(gastoMensualEnfermedad) >= $ 60.000
		//Tiene postulante <= 2 Hermanos
		if(diferenciaIngresoGasto >= 60000.0  &&  cantidadHermanos <= 2) {
			return ClasificacionSolicitud.SolicitudRechazada;
		}
		//-------------	SOLICITUD APROBADA CON MEDIA BECA
		//Suma(ingresosFamiliar) - Suma(gastoMensualEnfermedad) >= $ 60.000
		//Tiene postulante >= 3 hermanos
		else if(diferenciaIngresoGasto >= 60000.0 && cantidadHermanos >= 3) {
			return ClasificacionSolicitud.MediaBeca;
		}
		//Suma(ingresosFamiliar) - Suma(gastoMensualEnfermedad) <= $ 60.000
		//Suma(ingresosFamiliar) - Suma(gastoMensualEnfermedad) >= $ 50.000
		//Tiene postulante <= 2 hermanos
		else if(diferenciaIngresoGasto <= 60000.0 
				&& diferenciaIngresoGasto >=50000.0 && cantidadHermanos <= 2) {
			return ClasificacionSolicitud.MediaBeca;
		}
		//Suma(ingresosFamiliar) - Suma(gastoMensualEnfermedad) <= $ 50.000
		//No tiene hermanos.
		else if(diferenciaIngresoGasto <= 50000.0 && cantidadHermanos == 0) {
			return ClasificacionSolicitud.MediaBeca;
		}
		//-------------	SOLICITUD APROBADA CON BECA TOTAL
		//Suma(ingresosFamiliar) - Suma(gastoMensualEnfermedad) <= $ 50.000
		else if(diferenciaIngresoGasto <= 50000.0) {
			return ClasificacionSolicitud.BecaTotal;
		}
		else {
			return ClasificacionSolicitud.SolicitudEnEstudio;
		}
	}


}
