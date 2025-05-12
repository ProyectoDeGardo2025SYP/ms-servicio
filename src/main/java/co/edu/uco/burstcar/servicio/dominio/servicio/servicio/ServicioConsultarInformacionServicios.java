package co.edu.uco.burstcar.servicio.dominio.servicio.servicio;

import co.edu.uco.burstcar.servicio.dominio.dto.PaginaDto;
import co.edu.uco.burstcar.servicio.dominio.dto.ServicioDto;
import co.edu.uco.burstcar.servicio.dominio.puerto.RepositorioServicio;

import java.util.UUID;

public class ServicioConsultarInformacionServicios {
    private final RepositorioServicio repositorioServicio;


    public ServicioConsultarInformacionServicios(RepositorioServicio repositorioServicio) {
        this.repositorioServicio = repositorioServicio;
    }

    public PaginaDto<ServicioDto> ejecutarConsulta(Double latitud, Double longitud, int pagina, int cantidad){
        return this.repositorioServicio.consultarInformacionServicios(
                latitud, longitud, pagina, cantidad);
    }
}
