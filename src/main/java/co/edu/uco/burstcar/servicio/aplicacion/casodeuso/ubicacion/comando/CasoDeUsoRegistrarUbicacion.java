package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.ubicacion.comando;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.ubicacion.comando.dto.UbicacionDto;
import co.edu.uco.burstcar.servicio.aplicacion.mapeador.ubicacion.impl.MapeadorUbicacionAplicacion;
import co.edu.uco.burstcar.servicio.dominio.servicio.ubicacion.ServicioRegistrarUbicacion;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CasoDeUsoRegistrarUbicacion {
    private final ServicioRegistrarUbicacion servicioRegistrarUbicacion;
    private final MapeadorUbicacionAplicacion mapeadorUbicacionAplicacion;

    public CasoDeUsoRegistrarUbicacion(ServicioRegistrarUbicacion servicioRegistrarUbicacion, MapeadorUbicacionAplicacion mapeadorUbicacionAplicacion) {
        this.servicioRegistrarUbicacion = servicioRegistrarUbicacion;
        this.mapeadorUbicacionAplicacion = mapeadorUbicacionAplicacion;
    }


    public UUID ejecutarRegistro(UbicacionDto dto) {
        return this.servicioRegistrarUbicacion.ejecutarRegistro(
                this.mapeadorUbicacionAplicacion.aDominio(dto));

    }
}