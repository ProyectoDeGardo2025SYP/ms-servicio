package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.estadooferta.repositorio;

import co.edu.uco.burstcar.servicio.dominio.modelo.EstadoOferta;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.estadooferta.entidad.EntidadEstadoOferta;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.estadooferta.repositorio.jpa.RepositorioEstadoOfertaJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioEstadoOferta implements co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioEstadoOferta {

    private final RepositorioEstadoOfertaJpa repositorioEstadoOfertaJpa;

    public RepositorioEstadoOferta(RepositorioEstadoOfertaJpa repositorioEstadoOfertaJpa) {
        this.repositorioEstadoOfertaJpa = repositorioEstadoOfertaJpa;
    }


    @Override
    public EstadoOferta asociarEstadoOferta(String nombre) {
        EntidadEstadoOferta entidadEstadoOferta = this.repositorioEstadoOfertaJpa.findByNombre(nombre);
        if(entidadEstadoOferta == null){
            return null;
        }
        return EstadoOferta.nuevoEstadoOfertaConIdentificador(entidadEstadoOferta.getIdentificador(),
                entidadEstadoOferta.getDescripcion(), entidadEstadoOferta.getNombre());
    }

    @Override
    public List<EstadoOferta> consultarEstadosOferta() {
        return null;
    }
}
