package co.edu.uco.burstcar.servicio.infraestructura.entrada.oferta.consulta;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.oferta.consulta.CasoDeUsoConsultarOferta;
import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.oferta.consulta.CasoDeUsoConsultarOfertaPorPrestador;
import co.edu.uco.burstcar.servicio.dominio.dto.OfertaDto;
import co.edu.uco.burstcar.servicio.dominio.dto.PaginaDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/servicio/oferta")
public class ConsultaControladorOferta {

    private final CasoDeUsoConsultarOferta consultarOferta;
    private final CasoDeUsoConsultarOfertaPorPrestador consultarOfertaPorPrestador;

    public ConsultaControladorOferta(CasoDeUsoConsultarOferta consultarOferta, CasoDeUsoConsultarOfertaPorPrestador consultarOfertaPorPrestador) {
        this.consultarOferta = consultarOferta;
        this.consultarOfertaPorPrestador = consultarOfertaPorPrestador;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/todos/{id}")
    public PaginaDto<OfertaDto> consultarOfertas(@PathVariable UUID id,
                                                 @RequestParam(defaultValue = "0") int pagina,
                                                 @RequestParam(defaultValue = "3") int cantidad){
        return this.consultarOferta.ejecutarConsulta(id, pagina, cantidad);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/todos/{id}/prestador/{prestador}")
    public PaginaDto<OfertaDto> consultarOfertasPorPrestador(@PathVariable UUID id, @PathVariable String prestador,
                                                 @RequestParam(defaultValue = "0") int pagina,
                                                 @RequestParam(defaultValue = "3") int cantidad){
        return this.consultarOfertaPorPrestador.ejecutarConsulta(id, prestador, pagina, cantidad);
    }
}
