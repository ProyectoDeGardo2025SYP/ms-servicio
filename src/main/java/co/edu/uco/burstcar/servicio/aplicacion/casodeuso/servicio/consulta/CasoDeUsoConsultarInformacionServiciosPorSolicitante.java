package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.consulta;

import co.edu.uco.burstcar.servicio.dominio.dto.PaginaDto;
import co.edu.uco.burstcar.servicio.dominio.dto.ServicioDto;
import co.edu.uco.burstcar.servicio.dominio.servicio.servicio.ServicioConsultarInformacionServicios;
import co.edu.uco.burstcar.servicio.dominio.servicio.servicio.ServicioConsultarInformacionServiciosPorSolicitante;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CasoDeUsoConsultarInformacionServiciosPorSolicitante {
    private final ServicioConsultarInformacionServiciosPorSolicitante servicioConsultarInformacionServiciosPorSolicitante;

    public CasoDeUsoConsultarInformacionServiciosPorSolicitante(ServicioConsultarInformacionServiciosPorSolicitante servicioConsultarInformacionServiciosPorSolicitante) {
        this.servicioConsultarInformacionServiciosPorSolicitante = servicioConsultarInformacionServiciosPorSolicitante;
    }

    public PaginaDto<ServicioDto> ejecutarConsulta(UUID id, String solicitante, int pagina, int cantidad) {
        return this.servicioConsultarInformacionServiciosPorSolicitante.ejecutarConsulta(id, solicitante,
                pagina, cantidad);
    }
}