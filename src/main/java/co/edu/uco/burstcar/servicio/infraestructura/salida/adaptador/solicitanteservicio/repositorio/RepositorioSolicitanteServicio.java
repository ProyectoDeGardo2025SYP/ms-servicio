package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.solicitanteservicio.repositorio;

import co.edu.uco.burstcar.servicio.dominio.modelo.DelimitacionServicio;
import co.edu.uco.burstcar.servicio.dominio.modelo.SolicitanteServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.solicitanteservicio.entidad.EntidadSolicitanteServicio;
import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.solicitanteservicio.repositorio.jpa.RepositorioSolicitanteServicioJpa;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioSolicitanteServicio implements co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioSolicitanteServicio {

    private final RepositorioSolicitanteServicioJpa repositorioSolicitanteServicioJpa;

    public RepositorioSolicitanteServicio(RepositorioSolicitanteServicioJpa repositorioSolicitanteServicioJpa) {
        this.repositorioSolicitanteServicioJpa = repositorioSolicitanteServicioJpa;
    }

    @Override
    public SolicitanteServicio asociarSolicitanteServicio(String numeroIdentificacion) {
        EntidadSolicitanteServicio entidadSolicitanteServicio = this.repositorioSolicitanteServicioJpa.findByNumeroIdentificacion(numeroIdentificacion);
        if(entidadSolicitanteServicio ==null){
            return null;
        }
        return SolicitanteServicio.nuevoSolicitanteServicioConIdentificador(
                entidadSolicitanteServicio.getIdentificador(),
                entidadSolicitanteServicio.getNumeroIdentificacion(), entidadSolicitanteServicio.getNombreSolicitante(),
                entidadSolicitanteServicio.getNombreUsuario(), entidadSolicitanteServicio.getTelefonoSolicitante(), entidadSolicitanteServicio.getNombreIdentificacion(),
                entidadSolicitanteServicio.getTipoIdentificacion(), entidadSolicitanteServicio.getCodigoIdentificador());
    }

    @Override

    public void registrarSolicitante(SolicitanteServicio solicitanteServicio) {
        EntidadSolicitanteServicio entidadSolicitanteServicio = new EntidadSolicitanteServicio(
                solicitanteServicio.getNumeroIdentificacion(), solicitanteServicio.getNombreSolicitante(), solicitanteServicio.getNombreUsuario(),
                solicitanteServicio.getTelefonoSolicitante(), solicitanteServicio.getNombreIdentificacion(), solicitanteServicio.getTipoIdentificacion(),
                solicitanteServicio.getCodigoIdentificador());
        entidadSolicitanteServicio.setIdentificador(solicitanteServicio.getIdentificador());
        this.repositorioSolicitanteServicioJpa.save(entidadSolicitanteServicio);
    }
}
