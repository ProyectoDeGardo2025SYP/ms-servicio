package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.comando;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.comando.dto.EstadoDto;
import co.edu.uco.burstcar.servicio.aplicacion.mapeador.servicio.impl.MapeadorServicioActualizarEstadoAplicacion;
import co.edu.uco.burstcar.servicio.dominio.servicio.servicio.ServicioActualizarEstadoServicio;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CasoDeUsoActualizarEstadoServicio {
    private final ServicioActualizarEstadoServicio servicioActualizarEstadoServicio;
    private final MapeadorServicioActualizarEstadoAplicacion mapeadorServicioActualizarEstadoAplicacion;

    public CasoDeUsoActualizarEstadoServicio(ServicioActualizarEstadoServicio servicioActualizarEstadoServicio, MapeadorServicioActualizarEstadoAplicacion mapeadorServicioActualizarEstadoAplicacion) {
        this.servicioActualizarEstadoServicio = servicioActualizarEstadoServicio;
        this.mapeadorServicioActualizarEstadoAplicacion = mapeadorServicioActualizarEstadoAplicacion;
    }

    public void ejecutarActualizacionEstadoServicio(EstadoDto dto, UUID idServicio) {
        this.servicioActualizarEstadoServicio.ejecutarActualizacion(
                this.mapeadorServicioActualizarEstadoAplicacion.aDominio(dto), idServicio);

    }
}