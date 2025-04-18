package co.edu.uco.burstcar.servicio.infraestructura.entrada.servicio.comando;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.comando.CasoDeUsoActualizarEstadoServicio;
import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.comando.CasoDeUsoActualizarInformacionServicio;
import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.comando.CasoDeUsoEliminarDeManeraLogicaServicio;
import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.comando.CasoDeUsoRegistrarServicio;
import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.comando.dto.EstadoDto;
import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.comando.dto.ServicioDto;
import co.edu.uco.burstcar.servicio.dominio.dto.ServicioActualizacionDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/servicio")
public class ComandoControladorServicio {

    private final CasoDeUsoRegistrarServicio casoDeUsoRegistrarServicio;
    private final CasoDeUsoEliminarDeManeraLogicaServicio casoDeUsoEliminarDeManeraLogicaServicio;
    private final CasoDeUsoActualizarEstadoServicio casoDeUsoActualizarEstadoServicio;
    private final CasoDeUsoActualizarInformacionServicio casoDeUsoActualizarInformacionServicio;

    public ComandoControladorServicio(CasoDeUsoRegistrarServicio casoDeUsoRegistrarServicio, CasoDeUsoEliminarDeManeraLogicaServicio casoDeUsoEliminarDeManeraLogicaServicio, CasoDeUsoActualizarEstadoServicio casoDeUsoActualizarEstadoServicio, CasoDeUsoActualizarInformacionServicio casoDeUsoActualizarInformacionServicio) {
        this.casoDeUsoRegistrarServicio = casoDeUsoRegistrarServicio;
        this.casoDeUsoEliminarDeManeraLogicaServicio = casoDeUsoEliminarDeManeraLogicaServicio;
        this.casoDeUsoActualizarEstadoServicio = casoDeUsoActualizarEstadoServicio;
        this.casoDeUsoActualizarInformacionServicio = casoDeUsoActualizarInformacionServicio;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/nuevo")
    public UUID registrarServicio(@RequestBody ServicioDto dto){
        return this.casoDeUsoRegistrarServicio.ejecutarRegistro(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}/elimincacion")
    public void eliminarLogicamenteServicio(@RequestBody EstadoDto dto, @PathVariable UUID id){
        this.casoDeUsoEliminarDeManeraLogicaServicio.ejecutarEliminacionLogica(dto, id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}/cambio")
    public void actualizarEstadoServicio(@RequestBody EstadoDto dto, @PathVariable UUID id){
        this.casoDeUsoActualizarEstadoServicio.ejecutarActualizacionEstadoServicio(dto, id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}/cambio/informacion")
    public void actualizarInformacionServicio(@RequestBody ServicioActualizacionDto dto, @PathVariable UUID id){
        this.casoDeUsoActualizarInformacionServicio.ejecutarActualizacionInformacionServicio(dto, id);
    }
}
