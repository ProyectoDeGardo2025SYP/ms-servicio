package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.comando;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.comando.dto.EstadoDto;
import co.edu.uco.burstcar.servicio.aplicacion.mapeador.servicio.impl.MapeadorServicioEliminacionLogicaAplicacion;
import co.edu.uco.burstcar.servicio.dominio.servicio.servicio.ServicioEliminarDeManeraLogicaServicio;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CasoDeUsoEliminarDeManeraLogicaServicio {
    private final ServicioEliminarDeManeraLogicaServicio servicioEliminarDeManeraLogicaServicio;
    private final MapeadorServicioEliminacionLogicaAplicacion mapeadorServicioEliminacionLogicaAplicacion;

    public CasoDeUsoEliminarDeManeraLogicaServicio(ServicioEliminarDeManeraLogicaServicio servicioEliminarDeManeraLogicaServicio, MapeadorServicioEliminacionLogicaAplicacion mapeadorServicioEliminacionLogicaAplicacion) {
        this.servicioEliminarDeManeraLogicaServicio = servicioEliminarDeManeraLogicaServicio;
        this.mapeadorServicioEliminacionLogicaAplicacion = mapeadorServicioEliminacionLogicaAplicacion;
    }


    public void ejecutarEliminacionLogica(EstadoDto dto, UUID idServicio) {
        this.servicioEliminarDeManeraLogicaServicio.ejecutarElimincaionLogica(
                this.mapeadorServicioEliminacionLogicaAplicacion.aDominio(dto), idServicio);

    }
}