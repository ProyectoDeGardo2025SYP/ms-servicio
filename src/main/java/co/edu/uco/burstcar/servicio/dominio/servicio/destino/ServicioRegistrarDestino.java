package co.edu.uco.burstcar.servicio.dominio.servicio.destino;

import co.edu.uco.burstcar.servicio.dominio.modelo.DestinoServicio;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioDestino;

import java.util.UUID;

public class ServicioRegistrarDestino {
    private final RepositorioDestino repositorioDestino;

    public ServicioRegistrarDestino(RepositorioDestino repositorioDestino) {
        this.repositorioDestino = repositorioDestino;
    }


    public UUID ejecutarRegistro(DestinoServicio destinoServicio){
        return this.repositorioDestino.registrarDestino(destinoServicio);
    }
}
