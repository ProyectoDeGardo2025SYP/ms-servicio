package co.edu.uco.burstcar.servicio.infraestructura.config.general.rabbit.solicitanteservicio;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConfiguracionSolicitanteRabbit {

    private final PropiedadesConfiguracionSolicitanteRabbit propiedadesConfiguracionSolicitanteRabbit;

    public ConfiguracionSolicitanteRabbit(PropiedadesConfiguracionSolicitanteRabbit propiedadesConfiguracionSolicitanteRabbit) {
        this.propiedadesConfiguracionSolicitanteRabbit = propiedadesConfiguracionSolicitanteRabbit;
    }

    @Bean
    public TopicExchange solicitanteExchange() {
        return new TopicExchange(propiedadesConfiguracionSolicitanteRabbit.getExchange());
    }

    @Bean
    public Queue solicitanteCola() {
        return QueueBuilder.durable(propiedadesConfiguracionSolicitanteRabbit.getCola())
                .withArgument("x-dead-letter-exchange", propiedadesConfiguracionSolicitanteRabbit.getDlx())
                .withArgument("x-dead-letter-routing-key", propiedadesConfiguracionSolicitanteRabbit.getDlq())
                .build();
    }

    @Bean
    public Binding solicitanteEnlace() {
        return BindingBuilder.bind(solicitanteCola())
                .to(solicitanteExchange())
                .with(propiedadesConfiguracionSolicitanteRabbit.getClave());
    }

    @Bean
    public DirectExchange solicitanteDLX() {
        return new DirectExchange(propiedadesConfiguracionSolicitanteRabbit.getDlx());
    }

    @Bean
    public Queue solicitanteDLQ() {
        return QueueBuilder.durable(propiedadesConfiguracionSolicitanteRabbit.getDlq()).build();
    }

    @Bean
    public Binding solicitanteDlqEnlace() {
        return BindingBuilder.bind(solicitanteDLQ())
                .to(solicitanteDLX())
                .with(propiedadesConfiguracionSolicitanteRabbit.getDlq());
    }
}
