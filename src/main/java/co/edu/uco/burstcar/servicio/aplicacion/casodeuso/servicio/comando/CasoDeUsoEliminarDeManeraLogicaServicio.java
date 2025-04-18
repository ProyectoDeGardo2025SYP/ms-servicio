package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.comando;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.comando.dto.EstadoDto;
import co.edu.uco.burstcar.servicio.aplicacion.mapeador.servicio.impl.MapeadorServicioActualizarEstadoAplicacion;
import co.edu.uco.burstcar.servicio.dominio.servicio.servicio.ServicioEliminarDeManeraLogicaServicio;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CasoDeUsoEliminarDeManeraLogicaServicio {
    private final ServicioEliminarDeManeraLogicaServicio servicioEliminarDeManeraLogicaServicio;
    private final MapeadorServicioActualizarEstadoAplicacion mapeadorServicioActualizarEstadoAplicacion;

    public CasoDeUsoEliminarDeManeraLogicaServicio(ServicioEliminarDeManeraLogicaServicio servicioEliminarDeManeraLogicaServicio, MapeadorServicioActualizarEstadoAplicacion mapeadorServicioActualizarEstadoAplicacion) {
        this.servicioEliminarDeManeraLogicaServicio = servicioEliminarDeManeraLogicaServicio;
        this.mapeadorServicioActualizarEstadoAplicacion = mapeadorServicioActualizarEstadoAplicacion;
    }


    public void ejecutarEliminacionLogica(EstadoDto dto, UUID idServicio) {
        this.servicioEliminarDeManeraLogicaServicio.ejecutarElimincaionLogica(
                this.mapeadorServicioActualizarEstadoAplicacion.aDominio(dto), idServicio);

    }
}