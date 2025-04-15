package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.solicitanteservicio.comando;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.solicitanteservicio.comando.dto.SolicitanteDto;
import co.edu.uco.burstcar.servicio.aplicacion.mapeador.solicitanteservicio.impl.MapeadorSolicitanteAplicacion;
import co.edu.uco.burstcar.servicio.dominio.servicio.solicitanteservicio.ServicioRegistrarSolicitante;
import org.springframework.stereotype.Component;

@Component
public class CasoDeUsoRegistrarSolicitante {
    private final ServicioRegistrarSolicitante servicioRegistrarSolicitante;
    private final MapeadorSolicitanteAplicacion mapeadorSolicitanteAplicacion;

    public CasoDeUsoRegistrarSolicitante(ServicioRegistrarSolicitante servicioRegistrarSolicitante, MapeadorSolicitanteAplicacion mapeadorSolicitanteAplicacion) {
        this.servicioRegistrarSolicitante = servicioRegistrarSolicitante;
        this.mapeadorSolicitanteAplicacion = mapeadorSolicitanteAplicacion;
    }

    public void ejecutarRegistro(SolicitanteDto dto) {
        this.servicioRegistrarSolicitante.ejecutarRegistro
                (this.mapeadorSolicitanteAplicacion.aDominio(dto));
    }
}