package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.oferta.repositorio;

import co.edu.uco.burstcar.servicio.dominio.dto.OfertaDto;
import co.edu.uco.burstcar.servicio.dominio.modelo.EstadoOferta;
import co.edu.uco.burstcar.servicio.dominio.modelo.MonedaServicio;
import co.edu.uco.burstcar.servicio.dominio.modelo.Oferta;
import co.edu.uco.burstcar.servicio.dominio.modelo.Servicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.estadooferta.entidad.EntidadEstadoOferta;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.estadooferta.repositorio.jpa.RepositorioEstadoOfertaJpa;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.monedaservicio.entidad.EntidadMonedaServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.monedaservicio.repositorio.jpa.RepositorioMonedaServicioJpa;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.oferta.entidad.EntidadOferta;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.oferta.repositorio.jpa.RepositorioOfertaJpa;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.prestadorservicio.entidad.EntidadPrestadorServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.prestadorservicio.repositorio.jpa.RepositorioPrestadorServicioJpa;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.servicio.entidad.EntidadServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.servicio.repositorio.jpa.RepositorioServicioJpa;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public class RepositorioOferta implements co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioOferta {

    private final RepositorioOfertaJpa repositorioOfertaJpa;
    private final RepositorioMonedaServicioJpa repositorioMonedaServicioJpa;
    private final RepositorioEstadoOfertaJpa repositorioEstadoOfertaJpa;
    private final RepositorioServicioJpa repositorioServicioJpa;
    private final RepositorioPrestadorServicioJpa repositorioPrestadorServicioJpa;

    public RepositorioOferta(RepositorioOfertaJpa repositorioOfertaJpa, RepositorioMonedaServicioJpa repositorioMonedaServicioJpa, RepositorioEstadoOfertaJpa repositorioEstadoOfertaJpa, RepositorioServicioJpa repositorioServicioJpa, RepositorioPrestadorServicioJpa repositorioPrestadorServicioJpa) {
        this.repositorioOfertaJpa = repositorioOfertaJpa;
        this.repositorioMonedaServicioJpa = repositorioMonedaServicioJpa;
        this.repositorioEstadoOfertaJpa = repositorioEstadoOfertaJpa;
        this.repositorioServicioJpa = repositorioServicioJpa;
        this.repositorioPrestadorServicioJpa = repositorioPrestadorServicioJpa;
    }

    @Override
    public UUID registrarInformacionNuevaOferta(Oferta oferta) {
        EntidadMonedaServicio entidadMonedaServicio = this.repositorioMonedaServicioJpa.findByNombre(oferta.getMonedaServicio().getNombre());
        EntidadEstadoOferta entidadEstadoOferta = this.repositorioEstadoOfertaJpa.findByNombre(oferta.getEstadoOferta().getNombre());
        EntidadServicio entidadServicio = this.repositorioServicioJpa.findById(oferta.getServicio().getIdentificador()).orElse(null);
        EntidadPrestadorServicio entidadPrestadorServicio = this.repositorioPrestadorServicioJpa.findByNumeroIdentificacion(oferta.getPrestadorServicio().getIdentificacionPrestador());

        EntidadOferta entidadOferta = new EntidadOferta(oferta.getDescripcion(), oferta.getCosto(), entidadMonedaServicio, oferta.getFechaInicio(),
                oferta.getFechaFin(), entidadEstadoOferta, entidadServicio, entidadPrestadorServicio);
        entidadOferta.setIdentificador(oferta.getIdentificador());

        return this.repositorioOfertaJpa.save(entidadOferta).getIdentificador();
    }

    @Override
    public void actualizarEstadoOferta(EstadoOferta estadoOferta, UUID identificadorOferta) {
        EntidadOferta entidadOferta = this.repositorioOfertaJpa.findById(identificadorOferta).orElse(null);
        EntidadEstadoOferta entidadEstadoOferta = this.repositorioEstadoOfertaJpa.findByNombre(estadoOferta.getNombre());
        if(entidadEstadoOferta != null){
            entidadOferta.setEntidadEstadoOferta(entidadEstadoOferta);
            this.repositorioOfertaJpa.save(entidadOferta);
        }
    }

    @Override
    public void notificarSolicitanteNegociacionOferta(Oferta oferta) {

    }

    @Override
    public List<OfertaDto> consultarOfertas(UUID servicio) {
        return this.repositorioOfertaJpa.obtenerOfertasDeUnServicio(servicio).stream()
                .map(entidad -> new OfertaDto(entidad.getIdentificador(),
                        entidad.getDescripcion(), entidad.getCosto(), entidad.getEntidadMonedaServicio().getNombre(),
                        entidad.getFechaInicio(), entidad.getFechaFin(), entidad.getEntidadEstadoOferta().getNombre(),
                        entidad.getEntidadServicio().getIdentificador(),
                        entidad.getEntidadPrestadorServicio().getNumeroIdentificacion())).toList();
    }
}
