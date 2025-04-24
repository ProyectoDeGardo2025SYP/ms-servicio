package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.consulta;

import co.edu.uco.burstcar.servicio.dominio.dto.PaginaDto;
import co.edu.uco.burstcar.servicio.dominio.dto.ServicioDto;
import co.edu.uco.burstcar.servicio.dominio.servicio.servicio.ServicioConsultarServicio;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CasoDeUsoConsultarServicio {
    private final ServicioConsultarServicio servicioConsultarServicio;

    public CasoDeUsoConsultarServicio(ServicioConsultarServicio servicioConsultarServicio) {
        this.servicioConsultarServicio = servicioConsultarServicio;
    }

    public PaginaDto<ServicioDto> ejecutarConsulta(UUID id, int pagina, int cantidad) {
        return this.servicioConsultarServicio.ejecutarConsulta(id, pagina, cantidad);
    }
}