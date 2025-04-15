package co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.monedaservicio.repositorio.jpa;

import java.util.UUID;

import co.edu.uco.burstcar.servicio.infraestructura.salida.adaptador.monedaservicio.entidad.EntidadMonedaServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioMonedaServicioJpa extends JpaRepository<EntidadMonedaServicio, UUID> {
    EntidadMonedaServicio findByNombre(String nombre);

}
