package co.edu.uco.burstcar.servicio.dominio.servicio.servicio;

import co.edu.uco.burstcar.servicio.dominio.dto.ServicioActualizacionDto;
import co.edu.uco.burstcar.servicio.dominio.modelo.EstadoServicio;
import co.edu.uco.burstcar.servicio.dominio.modelo.Servicio;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioServicio;

import java.util.UUID;

public class ServicioActualizarInformacionServicio {
    private final RepositorioServicio repositorioServicio;

    public ServicioActualizarInformacionServicio(RepositorioServicio repositorioServicio) {
        this.repositorioServicio = repositorioServicio;
    }

    public void ejecutarActualizacion(ServicioActualizacionDto dto, UUID idServcio){
        this.repositorioServicio.actualizarInformacionServicio(dto, idServcio);
    }
}
