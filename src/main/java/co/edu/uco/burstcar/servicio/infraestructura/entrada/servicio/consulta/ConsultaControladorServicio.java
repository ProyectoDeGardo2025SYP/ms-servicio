package co.edu.uco.burstcar.servicio.infraestructura.entrada.servicio.consulta;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.consulta.CasoDeUsoConsultarEstadoServicio;
import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.consulta.CasoDeUsoConsultarInformacionServicios;
import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.consulta.CasoDeUsoConsultarInformacionServiciosPorSolicitante;
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
    private final CasoDeUsoConsultarInformacionServiciosPorSolicitante casoDeUsoConsultarInformacionServiciosPorSolicitante;
    private final CasoDeUsoConsultarEstadoServicio consultarEstadoServicio;
    private final CasoDeUsoConsultarServicio casoDeUsoConsultarServicio;


    public ConsultaControladorServicio(CasoDeUsoConsultarInformacionServicios casoDeUsoConsultarInformacionServicios, CasoDeUsoConsultarInformacionServiciosPorSolicitante casoDeUsoConsultarInformacionServiciosPorSolicitante, CasoDeUsoConsultarEstadoServicio consultarEstadoServicio, CasoDeUsoConsultarServicio casoDeUsoConsultarServicio) {
        this.casoDeUsoConsultarInformacionServicios = casoDeUsoConsultarInformacionServicios;
        this.casoDeUsoConsultarInformacionServiciosPorSolicitante = casoDeUsoConsultarInformacionServiciosPorSolicitante;
        this.consultarEstadoServicio = consultarEstadoServicio;
        this.casoDeUsoConsultarServicio = casoDeUsoConsultarServicio;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/todos")
    public PaginaDto<ServicioDto> consultarServicios(@RequestParam Double latitud,
                                                     @RequestParam Double longitud,
                                                     @RequestParam(defaultValue = "0") int pagina,
                                                     @RequestParam(defaultValue = "3") int cantidad){
        return this.casoDeUsoConsultarInformacionServicios.ejecutarConsulta(latitud, longitud, pagina, cantidad);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/todos/solicitante/{solicitante}")
    public PaginaDto<ServicioDto> consultarServiciosPorSolicitante(@PathVariable String solicitante,
                                                     @RequestParam(defaultValue = "0") int pagina,
                                                     @RequestParam(defaultValue = "3") int cantidad){
        return this.casoDeUsoConsultarInformacionServiciosPorSolicitante.ejecutarConsulta(solicitante, pagina, cantidad);
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
