package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.destino.comando;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.destino.comando.dto.DestinoDto;
import co.edu.uco.burstcar.servicio.aplicacion.mapeador.destino.impl.MapeadorDestinoAplicacion;
import co.edu.uco.burstcar.servicio.dominio.servicio.destino.ServicioRegistrarDestino;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CasoDeUsoRegistrarDestino {
    private final ServicioRegistrarDestino servicioRegistrarDestino;
    private final MapeadorDestinoAplicacion mapeadorDestinoAplicacion;

    public CasoDeUsoRegistrarDestino(ServicioRegistrarDestino servicioRegistrarDestino, MapeadorDestinoAplicacion mapeadorDestinoAplicacion) {
        this.servicioRegistrarDestino = servicioRegistrarDestino;
        this.mapeadorDestinoAplicacion = mapeadorDestinoAplicacion;
    }


    public UUID ejecutarRegistro(DestinoDto dto) {
        return this.servicioRegistrarDestino.ejecutarRegistro(
                this.mapeadorDestinoAplicacion.aDominio(dto));
    }
}