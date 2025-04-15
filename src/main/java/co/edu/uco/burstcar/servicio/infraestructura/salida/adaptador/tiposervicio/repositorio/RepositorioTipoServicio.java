package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.tiposervicio.repositorio;

import co.edu.uco.burstcar.servicio.dominio.modelo.TipoServicio;
import co.edu.uco.burstcar.servicio.dominio.modelo.ViaServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.tiposervicio.entidad.EntidadTipoServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.tiposervicio.repositorio.jpa.RepositorioTipoServicioJpa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioTipoServicio implements co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioTipoServicio {

    private final RepositorioTipoServicioJpa repositorioTipoServicioJpa;

    public RepositorioTipoServicio(RepositorioTipoServicioJpa repositorioTipoServicioJpa) {
        this.repositorioTipoServicioJpa = repositorioTipoServicioJpa;
    }


    @Override
    public TipoServicio asociarTipoServicio(String nombre) {
        EntidadTipoServicio entidadTipoServicio = this.repositorioTipoServicioJpa.findByNombre(nombre);
        if(entidadTipoServicio == null){
            return null;
        }
        return TipoServicio.nuevoTipoServicioConIdentificador(
                entidadTipoServicio.getIdentificador(),
                entidadTipoServicio.getDescripcion(), entidadTipoServicio.getNombre());
    }

    @Override
    public List<TipoServicio> consultarTiposServicios() {
        return null;
    }
}
