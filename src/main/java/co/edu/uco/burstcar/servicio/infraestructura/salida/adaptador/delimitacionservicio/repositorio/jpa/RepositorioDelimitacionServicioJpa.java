package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.delimitacionservicio.repositorio.jpa;

import java.util.UUID;

import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.delimitacionservicio.entidad.EntidadDelimitacionServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDelimitacionServicioJpa extends JpaRepository<EntidadDelimitacionServicio, UUID> {

    @Query(value = "SELECT dp.identificador, dp.nombre_corregimiento, " +
            "dp.nombre_ciudad, " +
            "dp.identificacion_ciudad, " +
            "dp.nombre_departamento, " +
            "dp.identificacion_departamento, " +
            "dp.identificacion_pais, " +
            "dp.nombre_pais " +
            "FROM servicio.delimitacion_servicio dp WHERE " +
            "nombre_pais = :pais AND nombre_departamento = :departamento AND " +
            "nombre_ciudad = :ciudad AND nombre_corregimiento = :corregimiento", nativeQuery = true)
    EntidadDelimitacionServicio findDelimitacion(@Param("pais") String pais,
                                                  @Param("departamento") String departamento,
                                                  @Param("ciudad") String ciudad,
                                                  @Param("corregimiento") String corregimiento);
}
