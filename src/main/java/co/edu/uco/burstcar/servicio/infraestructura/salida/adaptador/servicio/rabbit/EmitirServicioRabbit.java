package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.servicio.rabbit;

import co.edu.uco.burstcar.servicio.dominio.dto.ServicioEmisorDto;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioEmitirServicio;
import co.edu.uco.burstcar.servicio.infraestructura.config.general.rabbit.servicio.PropiedadesConfiguracionServicioRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmitirServicioRabbit implements RepositorioEmitirServicio {

    private final RabbitTemplate rabbit;
    private final PropiedadesConfiguracionServicioRabbit propiedadesConfiguracionServicioRabbit;

    public EmitirServicioRabbit(RabbitTemplate rabbit, PropiedadesConfiguracionServicioRabbit propiedadesConfiguracionServicioRabbit) {
        this.rabbit = rabbit;
        this.propiedadesConfiguracionServicioRabbit = propiedadesConfiguracionServicioRabbit;
    }

    @Override
    public void emitirInformacionServicio(ServicioEmisorDto emisorDto) {
        this.rabbit.convertAndSend(propiedadesConfiguracionServicioRabbit.getExchange(),
                propiedadesConfiguracionServicioRabbit.getClave(), emisorDto);
    }
}
