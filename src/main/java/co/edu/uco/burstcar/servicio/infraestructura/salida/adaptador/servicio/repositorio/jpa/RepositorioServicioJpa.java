package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.servicio.repositorio.jpa;

import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.servicio.entidad.EntidadServicio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface RepositorioServicioJpa extends JpaRepository<EntidadServicio, UUID> {

    @Query(value = "Select * From servicio.servicio Where estado_servicio_id != :estadoId",
           countQuery = "Select COUNT(*) From servicio.servicio Where estado_servicio_id != :estadoId",
            nativeQuery = true)
    Page<EntidadServicio> consultarServiciosMenosLosEliminados(@Param("estadoId") UUID estadoId, Pageable pageable);

    @Query(value = "Select * From servicio.servicio Where estado_servicio_id != :estadoId and " +
            "solicitante_servicio_id = :idSolicitante",
            countQuery = "Select COUNT(*) From servicio.servicio Where estado_servicio_id != :estadoId",
            nativeQuery = true)
    Page<EntidadServicio> consultarServiciosMenosLosEliminadosPorSolicitante(@Param("estadoId") UUID estadoId,
                                                                             @Param("idSolicitante") UUID solicitante,
                                                                             Pageable pageable);

}
