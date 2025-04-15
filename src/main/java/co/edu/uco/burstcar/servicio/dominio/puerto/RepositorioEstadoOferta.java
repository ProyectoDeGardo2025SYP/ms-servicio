package co.edu.uco.burstcar.servicio.dominio.puerto;

import co.edu.uco.burstcar.servicio.dominio.modelo.EstadoOferta;

import java.util.List;

public interface RepositorioEstadoOferta {

    EstadoOferta asociarEstadoOferta(String nombre);
    List<EstadoOferta> consultarEstadosOferta();
}
