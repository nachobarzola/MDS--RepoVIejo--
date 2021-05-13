package mds.trabajopractico.sistemabecasalimentarias.services.interfaces;

import java.util.Optional;

import mds.trabajopractico.sistemabecasalimentarias.domain.BecaAprobada;
import mds.trabajopractico.sistemabecasalimentarias.domain.ClasificacionSolicitud;
import mds.trabajopractico.sistemabecasalimentarias.domain.Solicitud;

public interface SolicitudService {
	Optional<Solicitud> guardarSolicitud(Solicitud solicitud);
	
	Optional<Solicitud> agregarBecaAprobada(Solicitud solicitud, BecaAprobada becaAprobada);
	
	ClasificacionSolicitud clasificarSolicitud(Solicitud solicitud);
	
}
