package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.oferta.repositorio.jpa;

import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.oferta.entidad.EntidadOferta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RepositorioOfertaJpa extends JpaRepository<EntidadOferta, UUID> {

    @Query(value = "Select * From servicio.oferta Where servicio_id = :servicio_id",
            countQuery = "Select COUNT(*) From servicio.oferta Where servicio_id != :servicio_id",
            nativeQuery = true)
    Page<EntidadOferta> obtenerOfertasDeUnServicio(@Param("servicio_id") UUID servicio_id, Pageable pageable);

    @Query(value = "Select * From servicio.oferta Where servicio_id = :servicio_id and " +
            "prestador_servicio_id = :prestadorId",
            countQuery = "Select COUNT(*) From servicio.oferta Where servicio_id != :servicio_id",
            nativeQuery = true)
    Page<EntidadOferta> obtenerOfertasDeUnServicioPorPrestador(@Param("servicio_id") UUID servicio_id,
                                                               @Param("prestadorId") UUID prestadorId,
                                                               Pageable pageable);
}
