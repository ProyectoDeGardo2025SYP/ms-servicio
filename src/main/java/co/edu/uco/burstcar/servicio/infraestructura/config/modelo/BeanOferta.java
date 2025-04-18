package co.edu.uco.burstcar.servicio.infraestructura.config.modelo;

import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioOferta;
import co.edu.uco.burstcar.servicio.dominio.servicio.oferta.ServicioActualizarEstadoOferta;
import co.edu.uco.burstcar.servicio.dominio.servicio.oferta.ServicioAnalizarCostoOferta;
import co.edu.uco.burstcar.servicio.dominio.servicio.oferta.ServicioConsultarOferta;
import co.edu.uco.burstcar.servicio.dominio.servicio.oferta.ServicioRegistrarOferta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanOferta {

    @Bean
    public ServicioRegistrarOferta servicioRegistrarOferta(RepositorioOferta repositorioOferta){
        return new ServicioRegistrarOferta(repositorioOferta);
    }

    @Bean
    public ServicioAnalizarCostoOferta servicioAnalizarCostoOferta(){
        return new ServicioAnalizarCostoOferta();
    }

    @Bean
    public ServicioConsultarOferta servicioConsultarOferta(RepositorioOferta repositorioOferta){
        return new ServicioConsultarOferta(repositorioOferta);
    }

    @Bean
    public ServicioActualizarEstadoOferta servicioActualizarEstadoOferta(RepositorioOferta repositorioOferta){
        return new ServicioActualizarEstadoOferta(repositorioOferta);
    }
}
