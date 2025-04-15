package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.destino.repositorio.jpa;

import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.destino.entidad.EntidadDestino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositorioDestinoJpa extends JpaRepository<EntidadDestino, UUID> {

    @Query(value = "Select * from servicio.destino WHERE ubicacion_servicio_id = :ubicacion", nativeQuery = true)
    EntidadDestino findByByUbicacion(@Param("ubicacion") UUID ubicacion);
}
