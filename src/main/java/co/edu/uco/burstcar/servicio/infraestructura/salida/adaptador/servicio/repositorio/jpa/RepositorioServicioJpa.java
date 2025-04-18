package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.servicio.repositorio.jpa;

import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.servicio.entidad.EntidadServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface RepositorioServicioJpa extends JpaRepository<EntidadServicio, UUID> {

    @Query(value = "Select * From servicio.servicio Where estado_servicio_id != :estadoId", nativeQuery = true)
    List<EntidadServicio> consultarServiciosMenosLosEliminados(@Param("estadoId") UUID estadoId);

}
