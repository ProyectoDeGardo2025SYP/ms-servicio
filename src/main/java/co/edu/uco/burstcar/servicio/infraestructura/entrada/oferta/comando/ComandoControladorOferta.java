package co.edu.uco.burstcar.servicio.infraestructura.entrada.oferta.comando;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.oferta.comando.CasoDeUsoActualizarEstadoOferta;
import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.oferta.comando.CasoDeUsoRegistrarOferta;
import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.oferta.comando.dto.EstadoOfertaDto;
import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.oferta.comando.dto.OfertaDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/servicio/oferta")
public class ComandoControladorOferta {

    private final CasoDeUsoRegistrarOferta casoDeUsoRegistrarOferta;
    private final CasoDeUsoActualizarEstadoOferta casoDeUsoActualizarEstadoOferta;

    public ComandoControladorOferta(CasoDeUsoRegistrarOferta casoDeUsoRegistrarOferta, CasoDeUsoActualizarEstadoOferta casoDeUsoActualizarEstadoOferta) {
        this.casoDeUsoRegistrarOferta = casoDeUsoRegistrarOferta;
        this.casoDeUsoActualizarEstadoOferta = casoDeUsoActualizarEstadoOferta;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/nueva")
    public UUID registrarOferta(@RequestBody OfertaDto dto){
        return this.casoDeUsoRegistrarOferta.ejecutarRegistro(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}/cambio/estado")
    public void actualizarEstadoOferta(@RequestBody EstadoOfertaDto dto, @PathVariable UUID id){
        this.casoDeUsoActualizarEstadoOferta.ejecutarActualizacionEstadoOferta(dto, id);
    }
}
