package co.edu.uco.burstcar.servicio.dominio.servicio.servicio;

import co.edu.uco.burstcar.servicio.dominio.dto.PaginaDto;
import co.edu.uco.burstcar.servicio.dominio.dto.ServicioDto;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioServicio;

import java.util.UUID;

public class ServicioConsultarInformacionServiciosPorSolicitante {
    private final RepositorioServicio repositorioServicio;


    public ServicioConsultarInformacionServiciosPorSolicitante(RepositorioServicio repositorioServicio) {
        this.repositorioServicio = repositorioServicio;
    }

    public PaginaDto<ServicioDto> ejecutarConsulta(UUID id, String solicitante, int pagina, int cantidad){
        return this.repositorioServicio.consultarInformacionServiciosPorSolicitante(id, solicitante,
                pagina, cantidad);
    }
}
