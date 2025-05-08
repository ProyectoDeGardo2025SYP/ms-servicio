package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.oferta.consulta;

import co.edu.uco.burstcar.servicio.dominio.dto.OfertaDto;
import co.edu.uco.burstcar.servicio.dominio.dto.PaginaDto;
import co.edu.uco.burstcar.servicio.dominio.servicio.oferta.ServicioConsultarOferta;
import co.edu.uco.burstcar.servicio.dominio.servicio.oferta.ServicioConsultarOfertaPorPrestador;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CasoDeUsoConsultarOfertaPorPrestador {
    private final ServicioConsultarOfertaPorPrestador servicioConsultarOfertaPorPrestador;

    public CasoDeUsoConsultarOfertaPorPrestador(ServicioConsultarOfertaPorPrestador servicioConsultarOfertaPorPrestador) {
        this.servicioConsultarOfertaPorPrestador = servicioConsultarOfertaPorPrestador;
    }

    public PaginaDto<OfertaDto> ejecutarConsulta(UUID id, String prestador, int pagina, int cantidad) {
        return this.servicioConsultarOfertaPorPrestador.ejecutarConsulta(id, prestador, pagina, cantidad);
    }
}