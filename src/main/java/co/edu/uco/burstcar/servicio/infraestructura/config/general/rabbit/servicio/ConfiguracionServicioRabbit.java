package co.edu.uco.burstcar.servicio.infraestructura.config.general.rabbit.servicio;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionServicioRabbit {

    private final PropiedadesConfiguracionServicioRabbit propiedadesConfiguracionServicioRabbit;

    public ConfiguracionServicioRabbit(PropiedadesConfiguracionServicioRabbit propiedadesConfiguracionServicioRabbit) {
        this.propiedadesConfiguracionServicioRabbit = propiedadesConfiguracionServicioRabbit;
    }

    @Bean
    public TopicExchange servcioExchange() {
        return new TopicExchange(propiedadesConfiguracionServicioRabbit.getExchange());
    }

    @Bean
    public Queue servicioCola() {
        return new Queue(propiedadesConfiguracionServicioRabbit.getCola(), true);
    }

    @Bean
    public Binding servicioEnlace() {
        return BindingBuilder
                .bind(servicioCola())
                .to(servcioExchange())
                .with(propiedadesConfiguracionServicioRabbit.getClave());
    }

    @Bean
    public RabbitTemplate rabbitClienteEnvio(ConnectionFactory conexion, MessageConverter mesanje) {
        RabbitTemplate plantilla = new RabbitTemplate(conexion);
        plantilla.setMessageConverter(mesanje);
        return plantilla;
    }
}
