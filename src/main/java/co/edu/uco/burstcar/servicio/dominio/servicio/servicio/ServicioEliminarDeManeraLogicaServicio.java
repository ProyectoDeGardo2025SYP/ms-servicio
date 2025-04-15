package co.edu.uco.burstcar.servicio.dominio.servicio.servicio;

import co.edu.uco.burstcar.servicio.dominio.modelo.EstadoServicio;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioServicio;

import java.util.UUID;

public class ServicioEliminarDeManeraLogicaServicio {
    private final RepositorioServicio repositorioServicio;

    public ServicioEliminarDeManeraLogicaServicio(RepositorioServicio repositorioServicio) {
        this.repositorioServicio = repositorioServicio;
    }

    public void ejecutarElimincaionLogica(EstadoServicio estadoServicio, UUID idServcio){
        this.repositorioServicio.eliminarLogicamenteInformacionServicio(estadoServicio, idServcio);
    }
}
