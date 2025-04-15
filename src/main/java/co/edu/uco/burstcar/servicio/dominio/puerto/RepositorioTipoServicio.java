package co.edu.uco.burstcar.servicio.dominio.puerto;

import co.edu.uco.burstcar.servicio.dominio.modelo.TipoServicio;

import java.util.List;

public interface RepositorioTipoServicio {

    TipoServicio asociarTipoServicio(String nombre);
    List<TipoServicio> consultarTiposServicios();
}
