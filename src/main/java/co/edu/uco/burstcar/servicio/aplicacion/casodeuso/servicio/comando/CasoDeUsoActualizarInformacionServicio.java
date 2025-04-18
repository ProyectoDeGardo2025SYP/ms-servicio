package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.servicio.comando;

import co.edu.uco.burstcar.servicio.dominio.dto.ServicioActualizacionDto;
import co.edu.uco.burstcar.servicio.dominio.servicio.servicio.ServicioActualizarInformacionServicio;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CasoDeUsoActualizarInformacionServicio {
    private final ServicioActualizarInformacionServicio servicioActualizarInformacionServicio;

    public CasoDeUsoActualizarInformacionServicio(ServicioActualizarInformacionServicio servicioActualizarInformacionServicio) {
        this.servicioActualizarInformacionServicio = servicioActualizarInformacionServicio;
    }

    public void ejecutarActualizacionInformacionServicio(ServicioActualizacionDto dto, UUID idServcio) {
        this.servicioActualizarInformacionServicio.ejecutarActualizacion(dto, idServcio);

    }
}