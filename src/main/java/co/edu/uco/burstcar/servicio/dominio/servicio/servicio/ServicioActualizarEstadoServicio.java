package co.edu.uco.burstcar.servicio.dominio.servicio.servicio;

import co.edu.uco.burstcar.servicio.dominio.modelo.EstadoServicio;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioServicio;

import java.util.UUID;

public class ServicioActualizarEstadoServicio {
    private final RepositorioServicio repositorioServicio;

    public ServicioActualizarEstadoServicio(RepositorioServicio repositorioServicio) {
        this.repositorioServicio = repositorioServicio;
    }

    public void ejecutarActualizacion(EstadoServicio estadoServicio, UUID idServcio){
        this.repositorioServicio.actualizarEstadosDelServicio(estadoServicio, idServcio);
    }
}
