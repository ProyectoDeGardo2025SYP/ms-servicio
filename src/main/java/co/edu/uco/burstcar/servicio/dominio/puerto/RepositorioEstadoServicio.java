package co.edu.uco.burstcar.servicio.dominio.puerto;

import co.edu.uco.burstcar.servicio.dominio.modelo.EstadoServicio;

import java.util.List;

public interface RepositorioEstadoServicio {

    EstadoServicio asociarEstadoServicio(String nombre);
    List<EstadoServicio> consultarEstadosServicio();
}
