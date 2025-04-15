package co.edu.uco.burstcar.servicio.dominio.servicio.ubicacion;

import co.edu.uco.burstcar.servicio.dominio.modelo.UbicacionServicio;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioUbicacion;

public class ServicioActualizarUbicacion {
    private final RepositorioUbicacion repositorioUbicacion;

    public ServicioActualizarUbicacion(RepositorioUbicacion repositorioUbicacion) {
        this.repositorioUbicacion = repositorioUbicacion;
    }


    public void ejecutarActualizacion(UbicacionServicio ubicacionServicio){
        this.repositorioUbicacion.actualizarUbicacion(ubicacionServicio);
    }
}
