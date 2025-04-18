package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.consulta;

import co.edu.uco.burstcar.servicio.dominio.modelo.EstadoServicio;
import co.edu.uco.burstcar.servicio.dominio.servicio.servicio.ServicioConsultarEstadoServicio;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CasoDeUsoConsultarEstadoServicio {
    private final ServicioConsultarEstadoServicio servicioConsultarEstadoServicio;

    public CasoDeUsoConsultarEstadoServicio(ServicioConsultarEstadoServicio servicioConsultarEstadoServicio) {
        this.servicioConsultarEstadoServicio = servicioConsultarEstadoServicio;
    }


    public EstadoServicio ejecutarConsulta(UUID id) {
        return this.servicioConsultarEstadoServicio.ejecutarConsulta(id);
    }
}