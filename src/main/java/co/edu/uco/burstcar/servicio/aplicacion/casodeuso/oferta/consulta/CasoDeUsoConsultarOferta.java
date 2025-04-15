package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.oferta.consulta;

import co.edu.uco.burstcar.servicio.dominio.dto.OfertaDto;
import co.edu.uco.burstcar.servicio.dominio.servicio.oferta.ServicioConsultarOferta;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CasoDeUsoConsultarOferta {
    private final ServicioConsultarOferta servicioConsultarOferta;

    public CasoDeUsoConsultarOferta(ServicioConsultarOferta servicioConsultarOferta) {
        this.servicioConsultarOferta = servicioConsultarOferta;
    }

    public List<OfertaDto> ejecutarConsulta(UUID id) {
        return this.servicioConsultarOferta.ejecutarConsulta(id);
    }
}