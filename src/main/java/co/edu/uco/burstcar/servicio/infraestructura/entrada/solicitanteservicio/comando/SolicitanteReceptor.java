package co.edu.uco.burstcar.servicio.infraestructura.entrada.solicitanteservicio.comando;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.solicitanteservicio.comando.CasoDeUsoRegistrarSolicitante;
import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.solicitanteservicio.comando.dto.SolicitanteDto;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.solicitanteservicio.entidad.EntidadSolicitanteServicio;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SolicitanteReceptor {

    private final CasoDeUsoRegistrarSolicitante casoDeUsoRegistrarSolicitante;

    public SolicitanteReceptor(CasoDeUsoRegistrarSolicitante casoDeUsoRegistrarSolicitante) {
        this.casoDeUsoRegistrarSolicitante = casoDeUsoRegistrarSolicitante;
    }


    @RabbitListener(queues = "cola.ms-solicitante.registro")
    public void ejecutarRegistro(SolicitanteDto dto){
        this.casoDeUsoRegistrarSolicitante.ejecutarRegistro(dto);
    }
}
