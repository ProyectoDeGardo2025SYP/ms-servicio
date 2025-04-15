package co.edu.uco.burstcar.servicio.infraestructura.entrada.destino.comando;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.destino.comando.CasoDeUsoRegistrarDestino;
import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.destino.comando.dto.DestinoDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/servicio/destino")
public class ComandoControladorDestino {

    private final CasoDeUsoRegistrarDestino casoDeUsoRegistrarDestino;

    public ComandoControladorDestino(CasoDeUsoRegistrarDestino casoDeUsoRegistrarDestino) {
        this.casoDeUsoRegistrarDestino = casoDeUsoRegistrarDestino;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/nuevo")
    public UUID registrarDestino(@RequestBody DestinoDto dto){
        return this.casoDeUsoRegistrarDestino.ejecutarRegistro(dto);
    }
}
