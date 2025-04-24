package co.edu.uco.burstcar.servicio.dominio.puerto;

import co.edu.uco.burstcar.servicio.dominio.dto.PaginaDto;
import co.edu.uco.burstcar.servicio.dominio.dto.ServicioActualizacionDto;
import co.edu.uco.burstcar.servicio.dominio.dto.ServicioDto;
import co.edu.uco.burstcar.servicio.dominio.modelo.EstadoServicio;
import co.edu.uco.burstcar.servicio.dominio.modelo.Servicio;
import co.edu.uco.burstcar.servicio.dominio.modelo.UbicacionServicio;

import java.util.List;
import java.util.UUID;

public interface RepositorioServicio {

    UUID registrarInformacionServicio(Servicio servicio);
    void actualizarInformacionServicio(ServicioActualizacionDto dto, UUID idServcio);
    void eliminarInformacionServicio(UUID identificador);
    void eliminarLogicamenteInformacionServicio(EstadoServicio estadoServicio, UUID idServicio);
    EstadoServicio consultarEstadoServicio(UUID identificador);
    PaginaDto<ServicioDto> consultarInformacionServicios(UUID identificador, int pagina, int cantidad);
    void realizarSeguimientoServicio(UbicacionServicio ubicacion);
    void actualizarEstadosDelServicio(EstadoServicio estadoServicio, UUID identificador);
    Servicio asociarServcioAOferta(UUID identificador);
}
