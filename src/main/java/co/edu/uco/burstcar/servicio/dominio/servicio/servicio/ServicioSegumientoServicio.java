package co.edu.uco.burstcar.servicio.dominio.servicio.servicio;

import co.edu.uco.burstcar.servicio.dominio.modelo.UbicacionServicio;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioServicio;

public class ServicioSegumientoServicio {

    private final RepositorioServicio repositorioServicio;

    public ServicioSegumientoServicio(RepositorioServicio repositorioServicio) {
        this.repositorioServicio = repositorioServicio;
    }

    public void ejecutarSeguimiento(UbicacionServicio ubicacionServicio){
        this.repositorioServicio.realizarSeguimientoServicio(ubicacionServicio);
    }
}
