package co.edu.uco.burstcar.servicio.infraestructura.config.general.rabbit.prestadorservicio;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConfiguracionPrestadorRabbit {

    private final PropiedadesConfiguracionPrestadorRabbit propiedadesConfiguracionPrestadorRabbit;

    public ConfiguracionPrestadorRabbit(PropiedadesConfiguracionPrestadorRabbit propiedadesConfiguracionPrestadorRabbit) {
        this.propiedadesConfiguracionPrestadorRabbit = propiedadesConfiguracionPrestadorRabbit;
    }

    @Bean
    public TopicExchange prestadorExchange() {
        return new TopicExchange(propiedadesConfiguracionPrestadorRabbit.getExchange());
    }

    @Bean
    public Queue prestadorCola() {
        return QueueBuilder.durable(propiedadesConfiguracionPrestadorRabbit.getCola())
                .withArgument("x-dead-letter-exchange", propiedadesConfiguracionPrestadorRabbit.getDlx())
                .withArgument("x-dead-letter-routing-key", propiedadesConfiguracionPrestadorRabbit.getDlq())
                .build();
    }

    @Bean
    public Binding prestadorEnlace() {
        return BindingBuilder.bind(prestadorCola())
                .to(prestadorExchange())
                .with(propiedadesConfiguracionPrestadorRabbit.getClave());
    }

    @Bean
    public DirectExchange prestadorDLX() {
        return new DirectExchange(propiedadesConfiguracionPrestadorRabbit.getDlx());
    }

    @Bean
    public Queue prestadorDLQ() {
        return QueueBuilder.durable(propiedadesConfiguracionPrestadorRabbit.getDlq()).build();
    }

    @Bean
    public Binding prestadorDlqEnlace() {
        return BindingBuilder.bind(prestadorDLQ())
                .to(prestadorDLX())
                .with(propiedadesConfiguracionPrestadorRabbit.getDlq());
    }
}
