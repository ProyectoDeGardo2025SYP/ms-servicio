package co.edu.uco.burstcar.servicio.dominio.servicio.servicio;

import co.edu.uco.burstcar.servicio.dominio.modelo.Servicio;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioServicio;

import java.util.UUID;

public class ServicioRegistrarServicio {

    private final RepositorioServicio repositorioServicio;

    public ServicioRegistrarServicio(RepositorioServicio repositorioServicio) {
        this.repositorioServicio = repositorioServicio;
    }

    public UUID ejecutarRegistro(Servicio servicio){
        return this.repositorioServicio.registrarInformacionServicio(servicio);
    }
}
