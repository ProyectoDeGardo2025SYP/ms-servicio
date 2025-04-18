package co.edu.uco.burstcar.servicio.dominio.servicio.oferta;

import co.edu.uco.burstcar.servicio.dominio.modelo.EstadoOferta;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioOferta;

import java.util.UUID;

public class ServicioActualizarEstadoOferta {
    private final RepositorioOferta repositorioOferta;

    public ServicioActualizarEstadoOferta(RepositorioOferta repositorioOferta) {
        this.repositorioOferta = repositorioOferta;
    }


    public void ejecutarActualizacion(EstadoOferta estadoOferta, UUID idOferta){
        this.repositorioOferta.actualizarEstadoOferta(estadoOferta, idOferta);
    }
}
