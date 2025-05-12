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

    @Query(value = """
    SELECT s.*
    FROM servicio.servicio s
    JOIN servicio.ubicacion u ON s.ubicacion_servicio_id = u.identificador
    WHERE s.estado_servicio_id NOT IN (
      '95674536-47ba-43af-8161-f329df3a04e5',
      '95674536-47ba-43af-8161-f329df3a04e7',
      '95674536-47ba-43af-8161-f329df3a04e8',
      '95674536-47ba-43af-8161-f329df3a04e9'
    )
    AND (
      6371 * acos(
        cos(radians(:latitud)) * cos(radians(u.latitud)) *
        cos(radians(u.longitud) - radians(:longitud)) +
        sin(radians(:latitud)) * sin(radians(u.latitud))
      )
    ) <= :radioKm
    """,
            countQuery = """
    SELECT count(*)
    FROM servicio.servicio s
    JOIN servicio.ubicacion u ON s.ubicacion_servicio_id = u.identificador
    WHERE s.estado_servicio_id NOT IN (
      '95674536-47ba-43af-8161-f329df3a04e5',
      '95674536-47ba-43af-8161-f329df3a04e7',
      '95674536-47ba-43af-8161-f329df3a04e8',
      '95674536-47ba-43af-8161-f329df3a04e9'
    )
    AND (
      6371 * acos(
        cos(radians(:latitud)) * cos(radians(u.latitud)) *
        cos(radians(u.longitud) - radians(:longitud)) +
        sin(radians(:latitud)) * sin(radians(u.latitud))
      )
    ) <= :radioKm
    """,
            nativeQuery = true
    )
    Page<EntidadServicio> consultarServiciosParaPrestadorConFiltroGeografico(
            @Param("latitud") double latitud,
            @Param("longitud") double longitud,
            @Param("radioKm") double radioKm,
            Pageable pageable
    );

    @Query(value = "Select * From servicio.servicio Where estado_servicio_id != '95674536-47ba-43af-8161-f329df3a04e7' and " +
            "solicitante_servicio_id = :idSolicitante",
            countQuery = "Select COUNT(*) From servicio.servicio Where estado_servicio_id != '95674536-47ba-43af-8161-f329df3a04e7'",
            nativeQuery = true)
    Page<EntidadServicio> consultarServiciosMenosLosEliminadosPorSolicitante(@Param("idSolicitante") UUID solicitante,
                                                                             Pageable pageable);

}
