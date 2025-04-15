package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.ubicacion.repositorio.jpa;

import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.ubicacion.entidad.EntidadUbicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositorioUbicacionJpa extends JpaRepository<EntidadUbicacion, UUID> {

    @Query(value = "Select * from servicio.ubicacion WHERE latitud = :latitud AND " +
            "longitud = :longitud", nativeQuery = true)
    EntidadUbicacion findByLatitudAndLongitud(@Param("latitud") Double latitud, @Param("longitud") Double longitud);
}
