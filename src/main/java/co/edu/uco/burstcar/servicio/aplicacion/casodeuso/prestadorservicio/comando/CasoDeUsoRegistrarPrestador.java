package co.edu.uco.burstcar.servicio.aplicacion.casodeuso.prestadorservicio.comando;

import co.edu.uco.burstcar.servicio.aplicacion.casodeuso.prestadorservicio.comando.dto.PrestadorDto;
import co.edu.uco.burstcar.servicio.aplicacion.mapeador.prestadorservicio.impl.MapeadorPrestadorAplicacion;
import co.edu.uco.burstcar.servicio.dominio.servicio.prestadorservicio.ServicioRegistrarPrestador;
import org.springframework.stereotype.Component;

@Component
public class CasoDeUsoRegistrarPrestador {
    private final ServicioRegistrarPrestador servicioRegistrarPrestador;
    private final MapeadorPrestadorAplicacion mapeadorPrestadorAplicacion;

    public CasoDeUsoRegistrarPrestador(ServicioRegistrarPrestador servicioRegistrarPrestador, MapeadorPrestadorAplicacion mapeadorPrestadorAplicacion) {
        this.servicioRegistrarPrestador = servicioRegistrarPrestador;
        this.mapeadorPrestadorAplicacion = mapeadorPrestadorAplicacion;
    }


    public void ejecutarRegistro(PrestadorDto dto) {
        this.servicioRegistrarPrestador.ejecutarRegistro
                (this.mapeadorPrestadorAplicacion.aDominio(dto));
    }
}