package co.edu.uco.burstcar.servicio.infraestructura.entrada.prestadorservicio.comando;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.prestadorservicio.comando.CasoDeUsoRegistrarPrestador;
import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.prestadorservicio.comando.dto.PrestadorDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PrestadorReceptor {

    private final CasoDeUsoRegistrarPrestador casoDeUsoRegistrarPrestador;

    public PrestadorReceptor(CasoDeUsoRegistrarPrestador casoDeUsoRegistrarPrestador) {
        this.casoDeUsoRegistrarPrestador = casoDeUsoRegistrarPrestador;
    }


    @RabbitListener(queues = "cola.ms-prestador.registro")
    public void ejecutarRegistro(PrestadorDto dto){
        this.casoDeUsoRegistrarPrestador.ejecutarRegistro(dto);
    }
}
