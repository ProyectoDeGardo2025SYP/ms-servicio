package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.estadoservicio.repositorio.jpa;

import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.estadoservicio.entidad.EntidadEstadoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositorioEstadoServicioJpa extends JpaRepository<EntidadEstadoServicio, UUID> {

    EntidadEstadoServicio findByNombre(String nombre);

}
