package mds.trabajopractico.sistemabecasalimentarias.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mds.trabajopractico.sistemabecasalimentarias.domain.BecaAprobada;
import mds.trabajopractico.sistemabecasalimentarias.domain.ClasificacionSolicitud;
import mds.trabajopractico.sistemabecasalimentarias.domain.Solicitud;
import mds.trabajopractico.sistemabecasalimentarias.services.dao.BecaAprobadaRepository;
import mds.trabajopractico.sistemabecasalimentarias.services.dao.SolicitudRepository;
import mds.trabajopractico.sistemabecasalimentarias.services.interfaces.SolicitudService;

@Service
public class SolicitudSeviceImp implements SolicitudService{
	
	@Autowired
	private SolicitudRepository solicitudRepo;
	
	@Autowired
	private BecaAprobadaRepository becaAprobadaRepo;

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



}
