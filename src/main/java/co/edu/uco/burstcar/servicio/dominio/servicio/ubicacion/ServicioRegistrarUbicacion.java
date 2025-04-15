package co.edu.uco.burstcar.servicio.dominio.servicio.ubicacion;

import co.edu.uco.burstcar.servicio.dominio.modelo.UbicacionServicio;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioUbicacion;

import java.util.UUID;

public class ServicioRegistrarUbicacion {
    private final RepositorioUbicacion repositorioUbicacion;

    public ServicioRegistrarUbicacion(RepositorioUbicacion repositorioUbicacion) {
        this.repositorioUbicacion = repositorioUbicacion;
    }

    public UUID ejecutarRegistro(UbicacionServicio ubicacion){
        return this.repositorioUbicacion.registrarUbicacionServicio(ubicacion);
    }
}
