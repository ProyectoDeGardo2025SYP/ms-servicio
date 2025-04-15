package co.edu.uco.burstcar.servicio.dominio.servicio.ubicacion;

import co.edu.uco.burstcar.servicio.dominio.modelo.UbicacionServicio;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioUbicacion;

import java.util.UUID;

public class ServicioConsultaUbicacion {
    private final RepositorioUbicacion repositorioUbicacion;

    public ServicioConsultaUbicacion(RepositorioUbicacion repositorioUbicacion) {
        this.repositorioUbicacion = repositorioUbicacion;
    }

    public UbicacionServicio ejecutarConsulta(UUID id){
        return this.repositorioUbicacion.consultarUbicacion(id);
    }
}
