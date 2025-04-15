package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.estadooferta.repositorio.jpa;

import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.estadooferta.entidad.EntidadEstadoOferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface RepositorioEstadoOfertaJpa extends JpaRepository<EntidadEstadoOferta, UUID> {

    EntidadEstadoOferta findByNombre(String nombre);

}
