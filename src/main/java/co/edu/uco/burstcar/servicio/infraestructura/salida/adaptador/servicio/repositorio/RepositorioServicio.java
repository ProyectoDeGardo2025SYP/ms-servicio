package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.servicio.repositorio;

import co.edu.uco.burstcar.servicio.dominio.dto.ServicioActualizacionDto;
import co.edu.uco.burstcar.servicio.dominio.dto.ServicioDto;
import co.edu.uco.burstcar.servicio.dominio.modelo.*;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.delimitacionservicio.entidad.EntidadDelimitacionServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.delimitacionservicio.repositorio.jpa.RepositorioDelimitacionServicioJpa;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.destino.entidad.EntidadDestino;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.destino.repositorio.jpa.RepositorioDestinoJpa;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.estadoservicio.entidad.EntidadEstadoServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.estadoservicio.repositorio.jpa.RepositorioEstadoServicioJpa;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.monedaservicio.entidad.EntidadMonedaServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.monedaservicio.repositorio.jpa.RepositorioMonedaServicioJpa;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.servicio.entidad.EntidadServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.servicio.repositorio.jpa.RepositorioServicioJpa;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.solicitanteservicio.entidad.EntidadSolicitanteServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.solicitanteservicio.repositorio.jpa.RepositorioSolicitanteServicioJpa;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.tiposervicio.entidad.EntidadTipoServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.tiposervicio.repositorio.jpa.RepositorioTipoServicioJpa;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.ubicacion.entidad.EntidadUbicacion;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.ubicacion.repositorio.jpa.RepositorioUbicacionJpa;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.viaservicio.entidad.EntidadViaServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.viaservicio.repositorio.jpa.RepositorioViaServicioJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class RepositorioServicio implements co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioServicio {

    private final RepositorioServicioJpa repositorioServicioJpa;
    private final RepositorioSolicitanteServicioJpa repositorioSolicitanteServicioJpa;
    private final RepositorioTipoServicioJpa repositorioTipoServicioJpa;
    private final RepositorioEstadoServicioJpa repositorioEstadoServicioJpa;
    private final RepositorioUbicacionJpa repositorioUbicacionJpa;
    private final RepositorioDestinoJpa repositorioDestinoJpa;
    private final RepositorioMonedaServicioJpa repositorioMonedaServicioJpa;
    private final RepositorioDelimitacionServicioJpa repositorioDelimitacionServicioJpa;
    private final RepositorioViaServicioJpa repositorioViaServicioJpa;


    public RepositorioServicio(RepositorioServicioJpa repositorioServicioJpa, RepositorioSolicitanteServicioJpa repositorioSolicitanteServicioJpa, RepositorioTipoServicioJpa repositorioTipoServicioJpa, RepositorioEstadoServicioJpa repositorioEstadoServicioJpa, RepositorioUbicacionJpa repositorioUbicacionJpa, RepositorioDestinoJpa repositorioDestinoJpa, RepositorioMonedaServicioJpa repositorioMonedaServicioJpa, RepositorioDelimitacionServicioJpa repositorioDelimitacionServicioJpa, RepositorioViaServicioJpa repositorioViaServicioJpa) {
        this.repositorioServicioJpa = repositorioServicioJpa;
        this.repositorioSolicitanteServicioJpa = repositorioSolicitanteServicioJpa;
        this.repositorioTipoServicioJpa = repositorioTipoServicioJpa;
        this.repositorioEstadoServicioJpa = repositorioEstadoServicioJpa;
        this.repositorioUbicacionJpa = repositorioUbicacionJpa;
        this.repositorioDestinoJpa = repositorioDestinoJpa;
        this.repositorioMonedaServicioJpa = repositorioMonedaServicioJpa;
        this.repositorioDelimitacionServicioJpa = repositorioDelimitacionServicioJpa;
        this.repositorioViaServicioJpa = repositorioViaServicioJpa;
    }

    @Override
    public UUID registrarInformacionServicio(Servicio servicio) {
        EntidadSolicitanteServicio entidadSolicitanteServicio = this.repositorioSolicitanteServicioJpa.findByNumeroIdentificacion(servicio.getSolicitanteServicio().getNumeroIdentificacion());
        EntidadTipoServicio entidadTipoServicio = this.repositorioTipoServicioJpa.findByNombre(servicio.getTipoServicio().getNombre());
        EntidadEstadoServicio entidadEstadoServicio = this.repositorioEstadoServicioJpa.findByNombre(servicio.getEstadoServicio().getNombre());
        EntidadUbicacion entidadUbicacion = this.repositorioUbicacionJpa.findByLatitudAndLongitud(servicio.getUbicacion().getLatitud(), servicio.getUbicacion().getLongitud());
        EntidadUbicacion entidadUbicacionDestino = this.repositorioUbicacionJpa.findByLatitudAndLongitud(servicio.getDestino().getUbicacion().getLatitud(), servicio.getDestino().getUbicacion().getLongitud());
        EntidadDestino entidadDestino = this.repositorioDestinoJpa.findByByUbicacion(entidadUbicacionDestino.getIdentificador());
        EntidadMonedaServicio entidadMonedaServicio = this.repositorioMonedaServicioJpa.findByNombre(servicio.getMonedaServicio().getNombre());

        EntidadServicio entidadServicio = new EntidadServicio(servicio.getDescripcion(), entidadSolicitanteServicio, entidadTipoServicio,
                entidadEstadoServicio, entidadUbicacion, entidadDestino, servicio.getCostoInicialSolicitante(), entidadMonedaServicio, servicio.getFechaCreacion());

        entidadServicio.setIdentificador(servicio.getIdentificador());
        return this.repositorioServicioJpa.save(entidadServicio).getIdentificador();
    }

    @Override
    public void actualizarInformacionServicio(ServicioActualizacionDto dto, UUID idServcio) {
        EntidadServicio entidadServicio = this.repositorioServicioJpa.findById(idServcio).orElse(null);
        EntidadTipoServicio entidadTipoServicio = this.repositorioTipoServicioJpa.findByNombre(dto.getTipoServicio());
        EntidadMonedaServicio entidadMonedaServicio = this.repositorioMonedaServicioJpa.findByNombre(dto.getMoneda());
        EntidadUbicacion entidadUbicacion = this.repositorioUbicacionJpa.findById(dto.getUbicacion()).orElse(null);
        EntidadDestino entidadDestino = this.repositorioDestinoJpa.findById(dto.getDestino()).orElse(null);
        if (entidadServicio != null && Objects.equals(entidadServicio.getEntidadEstadoServicio().getNombre(), "Borrador")){
            entidadServicio.setDescripcion(dto.getDescripcion());
            entidadServicio.setEntidadTipoServicio(entidadTipoServicio);
            entidadServicio.setUbicacion(entidadUbicacion);
            entidadServicio.setDestino(entidadDestino);
            entidadServicio.setCostoInicialSolicitante(dto.getCostoInicial());
            entidadServicio.setMonedaServicio(entidadMonedaServicio);
            this.repositorioServicioJpa.save(entidadServicio);
        }

         throw new IllegalArgumentException("El servicio ya se encuentra en proceso, no se puede actualizar");
    }


    @Override
    public void eliminarInformacionServicio(UUID identificador) {

    }

    @Override
    public void eliminarLogicamenteInformacionServicio(EstadoServicio estadoServicio, UUID idServicio) {
        EntidadServicio entidadServicio = this.repositorioServicioJpa.findById(idServicio).orElse(null);
        EntidadEstadoServicio entidadEstadoServicio = this.repositorioEstadoServicioJpa.findByNombre(estadoServicio.getNombre());
        if(entidadServicio != null){
            entidadServicio.setEntidadEstadoServicio(entidadEstadoServicio);
            this.repositorioServicioJpa.save(entidadServicio);
        }
    }

    @Override
    public EstadoServicio consultarEstadoServicio(UUID identificador) {
        EntidadServicio entidadServicio = this.repositorioServicioJpa.findById(identificador).orElse(null);
        if(entidadServicio == null){
            return null;
        }
        return EstadoServicio.nuevoEstadoServicioConIdentificador(
                entidadServicio.getEntidadEstadoServicio().getIdentificador(),
                entidadServicio.getEntidadEstadoServicio().getDescripcion(),
                entidadServicio.getEntidadEstadoServicio().getNombre());
    }

    @Override
    public List<ServicioDto> consultarInformacionServicios(UUID identificador) {
        return this.repositorioServicioJpa.consultarServiciosMenosLosEliminados(identificador).stream().map(
                entidad -> new ServicioDto(
                        entidad.getIdentificador(),
                        entidad.getDescripcion(),
                        entidad.getEntidadSolicitanteServicio().getNombreSolicitante(),
                        entidad.getEntidadSolicitanteServicio().getNumeroIdentificacion(),
                        entidad.getEntidadTipoServicio().getNombre(),
                        entidad.getEntidadEstadoServicio().getNombre(),
                        entidad.getUbicacion().getIdentificador(),
                        entidad.getUbicacion().getLatitud(),
                        entidad.getUbicacion().getLongitud(),
                        entidad.getDestino().getIdentificador(),
                        entidad.getDestino().getNombreDestinatario(),
                        entidad.getDestino().getNumeroIdentificacion(),
                        entidad.getDestino().getEntidadUbicacion().getLatitud(),
                        entidad.getDestino().getEntidadUbicacion().getLongitud(),
                        entidad.getCostoInicialSolicitante(),
                        entidad.getMonedaServicio().getNombre(),
                        entidad.getFechaCreacion())).collect(Collectors.toList());
    }
    @Override
    public void realizarSeguimientoServicio(UbicacionServicio ubicacion) {

    }

    @Override
    public void actualizarEstadosDelServicio(EstadoServicio estadoServicio, UUID identificador) {
        EntidadServicio entidadServicio = this.repositorioServicioJpa.findById(identificador).orElse(null);
        EntidadEstadoServicio entidadEstadoServicio = this.repositorioEstadoServicioJpa.findByNombre(estadoServicio.getNombre());
        if(entidadServicio != null){
            entidadServicio.setEntidadEstadoServicio(entidadEstadoServicio);
            this.repositorioServicioJpa.save(entidadServicio);
        }
    }

    @Override
    public Servicio asociarServcioAOferta(UUID identificador) {
        EntidadServicio entidadServicio = this.repositorioServicioJpa.findById(identificador).orElse(null);

        EntidadSolicitanteServicio entidadSolicitanteServicio = this.repositorioSolicitanteServicioJpa.findByNumeroIdentificacion(entidadServicio.getEntidadSolicitanteServicio().getNumeroIdentificacion());
        SolicitanteServicio solicitanteServicio = SolicitanteServicio.nuevoSolicitanteServicioConIdentificador(entidadSolicitanteServicio.getIdentificador(),
                entidadSolicitanteServicio.getNumeroIdentificacion(), entidadSolicitanteServicio.getNombreSolicitante(),
                entidadSolicitanteServicio.getNombreUsuario(), entidadSolicitanteServicio.getTelefonoSolicitante(),
                entidadSolicitanteServicio.getNombreIdentificacion(), entidadSolicitanteServicio.getTipoIdentificacion(), entidadSolicitanteServicio.getCodigoIdentificador());

        EntidadTipoServicio entidadTipoServicio = this.repositorioTipoServicioJpa.findByNombre(entidadServicio.getEntidadTipoServicio().getNombre());
        TipoServicio tipoServicio = TipoServicio.nuevoTipoServicioConIdentificador(
                entidadTipoServicio.getIdentificador(), entidadTipoServicio.getDescripcion(), entidadTipoServicio.getNombre());

        EntidadEstadoServicio entidadEstadoServicio = this.repositorioEstadoServicioJpa.findByNombre(entidadServicio.getEntidadEstadoServicio().getNombre());
        EstadoServicio estadoServicio = EstadoServicio.nuevoEstadoServicioConIdentificador(
                entidadEstadoServicio.getIdentificador(), entidadEstadoServicio.getDescripcion(), entidadEstadoServicio.getNombre());

        EntidadUbicacion entidadUbicacion = this.repositorioUbicacionJpa.findByLatitudAndLongitud(entidadServicio.getUbicacion().getLatitud(), entidadServicio.getUbicacion().getLongitud());
        //Prueba
        UbicacionServicio ubicacionServicio = mapeador(entidadUbicacion);

        EntidadDestino entidadDestino = this.repositorioDestinoJpa.findById(entidadServicio.getDestino().getIdentificador()).orElse(null);
        //Prueba
        assert entidadDestino != null;
        UbicacionServicio ubicacionServicioDestino = mapeador(entidadDestino.getEntidadUbicacion());
        DestinoServicio destinoServicio = DestinoServicio.nuevoDestinoConIdentificador(entidadDestino.getIdentificador(), entidadDestino.getNombreDestinatario(), entidadDestino.getNumeroIdentificacion(), ubicacionServicioDestino);

        EntidadMonedaServicio entidadMonedaServicio = this.repositorioMonedaServicioJpa.findByNombre(entidadServicio.getMonedaServicio().getNombre());
        MonedaServicio monedaServicio = MonedaServicio.nuevaMonedaServcioConIdentificador(
                entidadMonedaServicio.getIdentificador(), entidadMonedaServicio.getDescripcion(),
                entidadMonedaServicio.getNombre());

        return Servicio.nuevoServicioConIdentifiacdor(entidadServicio.getIdentificador(), entidadServicio.getDescripcion(), solicitanteServicio, tipoServicio,
                estadoServicio, ubicacionServicio, destinoServicio, entidadServicio.getCostoInicialSolicitante(), monedaServicio, entidadServicio.getFechaCreacion());
    }

    private UbicacionServicio mapeador(EntidadUbicacion entidad){
        EntidadDelimitacionServicio entidadDelimitacionServicio = this.repositorioDelimitacionServicioJpa.findById(entidad.getEntidadDelimitacionServicio().getIdentificador()).orElse(null);
        assert entidadDelimitacionServicio != null;
        DelimitacionServicio delimitacionServicio = DelimitacionServicio.nuevaDelimitacionConIdentificador(
                entidadDelimitacionServicio.getIdentificador(), entidadDelimitacionServicio.getNombreCorregimiento(),
                entidadDelimitacionServicio.getNombreCiudad(), entidadDelimitacionServicio.getIdentificacionCiudad(), entidadDelimitacionServicio.getNombreDepartamento(), entidadDelimitacionServicio.getIdentificacionDepartamento(),
                entidadDelimitacionServicio.getIdentificacionPais(), entidadDelimitacionServicio.getNombrePais());
        EntidadViaServicio entidadViaServicio = this.repositorioViaServicioJpa.findByNombre(entidad.getEntidadViaServicio().getNombre());
        ViaServicio viaServicio = ViaServicio.nuevaViaConIdentificador(
                entidadViaServicio.getIdentificador(), entidadViaServicio.getNombre());

        return UbicacionServicio.nuevaUbicacionServcioConIdentificador(
                entidad.getIdentificador(), entidad.getNumeroVia(), entidad.getDireccion(),
                entidad.getLatitud(), entidad.getLongitud(), entidad.getDetalleAdicional(),
                delimitacionServicio, viaServicio);
    }
}
