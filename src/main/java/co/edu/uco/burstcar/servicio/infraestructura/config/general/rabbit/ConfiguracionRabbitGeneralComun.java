package co.edu.uco.burstcar.servicio.infraestructura.config.general.rabbit;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

@Configuration
public class ConfiguracionRabbitGeneralComun {

    @Bean(name = "conversorJsonGlobal")
    public MessageConverter conversorAJson() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitRececptor(ConnectionFactory conexion,
                                                                @Qualifier("conversorJsonGlobal") MessageConverter mensaje) {
        SimpleRabbitListenerContainerFactory receptor = new SimpleRabbitListenerContainerFactory();
        receptor.setConnectionFactory(conexion);
        receptor.setMessageConverter(mensaje);

        RetryTemplate reintento = new RetryTemplate();
        reintento.setRetryPolicy(new SimpleRetryPolicy(3));
        receptor.setRetryTemplate(reintento);

        return receptor;
    }
}
