package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.prestadorservicio.repositorio.jpa;

import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.prestadorservicio.entidad.EntidadPrestadorServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositorioPrestadorServicioJpa extends JpaRepository<EntidadPrestadorServicio, UUID> {

    EntidadPrestadorServicio findByNumeroIdentificacion(String numeroIdentificacion);
}
