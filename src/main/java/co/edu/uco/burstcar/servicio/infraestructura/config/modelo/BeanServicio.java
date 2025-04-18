package co.edu.uco.burstcar.servicio.infraestructura.config.modelo;

import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioServicio;
import co.edu.uco.burstcar.servicio.dominio.servicio.servicio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioRegistrarServicio servicioRegistrarServicio(RepositorioServicio repositorioServicio){
        return new ServicioRegistrarServicio(repositorioServicio);
    }

    @Bean
    public ServicioEliminarDeManeraLogicaServicio servicioEliminarDeManeraLogicaServicio(RepositorioServicio repositorioServicio){
        return new ServicioEliminarDeManeraLogicaServicio(repositorioServicio);
    }

    @Bean
    public ServicioActualizarEstadoServicio servicioActualizarEstadoServicio(RepositorioServicio repositorioServicio){
        return new ServicioActualizarEstadoServicio(repositorioServicio);
    }

    @Bean
    public ServicioConsultarEstadoServicio servicioConsultarEstadoServicio(RepositorioServicio repositorioServicio){
        return new ServicioConsultarEstadoServicio(repositorioServicio);
    }

    @Bean
    public ServicioActualizarInformacionServicio servicioActualizarInformacionServicio(RepositorioServicio repositorioServicio){
        return new ServicioActualizarInformacionServicio(repositorioServicio);
    }

    @Bean
    public ServicioConsultarServicio servicioConsultarServicio(RepositorioServicio repositorioServicio){
        return new ServicioConsultarServicio(repositorioServicio);
    }

    @Bean
    public ServicioSegumientoServicio servicioSegumientoServicio(RepositorioServicio repositorioServicio){
        return new ServicioSegumientoServicio(repositorioServicio);
    }
}
