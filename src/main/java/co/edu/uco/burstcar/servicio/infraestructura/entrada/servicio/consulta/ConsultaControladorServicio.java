package co.edu.uco.burstcar.servicio.infraestructura.entrada.servicio.consulta;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.consulta.CasoDeUsoConsultarServicio;
import co.edu.uco.burstcar.servicio.dominio.dto.ServicioDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/servicio")
public class ConsultaControladorServicio {

    private final CasoDeUsoConsultarServicio casoDeUsoConsultarServicio;

    public ConsultaControladorServicio(CasoDeUsoConsultarServicio casoDeUsoConsultarServicio) {
        this.casoDeUsoConsultarServicio = casoDeUsoConsultarServicio;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/todos/{id}")
    public List<ServicioDto> consultarServicios(@PathVariable UUID id){
        return this.casoDeUsoConsultarServicio.ejecutarConsulta(id);
    }
}
