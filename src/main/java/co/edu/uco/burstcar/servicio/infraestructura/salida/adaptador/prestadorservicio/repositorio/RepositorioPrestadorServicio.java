package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.prestadorservicio.repositorio;

import co.edu.uco.burstcar.servicio.dominio.modelo.PrestadorServicio;
import co.edu.uco.burstcar.servicio.dominio.modelo.SolicitanteServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.prestadorservicio.entidad.EntidadPrestadorServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.prestadorservicio.repositorio.jpa.RepositorioPrestadorServicioJpa;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPrestadorServicio implements co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioPrestadorServicio {

    private final RepositorioPrestadorServicioJpa repositorioPrestadorServicioJpa;

    public RepositorioPrestadorServicio(RepositorioPrestadorServicioJpa repositorioPrestadorServicioJpa) {
        this.repositorioPrestadorServicioJpa = repositorioPrestadorServicioJpa;
    }

    @Override
    public PrestadorServicio asociarSolicitanteServicio(String numeroIdentificacion) {
        EntidadPrestadorServicio entidadPrestadorServicio = this.repositorioPrestadorServicioJpa.findByNumeroIdentificacion(numeroIdentificacion);
        if(entidadPrestadorServicio ==null){
            return null;
        }
        return  PrestadorServicio.nuevoPrestadorServicioConIdentificador(
                entidadPrestadorServicio.getIdentificador(),
                entidadPrestadorServicio.getNumeroIdentificacion(), entidadPrestadorServicio.getNombrePrestador(),
                entidadPrestadorServicio.getNombreUsuario(), entidadPrestadorServicio.getTelefonoPrestador(), entidadPrestadorServicio.getUbicacionIdentificador(),
                entidadPrestadorServicio.getLatitudPrestador(), entidadPrestadorServicio.getLongitudPrestador(), entidadPrestadorServicio.getNombreIdentificacion(),
                entidadPrestadorServicio.getTipoIdentificacion(), entidadPrestadorServicio.getCodigoIdentificador());
    }

    @Override
    public void registrarSolicitante(PrestadorServicio prestadorServicio) {
        EntidadPrestadorServicio entidadPrestadorServicio = new EntidadPrestadorServicio(
                prestadorServicio.getIdentificacionPrestador(), prestadorServicio.getNombrePrestador(), prestadorServicio.getNombreUsuario(),
                prestadorServicio.getTelefonoPrestador(), prestadorServicio.getUbicacionIdentificador(), prestadorServicio.getLatitudPrestador(),
                prestadorServicio.getLongitudPrestador(), prestadorServicio.getNombreIdentificacion(), prestadorServicio.getTipoIdentificacion(),
                prestadorServicio.getCodigoIdentificador());
        entidadPrestadorServicio.setIdentificador(prestadorServicio.getIdentificador());
        this.repositorioPrestadorServicioJpa.save(entidadPrestadorServicio);
    }
}
