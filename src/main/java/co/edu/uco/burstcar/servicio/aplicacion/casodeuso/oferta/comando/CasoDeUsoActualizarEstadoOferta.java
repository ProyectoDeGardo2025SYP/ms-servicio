package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.oferta.comando;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.oferta.comando.dto.EstadoOfertaDto;
import co.edu.uco.burstcar.servicio.aplicacion.mapeador.oferta.impl.MapeadorServicioActualizarEstadoOfertaAplicacion;
import co.edu.uco.burstcar.servicio.dominio.servicio.oferta.ServicioActualizarEstadoOferta;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CasoDeUsoActualizarEstadoOferta {
    private final ServicioActualizarEstadoOferta servicioActualizarEstadoOferta;
    private final MapeadorServicioActualizarEstadoOfertaAplicacion mapeadorServicioActualizarEstadoOfertaAplicacion;

    public CasoDeUsoActualizarEstadoOferta(ServicioActualizarEstadoOferta servicioActualizarEstadoOferta, MapeadorServicioActualizarEstadoOfertaAplicacion mapeadorServicioActualizarEstadoOfertaAplicacion) {
        this.servicioActualizarEstadoOferta = servicioActualizarEstadoOferta;
        this.mapeadorServicioActualizarEstadoOfertaAplicacion = mapeadorServicioActualizarEstadoOfertaAplicacion;
    }

    public void ejecutarActualizacionEstadoOferta(EstadoOfertaDto dto, UUID idOferta) {
        this.servicioActualizarEstadoOferta.ejecutarActualizacion(
                this.mapeadorServicioActualizarEstadoOfertaAplicacion.aDominio(dto), idOferta);

    }
}