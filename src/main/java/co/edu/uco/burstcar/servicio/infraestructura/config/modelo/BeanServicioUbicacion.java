package co.edu.uco.burstcar.servicio.infraestructura.config.modelo;

import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioUbicacion;
import co.edu.uco.burstcar.servicio.dominio.servicio.ubicacion.ServicioActualizarUbicacion;
import co.edu.uco.burstcar.servicio.dominio.servicio.ubicacion.ServicioConsultaUbicacion;
import co.edu.uco.burstcar.servicio.dominio.servicio.ubicacion.ServicioRegistrarUbicacion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioUbicacion {

    @Bean
    public ServicioRegistrarUbicacion servicioRegistrarUbicacion(RepositorioUbicacion repositorioUbicacion){
        return new ServicioRegistrarUbicacion(repositorioUbicacion);
    }

    @Bean
    public ServicioActualizarUbicacion servicioActualizarUbicacion(RepositorioUbicacion repositorioUbicacion){
        return new ServicioActualizarUbicacion(repositorioUbicacion);
    }

    @Bean
    public ServicioConsultaUbicacion servicioConsultaUbicacion(RepositorioUbicacion repositorioUbicacion){
        return new ServicioConsultaUbicacion(repositorioUbicacion);
    }
}
