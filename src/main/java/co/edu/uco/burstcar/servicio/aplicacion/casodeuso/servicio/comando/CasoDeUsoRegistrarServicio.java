package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.comando;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.comando.dto.ServicioDto;
import co.edu.uco.burstcar.servicio.aplicacion.mapeador.servicio.impl.MapeadorServicioAplicacion;
import co.edu.uco.burstcar.servicio.aplicacion.mapeador.servicio.impl.MapeadorServicioEmisorAplicacion;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioEmitirServicio;
import co.edu.uco.burstcar.servicio.dominio.servicio.servicio.ServicioRegistrarServicio;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CasoDeUsoRegistrarServicio {
    private final ServicioRegistrarServicio servicioRegistrarServicio;
    private final MapeadorServicioAplicacion mapeadorServicioAplicacion;
    private final RepositorioEmitirServicio repositorioEmitirServicio;
    private final MapeadorServicioEmisorAplicacion mapeadorServicioEmisorAplicacion;

    public CasoDeUsoRegistrarServicio(ServicioRegistrarServicio servicioRegistrarServicio, MapeadorServicioAplicacion mapeadorServicioAplicacion, RepositorioEmitirServicio repositorioEmitirServicio, MapeadorServicioEmisorAplicacion mapeadorServicioEmisorAplicacion) {
        this.servicioRegistrarServicio = servicioRegistrarServicio;
        this.mapeadorServicioAplicacion = mapeadorServicioAplicacion;
        this.repositorioEmitirServicio = repositorioEmitirServicio;
        this.mapeadorServicioEmisorAplicacion = mapeadorServicioEmisorAplicacion;
    }

    public UUID ejecutarRegistro(ServicioDto dto) {
        UUID identificador = this.servicioRegistrarServicio.ejecutarRegistro(
                this.mapeadorServicioAplicacion.aDominio(dto));
        this.repositorioEmitirServicio.emitirInformacionServicio(
                this.mapeadorServicioEmisorAplicacion.aDominio(dto, identificador));
        return identificador;
    }
}