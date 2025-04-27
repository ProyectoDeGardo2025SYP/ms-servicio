package co.edu.uco.burstcar.servicio.infraestructura.entrada.servicio.consulta;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.consulta.CasoDeUsoConsultarEstadoServicio;
import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.consulta.CasoDeUsoConsultarInformacionServicios;
import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.consulta.CasoDeUsoConsultarServicio;
import co.edu.uco.burstcar.servicio.dominio.dto.PaginaDto;
import co.edu.uco.burstcar.servicio.dominio.dto.ServicioDto;
import co.edu.uco.burstcar.servicio.dominio.modelo.EstadoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/servicio")
public class ConsultaControladorServicio {

    private final CasoDeUsoConsultarInformacionServicios casoDeUsoConsultarInformacionServicios;
    private final CasoDeUsoConsultarEstadoServicio consultarEstadoServicio;
    private final CasoDeUsoConsultarServicio casoDeUsoConsultarServicio;


    public ConsultaControladorServicio(CasoDeUsoConsultarInformacionServicios casoDeUsoConsultarInformacionServicios, CasoDeUsoConsultarEstadoServicio consultarEstadoServicio, CasoDeUsoConsultarServicio casoDeUsoConsultarServicio) {
        this.casoDeUsoConsultarInformacionServicios = casoDeUsoConsultarInformacionServicios;
        this.consultarEstadoServicio = consultarEstadoServicio;
        this.casoDeUsoConsultarServicio = casoDeUsoConsultarServicio;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/todos/{id}")
    public PaginaDto<ServicioDto> consultarServicios(@PathVariable UUID id,
                                                     @RequestParam(defaultValue = "0") int pagina,
                                                     @RequestParam(defaultValue = "3") int cantidad){
        return this.casoDeUsoConsultarInformacionServicios.ejecutarConsulta(id, pagina, cantidad);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/estado")
    public EstadoServicio consultarEstadoServicio(@PathVariable UUID id){
        return this.consultarEstadoServicio.ejecutarConsulta(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/informacion/{id}")
    public ServicioDto consultarServicio(@PathVariable UUID id){
        return this.casoDeUsoConsultarServicio.ejecutarConsulta(id);
    }
}
