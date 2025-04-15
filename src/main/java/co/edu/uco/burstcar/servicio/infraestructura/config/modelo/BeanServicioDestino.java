package co.edu.uco.burstcar.servicio.infraestructura.config.modelo;

import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioDestino;
import co.edu.uco.burstcar.servicio.dominio.servicio.destino.ServicioActualizarDestino;
import co.edu.uco.burstcar.servicio.dominio.servicio.destino.ServicioConsultaDestino;
import co.edu.uco.burstcar.servicio.dominio.servicio.destino.ServicioRegistrarDestino;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioDestino {

    @Bean
    public ServicioRegistrarDestino servicioRegistrarDestino(RepositorioDestino repositorioDestino){
        return new ServicioRegistrarDestino(repositorioDestino);
    }

    @Bean
    public ServicioActualizarDestino servicioActualizarDestino(RepositorioDestino repositorioDestino){
        return new ServicioActualizarDestino(repositorioDestino);
    }

    @Bean
    public ServicioConsultaDestino servicioConsultaDestino(RepositorioDestino repositorioDestino){
        return new ServicioConsultaDestino(repositorioDestino);
    }
}
