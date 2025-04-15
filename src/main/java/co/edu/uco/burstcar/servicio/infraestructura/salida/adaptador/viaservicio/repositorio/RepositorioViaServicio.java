package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.viaservicio.repositorio;

import co.edu.uco.burstcar.servicio.dominio.modelo.DelimitacionServicio;
import co.edu.uco.burstcar.servicio.dominio.modelo.ViaServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.viaservicio.entidad.EntidadViaServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.viaservicio.repositorio.jpa.RepositorioViaServicioJpa;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioViaServicio implements co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioViaServicio {

    private final RepositorioViaServicioJpa repositorioViaServicioJpa;

    public RepositorioViaServicio(RepositorioViaServicioJpa repositorioViaServicioJpa) {
        this.repositorioViaServicioJpa = repositorioViaServicioJpa;
    }

    @Override
    public ViaServicio asociarViaUbicacionServicio(String nombre) {
        EntidadViaServicio entidadViaServicio = this.repositorioViaServicioJpa.findByNombre(nombre);
        if(entidadViaServicio == null){
            return null;
        }
        return ViaServicio.nuevaViaConIdentificador(entidadViaServicio.getIdentificador(), entidadViaServicio.getNombre());
    }
}
