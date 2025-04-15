package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.oferta.comando;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.oferta.comando.dto.OfertaDto;
import co.edu.uco.burstcar.servicio.aplicacion.mapeador.oferta.impl.MapeadorOfertaAplicacion;
import co.edu.uco.burstcar.servicio.dominio.servicio.oferta.ServicioAnalizarCostoOferta;
import co.edu.uco.burstcar.servicio.dominio.servicio.oferta.ServicioRegistrarOferta;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CasoDeUsoRegistrarOferta {
    private final ServicioRegistrarOferta servicioRegistrarOferta;
    private final ServicioAnalizarCostoOferta servicioAnalizarCostoOferta;
    private final MapeadorOfertaAplicacion mapeadorOfertaAplicacion;

    public CasoDeUsoRegistrarOferta(ServicioRegistrarOferta servicioRegistrarOferta, ServicioAnalizarCostoOferta servicioAnalizarCostoOferta, MapeadorOfertaAplicacion mapeadorOfertaAplicacion) {
        this.servicioRegistrarOferta = servicioRegistrarOferta;
        this.servicioAnalizarCostoOferta = servicioAnalizarCostoOferta;
        this.mapeadorOfertaAplicacion = mapeadorOfertaAplicacion;
    }

    public UUID ejecutarRegistro(OfertaDto dto) {
        if (this.servicioAnalizarCostoOferta.ejecutarAnalizis(dto.getFechaInicio(), dto.getFechaFin(), dto.getCosto())){
            return this.servicioRegistrarOferta.ejecutarRegistro(
                    this.mapeadorOfertaAplicacion.aDominio(dto));
        }
        return null;
    }
}