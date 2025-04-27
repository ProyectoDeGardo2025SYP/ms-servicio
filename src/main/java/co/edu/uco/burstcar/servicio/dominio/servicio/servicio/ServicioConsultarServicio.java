package co.edu.uco.burstcar.servicio.dominio.servicio.servicio;

import co.edu.uco.burstcar.servicio.dominio.dto.ServicioDto;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioServicio;

import java.util.UUID;

public class ServicioConsultarServicio {
    private final RepositorioServicio repositorioServicio;


    public ServicioConsultarServicio(RepositorioServicio repositorioServicio) {
        this.repositorioServicio = repositorioServicio;
    }

    public ServicioDto ejecutarConsulta(UUID id){
        return this.repositorioServicio.consultarServicio(id);
    }
}
