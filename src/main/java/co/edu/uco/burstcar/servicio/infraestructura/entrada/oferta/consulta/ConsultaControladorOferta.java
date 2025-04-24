package co.edu.uco.burstcar.servicio.infraestructura.entrada.oferta.consulta;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.oferta.consulta.CasoDeUsoConsultarOferta;
import co.edu.uco.burstcar.servicio.dominio.dto.OfertaDto;
import co.edu.uco.burstcar.servicio.dominio.dto.PaginaDto;
import co.edu.uco.burstcar.servicio.dominio.dto.ServicioDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/servicio/oferta")
public class ConsultaControladorOferta {

    private final CasoDeUsoConsultarOferta consultarOferta;

    public ConsultaControladorOferta(CasoDeUsoConsultarOferta consultarOferta) {
        this.consultarOferta = consultarOferta;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/todos/{id}")
    public PaginaDto<OfertaDto> consultarOfertas(@PathVariable UUID id,
                                                 @RequestParam(defaultValue = "0") int pagina,
                                                 @RequestParam(defaultValue = "3") int cantidad){
        return this.consultarOferta.ejecutarConsulta(id, pagina, cantidad);
    }
}
