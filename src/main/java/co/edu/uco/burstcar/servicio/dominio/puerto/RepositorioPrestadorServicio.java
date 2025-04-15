package co.edu.uco.burstcar.servicio.dominio.puerto;

import co.edu.uco.burstcar.servicio.dominio.modelo.PrestadorServicio;

public interface RepositorioPrestadorServicio {

    PrestadorServicio asociarSolicitanteServicio(String numeroIdentificacion);
    void registrarSolicitante(PrestadorServicio prestadorServicio);
}
