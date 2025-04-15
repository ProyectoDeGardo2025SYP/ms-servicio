package co.edu.uco.burstcar.servicio.dominio.puerto;

import co.edu.uco.burstcar.servicio.dominio.dto.ServicioEmisorDto;

public interface RepositorioEmitirServicio {

    void emitirInformacionServicio(ServicioEmisorDto emisorDto);
}
