package co.edu.uco.burstcar.servicio.infraestructura.entrada.servicio.comando;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.comando.CasoDeUsoRegistrarServicio;
import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.comando.dto.ServicioDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/servicio")
public class ComandoControladorServicio {

    private final CasoDeUsoRegistrarServicio casoDeUsoRegistrarServicio;

    public ComandoControladorServicio(CasoDeUsoRegistrarServicio casoDeUsoRegistrarServicio) {
        this.casoDeUsoRegistrarServicio = casoDeUsoRegistrarServicio;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/nuevo")
    public UUID registrarServicio(@RequestBody ServicioDto dto){
        return this.casoDeUsoRegistrarServicio.ejecutarRegistro(dto);
    }
}
