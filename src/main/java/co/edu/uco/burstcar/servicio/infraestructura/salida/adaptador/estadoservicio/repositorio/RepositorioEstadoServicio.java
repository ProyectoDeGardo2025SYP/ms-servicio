package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.estadoservicio.repositorio;

import co.edu.uco.burstcar.servicio.dominio.modelo.EstadoServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.estadoservicio.entidad.EntidadEstadoServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.estadoservicio.repositorio.jpa.RepositorioEstadoServicioJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioEstadoServicio implements co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioEstadoServicio {

    private final RepositorioEstadoServicioJpa repositorioEstadoServicioJpa;

    public RepositorioEstadoServicio(RepositorioEstadoServicioJpa repositorioEstadoServicioJpa) {
        this.repositorioEstadoServicioJpa = repositorioEstadoServicioJpa;
    }


    @Override
    public EstadoServicio asociarEstadoServicio(String nombre) {
        EntidadEstadoServicio entidadEstadoServicio = this.repositorioEstadoServicioJpa.findByNombre(nombre);
        if(entidadEstadoServicio == null){
            return null;
        }
        return EstadoServicio.nuevoEstadoServicioConIdentificador(entidadEstadoServicio.getIdentificador(),
                entidadEstadoServicio.getDescripcion(), entidadEstadoServicio.getNombre());
    }

    @Override
    public List<EstadoServicio> consultarEstadosServicio() {
        return null;
    }
}
