package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.solicitanteservicio.repositorio.jpa;

import java.util.UUID;

import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.solicitanteservicio.entidad.EntidadSolicitanteServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioSolicitanteServicioJpa extends JpaRepository<EntidadSolicitanteServicio, UUID> {

    EntidadSolicitanteServicio findByNumeroIdentificacion(String numeroIdentificacion);
}
