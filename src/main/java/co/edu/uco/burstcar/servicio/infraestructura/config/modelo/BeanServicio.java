package co.edu.uco.burstcar.servicio.infraestructura.config.modelo;

import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioServicio;
import co.edu.uco.burstcar.servicio.dominio.servicio.servicio.ServicioConsultarServicio;
import co.edu.uco.burstcar.servicio.dominio.servicio.servicio.ServicioEliminarDeManeraLogicaServicio;
import co.edu.uco.burstcar.servicio.dominio.servicio.servicio.ServicioRegistrarServicio;
import co.edu.uco.burstcar.servicio.dominio.servicio.servicio.ServicioSegumientoServicio;
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
    public ServicioConsultarServicio servicioConsultarServicio(RepositorioServicio repositorioServicio){
        return new ServicioConsultarServicio(repositorioServicio);
    }

    @Bean
    public ServicioSegumientoServicio servicioSegumientoServicio(RepositorioServicio repositorioServicio){
        return new ServicioSegumientoServicio(repositorioServicio);
    }
}
