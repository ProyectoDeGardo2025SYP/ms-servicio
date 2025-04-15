package co.edu.uco.burstcar.servicio.dominio.servicio.destino;

import co.edu.uco.burstcar.servicio.dominio.modelo.DestinoServicio;
import co.edu.uco.burstcar.servicio.dominio.modelo.UbicacionServicio;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioDestino;

import java.util.UUID;

public class ServicioConsultaDestino {
    private final RepositorioDestino repositorioDestino;

    public ServicioConsultaDestino(RepositorioDestino repositorioDestino) {
        this.repositorioDestino = repositorioDestino;
    }


    public DestinoServicio ejecutarConsulta(UUID id){
        return this.repositorioDestino.consultarInformacionDestino(id);
    }
}
