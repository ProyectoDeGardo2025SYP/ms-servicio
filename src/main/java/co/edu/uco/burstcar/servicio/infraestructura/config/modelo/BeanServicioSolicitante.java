package co.edu.uco.burstcar.servicio.infraestructura.config.modelo;

import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioSolicitanteServicio;
import co.edu.uco.burstcar.servicio.dominio.servicio.solicitanteservicio.ServicioRegistrarSolicitante;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioSolicitante {

    @Bean
    public ServicioRegistrarSolicitante servicioRegistrarSolicitante(RepositorioSolicitanteServicio repositorioSolicitanteServicio){
        return new ServicioRegistrarSolicitante(repositorioSolicitanteServicio);
    }
}
