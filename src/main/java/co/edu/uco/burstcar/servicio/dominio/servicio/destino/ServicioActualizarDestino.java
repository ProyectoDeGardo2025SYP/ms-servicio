package co.edu.uco.burstcar.servicio.dominio.servicio.destino;

import co.edu.uco.burstcar.servicio.dominio.modelo.DestinoServicio;
import co.edu.uco.burstcar.servicio.dominio.modelo.UbicacionServicio;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioDestino;

public class ServicioActualizarDestino {
    private final RepositorioDestino repositorioDestino;

    public ServicioActualizarDestino(RepositorioDestino repositorioDestino) {
        this.repositorioDestino = repositorioDestino;
    }


    public void ejecutarActualizacion(DestinoServicio destinoServicio){
        this.repositorioDestino.actualizarDestino(destinoServicio);
    }
}
