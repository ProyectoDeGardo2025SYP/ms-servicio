package co.edu.uco.burstcar.servicio.dominio.servicio.servicio;

import co.edu.uco.burstcar.servicio.dominio.dto.ServicioDto;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioServicio;

import java.util.List;
import java.util.UUID;

public class ServicioConsultarServicio {
    private final RepositorioServicio repositorioServicio;


    public ServicioConsultarServicio(RepositorioServicio repositorioServicio) {
        this.repositorioServicio = repositorioServicio;
    }

    public List<ServicioDto> ejecutarConsulta(UUID id){
        return this.repositorioServicio.consultarInformacionServicios(id);
    }
}
