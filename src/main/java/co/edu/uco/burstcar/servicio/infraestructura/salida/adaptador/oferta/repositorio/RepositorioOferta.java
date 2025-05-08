package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.oferta.repositorio;

import co.edu.uco.burstcar.servicio.dominio.dto.OfertaDto;
import co.edu.uco.burstcar.servicio.dominio.dto.PaginaDto;
import co.edu.uco.burstcar.servicio.dominio.dto.ServicioDto;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        if(entidadOferta != null){
            entidadOferta.setEntidadEstadoOferta(entidadEstadoOferta);
            this.repositorioOfertaJpa.save(entidadOferta);
        }
    }

    @Override
    public void notificarSolicitanteNegociacionOferta(Oferta oferta) {

    }

    @Override
    public PaginaDto<OfertaDto> consultarOfertas(UUID servicio, int pagina, int cantidad) {
        Pageable pageable = PageRequest.of(pagina, cantidad);
        Page<EntidadOferta> entidadOfertas = this.repositorioOfertaJpa.obtenerOfertasDeUnServicio(servicio, pageable);
        return mapeoInfoOferta(entidadOfertas);
    }

    @Override
    public PaginaDto<OfertaDto> consultarOfertasPorPrestador(UUID servicio, String prestador, int pagina, int cantidad) {
        Pageable pageable = PageRequest.of(pagina, cantidad);
        EntidadPrestadorServicio entidadPrestadorServicio = this.repositorioPrestadorServicioJpa.findByNumeroIdentificacion(prestador);

        if (entidadPrestadorServicio == null) {
            return new PaginaDto<>(Collections.emptyList(), pagina, 0, 0);
        }

        Page<EntidadOferta> entidadOfertas = this.repositorioOfertaJpa.obtenerOfertasDeUnServicioPorPrestador(servicio,
                entidadPrestadorServicio.getIdentificador(), pageable);
        return mapeoInfoOferta(entidadOfertas);
    }

    private PaginaDto<OfertaDto> mapeoInfoOferta(Page<EntidadOferta> entidadOfertas){
        List<OfertaDto> ofertaDtos = entidadOfertas.getContent().stream().map(entidad -> new OfertaDto(entidad.getIdentificador(),
                entidad.getDescripcion(), entidad.getCosto(), entidad.getEntidadMonedaServicio().getNombre(),
                entidad.getFechaInicio(), entidad.getFechaFin(), entidad.getEntidadEstadoOferta().getNombre(),
                entidad.getEntidadServicio().getIdentificador(),
                entidad.getEntidadPrestadorServicio().getNumeroIdentificacion())).toList();
        return new PaginaDto<>(ofertaDtos, entidadOfertas.getNumber(), entidadOfertas.getTotalPages(), entidadOfertas.getTotalElements());

    }
}
