package co.edu.uco.burstcar.servicio.dominio.puerto;

import co.edu.uco.burstcar.servicio.dominio.dto.OfertaDto;
import co.edu.uco.burstcar.servicio.dominio.modelo.EstadoOferta;
import co.edu.uco.burstcar.servicio.dominio.modelo.MonedaServicio;
import co.edu.uco.burstcar.servicio.dominio.modelo.Oferta;
import co.edu.uco.burstcar.servicio.dominio.modelo.Servicio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface RepositorioOferta {

    UUID registrarInformacionNuevaOferta(Oferta oferta);
    void actualizarEstadoOferta(EstadoOferta estadoOferta, UUID identificadorOferta);
    void notificarSolicitanteNegociacionOferta(Oferta oferta);
    List<OfertaDto> consultarOfertas(UUID servicio);

}
