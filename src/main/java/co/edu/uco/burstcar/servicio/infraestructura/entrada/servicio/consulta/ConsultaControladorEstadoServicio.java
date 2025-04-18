package co.edu.uco.burstcar.servicio.infraestructura.entrada.servicio.consulta;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.consulta.CasoDeUsoConsultarEstadoServicio;
import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.consulta.CasoDeUsoConsultarServicio;
import co.edu.uco.burstcar.servicio.dominio.modelo.EstadoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/servicio")
public class ConsultaControladorEstadoServicio {

    private final CasoDeUsoConsultarServicio casoDeUsoConsultarServicio;
    private final CasoDeUsoConsultarEstadoServicio consultarEstadoServicio;

    public ConsultaControladorEstadoServicio(CasoDeUsoConsultarServicio casoDeUsoConsultarServicio, CasoDeUsoConsultarEstadoServicio consultarEstadoServicio) {
        this.casoDeUsoConsultarServicio = casoDeUsoConsultarServicio;
        this.consultarEstadoServicio = consultarEstadoServicio;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/estado")
    public EstadoServicio consultarEstadoServicio(@PathVariable UUID id){
        return this.consultarEstadoServicio.ejecutarConsulta(id);
    }
}
