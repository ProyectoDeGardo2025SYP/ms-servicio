package co.edu.uco.burstcar.servicio.dominio.servicio.servicio;

import co.edu.uco.burstcar.servicio.dominio.modelo.EstadoServicio;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioServicio;

import java.util.UUID;

public class ServicioConsultarEstadoServicio {
    private final RepositorioServicio repositorioServicio;

    public ServicioConsultarEstadoServicio(RepositorioServicio repositorioServicio) {
        this.repositorioServicio = repositorioServicio;
    }

    public EstadoServicio ejecutarConsulta(UUID idServcio){
        return this.repositorioServicio.consultarEstadoServicio(idServcio);
    }
}
