package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.consulta;

import co.edu.uco.burstcar.servicio.dominio.dto.PaginaDto;
import co.edu.uco.burstcar.servicio.dominio.dto.ServicioDto;
import co.edu.uco.burstcar.servicio.dominio.servicio.servicio.ServicioConsultarInformacionServicios;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CasoDeUsoConsultarInformacionServicios {
    private final ServicioConsultarInformacionServicios servicioConsultarInformacionServicios;

    public CasoDeUsoConsultarInformacionServicios(ServicioConsultarInformacionServicios servicioConsultarInformacionServicios) {
        this.servicioConsultarInformacionServicios = servicioConsultarInformacionServicios;
    }

    public PaginaDto<ServicioDto> ejecutarConsulta(Double latitud, Double longitud, int pagina, int cantidad) {
        return this.servicioConsultarInformacionServicios.ejecutarConsulta(
                latitud, longitud, pagina, cantidad);
    }
}