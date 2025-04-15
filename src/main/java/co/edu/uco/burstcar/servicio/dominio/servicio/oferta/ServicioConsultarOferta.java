package co.edu.uco.burstcar.servicio.dominio.servicio.oferta;

import co.edu.uco.burstcar.servicio.dominio.dto.OfertaDto;
import co.edu.uco.burstcar.servicio.dominio.modelo.Oferta;
import co.edu.uco.burstcar.servicio.dominio.modelo.Servicio;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioOferta;

import java.util.List;
import java.util.UUID;

public class ServicioConsultarOferta {
    private final RepositorioOferta repositorioOferta;

    public ServicioConsultarOferta(RepositorioOferta repositorioOferta) {
        this.repositorioOferta = repositorioOferta;
    }

    public List<OfertaDto> ejecutarConsulta(UUID servicio){
        return this.repositorioOferta.consultarOfertas(servicio);
    }
}
