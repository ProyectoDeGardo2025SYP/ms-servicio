package co.edu.uco.burstcar.servicio.dominio.servicio.oferta;

import co.edu.uco.burstcar.servicio.dominio.dto.OfertaDto;
import co.edu.uco.burstcar.servicio.dominio.dto.PaginaDto;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioOferta;

import java.util.UUID;

public class ServicioConsultarOfertaPorPrestador {
    private final RepositorioOferta repositorioOferta;

    public ServicioConsultarOfertaPorPrestador(RepositorioOferta repositorioOferta) {
        this.repositorioOferta = repositorioOferta;
    }

    public PaginaDto<OfertaDto> ejecutarConsulta(UUID servicio, String prestador, int pagina, int cantidad){
        return this.repositorioOferta.consultarOfertasPorPrestador(servicio, prestador, pagina, cantidad);
    }
}
