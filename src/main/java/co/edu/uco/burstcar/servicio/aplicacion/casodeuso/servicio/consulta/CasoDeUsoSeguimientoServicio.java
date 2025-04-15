package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.consulta;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.ubicacion.comando.dto.UbicacionDto;
import co.edu.uco.burstcar.servicio.dominio.servicio.servicio.ServicioSegumientoServicio;
import org.springframework.stereotype.Component;

@Component
public class CasoDeUsoSeguimientoServicio {
    private final ServicioSegumientoServicio servicioSegumientoServicio;

    public CasoDeUsoSeguimientoServicio(ServicioSegumientoServicio servicioSegumientoServicio) {
        this.servicioSegumientoServicio = servicioSegumientoServicio;
    }

    public void ejecutarSegumiento(UbicacionDto dto) {
        //this.servicioSegumientoServicio.ejecutarSeguimiento();

    }
}