package co.edu.uco.burstcar.servicio.infraestructura.entrada.ubicacion.comando;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.ubicacion.comando.CasoDeUsoRegistrarUbicacion;
import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.ubicacion.comando.dto.UbicacionDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/servicio/ubicacion")
public class ComandoControladorUbicacion {

    private final CasoDeUsoRegistrarUbicacion casoDeUsoRegistrarUbicacion;

    public ComandoControladorUbicacion(CasoDeUsoRegistrarUbicacion casoDeUsoRegistrarUbicacion) {
        this.casoDeUsoRegistrarUbicacion = casoDeUsoRegistrarUbicacion;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/nuevo")
    public UUID registrarUbicaion(@RequestBody UbicacionDto dto){
        return this.casoDeUsoRegistrarUbicacion.ejecutarRegistro(dto);
    }

}
