package co.edu.uco.burstcar.servicio.dominio.puerto;

import co.edu.uco.burstcar.servicio.dominio.modelo.SolicitanteServicio;

public interface RepositorioSolicitanteServicio {

    SolicitanteServicio asociarSolicitanteServicio(String numeroIdentificacion);
    void registrarSolicitante(SolicitanteServicio solicitanteServicio);
}
