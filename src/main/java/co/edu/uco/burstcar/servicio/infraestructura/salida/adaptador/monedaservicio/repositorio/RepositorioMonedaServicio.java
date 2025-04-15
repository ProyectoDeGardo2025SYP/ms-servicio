package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.monedaservicio.repositorio;

import co.edu.uco.burstcar.servicio.dominio.modelo.MonedaServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.monedaservicio.entidad.EntidadMonedaServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.monedaservicio.repositorio.jpa.RepositorioMonedaServicioJpa;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMonedaServicio implements co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioMonedaServicio {

    private final RepositorioMonedaServicioJpa repositorioMonedaServicioJpa;

    public RepositorioMonedaServicio(RepositorioMonedaServicioJpa repositorioMonedaServicioJpa) {
        this.repositorioMonedaServicioJpa = repositorioMonedaServicioJpa;
    }

    @Override
    public MonedaServicio asociarMonedaServicio(String nombre) {
        EntidadMonedaServicio entidadMonedaServicio = this.repositorioMonedaServicioJpa.findByNombre(nombre);
        if(entidadMonedaServicio == null){
            return null;
        }
        return MonedaServicio.nuevaMonedaServcioConIdentificador(
                entidadMonedaServicio.getIdentificador(),
                entidadMonedaServicio.getDescripcion(), entidadMonedaServicio.getNombre());
    }
}
