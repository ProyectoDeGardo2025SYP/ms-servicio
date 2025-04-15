package co.edu.uco.burstcar.servicio.infraestructura.entrada.oferta.comando;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.destino.comando.dto.DestinoDto;
import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.oferta.comando.CasoDeUsoRegistrarOferta;
import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.oferta.comando.dto.OfertaDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/servicio/oferta")
public class ComandoControladorOferta {

    private final CasoDeUsoRegistrarOferta casoDeUsoRegistrarOferta;

    public ComandoControladorOferta(CasoDeUsoRegistrarOferta casoDeUsoRegistrarOferta) {
        this.casoDeUsoRegistrarOferta = casoDeUsoRegistrarOferta;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/nueva")
    public UUID registrarOferta(@RequestBody OfertaDto dto){
        return this.casoDeUsoRegistrarOferta.ejecutarRegistro(dto);
    }
}
