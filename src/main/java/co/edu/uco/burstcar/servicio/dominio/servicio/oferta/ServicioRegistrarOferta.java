package co.edu.uco.burstcar.servicio.dominio.servicio.oferta;

import co.edu.uco.burstcar.servicio.dominio.modelo.Oferta;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioOferta;

import java.util.UUID;

public class ServicioRegistrarOferta {
    private final RepositorioOferta repositorioOferta;

    public ServicioRegistrarOferta(RepositorioOferta repositorioOferta) {
        this.repositorioOferta = repositorioOferta;
    }


    public UUID ejecutarRegistro(Oferta oferta){
        return this.repositorioOferta.registrarInformacionNuevaOferta(oferta);
    }
}
