package co.edu.uco.burstcar.servicio.infraestructura.config.modelo;

import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioPrestadorServicio;
import co.edu.uco.burstcar.servicio.dominio.servicio.prestadorservicio.ServicioRegistrarPrestador;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioPrestador {

    @Bean
    public ServicioRegistrarPrestador servicioRegistrarPrestador(RepositorioPrestadorServicio repositorioPrestadorServicio){
        return new ServicioRegistrarPrestador(repositorioPrestadorServicio);
    }
}
