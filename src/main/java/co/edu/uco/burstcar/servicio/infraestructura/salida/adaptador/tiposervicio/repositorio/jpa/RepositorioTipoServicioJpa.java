package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.tiposervicio.repositorio.jpa;

import java.util.UUID;

import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.tiposervicio.entidad.EntidadTipoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTipoServicioJpa extends JpaRepository<EntidadTipoServicio, UUID> {

    EntidadTipoServicio findByNombre(String nombre);
}
