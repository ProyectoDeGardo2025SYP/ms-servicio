package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.viaservicio.repositorio.jpa;

import java.util.UUID;

import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.viaservicio.entidad.EntidadViaServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositorioViaServicioJpa extends JpaRepository<EntidadViaServicio, UUID> {

    EntidadViaServicio findByNombre(String nombre);

}
